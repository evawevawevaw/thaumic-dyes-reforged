package thaumicdyes;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public final class PortArmorItem extends ArmorItem implements
        thaumcraft.item.gear.RunicArmor, thaumcraft.item.gear.WarpingGear,
        thaumcraft.item.gear.Goggles, thaumcraft.node.Revealer,
        thaumcraft.wand.VisDiscountGear, thaumcraft.item.gear.RepairableExtended {
    private final boolean dyeable;
    private final boolean runic;
    private final boolean selfRepair;
    private final TagKey<Item> repair;

    public PortArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties,
                         boolean dyeable, boolean runic, boolean selfRepair, String repair) {
        super(material, type, properties);
        this.dyeable = dyeable;
        this.runic = runic;
        this.selfRepair = selfRepair;
        this.repair = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(
            ThaumicDyes.MOD_ID, "repairs_" + repair));
    }

    public boolean dyeable() {
        return dyeable;
    }

    @Override
    public ResourceLocation getArmorTexture(ItemStack stack, Entity entity,
            net.minecraft.world.entity.EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        Appearance.Skin skin = Appearance.of(stack);
        if (skin == null) {
            return null;
        }
        if (skin.model().equals("RobesSpecial")) {
            boolean hardened = GearData.has(stack, 5);
            String variant = "";
            if (entity instanceof net.minecraft.world.entity.player.Player player && carries(player, "eldritch_eye")) {
                variant = carries(player, "primordial_pearl") ? "_warden" : "1";
            }
            // The original UUID branch used String == and referenced a missing PNG; it is not reproduced.
            return ResourceLocation.fromNamespaceAndPath(ThaumicDyes.MOD_ID,
                "textures/models/guardian_robe_armor" + variant + (hardened ? "" : "_t") + ".png");
        }
        return ResourceLocation.parse(layer.dyeable() ? skin.main() : skin.overlay());
    }

    private static boolean carries(net.minecraft.world.entity.player.Player player, String path) {
        var id = ResourceLocation.fromNamespaceAndPath("thaumcraft", path);
        return net.minecraft.core.registries.BuiltInRegistries.ITEM.getOptional(id)
            .map(item -> player.getInventory().contains(new ItemStack(item))).orElse(false);
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
        return !runic && ingredient.is(repair);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return runic ? GearStats.tier(stack) == 3 && GearData.has(stack, 5) : super.isEnchantable(stack);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return !runic || GearStats.tier(stack) == 3 && GearData.has(stack, 5);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
        if (!level.isClientSide()) {
            GearData.migrate(stack);
            if (GearStats.tier(stack) == 3 && !GearData.has(stack, 5) && stack.isEnchanted()) {
                stack.remove(net.minecraft.core.component.DataComponents.ENCHANTMENTS);
            }
        }
        // Preserve the original worn-only void repair, without TC internal ArmorSupport calls.
        if (selfRepair && !level.isClientSide() && entity.tickCount % 20 == 0
                && entity instanceof LivingEntity living
                && living.getItemBySlot(getEquipmentSlot()) == stack && stack.isDamaged()) {
            stack.setDamageValue(Math.max(0, stack.getDamageValue() - 1));
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);
        int discount = getVisDiscount(stack, null, null);
        if (discount > 0) lines.add(Component.translatable("tc.visdiscount").append(": " + discount + "%").withStyle(ChatFormatting.DARK_PURPLE));
        if (getRunicCharge(stack) > 0) lines.add(Component.translatable("tooltip.thaumicdyes.capacity", getRunicCharge(stack)).withStyle(ChatFormatting.AQUA));
        if (GearData.goggles(stack)) lines.add(Component.translatable("item.thaumcraft.goggles_of_revealing").withStyle(ChatFormatting.DARK_PURPLE));
        int mask = GearData.mask(stack);
        if (mask >= 0) {
            String prefix = GearStats.kind(stack).equals("IronFortressArmor") ? "item.HelmetIronFortress.mask."
                : GearStats.kind(stack).contains("Ranger") ? "item.HelmetCultistRanger.mask." : "item.HelmetFortress.mask.";
            lines.add(Component.translatable(prefix + mask).withStyle(ChatFormatting.GOLD));
        }
        int[] upgrades = {GearData.upgrade(stack, 0), GearData.upgrade(stack, 1), GearData.upgrade(stack, 2)};
        for (int index = 0; index < upgrades.length; index++) {
            if (upgrades[index] != 0) {
                lines.add(Component.translatable("item.runic.upgrade." + upgrades[index])
                    .withStyle(ChatFormatting.DARK_AQUA));
            }
        }
    }
    @Override public int getRunicCharge(ItemStack stack) { return GearStats.capacity(stack, getEquipmentSlot()); }
    @Override public int getVisDiscount(ItemStack stack, net.minecraft.world.entity.player.Player player, thaumcraft.aspect.Aspect aspect) {
        return GearStats.discount(stack, getEquipmentSlot());
    }
    @Override public int getWarp(ItemStack stack, net.minecraft.world.entity.player.Player player) {
        return GearStats.warp(stack);
    }
    @Override public boolean showNodes(ItemStack stack, LivingEntity entity) { return GearStats.reveals(stack, getEquipmentSlot()); }
    @Override public boolean showIngamePopups(ItemStack stack, LivingEntity entity) { return showNodes(stack, entity); }
    @Override public boolean doRepair(ItemStack stack, net.minecraft.world.entity.player.Player player, int level) { return !runic; }

    @Override
    public net.minecraft.world.InteractionResult useOn(net.minecraft.world.item.context.UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        int slots = GearStats.tier(stack);
        if (slots < 2) return super.useOn(context);
        if (!context.getLevel().isClientSide()) {
            GearData.rotate(stack, slots);
            if (context.getPlayer() != null) thaumcraft.item.gear.RunicShield.markDirty(context.getPlayer());
        }
        return net.minecraft.world.InteractionResult.sidedSuccess(context.getLevel().isClientSide());
    }

}
