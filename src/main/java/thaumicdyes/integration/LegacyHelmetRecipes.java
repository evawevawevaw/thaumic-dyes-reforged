package thaumicdyes.integration;

import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.resources.ResourceLocation;
import thaumcraft.aspect.Aspect;
import thaumcraft.aspect.AspectList;
import thaumcraft.crafting.TcIngredient;
import thaumcraft.crafting.CrucibleRecipe;
import thaumcraft.crafting.InfusionRecipe;
import thaumcraft.crafting.ShapedArcaneRecipe;
import thaumcraft.research.ResearchCategories;

// Adapted from GPLv3 Thaumic Dyes 1.10.5 declarations; all registrations use documented Reforged API.
public final class LegacyHelmetRecipes {
   public static void initInfusionRecipes() {
      LegacyResearchData.recipes
         .put(
            "HelmGoggles",
            LegacyCrafting.infusion("legacyhelmetrecipes_133", "HELMGOGGLES",
               new Object[]{"goggles", Integer.valueOf(1)},
               5,
               new AspectList().add(Aspect.SENSES, 32).add(Aspect.AURA, 16).add(Aspect.ARMOR, 16),
               new LegacyStack("ItemHandler.itemFortressHelmetDyed", 1, 32767),
               new LegacyStack[]{new LegacyStack("Items.field_151123_aH"), new LegacyStack("ConfigItems.itemGoggles", 1, 0)}
            )
         );
      LegacyResearchData.recipes
         .put(
            "MaskGrinningDevil",
            LegacyCrafting.infusion("legacyhelmetrecipes_705", "MASKGRINNINGDEVIL",
               new Object[]{"mask", Integer.valueOf(0)},
               8,
               new AspectList().add(Aspect.MIND, 64).add(Aspect.HEAL, 64).add(Aspect.ARMOR, 16),
               new LegacyStack("ItemHandler.itemFortressHelmetDyed", 1, 32767),
               new LegacyStack[]{
                  new LegacyStack("Items.field_151100_aR", 1, 0),
                  new LegacyStack("Items.field_151042_j"),
                  new LegacyStack("Items.field_151116_aA"),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 2),
                  new LegacyStack("ConfigItems.itemZombieBrain", 1, 0),
                  new LegacyStack("Items.field_151042_j")
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "MaskAngryGhost",
            LegacyCrafting.infusion("legacyhelmetrecipes_1590", "MASKANGRYGHOST",
               new Object[]{"mask", Integer.valueOf(1)},
               8,
               new AspectList().add(Aspect.ENTROPY, 64).add(Aspect.DEATH, 64).add(Aspect.ARMOR, 16),
               new LegacyStack("ItemHandler.itemFortressHelmetDyed", 1, 32767),
               new LegacyStack[]{
                  new LegacyStack("Items.field_151100_aR", 1, 15),
                  new LegacyStack("Items.field_151042_j"),
                  new LegacyStack("Items.field_151116_aA"),
                  new LegacyStack("Items.field_151170_bI"),
                  new LegacyStack("Items.field_151144_bL", 1, 1),
                  new LegacyStack("Items.field_151042_j")
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "MaskSippingFiend",
            LegacyCrafting.infusion("legacyhelmetrecipes_2459", "MASKSIPPINGFIEND",
               new Object[]{"mask", Integer.valueOf(2)},
               8,
               new AspectList().add(Aspect.UNDEAD, 64).add(Aspect.LIFE, 64).add(Aspect.ARMOR, 16),
               new LegacyStack("ItemHandler.itemFortressHelmetDyed", 1, 32767),
               new LegacyStack[]{
                  new LegacyStack("Items.field_151100_aR", 1, 1),
                  new LegacyStack("Items.field_151042_j"),
                  new LegacyStack("Items.field_151116_aA"),
                  new LegacyStack("Items.field_151073_bk"),
                  new LegacyStack("Items.field_151117_aB"),
                  new LegacyStack("Items.field_151042_j")
               }
            )
         );
   }


}
