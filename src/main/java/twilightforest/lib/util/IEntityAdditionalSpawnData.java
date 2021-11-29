package twilightforest.lib.util;

import net.minecraft.network.FriendlyByteBuf;

public interface IEntityAdditionalSpawnData {
    void writeSpawnData(FriendlyByteBuf buffer);
    void readSpawnData(FriendlyByteBuf additionalData);
}
