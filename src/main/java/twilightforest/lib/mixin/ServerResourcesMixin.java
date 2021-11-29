package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import twilightforest.lib.events.ResourceListenerCallback;

import net.minecraft.commands.Commands;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.ServerResources;
import net.minecraft.server.packs.resources.ReloadableResourceManager;

@Mixin(ServerResources.class)
public class ServerResourcesMixin {
    @Shadow @Final private ReloadableResourceManager resources;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void reload(RegistryAccess registryAccess, Commands.CommandSelection commandSelection, int i, CallbackInfo ci) {
        ResourceListenerCallback.EVENT.invoker().reloadListeners((ServerResources) (Object) this).forEach(resources::registerReloadListener);
    }
}
