package twilightforest.lib.util;

import net.minecraft.nbt.CompoundTag;

public interface NBTSerializable {
    CompoundTag serializeNBT();

    void deserializeNBT(CompoundTag nbt);
}
