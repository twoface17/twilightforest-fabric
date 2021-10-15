package twilightforest.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.level.entity.LevelEntityGetter;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import twilightforest.ASMHooks;

import javax.annotation.Nullable;

@Mixin(ServerLevel.class)
@Debug(export = true)
public abstract class ServerLevelMixinPatch {

    @Unique
    int cachedID;

    @Inject(method = "getEntityOrPart", at=@At(value = "HEAD"))
    public void grabEntityID(int i, CallbackInfoReturnable<Entity> cir){
        cachedID = i;
    }

    @ModifyVariable(method = "getEntityOrPart", at=@At(value = "STORE", ordinal = 0))
    private Entity multipartFromID(Entity entity){
        return ASMHooks.multipartFromID(entity, cachedID);
    }

}
