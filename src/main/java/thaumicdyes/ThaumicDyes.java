package thaumicdyes;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ThaumicDyes.MOD_ID)
public final class ThaumicDyes {
    public static final String MOD_ID = "thaumicdyes";
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    private static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    static {
        TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.thaumicdyes"))
            .icon(() -> new ItemStack(Content.all().get("fortress_helm").get()))
            .displayItems((parameters, output) -> Content.all().values().forEach(item -> output.accept(item.get())))
            .build());
    }

    public ThaumicDyes(IEventBus modBus) {
        Content.all();
        ITEMS.register(modBus);
        Materials.REGISTRY.register(modBus);
        PortComponents.REGISTRY.register(modBus);
        TABS.register(modBus);
        AspectIntegration.register();
        RecipeComponents.register();
        modBus.addListener(this::setup);
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            thaumicdyes.integration.MagicIntegration.register();
            Content.all().values().forEach(item -> {
            var skin = Appearance.of(new ItemStack(item.get()));
            if (skin != null && skin.dyeable()) {
                CauldronInteraction.WATER.map().put(item.get(), CauldronInteraction.DYED_ITEM);
            }
            });
        });
    }
}
