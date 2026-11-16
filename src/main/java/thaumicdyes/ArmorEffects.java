package thaumicdyes;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID)
public final class ArmorEffects {
    private static final EquipmentSlot[] SLOTS = {EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS};
    private ArmorEffects() {}

    private static boolean fortress(ItemStack stack) {
        String kind = GearStats.kind(stack);
        return kind.equals("ThaumiumFortressDyed") || kind.equals("IronFortressArmor");
    }
    @SubscribeEvent
    public static void protection(LivingDamageEvent.Pre event) {
        var source = event.getSource();
        boolean magic = source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC);
        boolean fire = source.is(DamageTypeTags.IS_FIRE) || source.is(DamageTypeTags.IS_EXPLOSION);
        boolean bypass = source.is(DamageTypeTags.BYPASSES_ARMOR);
        if (bypass && !magic) return;
        LivingEntity entity = event.getEntity();
        double set = 0.875;
        for (EquipmentSlot slot : SLOTS) {
            ItemStack stack = entity.getItemBySlot(slot);
            if (stack.getItem() instanceof thaumcraft.item.armor.FortressArmorItem) set += 0.125 + (GearData.mask(stack) >= 0 ? 0.05 : 0);
        }
        double vanilla = 0, desired = 0;
        for (EquipmentSlot slot : SLOTS) {
            ItemStack stack = entity.getItemBySlot(slot);
            if (!(stack.getItem() instanceof PortArmorItem item)) continue;
            String kind = GearStats.kind(stack);
            double defense = item.getDefense();
            if (fortress(stack)) {
                desired += defense / (magic && kind.equals("ThaumiumFortressDyed") ? 35.0 : fire ? 20.0 : 25.0) * set;
                vanilla += defense / 25.0;
            } else if (kind.equals("VoidRobeDyed") || kind.equals("ThaumiumRobeDyed")) {
                desired += defense / (magic ? 35.0 : 25.0);
                vanilla += defense / 25.0;
            }
        }
        // Use the same post-vanilla correction policy as Reforged's own armor; preserve modern damage/enchantment ordering.
        double extra = desired - (bypass ? 0 : vanilla);
        if (extra > 0) event.setNewDamage((float)(event.getNewDamage()*(1-Math.min(0.8,extra))));
    }
}
