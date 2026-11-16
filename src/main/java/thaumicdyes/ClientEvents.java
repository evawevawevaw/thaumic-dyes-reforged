package thaumicdyes;

import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID, value = Dist.CLIENT)
public final class ClientEvents {
    private ClientEvents() {}

    @SubscribeEvent
    public static void colors(RegisterColorHandlersEvent.Item event) {
        Content.all().values().forEach(holder -> {
            var skin = Appearance.of(new net.minecraft.world.item.ItemStack(holder.get()));
            if (skin != null && skin.dyeable()) {
                event.register((stack, layer) -> layer == 0 ? DyedItemColor.getOrDefault(stack, 0xFFFFFF) : -1,
                    holder.get());
            }
        });
    }
}
