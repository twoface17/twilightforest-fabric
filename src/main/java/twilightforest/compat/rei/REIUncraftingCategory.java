package twilightforest.compat.rei;

import me.shedaniel.rei.api.client.gui.DisplayRenderer;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import twilightforest.TwilightForestMod;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class REIUncraftingCategory implements DisplayCategory<REIUncraftingDisplay> {

    public static CategoryIdentifier UNCRAFTING = CategoryIdentifier.of(TwilightForestMod.prefix("uncrafting_jei"));
    public static final int width = 116;
    public static final int height = 54;
    private final DisplayRenderer background;
    private final Renderer icon;
    private final TranslatableComponent localizedName;
    @Override
    public Renderer getIcon() {
        return icon;
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public CategoryIdentifier<? extends REIUncraftingDisplay> getCategoryIdentifier() {
        return UNCRAFTING;
    }
}
