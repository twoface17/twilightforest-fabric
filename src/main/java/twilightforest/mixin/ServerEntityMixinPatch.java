package twilightforest.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import twilightforest.ASMHooks;
import twilightforest.TFEventListener;

import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

@Mixin(ServerEntity.class)
public class ServerEntityMixinPatch {
    @Shadow @Final private Entity entity;

    @Inject(method = "addPairing", at = @At("TAIL"))
    public void trackPlayer(ServerPlayer player, CallbackInfo ci) {
        TFEventListener.onStartTracking(player, this.entity);
    }

    @Inject(method = "sendDirtyEntityData", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/entity/Entity;getEntityData()Lnet/minecraft/network/syncher/SynchedEntityData;"))
    public void updateMultiparts(CallbackInfo ci) {
        ASMHooks.updateMultiparts(this.entity);
    }
}
