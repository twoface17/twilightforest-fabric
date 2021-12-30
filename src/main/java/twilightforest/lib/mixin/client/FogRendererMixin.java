package twilightforest.lib.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import twilightforest.lib.events.EntityViewEvents;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;

@Mixin(FogRenderer.class)
public class FogRendererMixin {
    @Shadow private static float fogRed;

    @Shadow private static float fogGreen;

    @Shadow private static float fogBlue;

//    @Inject(method = "setupColor", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V"), cancellable = true)
//    private static void fogHook(Camera activeRenderInfo, float partialTicks, ClientLevel level, int renderDistanceChunks, float bossColorModifier, CallbackInfo ci) {
//        Color color = FogHandler.fogColors(activeRenderInfo, partialTicks, fogRed, fogGreen, fogBlue);
//        fogRed = color.getRed();
//        fogGreen = color.getGreen();
//        fogBlue = color.getBlue();
//    }

//    @Inject(method = "setupFog", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogEnd(F)V", ordinal = 1, shift = At.Shift.AFTER))
//    private static void fogRenderEvent(Camera activeRenderInfo, FogRenderer.FogMode fogType, float farPlaneDistance, boolean nearFog, CallbackInfo ci) {
        //EntityViewEvents.FOG_RENDER.invoker().onFogRender(fogType, activeRenderInfo, );
//    }
}
