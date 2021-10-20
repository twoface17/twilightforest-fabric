package twilightforest.api.mixin;

import org.spongepowered.asm.mixin.Mixin;
import twilightforest.api.extensions.IBlockMethods;

import net.minecraft.world.level.block.Block;

@Mixin(Block.class)
public class BlockMixin implements IBlockMethods {
}
