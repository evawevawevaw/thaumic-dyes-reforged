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
public final class LegacyRecipeData {

   public static void init() {
      initRunicRecipes();
      initRunicUpgrades();
   }

   public static void initCrimsonRecipes() {
   }

   public static void initCrimsonDyedRecipes() {
   }

   public static void initEldritchRecipes() {
   }

   public static void initIronRecipes() {
   }

   public static void initThaumiumRecipes() {
   }

   public static void initVoidRecipes() {
   }

   public static void initRunicRecipes() {
      LegacyResearchData.recipes
         .put(
            "RunicArmorHelm",
            LegacyCrafting.infusion("legacyrecipedata_530", "TD.RUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               4,
               new AspectList().add(Aspect.ARMOR, 30).add(Aspect.MAGIC, 75).add(Aspect.ENERGY, 75),
               new LegacyStack("Items.field_151169_ag", 1, 32767),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemInkwell")
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RunicArmorChest",
            LegacyCrafting.infusion("legacyrecipedata_1357", "TD.RUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicChest"),
               4,
               new AspectList().add(Aspect.ARMOR, 60).add(Aspect.MAGIC, 105).add(Aspect.ENERGY, 105),
               new LegacyStack("Items.field_151171_ah", 1, 32767),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemInkwell")
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RunicArmorLegs",
            LegacyCrafting.infusion("legacyrecipedata_2322", "TD.RUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicLegs"),
               4,
               new AspectList().add(Aspect.ARMOR, 45).add(Aspect.MAGIC, 90).add(Aspect.ENERGY, 90),
               new LegacyStack("Items.field_151149_ai", 1, 32767),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemInkwell")
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RunicArmorBoots",
            LegacyCrafting.infusion("legacyrecipedata_3216", "TD.RUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicBoots"),
               4,
               new AspectList().add(Aspect.ARMOR, 30).add(Aspect.MAGIC, 75).add(Aspect.ENERGY, 75),
               new LegacyStack("Items.field_151151_aj", 1, 32767),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemInkwell")
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RunicGoggles",
            LegacyCrafting.infusion("legacyrecipedata_4039", "TD.RUNICGOGGLES",
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               4,
               new AspectList().add(Aspect.MAGIC, 25).add(Aspect.EXCHANGE, 25),
               new LegacyStack("ConfigItems.itemGoggles", 1, 32767),
               new LegacyStack[]{new LegacyStack("ItemHandler.itemRunicHelmet"), new LegacyStack("Items.field_151123_aH")}
            )
         );
      LegacyResearchData.recipes
         .put(
            "RunicBootsTraveller",
            LegacyCrafting.infusion("legacyrecipedata_4589", "TD.RUNICBOOTSTRAVELLER",
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               4,
               new AspectList().add(Aspect.MAGIC, 25).add(Aspect.EXCHANGE, 25),
               new LegacyStack("ConfigItems.itemBootsTraveller", 1, 32767),
               new LegacyStack[]{new LegacyStack("ItemHandler.itemRunicBoots"), new LegacyStack("Items.field_151123_aH")}
            )
         );
      LegacyResearchData.recipes
         .put(
            "EnhRunicArmor0",
            LegacyCrafting.infusion("legacyrecipedata_5154", "TD.ENHANCEDRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               8,
               new AspectList()
                  .add(Aspect.ARMOR, 40)
                  .add(Aspect.MAGIC, 160)
                  .add(Aspect.ENERGY, 80)
                  .add(Aspect.ELDRITCH, 20)
                  .add(Aspect.CLOTH, 24)
                  .add(Aspect.CRYSTAL, 16)
                  .add(Aspect.EXCHANGE, 20),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "EnhRunicArmor1",
            LegacyCrafting.infusion("legacyrecipedata_6415", "TD.ENHANCEDRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               8,
               new AspectList()
                  .add(Aspect.ARMOR, 40)
                  .add(Aspect.MAGIC, 160)
                  .add(Aspect.ENERGY, 80)
                  .add(Aspect.ELDRITCH, 20)
                  .add(Aspect.CLOTH, 24)
                  .add(Aspect.CRYSTAL, 16)
                  .add(Aspect.EXCHANGE, 20),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "EnhRunicArmor2",
            LegacyCrafting.infusion("legacyrecipedata_7674", "TD.ENHANCEDRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               8,
               new AspectList()
                  .add(Aspect.ARMOR, 40)
                  .add(Aspect.MAGIC, 160)
                  .add(Aspect.ENERGY, 80)
                  .add(Aspect.ELDRITCH, 20)
                  .add(Aspect.CLOTH, 24)
                  .add(Aspect.CRYSTAL, 16)
                  .add(Aspect.EXCHANGE, 20),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "EnhRunicArmor3",
            LegacyCrafting.infusion("legacyrecipedata_8931", "TD.ENHANCEDRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               8,
               new AspectList()
                  .add(Aspect.ARMOR, 40)
                  .add(Aspect.MAGIC, 160)
                  .add(Aspect.ENERGY, 80)
                  .add(Aspect.ELDRITCH, 20)
                  .add(Aspect.CLOTH, 24)
                  .add(Aspect.CRYSTAL, 16)
                  .add(Aspect.EXCHANGE, 20),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("ConfigItems.itemResource", 1, 7),
                  new LegacyStack("Items.field_151156_bN"),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 15),
                  new LegacyStack("ConfigItems.itemResource", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PrmRunicArmor0",
            LegacyCrafting.infusion("legacyrecipedata_10190", "TD.PRIMALRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               10,
               new AspectList().add(Aspect.MAGIC, 240).add(Aspect.ELDRITCH, 120).add(Aspect.DARKNESS, 60).add(Aspect.SOUL, 60).add(Aspect.EXCHANGE, 40),
               new LegacyStack("ConfigItems.itemEldritchObject", 1, 3),
               new LegacyStack[]{
                  new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0),
                  new LegacyStack("ConfigItems.itemHelmetVoidRobe"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PrmRunicArmor1",
            LegacyCrafting.infusion("legacyrecipedata_11041", "TD.PRIMALRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               10,
               new AspectList().add(Aspect.MAGIC, 240).add(Aspect.ELDRITCH, 120).add(Aspect.DARKNESS, 60).add(Aspect.SOUL, 60).add(Aspect.EXCHANGE, 40),
               new LegacyStack("ConfigItems.itemEldritchObject", 1, 3),
               new LegacyStack[]{
                  new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0),
                  new LegacyStack("ConfigItems.itemChestVoidRobe"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PrmRunicArmor2",
            LegacyCrafting.infusion("legacyrecipedata_11889", "TD.PRIMALRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               10,
               new AspectList().add(Aspect.MAGIC, 240).add(Aspect.ELDRITCH, 120).add(Aspect.DARKNESS, 60).add(Aspect.SOUL, 60).add(Aspect.EXCHANGE, 40),
               new LegacyStack("ConfigItems.itemEldritchObject", 1, 3),
               new LegacyStack[]{
                  new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0),
                  new LegacyStack("ConfigItems.itemLegsVoidRobe"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PrmRunicArmor3",
            LegacyCrafting.infusion("legacyrecipedata_12734", "TD.PRIMALRUNICARMOR",
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               10,
               new AspectList().add(Aspect.MAGIC, 240).add(Aspect.ELDRITCH, 120).add(Aspect.DARKNESS, 60).add(Aspect.SOUL, 60).add(Aspect.EXCHANGE, 40),
               new LegacyStack("ConfigItems.itemEldritchObject", 1, 3),
               new LegacyStack[]{
                  new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0),
                  new LegacyStack("ItemHandler.itemVoidBootsTraveller"),
                  new LegacyStack("ConfigItems.itemEldritchObject", 1, 0)
               }
            )
         );
   }

   public static void initRunicUpgrades() {
      LegacyResearchData.recipes
         .put(
            "RAU1_0",
            LegacyCrafting.infusion("legacyrecipedata_13629", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU1_1",
            LegacyCrafting.infusion("legacyrecipedata_14499", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU1_2",
            LegacyCrafting.infusion("legacyrecipedata_15368", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU1_3",
            LegacyCrafting.infusion("legacyrecipedata_16236", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU1",
            LegacyCrafting.infusion("legacyrecipedata_17103", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU1",
            LegacyCrafting.infusion("legacyrecipedata_17973", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU1_0",
            LegacyCrafting.infusion("legacyrecipedata_18852", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU1_1",
            LegacyCrafting.infusion("legacyrecipedata_19731", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU1_2",
            LegacyCrafting.infusion("legacyrecipedata_20609", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU1_3",
            LegacyCrafting.infusion("legacyrecipedata_21486", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU1_0",
            LegacyCrafting.infusion("legacyrecipedata_22364", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU1_1",
            LegacyCrafting.infusion("legacyrecipedata_23241", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU1_2",
            LegacyCrafting.infusion("legacyrecipedata_24117", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU1_3",
            LegacyCrafting.infusion("legacyrecipedata_24992", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(1)},
               6,
               new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("Items.field_151065_br"),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 1)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU2_0",
            LegacyCrafting.infusion("legacyrecipedata_25867", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU2_1",
            LegacyCrafting.infusion("legacyrecipedata_26777", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU2_2",
            LegacyCrafting.infusion("legacyrecipedata_27686", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU2_3",
            LegacyCrafting.infusion("legacyrecipedata_28594", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU2",
            LegacyCrafting.infusion("legacyrecipedata_29501", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU2",
            LegacyCrafting.infusion("legacyrecipedata_30411", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU2_0",
            LegacyCrafting.infusion("legacyrecipedata_31330", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU2_1",
            LegacyCrafting.infusion("legacyrecipedata_32249", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU2_2",
            LegacyCrafting.infusion("legacyrecipedata_33167", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU2_3",
            LegacyCrafting.infusion("legacyrecipedata_34084", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU2_0",
            LegacyCrafting.infusion("legacyrecipedata_35002", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU2_1",
            LegacyCrafting.infusion("legacyrecipedata_35919", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU2_2",
            LegacyCrafting.infusion("legacyrecipedata_36835", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU2_3",
            LegacyCrafting.infusion("legacyrecipedata_37750", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(2)},
               6,
               new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 6)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU3_0",
            LegacyCrafting.infusion("legacyrecipedata_38665", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU3_1",
            LegacyCrafting.infusion("legacyrecipedata_39565", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU3_2",
            LegacyCrafting.infusion("legacyrecipedata_40464", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU3_3",
            LegacyCrafting.infusion("legacyrecipedata_41362", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU3",
            LegacyCrafting.infusion("legacyrecipedata_42259", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU3",
            LegacyCrafting.infusion("legacyrecipedata_43159", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU3_0",
            LegacyCrafting.infusion("legacyrecipedata_44068", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU3_1",
            LegacyCrafting.infusion("legacyrecipedata_44977", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU3_2",
            LegacyCrafting.infusion("legacyrecipedata_45885", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU3_3",
            LegacyCrafting.infusion("legacyrecipedata_46792", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU3_0",
            LegacyCrafting.infusion("legacyrecipedata_47700", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU3_1",
            LegacyCrafting.infusion("legacyrecipedata_48607", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU3_2",
            LegacyCrafting.infusion("legacyrecipedata_49513", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU3_3",
            LegacyCrafting.infusion("legacyrecipedata_50418", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(3)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("Items.field_151068_bn", 1, 16428),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU4_0",
            LegacyCrafting.infusion("legacyrecipedata_51323", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU4_1",
            LegacyCrafting.infusion("legacyrecipedata_52222", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU4_2",
            LegacyCrafting.infusion("legacyrecipedata_53120", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU4_3",
            LegacyCrafting.infusion("legacyrecipedata_54017", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU4",
            LegacyCrafting.infusion("legacyrecipedata_54913", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU4",
            LegacyCrafting.infusion("legacyrecipedata_55812", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU4_0",
            LegacyCrafting.infusion("legacyrecipedata_56720", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU4_1",
            LegacyCrafting.infusion("legacyrecipedata_57628", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU4_2",
            LegacyCrafting.infusion("legacyrecipedata_58535", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU4_3",
            LegacyCrafting.infusion("legacyrecipedata_59441", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU4_0",
            LegacyCrafting.infusion("legacyrecipedata_60348", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU4_1",
            LegacyCrafting.infusion("legacyrecipedata_61254", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU4_2",
            LegacyCrafting.infusion("legacyrecipedata_62159", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU4_3",
            LegacyCrafting.infusion("legacyrecipedata_63063", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(4)},
               6,
               new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 64).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("Items.field_151068_bn", 1, 8257),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigItems.itemShard", 1, 2)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU5_0",
            LegacyCrafting.infusion("legacyrecipedata_63967", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU5_1",
            LegacyCrafting.infusion("legacyrecipedata_64858", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU5_2",
            LegacyCrafting.infusion("legacyrecipedata_65748", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU5_3",
            LegacyCrafting.infusion("legacyrecipedata_66637", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU5",
            LegacyCrafting.infusion("legacyrecipedata_67525", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU5",
            LegacyCrafting.infusion("legacyrecipedata_68416", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU5_0",
            LegacyCrafting.infusion("legacyrecipedata_69316", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU5_1",
            LegacyCrafting.infusion("legacyrecipedata_70216", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU5_2",
            LegacyCrafting.infusion("legacyrecipedata_71115", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU5_3",
            LegacyCrafting.infusion("legacyrecipedata_72013", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU5_0",
            LegacyCrafting.infusion("legacyrecipedata_72912", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU5_1",
            LegacyCrafting.infusion("legacyrecipedata_73810", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU5_2",
            LegacyCrafting.infusion("legacyrecipedata_74707", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU5_3",
            LegacyCrafting.infusion("legacyrecipedata_75603", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(5)},
               6,
               new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU6_0",
            LegacyCrafting.infusion("legacyrecipedata_76499", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU6_1",
            LegacyCrafting.infusion("legacyrecipedata_77400", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU6_2",
            LegacyCrafting.infusion("legacyrecipedata_78300", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU6_3",
            LegacyCrafting.infusion("legacyrecipedata_79199", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU6",
            LegacyCrafting.infusion("legacyrecipedata_80097", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU6",
            LegacyCrafting.infusion("legacyrecipedata_80998", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU6_0",
            LegacyCrafting.infusion("legacyrecipedata_81908", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU6_1",
            LegacyCrafting.infusion("legacyrecipedata_82818", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU6_2",
            LegacyCrafting.infusion("legacyrecipedata_83727", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU6_3",
            LegacyCrafting.infusion("legacyrecipedata_84635", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU6_0",
            LegacyCrafting.infusion("legacyrecipedata_85544", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU6_1",
            LegacyCrafting.infusion("legacyrecipedata_86452", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU6_2",
            LegacyCrafting.infusion("legacyrecipedata_87359", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU6_3",
            LegacyCrafting.infusion("legacyrecipedata_88265", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(6)},
               6,
               new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("Items.field_151068_bn", 1, 8233),
                  new LegacyStack("ConfigItems.itemShard", 1, 3),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU7_0",
            LegacyCrafting.infusion("legacyrecipedata_89171", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU7_1",
            LegacyCrafting.infusion("legacyrecipedata_90069", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU7_2",
            LegacyCrafting.infusion("legacyrecipedata_90966", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU7_3",
            LegacyCrafting.infusion("legacyrecipedata_91862", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU7",
            LegacyCrafting.infusion("legacyrecipedata_92757", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU7",
            LegacyCrafting.infusion("legacyrecipedata_93655", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU7_0",
            LegacyCrafting.infusion("legacyrecipedata_94562", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU7_1",
            LegacyCrafting.infusion("legacyrecipedata_95469", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU7_2",
            LegacyCrafting.infusion("legacyrecipedata_96375", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU7_3",
            LegacyCrafting.infusion("legacyrecipedata_97280", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU7_0",
            LegacyCrafting.infusion("legacyrecipedata_98186", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU7_1",
            LegacyCrafting.infusion("legacyrecipedata_99091", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU7_2",
            LegacyCrafting.infusion("legacyrecipedata_99995", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU7_3",
            LegacyCrafting.infusion("legacyrecipedata_100898", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(7)},
               6,
               new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 40).add(Aspect.ENTROPY, 60),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 5),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigBlocks.blockCosmeticSolid", 1, 3),
                  new LegacyStack("Blocks.field_150339_S"),
                  new LegacyStack("ConfigItems.itemShard", 1, 5)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU8_0",
            LegacyCrafting.infusion("legacyrecipedata_101801", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU8_1",
            LegacyCrafting.infusion("legacyrecipedata_102742", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU8_2",
            LegacyCrafting.infusion("legacyrecipedata_103682", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU8_3",
            LegacyCrafting.infusion("legacyrecipedata_104621", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU8",
            LegacyCrafting.infusion("legacyrecipedata_105559", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU8",
            LegacyCrafting.infusion("legacyrecipedata_106500", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU8_0",
            LegacyCrafting.infusion("legacyrecipedata_107450", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU8_1",
            LegacyCrafting.infusion("legacyrecipedata_108400", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU8_2",
            LegacyCrafting.infusion("legacyrecipedata_109349", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU8_3",
            LegacyCrafting.infusion("legacyrecipedata_110297", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU8_0",
            LegacyCrafting.infusion("legacyrecipedata_111246", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU8_1",
            LegacyCrafting.infusion("legacyrecipedata_112194", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU8_2",
            LegacyCrafting.infusion("legacyrecipedata_113141", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU8_3",
            LegacyCrafting.infusion("legacyrecipedata_114087", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(8)},
               6,
               new AspectList().add(Aspect.LIFE, 320).add(Aspect.MAGIC, 64).add(Aspect.MAN, 80).add(Aspect.EXCHANGE, 40).add(Aspect.SOUL, 40),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemShard", 1, 2),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemGolemPlacer", 1, 4),
                  new LegacyStack("ConfigBlocks.blockCustomPlant", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 3)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU9_3",
            LegacyCrafting.infusion("legacyrecipedata_115033", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(9)},
               6,
               new AspectList().add(Aspect.TRAVEL, 24).add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 24).add(Aspect.MOTION, 32),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU9",
            LegacyCrafting.infusion("legacyrecipedata_115945", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(9)},
               6,
               new AspectList().add(Aspect.TRAVEL, 24).add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 24).add(Aspect.MOTION, 32),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU9_3",
            LegacyCrafting.infusion("legacyrecipedata_116868", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(9)},
               6,
               new AspectList().add(Aspect.TRAVEL, 24).add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 24).add(Aspect.MOTION, 32),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU9_3",
            LegacyCrafting.infusion("legacyrecipedata_117790", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(9)},
               6,
               new AspectList().add(Aspect.TRAVEL, 24).add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 24).add(Aspect.MOTION, 32),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemShard", 1, 0),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemResource", 1, 14),
                  new LegacyStack("ConfigItems.itemResource", 1, 1),
                  new LegacyStack("ConfigItems.itemShard", 1, 4)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU10_0",
            LegacyCrafting.infusion("legacyrecipedata_118710", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicHelmet"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU10_1",
            LegacyCrafting.infusion("legacyrecipedata_119598", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicChest"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU10_2",
            LegacyCrafting.infusion("legacyrecipedata_120485", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicLegs"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RAU10_3",
            LegacyCrafting.infusion("legacyrecipedata_121371", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicBoots"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RGU10",
            LegacyCrafting.infusion("legacyrecipedata_122256", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicGoggles"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "RBTU10",
            LegacyCrafting.infusion("legacyrecipedata_123144", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicBootsTraveller"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU10_0",
            LegacyCrafting.infusion("legacyrecipedata_124041", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicHelmetEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU10_1",
            LegacyCrafting.infusion("legacyrecipedata_124938", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicChestEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU10_2",
            LegacyCrafting.infusion("legacyrecipedata_125834", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicLegsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "ERAU10_3",
            LegacyCrafting.infusion("legacyrecipedata_126729", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicBootsEnhanced"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU10_0",
            LegacyCrafting.infusion("legacyrecipedata_127625", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicHelmetPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU10_1",
            LegacyCrafting.infusion("legacyrecipedata_128520", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicChestPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU10_2",
            LegacyCrafting.infusion("legacyrecipedata_129414", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicLegsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
      LegacyResearchData.recipes
         .put(
            "PRAU10_3",
            LegacyCrafting.infusion("legacyrecipedata_130307", "TD.RUNICARMORUPGRADES",
               new Object[]{"upgrade", Integer.valueOf(10)},
               6,
               new AspectList().add(Aspect.WEAPON, 200).add(Aspect.MAGIC, 64).add(Aspect.ENERGY, 96),
               new LegacyStack("ItemHandler.itemRunicBootsPrimal"),
               new LegacyStack[]{
                  new LegacyStack("ConfigItems.itemShard", 1, 6),
                  new LegacyStack("ConfigItems.itemResource", 1, 0),
                  new LegacyStack("ConfigItems.itemShard", 1, 1),
                  new LegacyStack("ConfigItems.itemSwordThaumium"),
                  new LegacyStack("ConfigItems.itemShard", 1, 4),
                  new LegacyStack("ConfigItems.itemResource", 1, 0)
               }
            )
         );
   }

}
