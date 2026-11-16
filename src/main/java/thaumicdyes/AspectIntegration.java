package thaumicdyes;

import thaumcraft.aspect.Aspect;
import thaumcraft.aspect.AspectList;
import thaumcraft.aspect.AspectSync;

public final class AspectIntegration {
    private AspectIntegration() {}

    public static void register() {
        // Documented reload hook: direct edits of the active registry would be lost.
        AspectSync.addRegistrar(registry -> {
            registry.register(Content.all().get("cultist_paladin_helm").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.GREED, 3).add(Aspect.ELDRITCH, 2));
            registry.register(Content.all().get("cultist_ranger_helm").get(), new AspectList().add(Aspect.METAL, 3).add(Aspect.CLOTH, 2).add(Aspect.ELDRITCH, 1).add(Aspect.TRAVEL, 1));
            registry.register(Content.all().get("cultist_ranger_chest").get(), new AspectList().add(Aspect.METAL, 3).add(Aspect.CLOTH, 2).add(Aspect.ELDRITCH, 1).add(Aspect.TRAVEL, 1));
            registry.register(Content.all().get("cultist_ranger_legs").get(), new AspectList().add(Aspect.METAL, 3).add(Aspect.CLOTH, 2).add(Aspect.ELDRITCH, 1).add(Aspect.TRAVEL, 1));
            registry.register(Content.all().get("cultist_archer_helm").get(), new AspectList().add(Aspect.METAL, 5).add(Aspect.ELDRITCH, 1).add(Aspect.WEAPON, 1));
            registry.register(Content.all().get("cultist_archer_chest").get(), new AspectList().add(Aspect.METAL, 5).add(Aspect.ELDRITCH, 1).add(Aspect.WEAPON, 1));
            registry.register(Content.all().get("cultist_archer_legs").get(), new AspectList().add(Aspect.METAL, 5).add(Aspect.ELDRITCH, 1).add(Aspect.WEAPON, 1));
            registry.register(Content.all().get("cultist_robe_helm").get(), new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.MAGIC, 2));
            registry.register(Content.all().get("cultist_robe_chest").get(), new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.MAGIC, 2));
            registry.register(Content.all().get("cultist_robe_legs").get(), new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.MAGIC, 2));
            registry.register(Content.all().get("cultist_plate_helm").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1));
            registry.register(Content.all().get("cultist_plate_chest").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1));
            registry.register(Content.all().get("cultist_plate_legs").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1));
            registry.register(Content.all().get("cultist_leader_helm").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 1));
            registry.register(Content.all().get("cultist_leader_chest").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 1));
            registry.register(Content.all().get("cultist_leader_legs").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 1));
            registry.register(Content.all().get("cultist_ranger_helm_dyed").get(), new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.TRAVEL, 1));
            registry.register(Content.all().get("cultist_ranger_chest_dyed").get(), new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.TRAVEL, 1));
            registry.register(Content.all().get("cultist_ranger_legs_dyed").get(), new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.TRAVEL, 1));
            registry.register(Content.all().get("cultist_archer_helm_dyed").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.WEAPON, 1));
            registry.register(Content.all().get("cultist_archer_chest_dyed").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.WEAPON, 1));
            registry.register(Content.all().get("cultist_archer_legs_dyed").get(), new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.WEAPON, 1));
            registry.register(Content.all().get("inhabited_plate_helm").get(), new AspectList().add(Aspect.METAL, 5).add(Aspect.UNDEAD, 1).add(Aspect.ELDRITCH, 4).add(Aspect.ENTROPY, 2));
            registry.register(Content.all().get("inhabited_plate_chest").get(), new AspectList().add(Aspect.METAL, 5).add(Aspect.UNDEAD, 1).add(Aspect.ELDRITCH, 4).add(Aspect.ENTROPY, 2));
            registry.register(Content.all().get("inhabited_plate_legs").get(), new AspectList().add(Aspect.METAL, 5).add(Aspect.UNDEAD, 1).add(Aspect.ELDRITCH, 4).add(Aspect.ENTROPY, 2));
            registry.register(Content.all().get("item_runic_helmet").get(), new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 5).add(Aspect.VOID, 4));
            registry.register(Content.all().get("item_runic_chest").get(), new AspectList().add(Aspect.ARMOR, 12).add(Aspect.ENERGY, 36).add(Aspect.MAGIC, 24).add(Aspect.GREED, 5).add(Aspect.VOID, 4));
            registry.register(Content.all().get("item_runic_legs").get(), new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ENERGY, 24).add(Aspect.MAGIC, 16).add(Aspect.GREED, 5).add(Aspect.VOID, 4));
            registry.register(Content.all().get("item_runic_boots").get(), new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 5).add(Aspect.VOID, 4));
            registry.register(Content.all().get("item_runic_helmet_enhanced").get(), new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6));
            registry.register(Content.all().get("item_runic_chest_enhanced").get(), new AspectList().add(Aspect.ARMOR, 12).add(Aspect.ENERGY, 36).add(Aspect.MAGIC, 24).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6));
            registry.register(Content.all().get("item_runic_legs_enhanced").get(), new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ENERGY, 24).add(Aspect.MAGIC, 16).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6));
            registry.register(Content.all().get("item_runic_boots_enhanced").get(), new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6));
            registry.register(Content.all().get("item_resource_fabric").get(), new AspectList().add(Aspect.CLOTH, 4).add(Aspect.ELDRITCH, 1).add(Aspect.MAGIC, 2));
            var leader = net.minecraft.core.registries.BuiltInRegistries.ENTITY_TYPE.getOptional(
                net.minecraft.resources.ResourceLocation.parse("thaumcraft:cultist_leader")).orElseThrow();
            registry.registerEntity(leader, new AspectList().add(Aspect.ELDRITCH,2).add(Aspect.MAN,2).add(Aspect.ENTROPY,1).add(Aspect.MAGIC,2));
        });
    }
}
