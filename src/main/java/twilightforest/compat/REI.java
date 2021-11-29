package twilightforest.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.screen.ExclusionZones;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.client.UncraftingGui;

import java.util.List;

import net.minecraft.world.item.ItemStack;

public class REI implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.addWorkstations(REICommon.CRAFTING, EntryIngredients.of(new ItemStack(TFBlocks.UNCRAFTING_TABLE.get())));
        registry.addWorkstations(REIUncraftingCategory.UNCRAFTING, EntryIngredients.of(new ItemStack(TFBlocks.UNCRAFTING_TABLE.get())));
    }

    @Override
    public void registerExclusionZones(ExclusionZones zones) {
        zones.register(UncraftingGui.class, (screen -> List.of(new Rectangle(34, 33, 27, 20))));
        zones.register(UncraftingGui.class, (screen -> List.of(new Rectangle(115, 33, 27, 20))));
    }

    @Override
    public String getPluginProviderName() {
        return TwilightForestMod.prefix("rei_plugin").toString();
    }
}
