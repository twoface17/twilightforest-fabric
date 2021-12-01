package twilightforest.network;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.network.FriendlyByteBuf;
import twilightforest.TwilightForestMod;
import twilightforest.client.TwilightForestRenderInfo;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.lib.BasePacket;

import java.util.function.Supplier;

public class StructureProtectionClearPacket implements BasePacket<StructureProtectionClearPacket> {

	public StructureProtectionClearPacket() {}

	public StructureProtectionClearPacket(FriendlyByteBuf unused) {}

	public void encode(FriendlyByteBuf unused) {}

	@Override
	public void handle(StructureProtectionClearPacket packet, Context context) {
		Handler.onMessage(packet, context);
	}

	public static class Handler {
		public static boolean onMessage(StructureProtectionClearPacket message, Supplier<Context> ctx) {
			ctx.get().enqueueWork(() -> {
				DimensionSpecialEffects info = DimensionSpecialEffects.EFFECTS.get(TwilightForestMod.prefix("renderer"));

				// add weather box if needed
				if (info instanceof TwilightForestRenderInfo tfInfo) {
					TFWeatherRenderer weatherRenderer = tfInfo.getWeatherRenderHandler();

					if (weatherRenderer != null) {
						weatherRenderer.setProtectedBox(null);
					}
				}
			});

			return true;
		}
	}
}
