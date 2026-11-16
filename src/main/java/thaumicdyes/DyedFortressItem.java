package thaumicdyes;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import thaumcraft.aspect.Aspect;
import thaumcraft.infusion.InfusionKeys;
import thaumcraft.item.armor.FortressArmorItem;
import thaumcraft.platform.ArmorSlot;
import thaumcraft.platform.TcArmorMaterial;

public final class DyedFortressItem extends FortressArmorItem implements thaumcraft.item.gear.WarpingGear, thaumcraft.wand.VisDiscountGear {
    private final Holder<ArmorMaterial> renderMaterial;

    static TcArmorMaterial profile(Materials.Profile profile) {
        return new TcArmorMaterial(profile.durability(),profile.helmet(),profile.chest(),profile.legs(),profile.boots(),profile.enchantability(),
            SoundEvents.ARMOR_EQUIP_GENERIC,0,0,TagKey.create(Registries.ITEM,ResourceLocation.parse("thaumicdyes:repairs_thaumium")),
            ResourceLocation.parse("thaumicdyes:fortress"));
    }
    DyedFortressItem(Holder<ArmorMaterial> renderMaterial,TcArmorMaterial profile,ArmorItem.Type slot,Properties properties) {
        super(profile,switch(slot) {
            case HELMET -> ArmorSlot.HELMET;
            case CHESTPLATE -> ArmorSlot.CHESTPLATE;
            case LEGGINGS -> ArmorSlot.LEGGINGS;
            case BOOTS -> ArmorSlot.BOOTS;
            default -> throw new IllegalArgumentException("Unsupported fortress slot");
        },properties);
        this.renderMaterial=renderMaterial;
    }
    @Override public Holder<ArmorMaterial> getMaterial() { return renderMaterial; }
    @Override public ResourceLocation getArmorTexture(ItemStack stack,Entity entity,EquipmentSlot slot,ArmorMaterial.Layer layer,boolean inner) {
        var skin=Appearance.of(stack);
        return ResourceLocation.parse(layer.dyeable()?skin.main():skin.overlay());
    }
    @Override public boolean isValidRepairItem(ItemStack stack,ItemStack ingredient) {
        return ingredient.is(TagKey.create(Registries.ITEM,ResourceLocation.parse("thaumicdyes:repairs_thaumium")));
    }
    @Override public int getWarp(ItemStack stack,Player player) { return 0; }
    @Override public int getVisDiscount(ItemStack stack,Player player,Aspect aspect) { return 0; }
    @Override public boolean showNodes(ItemStack stack,LivingEntity entity) { return GearData.goggles(stack); }
    @Override public boolean showIngamePopups(ItemStack stack,LivingEntity entity) { return GearData.goggles(stack); }
    @Override public void inventoryTick(ItemStack stack,Level level,Entity entity,int slot,boolean selected) {
        super.inventoryTick(stack,level,entity,slot,selected);
        if (level.isClientSide()) return;
        GearData.migrate(stack);
        Map<String,String> flags=new HashMap<>(InfusionKeys.TAGS.getOrDefault(stack,Map.of()));
        boolean changed=false;
        if (!flags.containsKey("mask") && stack.has(PortComponents.MASK.get())) {
            flags.put("mask",Integer.toString(stack.get(PortComponents.MASK.get())));changed=true;
        }
        if (!flags.containsKey("goggles") && stack.getOrDefault(PortComponents.GOGGLES.get(),false)) {
            flags.put("goggles","1");changed=true;
        }
        if (changed) InfusionKeys.TAGS.set(stack,Map.copyOf(flags));
    }
}
