package thaumicdyes.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.client.ClientHooks;
import thaumicdyes.Appearance;
import thaumicdyes.PortArmorItem;

final class TranslucentArmorLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private TranslucentArmorLayer(RenderLayerParent<T, M> parent) {
        super(parent);
    }

    static void attach(EntityRenderer<?> renderer) {
        if (renderer instanceof LivingEntityRenderer<?, ?> living && living.getModel() instanceof HumanoidModel<?>) {
            attachLiving(living);
        }
    }

    private static <T extends LivingEntity, M extends EntityModel<T>> void attachLiving(LivingEntityRenderer<T, M> renderer) {
        renderer.addLayer(new TranslucentArmorLayer<>(renderer));
    }

    @Override
    public void render(PoseStack poses, MultiBufferSource buffers, int light, T entity,
            float swing, float amount, float partialTick, float age, float yaw, float pitch) {
        if (!(getParentModel() instanceof HumanoidModel<?> parent)) {
            return;
        }
        for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
            var stack = entity.getItemBySlot(slot);
            Appearance.Skin skin = Appearance.of(stack);
            if (skin == null || !skin.model().equals("RobesSpecial")
                    || !(stack.getItem() instanceof PortArmorItem item) || item.getEquipmentSlot() != slot) {
                continue;
            }
            LegacyArmorModel model = ArmorModels.model(skin.model(), slot);
            ClientHooks.copyModelProperties(parent, model);
            model.animate(entity, swing, amount, age);
            var layer = item.getMaterial().value().layers().getFirst();
            var texture = item.getArmorTexture(stack, entity, slot, layer, slot == EquipmentSlot.LEGS);
            // A native translucent buffer replaces the legacy per-render global OpenGL blend state.
            var vertices = ItemRenderer.getArmorFoilBuffer(buffers, RenderType.entityTranslucent(texture), stack.hasFoil());
            model.renderToBuffer(poses, vertices, light, OverlayTexture.NO_OVERLAY, -1);
        }
    }
}
