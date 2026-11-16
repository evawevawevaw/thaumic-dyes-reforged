package thaumicdyes;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;

public final class Content {
    private static final net.neoforged.neoforge.registries.DeferredRegister.Items ITEMS = ThaumicDyes.ITEMS;
    private static final Map<String, DeferredItem<? extends Item>> CONTENT = new LinkedHashMap<>();

    static {
        armor("cultist_robe_helm", Materials.ROBES, ArmorItem.Type.HELMET, true, false, false, "iron");
        armor("cultist_robe_chest", Materials.ROBES, ArmorItem.Type.CHESTPLATE, true, false, false, "iron");
        armor("cultist_robe_legs", Materials.ROBES, ArmorItem.Type.LEGGINGS, true, false, false, "iron");
        armor("fortress_helm", Materials.FORTRESS, ArmorItem.Type.HELMET, true, false, false, "thaumium");
        armor("fortress_chest", Materials.FORTRESS, ArmorItem.Type.CHESTPLATE, true, false, false, "thaumium");
        armor("fortress_legs", Materials.FORTRESS, ArmorItem.Type.LEGGINGS, true, false, false, "thaumium");
        armor("cultist_leader_helm", Materials.FORTRESS, ArmorItem.Type.HELMET, true, false, false, "iron");
        armor("cultist_leader_chest", Materials.FORTRESS, ArmorItem.Type.CHESTPLATE, true, false, false, "iron");
        armor("cultist_leader_legs", Materials.FORTRESS, ArmorItem.Type.LEGGINGS, true, false, false, "iron");
        armor("cultist_plate_helm", Materials.KNIGHT, ArmorItem.Type.HELMET, true, false, false, "iron");
        armor("cultist_plate_chest", Materials.KNIGHT, ArmorItem.Type.CHESTPLATE, true, false, false, "iron");
        armor("cultist_plate_legs", Materials.KNIGHT, ArmorItem.Type.LEGGINGS, true, false, false, "iron");
        armor("inhabited_plate_helm", Materials.IRON, ArmorItem.Type.HELMET, false, false, false, "iron");
        armor("inhabited_plate_chest", Materials.IRON, ArmorItem.Type.CHESTPLATE, false, false, false, "iron");
        armor("inhabited_plate_legs", Materials.IRON, ArmorItem.Type.LEGGINGS, false, false, false, "iron");
        armor("iron_fortress_helm", Materials.IRON_FORTRESS, ArmorItem.Type.HELMET, false, false, false, "iron");
        armor("iron_fortress_chest", Materials.IRON_FORTRESS, ArmorItem.Type.CHESTPLATE, false, false, false, "iron");
        armor("iron_fortress_legs", Materials.IRON_FORTRESS, ArmorItem.Type.LEGGINGS, false, false, false, "iron");
        armor("cultist_ranger_helm", Materials.IRON, ArmorItem.Type.HELMET, false, false, false, "iron");
        armor("cultist_ranger_chest", Materials.IRON, ArmorItem.Type.CHESTPLATE, false, false, false, "iron");
        armor("cultist_ranger_legs", Materials.IRON, ArmorItem.Type.LEGGINGS, false, false, false, "iron");
        armor("cultist_ranger_helm_dyed", Materials.ROBES, ArmorItem.Type.HELMET, true, false, false, "iron");
        armor("cultist_ranger_chest_dyed", Materials.ROBES, ArmorItem.Type.CHESTPLATE, true, false, false, "iron");
        armor("cultist_ranger_legs_dyed", Materials.ROBES, ArmorItem.Type.LEGGINGS, true, false, false, "iron");
        armor("void_robe_helm", Materials.VOID, ArmorItem.Type.HELMET, true, false, true, "void_metal");
        armor("void_robe_chest", Materials.VOID, ArmorItem.Type.CHESTPLATE, true, false, true, "void_metal");
        armor("void_robe_legs", Materials.VOID, ArmorItem.Type.LEGGINGS, true, false, true, "void_metal");
        armor("thaumium_robe_helm", Materials.THAUMIUM, ArmorItem.Type.HELMET, true, false, false, "thaumium");
        armor("thaumium_robe_chest", Materials.THAUMIUM, ArmorItem.Type.CHESTPLATE, true, false, false, "thaumium");
        armor("thaumium_robe_legs", Materials.THAUMIUM, ArmorItem.Type.LEGGINGS, true, false, false, "thaumium");
        armor("boots_thaumium_traveller", Materials.THAUMIUM, ArmorItem.Type.BOOTS, false, false, false, "thaumium");
        armor("boots_void_traveller", Materials.VOID, ArmorItem.Type.BOOTS, false, false, true, "void_metal");
        armor("cultist_archer_helm", Materials.IRON, ArmorItem.Type.HELMET, false, false, false, "iron");
        armor("cultist_archer_chest", Materials.IRON, ArmorItem.Type.CHESTPLATE, false, false, false, "iron");
        armor("cultist_archer_legs", Materials.IRON, ArmorItem.Type.LEGGINGS, false, false, false, "iron");
        armor("cultist_paladin_helm", Materials.FORTRESS, ArmorItem.Type.HELMET, false, false, false, "iron");
        armor("cultist_archer_helm_dyed", Materials.KNIGHT, ArmorItem.Type.HELMET, true, false, false, "iron");
        armor("cultist_archer_chest_dyed", Materials.KNIGHT, ArmorItem.Type.CHESTPLATE, true, false, false, "iron");
        armor("cultist_archer_legs_dyed", Materials.KNIGHT, ArmorItem.Type.LEGGINGS, true, false, false, "iron");
        add("item_resource_fabric", ITEMS.registerSimpleItem("item_resource_fabric"));
        armor("sun_knight_helm", Materials.IRON, ArmorItem.Type.HELMET, false, false, false, "iron");
        armor("sun_knight_chest", Materials.IRON, ArmorItem.Type.CHESTPLATE, false, false, false, "iron");
        armor("item_runic_helmet", Materials.RUNIC, ArmorItem.Type.HELMET, false, true, false, "none");
        armor("item_runic_chest", Materials.RUNIC, ArmorItem.Type.CHESTPLATE, false, true, false, "none");
        armor("item_runic_legs", Materials.RUNIC, ArmorItem.Type.LEGGINGS, false, true, false, "none");
        armor("item_runic_boots", Materials.RUNIC, ArmorItem.Type.BOOTS, false, true, false, "none");
        armor("item_runic_goggles", Materials.RUNIC, ArmorItem.Type.HELMET, false, true, false, "none");
        armor("item_runic_boots_traveller", Materials.RUNIC, ArmorItem.Type.BOOTS, false, true, false, "none");
        armor("item_mask_evil", Materials.SPECIAL, ArmorItem.Type.HELMET, false, false, false, "void_metal");
        armor("item_runic_helmet_enhanced", Materials.RUNIC_II, ArmorItem.Type.HELMET, false, true, false, "none");
        armor("item_runic_chest_enhanced", Materials.RUNIC_II, ArmorItem.Type.CHESTPLATE, false, true, false, "none");
        armor("item_runic_legs_enhanced", Materials.RUNIC_II, ArmorItem.Type.LEGGINGS, false, true, false, "none");
        armor("item_runic_boots_enhanced", Materials.RUNIC_II, ArmorItem.Type.BOOTS, false, true, false, "none");
        armor("item_runic_helmet_primal", Materials.RUNIC_III, ArmorItem.Type.HELMET, false, true, false, "none");
        armor("item_runic_chest_primal", Materials.RUNIC_III, ArmorItem.Type.CHESTPLATE, false, true, false, "none");
        armor("item_runic_legs_primal", Materials.RUNIC_III, ArmorItem.Type.LEGGINGS, false, true, false, "none");
        armor("item_runic_boots_primal", Materials.RUNIC_III, ArmorItem.Type.BOOTS, false, true, false, "none");
    }

