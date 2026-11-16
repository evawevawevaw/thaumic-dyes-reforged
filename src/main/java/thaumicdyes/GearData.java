package thaumicdyes;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;
import thaumcraft.infusion.InfusionKeys;

public final class GearData {
    private GearData() {}

    private static int integer(ItemStack stack, String name, DataComponentType<Integer> type, int fallback, int max) {
        String raw = InfusionKeys.TAGS.getOrDefault(stack, Map.of()).get("thaumicdyes.tag." + name);
        if (raw == null && name.equals("mask")) raw = InfusionKeys.TAGS.getOrDefault(stack, Map.of()).get("mask");
        if (raw != null) {
            try {
                int value = Integer.parseInt(raw);
                return value >= 0 && value <= max ? value : fallback;
            } catch (NumberFormatException ignored) {
                return fallback;
            }
        }
        return stack.getOrDefault(type, fallback);
    }

    public static int upgrade(ItemStack stack, int slot) {
        return switch (slot) {
            case 0 -> integer(stack, "upgrade", PortComponents.UPGRADE.get(), 0, 10);
            case 1 -> integer(stack, "upgrade2", PortComponents.UPGRADE_2.get(), 0, 10);
            case 2 -> integer(stack, "upgrade3", PortComponents.UPGRADE_3.get(), 0, 10);
            default -> throw new IllegalArgumentException("Invalid upgrade slot " + slot);
        };
    }

    public static int mask(ItemStack stack) {
        return integer(stack, "mask", PortComponents.MASK.get(), -1, 2);
    }

    public static boolean goggles(ItemStack stack) {
        String value = InfusionKeys.TAGS.getOrDefault(stack, Map.of()).get("thaumicdyes.tag.goggles");
        if (value == null && InfusionKeys.TAGS.getOrDefault(stack, Map.of()).containsKey("goggles")) return true;
        return value != null ? value.equals("1") || value.equals("true") : stack.getOrDefault(PortComponents.GOGGLES.get(), false);
    }

    public static boolean has(ItemStack stack, int upgrade) {
        int slots = GearStats.tier(stack);
        for (int i = 0; i < slots; i++) if (upgrade(stack, i) == upgrade) return true;
        return false;
    }

    public static void migrate(ItemStack stack) {
        Map<String,String> tags = new HashMap<>(InfusionKeys.TAGS.getOrDefault(stack, Map.of()));
        var known = java.util.Set.of("thaumicdyes.tag.upgrade", "thaumicdyes.tag.upgrade2", "thaumicdyes.tag.upgrade3", "thaumicdyes.tag.mask", "thaumicdyes.tag.goggles");
        boolean changed = tags.keySet().stream().anyMatch(known::contains);
        if (!changed) return;
        stack.set(PortComponents.UPGRADE.get(), upgrade(stack, 0));
        stack.set(PortComponents.UPGRADE_2.get(), upgrade(stack, 1));
        stack.set(PortComponents.UPGRADE_3.get(), upgrade(stack, 2));
        int mask = mask(stack);
        if (mask >= 0) stack.set(PortComponents.MASK.get(), mask);
        stack.set(PortComponents.GOGGLES.get(), goggles(stack));
        tags.keySet().removeIf(known::contains);
        if (tags.isEmpty()) InfusionKeys.TAGS.remove(stack); else InfusionKeys.TAGS.set(stack, Map.copyOf(tags));
    }

    public static void rotate(ItemStack stack, int slots) {
        migrate(stack);
        int first = upgrade(stack, 0), second = upgrade(stack, 1), third = upgrade(stack, 2);
        stack.set(PortComponents.UPGRADE.get(), second);
        stack.set(PortComponents.UPGRADE_2.get(), slots == 3 ? third : first);
        if (slots == 3) stack.set(PortComponents.UPGRADE_3.get(), first);
    }
}
