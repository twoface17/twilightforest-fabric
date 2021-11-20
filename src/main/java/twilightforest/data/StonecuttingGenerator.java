package twilightforest.data;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;

import javax.annotation.Nullable;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import static twilightforest.TwilightForestMod.prefix;

public class StonecuttingGenerator extends RecipeProvider {
	public StonecuttingGenerator(DataGenerator generator) {
		super(generator);
	}

	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		consumer.accept(stonecutting(TFBlocks.CASTLE_BRICK, TFBlocks.THICK_CASTLE_BRICK));
		consumer.accept(stonecutting(TFBlocks.CRACKED_CASTLE_BRICK, TFBlocks.THICK_CASTLE_BRICK));
		consumer.accept(stonecutting(TFBlocks.WORN_CASTLE_BRICK, TFBlocks.THICK_CASTLE_BRICK));
		consumer.accept(stonecutting(TFBlocks.MOSSY_CASTLE_BRICK, TFBlocks.THICK_CASTLE_BRICK));

		consumer.accept(stonecutting(TFBlocks.CASTLE_BRICK, TFBlocks.WORN_CASTLE_BRICK));
		consumer.accept(stonecutting(TFBlocks.THICK_CASTLE_BRICK, TFBlocks.BOLD_CASTLE_BRICK_PILLAR));
		consumer.accept(stonecutting(TFBlocks.BOLD_CASTLE_BRICK_PILLAR, TFBlocks.BOLD_CASTLE_BRICK_TILE));
		consumer.accept(stonecutting(TFBlocks.ENCASED_CASTLE_BRICK_PILLAR, TFBlocks.ENCASED_CASTLE_BRICK_TILE));

		consumer.accept(stonecutting(TFBlocks.ENCASED_CASTLE_BRICK_PILLAR, TFBlocks.ENCASED_CASTLE_BRICK_STAIRS));
		consumer.accept(stonecutting(TFBlocks.BOLD_CASTLE_BRICK_PILLAR, TFBlocks.BOLD_CASTLE_BRICK_STAIRS));
		consumer.accept(stonecutting(TFBlocks.CASTLE_BRICK, TFBlocks.CASTLE_BRICK_STAIRS));
		consumer.accept(stonecutting(TFBlocks.WORN_CASTLE_BRICK, TFBlocks.WORN_CASTLE_BRICK_STAIRS));
		consumer.accept(stonecutting(TFBlocks.CRACKED_CASTLE_BRICK, TFBlocks.CRACKED_CASTLE_BRICK_STAIRS));
		consumer.accept(stonecutting(TFBlocks.MOSSY_CASTLE_BRICK, TFBlocks.MOSSY_CASTLE_BRICK_STAIRS));

		consumer.accept(stonecutting(TFBlocks.ETCHED_NAGASTONE, TFBlocks.NAGASTONE_STAIRS_LEFT));
		consumer.accept(stonecutting(TFBlocks.ETCHED_NAGASTONE, TFBlocks.NAGASTONE_STAIRS_RIGHT));
		consumer.accept(stonecutting(TFBlocks.MOSSY_ETCHED_NAGASTONE, TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT));
		consumer.accept(stonecutting(TFBlocks.MOSSY_ETCHED_NAGASTONE, TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT));
		consumer.accept(stonecutting(TFBlocks.CRACKED_ETCHED_NAGASTONE, TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT));
		consumer.accept(stonecutting(TFBlocks.CRACKED_ETCHED_NAGASTONE, TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT));

		consumer.accept(stonecutting(TFBlocks.NAGASTONE_STAIRS_RIGHT, TFBlocks.NAGASTONE_STAIRS_LEFT));
		consumer.accept(stonecutting(TFBlocks.NAGASTONE_STAIRS_LEFT, TFBlocks.NAGASTONE_STAIRS_RIGHT));
		consumer.accept(stonecutting(TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT, TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT));
		consumer.accept(stonecutting(TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT, TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT));
		consumer.accept(stonecutting(TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT, TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT));
		consumer.accept(stonecutting(TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT, TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT));
		
		consumer.accept(stonecutting(TFBlocks.DARK_LOG, TFBlocks.TOWERWOOD));
		consumer.accept(stonecutting(TFBlocks.DARK_WOOD, TFBlocks.TOWERWOOD));
		consumer.accept(stonecutting(TFBlocks.TOWERWOOD, TFBlocks.ENCASED_TOWERWOOD));
		
