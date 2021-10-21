package twilightforest.api.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import twilightforest.client.TFClientEvents;

import java.util.Set;
import java.util.stream.Stream;

import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

@Mixin(TextureAtlas.class)
public class TextureAtlasMixin {
    @Inject(method = "prepareToStitch", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V", ordinal = 0, shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void stitchModels(ResourceManager resourceManager, Stream<ResourceLocation> resourceLocations, ProfilerFiller profiler, int maxMipmapLevel, CallbackInfoReturnable<TextureAtlas.Preparations> cir, Set<ResourceLocation> set) {
        TFClientEvents.texStitch(((TextureAtlas) (Object) this), set);
    }
}
