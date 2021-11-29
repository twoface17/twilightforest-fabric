package twilightforest.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import java.util.List;

public class REIUncraftingDisplay implements Display {
    @Override
    public List<EntryIngredient> getInputEntries() {
        return null;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return null;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return REIUncraftingCategory.UNCRAFTING;
    }
}
