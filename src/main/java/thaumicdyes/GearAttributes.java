package thaumicdyes;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID)
public final class GearAttributes {
    private GearAttributes() {}

    private static void add(ItemAttributeModifierEvent event, Holder<Attribute> attribute, String name, double value, EquipmentSlot slot) {
        event.addModifier(attribute, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(ThaumicDyes.MOD_ID,
            "runic_" + slot.getName() + "_" + name), value, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.bySlot(slot));
    }

    @SubscribeEvent
    public static void attributes(ItemAttributeModifierEvent event) {
        var stack = event.getItemStack();
        if (!(stack.getItem() instanceof PortArmorItem item) || GearStats.tier(stack) == 0) return;
        var slot = item.getEquipmentSlot();
        if (GearData.has(stack, 7)) add(event, Attributes.KNOCKBACK_RESISTANCE, "steadfast", 0.2, slot);
        if (GearData.has(stack, 8)) add(event, Attributes.MAX_HEALTH, "vitality", 10, slot);
        if (slot == EquipmentSlot.FEET && GearData.has(stack, 9)) add(event, Attributes.MOVEMENT_SPEED, "celerity", 0.03, slot);
        if (GearData.has(stack, 10)) add(event, Attributes.ATTACK_DAMAGE, "ravager", 2, slot);
        if (GearData.has(stack, 5)) {
            int tier = GearStats.tier(stack);
            if (tier == 1) add(event, Attributes.ARMOR, "hardened", item.getDefense(), slot);
            else if (tier == 2) add(event, Attributes.ARMOR, "hardened", 1, slot);
        }
    }
}