    private Content() {}

    private static void add(String id, DeferredItem<? extends Item> item) {
        CONTENT.put(id, item);
    }

    private static void armor(String id, Materials.Profile profile, ArmorItem.Type slot,
                              boolean dyeable, boolean runic, boolean selfRepair, String repair) {
        var material = Materials.register(id, profile, dyeable);
        var fortress = id.startsWith("fortress_") ? DyedFortressItem.profile(profile) : null;
        if (fortress != null) thaumcraft.platform.Registration.armorMaterial(fortress);
        add(id, ITEMS.register(id, () -> {
            Item.Properties properties = new Item.Properties().stacksTo(1).rarity(GearStats.rarity(id));
            if (dyeable) {
                // Legacy dye recipes include the initial white color in the first mixture.
                properties.component(net.minecraft.core.component.DataComponents.DYED_COLOR,
                    new net.minecraft.world.item.component.DyedItemColor(0xFFFFFF, true));
            }
            if (!runic) {
                properties.durability(slot.getDurability(profile.durability()));
            }
            if (fortress != null) return new DyedFortressItem(material, fortress, slot, properties);
            return new PortArmorItem(material, slot, properties,
                dyeable, runic, selfRepair, repair);
        }));
    }

    public static Map<String, DeferredItem<? extends Item>> all() {
        return Collections.unmodifiableMap(CONTENT);
    }
}
