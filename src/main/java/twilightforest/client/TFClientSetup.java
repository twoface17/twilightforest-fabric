package twilightforest.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.properties.WoodType;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import twilightforest.TFConfig;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.block.entity.TFBlockEntities;
import twilightforest.client.model.TFLayerDefinitions;
import twilightforest.client.model.TFModelLayers;
import twilightforest.client.particle.TFParticleType;
import twilightforest.client.renderer.entity.IceLayer;
import twilightforest.client.renderer.entity.ShieldLayer;
import twilightforest.entity.TFEntities;
import twilightforest.inventory.TFContainers;
import twilightforest.item.TFItems;
import twilightforest.lib.events.EntityViewEvents;
import twilightforest.lib.events.OnTextureStitchCallback;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

public class TFClientSetup implements ClientModInitializer {

	public static boolean optifinePresent = false;

	@Override
	public void onInitializeClient() {
		clientSetup();

		TFClientEvents.ModBusEvents.registerModels();
		TFParticleType.registerFactories();
		TFLayerDefinitions.registerLayers();
		TFModelLayers.init();
		TFEntities.registerEntityRenderer();
		//Fabric events
		//EntityAddedLayerCallback.EVENT.register(this::attachRenderLayers);
		ClientTickEvents.END_WORLD_TICK.register(LockedBiomeListener::clientTick);
		OnTextureStitchCallback.PRE.register(TFClientEvents.ModBusEvents::texStitch);
		WorldRenderEvents.END.register(TFClientEvents::renderWorldLast);
		ClientTickEvents.END_CLIENT_TICK.register(TFClientEvents::clientTick);
		ItemTooltipCallback.EVENT.register(TFClientEvents::tooltipEvent);
		ScreenEvents.AFTER_INIT.register(ForgeEvents::showOptifineWarning);
		EntityViewEvents.FOG_COLORS.register(FogHandler::fogColors);
		EntityViewEvents.FOG_RENDER.register(FogHandler::fog);
	}

	public static class ForgeEvents {

		private static boolean optifineWarningShown = false;

		public static void showOptifineWarning(Minecraft client, Screen screen, int scaledWidth, int scaledHeigh) {
			if (optifinePresent && !optifineWarningShown && !TFConfig.CLIENT_CONFIG.disableOptifineNagScreen.get() && screen instanceof TitleScreen) {
				optifineWarningShown = true;
				Minecraft.getInstance().setScreen(new OptifineWarningScreen(screen));
			}
		}

	}

	private static void registerWoodType(WoodType woodType) {
		Sheets.SIGN_MATERIALS.put(woodType, Sheets.createSignMaterial(woodType));
	}

    public static void clientSetup() {
		try {
			Class.forName("net.optifine.Config");
			optifinePresent = true;
		} catch (ClassNotFoundException e) {
			optifinePresent = false;
		}
		TFItems.addItemModelProperties();

		ScreenEvents.BEFORE_INIT.register(LoadingScreenListener::onOpenGui);
        RenderLayerRegistration.init();
        TFBlockEntities.registerTileEntityRenders();
        TFContainers.renderScreens();

        TwilightForestRenderInfo renderInfo = new TwilightForestRenderInfo(128.0F, false, DimensionSpecialEffects.SkyType.NONE, false, false);
        DimensionSpecialEffects.EFFECTS.put(TwilightForestMod.prefix("renderer"), renderInfo);

//        evt.enqueueWork(() -> {
            registerWoodType(TFBlocks.TWILIGHT_OAK);
            registerWoodType(TFBlocks.CANOPY);
            registerWoodType(TFBlocks.MANGROVE);
            registerWoodType(TFBlocks.DARKWOOD);
            registerWoodType(TFBlocks.TIMEWOOD);
            registerWoodType(TFBlocks.TRANSFORMATION);
            registerWoodType(TFBlocks.MINING);
            registerWoodType(TFBlocks.SORTING);
//        });
       
    }

	@SuppressWarnings("unchecked")
	public void attachRenderLayers(final Map<EntityType<?>, EntityRenderer<?>> renderers, final Map<String, EntityRenderer<? extends Player>> skinMap) {
		if (renderers != null) {
			skinMap.keySet().forEach(renderer -> {
				LivingEntityRenderer<Player, EntityModel<Player>> skin = (LivingEntityRenderer<Player, EntityModel<Player>>) skinMap.get(renderer);
				attachRenderLayers(Objects.requireNonNull(skin));
			});
			skinMap.values().stream().
					filter(LivingEntityRenderer.class::isInstance).map(LivingEntityRenderer.class::cast).forEach(TFClientSetup::attachRenderLayers);
		}
	}

	private static <T extends LivingEntity, M extends EntityModel<T>> void attachRenderLayers(LivingEntityRenderer<T, M> renderer) {
		renderer.addLayer(new ShieldLayer<>(renderer));
		renderer.addLayer(new IceLayer<>(renderer));
	}
}
