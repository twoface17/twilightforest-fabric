package twilightforest.api.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import twilightforest.ASMHooks;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixinPatch {
    @ModifyVariable(method = "getEntityOrPart", at=@At(value = "STORE", ordinal = 0))
    private Entity multipartFromID(Entity entity, int id){
        return ASMHooks.multipartFromID(entity, id);
    }
}
