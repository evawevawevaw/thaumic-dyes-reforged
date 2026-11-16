package thaumicdyes;

import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public final class GearStats {
    private static final Map<String,String> KINDS = Map.ofEntries(
        Map.entry("cultist_robe_helm", "CultistRobesDyed"),
        Map.entry("cultist_robe_chest", "CultistRobesDyed"),
        Map.entry("cultist_robe_legs", "CultistRobesDyed"),
        Map.entry("fortress_helm", "ThaumiumFortressDyed"),
        Map.entry("fortress_chest", "ThaumiumFortressDyed"),
        Map.entry("fortress_legs", "ThaumiumFortressDyed"),
        Map.entry("cultist_leader_helm", "CultistPraetorDyed"),
        Map.entry("cultist_leader_chest", "CultistPraetorDyed"),
        Map.entry("cultist_leader_legs", "CultistPraetorDyed"),
        Map.entry("cultist_plate_helm", "CultistKnightDyed"),
        Map.entry("cultist_plate_chest", "CultistKnightDyed"),
        Map.entry("cultist_plate_legs", "CultistKnightDyed"),
        Map.entry("inhabited_plate_helm", "InhabitedKnightArmor"),
        Map.entry("inhabited_plate_chest", "InhabitedKnightArmor"),
        Map.entry("inhabited_plate_legs", "InhabitedKnightArmor"),
        Map.entry("iron_fortress_helm", "IronFortressArmor"),
        Map.entry("iron_fortress_chest", "IronFortressArmor"),
        Map.entry("iron_fortress_legs", "IronFortressArmor"),
        Map.entry("cultist_ranger_helm", "CultistRanger"),
        Map.entry("cultist_ranger_chest", "CultistRanger"),
        Map.entry("cultist_ranger_legs", "CultistRanger"),
        Map.entry("cultist_ranger_helm_dyed", "CultistRangerDyed"),
        Map.entry("cultist_ranger_chest_dyed", "CultistRangerDyed"),
        Map.entry("cultist_ranger_legs_dyed", "CultistRangerDyed"),
        Map.entry("void_robe_helm", "VoidRobeDyed"),
        Map.entry("void_robe_chest", "VoidRobeDyed"),
        Map.entry("void_robe_legs", "VoidRobeDyed"),
        Map.entry("thaumium_robe_helm", "ThaumiumRobeDyed"),
        Map.entry("thaumium_robe_chest", "ThaumiumRobeDyed"),
        Map.entry("thaumium_robe_legs", "ThaumiumRobeDyed"),
        Map.entry("boots_thaumium_traveller", "ThaumiumBoots"),
        Map.entry("boots_void_traveller", "VoidBoots"),
        Map.entry("cultist_archer_helm", "CultistArcher"),
        Map.entry("cultist_archer_chest", "CultistArcher"),
        Map.entry("cultist_archer_legs", "CultistArcher"),
        Map.entry("cultist_paladin_helm", "CultistPaladin"),
        Map.entry("cultist_archer_helm_dyed", "CultistArcherDyed"),
        Map.entry("cultist_archer_chest_dyed", "CultistArcherDyed"),
        Map.entry("cultist_archer_legs_dyed", "CultistArcherDyed"),
        Map.entry("sun_knight_helm", "SunKnight"),
        Map.entry("sun_knight_chest", "SunKnight"),
        Map.entry("item_runic_helmet", "ItemRunicArmor"),
        Map.entry("item_runic_chest", "ItemRunicArmor"),
        Map.entry("item_runic_legs", "ItemRunicArmor"),
        Map.entry("item_runic_boots", "ItemRunicArmor"),
        Map.entry("item_runic_goggles", "ItemRunicGoggles"),
        Map.entry("item_runic_boots_traveller", "ItemRunicBootsTraveller"),
        Map.entry("item_mask_evil", "ItemTXAncientMask"),
        Map.entry("item_runic_helmet_enhanced", "ItemRunicArmorEnhanced"),
        Map.entry("item_runic_chest_enhanced", "ItemRunicArmorEnhanced"),
        Map.entry("item_runic_legs_enhanced", "ItemRunicArmorEnhanced"),
        Map.entry("item_runic_boots_enhanced", "ItemRunicArmorEnhanced"),
        Map.entry("item_runic_helmet_primal", "ItemRunicArmorPrimal"),
        Map.entry("item_runic_chest_primal", "ItemRunicArmorPrimal"),
        Map.entry("item_runic_legs_primal", "ItemRunicArmorPrimal"),
        Map.entry("item_runic_boots_primal", "ItemRunicArmorPrimalBoots")
    );
    private GearStats() {}
    public static String kind(ItemStack stack) {
        var id = BuiltInRegistries.ITEM.getKey(stack.getItem());
        return id.getNamespace().equals(ThaumicDyes.MOD_ID) ? KINDS.getOrDefault(id.getPath(), "") : "";
    }
    public static net.minecraft.world.item.Rarity rarity(String id) {
        return switch(KINDS.getOrDefault(id, "")) {
            case "CultistPaladin", "CultistPraetorDyed", "ThaumiumBoots", "ThaumiumFortressDyed", "ThaumiumRobeDyed", "ItemTXAncientMask", "ItemRunicArmor", "ItemRunicArmorEnhanced", "ItemRunicBootsTraveller", "ItemRunicGoggles" -> net.minecraft.world.item.Rarity.RARE;
            case "VoidBoots", "VoidRobeDyed", "ItemRunicArmorPrimal", "ItemRunicArmorPrimalBoots" -> net.minecraft.world.item.Rarity.EPIC;
            default -> net.minecraft.world.item.Rarity.UNCOMMON;
        };
    }
    public static int tier(ItemStack stack) {
        String kind = kind(stack);
        return kind.contains("Primal") ? 3 : kind.contains("Enhanced") ? 2 : kind.startsWith("ItemRunic") ? 1 : 0;
    }
    public static int discount(ItemStack stack, EquipmentSlot slot) {
        return switch (kind(stack)) {
            case "CultistRobesDyed", "ThaumiumBoots", "ItemRunicArmorEnhanced" -> 2;
            case "CultistRanger" -> slot == EquipmentSlot.HEAD ? 0 : 1;
            case "CultistRangerDyed" -> slot == EquipmentSlot.HEAD ? 0 : 2;
            case "ThaumiumRobeDyed" -> slot == EquipmentSlot.HEAD ? 5 : 3;
            case "VoidRobeDyed", "VoidBoots", "ItemRunicGoggles", "ItemTXAncientMask", "ItemRunicArmorPrimal", "ItemRunicArmorPrimalBoots" -> 5;
            default -> 0;
        };
    }
    public static int warp(ItemStack stack) {
        return switch (kind(stack)) {
            case "CultistRobesDyed", "CultistPraetorDyed", "CultistRanger", "InhabitedKnightArmor", "ItemTXAncientMask" -> 1;
            case "VoidRobeDyed", "VoidBoots" -> 2;
            case "ItemRunicArmorPrimal", "ItemRunicArmorPrimalBoots" -> 3;
            case "IronFortressArmor" -> GearData.mask(stack) == 2 ? 1 : 0;
            default -> 0;
        };
    }
    public static boolean reveals(ItemStack stack, EquipmentSlot slot) {
        if (slot != EquipmentSlot.HEAD) return false;
        return switch (kind(stack)) {
            case "VoidRobeDyed", "ThaumiumRobeDyed", "ItemRunicGoggles", "ItemRunicArmorPrimal" -> true;
            case "ThaumiumFortressDyed", "IronFortressArmor" -> GearData.goggles(stack);
            case "CultistRanger", "CultistRangerDyed" -> GearData.mask(stack) == 0;
            default -> false;
        };
    }
    public static int capacity(ItemStack stack, EquipmentSlot slot) {
        int tier = tier(stack);
        if (tier == 0) return 0;
        int base = switch (slot) { case HEAD, FEET -> 8; case CHEST -> 24; case LEGS -> 16; default -> 0; };
        int nexus = 0;
        for (int index = 0; index < tier; index++) if (GearData.upgrade(stack, index) == 2) nexus++;
        return base + base / 2 * nexus;
    }
}
