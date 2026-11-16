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
public final class LegacyResearchData {

   public static HashMap<String, Object> recipes = new HashMap<>();

   public static void addResearch() {
      ResearchCategories.registerCategory(
         "DYES", ResourceLocation.parse("thaumicdyes:textures/gui/r_td2.png"), ResourceLocation.parse("thaumicdyes:textures/gui/r_tdbg.png")
      );
      researchCrimson();
      researchCrimsonDyed();
      researchEldritch();
      researchIron();
      researchThaumium();
      researchVoid();
      researchBoots();
      researchRunic();
   }

   public static void researchCrimson() {
      ShapedArcaneRecipe recipeFabricResource = LegacyCrafting.arcane("legacyresearchdata_593", "TD.CRIMSON",
         new LegacyStack("ItemHandler.itemResourceFabric"),
         new AspectList().add(Aspect.ENTROPY, 2).add(Aspect.ORDER, 5),
         new Object[]{
            "R",
            "F",
            "V",
            'R',
            new LegacyStack("Items.field_151100_aR", 1, 1),
            'F',
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            'V',
            new LegacyStack("ConfigItems.itemResource", 1, 17)
         }
      );
      ShapedArcaneRecipe recipeCrimsonBoots = LegacyCrafting.arcane("legacyresearchdata_1163", "TD.CRIMSON",
         new LegacyStack("ConfigItems.itemBootsCultist"),
         new AspectList().add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{"R R", "R R", 'R', new LegacyStack("ItemHandler.itemResourceFabric")}
      );
      new LegacyResearch(
            "TD.CRIMSON",
            "DYES",
            new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
            -2,
            -1,
            2,
            new LegacyStack("ConfigItems.itemEldritchObject", 1, 1)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.crimson.1"),
               new LegacyPage("tc.research_page.TD.crimson.2"),
               new LegacyPage("tc.research_page.TD.crimson.3"),
               new LegacyPage(recipeFabricResource),
               new LegacyPage(recipeCrimsonBoots)
            }
         )
         .setParents(new String[]{"CRIMSON", "ENCHFABRIC"})
         .setLost()
         .setSpecial()
         .setRound()
         .setItemTriggers(new LegacyStack[]{new LegacyStack("ConfigItems.itemEldritchObject", 1, 1)})
         .registerResearchItem();
      LegacyCrafting.warp("TD.CRIMSON", 1);
      LegacyStack banner = new LegacyStack("ConfigBlocks.blockWoodenDevice", 1, 8);
      LegacyStack bannerR = new LegacyStack("ConfigBlocks.blockWoodenDevice", 1, 8);
      
