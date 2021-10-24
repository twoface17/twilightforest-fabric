package twilightforest.api.mixin.plugin.patches;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.util.asm.ASM;
import org.spongepowered.asm.util.asm.MethodVisitorEx;

public class EnchantmentMenuPatch implements Patch {
    @Override
    public void applyMethod(MethodNode node) {
        for(AbstractInsnNode insnNode : node.instructions) {
            //System.out.println(insnNode);
        }
    }

    @Override
    public String getMixinClass() {
        return FabricLoader.getInstance().getMappingResolver().mapClassName("intermediary", "net.minecraft.class_1718");
    }

    @Override
    public String getMethodName() {
        return FabricLoader.getInstance().getMappingResolver().mapMethodName("intermediary", "net.minecraft.class_898", "method_7609", "(Lnet/minecraft/class_1263;)V");
    }

    @Override
    public String getMethodDesc() {
        return FabricLoader.getInstance().isDevelopmentEnvironment() ? "(Lnet/minecraft/world/Container;)V" : "(Lnet/minecraft/class_1263;)V";
    }
}