		consumer.accept(stonecutting(TFBlocks.MAZESTONE, TFBlocks.MAZESTONE_BORDER));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE, TFBlocks.MAZESTONE_BRICK));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE, TFBlocks.CUT_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE, TFBlocks.DECORATIVE_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE, TFBlocks.MAZESTONE_MOSAIC));

		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BRICK, TFBlocks.MAZESTONE_BORDER));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BRICK, TFBlocks.CUT_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BRICK, TFBlocks.DECORATIVE_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BRICK, TFBlocks.MAZESTONE_MOSAIC));

		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BORDER, TFBlocks.MAZESTONE_BRICK));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BORDER, TFBlocks.CUT_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BORDER, TFBlocks.DECORATIVE_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_BORDER, TFBlocks.MAZESTONE_MOSAIC));

		consumer.accept(stonecutting(TFBlocks.CUT_MAZESTONE, TFBlocks.MAZESTONE_BORDER));
		consumer.accept(stonecutting(TFBlocks.CUT_MAZESTONE, TFBlocks.MAZESTONE_BRICK));
		consumer.accept(stonecutting(TFBlocks.CUT_MAZESTONE, TFBlocks.DECORATIVE_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.CUT_MAZESTONE, TFBlocks.MAZESTONE_MOSAIC));

		consumer.accept(stonecutting(TFBlocks.DECORATIVE_MAZESTONE, TFBlocks.MAZESTONE_BORDER));
		consumer.accept(stonecutting(TFBlocks.DECORATIVE_MAZESTONE, TFBlocks.CUT_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.DECORATIVE_MAZESTONE, TFBlocks.MAZESTONE_BRICK));
		consumer.accept(stonecutting(TFBlocks.DECORATIVE_MAZESTONE, TFBlocks.MAZESTONE_MOSAIC));

		consumer.accept(stonecutting(TFBlocks.MAZESTONE_MOSAIC, TFBlocks.MAZESTONE_BORDER));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_MOSAIC, TFBlocks.CUT_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_MOSAIC, TFBlocks.DECORATIVE_MAZESTONE));
		consumer.accept(stonecutting(TFBlocks.MAZESTONE_MOSAIC, TFBlocks.MAZESTONE_BRICK));

		consumer.accept(stonecutting(TFBlocks.TWILIGHT_OAK_LOG.get(), TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(TFBlocks.CANOPY_LOG.get(), TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(TFBlocks.MANGROVE_LOG.get(), TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(TFBlocks.DARK_LOG.get(), TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(TFBlocks.TIME_LOG.get(), TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(TFBlocks.TRANSFORMATION_LOG.get(), TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(TFBlocks.MINING_LOG.get(), TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(TFBlocks.SORTING_LOG.get(), TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL.get()));

		consumer.accept(stonecutting(Blocks.OAK_LOG, TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(Blocks.SPRUCE_LOG, TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(Blocks.BIRCH_LOG, TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(Blocks.JUNGLE_LOG, TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(Blocks.ACACIA_LOG, TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(Blocks.DARK_OAK_LOG, TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL.get()));
		consumer.accept(stonecutting(Blocks.CRIMSON_STEM, TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL.get()));
		consumer.accept(stonecutting(Blocks.WARPED_STEM, TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL.get()));

		consumer.accept(stonecutting(Blocks.STONE, TFBlocks.TWISTED_STONE));
		consumer.accept(stonecutting(Blocks.STONE, TFBlocks.BOLD_STONE_PILLAR));
	}

	@Override
	public String getName() {
		return "Twilight Forest stonecutting recipes";
	}

	private static Wrapper stonecutting(ItemLike input, ItemLike output) {
		return stonecutting(input, output, 1);
	}

	private static Wrapper stonecutting(ItemLike input, ItemLike output, int count) {
		return new Wrapper(getIdFor(input.asItem(), output.asItem()), Ingredient.of(input), output.asItem(), count);
	}

	private static ResourceLocation getIdFor(Item input, Item output) {
		String path = String.format("stonecutting/%s/%s", Registry.ITEM.getKey(input).getPath(), Registry.ITEM.getKey(output).getPath());
		return prefix(path);
	}

	// Wrapper that allows you to not have an advancement
	public static class Wrapper extends SingleItemRecipeBuilder.Result {
		public Wrapper(ResourceLocation id, Ingredient input, Item output, int count) {
			super(id, RecipeSerializer.STONECUTTER, "", input, output, count, null, null);
		}

		@Nullable
		@Override
		public JsonObject serializeAdvancement() {
			return null;
		}

		@Nullable
		@Override
		public ResourceLocation getAdvancementId() {
			return null;
		}
	}
}
