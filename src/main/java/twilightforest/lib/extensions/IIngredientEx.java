package twilightforest.lib.extensions;

import twilightforest.lib.crafting.IIngredientSerializer;

import net.minecraft.world.item.crafting.Ingredient;

public interface IIngredientEx {
    IIngredientSerializer<? extends Ingredient> getSerializer();

    boolean isSimple();

    default void invalidate() {}
}
