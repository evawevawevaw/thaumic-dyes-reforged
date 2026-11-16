package thaumicdyes;

import java.util.List;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class Materials {
    public static final DeferredRegister<ArmorMaterial> REGISTRY =
        DeferredRegister.create(Registries.ARMOR_MATERIAL, ThaumicDyes.MOD_ID);

    public record Profile(int durability, int helmet, int chest, int legs, int boots, int enchantability) {}

    public static final Profile ROBES = new Profile(15, 2, 6, 5, 1, 15);
    public static final Profile FORTRESS = new Profile(45, 3, 7, 6, 1, 30);
    public static final Profile KNIGHT = new Profile(20, 2, 6, 5, 1, 12);
    public static final Profile IRON_FORTRESS = new Profile(25, 2, 6, 5, 2, 12);
    public static final Profile IRON = new Profile(15, 2, 6, 5, 2, 9);
    public static final Profile THAUMIUM = new Profile(25, 2, 6, 5, 2, 25);
    public static final Profile VOID = new Profile(10, 3, 7, 6, 3, 10);
    // Legacy ThaumcraftApi SPECIAL values verified against the original public API source.
    public static final Profile SPECIAL = new Profile(25, 1, 3, 2, 1, 25);
    public static final Profile RUNIC = new Profile(0, 1, 3, 2, 1, 25);
    public static final Profile RUNIC_II = new Profile(0, 2, 6, 5, 2, 25);
    public static final Profile RUNIC_III = new Profile(0, 3, 7, 6, 3, 25);

    private Materials() {}

    public static Holder<ArmorMaterial> register(String name, Profile profile, boolean tinted) {
        return REGISTRY.register(name, () -> new ArmorMaterial(
            Map.of(ArmorItem.Type.HELMET, profile.helmet(), ArmorItem.Type.CHESTPLATE, profile.chest(),
                ArmorItem.Type.LEGGINGS, profile.legs(), ArmorItem.Type.BOOTS, profile.boots()),
            profile.enchantability(), SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY,
            // Native layer definitions control tint; PortArmorItem resolves the original texture for each layer.
            tinted ? List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace("leather"), "", true),
                             new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace("leather"), "_overlay", false))
                   : List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace("iron"))),
            0.0F, 0.0F));
    }
}
