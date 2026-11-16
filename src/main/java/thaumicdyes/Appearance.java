package thaumicdyes;

import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

public final class Appearance {
    public record Skin(String model, String main, String overlay, boolean dyeable) {}
    private static final Map<String, Skin> SKINS = Map.ofEntries(
        Map.entry("cultist_robe_helm", new Skin("Robes", "thaumicdyes:textures/models/robe_armor_overlay.png", "thaumicdyes:textures/models/cultist_robe_base.png", true)),
        Map.entry("cultist_robe_chest", new Skin("Robes", "thaumicdyes:textures/models/robe_armor_overlay.png", "thaumicdyes:textures/models/cultist_robe_base.png", true)),
        Map.entry("cultist_robe_legs", new Skin("Robes", "thaumicdyes:textures/models/robe_armor_overlay.png", "thaumicdyes:textures/models/cultist_robe_base.png", true)),
        Map.entry("fortress_helm", new Skin("Fortress", "thaumicdyes:textures/models/fortress_armor_overlay.png", "thaumicdyes:textures/models/fortress_armor_base.png", true)),
        Map.entry("fortress_chest", new Skin("Fortress", "thaumicdyes:textures/models/fortress_armor_overlay.png", "thaumicdyes:textures/models/fortress_armor_base.png", true)),
        Map.entry("fortress_legs", new Skin("Fortress", "thaumicdyes:textures/models/fortress_armor_overlay.png", "thaumicdyes:textures/models/fortress_armor_base.png", true)),
        Map.entry("cultist_leader_helm", new Skin("Praetor", "thaumicdyes:textures/models/cultist_praetor_overlay.png", "thaumicdyes:textures/models/cultist_praetor_base.png", true)),
        Map.entry("cultist_leader_chest", new Skin("Praetor", "thaumicdyes:textures/models/cultist_praetor_overlay.png", "thaumicdyes:textures/models/cultist_praetor_base.png", true)),
        Map.entry("cultist_leader_legs", new Skin("Praetor", "thaumicdyes:textures/models/cultist_praetor_overlay.png", "thaumicdyes:textures/models/cultist_praetor_base.png", true)),
        Map.entry("cultist_plate_helm", new Skin("Knight", "thaumicdyes:textures/models/cultist_knight_overlay.png", "thaumicdyes:textures/models/cultist_knight_base.png", true)),
        Map.entry("cultist_plate_chest", new Skin("Knight", "thaumicdyes:textures/models/cultist_knight_overlay.png", "thaumicdyes:textures/models/cultist_knight_base.png", true)),
        Map.entry("cultist_plate_legs", new Skin("Knight", "thaumicdyes:textures/models/cultist_knight_overlay.png", "thaumicdyes:textures/models/cultist_knight_base.png", true)),
        Map.entry("inhabited_plate_helm", new Skin("Knight", "thaumicdyes:textures/models/zombie_plate_armor.png", "thaumicdyes:textures/models/zombie_plate_armor.png", false)),
        Map.entry("inhabited_plate_chest", new Skin("Knight", "thaumicdyes:textures/models/zombie_plate_armor.png", "thaumicdyes:textures/models/zombie_plate_armor.png", false)),
        Map.entry("inhabited_plate_legs", new Skin("Knight", "thaumicdyes:textures/models/zombie_plate_armor.png", "thaumicdyes:textures/models/zombie_plate_armor.png", false)),
        Map.entry("iron_fortress_helm", new Skin("IronFortress", "thaumicdyes:textures/models/iron_fortress_armor2.png", "thaumicdyes:textures/models/iron_fortress_armor2.png", false)),
        Map.entry("iron_fortress_chest", new Skin("IronFortress", "thaumicdyes:textures/models/iron_fortress_armor2.png", "thaumicdyes:textures/models/iron_fortress_armor2.png", false)),
        Map.entry("iron_fortress_legs", new Skin("IronFortress", "thaumicdyes:textures/models/iron_fortress_armor2.png", "thaumicdyes:textures/models/iron_fortress_armor2.png", false)),
        Map.entry("cultist_ranger_helm", new Skin("Ranger2", "thaumicdyes:textures/models/cultist_ranger_armor.png", "thaumicdyes:textures/models/cultist_ranger_armor.png", false)),
        Map.entry("cultist_ranger_chest", new Skin("Ranger2", "thaumicdyes:textures/models/cultist_ranger_armor.png", "thaumicdyes:textures/models/cultist_ranger_armor.png", false)),
        Map.entry("cultist_ranger_legs", new Skin("Ranger2", "thaumicdyes:textures/models/cultist_ranger_armor.png", "thaumicdyes:textures/models/cultist_ranger_armor.png", false)),
        Map.entry("cultist_ranger_helm_dyed", new Skin("Ranger", "thaumicdyes:textures/models/cultist_ranger_overlay.png", "thaumicdyes:textures/models/cultist_ranger_base.png", true)),
        Map.entry("cultist_ranger_chest_dyed", new Skin("Ranger", "thaumicdyes:textures/models/cultist_ranger_overlay.png", "thaumicdyes:textures/models/cultist_ranger_base.png", true)),
        Map.entry("cultist_ranger_legs_dyed", new Skin("Ranger", "thaumicdyes:textures/models/cultist_ranger_overlay.png", "thaumicdyes:textures/models/cultist_ranger_base.png", true)),
        Map.entry("void_robe_helm", new Skin("Robes", "thaumicdyes:textures/models/robe_armor_overlay.png", "thaumicdyes:textures/models/void_robe_base.png", true)),
        Map.entry("void_robe_chest", new Skin("Robes", "thaumicdyes:textures/models/robe_armor_overlay.png", "thaumicdyes:textures/models/void_robe_base.png", true)),
        Map.entry("void_robe_legs", new Skin("Robes", "thaumicdyes:textures/models/robe_armor_overlay.png", "thaumicdyes:textures/models/void_robe_base.png", true)),
        Map.entry("thaumium_robe_helm", new Skin("Robes", "thaumicdyes:textures/models/thaumium_robe_overlay.png", "thaumicdyes:textures/models/thaumium_robe_base.png", true)),
        Map.entry("thaumium_robe_chest", new Skin("Robes", "thaumicdyes:textures/models/thaumium_robe_overlay.png", "thaumicdyes:textures/models/thaumium_robe_base.png", true)),
        Map.entry("thaumium_robe_legs", new Skin("Robes", "thaumicdyes:textures/models/thaumium_robe_overlay.png", "thaumicdyes:textures/models/thaumium_robe_base.png", true)),
        Map.entry("boots_thaumium_traveller", new Skin("Vanilla", "thaumicdyes:textures/models/bootsthaumiumtrv.png", "thaumicdyes:textures/models/bootsthaumiumtrv.png", false)),
        Map.entry("boots_void_traveller", new Skin("Vanilla", "thaumicdyes:textures/models/bootsvoidtrv.png", "thaumicdyes:textures/models/bootsvoidtrv.png", false)),
        Map.entry("cultist_archer_helm", new Skin("Archer", "thaumicdyes:textures/models/cultist_archer_armor.png", "thaumicdyes:textures/models/cultist_archer_armor.png", false)),
        Map.entry("cultist_archer_chest", new Skin("Archer", "thaumicdyes:textures/models/cultist_archer_armor.png", "thaumicdyes:textures/models/cultist_archer_armor.png", false)),
        Map.entry("cultist_archer_legs", new Skin("Archer", "thaumicdyes:textures/models/cultist_archer_armor.png", "thaumicdyes:textures/models/cultist_archer_armor.png", false)),
        Map.entry("cultist_paladin_helm", new Skin("Paladin", "thaumicdyes:textures/models/cultist_paladin_armor.png", "thaumicdyes:textures/models/cultist_paladin_armor.png", false)),
        Map.entry("cultist_archer_helm_dyed", new Skin("Archer", "thaumicdyes:textures/models/cultist_archer_overlay.png", "thaumicdyes:textures/models/cultist_archer_base.png", true)),
        Map.entry("cultist_archer_chest_dyed", new Skin("Archer", "thaumicdyes:textures/models/cultist_archer_overlay.png", "thaumicdyes:textures/models/cultist_archer_base.png", true)),
        Map.entry("cultist_archer_legs_dyed", new Skin("Archer", "thaumicdyes:textures/models/cultist_archer_overlay.png", "thaumicdyes:textures/models/cultist_archer_base.png", true)),
        Map.entry("sun_knight_helm", new Skin("Knight", "thaumicdyes:textures/models/sun_plate_armor.png", "thaumicdyes:textures/models/sun_plate_armor.png", false)),
        Map.entry("sun_knight_chest", new Skin("Knight", "thaumicdyes:textures/models/sun_plate_armor.png", "thaumicdyes:textures/models/sun_plate_armor.png", false)),
        Map.entry("item_runic_helmet", new Skin("IronFortress", "thaumicdyes:textures/models/iron_fortress_armor2.png", "thaumicdyes:textures/models/iron_fortress_armor2.png", false)),
        Map.entry("item_runic_chest", new Skin("IronFortress", "thaumicdyes:textures/models/iron_fortress_armor2.png", "thaumicdyes:textures/models/iron_fortress_armor2.png", false)),
        Map.entry("item_runic_legs", new Skin("IronFortress", "thaumicdyes:textures/models/iron_fortress_armor2.png", "thaumicdyes:textures/models/iron_fortress_armor2.png", false)),
        Map.entry("item_runic_boots", new Skin("Vanilla", "thaumicdyes:textures/models/bootsthaumiumtrv.png", "thaumicdyes:textures/models/bootsthaumiumtrv.png", false)),
        Map.entry("item_runic_goggles", new Skin("Vanilla", "thaumicdyes:textures/models/runic_goggles.png", "thaumicdyes:textures/models/runic_goggles.png", false)),
        Map.entry("item_runic_boots_traveller", new Skin("Vanilla", "thaumicdyes:textures/models/runicbootstraveler.png", "thaumicdyes:textures/models/runicbootstraveler.png", false)),
        Map.entry("item_mask_evil", new Skin("Vanilla", "thaumicdyes:textures/models/mask.png", "thaumicdyes:textures/models/mask.png", false)),
        Map.entry("item_runic_helmet_enhanced", new Skin("Praetor", "thaumicdyes:textures/models/cultist_praetor_armor.png", "thaumicdyes:textures/models/cultist_praetor_armor.png", false)),
        Map.entry("item_runic_chest_enhanced", new Skin("Praetor", "thaumicdyes:textures/models/cultist_praetor_armor.png", "thaumicdyes:textures/models/cultist_praetor_armor.png", false)),
        Map.entry("item_runic_legs_enhanced", new Skin("Praetor", "thaumicdyes:textures/models/cultist_praetor_armor.png", "thaumicdyes:textures/models/cultist_praetor_armor.png", false)),
        Map.entry("item_runic_boots_enhanced", new Skin("Vanilla", "thaumicdyes:textures/models/bootsvoidtrv.png", "thaumicdyes:textures/models/bootsvoidtrv.png", false)),
        Map.entry("item_runic_helmet_primal", new Skin("RobesSpecial", "thaumicdyes:textures/models/guardian_robe_armor_t.png", "thaumicdyes:textures/models/guardian_robe_armor_t.png", false)),
        Map.entry("item_runic_chest_primal", new Skin("RobesSpecial", "thaumicdyes:textures/models/guardian_robe_armor_t.png", "thaumicdyes:textures/models/guardian_robe_armor_t.png", false)),
        Map.entry("item_runic_legs_primal", new Skin("RobesSpecial", "thaumicdyes:textures/models/guardian_robe_armor_t.png", "thaumicdyes:textures/models/guardian_robe_armor_t.png", false)),
        Map.entry("item_runic_boots_primal", new Skin("RobesSpecial", "thaumicdyes:textures/models/guardian_robe_armor_t.png", "thaumicdyes:textures/models/guardian_robe_armor_t.png", false))
    );
    private Appearance() {}

    public static Skin of(ItemStack stack) {
        var id = BuiltInRegistries.ITEM.getKey(stack.getItem());
        return id.getNamespace().equals(ThaumicDyes.MOD_ID) ? SKINS.get(id.getPath()) : null;
    }
}
