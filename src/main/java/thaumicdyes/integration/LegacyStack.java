package thaumicdyes.integration;

import java.util.LinkedHashMap;
import java.util.Map;
import thaumcraft.crafting.TcStack;
import thaumcraft.crafting.TcIngredient;

final class LegacyStack {
    final String id;
    final int count;
    final Map<String,String> data = new LinkedHashMap<>();

    LegacyStack(String legacy) { this(legacy, 1, 0); }
    LegacyStack(String legacy, int count) { this(legacy, count, 0); }
    LegacyStack(String legacy, int count, int metadata) {
        id = LegacyItems.resolve(legacy, metadata);
        // Legacy research icons sometimes had count 0, and two ingredients used count 32767 as a wildcard.
        this.count = count <= 0 || count > 99 ? 1 : count;
        if (metadata == 0) data.put("thaumicdyes.damage", "0");
        if (legacy.equals("Items.field_151068_bn")) {
            data.put("thaumicdyes.potion", switch (metadata) {
                case 8233 -> "strong_strength";
                case 8257 -> "long_regeneration";
                case 16428 -> "strong_harming";
                default -> throw new IllegalArgumentException("Unmapped potion metadata " + metadata);
            });
        }
    }

    TcStack stack() { return TcStack.withData(id, count, data); }
    TcStack one() { return TcStack.withData(id, 1, data); }
    TcIngredient ingredient() {
        String tag = switch(id) {
            case "minecraft:iron_ingot" -> "c:ingots/iron";
            case "minecraft:gold_ingot" -> "c:ingots/gold";
            case "minecraft:gold_nugget" -> "c:nuggets/gold";
            case "minecraft:diamond" -> "c:gems/diamond";
            case "minecraft:slime_ball" -> "c:slime_balls";
            case "minecraft:string" -> "c:strings";
            case "minecraft:leather" -> "c:leathers";
            case "minecraft:nether_star" -> "c:nether_stars";
            case "minecraft:iron_block" -> "c:storage_blocks/iron";
            case "minecraft:black_dye" -> "c:dyes/black";
            case "minecraft:red_dye" -> "c:dyes/red";
            case "minecraft:white_dye" -> "c:dyes/white";
            case "minecraft:yellow_dye" -> "c:dyes/yellow";
            case "minecraft:light_gray_dye" -> "c:dyes/light_gray";
            case "thaumcraft:thaumium_ingot" -> "c:ingots/thaumium";
            case "thaumcraft:void_metal_ingot" -> "c:ingots/void_metal";
            default -> null;
        };
        return tag == null ? TcIngredient.of(one()) : TcIngredient.tag(tag);
    }

}
