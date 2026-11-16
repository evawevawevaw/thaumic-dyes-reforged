package thaumicdyes.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import thaumcraft.aspect.AspectList;
import thaumcraft.crafting.*;
import thaumcraft.research.ResearchCategories;

final class LegacyCrafting {
    private LegacyCrafting() {}

    private static <T extends TcRecipe> T register(T recipe) {
        if (TcRecipes.get(recipe.key()) != null) throw new IllegalStateException("Duplicate add-on recipe " + recipe.key());
        return TcRecipes.register(recipe);
    }

    static InfusionRecipe infusion(String key, String research, Object result, int instability,
            AspectList aspects, LegacyStack central, LegacyStack[] components) {
        TcStack output;
        if (result instanceof LegacyStack stack) {
            output = stack.stack();
        } else if (result instanceof Object[] modification && modification.length == 2) {
            // No data handler for this prefix: TC preserves all central components using its tag-result path.
            String flag = modification[0].toString();
            String dataKey = flag.equals("mask") || flag.equals("goggles") ? flag : "thaumicdyes.tag." + flag;
            output = TcStack.withData(central.id, 1, Map.of(dataKey, modification[1].toString()));
        } else {
            throw new IllegalArgumentException("Unsupported legacy infusion output");
        }
        List<TcIngredient> inputs = java.util.Arrays.stream(components).map(LegacyStack::ingredient).toList();
        return register(new InfusionRecipe("thaumicdyes:"+key, research, output, instability,
            aspects, TcIngredient.of(central.one()), inputs));
    }

    static CrucibleRecipe crucible(String key, String research, LegacyStack result, LegacyStack input, AspectList aspects) {
        return register(new CrucibleRecipe("thaumicdyes:"+key, research, result.stack(), TcIngredient.of(input.one()), aspects));
    }

    static ShapedArcaneRecipe arcane(String key, String research, LegacyStack result, AspectList aspects, Object[] parameters) {
        List<String> rows = new ArrayList<>();
        int index = 0;
        while (index < parameters.length && parameters[index] instanceof String row) {
            rows.add(row);
            index++;
        }
        if (rows.isEmpty() || rows.size() > 3 || (parameters.length - index) % 2 != 0) {
            throw new IllegalArgumentException("Invalid shaped arcane parameters for " + key);
        }
        Map<Character,TcIngredient> keys = new HashMap<>();
        while (index < parameters.length) {
            if (!(parameters[index++] instanceof Character symbol) || symbol == ' ') {
                throw new IllegalArgumentException("Invalid shaped arcane symbol for " + key);
            }
            // Legacy ore strings are converted to native tag ingredients by the generator.
            // Ordinary stacks still retain their metadata/component predicates.
            Object value = parameters[index++];
            TcIngredient ingredient = switch (value) {
                case LegacyStack stack -> stack.ingredient();
                case TcIngredient nativeIngredient -> nativeIngredient;
                default -> throw new IllegalArgumentException("Unsupported shaped arcane ingredient for " + key + ": " + value);
            };
            if (keys.putIfAbsent(symbol, ingredient) != null) {
                throw new IllegalArgumentException("Duplicate shaped arcane symbol for " + key + ": " + symbol);
            }
        }
        int width = rows.stream().mapToInt(String::length).max().orElseThrow();
        if (width < 1 || width > 3 || rows.stream().anyMatch(row -> row.length() != width)) {
            throw new IllegalArgumentException("Invalid shaped arcane dimensions for " + key);
        }
        List<TcIngredient> grid = new ArrayList<>();
        for (String row : rows) for (int x = 0; x < width; x++) {
            char symbol = x < row.length() ? row.charAt(x) : ' ';
            if (symbol != ' ' && !keys.containsKey(symbol)) throw new IllegalArgumentException("Undefined recipe symbol " + symbol);
            grid.add(symbol == ' ' ? TcIngredient.EMPTY : keys.get(symbol));
        }
        return register(new ShapedArcaneRecipe("thaumicdyes:"+key, research, result.stack(), aspects, width, rows.size(), grid));
    }

    static void warp(String research, int amount) {
        var item = ResearchCategories.getResearch(research);
        if (item == null) throw new IllegalArgumentException("Unknown research " + research);
        item.setWarp(amount);
    }
}
