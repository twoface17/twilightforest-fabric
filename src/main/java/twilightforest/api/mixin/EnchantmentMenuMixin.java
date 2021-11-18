package twilightforest.api.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import twilightforest.api.extensions.IBlockMethods;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(EnchantmentMenu.class)
public class EnchantmentMenuMixin {

    @SuppressWarnings("target")
    @ModifyVariable(
            method = "lambda$slotsChanged$0(Lnet/minecraft/world/item/ItemStack;" +
                    "Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V",
            at = @At(value = "STORE", ordinal = 0),
            ordinal = 0
    )
    private int tfBookshelfEnchanting(int obj, ItemStack stack, Level level, BlockPos pos) {
        for (int x = -1; x <= 1; ++x) {
            for (int z = -1; z <= 1; ++z) {
                if ((x != 0 || z != 0) && level.isEmptyBlock(pos.offset(x, 0, z)) && level.isEmptyBlock(pos.offset(x, 1, z))) {
                    obj += getPower(level.getBlockState(pos.offset(x * 2, 0, z * 2)), level, pos);
                    obj += getPower(level.getBlockState(pos.offset(x * 2, 1, z * 2)), level, pos);
                    if (x != 0 && z != 0) {
                        obj += getPower(level.getBlockState(pos.offset(x * 2, 0, z)), level, pos);
                        obj += getPower(level.getBlockState(pos.offset(x * 2, 1, z)), level, pos);
                        obj += getPower(level.getBlockState(pos.offset(x, 0, z * 2)), level, pos);
                        obj += getPower(level.getBlockState(pos.offset(x, 1, z * 2)), level, pos);
                    }
                }
            }
        }
        return obj;
    }

    @Unique
    private float getPower(BlockState state, LevelReader level, BlockPos offset) {
        return ((IBlockMethods)state.getBlock()).getEnchantPowerBonus(state, level, offset);
    }
}
