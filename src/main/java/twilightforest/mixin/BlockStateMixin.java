package twilightforest.mixin;

import org.spongepowered.asm.mixin.Mixin;
import twilightforest.api.extensions.IBlockStateEx;

import net.minecraft.world.level.block.state.BlockState;

@Mixin(BlockState.class)
public class BlockStateMixin implements IBlockStateEx {
}
