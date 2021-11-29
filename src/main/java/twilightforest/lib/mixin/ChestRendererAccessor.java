package twilightforest.lib.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.blockentity.ChestRenderer;

@Mixin(ChestRenderer.class)
public interface ChestRendererAccessor {
    @Accessor
    ModelPart getDoubleLeftLid();

    @Accessor
    ModelPart getDoubleLeftLock();

    @Accessor
    ModelPart getDoubleLeftBottom();

    @Invoker
    void callRender(PoseStack matrixStack, VertexConsumer buffer, ModelPart chestLid, ModelPart chestLatch, ModelPart chestBottom, float lidAngle, int combinedLight, int combinedOverlay);

    @Accessor
    ModelPart getDoubleRightLid();

    @Accessor
    ModelPart getDoubleRightLock();

    @Accessor
    ModelPart getDoubleRightBottom();

    @Accessor
    ModelPart getLid();

    @Accessor
    ModelPart getLock();

    @Accessor
    ModelPart getBottom();

    @Accessor
    boolean isXmasTextures();
}
