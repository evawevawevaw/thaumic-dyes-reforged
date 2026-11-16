package thaumicdyes;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class PortComponents {
    public static final DeferredRegister<DataComponentType<?>> REGISTRY =
        DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, ThaumicDyes.MOD_ID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> UPGRADE = upgrade("upgrade");
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> UPGRADE_2 = upgrade("upgrade_2");
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> UPGRADE_3 = upgrade("upgrade_3");
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> MASK =
        REGISTRY.register("mask", () -> DataComponentType.<Integer>builder()
            .persistent(Codec.intRange(0, 2)).networkSynchronized(ByteBufCodecs.VAR_INT).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> GOGGLES =
        REGISTRY.register("goggles", () -> DataComponentType.<Boolean>builder()
            .persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());

    private PortComponents() {}

    private static DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> upgrade(String name) {
        return REGISTRY.register(name, () -> DataComponentType.<Integer>builder()
            .persistent(Codec.intRange(0, 10)).networkSynchronized(ByteBufCodecs.VAR_INT).build());
    }
}
