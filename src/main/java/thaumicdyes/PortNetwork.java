package thaumicdyes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID)
public final class PortNetwork {
    private static final Map<UUID,Boolean> FORWARD = new HashMap<>();
    public static Consumer<Beam> beamReceiver = payload -> {};
    public static Consumer<Ward> wardReceiver = payload -> {};
    private PortNetwork() {}

    public record Forward(boolean forward) implements CustomPacketPayload {
        static final Type<Forward> TYPE = new Type<>(id("forward"));
        static final StreamCodec<RegistryFriendlyByteBuf,Forward> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, Forward::forward, Forward::new);
        @Override public Type<Forward> type() { return TYPE; }
    }
    public record Beam(int player, int target) implements CustomPacketPayload {
        static final Type<Beam> TYPE = new Type<>(id("mask_beam"));
        static final StreamCodec<RegistryFriendlyByteBuf,Beam> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, Beam::player, ByteBufCodecs.VAR_INT, Beam::target, Beam::new);
        @Override public Type<Beam> type() { return TYPE; }
    }
    public record Ward(int charge) implements CustomPacketPayload {
        static final Type<Ward> TYPE = new Type<>(id("emergency_ward"));
        static final StreamCodec<RegistryFriendlyByteBuf,Ward> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, Ward::charge, Ward::new);
        @Override public Type<Ward> type() { return TYPE; }
    }
    private static ResourceLocation id(String path) { return ResourceLocation.fromNamespaceAndPath(ThaumicDyes.MOD_ID,path); }

    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        var registrar = event.registrar("1");
        registrar.playToServer(Forward.TYPE, Forward.CODEC, (payload, context) -> context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) FORWARD.put(player.getUUID(),payload.forward());
        }));
        registrar.playToClient(Beam.TYPE, Beam.CODEC, (payload, context) -> context.enqueueWork(() -> beamReceiver.accept(payload)));
        registrar.playToClient(Ward.TYPE, Ward.CODEC, (payload, context) -> context.enqueueWork(() -> wardReceiver.accept(payload)));
    }

    public static boolean forward(net.minecraft.world.entity.player.Player player) {
        return player instanceof ServerPlayer ? FORWARD.getOrDefault(player.getUUID(),false) : player.zza > 0;
    }
    public static void forget(UUID player) { FORWARD.remove(player); }
}
