package thaumicdyes.client;

import net.minecraft.util.Mth;

// Adapted from the original cloth/cape rotation formulas; native humanoid poses supply the limbs.
final class LegacyAnimations {
    private LegacyAnimations() {}

    static void apply(LegacyArmorModel model, String kind, float swing, float amount, float age) {
        float a = Mth.cos(swing * 0.6662F) * 1.4F * amount;
        float b = Mth.cos(swing * 0.6662F + (float) Math.PI) * 1.4F * amount;
        float c = Math.min(a, b);
        switch (kind) {
            case "Archer" -> {
                model.rotateX("FrontclothR1", c - 0.1047198F);
                model.rotateX("FrontclothL1", c - 0.1047198F);
                model.rotateX("FrontclothR2", c - 0.3316126F);
                model.rotateX("FrontclothL2", c - 0.3316126F);
                model.rotateX("ClothBackR1", -c + 0.1047198F);
                model.rotateX("ClothBackL1", -c + 0.1047198F);
                model.rotateX("ClothBackR2", -c + 0.2268928F);
                model.rotateX("ClothBackL2", -c + 0.2268928F);
                model.rotateX("ClothBackR3", -c + 0.2268928F);
                model.rotateX("ClothBackL3", -c + 0.2268928F);
            }
            case "Knight" -> {
                model.rotateX("Frontcloth1", c - 0.1047198F);
                model.rotateX("Frontcloth2", c - 0.3316126F);
                model.rotateX("Cloak1", -c / 2.0F + 0.1396263F);
                model.rotateX("Cloak2", -c / 2.0F + 0.3069452F);
                model.rotateX("Cloak3", -c / 2.0F + 0.4465716F);
            }
            case "Paladin" -> {
                model.rotateX("LegClothR", a - 0.10472F);
                model.rotateX("LegClothL", b - 0.10472F);
                model.rotateX("Cloak1", -c / 2.0F + 0.1396263F);
                model.rotateX("Cloak2", -c / 2.0F + 0.306945F);
                model.rotateX("Cloak3", -c / 2.0F + 0.4465716F);
            }
            case "Praetor" -> {
                model.rotateX("LegClothR", a - 0.10472F);
                model.rotateX("LegClothL", b - 0.10472F);
                model.rotateX("Cloak1", -c / 2.0F + 0.1396263F);
                model.rotateX("Cloak2", -c / 2.0F + 0.306945F);
                model.rotateX("Cloak3", -c / 2.0F + 0.4465716F);
            }
            case "Ranger" -> {
                model.rotateX("FrontclothR1", c - 0.1047198F);
                model.rotateX("FrontclothL1", c - 0.1047198F);
                model.rotateX("FrontclothR2", c - 0.3316126F);
                model.rotateX("FrontclothL2", c - 0.3316126F);
                model.rotateX("ClothBackR1", -c + 0.1047198F);
                model.rotateX("ClothBackL1", -c + 0.1047198F);
                model.rotateX("ClothBackR2", -c + 0.2268928F);
                model.rotateX("ClothBackL2", -c + 0.2268928F);
                model.rotateX("ClothBackR3", -c + 0.2268928F);
                model.rotateX("ClothBackL3", -c + 0.2268928F);
            }
            case "Ranger2" -> {
                model.rotateX("FrontclothR1", c - 0.1047198F);
                model.rotateX("FrontclothL1", c - 0.1047198F);
                model.rotateX("FrontclothR2", c - 0.3316126F);
                model.rotateX("FrontclothL2", c - 0.3316126F);
                model.rotateX("ClothBackR1", -c + 0.1047198F);
                model.rotateX("ClothBackL1", -c + 0.1047198F);
                model.rotateX("ClothBackR2", -c + 0.2268928F);
                model.rotateX("ClothBackL2", -c + 0.2268928F);
                model.rotateX("ClothBackR3", -c + 0.2268928F);
                model.rotateX("ClothBackL3", -c + 0.2268928F);
            }
            case "Robes" -> {
                model.rotateX("FrontclothR1", c - 0.1047198F);
                model.rotateX("FrontclothL1", c - 0.1047198F);
                model.rotateX("FrontclothR2", c - 0.3316126F);
                model.rotateX("FrontclothL2", c - 0.3316126F);
                model.rotateX("ClothBackR1", -c + 0.1047198F);
                model.rotateX("ClothBackL1", -c + 0.1047198F);
                model.rotateX("ClothBackR2", -c + 0.2268928F);
                model.rotateX("ClothBackL2", -c + 0.2268928F);
                model.rotateX("ClothBackR3", -c + 0.2268928F);
                model.rotateX("ClothBackL3", -c + 0.2268928F);
            }
            case "RobesSpecial" -> {
                model.rotateX("FrontclothR1", c - 0.1047198F);
                model.rotateX("FrontclothL1", c - 0.1047198F);
                model.rotateX("FrontclothR2", c - 0.3316126F);
                model.rotateX("FrontclothL2", c - 0.3316126F);
                model.rotateX("Cloak1", 0.2F + Mth.sin((age) / 7.0F) * 0.08F);
            }
            default -> {}
        }
    }
}
