package thaumicdyes.integration;

import java.util.Arrays;
import thaumcraft.crafting.CrucibleRecipe;
import thaumcraft.crafting.InfusionRecipe;
import thaumcraft.crafting.ShapedArcaneRecipe;
import thaumcraft.research.ResearchPage;

final class LegacyPage {
    final ResearchPage page;
    LegacyPage(String text) { page = ResearchPage.text(text); }
    LegacyPage(InfusionRecipe... recipes) { page = ResearchPage.infusion(Arrays.stream(recipes).map(InfusionRecipe::key).toArray(String[]::new)); }
    LegacyPage(CrucibleRecipe... recipes) { page = ResearchPage.crucible(Arrays.stream(recipes).map(CrucibleRecipe::key).toArray(String[]::new)); }
    LegacyPage(ShapedArcaneRecipe... recipes) { page = ResearchPage.arcane(Arrays.stream(recipes).map(ShapedArcaneRecipe::key).toArray(String[]::new)); }
}
