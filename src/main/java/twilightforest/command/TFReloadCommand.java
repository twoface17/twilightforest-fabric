package twilightforest.command;

//import com.mojang.brigadier.Command;
//import com.mojang.brigadier.builder.LiteralArgumentBuilder;
//import com.mojang.brigadier.context.CommandContext;
//import net.minecraft.client.Minecraft;
//import net.minecraft.commands.CommandSourceStack;
//import net.minecraft.commands.Commands;
//import net.minecraft.network.chat.TranslatableComponent;
//
//import net.fabricmc.loader.api.FabricLoader;
//import twilightforest.client.shader.ShaderManager;
//import twilightforest.compat.ie.IEShaderRegister;
//
////FIXME this command was sitting in the proxy, so I moved it over here.
////However, if you run it, the game closes because ShaderManager isnt registering properly
//public class TFReloadCommand {
//
//    public static LiteralArgumentBuilder<CommandSourceStack> register() {
//        return Commands.literal("tfreload").executes(TFReloadCommand::reload);
//    }
//
//    private static int reload(CommandContext<CommandSourceStack> ctx) {
//        ctx.getSource().sendSuccess(new TranslatableComponent("commands.tfreload.reload"), true);
//        ShaderManager.getShaderReloadListener().onResourceManagerReload(Minecraft.getInstance().getResourceManager());
//        if (FabricLoader.getInstance().isModLoaded("immersiveengineering"))
//            IEShaderRegister.initShaders();
//        return Command.SINGLE_SUCCESS;
//    }
//}
