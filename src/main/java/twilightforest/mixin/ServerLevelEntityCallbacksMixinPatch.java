package twilightforest.mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import twilightforest.ASMHooks;

@Mixin(ServerLevel.EntityCallbacks.class)
public class ServerLevelEntityCallbacksMixinPatch {
    @Inject(method = "onTrackingStart", at = @At("HEAD"))
    public void multiPartTrackingStart(Entity entity, CallbackInfo ci){
        ASMHooks.trackingStart(entity);
    }

    @Inject(method = "onTrackingEnd", at = @At("HEAD"))
    public void multiPartTrackingEnd(Entity entity, CallbackInfo ci){
        ASMHooks.trackingEnd(entity);
    }
}