      bannerR.data.put("thaumicdyes.banner_color", "14");
      ShapedArcaneRecipe recipeCrimsonBanner = LegacyCrafting.arcane("legacyresearchdata_2740", "TD.CRIMSONBANNER",
         banner,
         new AspectList().add(Aspect.ORDER, 5),
         new Object[]{"g g", "gBg", "g g", 'B', bannerR, 'g', new LegacyStack("Items.field_151074_bl")}
      );
      new LegacyResearch(
            "TD.CRIMSONBANNER",
            "DYES",
            new AspectList().add(Aspect.CLOTH, 2).add(Aspect.SENSES, 1),
            -1,
            -1,
            1,
            new LegacyStack("ConfigBlocks.blockWoodenDevice", 1, 8)
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.crimsonBanner.1"), new LegacyPage(recipeCrimsonBanner)})
         .setParents(new String[]{"TD.CRIMSON", "BANNERS"})
         .setConcealed()
         .setSecondary()
         .registerResearchItem();
      ShapedArcaneRecipe recipeClericHood = LegacyCrafting.arcane("legacyresearchdata_3580", "TD.CRIMSONCLERIC",
         new LegacyStack("ConfigItems.itemHelmetCultistRobe"),
         new AspectList().add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{"RRR", "R R", "   ", 'R', new LegacyStack("ItemHandler.itemResourceFabric")}
      );
      ShapedArcaneRecipe recipeClericChest = LegacyCrafting.arcane("legacyresearchdata_3959", "TD.CRIMSONCLERIC",
         new LegacyStack("ConfigItems.itemChestCultistRobe"),
         new AspectList().add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{"R R", "RRR", "RGR", 'R', new LegacyStack("ItemHandler.itemResourceFabric"), 'G', new LegacyStack("Items.field_151043_k")}
      );
      ShapedArcaneRecipe recipeClericLegs = LegacyCrafting.arcane("legacyresearchdata_4382", "TD.CRIMSONCLERIC",
         new LegacyStack("ConfigItems.itemLegsCultistRobe"),
         new AspectList().add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "RGR",
            "RIR",
            "R R",
            'R',
            new LegacyStack("ItemHandler.itemResourceFabric"),
            'I',
            new LegacyStack("Items.field_151042_j"),
            'G',
            new LegacyStack("Items.field_151043_k")
         }
      );
      new LegacyResearch(
            "TD.CRIMSONCLERIC",
            "DYES",
            new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
            -5,
            -2,
            1,
            new LegacyStack("ConfigItems.itemHelmetCultistRobe")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.crimsonCleric.1"),
               new LegacyPage(recipeClericHood),
               new LegacyPage(recipeClericChest),
               new LegacyPage(recipeClericLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSON"})
         .setConcealed()
         .setLost()
         .setEntityTriggers(new String[]{"thaumcraft:cultist_cleric"})
         .registerResearchItem();
      ShapedArcaneRecipe recipeKnightHelm = LegacyCrafting.arcane("legacyresearchdata_5756", "TD.CRIMSONKNIGHT",
         new LegacyStack("ConfigItems.itemHelmetCultistPlate"),
         new AspectList().add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "III",
            "IGI",
            " R ",
            'R',
            new LegacyStack("ItemHandler.itemResourceFabric"),
            'I',
            new LegacyStack("Items.field_151042_j"),
            'G',
            new LegacyStack("Items.field_151043_k")
         }
      );
      ShapedArcaneRecipe recipeKnightChest = LegacyCrafting.arcane("legacyresearchdata_6346", "TD.CRIMSONKNIGHT",
         new LegacyStack("ConfigItems.itemChestCultistPlate"),
         new AspectList().add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{"I I", "IRI", "IRI", 'R', new LegacyStack("ItemHandler.itemResourceFabric"), 'I', new LegacyStack("Items.field_151042_j")}
      );
      ShapedArcaneRecipe recipeKnightLegs = LegacyCrafting.arcane("legacyresearchdata_6769", "TD.CRIMSONKNIGHT",
         new LegacyStack("ConfigItems.itemLegsCultistPlate"),
         new AspectList().add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "IGI",
            "IRI",
            "I I",
            'R',
            new LegacyStack("ItemHandler.itemResourceFabric"),
            'I',
            new LegacyStack("Items.field_151042_j"),
            'G',
            new LegacyStack("Items.field_151043_k")
         }
      );
      new LegacyResearch(
            "TD.CRIMSONKNIGHT",
            "DYES",
            new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4),
            -5,
            -1,
            1,
            new LegacyStack("ConfigItems.itemHelmetCultistPlate")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.crimsonKnight.1"),
               new LegacyPage(recipeKnightHelm),
               new LegacyPage(recipeKnightChest),
               new LegacyPage(recipeKnightLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSON"})
         .setConcealed()
         .setLost()
         .setEntityTriggers(new String[]{"thaumcraft:cultist_knight"})
         .registerResearchItem();
      InfusionRecipe recipeLeaderHelm = LegacyCrafting.infusion("legacyresearchdata_8140", "TD.CRIMSONLEADER",
         new LegacyStack("ConfigItems.itemHelmetCultistLeaderPlate"),
         3,
         new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 8).add(Aspect.METAL, 8),
         new LegacyStack("ConfigItems.itemHelmetCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("Items.field_151043_k"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("ItemHandler.itemResourceFabric"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("Items.field_151042_j")
         }
      );
      InfusionRecipe recipeLeaderChest = LegacyCrafting.infusion("legacyresearchdata_8865", "TD.CRIMSONLEADER",
         new LegacyStack("ConfigItems.itemChestCultistLeaderPlate"),
         3,
         new AspectList().add(Aspect.ARMOR, 12).add(Aspect.ELDRITCH, 12).add(Aspect.METAL, 8),
         new LegacyStack("ConfigItems.itemChestCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("Items.field_151043_k"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("ItemHandler.itemResourceFabric"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("ItemHandler.itemResourceFabric"),
            new LegacyStack("Items.field_151042_j")
         }
      );
      InfusionRecipe recipeLeaderLegs = LegacyCrafting.infusion("legacyresearchdata_9599", "TD.CRIMSONLEADER",
         new LegacyStack("ConfigItems.itemLegsCultistLeaderPlate"),
         3,
         new AspectList().add(Aspect.ARMOR, 10).add(Aspect.ELDRITCH, 10).add(Aspect.METAL, 8),
         new LegacyStack("ConfigItems.itemLegsCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("Items.field_151043_k"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("ItemHandler.itemResourceFabric"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("ItemHandler.itemResourceFabric"),
            new LegacyStack("Items.field_151042_j")
         }
      );
      new LegacyResearch(
            "TD.CRIMSONLEADER",
            "DYES",
            new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4).add(Aspect.MAGIC, 4),
            -3,
            2,
            2,
            new LegacyStack("ConfigItems.itemHelmetCultistLeaderPlate")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.crimsonLeader.1"),
               new LegacyPage(recipeLeaderHelm),
               new LegacyPage(recipeLeaderChest),
               new LegacyPage(recipeLeaderLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSON", "PRIMPEARL"})
         .setParentsHidden(new String[]{"TD.CRIMSONCLERIC", "TD.CRIMSONKNIGHT", "TD.CRIMSONRANGER", "TD.CRIMSONARCHER"})
         .setConcealed()
         .registerResearchItem();
      ShapedArcaneRecipe recipePaladinHelm = LegacyCrafting.arcane("legacyresearchdata_11197", "TD.PALADIN",
         new LegacyStack("ItemHandler.itemCultistPaladinHelmet"),
         new AspectList().add(Aspect.FIRE, 20).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 25),
         new Object[]{
            " g ",
            "GHG",
            " g ",
            'H',
            new LegacyStack("ConfigItems.itemHelmetCultistLeaderPlate"),
            'g',
            new LegacyStack("Items.field_151074_bl"),
            'G',
            new LegacyStack("Items.field_151043_k")
         }
      );
      new LegacyResearch(
            "TD.PALADIN",
            "DYES",
            new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4),
            -3,
            4,
            1,
            new LegacyStack("ItemHandler.itemCultistPaladinHelmet")
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.paladin.1"), new LegacyPage(recipePaladinHelm)})
         .setParents(new String[]{"TD.CRIMSONLEADER"})
         .setParentsHidden(new String[]{"TD.DYEDPRAETOR"})
         .setConcealed()
         .registerResearchItem();
      ShapedArcaneRecipe recipeRangerHelm = LegacyCrafting.arcane("legacyresearchdata_12380", "TD.CRIMSONRANGER",
         new LegacyStack("ItemHandler.itemCultistRangerHelmet"),
         new AspectList().add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            " I ",
            "IHI",
            " R ",
            'R',
            new LegacyStack("ItemHandler.itemResourceFabric"),
            'H',
            new LegacyStack("Items.field_151028_Y"),
            'I',
            new LegacyStack("Items.field_151042_j")
         }
      );
      ShapedArcaneRecipe recipeRangerChest = LegacyCrafting.arcane("legacyresearchdata_12972", "TD.CRIMSONRANGER",
         new LegacyStack("ItemHandler.itemCultistRangerChest"),
         new AspectList().add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "c",
            "C",
            "R",
            'C',
            new LegacyStack("ConfigItems.itemChestCultistRobe"),
            'c',
            new LegacyStack("Blocks.field_150486_ae"),
            'R',
            new LegacyStack("ItemHandler.itemResourceFabric")
         }
      );
      ShapedArcaneRecipe recipeRangerLegs = LegacyCrafting.arcane("legacyresearchdata_13570", "TD.CRIMSONRANGER",
         new LegacyStack("ItemHandler.itemCultistRangerLegs"),
         new AspectList().add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "sLs",
            "bBb",
            'B',
            new LegacyStack("Items.field_151065_br"),
            'L',
            new LegacyStack("ConfigItems.itemLegsCultistRobe"),
            's',
            new LegacyStack("Items.field_151007_F"),
            'b',
            new LegacyStack("Items.field_151069_bo")
         }
      );
      new LegacyResearch(
            "TD.CRIMSONRANGER",
            "DYES",
            new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
            -4,
            -3,
            1,
            new LegacyStack("ItemHandler.itemCultistRangerChest")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.crimsonRanger.1"),
               new LegacyPage(recipeRangerHelm),
               new LegacyPage(recipeRangerChest),
               new LegacyPage(recipeRangerLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSON"})
         .setParentsHidden(new String[]{"TD.CRIMSONCLERIC"})
         .setConcealed()
         .registerResearchItem();
      ShapedArcaneRecipe recipeArcherHelm = LegacyCrafting.arcane("legacyresearchdata_14972", "TD.CRIMSONARCHER",
         new LegacyStack("ItemHandler.itemCultistArcherHelmet"),
         new AspectList().add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "IHI", " g ", 'g', new LegacyStack("Items.field_151043_k"), 'H', new LegacyStack("Items.field_151028_Y"), 'I', new LegacyStack("Items.field_151042_j")
         }
      );
      ShapedArcaneRecipe recipeArcherChest = LegacyCrafting.arcane("legacyresearchdata_15449", "TD.CRIMSONARCHER",
         new LegacyStack("ItemHandler.itemCultistArcherChest"),
         new AspectList().add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "I I",
            "RIR",
            "IlI",
            'R',
            new LegacyStack("ItemHandler.itemResourceFabric"),
            'C',
            new LegacyStack("ConfigItems.itemChestCultistRobe"),
            'I',
            new LegacyStack("Items.field_151042_j"),
            'l',
            new LegacyStack("Items.field_151116_aA")
         }
      );
      ShapedArcaneRecipe recipeArcherLegs = LegacyCrafting.arcane("legacyresearchdata_16120", "TD.CRIMSONARCHER",
         new LegacyStack("ItemHandler.itemCultistArcherLegs"),
         new AspectList().add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20),
         new Object[]{
            "ILI",
            " R ",
            'R',
            new LegacyStack("ItemHandler.itemResourceFabric"),
            'L',
            new LegacyStack("ConfigItems.itemLegsCultistPlate"),
            'I',
            new LegacyStack("Items.field_151042_j")
         }
      );
      new LegacyResearch(
            "TD.CRIMSONARCHER",
            "DYES",
            new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
            -5,
            0,
            1,
            new LegacyStack("ItemHandler.itemCultistArcherHelmet")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.crimsonArcher.1"),
               new LegacyPage(recipeArcherHelm),
               new LegacyPage(recipeArcherChest),
               new LegacyPage(recipeArcherLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSON"})
         .setParentsHidden(new String[]{"TD.CRIMSONKNIGHT"})
         .setConcealed()
         .registerResearchItem();
   }

   public static void researchCrimsonDyed() {
      InfusionRecipe recipeRobeHelm = LegacyCrafting.infusion("legacyresearchdata_17502", "TD.DYEDROBE",
         new LegacyStack("ItemHandler.itemCultistRobeHelmetDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 8).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 16).add(Aspect.METAL, 8),
         new LegacyStack("ConfigItems.itemHelmetCultistRobe"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7)
         }
      );
      InfusionRecipe recipeRobeChest = LegacyCrafting.infusion("legacyresearchdata_18161", "TD.DYEDROBE",
         new LegacyStack("ItemHandler.itemCultistRobeChestDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 12).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 24).add(Aspect.METAL, 8),
         new LegacyStack("ConfigItems.itemChestCultistRobe"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7)
         }
      );
      InfusionRecipe recipeRobeLegs = LegacyCrafting.infusion("legacyresearchdata_18818", "TD.DYEDROBE",
         new LegacyStack("ItemHandler.itemCultistRobeLegsDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 10).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 20).add(Aspect.METAL, 8),
         new LegacyStack("ConfigItems.itemLegsCultistRobe"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7)
         }
      );
      new LegacyResearch(
            "TD.DYEDROBE",
            "DYES",
            new AspectList().add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
            -7,
            -3,
            2,
            new LegacyStack("ItemHandler.itemCultistRobeHelmetDyed", 0)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.robe.1"),
               new LegacyPage("tc.research_page.TD.robe.2"),
               new LegacyPage(recipeRobeHelm),
               new LegacyPage(recipeRobeChest),
               new LegacyPage(recipeRobeLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSONCLERIC"})
         .setConcealed()
         .setSecondary()
         .registerResearchItem();
      InfusionRecipe recipeKniHelm = LegacyCrafting.infusion("legacyresearchdata_20245", "TD.DYEDKNIGHT",
         new LegacyStack("ItemHandler.itemCultistKnightHelmetDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemHelmetCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeKniChest = LegacyCrafting.infusion("legacyresearchdata_20908", "TD.DYEDKNIGHT",
         new LegacyStack("ItemHandler.itemCultistKnightChestDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemChestCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeKniLegs = LegacyCrafting.infusion("legacyresearchdata_21568", "TD.DYEDKNIGHT",
         new LegacyStack("ItemHandler.itemCultistKnightLegsDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemLegsCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      new LegacyResearch(
            "TD.DYEDKNIGHT",
            "DYES",
            new AspectList().add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
            -7,
            -1,
            2,
            new LegacyStack("ItemHandler.itemCultistKnightChestDyed")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.knight.1"),
               new LegacyPage(recipeKniHelm),
               new LegacyPage(recipeKniChest),
               new LegacyPage(recipeKniLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSONKNIGHT"})
         .setConcealed()
         .setSecondary()
         .registerResearchItem();
      InfusionRecipe recipePraeHelm = LegacyCrafting.infusion("legacyresearchdata_22938", "TD.DYEDPRAETOR",
         new LegacyStack("ItemHandler.itemCultistLeaderHelmetDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemHelmetCultistLeaderPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipePraeChest = LegacyCrafting.infusion("legacyresearchdata_23609", "TD.DYEDPRAETOR",
         new LegacyStack("ItemHandler.itemCultistLeaderChestDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemChestCultistLeaderPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipePraeLegs = LegacyCrafting.infusion("legacyresearchdata_24277", "TD.DYEDPRAETOR",
         new LegacyStack("ItemHandler.itemCultistLeaderLegsDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemLegsCultistLeaderPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      new LegacyResearch(
            "TD.DYEDPRAETOR",
            "DYES",
            new AspectList().add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.DARKNESS, 5),
            -5,
            3,
            3,
            new LegacyStack("ItemHandler.itemCultistLeaderChestDyed")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.praetor.1"),
               new LegacyPage(recipePraeHelm),
               new LegacyPage(recipePraeChest),
               new LegacyPage(recipePraeLegs)
            }
         )
         .setParents(new String[]{"TD.CRIMSONLEADER"})
         .setConcealed()
         .setSecondary()
         .registerResearchItem();
      InfusionRecipe recipeRangerHelmDyed = LegacyCrafting.infusion("legacyresearchdata_25688", "TD.DYEDRANGER",
         new LegacyStack("ItemHandler.itemCultistRangerHelmetDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ItemHandler.itemCultistRangerHelmet"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeRangerChestDyed = LegacyCrafting.infusion("legacyresearchdata_26359", "TD.DYEDRANGER",
         new LegacyStack("ItemHandler.itemCultistRangerChestDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ItemHandler.itemCultistRangerChest"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeRangerLegsDyed = LegacyCrafting.infusion("legacyresearchdata_27028", "TD.DYEDRANGER",
         new LegacyStack("ItemHandler.itemCultistRangerLegsDyed"),
         3,
         new AspectList().add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ItemHandler.itemCultistRangerLegs"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeRangerHelmGoggles = LegacyCrafting.infusion("legacyresearchdata_27698", "TD.DYEDRANGER",
         new Object[]{"mask", Integer.valueOf(0)},
         3,
         new AspectList().add(Aspect.SENSES, 16).add(Aspect.AURA, 8).add(Aspect.ARMOR, 8),
         new LegacyStack("ItemHandler.itemCultistRangerHelmetDyed", 1, 32767),
         new LegacyStack[]{new LegacyStack("Items.field_151123_aH"), new LegacyStack("ConfigItems.itemGoggles", 1, 32767)}
      );
      InfusionRecipe recipeRangerHelmPlate = LegacyCrafting.infusion("legacyresearchdata_28175", "TD.DYEDRANGER",
         new Object[]{"mask", Integer.valueOf(1)},
         2,
         new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8),
         new LegacyStack("ItemHandler.itemCultistRangerHelmetDyed", 1, 32767),
         new LegacyStack[]{new LegacyStack("Items.field_151123_aH"), new LegacyStack("ConfigItems.itemResource", 1, 2)}
      );
      new LegacyResearch(
            "TD.DYEDRANGER",
            "DYES",
            new AspectList().add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4).add(Aspect.TRAVEL, 4),
            -5,
            -5,
            2,
            new LegacyStack("ItemHandler.itemCultistRangerChestDyed")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.ranger.1"),
               new LegacyPage(recipeRangerHelmDyed),
               new LegacyPage(recipeRangerChestDyed),
               new LegacyPage(recipeRangerLegsDyed),
               new LegacyPage("tc.research_page.TD.ranger.2"),
               new LegacyPage(recipeRangerHelmGoggles),
               new LegacyPage(recipeRangerHelmPlate)
            }
         )
         .setParents(new String[]{"TD.CRIMSONRANGER"})
         .setConcealed()
         .setSecondary()
         .registerResearchItem();
      InfusionRecipe recipeArcherHelmDyed = LegacyCrafting.infusion("legacyresearchdata_29553", "TD.DYEDARCHER",
         new LegacyStack("ItemHandler.itemCultistArcherHelmetDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ItemHandler.itemCultistArcherHelmet"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeArcherChestDyed = LegacyCrafting.infusion("legacyresearchdata_30224", "TD.DYEDARCHER",
         new LegacyStack("ItemHandler.itemCultistArcherChestDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ItemHandler.itemCultistArcherChest"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeArcherLegsDyed = LegacyCrafting.infusion("legacyresearchdata_30892", "TD.DYEDARCHER",
         new LegacyStack("ItemHandler.itemCultistArcherLegsDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ItemHandler.itemCultistArcherLegs"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      new LegacyResearch(
            "TD.DYEDARCHER",
            "DYES",
            new AspectList().add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.WEAPON, 5),
            -7,
            1,
            2,
            new LegacyStack("ItemHandler.itemCultistArcherHelmetDyed")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.archer.1"),
               new LegacyPage(recipeArcherHelmDyed),
               new LegacyPage(recipeArcherChestDyed),
               new LegacyPage(recipeArcherLegsDyed)
            }
         )
         .setParents(new String[]{"TD.CRIMSONARCHER"})
         .setConcealed()
         .setSecondary()
         .registerResearchItem();
      ShapedArcaneRecipe recipeSunKniHelm = LegacyCrafting.arcane("legacyresearchdata_32349", "TD.SUNNYD",
         new LegacyStack("ItemHandler.itemSunKnightHelmet"),
         new AspectList().add(Aspect.FIRE, 20).add(Aspect.AIR, 20),
         new Object[]{
            " g ",
            "nHn",
            " g ",
            'H',
            new LegacyStack("ItemHandler.itemCultistKnightHelmetDyed"),
            'g',
            new LegacyStack("Items.field_151100_aR", 1, 8),
            'n',
            TcIngredient.tag("c:nuggets/iron")
         }
      );
      ShapedArcaneRecipe recipeSunKniChest = LegacyCrafting.arcane("legacyresearchdata_32892", "TD.SUNNYD",
         new LegacyStack("ItemHandler.itemSunKnightChest"),
         new AspectList().add(Aspect.FIRE, 20).add(Aspect.AIR, 20),
         new Object[]{
            "nrn",
            "rCr",
            "nyn",
            'C',
            new LegacyStack("ItemHandler.itemCultistKnightChestDyed"),
            'r',
            new LegacyStack("Items.field_151100_aR", 1, 1),
            'y',
            new LegacyStack("Items.field_151100_aR", 1, 11),
            'n',
            TcIngredient.tag("c:nuggets/iron")
         }
      );
      new LegacyResearch(
            "TD.SUNNYD",
            "DYES",
            new AspectList().add(Aspect.FIRE, 4).add(Aspect.ARMOR, 4).add(Aspect.AURA, 4),
            0,
            -3,
            1,
            new LegacyStack("ItemHandler.itemSunKnightChest")
         )
         .setPages(
            new LegacyPage[]{new LegacyPage("tc.research_page.TD.sunnyD.1"), new LegacyPage(recipeSunKniHelm), new LegacyPage(recipeSunKniChest)}
         )
         .setParentsHidden(new String[]{"TD.DYEDKNIGHT"})
         .setConcealed()
         .registerResearchItem();
   }

   public static void researchEldritch() {
      new LinkedResearch("TD.OUTERARRIVAL", "DYES", "ENTEROUTER", "ELDRITCH", -2, 6, ResearchCategories.getResearch("ENTEROUTER").iconTexture())
         .registerResearchItem();
      InfusionRecipe recipeHuskHelm = LegacyCrafting.infusion("legacyresearchdata_34270", "TD.INHABITEDPLATE",
         new LegacyStack("ItemHandler.itemInhabitedPlateHelmet"),
         3,
         new AspectList().add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 16).add(Aspect.METAL, 16).add(Aspect.ARMOR, 16),
         new LegacyStack("ConfigItems.itemHelmetCultistPlate"),
         new LegacyStack[]{new LegacyStack("ConfigItems.itemShard", 1, 5), new LegacyStack("Items.field_151042_j"), new LegacyStack("ConfigItems.itemResource", 1, 17)}
      );
      InfusionRecipe recipeHuskChest = LegacyCrafting.infusion("legacyresearchdata_34819", "TD.INHABITEDPLATE",
         new LegacyStack("ItemHandler.itemInhabitedPlateChest"),
         3,
         new AspectList().add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 24).add(Aspect.METAL, 24).add(Aspect.ARMOR, 24),
         new LegacyStack("ConfigItems.itemChestCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemShard", 1, 5),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("ConfigItems.itemResource", 1, 17),
            new LegacyStack("ConfigItems.itemResource", 1, 17)
         }
      );
      InfusionRecipe recipeHuskLegs = LegacyCrafting.infusion("legacyresearchdata_35529", "TD.INHABITEDPLATE",
         new LegacyStack("ItemHandler.itemInhabitedPlateLegs"),
         3,
         new AspectList().add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 20).add(Aspect.METAL, 20).add(Aspect.ARMOR, 20),
         new LegacyStack("ConfigItems.itemLegsCultistPlate"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemShard", 1, 5),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("Items.field_151042_j"),
            new LegacyStack("ConfigItems.itemResource", 1, 17)
         }
      );
      new LegacyResearch(
            "TD.INHABITEDPLATE",
            "DYES",
            new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 4).add(Aspect.ELDRITCH, 4),
            -4,
            6,
            2,
            new LegacyStack("ItemHandler.itemInhabitedPlateHelmet", 0)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.husk.1"),
               new LegacyPage("tc.research_page.TD.husk.2"),
               new LegacyPage(recipeHuskHelm),
               new LegacyPage(recipeHuskChest),
               new LegacyPage(recipeHuskLegs)
            }
         )
         .setParents(new String[]{"TD.OUTERARRIVAL"})
         .registerResearchItem();
      LegacyCrafting.warp("TD.INHABITEDPLATE", 2);
      ShapedArcaneRecipe recipeMaskEvil = LegacyCrafting.arcane("legacyresearchdata_37017", "TD.MASKEVIL",
         new LegacyStack("ItemHandler.itemHelmetMaskTX"),
         new AspectList().add(Aspect.ENTROPY, 60).add(Aspect.FIRE, 40).add(Aspect.AIR, 40),
         new Object[]{
            "LVL",
            "L L",
            "EVE",
            'E',
            new LegacyStack("ConfigItems.itemEldritchObject", 1, 0),
            'V',
            new LegacyStack("ConfigItems.itemResource", 1, 16),
            'L',
            new LegacyStack("Items.field_151116_aA")
         }
      );
      new LegacyResearch(
            "TD.MASKEVIL",
            "DYES",
            new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.WEAPON, 4).add(Aspect.ELDRITCH, 4),
            0,
            7,
            2,
            new LegacyStack("ItemHandler.itemHelmetMaskTX", 0)
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.maskEvil.1"), new LegacyPage(recipeMaskEvil)})
         .setParents(new String[]{"VOIDMETAL"})
         .registerResearchItem();
      LegacyCrafting.warp("TD.MASKEVIL", 2);
   }

   public static void researchIron() {
      InfusionRecipe recipeIronFortHelm = LegacyCrafting.infusion("legacyresearchdata_38160", "TD.IRONFORTRESS",
         new LegacyStack("ItemHandler.itemIronFortressHelmet"),
         1,
         new AspectList().add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8),
         new LegacyStack("Items.field_151028_Y", 0),
         new LegacyStack[]{
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151043_k", 0),
            new LegacyStack("Items.field_151045_i", 0)
         }
      );
      InfusionRecipe recipeIronFortChest = LegacyCrafting.infusion("legacyresearchdata_38818", "TD.IRONFORTRESS",
         new LegacyStack("ItemHandler.itemIronFortressChest"),
         1,
         new AspectList().add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8),
         new LegacyStack("Items.field_151030_Z", 0),
         new LegacyStack[]{
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151043_k", 0),
            new LegacyStack("Items.field_151116_aA", 0)
         }
      );
      InfusionRecipe recipeIronFortLegs = LegacyCrafting.infusion("legacyresearchdata_39531", "TD.IRONFORTRESS",
         new LegacyStack("ItemHandler.itemIronFortressLegs"),
         1,
         new AspectList().add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8),
         new LegacyStack("Items.field_151165_aa", 0),
         new LegacyStack[]{
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151042_j", 0),
            new LegacyStack("Items.field_151043_k", 0),
            new LegacyStack("Items.field_151116_aA", 0)
         }
      );
      new LegacyResearch(
            "TD.IRONFORTRESS",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 5).add(Aspect.METAL, 5).add(Aspect.CRAFT, 5),
            9,
            -1,
            2,
            new LegacyStack("ItemHandler.itemIronFortressHelmet", 0)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.ironFortress.1"),
               new LegacyPage("tc.research_page.TD.ironFortress.2"),
               new LegacyPage(recipeIronFortHelm),
               new LegacyPage(recipeIronFortChest),
               new LegacyPage(recipeIronFortLegs)
            }
         )
         .setParents(new String[]{"TD.ARMORFORTRESS"})
         .setSecondary()
         .registerResearchItem();
      InfusionRecipe recipeIronFortHelmGoggles = LegacyCrafting.infusion("legacyresearchdata_40971", "TD.IRONHELMGOGGLES",
         new Object[]{"goggles", Integer.valueOf(1)},
         5,
         new AspectList().add(Aspect.SENSES, 32).add(Aspect.AURA, 16).add(Aspect.ARMOR, 16),
         new LegacyStack("ItemHandler.itemIronFortressHelmet", 1, 32767),
         new LegacyStack[]{new LegacyStack("Items.field_151123_aH"), new LegacyStack("ConfigItems.itemGoggles", 1, 32767)}
      );
      InfusionRecipe recipeIronFortHelmKnight = LegacyCrafting.infusion("legacyresearchdata_41456", "TD.IRONHELMAESTHETICS",
         new Object[]{"mask", Integer.valueOf(0)},
         2,
         new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8),
         new LegacyStack("ItemHandler.itemIronFortressHelmet", 1, 32767),
         new LegacyStack[]{new LegacyStack("Items.field_151123_aH"), new LegacyStack("ConfigItems.itemHelmetCultistPlate", 32767)}
      );
      InfusionRecipe recipeIronFortHelmPraetor = LegacyCrafting.infusion("legacyresearchdata_41926", "TD.IRONHELMAESTHETICS",
         new Object[]{"mask", Integer.valueOf(1)},
         2,
         new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8),
         new LegacyStack("ItemHandler.itemIronFortressHelmet", 1, 32767),
         new LegacyStack[]{new LegacyStack("Items.field_151123_aH"), new LegacyStack("ConfigItems.itemHelmetCultistLeaderPlate", 32767)}
      );
      new LegacyResearch(
            "TD.IRONHELMGOGGLES",
            "DYES",
            new AspectList().add(Aspect.SENSES, 5).add(Aspect.AURA, 3).add(Aspect.ARMOR, 3),
            11,
            -1,
            1,
            new LegacyStack("ConfigItems.itemGoggles")
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.ironHelmGoggles.1"), new LegacyPage(recipeIronFortHelmGoggles)})
         .setParents(new String[]{"TD.IRONFORTRESS", "GOGGLES"})
         .setSecondary()
         .setConcealed()
         .registerResearchItem();
      new LegacyResearch(
            "TD.IRONHELMAESTHETICS",
            "DYES",
            new AspectList().add(Aspect.CRAFT, 5).add(Aspect.ARMOR, 3),
            11,
            0,
            1,
            new LegacyStack("ConfigItems.itemHelmetCultistPlate")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.ironHelmFace.1"), new LegacyPage(recipeIronFortHelmKnight), new LegacyPage(recipeIronFortHelmPraetor)
            }
         )
         .setParents(new String[]{"TD.IRONFORTRESS"})
         .setSecondary()
         .setConcealed()
         .registerResearchItem();
      InfusionRecipe recipeIronFortHelmHusk = LegacyCrafting.infusion("legacyresearchdata_43615", "TD.IRONHELMHUSK",
         new Object[]{"mask", Integer.valueOf(2)},
         2,
         new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 4).add(Aspect.EXCHANGE, 4),
         new LegacyStack("ItemHandler.itemIronFortressHelmet", 1, 32767),
         new LegacyStack[]{new LegacyStack("Items.field_151123_aH"), new LegacyStack("ItemHandler.itemInhabitedPlateHelmet", 0)}
      );
      new LegacyResearch(
            "TD.IRONHELMHUSK",
            "DYES",
            new AspectList().add(Aspect.CRAFT, 5).add(Aspect.ARMOR, 3).add(Aspect.ELDRITCH, 2),
            10,
            1,
            1,
            new LegacyStack("ItemHandler.itemInhabitedPlateHelmet")
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.ironHelmFace.2"), new LegacyPage(recipeIronFortHelmHusk)})
         .setParents(new String[]{"TD.IRONFORTRESS"})
         .setParentsHidden(new String[]{"TD.INHABITEDPLATE", "TD.IRONHELMAESTHETICS"})
         .setSecondary()
         .setConcealed()
         .registerResearchItem();
   }

   public static void researchThaumium() {
      new LinkedResearch("TD.THAUMIUM", "DYES", "THAUMIUM", "ALCHEMY", 2, -1, ResearchCategories.getResearch("THAUMIUM").iconItem()).registerResearchItem();
      new LinkedResearch("TD.ARMORFORTRESS", "DYES", "ARMORFORTRESS", "ARTIFICE", 7, -2, ResearchCategories.getResearch("ARMORFORTRESS").iconItem())
         .registerResearchItem();
      InfusionRecipe recipeFortHelm = LegacyCrafting.infusion("legacyresearchdata_45157", "TD.DYEDFORTRESS",
         new LegacyStack("ItemHandler.itemFortressHelmetDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemHelmetFortress"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeFortChest = LegacyCrafting.infusion("legacyresearchdata_45814", "TD.DYEDFORTRESS",
         new LegacyStack("ItemHandler.itemFortressChestDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemChestFortress"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      InfusionRecipe recipeFortLegs = LegacyCrafting.infusion("legacyresearchdata_46468", "TD.DYEDFORTRESS",
         new LegacyStack("ItemHandler.itemFortressLegsDyed"),
         5,
         new AspectList().add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
         new LegacyStack("ConfigItems.itemLegsFortress"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 2)
         }
      );
      new LegacyResearch(
            "TD.DYEDFORTRESS",
            "DYES",
            new AspectList().add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5),
            5,
            -2,
            2,
            new LegacyStack("ItemHandler.itemFortressHelmetDyed", 0)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.fortress.1"),
               new LegacyPage(recipeFortHelm),
               new LegacyPage(recipeFortChest),
               new LegacyPage(recipeFortLegs)
            }
         )
         .setParents(new String[]{"TD.THAUMIUM", "TD.ARMORFORTRESS"})
         .setConcealed()
         .registerResearchItem();
      InfusionRecipe recipeThaumRobeHelm = LegacyCrafting.infusion("legacyresearchdata_47831", "TD.THAUMIUMROBE",
         new LegacyStack("ItemHandler.itemThaumiumRobeHelmetDyed"),
         4,
         new AspectList().add(Aspect.METAL, 16).add(Aspect.SENSES, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16),
         new LegacyStack("ConfigItems.itemHelmetThaumium"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemGoggles"),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 7)
         }
      );
      InfusionRecipe recipeThaumRobeChest = LegacyCrafting.infusion("legacyresearchdata_48641", "TD.THAUMIUMROBE",
         new LegacyStack("ItemHandler.itemThaumiumRobeChestDyed"),
         4,
         new AspectList().add(Aspect.METAL, 24).add(Aspect.ARMOR, 24).add(Aspect.CLOTH, 24).add(Aspect.MAGIC, 16),
         new LegacyStack("ConfigItems.itemChestThaumium"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemChestRobe"),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("Items.field_151116_aA")
         }
      );
      InfusionRecipe recipeThaumRobeLegs = LegacyCrafting.infusion("legacyresearchdata_49418", "TD.THAUMIUMROBE",
         new LegacyStack("ItemHandler.itemThaumiumRobeLegsDyed"),
         4,
         new AspectList().add(Aspect.METAL, 20).add(Aspect.ARMOR, 20).add(Aspect.CLOTH, 20).add(Aspect.MAGIC, 16),
         new LegacyStack("ConfigItems.itemLegsThaumium"),
         new LegacyStack[]{
            new LegacyStack("ConfigItems.itemLegsRobe"),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("Items.field_151116_aA")
         }
      );
      new LegacyResearch(
            "TD.THAUMIUMROBE",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.CRAFT, 5),
            3,
            -4,
            2,
            new LegacyStack("ItemHandler.itemThaumiumRobeChestDyed", 0)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.thaumrobe.1"),
               new LegacyPage(recipeThaumRobeHelm),
               new LegacyPage(recipeThaumRobeChest),
               new LegacyPage(recipeThaumRobeLegs)
            }
         )
         .setParents(new String[]{"TD.THAUMIUM", "GOGGLES", "ENCHFABRIC"})
         .registerResearchItem();
   }

   public static void researchVoid() {
      new LinkedResearch("TD.VOIDFORTRESS", "DYES", "ARMORVOIDFORTRESS", "ELDRITCH", 2, 6, ResearchCategories.getResearch("ARMORVOIDFORTRESS").iconItem())
         .registerResearchItem();
      CrucibleRecipe recipeVoidRobeHelm = LegacyCrafting.crucible("legacyresearchdata_51227", "TD.VOIDROBE",
         new LegacyStack("ItemHandler.itemVoidRobeHelmetDyed"),
         new LegacyStack("ConfigItems.itemHelmetVoidRobe"),
         new AspectList().add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8)
      );
      CrucibleRecipe recipeVoidRobeChest = LegacyCrafting.crucible("legacyresearchdata_51554", "TD.VOIDROBE",
         new LegacyStack("ItemHandler.itemVoidRobeChestDyed"),
         new LegacyStack("ConfigItems.itemChestVoidRobe"),
         new AspectList().add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8)
      );
      CrucibleRecipe recipeVoidRobeLegs = LegacyCrafting.crucible("legacyresearchdata_51878", "TD.VOIDROBE",
         new LegacyStack("ItemHandler.itemVoidRobeLegsDyed"),
         new LegacyStack("ConfigItems.itemLegsVoidRobe"),
         new AspectList().add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8)
      );
      new LegacyResearch(
            "TD.VOIDROBE",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 5).add(Aspect.METAL, 5).add(Aspect.CRAFT, 5),
            4,
            6,
            2,
            new LegacyStack("ItemHandler.itemVoidRobeHelmetDyed", 0)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.voidrobe.1"),
               new LegacyPage(recipeVoidRobeHelm),
               new LegacyPage(recipeVoidRobeChest),
               new LegacyPage(recipeVoidRobeLegs)
            }
         )
         .setParents(new String[]{"TD.VOIDFORTRESS"})
         .setSecondary()
         .setConcealed()
         .registerResearchItem();
   }

   public static void researchBoots() {
      new LinkedResearch("TD.BOOTSTRAVELLER", "DYES", "BOOTSTRAVELLER", "ARTIFICE", 4, 2, ResearchCategories.getResearch("BOOTSTRAVELLER").iconItem())
         .registerResearchItem();
      InfusionRecipe recipeThaumBoots = LegacyCrafting.infusion("legacyresearchdata_53054", "TD.THAUMIUMBOOTS",
         new LegacyStack("ItemHandler.itemThaumiumBootsTraveller"),
         4,
         new AspectList().add(Aspect.METAL, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16).add(Aspect.TRAVEL, 8),
         new LegacyStack("ConfigItems.itemBootsTraveller"),
         new LegacyStack[]{
            new LegacyStack("Items.field_151116_aA"),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 7)
         }
      );
      new LegacyResearch(
            "TD.THAUMIUMBOOTS",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.TRAVEL, 5),
            2,
            1,
            2,
            new LegacyStack("ItemHandler.itemThaumiumBootsTraveller", 0)
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.thaumboots.1"), new LegacyPage(recipeThaumBoots)})
         .setParents(new String[]{"TD.THAUMIUM", "TD.BOOTSTRAVELLER"})
         .setConcealed()
         .registerResearchItem();
      InfusionRecipe recipeVoidBoots = LegacyCrafting.infusion("legacyresearchdata_54411", "TD.VOIDBOOTS",
         new LegacyStack("ItemHandler.itemVoidBootsTraveller"),
         4,
         new AspectList()
            .add(Aspect.METAL, 16)
            .add(Aspect.ARMOR, 16)
            .add(Aspect.CLOTH, 16)
            .add(Aspect.MAGIC, 16)
            .add(Aspect.TRAVEL, 8)
            .add(Aspect.ELDRITCH, 16)
            .add(Aspect.VOID, 8),
         new LegacyStack("ConfigItems.itemBootsTraveller"),
         new LegacyStack[]{
            new LegacyStack("Items.field_151116_aA"),
            new LegacyStack("ConfigItems.itemResource", 1, 16),
            new LegacyStack("ConfigItems.itemResource", 1, 2),
            new LegacyStack("ConfigItems.itemResource", 1, 14),
            new LegacyStack("ConfigItems.itemResource", 1, 7),
            new LegacyStack("ConfigItems.itemResource", 1, 7)
         }
      );
      new LegacyResearch(
            "TD.VOIDBOOTS",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.TRAVEL, 5).add(Aspect.ELDRITCH, 5),
            2,
            4,
            2,
            new LegacyStack("ItemHandler.itemVoidBootsTraveller", 0)
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.voidboots.1"), new LegacyPage(recipeVoidBoots)})
         .setParents(new String[]{"TD.VOIDFORTRESS", "TD.BOOTSTRAVELLER"})
         .setConcealed()
         .registerResearchItem();
   }

   public static void researchRunic() {
      new LegacyResearch(
            "TD.RUNICARMOR",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 8).add(Aspect.AIR, 5).add(Aspect.MAGIC, 5).add(Aspect.ENERGY, 5).add(Aspect.MIND, 3),
            8,
            3,
            3,
            new LegacyStack("ItemHandler.itemRunicChest")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.RUNICARMOR.1"),
               new LegacyPage("tc.research_page.TD.RUNICARMOR.2"),
               new LegacyPage((InfusionRecipe)recipes.get("RunicArmorHelm")),
               new LegacyPage((InfusionRecipe)recipes.get("RunicArmorChest")),
               new LegacyPage((InfusionRecipe)recipes.get("RunicArmorLegs")),
               new LegacyPage((InfusionRecipe)recipes.get("RunicArmorBoots"))
            }
         )
         .setParents(new String[]{"INFUSION", "RUNICARMOR"})
         .setConcealed()
         .setSpecial()
         .registerResearchItem();
      new LegacyResearch(
            "TD.RUNICGOGGLES",
            "DYES",
            new AspectList().add(Aspect.SENSES, 8).add(Aspect.MAGIC, 5).add(Aspect.ARMOR, 5).add(Aspect.AURA, 3),
            7,
            1,
            2,
            new LegacyStack("ItemHandler.itemRunicGoggles")
         )
         .setPages(new LegacyPage[]{new LegacyPage("tc.research_page.TD.RUNICGOGGLES.1"), new LegacyPage((InfusionRecipe)recipes.get("RunicGoggles"))})
         .setParents(new String[]{"GOGGLES", "TD.RUNICARMOR"})
         .setSecondary()
         .setConcealed()
         .registerResearchItem();
      new LegacyResearch(
            "TD.RUNICBOOTSTRAVELLER",
            "DYES",
            new AspectList().add(Aspect.TRAVEL, 8).add(Aspect.WATER, 5).add(Aspect.ARMOR, 5).add(Aspect.FLIGHT, 5),
            5,
            2,
            2,
            new LegacyStack("ItemHandler.itemRunicBootsTraveller")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.RUNICBOOTSTRAVELLER.1"), new LegacyPage((InfusionRecipe)recipes.get("RunicBootsTraveller"))
            }
         )
         .setParents(new String[]{"TD.BOOTSTRAVELLER", "TD.RUNICARMOR"})
         .setSecondary()
         .setConcealed()
         .registerResearchItem();
      ArrayList<InfusionRecipe> rc1 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc2 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc3 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc4 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc5 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc6 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc7 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc8 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc9 = new ArrayList<>();
      ArrayList<InfusionRecipe> rc10 = new ArrayList<>();

      for (int a = 0; a <= 3; a++) {
         rc1.add((InfusionRecipe)recipes.get("RAU1_" + a));
         rc2.add((InfusionRecipe)recipes.get("RAU2_" + a));
         rc3.add((InfusionRecipe)recipes.get("RAU3_" + a));
         rc4.add((InfusionRecipe)recipes.get("RAU4_" + a));
         rc5.add((InfusionRecipe)recipes.get("RAU5_" + a));
         rc6.add((InfusionRecipe)recipes.get("RAU6_" + a));
         rc7.add((InfusionRecipe)recipes.get("RAU7_" + a));
         rc8.add((InfusionRecipe)recipes.get("RAU8_" + a));
         rc9.add((InfusionRecipe)recipes.get("RAU9_3"));
         rc10.add((InfusionRecipe)recipes.get("RAU10_" + a));
      }

      new LegacyResearch(
            "TD.RUNICARMORUPGRADES",
            "DYES",
            new AspectList().add(Aspect.MAGIC, 8).add(Aspect.ARMOR, 5).add(Aspect.ORDER, 5).add(Aspect.MIND, 3),
            7,
            4,
            3,
            ResourceLocation.parse("thaumcraft:textures/misc/r_runicupg.png")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.1"),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.2"),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a1"),
               new LegacyPage(rc1.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a2"),
               new LegacyPage(rc2.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a3"),
               new LegacyPage(rc3.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a4"),
               new LegacyPage(rc4.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a5"),
               new LegacyPage(rc5.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a6"),
               new LegacyPage(rc6.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a7"),
               new LegacyPage(rc7.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a8"),
               new LegacyPage(rc8.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a9"),
               new LegacyPage(rc9.toArray(new InfusionRecipe[0])),
               new LegacyPage("tc.research_page.TD.RUNICARMORUPGRADES.a10"),
               new LegacyPage(rc10.toArray(new InfusionRecipe[0]))
            }
         )
         .setParents(new String[]{"TD.RUNICARMOR"})
         .setParentsHidden(new String[]{"RUNICHEALING", "RUNICKINETIC", "RUNICEMERGENCY"})
         .setSecondary()
         .setConcealed()
         .registerResearchItem();
      ArrayList<InfusionRecipe> enhR = new ArrayList<>();

      for (int a = 0; a <= 3; a++) {
         enhR.add((InfusionRecipe)recipes.get("EnhRunicArmor" + a));
      }

      new LegacyResearch(
            "TD.ENHANCEDRUNICARMOR",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 8).add(Aspect.AIR, 5).add(Aspect.MAGIC, 5).add(Aspect.ENERGY, 5).add(Aspect.MIND, 3),
            10,
            3,
            3,
            new LegacyStack("ItemHandler.itemRunicChestEnhanced")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.ENHANCEDRUNICARMOR.1"),
               new LegacyPage("tc.research_page.TD.ENHANCEDRUNICARMOR.2"),
               new LegacyPage(enhR.toArray(new InfusionRecipe[0]))
            }
         )
         .setParents(new String[]{"TD.RUNICARMOR"})
         .setParentsHidden(new String[]{"TD.RUNICARMORUPGRADES"})
         .setConcealed()
         .registerResearchItem();
      ArrayList<InfusionRecipe> prmR = new ArrayList<>();

      for (int a = 0; a <= 3; a++) {
         prmR.add((InfusionRecipe)recipes.get("PrmRunicArmor" + a));
      }

      new LegacyResearch(
            "TD.PRIMALRUNICARMOR",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 12).add(Aspect.MAGIC, 12).add(Aspect.DARKNESS, 10).add(Aspect.SOUL, 8),
            11,
            6,
            3,
            new LegacyStack("ItemHandler.itemRunicChestPrimal")
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.PRIMALRUNICARMOR.1"),
               new LegacyPage("tc.research_page.TD.PRIMALRUNICARMOR.2"),
               new LegacyPage("tc.research_page.TD.PRIMALRUNICARMOR.3"),
               new LegacyPage(prmR.toArray(new InfusionRecipe[0]))
            }
         )
         .setParents(new String[]{"TD.ENHANCEDRUNICARMOR"})
         .setParentsHidden(new String[]{"PRIMPEARL"})
         .setConcealed()
         .registerResearchItem();
      LegacyCrafting.warp("TD.PRIMALRUNICARMOR", 4);
      new LegacyResearch(
            "TD.PRIMALRUNIC",
            "DYES",
            new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 12).add(Aspect.MAGIC, 12).add(Aspect.DARKNESS, 10).add(Aspect.SOUL, 8),
            12,
            6,
            1,
            new LegacyStack("ConfigItems.itemEldritchObject", 1, 0)
         )
         .setPages(
            new LegacyPage[]{
               new LegacyPage("tc.research_page.TD.PRIMALRUNIC.1"),
               new LegacyPage("tc.research_page.TD.PRIMALRUNIC.2"),
               new LegacyPage("tc.research_page.TD.PRIMALRUNIC.3"),
               new LegacyPage("tc.research_page.TD.PRIMALRUNIC.4")
            }
         )
         .setParents(new String[]{"TD.PRIMALRUNICARMOR"})
         .setConcealed()
         .registerResearchItem();
   }

}
