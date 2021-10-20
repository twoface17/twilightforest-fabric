package twilightforest.api.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import twilightforest.ASMHooks;
import twilightforest.client.model.entity.PartEntity;
import twilightforest.api.extensions.IEntityEx;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRenderDispatcherMixin {
    @Shadow public abstract <T extends Entity> EntityRenderer<? super T> getRenderer(T entity);

    //TODO: Double Check that this is a proper replacement
    @Inject(method = "renderHitbox", at=@At(value = "HEAD"))
    private static void multiPartRenderHitbox(PoseStack poseStack, VertexConsumer matrixStack, Entity buffer, float entity, CallbackInfo ci) {
        if (((IEntityEx)buffer).isMultipartEntity()) {
            double d0 = -Mth.lerp(entity, buffer.xOld, buffer.getX());
            double d1 = -Mth.lerp(entity, buffer.yOld, buffer.getY());
            double d2 = -Mth.lerp(entity, buffer.zOld, buffer.getZ());

            for(PartEntity<?> multiPart : ((IEntityEx)buffer).getParts()) {
                poseStack.pushPose();
                double d3 = d0 + Mth.lerp(entity, multiPart.xOld, multiPart.getX());
                double d4 = d1 + Mth.lerp(entity, multiPart.yOld, multiPart.getY());
                double d5 = d2 + Mth.lerp(entity, multiPart.zOld, multiPart.getZ());
                poseStack.translate(d3, d4, d5);
                LevelRenderer.renderLineBox(poseStack, matrixStack, multiPart.getBoundingBox().move(-multiPart.getX(), -multiPart.getY(), -multiPart.getZ()), 0.25F, 1.0F, 0.0F, 1.0F);
                poseStack.popPose();
            }
        }
    }

    @Inject(method = "onResourceManagerReload", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void nonAsmCursedness(ResourceManager resourceManager, CallbackInfo ci, EntityRendererProvider.Context context) {
        ASMHooks.bakeMultipartRenders(context);
    }

//    @Inject(method = "getRenderer", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
//    public <T extends Entity> void getMultipartRenderer(T entity, CallbackInfoReturnable<EntityRenderer<? super T>> cir) {
//        cir.setReturnValue((EntityRenderer<? super T>) ASMHooks.getMultipartRenderer(this.renderers.get(entity.getType()), entity));
//    }
}
