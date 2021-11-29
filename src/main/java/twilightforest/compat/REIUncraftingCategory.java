package twilightforest.compat;

import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import twilightforest.TwilightForestMod;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.CraftingRecipe;

public class REIUncraftingCategory implements DisplayCategory<REIUncraftingDisplay> {
    public static CategoryIdentifier UNCRAFTING = CategoryIdentifier.of(TwilightForestMod.prefix("uncrafting_rei"));

    @Override
    public Renderer getIcon() {
        return null;
    }

    @Override
    public Component getTitle() {
        return null;
    }

    @Override
    public CategoryIdentifier<? extends REIUncraftingDisplay> getCategoryIdentifier() {
        return UNCRAFTING;
    }
}
