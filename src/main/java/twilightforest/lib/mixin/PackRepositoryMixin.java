package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import twilightforest.lib.events.AddPackFindersCallback;

import java.util.Set;

import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.RepositorySource;

@Mixin(PackRepository.class)
public class PackRepositoryMixin {
    @Shadow @Final public Set<RepositorySource> sources;

    @Inject(method = "<init>(Lnet/minecraft/server/packs/PackType;[Lnet/minecraft/server/packs/repository/RepositorySource;)V", at = @At("TAIL"))
    public void addPacks(PackType packType, RepositorySource[] repositorySources, CallbackInfo ci) {
        AddPackFindersCallback.EVENT.invoker().addPacks(packType, sources::add);
    }
}
