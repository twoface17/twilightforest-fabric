package twilightforest.client;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.util.Mth;

import com.mojang.math.Vector3f;
import net.fabricmc.api.EnvType;
import twilightforest.TwilightForestMod;
import twilightforest.world.registration.biomes.BiomeKeys;

import java.util.Objects;
import java.util.Optional;

public class FogHandler {

	private static final float[] spoopColors = new float[3];
	private static float spoopColor = 0F;
	private static float spoopFog = 1F;

	public static Vector3f fogColors(Camera info, float partialTicks, Vector3f color) {
		boolean flag = isSpooky();
		if (flag || spoopColor > 0F) {
			final float[] realColors = {color.x(), color.y(), color.z()};
			final float[] lerpColors = {130F / 255F, 115F / 255F, 145F / 255F};
			for (int i = 0; i < 3; i++) {
				final float real = realColors[i];
				final float spoop = lerpColors[i];
				final boolean inverse = real > spoop;
				spoopColors[i] = real == spoop ? spoop : Mth.clampedLerp(inverse ? spoop : real, inverse ? real : spoop, spoopColor);
			}
			float shift = (float) (0.01F * partialTicks);
			if (flag)
				spoopColor += shift;
			else
				spoopColor -= shift;
			spoopColor = Mth.clamp(spoopColor, 0F, 1F);
			color.set(spoopColors[0], spoopColors[1], spoopColors[2]);
			return color;
		}
		return null;
	}

	public static void fog(FogRenderer.FogMode type, Camera info, float partialTicks, float distance) {
		boolean flag = isSpooky();
		if (flag || spoopFog < 1F) {
			float f = 48F;
			f = f >= event.getFarPlaneDistance() ? event.getFarPlaneDistance() : Mth.clampedLerp(f, event.getFarPlaneDistance(), spoopFog);
			float shift = (float) (0.001F * partialTicks);
			if (flag)
				spoopFog -= shift;
			else
				spoopFog += shift;
			spoopFog = Mth.clamp(spoopFog, 0F, 1F);

			//FIXME: These two are commented out as they do not exist in the main game. While this might mean they aren't needed, look at this if there is a problem
//			RenderSystem.fogMode(GlStateManager.FogMode.LINEAR);

			if (event.getMode() == FogRenderer.FogMode.FOG_SKY) {
				RenderSystem.setShaderFogStart(0.0F);
				RenderSystem.setShaderFogEnd(f);
			} else {
				RenderSystem.setShaderFogStart(f * 0.75F);
				RenderSystem.setShaderFogEnd(f);
			}

//			RenderSystem.setupNvFogDistance();
		}
	}

	private static boolean isSpooky() {
		return Minecraft.getInstance().level != null && Minecraft.getInstance().player != null &&
				Objects.equals(Minecraft.getInstance().level.getBiomeName(Minecraft.getInstance().player.blockPosition()), Optional.of(BiomeKeys.SPOOKY_FOREST));
	}
}
