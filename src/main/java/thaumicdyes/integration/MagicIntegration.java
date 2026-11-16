package thaumicdyes.integration;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import thaumcraft.crafting.TcStack;
import thaumcraft.device.WardedKeys;

public final class MagicIntegration {
    private static boolean registered;
    private MagicIntegration() {}

    private static Holder<Potion> potion(String value) {
        return switch (value) {
            case "strong_strength" -> Potions.STRONG_STRENGTH;
            case "long_regeneration" -> Potions.LONG_REGENERATION;
            case "strong_harming" -> Potions.STRONG_HARMING;
            default -> throw new IllegalArgumentException("Unknown legacy potion " + value);
        };
    }

    public static void register() {
        if (registered) throw new IllegalStateException("Magic integration registered twice");
        registered = true;
        TcStack.registerDataHandler("thaumicdyes.damage", (stack,value) -> {
            if (stack.isDamageableItem()) stack.setDamageValue(Integer.parseInt(value));
        });
        TcStack.registerDataMatcher("thaumicdyes.damage", (stack,value) -> stack.getDamageValue() == Integer.parseInt(value));
        TcStack.registerDataHandler("thaumicdyes.potion", (stack, value) ->
            stack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion(value))));
        TcStack.registerDataMatcher("thaumicdyes.potion", (stack, value) ->
            stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).potion()
                .map(holder -> holder.equals(potion(value))).orElse(false));
        TcStack.registerDataHandler("thaumicdyes.banner_color", (stack, value) ->
            WardedKeys.BANNER_COLOR.set(stack, Integer.parseInt(value)));
        TcStack.registerDataMatcher("thaumicdyes.banner_color", (stack, value) ->
            WardedKeys.BANNER_COLOR.getOrDefault(stack, -1) == Integer.parseInt(value));
        LegacyHelmetRecipes.initInfusionRecipes();
        LegacyRecipeData.init();
        LegacyResearchData.addResearch();
    }
}
