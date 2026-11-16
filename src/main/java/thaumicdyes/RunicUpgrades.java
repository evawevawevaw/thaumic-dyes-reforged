package thaumicdyes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import thaumcraft.item.gear.RunicShield;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID)
public final class RunicUpgrades {
    private static final EquipmentSlot[] SLOTS = {EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET};
    private static final Map<UUID,State> STATES = new HashMap<>();
    private static final class State {
        final Map<Integer,Long> cooldowns = new HashMap<>();
        int ward;
        Boolean warped;
    }
    private RunicUpgrades() {}

    private static int count(Player player, int upgrade) {
        int count = 0;
        for (EquipmentSlot slot : SLOTS) {
            var stack = player.getItemBySlot(slot);
            for (int i=0; i<GearStats.tier(stack); i++) if (GearData.upgrade(stack,i)==upgrade) count++;
        }
        return count;
    }
    private static int capacity(Player player) {
        int value=0;
        boolean ownRunic=false;
        for (EquipmentSlot slot : SLOTS) {
            var stack=player.getItemBySlot(slot);
            ownRunic|=GearStats.tier(stack)>0;
            value+=thaumcraft.infusion.InfusionHooks.getFinalCharge(stack);
        }
        for (var stack:thaumcraft.platform.Baubles.stacks(player)) value+=thaumcraft.infusion.InfusionHooks.getFinalCharge(stack);
        return ownRunic ? value : 0;
    }
    private static boolean ready(State state, int key, long tick, int cooldown) {
        if (state.cooldowns.getOrDefault(key,0L)>tick) return false;
        state.cooldowns.put(key,tick+cooldown);
        return true;
    }
    private static void sound(ServerPlayer player,String path) {
        var sound=BuiltInRegistries.SOUND_EVENT.getOptional(ResourceLocation.fromNamespaceAndPath("thaumcraft",path)).orElse(SoundEvents.ENCHANTMENT_TABLE_USE);
        player.level().playSound(null,player.blockPosition(),sound,SoundSource.PLAYERS,1,1);
    }
    private static void ward(ServerPlayer player, State state, int value) {
        value=Math.max(0,Math.min(value,Math.max(0,capacity(player)-RunicShield.getCharge(player))));
        if (state.ward!=value) {
            state.ward=value;
            PacketDistributor.sendToPlayer(player,new PortNetwork.Ward(value));
        }
    }

    @SubscribeEvent(priority=EventPriority.LOWEST)
    public static void damage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player) || player instanceof FakePlayer || capacity(player)<=0) return;
        var source=event.getSource();
        if (source.is(DamageTypes.DROWN)||source.is(DamageTypes.WITHER)||source.is(DamageTypes.FELL_OUT_OF_WORLD)||source.is(DamageTypes.STARVE)) return;
        State state=STATES.computeIfAbsent(player.getUUID(),ignored->new State());
        if (state.ward>0 && event.getAmount()>0) {
            int absorbed=Math.min(state.ward,(int)Math.ceil(event.getAmount()));
            event.setAmount(Math.max(0,event.getAmount()-absorbed));
            ward(player,state,state.ward-absorbed);
        }
        if (RunicShield.getCharge(player)>0 || state.ward>0 || event.getOriginalAmount()<=0) return;
        long tick=player.level().getGameTime();
        int berserker=count(player,1),kinetic=count(player,3),healing=count(player,4),emergency=count(player,6);
        if (berserker>0 && ready(state,1,tick,400)) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,100*berserker,berserker));
            if (berserker>=4) player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,200+100*(berserker-4),berserker-4));
            sound(player,"runic_shield_effect");
        }
        if (kinetic>0 && ready(state,3,tick,600)) {
            player.level().explode(player,player.getX(),player.getY()+player.getBbHeight()/2,player.getZ(),1.5F+kinetic*0.5F,false,Level.ExplosionInteraction.NONE);
            sound(player,"shock");
        }
        if (healing>0 && ready(state,4,tick,600)) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,200,healing));
            sound(player,"runic_shield_effect");
        }
        if (emergency>0 && ready(state,6,tick,2400)) {
            // Core charge has no public setter. Keep the original 8-per-upgrade emergency protection in an add-on-owned pool.
            ward(player,state,8*emergency);
            sound(player,"runic_shield_charge");
        }
    }

    private static boolean warped(Player player) {
        for (EquipmentSlot slot:SLOTS) if (GearStats.tier(player.getItemBySlot(slot))!=3) return false;
        return BuiltInRegistries.ITEM.getOptional(ResourceLocation.parse("thaumcraft:primordial_pearl"))
            .map(item->player.getInventory().contains(new net.minecraft.world.item.ItemStack(item))).orElse(false);
    }
    @SubscribeEvent public static void name(PlayerEvent.NameFormat event) {
        if (warped(event.getEntity())) event.setDisplayname(Component.translatable("name.thaumicdyes.warped",event.getUsername()));
    }
    @SubscribeEvent public static void tick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        State state=STATES.computeIfAbsent(player.getUUID(),ignored->new State());
        ward(player,state,state.ward);
        if (player.getHealth()>player.getMaxHealth()) player.setHealth(player.getMaxHealth());
        if (player.tickCount%20==0) {
            boolean warped=warped(player);
            if (state.warped==null||state.warped!=warped) { state.warped=warped;player.refreshDisplayName(); }
        }
    }
    @SubscribeEvent public static void equipment(net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) RunicShield.markDirty(player);
    }
    @SubscribeEvent public static void clone(PlayerEvent.Clone event) {
        STATES.remove(event.getEntity().getUUID());
        PortNetwork.forget(event.getEntity().getUUID());
    }
    @SubscribeEvent public static void logout(PlayerEvent.PlayerLoggedOutEvent event) {
        STATES.remove(event.getEntity().getUUID());PortNetwork.forget(event.getEntity().getUUID());
    }
}
