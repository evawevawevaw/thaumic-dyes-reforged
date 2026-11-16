package thaumicdyes.integration;

import java.util.Arrays;
import net.minecraft.resources.ResourceLocation;
import thaumcraft.aspect.AspectList;
import thaumcraft.crafting.TcStack;
import thaumcraft.research.ResearchItem;

class LegacyResearch extends ResearchItem {
    LegacyResearch(String key, String category, AspectList tags, int x, int y, int complexity, LegacyStack icon) {
        super(key, category, tags, x, y, complexity, icon.stack());
    }
    LegacyResearch(String key, String category, AspectList tags, int x, int y, int complexity, TcStack icon) {
        super(key, category, tags, x, y, complexity, icon);
    }
    LegacyResearch(String key, String category, AspectList tags, int x, int y, int complexity, ResourceLocation icon) {
        super(key, category, tags, x, y, complexity, icon);
    }
    LegacyResearch setPages(LegacyPage... pages) {
        super.setPages(Arrays.stream(pages).map(p -> p.page).toArray(thaumcraft.research.ResearchPage[]::new));
        return this;
    }
    LegacyResearch setItemTriggers(LegacyStack... stacks) {
        super.setItemTriggers(Arrays.stream(stacks).map(s -> s.id).toArray(String[]::new));
        return this;
    }
    @Override public LegacyResearch setParents(String... keys) { super.setParents(keys); return this; }
    @Override public LegacyResearch setParentsHidden(String... keys) { super.setParentsHidden(keys); return this; }
    @Override public LegacyResearch setSiblings(String... keys) { super.setSiblings(keys); return this; }
    @Override public LegacyResearch setSpecial() { super.setSpecial(); return this; }
    @Override public LegacyResearch setSecondary() { super.setSecondary(); return this; }
    @Override public LegacyResearch setRound() { super.setRound(); return this; }
    @Override public LegacyResearch setConcealed() { super.setConcealed(); return this; }
    @Override public LegacyResearch setHidden() { super.setHidden(); return this; }
    @Override public LegacyResearch setLost() { super.setLost(); return this; }
    @Override public LegacyResearch setStub() { super.setStub(); return this; }
}
