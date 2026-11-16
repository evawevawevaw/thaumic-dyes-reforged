package thaumicdyes.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import thaumicdyes.PortNetwork;
import thaumicdyes.ThaumicDyes;

@EventBusSubscriber(modid=ThaumicDyes.MOD_ID,value=Dist.CLIENT)
public final class GearClient {
    private record Beam(int target,long until) {}
    private static final Map<Integer,Beam> BEAMS=new HashMap<>();
    private static net.minecraft.client.multiplayer.ClientLevel level;
    private static net.minecraft.client.player.LocalPlayer player;
    private static boolean forward;
    private static int ward;
    private GearClient() {}

    @SubscribeEvent public static void setup(FMLClientSetupEvent event) {
        PortNetwork.beamReceiver=payload->{
            var current=Minecraft.getInstance().level;
            if (current!=null) BEAMS.put(payload.player(),new Beam(payload.target(),current.getGameTime()+5));
        };
        PortNetwork.wardReceiver=payload->ward=Math.max(0,payload.charge());
    }
    @SubscribeEvent public static void tick(ClientTickEvent.Post event) {
        var client=Minecraft.getInstance();
        if (level!=client.level) { BEAMS.clear();ward=0;level=client.level; }
        var current=client.player;
        if (current==null) { player=null;return; }
        if (player != current) { ward=0;BEAMS.clear(); }
        boolean moving=current.input.forwardImpulse>0;
        if (player!=current || moving!=forward) {
            player=current;forward=moving;PacketDistributor.sendToServer(new PortNetwork.Forward(moving));
        }
        if (level!=null) BEAMS.values().removeIf(beam->beam.until()<level.getGameTime());
    }
    @SubscribeEvent public static void gui(RegisterGuiLayersEvent event) {
        event.registerAboveAll(ResourceLocation.fromNamespaceAndPath(ThaumicDyes.MOD_ID,"emergency_ward"),(graphics,delta)->{
            var client=Minecraft.getInstance();
            if (ward<=0 || client.player==null || client.options.hideGui) return;
            graphics.drawString(client.font,Component.translatable("hud.thaumicdyes.ward",ward),
                graphics.guiWidth()/2-91,graphics.guiHeight()-59,0xFF80DFFF,true);
        });
    }
    @SubscribeEvent public static void beam(RenderLevelStageEvent event) {
        if (event.getStage()!=RenderLevelStageEvent.Stage.AFTER_PARTICLES || level==null || BEAMS.isEmpty()) return;
        var buffers=Minecraft.getInstance().renderBuffers().bufferSource();
        var type=net.minecraft.client.renderer.RenderType.lightning();
        var vertices=buffers.getBuffer(type);
        var pose=event.getPoseStack();
        pose.pushPose();
        Vec3 camera=event.getCamera().getPosition();pose.translate(-camera.x,-camera.y,-camera.z);
        for (var entry:BEAMS.entrySet()) {
            var from=level.getEntity(entry.getKey());var to=level.getEntity(entry.getValue().target());
            if (from==null||to==null) continue;
            Vec3 start=from.getEyePosition(),end=to.getBoundingBox().getCenter();
            RandomSource random=RandomSource.create(entry.getKey()*31L+level.getGameTime()/2);
            Vec3 previous=start;
            for (int i=1;i<=12;i++) {
                Vec3 next=start.lerp(end,i/12.0);
                if (i<12) next=next.add((random.nextDouble()-0.5)*0.3,(random.nextDouble()-0.5)*0.3,(random.nextDouble()-0.5)*0.3);
                for (Vec3 side:new Vec3[]{new Vec3(0.0625,0,0),new Vec3(0,0.0625,0),new Vec3(0,0,0.0625)}) {
                    vertex(vertices,pose,previous.add(side));vertex(vertices,pose,next.add(side));
                    vertex(vertices,pose,next.subtract(side));vertex(vertices,pose,previous.subtract(side));
                }
                previous=next;
            }
        }
        pose.popPose();buffers.endBatch(type);
    }
    private static void vertex(com.mojang.blaze3d.vertex.VertexConsumer vertices,com.mojang.blaze3d.vertex.PoseStack poses,Vec3 point) {
        vertices.addVertex(poses.last().pose(),(float)point.x,(float)point.y,(float)point.z).setColor(0.55F,0.25F,0.8F,0.8F);
    }
}
