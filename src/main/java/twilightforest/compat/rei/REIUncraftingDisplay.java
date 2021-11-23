package twilightforest.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.List;

import net.minecraft.world.item.crafting.CraftingRecipe;

public class REIUncraftingDisplay implements Display {

    private final CraftingRecipe recipe;

    public REIUncraftingDisplay(CraftingRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return EntryIngredients.ofIngredients(recipe.getIngredients());
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(EntryIngredients.of(recipe.getResultItem()));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return REIUncraftingCategory.UNCRAFTING;
    }

    public CraftingRecipe getRecipe() {
        return recipe;
    }
}
