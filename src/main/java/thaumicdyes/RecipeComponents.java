package thaumicdyes;

import java.util.function.Supplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;
import thaumcraft.crafting.TcStack;

public final class RecipeComponents {
    private RecipeComponents() {}

    public static void register() {
        integer("thaumicdyes.upgrade", PortComponents.UPGRADE, 10, 0);
        integer("thaumicdyes.upgrade_2", PortComponents.UPGRADE_2, 10, 0);
        integer("thaumicdyes.upgrade_3", PortComponents.UPGRADE_3, 10, 0);
        integer("thaumicdyes.mask", PortComponents.MASK, 2, -1);
        TcStack.registerDataHandler("thaumicdyes.goggles", (stack, value) -> {
            requireArmor(stack);
            if (!value.equals("true") && !value.equals("false")) {
                throw new IllegalArgumentException("Invalid thaumicdyes.goggles: " + value);
            }
            GearData.migrate(stack);
            boolean enabled = Boolean.parseBoolean(value);
            stack.set(PortComponents.GOGGLES.get(), enabled);
            var tags = new java.util.HashMap<>(thaumcraft.infusion.InfusionKeys.TAGS.getOrDefault(stack, java.util.Map.of()));
            if (enabled) tags.put("goggles", "1"); else tags.remove("goggles");
            if (tags.isEmpty()) thaumcraft.infusion.InfusionKeys.TAGS.remove(stack);
            else thaumcraft.infusion.InfusionKeys.TAGS.set(stack, java.util.Map.copyOf(tags));
        });
        TcStack.registerDataMatcher("thaumicdyes.goggles", (stack, value) ->
            stack.getItem() instanceof net.minecraft.world.item.ArmorItem && !GearStats.kind(stack).isEmpty() && (value.equals("true") || value.equals("false"))
                && GearData.goggles(stack) == Boolean.parseBoolean(value));
    }

    private static void requireArmor(ItemStack stack) {
        if (!(stack.getItem() instanceof net.minecraft.world.item.ArmorItem) || GearStats.kind(stack).isEmpty()) {
            throw new IllegalArgumentException("Thaumic Dyes recipe data requires Thaumic Dyes armor");
        }
    }

    private static int parsed(String value, int max) {
        int number = Integer.parseInt(value);
        if (number < 0 || number > max) {
            throw new IllegalArgumentException("Thaumic Dyes recipe value outside 0.." + max + ": " + value);
        }
        return number;
    }

    private static void integer(String key, Supplier<DataComponentType<Integer>> type, int max, int fallback) {
        // Namespaced keys avoid overriding other add-ons' legacy mask/goggles handlers.
        TcStack.registerDataHandler(key, (stack, value) -> {
            requireArmor(stack);
            GearData.migrate(stack);
            int number = parsed(value, max);
            stack.set(type.get(), number);
            if (key.equals("thaumicdyes.mask")) {
                var tags = new java.util.HashMap<>(thaumcraft.infusion.InfusionKeys.TAGS.getOrDefault(stack, java.util.Map.of()));
                tags.put("mask", Integer.toString(number));
                thaumcraft.infusion.InfusionKeys.TAGS.set(stack, java.util.Map.copyOf(tags));
            }
        });
        TcStack.registerDataMatcher(key, (stack, value) -> {
            if (!(stack.getItem() instanceof net.minecraft.world.item.ArmorItem) || GearStats.kind(stack).isEmpty()) {
                return false;
            }
            try {
                int actual = switch (key) {
                    case "thaumicdyes.mask" -> GearData.mask(stack);
                    case "thaumicdyes.upgrade" -> GearData.upgrade(stack, 0);
                    case "thaumicdyes.upgrade_2" -> GearData.upgrade(stack, 1);
                    case "thaumicdyes.upgrade_3" -> GearData.upgrade(stack, 2);
                    default -> stack.getOrDefault(type.get(), fallback);
                };
                return actual == parsed(value, max);
            } catch (IllegalArgumentException exception) {
                return false;
            }
        });
    }
}
