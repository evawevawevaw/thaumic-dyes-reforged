package thaumicdyes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid=ThaumicDyes.MOD_ID)
public final class AncientMaskEffects {
    private static final double RANGE=24;
    private static final ResourceKey<DamageType> DAMAGE=ResourceKey.create(Registries.DAMAGE_TYPE,
        ResourceLocation.fromNamespaceAndPath(ThaumicDyes.MOD_ID,"wither_mask"));
    private static final Map<UUID,Aim> AIMS=new HashMap<>();
    private record Aim(int target,int ticks) {}
    private AncientMaskEffects() {}

    private static boolean wearing(ServerPlayer player) {
        return GearStats.kind(player.getItemBySlot(EquipmentSlot.HEAD)).equals("ItemTXAncientMask");
    }
    private static boolean allowed(ServerPlayer player,LivingEntity target) {
        return target!=player && target.isAlive() && target.isAttackable() && !target.isSpectator()
            && (!(target instanceof Player other) || player.server.isPvpAllowed() && player.canHarmPlayer(other));
    }
    private static boolean spend(ServerPlayer player) {
        if (!wearing(player)) return false;
        player.getItemBySlot(EquipmentSlot.HEAD).hurtAndBreak(1,player,EquipmentSlot.HEAD);
        return true;
    }
    private static LivingEntity ray(ServerPlayer player) {
        Vec3 start=player.getEyePosition(),direction=player.getLookAngle().scale(RANGE),end=start.add(direction);
        var block=player.level().clip(new ClipContext(start,end,ClipContext.Block.COLLIDER,ClipContext.Fluid.NONE,player));
        if (block.getType()!=HitResult.Type.MISS) end=block.getLocation();
        double distance=start.distanceToSqr(end);
        var hit=ProjectileUtil.getEntityHitResult(player,start,end,player.getBoundingBox().expandTowards(direction).inflate(1),
            entity->entity instanceof LivingEntity living && allowed(player,living),distance);
        return hit!=null && hit.getEntity() instanceof LivingEntity living ? living : null;
    }
    private static void beam(ServerPlayer player) {
        LivingEntity target=ray(player);
        if (target==null) { AIMS.remove(player.getUUID());return; }
        Aim previous=AIMS.get(player.getUUID());
        int ticks=previous!=null && previous.target()==target.getId() ? previous.ticks()+1 : 1;
        AIMS.put(player.getUUID(),new Aim(target.getId(),ticks%5));
        if (ticks%5!=0 || !spend(player)) return;
        // Only the server chooses the entity and applies damage; no target/dimension supplied by a client packet.
        var holder=player.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DAMAGE);
        target.hurt(new DamageSource(holder,player),1);
        PacketDistributor.sendToPlayersTrackingEntityAndSelf(player,new PortNetwork.Beam(player.getId(),target.getId()));
    }
    private static void gaze(ServerPlayer player) {
        Vec3 eye=player.getEyePosition(),look=player.getLookAngle();
        for (LivingEntity target:player.level().getEntitiesOfClass(LivingEntity.class,player.getBoundingBox().inflate(RANGE),entity->allowed(player,entity))) {
            Vec3 offset=target.getEyePosition().subtract(eye);
            double distance=offset.length();
            // Native look-cone/LOS replaces the unavailable legacy EntityUtils helper.
            if (distance>RANGE || distance>0 && look.dot(offset.scale(1/distance))<=1-0.75/distance || !player.hasLineOfSight(target)) continue;
            if (!spend(player)) break;
            target.setLastHurtByMob(player);
            target.setLastHurtByPlayer(player);
            if (target instanceof PathfinderMob mob) mob.setTarget(player);
            int choice=player.getRandom().nextInt(3);
            target.addEffect(switch(choice) {
                case 0 -> new MobEffectInstance(MobEffects.WEAKNESS,100,6);
                case 1 -> new MobEffectInstance(MobEffects.WITHER,100,1);
                default -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100,3);
            });
        }
    }
    @SubscribeEvent public static void tick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!wearing(player) || player.isSpectator() || !player.isAlive()) { AIMS.remove(player.getUUID());return; }
        beam(player);
        if (player.tickCount%20==0 && wearing(player)) gaze(player);
    }
    @SubscribeEvent public static void logout(PlayerEvent.PlayerLoggedOutEvent event) { AIMS.remove(event.getEntity().getUUID()); }
}
