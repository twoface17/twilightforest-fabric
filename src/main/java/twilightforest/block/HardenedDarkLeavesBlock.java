package twilightforest.block;

import net.fabricmc.fabric.api.block.BlockPickInteractionAware;
import org.jetbrains.annotations.Nullable;
import twilightforest.lib.extensions.IBlockMethods;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

public class HardenedDarkLeavesBlock extends Block implements IBlockMethods, BlockPickInteractionAware {

	protected HardenedDarkLeavesBlock(Properties props) {
		super(props);
	}

    @Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 1;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 0;
	}

	@Override
	public ItemStack getPickedStack(BlockState state, BlockGetter view, BlockPos pos, @Nullable Player player, @Nullable HitResult result) {
		return new ItemStack(TFBlocks.DARK_LEAVES.get());
	}
}
