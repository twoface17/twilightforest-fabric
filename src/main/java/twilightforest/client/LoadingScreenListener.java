package twilightforest.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.level.Level;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import twilightforest.TFConfig;
import twilightforest.block.TFBlocks;

@Environment(EnvType.CLIENT)
public class LoadingScreenListener {

	private final Minecraft client = Minecraft.getInstance();

	public static void onOpenGui(Minecraft client, Screen screen, int scaledWidth, int scaledHeight) {
		if (screen instanceof ReceivingLevelScreen && client.player != null) {
			ResourceKey<Level> tfDimension = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(TFConfig.COMMON_CONFIG.DIMENSION.portalDestinationID.get()));
			if (client.player.getCommandSenderWorld().getBlockState(client.player.blockPosition().below()) == TFBlocks.TWILIGHT_PORTAL.get().defaultBlockState() || client.player.getCommandSenderWorld().dimension() == tfDimension) {
				LoadingScreenGui guiLoading = new LoadingScreenGui();
				guiLoading.setEntering(client.player.getCommandSenderWorld().dimension() == Level.OVERWORLD);
				client.setScreen(guiLoading);
			}
		}
	}
}
