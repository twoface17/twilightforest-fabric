package twilightforest.item.recipe;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import twilightforest.TwilightForestMod;
import twilightforest.lib.RegistryObject;
import twilightforest.lib.TFRegistry;

public class TFRecipes {
	public static final TFRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = TFRegistry.create(Registry.RECIPE_SERIALIZER, TwilightForestMod.ID);

	public static final RegistryObject<SimpleRecipeSerializer<?>> MOONWORM_QUEEN_REPAIR_RECIPE = RECIPE_SERIALIZERS.register("moonworm_queen_repair_recipe", () -> new SimpleRecipeSerializer<>(MoonwormQueenRepairRecipe::new));
	public static final RegistryObject<RecipeSerializer<UncraftingRecipe>> UNCRAFTING_SERIALIZER = RECIPE_SERIALIZERS.register("uncrafting", UncraftingRecipe.Serializer::new);

	public static final RecipeType<UncraftingRecipe> UNCRAFTING_RECIPE = RecipeType.register("twilightforest:unique_uncrafting");
}
