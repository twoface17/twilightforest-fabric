package twilightforest.api.extensions;

import twilightforest.api.crafting.IIngredientSerializer;

import net.minecraft.world.item.crafting.Ingredient;

public interface IIngredientEx {
    IIngredientSerializer<? extends Ingredient> getSerializer();

    boolean isSimple();

    default void invalidate() {}
}
