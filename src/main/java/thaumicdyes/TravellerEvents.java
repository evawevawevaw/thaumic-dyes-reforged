package thaumicdyes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

@EventBusSubscriber(modid = ThaumicDyes.MOD_ID)
public final class TravellerEvents {
    private static final ResourceLocation STEP = ResourceLocation.fromNamespaceAndPath(ThaumicDyes.MOD_ID, "traveller_step");

    private TravellerEvents() {}

    private record Movement(float speed, float waterDivisor, float fallReduction) {}

    private static Movement movement(ItemStack stack) {
        if (stack.is(Content.all().get("boots_thaumium_traveller").get())) {
            return new Movement(0.085F, 3.0F, 0.35F);
        }
        if (stack.is(Content.all().get("boots_void_traveller").get())
                || stack.is(Content.all().get("item_runic_boots_primal").get())) {
            return new Movement(0.1F, 3.0F, 0.5F);
        }
        if (stack.is(Content.all().get("item_runic_boots_traveller").get())) {
            return new Movement(0.055F, 4.0F, 0.25F);
        }
        return null;
    }

    @SubscribeEvent
    public static void tick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        Movement movement = movement(player.getItemBySlot(EquipmentSlot.FEET));
        var step = player.getAttribute(Attributes.STEP_HEIGHT);
        boolean stepping = movement != null && !player.getAbilities().flying && !player.isFallFlying() && PortNetwork.forward(player) && !player.isShiftKeyDown();
        if (step != null) {
            if (stepping && !step.hasModifier(STEP)) {
                // A removable native attribute replaces TC4's shared prevStep map.
                step.addTransientModifier(new AttributeModifier(STEP, 0.4, AttributeModifier.Operation.ADD_VALUE));
            } else if (!stepping && step.hasModifier(STEP)) {
                step.removeModifier(STEP);
            }
        }
        if (movement == null) {
            return;
        }
        if (!player.getAbilities().flying && !player.isFallFlying() && PortNetwork.forward(player) && player.onGround()) {
            float speed = player.isInWater() ? movement.speed() / movement.waterDivisor() : movement.speed();
            player.moveRelative(speed, new Vec3(0, 0, 1));
        }
        if (!player.getAbilities().flying && !player.isFallFlying() && PortNetwork.forward(player) && !player.onGround()) {
            // MC 1.21 has no writable jumpMovementFactor; translate 0.03/0.05 total into the extra 0.01/0.03 impulse.
            boolean hover = thaumcraft.item.armor.Hover.isHovering(thaumcraft.item.armor.Hover.getHarness(player));
            player.moveRelative(hover ? 0.01F : 0.03F, new Vec3(0, 0, 1));
        }
        if (player.fallDistance > 0) {
            player.fallDistance = Math.max(0, player.fallDistance - movement.fallReduction());
        }
    }

    @SubscribeEvent
    public static void jump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
            float bonus = boots.is(Content.all().get("boots_thaumium_traveller").get()) ? 0.275F
                : boots.is(Content.all().get("boots_void_traveller").get())
                    || boots.is(Content.all().get("item_runic_boots_primal").get()) ? 0.35F
                : boots.is(Content.all().get("item_runic_boots_traveller").get()) ? 0.275F : 0;
            if (bonus > 0) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, bonus, 0));
            }
        }
    }
}
