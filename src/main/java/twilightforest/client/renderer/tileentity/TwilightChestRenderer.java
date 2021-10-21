package twilightforest.client.renderer.tileentity;

import com.google.common.collect.ImmutableMap;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import twilightforest.TwilightForestMod;
import twilightforest.api.mixin.ChestRendererAccessor;
import twilightforest.api.mixin.ModelBakeryAccessor;
import twilightforest.block.TFBlocks;
import twilightforest.block.entity.TwilightChestEntity;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwilightChestRenderer<T extends TwilightChestEntity> extends ChestRenderer<T> {
    public static final Map<Block, EnumMap<ChestType, Material>> MATERIALS;

    static {
        ImmutableMap.Builder<Block, EnumMap<ChestType, Material>> builder = ImmutableMap.builder();

        builder.put(TFBlocks.TWILIGHT_OAK_CHEST, chestMaterial("twilight"));
        builder.put(TFBlocks.CANOPY_CHEST, chestMaterial("canopy"));
        builder.put(TFBlocks.MANGROVE_CHEST, chestMaterial("mangrove"));
        builder.put(TFBlocks.DARKWOOD_CHEST, chestMaterial("darkwood"));
        builder.put(TFBlocks.TIME_CHEST, chestMaterial("time"));
        builder.put(TFBlocks.TRANSFORMATION_CHEST, chestMaterial("trans"));
        builder.put(TFBlocks.MINING_CHEST, chestMaterial("mining"));
        builder.put(TFBlocks.SORTING_CHEST, chestMaterial("sort"));

        MATERIALS = builder.build();

        ModelBakeryAccessor.getUNREFERENCED_TEXTURES().addAll(MATERIALS.values().stream().flatMap(e -> e.values().stream()).collect(Collectors.toList()));
    }

    public TwilightChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(T pBlockEntity, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pCombinedLight, int pCombinedOverlay) {
        Level level = pBlockEntity.getLevel();
        boolean flag = level != null;
        BlockState blockstate = flag ? pBlockEntity.getBlockState() : Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
        ChestType chesttype = blockstate.hasProperty(ChestBlock.TYPE) ? blockstate.getValue(ChestBlock.TYPE) : ChestType.SINGLE;
        Block block = blockstate.getBlock();
        if (block instanceof AbstractChestBlock) {
            AbstractChestBlock<?> abstractchestblock = (AbstractChestBlock)block;
            boolean flag1 = chesttype != ChestType.SINGLE;
            pMatrixStack.pushPose();
            float f = blockstate.getValue(ChestBlock.FACING).toYRot();
            pMatrixStack.translate(0.5D, 0.5D, 0.5D);
            pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(-f));
            pMatrixStack.translate(-0.5D, -0.5D, -0.5D);
            DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> neighborcombineresult;
            if (flag) {
                neighborcombineresult = abstractchestblock.combine(blockstate, level, pBlockEntity.getBlockPos(), true);
            } else {
                neighborcombineresult = DoubleBlockCombiner.Combiner::acceptNone;
            }

            float f1 = neighborcombineresult.<Float2FloatFunction>apply(ChestBlock.opennessCombiner(pBlockEntity)).get(pPartialTicks);
            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            int i = neighborcombineresult.<Int2IntFunction>apply(new BrightnessCombiner<>()).applyAsInt(pCombinedLight);
            Material material = this.getMaterial(pBlockEntity, chesttype);
            VertexConsumer vertexconsumer = material.buffer(pBuffer, RenderType::entityCutout);
            if (flag1) {
                if (chesttype == ChestType.LEFT) {
                    ((ChestRendererAccessor)this).callRender(pMatrixStack, vertexconsumer, ((ChestRendererAccessor)this).getDoubleLeftLid(), ((ChestRendererAccessor)this).getDoubleLeftLock(), ((ChestRendererAccessor)this).getDoubleLeftBottom(), f1, i, pCombinedOverlay);
                } else {
                    ((ChestRendererAccessor)this).callRender(pMatrixStack, vertexconsumer, ((ChestRendererAccessor)this).getDoubleRightLid(), ((ChestRendererAccessor)this).getDoubleRightLock(), ((ChestRendererAccessor)this).getDoubleRightBottom(), f1, i, pCombinedOverlay);
                }
            } else {
                ((ChestRendererAccessor)this).callRender(pMatrixStack, vertexconsumer, ((ChestRendererAccessor)this).getLid(), ((ChestRendererAccessor)this).getLock(), ((ChestRendererAccessor)this).getBottom(), f1, i, pCombinedOverlay);
            }

            pMatrixStack.popPose();
        }
    }

    protected Material getMaterial(T blockEntity, ChestType chestType) {
        EnumMap<ChestType, Material> b = MATERIALS.get(blockEntity.getBlockState().getBlock());

        if (b == null) return Sheets.chooseMaterial(blockEntity, chestType, ((ChestRendererAccessor)this).isXmasTextures());

        Material material = b.get(chestType);

        return material != null ? material : Sheets.chooseMaterial(blockEntity, chestType, ((ChestRendererAccessor)this).isXmasTextures());
    }

    private static EnumMap<ChestType, Material> chestMaterial(String type) {
        EnumMap<ChestType, Material> map = new EnumMap<>(ChestType.class);

        map.put(ChestType.SINGLE, new Material(Sheets.CHEST_SHEET, TwilightForestMod.prefix("model/chest/" + type + "/" + type)));
        map.put(ChestType.LEFT, new Material(Sheets.CHEST_SHEET, TwilightForestMod.prefix("model/chest/" + type + "/left")));
        map.put(ChestType.RIGHT, new Material(Sheets.CHEST_SHEET, TwilightForestMod.prefix("model/chest/" + type + "/right")));

        return map;
    }
}
