package twilightforest.lib.util;

import net.minecraft.world.item.ItemStack;

public class ItemUtil {
    public static ItemStack copyStackWithSize(ItemStack stack, int size) {
        if (size == 0) return ItemStack.EMPTY;
        ItemStack copy = stack.copy();
        copy.setCount(size);
        return copy;
    }
}
