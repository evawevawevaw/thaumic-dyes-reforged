package thaumicdyes.client;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import thaumicdyes.Appearance;
import thaumicdyes.Content;
import thaumicdyes.ThaumicDyes;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID, value = Dist.CLIENT)
public final class ArmorModels {
    private static final Map<String, Function<Boolean, LayerDefinition>> FACTORIES = Map.ofEntries(
        Map.entry("Archer", LegacyGeometry::archer), Map.entry("Fortress", LegacyGeometry::fortress),
        Map.entry("IronFortress", LegacyGeometry::ironfortress), Map.entry("Knight", LegacyGeometry::knight),
        Map.entry("Paladin", LegacyGeometry::paladin), Map.entry("Praetor", LegacyGeometry::praetor),
        Map.entry("Ranger", LegacyGeometry::ranger), Map.entry("Ranger2", LegacyGeometry::ranger2),
        Map.entry("Robes", LegacyGeometry::robes), Map.entry("RobesSpecial", LegacyGeometry::robesspecial));
    private static final Map<String, Map<EquipmentSlot, LegacyArmorModel>> MODELS = new HashMap<>();

    private ArmorModels() {}

    private static ModelLayerLocation layer(String kind, boolean inner) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ThaumicDyes.MOD_ID,
            "armor/" + kind.toLowerCase(java.util.Locale.ROOT)), inner ? "inner" : "outer");
    }

    @SubscribeEvent
    public static void layers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        FACTORIES.forEach((kind, factory) -> {
            event.registerLayerDefinition(layer(kind, true), () -> factory.apply(true));
            event.registerLayerDefinition(layer(kind, false), () -> factory.apply(false));
        });
    }

    @SubscribeEvent
    public static void bake(EntityRenderersEvent.AddLayers event) {
        bake(event.getEntityModels());
        java.util.Set<net.minecraft.client.renderer.entity.EntityRenderer<?>> renderers =
            java.util.Collections.newSetFromMap(new java.util.IdentityHashMap<>());
        event.getSkins().forEach(skin -> renderers.add(event.getSkin(skin)));
        event.getEntityTypes().forEach(type -> renderers.add(event.getRenderer(type)));
        renderers.forEach(TranslucentArmorLayer::attach);
    }

    private static void bake(EntityModelSet models) {
        MODELS.clear();
        FACTORIES.keySet().forEach(kind -> {
            Map<EquipmentSlot, LegacyArmorModel> bySlot = new EnumMap<>(EquipmentSlot.class);
            for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                bySlot.put(slot, new LegacyArmorModel(models.bakeLayer(layer(kind,
                    slot == EquipmentSlot.HEAD || slot == EquipmentSlot.LEGS)), kind, slot));
            }
            MODELS.put(kind, bySlot);
        });
    }

    static LegacyArmorModel model(String kind, EquipmentSlot slot) {
        if (MODELS.isEmpty()) {
            bake(Minecraft.getInstance().getEntityModels());
        }
        return MODELS.get(kind).get(slot);
    }

    @SubscribeEvent
    public static void extensions(RegisterClientExtensionsEvent event) {
        Content.all().values().forEach(item -> {
            Appearance.Skin skin = Appearance.of(new ItemStack(item.get()));
            if (skin == null) {
                return;
            }
            event.registerItem(new IClientItemExtensions() {
                @Override
                public int getDefaultDyeColor(ItemStack stack) {
                    return 0xFFFFFFFF;
                }

                @Override
                public int getArmorLayerTintColor(ItemStack stack, LivingEntity entity,
                        ArmorMaterial.Layer layer, int index, int fallback) {
                    return skin.model().equals("RobesSpecial") ? 0
                        : IClientItemExtensions.super.getArmorLayerTintColor(stack, entity, layer, index, fallback);
                }

                @Override
                public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack,
                        EquipmentSlot slot, HumanoidModel<?> original) {
                    if (!FACTORIES.containsKey(skin.model())) {
                        return original;
                    }
                    if (MODELS.isEmpty()) {
                        bake(Minecraft.getInstance().getEntityModels());
                    }
                    LegacyArmorModel model = MODELS.get(skin.model()).get(slot);
                    return model == null ? original : model;
                }

                @Override
                public void setupModelAnimations(LivingEntity entity, ItemStack stack, EquipmentSlot slot,
                        Model model, float swing, float amount, float partialTick, float age,
                        float yaw, float pitch) {
                    if (model instanceof LegacyArmorModel armor) {
                        armor.animate(entity, swing, amount, age);
                        if (skin.model().equals("RobesSpecial")) {
                            // The dedicated translucent layer renders this geometry and its foil once.
                            armor.setAllVisible(false);
                        }
                    }
                }
            }, item.get());
        });
    }
}
