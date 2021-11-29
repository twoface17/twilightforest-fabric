package twilightforest.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import twilightforest.TwilightForestMod;
import twilightforest.lib.BasePacket;

import java.util.function.Supplier;

public class EnforceProgressionStatusPacket implements BasePacket<EnforceProgressionStatusPacket> {

	private final boolean enforce;

	public EnforceProgressionStatusPacket(FriendlyByteBuf buf) {
		this.enforce = buf.readBoolean();
	}

	public EnforceProgressionStatusPacket(boolean enforce) {
		this.enforce = enforce;
	}

	@Override
	public void encode(FriendlyByteBuf buf) {
		buf.writeBoolean(enforce);
	}

	@Override
	public void handle(EnforceProgressionStatusPacket packet, Context context) {
		Handler.onMessage(packet, context);
	}

	public static class Handler {

		public static boolean onMessage(EnforceProgressionStatusPacket message, Supplier<BasePacket.Context> ctx) {
			ctx.get().enqueueWork(new Runnable() {
				@Override
				public void run() {
					Minecraft.getInstance().level.getGameRules().getRule(TwilightForestMod.ENFORCED_PROGRESSION_RULE).set(message.enforce, null);
				}
			});
			return true;
		}
	}
}
