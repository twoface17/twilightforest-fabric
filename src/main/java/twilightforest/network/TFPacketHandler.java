package twilightforest.network;

import net.fabricmc.api.EnvType;
import twilightforest.TFConstants;
import twilightforest.TwilightForestMod;

public class TFPacketHandler {
	// Bump this number every time theres a breaking change, to ensure people dont mess things up when joining on the wrong version
	private static final String PROTOCOL_VERSION = "2";
	public static final NetworkWrapper CHANNEL = new NetworkWrapper(TwilightForestMod.prefix("channel"));

	@SuppressWarnings("UnusedAssignment")
	public static void init() {
		int id = 0;
		CHANNEL.registerPacket(AreaProtectionPacket.class, AreaProtectionPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(ChangeBiomePacket.class, ChangeBiomePacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(EnforceProgressionStatusPacket.class, EnforceProgressionStatusPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(StructureProtectionPacket.class, StructureProtectionPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(StructureProtectionClearPacket.class, StructureProtectionClearPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(ThrowPlayerPacket.class, ThrowPlayerPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(MagicMapPacket.class, MagicMapPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(MazeMapPacket.class, MazeMapPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(UpdateShieldPacket.class, UpdateShieldPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(UncraftingGuiPacket.class, UncraftingGuiPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(UpdateTFMultipartPacket.class, UpdateTFMultipartPacket::new, EnvType.CLIENT);
		CHANNEL.registerPacket(SpawnFallenLeafFromPacket.class, SpawnFallenLeafFromPacket::new, EnvType.CLIENT);
		CHANNEL.messageBuilder(MissingAdvancementToastPacket.class, id++).encoder(MissingAdvancementToastPacket::encode).decoder(MissingAdvancementToastPacket::new).consumer(MissingAdvancementToastPacket::handle).add();
	}
}
