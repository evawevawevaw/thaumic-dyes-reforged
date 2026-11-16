package thaumicdyes.integration;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import thaumcraft.aspect.AspectList;
import thaumcraft.crafting.TcStack;
import thaumcraft.research.ResearchCategories;
import thaumcraft.research.ResearchItem;
import thaumcraft.research.ResearchPage;

final class LinkedResearch extends LegacyResearch {
    private final ResearchItem origin;
    LinkedResearch(String key, String category, String source, String sourceCategory, int x, int y, TcStack icon) {
        super(key, category, new AspectList(), x, y, 1, icon);
        origin = require(source);
        link();
    }
    LinkedResearch(String key, String category, String source, String sourceCategory, int x, int y, ResourceLocation icon) {
        super(key, category, new AspectList(), x, y, 1, icon);
        origin = require(source);
        link();
    }
    private static ResearchItem require(String key) {
        ResearchItem item = ResearchCategories.getResearch(key);
        if (item == null) throw new IllegalArgumentException("Missing base research " + key);
        return item;
    }
    private void link() {
        List<String> siblings = new ArrayList<>(origin.siblings());
        if (!siblings.contains(key())) siblings.add(key());
        origin.setSiblings(siblings.toArray(String[]::new));
        setStub();
        setHidden();
        if (origin.isSecondary()) setSecondary();
    }
    @Override public List<ResearchPage> pages() { return origin.pages(); }
    @Override public String nameKey() { return origin.nameKey(); }
    @Override public String textKey() { return origin.textKey(); }
}
