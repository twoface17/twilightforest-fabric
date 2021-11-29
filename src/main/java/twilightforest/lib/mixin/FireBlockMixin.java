package twilightforest.lib.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;

import twilightforest.block.CompressedBlock;

import java.util.Random;

@Mixin(FireBlock.class)
public class FireBlockMixin {

    @ModifyVariable(method = "tick", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/Tag;)Z"))
    public boolean isFireBlock(boolean bl, BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(level.getBlockState(pos.below()).getBlock() instanceof CompressedBlock block){
            return block.isFireSource(level.getBlockState(pos.below()), level, pos, Direction.UP); //Direction dosn't matter
        }
        else{
            return bl;
        }
    }
}
