package twilightforest.api.mixin.plugin;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import twilightforest.api.mixin.plugin.patches.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TwilightForestMixinPlugin implements IMixinConfigPlugin {
    private List<Patch> patches;
    @Override
    public void onLoad(String mixinPackage) {
        patches = new ArrayList<>();
        patches.add(new EntityRenderDispatcherPatch());
        patches.add(new MapItemPatch());
//        patches.add(new BiomeColorsPatch());
        patches.add(new EnchantmentMenuPatch());
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if(mixinClassName.contains("BoundingBoxMixin") || mixinClassName.contains("WorldGenRegionMixin"))
            return FabricLoader.getInstance().isDevelopmentEnvironment();
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    private boolean warned = false;

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        if(!warned) {
            warned = true;
            System.out.println("PATCHING CLASSES");
        }

        for(Patch patch : patches) {
            if(patch.getMixinClass().equals(targetClassName)) {
                System.out.println("PATCHING CLASS: "+ targetClassName);
                for(MethodNode node : targetClass.methods) {
                    if(node.name.equals(patch.getMethodName()) && node.desc.equals(patch.getMethodDesc())) {
                        System.out.println("PATCHING METHOD: "+ node.name+node.desc);
                        patch.applyMethod(node);
                    }
                }
            }
        }
    }
}
