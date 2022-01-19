package twilightforest.lib;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;
import twilightforest.lib.mixin.plugin.patches.Patch;

import java.util.function.Consumer;

public class TFEarlyRiser implements Runnable {
    @Override
    public void run() {
        multipart();


        // to find method
//        ClassTinkerers.addTransformation(RemappingUtils.getClassName("class_898"), classNode -> {
//            classNode.methods.stream().filter(methodNode -> methodNode.name.contains("getRenderer")).forEach(methodNode -> System.out.println(methodNode.name + " " + methodNode.desc));
//        });
    }

    private void multipart() {
        transformMethodUnchecked("class_1937", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_238;Ljava/util/function/Predicate;)Ljava/util/List;", methodNode -> {
            var /*org.objectweb.asm.tree.InsnList*/ instructions = methodNode.instructions;
            instructions.insertBefore(
                    findFirstInstruction(methodNode, Opcodes.ARETURN),
                    listOf(
                            new VarInsnNode(Opcodes.ALOAD, 0),
                            new VarInsnNode(Opcodes.ALOAD, 1),
                            new VarInsnNode(Opcodes.ALOAD, 2),
                            new VarInsnNode(Opcodes.ALOAD, 3),
                            new MethodInsnNode(
                                    Opcodes.INVOKESTATIC,
                                    "twilightforest/ASMHooks",
                                    "multipartHitbox",
                                    RemappingUtils.mapMethodDescriptor("(Ljava/util/List;Lnet/minecraft/class_1937;Lnet/minecraft/class_1297;Lnet/minecraft/class_238;Ljava/util/function/Predicate;)Ljava/util/List;"),
                                    false
                            )
                    )
            );
        });
        transformMethod("class_3218", "method_31424", "(I)Lnet/minecraft/class_1297;", methodNode -> {
            var /*org.objectweb.asm.tree.InsnList*/ instructions = methodNode.instructions;
            instructions.insertBefore(
                    findFirstInstruction(methodNode, Opcodes.ARETURN),
                    listOf(
                            new VarInsnNode(Opcodes.ILOAD, 1),
                            new MethodInsnNode(
                                    Opcodes.INVOKESTATIC,
                                    "twilightforest/ASMHooks",
                                    "multipartFromID",
                                    RemappingUtils.mapMethodDescriptor("(Lnet/minecraft/class_1297;I)Lnet/minecraft/class_1297;"),
                                    false
                            )
                    )
            );
        });
        transformMethod("class_3218$class_5526", "method_31436", "(Lnet/minecraft/class_1297;)V", methodNode -> {
            var /*org.objectweb.asm.tree.InsnList*/ instructions = methodNode.instructions;
            instructions.insert(
                    listOf(
                            new VarInsnNode(Opcodes.ALOAD, 1),
                            new MethodInsnNode(
                                    Opcodes.INVOKESTATIC,
                                    "twilightforest/ASMHooks",
                                    "trackingStart",
                                    RemappingUtils.mapMethodDescriptor("(Lnet/minecraft/class_1297;)V"),
                                    false
                            )
                    )
            );
        });

        transformMethod("class_3231", "method_14306", "()V", methodNode -> {
            var /*org.objectweb.asm.tree.InsnList*/ instructions = methodNode.instructions;
            instructions.insert(
                    findFirstInstruction(methodNode, Opcodes.GETFIELD),
                    listOf(
                            new MethodInsnNode(
                                    Opcodes.INVOKESTATIC,
                                    "twilightforest/ASMHooks",
                                    "updateMultiparts",
                                    RemappingUtils.mapMethodDescriptor("(Lnet/minecraft/class_1297;)Lnet/minecraft/class_1297;"),
                                    false
                            )
                    )
            );
        });
        transformMethod("class_898", "method_3953", "(Lnet/minecraft/class_1297;)Lnet/minecraft/class_897;", methodNode -> {
            var /*org.objectweb.asm.tree.InsnList*/ instructions = methodNode.instructions;
            AbstractInsnNode lastInstruction = null;
            for (var index = instructions.size() - 1; index > 0; index--) {
                var /*org.objectweb.asm.tree.AbstractInsnNode*/ node = instructions.get(index);
                if (lastInstruction == null &&

                        node instanceof InsnNode &&

                        node.getOpcode() == Opcodes.ARETURN

                )
                    lastInstruction = node;

            }
            instructions.insertBefore(
                    lastInstruction,
                    listOf(
                            new VarInsnNode(Opcodes.ALOAD, 1),
                            new MethodInsnNode(
                                    Opcodes.INVOKESTATIC,
                                    "twilightforest/ASMHooks",
                                    "getMultipartRenderer",
                                    RemappingUtils.mapMethodDescriptor("(Lnet/minecraft/class_897;Lnet/minecraft/class_1297;)Lnet/minecraft/class_897;"),
                                    false
                            )
                    )
            );
        });
    }

    public static void transformMethod(String clazz, String method, String desc, Consumer<MethodNode> node) {
        ClassTinkerers.addTransformation(RemappingUtils.getClassName(clazz), classNode -> {
            classNode.methods.forEach(methodNode -> {
                if(methodNode.name.equals(RemappingUtils.getMethodName(clazz, method, desc)) && methodNode.desc.equals(RemappingUtils.mapMethodDescriptor(desc))) {
                    node.accept(methodNode);
                }
            });
        });
    }

    public static void transformMethodUnchecked(String clazz, String desc, Consumer<MethodNode> node) {
        ClassTinkerers.addTransformation(RemappingUtils.getClassName(clazz), classNode -> {
            classNode.methods.forEach(methodNode -> {
                if(methodNode.desc.equals(RemappingUtils.mapMethodDescriptor(desc))) {
                    node.accept(methodNode);
                }
            });
        });
    }

    static AbstractInsnNode findFirstInstructionAfter(MethodNode method, int opCode, int startIndex) {
        for (int i = Math.max(0, startIndex); i < method.instructions.size(); i++) {
            AbstractInsnNode ain = method.instructions.get(i);
            if (ain.getOpcode() == opCode) {
                return ain;
            }
        }
        return null;
    }

    /**
     * Builds a new {@link InsnList} out of the specified AbstractInsnNodes
     *
     * @param nodes The nodes you want to add
     * @return A new list with the nodes
     */
    static InsnList listOf(AbstractInsnNode... nodes) {
        InsnList list = new InsnList();
        for (AbstractInsnNode node : nodes)
            list.add(node);
        return list;
    }

    /**
     * Finds the first instruction with matching opcode
     *
     * @param method the method to search in
     * @param opCode the opcode to search for
     * @return the found instruction node or null if none matched
     */
    static AbstractInsnNode findFirstInstruction(MethodNode method, int opCode) {
        return findFirstInstructionAfter(method, opCode, 0);
    }
}
