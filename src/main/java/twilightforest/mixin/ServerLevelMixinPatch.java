package twilightforest.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import twilightforest.ASMHooks;

import javax.annotation.Nullable;

@Mixin(ServerLevel.class)
@Debug(export = true)
public class ServerLevelMixinPatch {

    @Unique
    int cachedID;

    @Inject(method = "getEntityOrPart", at=@At(value = "HEAD", shift = At.Shift.BY, ordinal = 2))
    public void multiPartGetEntityOrPart(int i, CallbackInfoReturnable<Entity> cir){
        cachedID = i;
    }

    @ModifyVariable(method = "getEntityOrPart", at=@At("RETURN"))
    public Entity multipartHitbox(@Nullable Entity o){
        Entity entity = ((ServerLevel) (Object) this).getEntities().get(cachedID);
        return ASMHooks.multipartFromID(o, cachedID);
    }
}
