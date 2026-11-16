package thaumicdyes.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

final class LegacyMesh {
    final Node head = new Node(0, 0);
    final Node hat = new Node(32, 0);
    final Node body = new Node(16, 16);
    final Node rightArm = new Node(40, 16);
    final Node leftArm = new Node(40, 16);
    final Node rightLeg = new Node(0, 16);
    final Node leftLeg = new Node(0, 16);

    LegacyMesh(float expansion) {
        head.box(-4, -8, -4, 8, 8, 8, expansion);
        hat.box(-4, -8, -4, 8, 8, 8, expansion + 0.5F);
        body.box(-4, 0, -2, 8, 12, 4, expansion);
        rightArm.pivot(-5, 2, 0);
        rightArm.box(-3, -2, -2, 4, 12, 4, expansion);
        leftArm.mirror = true;
        leftArm.pivot(5, 2, 0);
        leftArm.box(-1, -2, -2, 4, 12, 4, expansion);
        rightLeg.pivot(-1.9F, 12, 0);
        rightLeg.box(-2, 0, -2, 4, 12, 4, expansion);
        leftLeg.mirror = true;
        leftLeg.pivot(1.9F, 12, 0);
        leftLeg.box(-2, 0, -2, 4, 12, 4, expansion);
    }

    LayerDefinition bake() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        head.bake(root, "head");
        hat.bake(root, "hat");
        body.bake(root, "body");
        rightArm.bake(root, "right_arm");
        leftArm.bake(root, "left_arm");
        rightLeg.bake(root, "right_leg");
        leftLeg.bake(root, "left_leg");
        return LayerDefinition.create(mesh, 128, 64);
    }

    static final class Node {
        private record Box(float x, float y, float z, float width, float height, float depth, float expansion, boolean mirror) {}
        final List<Box> boxes = new ArrayList<>();
        private final Map<String, Node> children = new LinkedHashMap<>();
        private final int u;
        private final int v;
        boolean mirror;
        private float x, y, z, xRot, yRot, zRot;

        Node(int u, int v) {
            this.u = u;
            this.v = v;
        }

        void box(float x, float y, float z, float width, float height, float depth) {
            box(x, y, z, width, height, depth, 0);
        }

        void box(float x, float y, float z, float width, float height, float depth, float expansion) {
            boxes.add(new Box(x, y, z, width, height, depth, expansion, mirror));
        }

        void pivot(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        void rotate(float x, float y, float z) {
            this.xRot = x;
            this.yRot = y;
            this.zRot = z;
        }

        void size(int width, int height) {
            if (width != 128 || height != 64) {
                throw new IllegalArgumentException("Unexpected legacy texture dimensions");
            }
        }

        void child(String name, Node child) {
            children.put(name, child);
        }

        void bake(PartDefinition parent, String name) {
            CubeListBuilder cubes = CubeListBuilder.create();
            for (Box box : boxes) {
                cubes.texOffs(u, v).mirror(box.mirror()).addBox(box.x(), box.y(), box.z(),
                    box.width(), box.height(), box.depth(), new CubeDeformation(box.expansion()));
            }
            PartDefinition part = parent.addOrReplaceChild(name, cubes, PartPose.offsetAndRotation(x, y, z, xRot, yRot, zRot));
            children.forEach((childName, child) -> child.bake(part, childName));
        }
    }
}
