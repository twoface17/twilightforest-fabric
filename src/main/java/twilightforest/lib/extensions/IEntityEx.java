package twilightforest.lib.extensions;

import twilightforest.lib.entity.PartEntity;
import twilightforest.world.TFTeleporter;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public interface IEntityEx {
    default boolean isMultipartEntity()
    {
        return false;
    }

    @Nullable
    default PartEntity<?>[] getParts()
    {
        return null;
    }

    default Entity changeDimension(ServerLevel pServer, TFTeleporter teleporter) {
        return ((Entity)this).changeDimension(pServer);
    }

    default CompoundTag getPersistentData() {
        return null;
    };

    default boolean canRiderInteract() {
        return false;
    }

    static IEntityEx cast(Entity entity) {
        if(entity instanceof IEntityEx partEntity)
            return partEntity;
        throw new ClassCastException();
    }
}
