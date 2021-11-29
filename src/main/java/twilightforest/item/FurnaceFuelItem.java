package twilightforest.item;

import twilightforest.lib.extensions.IItemEx;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

import javax.annotation.Nullable;

public class FurnaceFuelItem extends BlockItem implements IItemEx {
    private final int burntime;

    public FurnaceFuelItem(Block block, Properties properties, int burn) {
        super(block, properties);
        this.burntime = burn;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return burntime;
    }
}
