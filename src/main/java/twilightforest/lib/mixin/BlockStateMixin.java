package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import twilightforest.lib.extensions.IBlockStateEx;

import net.minecraft.world.level.block.state.BlockState;

@Mixin(BlockState.class)
public class BlockStateMixin implements IBlockStateEx {
}
