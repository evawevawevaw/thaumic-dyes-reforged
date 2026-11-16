package thaumicdyes.client;

import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import thaumicdyes.Appearance;
import thaumicdyes.ThaumicDyes;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID, value = Dist.CLIENT)
public final class PlayerSkinLayers {
    private PlayerSkinLayers() {}

    private static boolean modeled(net.minecraft.world.entity.player.Player player, EquipmentSlot slot) {
        Appearance.Skin skin = Appearance.of(player.getItemBySlot(slot));
        return skin != null && !skin.model().equals("Vanilla");
    }

    @SubscribeEvent
    public static void hideCoveredLayers(RenderPlayerEvent.Pre event) {
        var player = event.getEntity();
        var model = event.getRenderer().getModel();
        if (modeled(player, EquipmentSlot.HEAD)) {
            model.hat.visible = false;
        }
        if (modeled(player, EquipmentSlot.CHEST)) {
            model.jacket.visible = false;
            model.rightSleeve.visible = false;
            model.leftSleeve.visible = false;
        }
        if (modeled(player, EquipmentSlot.LEGS)) {
            model.leftPants.visible = false;
            model.rightPants.visible = false;
        }
    }
}
