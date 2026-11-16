package thaumicdyes.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import thaumicdyes.PortComponents;

final class LegacyArmorModel extends HumanoidModel<LivingEntity> {
    private final ModelPart root;
    private final String kind;
    private final EquipmentSlot slot;
    private final Map<String, ModelPart> parts = new HashMap<>();

    LegacyArmorModel(ModelPart root, String kind, EquipmentSlot slot) {
        super(root);
        this.root = root;
        this.kind = kind;
        this.slot = slot;
    }

    private ModelPart part(String name) {
        return parts.computeIfAbsent(name, key -> root.getAllParts().filter(p -> p.hasChild(key))
            .findFirst().map(p -> p.getChild(key)).orElse(null));
    }

    void rotateX(String name, float rotation) {
        ModelPart part = part(name);
        if (part != null) {
            part.xRot = rotation;
        }
    }

    private void visible(String name, boolean visible) {
        ModelPart part = part(name);
        if (part != null) {
            part.visible = visible;
        }
    }

    void animate(LivingEntity entity, float swing, float amount, float age) {
        head.visible = slot == EquipmentSlot.HEAD;
        hat.visible = slot == EquipmentSlot.HEAD;
        body.visible = slot == EquipmentSlot.CHEST || slot == EquipmentSlot.LEGS;
        rightArm.visible = leftArm.visible = slot == EquipmentSlot.CHEST;
        rightLeg.visible = leftLeg.visible = slot == EquipmentSlot.LEGS;
        // Vanilla handles baby/crouch/bow poses; retain the legacy anti-clipping scale.
        head.xScale = head.yScale = head.zScale = entity.isBaby() ? 1.0F : 1.01F;
        rightArm.yScale = leftArm.yScale = 1.0F;
        LegacyAnimations.apply(this, kind, swing, amount, age);
        if (kind.equals("Fortress") || kind.equals("IronFortress")) {
            fortress(entity);
        }
    }

    private void fortress(LivingEntity entity) {
        String prefix = kind.equals("Fortress") ? "fortress_" : "iron_fortress_";
        int count = 0;
        for (EquipmentSlot piece : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS}) {
            var id = BuiltInRegistries.ITEM.getKey(entity.getItemBySlot(piece).getItem());
            if (id.getNamespace().equals("thaumicdyes") && id.getPath().startsWith(prefix)) {
                count++;
            }
        }
        ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
        var id = BuiltInRegistries.ITEM.getKey(helmet.getItem());
        boolean correctHelmet = id.getNamespace().equals("thaumicdyes") && id.getPath().equals(prefix + "helm");
        visible("Goggles", correctHelmet && thaumicdyes.GearData.goggles(helmet));
        int mask = correctHelmet ? thaumicdyes.GearData.mask(helmet) : -1;
        for (int i = 0; i < 3; i++) {
            visible("Mask" + i, mask == i);
        }
        for (String name : new String[]{"Book", "flapL", "flapR", "ShoulderplateLtop", "ShoulderplateL1",
                "ShoulderplateRtop", "ShoulderplateR1", "SidepanelR2", "SidepanelL2"}) {
            visible(name, count >= 2);
        }
        for (String name : new String[]{"Scroll", "OrnamentL", "OrnamentL2", "OrnamentR", "OrnamentR2",
                "Gemornament", "Gem", "ShoulderplateL2", "ShoulderplateL3", "ShoulderplateR2",
                "ShoulderplateR3", "SidepanelR3", "SidepanelL3"}) {
            visible(name, count >= 3);
        }
    }
}
