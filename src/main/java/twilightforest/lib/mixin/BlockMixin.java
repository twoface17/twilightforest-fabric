package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import twilightforest.lib.extensions.IBlockMethods;

import net.minecraft.world.level.block.Block;

@Mixin(Block.class)
public class BlockMixin implements IBlockMethods {
}
