package twilightforest.data;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.Ingredient;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;

public class CraftingGenerator extends CraftingDataHelper {
	public CraftingGenerator(DataGenerator generator) {
		super(generator);
	}

	@Override
	public void run(HashCache cache) {
		super.run(cache);
		Path path = this.generator.getOutputFolder();
		Set<ResourceLocation> set = Sets.newHashSet();
		buildCraftingRecipes((recipe) -> {
			if (!set.add(recipe.getId())) {
				throw new IllegalStateException("Duplicate recipe " + recipe.getId());
			} else {
				saveRecipe(cache, recipe.serializeRecipe(), path.resolve("data/" + recipe.getId().getNamespace() + "/recipes/" + recipe.getId().getPath() + ".json"));
				JsonObject jsonobject = recipe.serializeAdvancement();
				if (jsonobject != null) {
					saveAdvancement(cache, jsonobject, path.resolve("data/" + recipe.getId().getNamespace() + "/advancements/" + recipe.getAdvancementId().getPath() + ".json"));
				}
			}
		});
	}

	//@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		// The Recipe Builder currently doesn't support enchantment-resulting recipes, those must be manually created.
		blockCompressionRecipes(consumer);
		equipmentRecipes(consumer);
		emptyMapRecipes(consumer);
		woodRecipes(consumer);
		fieryConversions(consumer);

		nagastoneRecipes(consumer);
		darkTowerRecipes(consumer);
		castleRecipes(consumer);

		bannerPattern(consumer, "naga_banner_pattern", TFBlocks.NAGA_TROPHY, TFItems.NAGA_BANNER_PATTERN);
		bannerPattern(consumer, "lich_banner_pattern", TFBlocks.LICH_TROPHY, TFItems.LICH_BANNER_PATTERN);
		bannerPattern(consumer, "minoshroom_banner_pattern", TFBlocks.MINOSHROOM_TROPHY, TFItems.MINOSHROOM_BANNER_PATTERN);
		bannerPattern(consumer, "hydra_banner_pattern", TFBlocks.HYDRA_TROPHY, TFItems.HYDRA_BANNER_PATTERN);
		bannerPattern(consumer, "knight_phantom_banner_pattern", TFBlocks.KNIGHT_PHANTOM_TROPHY, TFItems.KNIGHT_PHANTOM_BANNER_PATTERN);
		bannerPattern(consumer, "ur_ghast_banner_pattern", TFBlocks.UR_GHAST_TROPHY, TFItems.UR_GHAST_BANNER_PATTERN);
		bannerPattern(consumer, "alpha_yeti_banner_pattern", TFBlocks.ALPHA_YETI_TROPHY, TFItems.ALPHA_YETI_BANNER_PATTERN);
		bannerPattern(consumer, "snow_queen_banner_pattern", TFBlocks.SNOW_QUEEN_TROPHY, TFItems.SNOW_QUEEN_BANNER_PATTERN);
		bannerPattern(consumer, "questing_ram_banner_pattern", TFBlocks.QUEST_RAM_TROPHY, TFItems.QUEST_RAM_BANNER_PATTERN);

		slabBlock(consumer, "aurora_slab", TFBlocks.AURORA_SLAB, TFBlocks.AURORA_BLOCK);
		ShapedRecipeBuilder.shaped(TFBlocks.AURORA_PILLAR, 2)
				.pattern("#")
				.pattern("#")
				.define('#', Ingredient.of(TFBlocks.AURORA_BLOCK))
				.unlockedBy("has_" + Registry.BLOCK.getKey(TFBlocks.AURORA_PILLAR).getPath(), has(TFBlocks.AURORA_PILLAR))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFBlocks.IRON_LADDER, 3)
				.pattern("-#-")
				.pattern("-#-")
				.define('#', Ingredient.of(Blocks.IRON_BARS))
				.define('-', Items.GOLD_NUGGET)
				.unlockedBy("has_" + Registry.BLOCK.getKey(TFBlocks.IRON_LADDER).getPath(), has(TFBlocks.IRON_LADDER))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(TFBlocks.FIREFLY_JAR)
				.requires(Ingredient.of(TFBlocks.FIREFLY))
				.requires(Ingredient.of(Items.GLASS_BOTTLE))
				.unlockedBy("has_item", has(TFBlocks.FIREFLY))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(TFBlocks.FIREFLY_SPAWNER)
				.requires(Ingredient.of(TFBlocks.FIREFLY_JAR))
				.requires(Ingredient.of(TFBlocks.FIREFLY))
				.requires(Ingredient.of(Blocks.POPPY))
				.unlockedBy("has_jar", has(TFBlocks.FIREFLY_JAR))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(TFBlocks.CICADA_JAR)
				.requires(Ingredient.of(TFBlocks.CICADA))
				.requires(Ingredient.of(Items.GLASS_BOTTLE))
				.unlockedBy("has_item", has(TFBlocks.CICADA))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(Items.MAGENTA_DYE)
				.requires(Ingredient.of(TFBlocks.HUGE_WATER_LILY))
				.unlockedBy("has_item", has(TFBlocks.HUGE_WATER_LILY))
				.save(consumer, TwilightForestMod.prefix("waterlily_to_magenta"));

		ShapelessRecipeBuilder.shapeless(Items.RED_DYE)
				.requires(Ingredient.of(TFBlocks.THORN_ROSE))
				.unlockedBy("has_item", has(TFBlocks.THORN_ROSE))
				.save(consumer, TwilightForestMod.prefix("thorn_rose_to_red"));

		ShapelessRecipeBuilder.shapeless(Items.STICK)
				.requires(Ingredient.of(TFBlocks.ROOT_STRAND))
				.unlockedBy("has_item", has(TFBlocks.ROOT_STRAND))
				.save(consumer, TwilightForestMod.prefix("root_stick"));

		ShapedRecipeBuilder.shaped(Blocks.TORCH, 5)
				.pattern("∴")
				.pattern("|")
				.define('∴', Ingredient.of(TFItems.TORCHBERRIES))
				.define('|', Items.STICK)
				.unlockedBy("has_item", has(TFItems.TORCHBERRIES))
				.save(consumer, TwilightForestMod.prefix("berry_torch"));

//		ConditionalRecipe.builder()
//				.addCondition(new UncraftingEnabledCondition())
//				.addRecipe(ShapedRecipeBuilder.shaped(TFBlocks.UNCRAFTING_TABLE)
//						.pattern("###")
//						.pattern("#X#")
//						.pattern("###")
//						.define('#', Blocks.CRAFTING_TABLE)
//						.define('X', TFItems.MAZE_MAP_FOCUS)
//						.unlockedBy("has_uncrafting_table", has(TFBlocks.UNCRAFTING_TABLE))
//						::save)
//				.build(consumer, TwilightForestMod.prefix("uncrafting_table"));

		// Patchouli books would also go here, except they also must craft-result with NBT data.

		cookingRecipes(consumer, "smelted", RecipeSerializer.SMELTING_RECIPE, 200);
		cookingRecipes(consumer, "smoked", RecipeSerializer.SMOKING_RECIPE, 100);
		cookingRecipes(consumer, "campfired", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 600);

		ingotRecipes(consumer, "smelted", RecipeSerializer.SMELTING_RECIPE, 200);
		ingotRecipes(consumer, "blasted", RecipeSerializer.BLASTING_RECIPE, 100);

		crackedWoodRecipes(consumer, "smoked", RecipeSerializer.SMOKING_RECIPE, 100);
		crackedStoneRecipes(consumer, "smelted", RecipeSerializer.SMELTING_RECIPE, 200);

		ShapedRecipeBuilder.shaped(TFBlocks.EMPTY_CANOPY_BOOKSHELF)
				.pattern("---")
				.pattern("   ")
				.pattern("---")
				.define('-', TFBlocks.CANOPY_SLAB)
				.unlockedBy("has_item", has(TFBlocks.CANOPY_SLAB))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFBlocks.CANOPY_BOOKSHELF)
				.pattern("---")
				.pattern("BBB")
				.pattern("---")
				.define('-', TFBlocks.CANOPY_PLANKS)
				.define('B', Items.BOOK)
				.unlockedBy("has_item", has(TFBlocks.CANOPY_PLANKS))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(TFItems.ARMOR_SHARD_CLUSTER)
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.requires(Ingredient.of(TFItems.ARMOR_SHARD))
				.unlockedBy("has_item", has(TFItems.ARMOR_SHARD))
				.save(consumer, TwilightForestMod.prefix("material/" + Registry.ITEM.getKey(TFItems.ARMOR_SHARD_CLUSTER).getPath()));

		ShapelessRecipeBuilder.shapeless(TFBlocks.MOSSY_UNDERBRICK, 1)
				.requires(Ingredient.of(Blocks.VINE, Blocks.MOSS_BLOCK))
				.requires(Ingredient.of(TFBlocks.UNDERBRICK))
				.unlockedBy("has_item", has(TFBlocks.UNDERBRICK))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(TFBlocks.MOSSY_MAZESTONE, 1)
				.requires(Ingredient.of(Blocks.VINE, Blocks.MOSS_BLOCK))
				.requires(Ingredient.of(TFBlocks.MAZESTONE_BRICK))
				.unlockedBy("has_item", has(TFBlocks.MAZESTONE_BRICK))
				.save(consumer, TwilightForestMod.prefix("maze_stone/mossy_mazestone"));

		ShapelessRecipeBuilder.shapeless(TFItems.CARMINITE)
				.requires(Ingredient.of(TFItems.BORER_ESSENCE))
				.requires(Items.REDSTONE)
				.requires(Ingredient.of(TFItems.BORER_ESSENCE))
				.requires(Items.REDSTONE)
				.requires(Ingredient.of(Items.GHAST_TEAR))
				.requires(Items.REDSTONE)
				.requires(Ingredient.of(TFItems.BORER_ESSENCE))
				.requires(Items.REDSTONE)
				.requires(Ingredient.of(TFItems.BORER_ESSENCE))
				.unlockedBy("has_item", has(TFItems.BORER_ESSENCE))
				.save(consumer, TwilightForestMod.prefix("material/" + Registry.ITEM.getKey(TFItems.CARMINITE).getPath()));

		ShapelessRecipeBuilder.shapeless(TFItems.RAW_IRONWOOD, 2)
				.requires(Ingredient.of(TFItems.LIVEROOT))
				.requires(Ingredient.of(Items.RAW_IRON))
				.requires(Items.GOLD_NUGGET)
				.unlockedBy("has_item", has(TFItems.LIVEROOT))
				.save(consumer, TwilightForestMod.prefix("material/" + Registry.ITEM.getKey(TFItems.RAW_IRONWOOD).getPath()));
	}

	private void darkTowerRecipes(Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(TFBlocks.ENCASED_FIRE_JET)
				.pattern("#∴#")
				.pattern("∴^∴")
				.pattern("uuu")
				.define('∴', Items.REDSTONE)
				.define('#', Ingredient.of(TFBlocks.ENCASED_TOWERWOOD))
				.define('^', Ingredient.of(TFBlocks.FIRE_JET))
				.define('u', Ingredient.of(Items.LAVA_BUCKET))
				.unlockedBy("has_item", has(TFBlocks.FIRE_JET))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFBlocks.ENCASED_SMOKER)
				.pattern("#∴#")
				.pattern("∴^∴")
				.pattern("#∴#")
				.define('∴', Items.REDSTONE)
				.define('#', Ingredient.of(TFBlocks.ENCASED_TOWERWOOD))
				.define('^', Ingredient.of(TFBlocks.SMOKER))
				.unlockedBy("has_item", has(TFBlocks.SMOKER))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFBlocks.CARMINITE_BUILDER)
				.pattern("#6#")
				.pattern("6o6")
				.pattern("#6#")
				.define('6', ItemTagGenerator.CARMINITE_GEMS)
				.define('#', Ingredient.of(TFBlocks.ENCASED_TOWERWOOD))
				.define('o', Ingredient.of(Blocks.DISPENSER))
				.unlockedBy("has_item", has(TFItems.CARMINITE))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFBlocks.CARMINITE_REACTOR)
				.pattern("#6#")
				.pattern("6%6")
				.pattern("#6#")
				.define('6', ItemTagGenerator.CARMINITE_GEMS)
				.define('#', Ingredient.of(TFBlocks.ENCASED_TOWERWOOD))
				.define('%', Items.REDSTONE_ORE)
				.unlockedBy("has_item", has(TFBlocks.CARMINITE_REACTOR))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFBlocks.REAPPEARING_BLOCK, 2)
				.pattern("#∴#")
				.pattern("∴6∴")
				.pattern("#∴#")
				.define('∴', Items.REDSTONE)
				.define('#', Ingredient.of(TFBlocks.ENCASED_TOWERWOOD))
				.define('6', ItemTagGenerator.CARMINITE_GEMS)
				.unlockedBy("has_item", has(TFBlocks.REAPPEARING_BLOCK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFBlocks.VANISHING_BLOCK, 8)
				.pattern("#w#")
				.pattern("w6w")
				.pattern("#w#")
				.define('w', ItemTagGenerator.TOWERWOOD)
				.define('#', Ingredient.of(TFBlocks.ENCASED_TOWERWOOD))
				.define('6', ItemTagGenerator.CARMINITE_GEMS)
				.unlockedBy("has_item", has(TFBlocks.REAPPEARING_BLOCK))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(TFBlocks.MOSSY_TOWERWOOD)
				.requires(Ingredient.of(TFBlocks.TOWERWOOD))
				.requires(Ingredient.of(Blocks.VINE, Blocks.MOSS_BLOCK))
				.unlockedBy("has_item", has(TFBlocks.TOWERWOOD))
				.save(consumer, TwilightForestMod.prefix("wood/" + Registry.BLOCK.getKey(TFBlocks.MOSSY_TOWERWOOD).getPath()));

	}

	private void equipmentRecipes(Consumer<FinishedRecipe> consumer) {
		bootsItem(consumer, "arctic_boots", TFItems.ARCTIC_BOOTS, ItemTagGenerator.ARCTIC_FUR);
		chestplateItem(consumer, "arctic_chestplate", TFItems.ARCTIC_CHESTPLATE, ItemTagGenerator.ARCTIC_FUR);
		helmetItem(consumer, "arctic_helmet", TFItems.ARCTIC_HELMET, ItemTagGenerator.ARCTIC_FUR);
		leggingsItem(consumer, "arctic_leggings", TFItems.ARCTIC_LEGGINGS, ItemTagGenerator.ARCTIC_FUR);

		bootsItem(consumer, "fiery_boots", TFItems.FIERY_BOOTS, ItemTagGenerator.FIERY_INGOTS);
		chestplateItem(consumer, "fiery_chestplate", TFItems.FIERY_CHESTPLATE, ItemTagGenerator.FIERY_INGOTS);
		helmetItem(consumer, "fiery_helmet", TFItems.FIERY_HELMET, ItemTagGenerator.FIERY_INGOTS);
		leggingsItem(consumer, "fiery_leggings", TFItems.FIERY_LEGGINGS, ItemTagGenerator.FIERY_INGOTS);
		swordItem(consumer, "fiery_sword", TFItems.FIERY_SWORD, ItemTagGenerator.FIERY_INGOTS, Items.BLAZE_ROD);
		pickaxeItem(consumer, "fiery_pickaxe", TFItems.FIERY_PICKAXE, ItemTagGenerator.FIERY_INGOTS, Items.BLAZE_ROD);

		bootsItem(consumer, "knightmetal_boots", TFItems.KNIGHTMETAL_BOOTS, ItemTagGenerator.KNIGHTMETAL_INGOTS);
		chestplateItem(consumer, "knightmetal_chestplate", TFItems.KNIGHTMETAL_CHESTPLATE, ItemTagGenerator.KNIGHTMETAL_INGOTS);
		helmetItem(consumer, "knightmetal_helmet", TFItems.KNIGHTMETAL_HELMET, ItemTagGenerator.KNIGHTMETAL_INGOTS);
		leggingsItem(consumer, "knightmetal_leggings", TFItems.KNIGHTMETAL_LEGGINGS, ItemTagGenerator.KNIGHTMETAL_INGOTS);
		pickaxeItem(consumer, "knightmetal_pickaxe", TFItems.KNIGHTMETAL_PICKAXE, ItemTagGenerator.KNIGHTMETAL_INGOTS, Items.STICK);
		swordItem(consumer, "knightmetal_sword", TFItems.KNIGHTMETAL_SWORD, ItemTagGenerator.KNIGHTMETAL_INGOTS, Items.STICK);
		axeItem(consumer, "knightmetal_axe", TFItems.KNIGHTMETAL_AXE, ItemTagGenerator.KNIGHTMETAL_INGOTS, Items.STICK);

		ShapedRecipeBuilder.shaped(TFItems.GIANT_PICKAXE)
				.pattern("###")
				.pattern(" X ")
				.pattern(" X ")
				.define('#', TFBlocks.GIANT_COBBLESTONE)
				.define('X', TFBlocks.GIANT_LOG)
				.unlockedBy("has_item", has(TFBlocks.GIANT_COBBLESTONE))
				.save(consumer, locEquip(Registry.ITEM.getKey(TFItems.GIANT_PICKAXE).getPath()));

		ShapedRecipeBuilder.shaped(TFItems.GIANT_SWORD)
				.pattern("#")
				.pattern("#")
				.pattern("X")
				.define('#', TFBlocks.GIANT_COBBLESTONE)
				.define('X', TFBlocks.GIANT_LOG)
				.unlockedBy("has_item", has(TFBlocks.GIANT_COBBLESTONE))
				.save(consumer, locEquip(Registry.ITEM.getKey(TFItems.GIANT_SWORD).getPath()));

		charmRecipe(consumer, "charm_of_keeping_2", TFItems.CHARM_OF_KEEPING_2, TFItems.CHARM_OF_KEEPING_1);
		charmRecipe(consumer, "charm_of_keeping_3", TFItems.CHARM_OF_KEEPING_3, TFItems.CHARM_OF_KEEPING_2);
		charmRecipe(consumer, "charm_of_life_2", TFItems.CHARM_OF_LIFE_2, TFItems.CHARM_OF_LIFE_1);

		ShapelessRecipeBuilder.shapeless(TFItems.MOONWORM_QUEEN)
				.requires(TFItems.MOONWORM_QUEEN)
				.requires(TFItems.TORCHBERRIES, 3)
				.unlockedBy("has_item", has(TFItems.MOONWORM_QUEEN))
				.save(consumer, TwilightForestMod.prefix("moonworm_queen"));

		ShapelessRecipeBuilder.shapeless(Blocks.COBBLESTONE, 64)
				.requires(TFBlocks.GIANT_COBBLESTONE)
				.unlockedBy("has_item", has(TFBlocks.GIANT_COBBLESTONE))
				.save(consumer, TwilightForestMod.prefix(Registry.BLOCK.getKey(TFBlocks.GIANT_COBBLESTONE).getPath() + "_to_" + Registry.ITEM.getKey(Blocks.COBBLESTONE.asItem()).getPath()));

		ShapelessRecipeBuilder.shapeless(Blocks.OAK_PLANKS, 64)
				.requires(TFBlocks.GIANT_LOG)
				.unlockedBy("has_item", has(TFBlocks.GIANT_LOG))
				.save(consumer, TwilightForestMod.prefix(Registry.BLOCK.getKey(TFBlocks.GIANT_LOG).getPath() + "_to_" + Registry.ITEM.getKey(Blocks.OAK_PLANKS.asItem()).getPath()));

		ShapelessRecipeBuilder.shapeless(Blocks.OAK_LEAVES, 64)
				.requires(TFBlocks.GIANT_LEAVES)
				.unlockedBy("has_item", has(TFBlocks.GIANT_LOG))
				.save(consumer, TwilightForestMod.prefix(Registry.BLOCK.getKey(TFBlocks.GIANT_LEAVES).getPath() + "_to_" + Registry.ITEM.getKey(Blocks.OAK_LEAVES.asItem()).getPath()));

		ShapelessRecipeBuilder.shapeless(TFItems.BLOCK_AND_CHAIN)
				.requires(ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL)
				.requires(ItemTagGenerator.KNIGHTMETAL_INGOTS)
				.requires(ItemTagGenerator.KNIGHTMETAL_INGOTS)
				.requires(ItemTagGenerator.KNIGHTMETAL_INGOTS)
				.requires(Ingredient.of(TFItems.KNIGHTMETAL_RING))
				.unlockedBy("has_item", has(TFBlocks.KNIGHTMETAL_BLOCK))
				.save(consumer, locEquip(Registry.ITEM.getKey(TFItems.BLOCK_AND_CHAIN).getPath()));

		ShapedRecipeBuilder.shaped(TFItems.KNIGHTMETAL_RING)
				.pattern(" - ")
				.pattern("- -")
				.pattern(" - ")
				.define('-', ItemTagGenerator.KNIGHTMETAL_INGOTS)
				.unlockedBy("has_item", has(TFItems.KNIGHTMETAL_INGOT))
				.save(consumer, locEquip(Registry.ITEM.getKey(TFItems.KNIGHTMETAL_RING).getPath()));

		ShapedRecipeBuilder.shaped(TFItems.KNIGHTMETAL_SHIELD)
				.pattern("-#")
				.pattern("-o")
				.pattern("-#")
				.define('-', ItemTagGenerator.KNIGHTMETAL_INGOTS)
				.define('#', ItemTagGenerator.TOWERWOOD)
				.define('o', Ingredient.of(TFItems.KNIGHTMETAL_RING))
				.unlockedBy("has_item", has(TFItems.KNIGHTMETAL_INGOT))
				.save(consumer, locEquip(Registry.ITEM.getKey(TFItems.KNIGHTMETAL_SHIELD).getPath()));

//		ShapelessRecipeBuilder.shapeless(TFItems.LIFEDRAIN_SCEPTER)
//				.requires(itemWithNBT(TFItems.LIFEDRAIN_SCEPTER, nbt -> nbt.putInt("Damage", TFItems.LIFEDRAIN_SCEPTER.getMaxDamage())))
//				.requires(Ingredient.of(Items.FERMENTED_SPIDER_EYE))
//				.unlockedBy("has_item", has(TFItems.LIFEDRAIN_SCEPTER))
//				.save(consumer, locEquip(TFItems.LIFEDRAIN_SCEPTER).getPath()));
//
//		ShapelessRecipeBuilder.shapeless(TFItems.FORTIFICATION_SCEPTER)
//				.requires(itemWithNBT(TFItems.FORTIFICATION_SCEPTER, nbt -> nbt.putInt("Damage", TFItems.FORTIFICATION_SCEPTER.getMaxDamage())))
//				.requires(Ingredient.of(Items.GOLDEN_APPLE))
//				.unlockedBy("has_item", has(TFItems.FORTIFICATION_SCEPTER))
//				.save(consumer, locEquip(TFItems.FORTIFICATION_SCEPTER).getPath()));
//
//		ShapelessRecipeBuilder.shapeless(TFItems.TWILIGHT_SCEPTER)
//				.requires(itemWithNBT(TFItems.TWILIGHT_SCEPTER, nbt -> nbt.putInt("Damage", TFItems.TWILIGHT_SCEPTER.getMaxDamage())))
//				.requires(Tags.Items.ENDER_PEARLS)
//				.unlockedBy("has_item", has(TFItems.TWILIGHT_SCEPTER))
//				.save(consumer, locEquip(TFItems.TWILIGHT_SCEPTER).getPath()));
//
//		ShapelessRecipeBuilder.shapeless(TFItems.ZOMBIE_SCEPTER)
//				.requires(multipleIngredients(
//						itemWithNBT(Items.POTION, nbt -> nbt.putString("Potion", "minecraft:strength")),
//						itemWithNBT(Items.POTION, nbt -> nbt.putString("Potion", "minecraft:strong_strength")),
//						itemWithNBT(Items.POTION, nbt -> nbt.putString("Potion", "minecraft:long_strength"))
//				))
//				.requires(itemWithNBT(TFItems.ZOMBIE_SCEPTER, nbt -> nbt.putInt("Damage", TFItems.ZOMBIE_SCEPTER.getMaxDamage())))
//				.requires(Ingredient.of(Items.ROTTEN_FLESH))
//				.unlockedBy("has_item", has(TFItems.ZOMBIE_SCEPTER))
//				.save(consumer, locEquip(TFItems.ZOMBIE_SCEPTER).getPath()));

		// Testing
		//ShapelessRecipeBuilder.shapelessRecipe(TFItems.zombie_scepter)
		//		.addIngredient(multipleIngredients(
		//				Ingredient.fromTag(Tags.Items.GEMS_DIAMOND),
		//				Ingredient.fromItems(Items.BEDROCK)
		//		))
		//		.addIngredient(itemWithNBT(TFItems.zombie_scepter, nbt -> nbt.putInt("Damage", TFItems.zombie_scepter.getMaxDamage())))
		//		.addIngredient(Ingredient.fromItems(Items.ROTTEN_FLESH))
		//		.addIngredient(Tags.Items.GEMS_EMERALD)
		//		.addCriterion("has_item", hasItem(TFItems.zombie_scepter))
		//		.build(consumer, locEquip(TFItems.zombie_scepter).getPath() + "_rv"));
	}

	private void blockCompressionRecipes(Consumer<FinishedRecipe> consumer) {
		reverseCompressBlock(consumer, "arctic_block_to_item", TFItems.ARCTIC_FUR, ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR);
		reverseCompressBlock(consumer, "carminite_block_to_item", TFItems.CARMINITE, ItemTagGenerator.STORAGE_BLOCKS_CARMINITE);
		reverseCompressBlock(consumer, "fiery_block_to_ingot", TFItems.FIERY_INGOT, ItemTagGenerator.STORAGE_BLOCKS_FIERY);
		reverseCompressBlock(consumer, "ironwood_block_ingot", TFItems.IRONWOOD_INGOT, ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD);
		reverseCompressBlock(consumer, "knightmetal_block_ingot", TFItems.KNIGHTMETAL_INGOT,ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL);
		reverseCompressBlock(consumer, "steeleaf_block_ingot", TFItems.STEELEAF_INGOT, ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);

		compressedBlock(consumer, "arctic_block", TFBlocks.ARCTIC_FUR_BLOCK, ItemTagGenerator.ARCTIC_FUR);
		compressedBlock(consumer, "carminite_block", TFBlocks.CARMINITE_BLOCK, ItemTagGenerator.CARMINITE_GEMS);
		compressedBlock(consumer, "fiery_block", TFBlocks.FIERY_BLOCK, ItemTagGenerator.FIERY_INGOTS);
		compressedBlock(consumer, "ironwood_block", TFBlocks.IRONWOOD_BLOCK, ItemTagGenerator.IRONWOOD_INGOTS);
		compressedBlock(consumer, "knightmetal_block", TFBlocks.KNIGHTMETAL_BLOCK, ItemTagGenerator.KNIGHTMETAL_INGOTS);
		compressedBlock(consumer, "steeleaf_block", TFBlocks.STEELEAF_BLOCK, ItemTagGenerator.STEELEAF_INGOTS);
	}

	private void emptyMapRecipes(Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(TFItems.MAGIC_MAP_FOCUS)
				.requires(TFItems.RAVEN_FEATHER)
				.requires(TFItems.TORCHBERRIES)
				.requires(Items.GLOWSTONE_DUST)
				.unlockedBy("has_item", has(TFItems.TORCHBERRIES))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFItems.MAGIC_MAP)
				.pattern("###")
				.pattern("#•#")
				.pattern("###")
				.define('#', ItemTagGenerator.PAPER)
				.define('•', Ingredient.of(TFItems.MAGIC_MAP_FOCUS))
				.unlockedBy("has_item", has(TFItems.MAGIC_MAP_FOCUS))
				.save(consumer);

		ShapedRecipeBuilder.shaped(TFItems.MAZE_MAP)
				.pattern("###")
				.pattern("#•#")
				.pattern("###")
				.define('#', ItemTagGenerator.PAPER)
				.define('•', Ingredient.of(TFItems.MAZE_MAP_FOCUS))
				.unlockedBy("has_item", has(TFItems.MAZE_MAP_FOCUS))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(TFItems.ORE_MAP)
				.requires(TFItems.MAZE_MAP)
				.requires(Items.DIAMOND_BLOCK)
				.requires(Items.GOLD_BLOCK)
				.requires(Items.IRON_BLOCK)
				.unlockedBy("has_item", has(TFItems.ORE_MAGNET))
				.save(consumer);
	}

	private void woodRecipes(Consumer<FinishedRecipe> consumer) {
		buttonBlock(consumer, "canopy", TFBlocks.CANOPY_BUTTON, TFBlocks.CANOPY_PLANKS);
		buttonBlock(consumer, "darkwood", TFBlocks.DARK_BUTTON, TFBlocks.DARK_PLANKS);
		buttonBlock(consumer, "mangrove", TFBlocks.MANGROVE_BUTTON, TFBlocks.MANGROVE_PLANKS);
		buttonBlock(consumer, "mining", TFBlocks.MINING_BUTTON, TFBlocks.MINING_PLANKS);
		buttonBlock(consumer, "sorting", TFBlocks.SORTING_BUTTON, TFBlocks.SORTING_PLANKS);
		buttonBlock(consumer, "time", TFBlocks.TIME_BUTTON, TFBlocks.TIME_PLANKS);
		buttonBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_BUTTON, TFBlocks.TRANSFORMATION_PLANKS);
		buttonBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_BUTTON, TFBlocks.TWILIGHT_OAK_PLANKS);

		doorBlock(consumer, "canopy", TFBlocks.CANOPY_DOOR, TFBlocks.CANOPY_PLANKS);
		doorBlock(consumer, "darkwood", TFBlocks.DARK_DOOR, TFBlocks.DARK_PLANKS);
		doorBlock(consumer, "mangrove", TFBlocks.MANGROVE_DOOR, TFBlocks.MANGROVE_PLANKS);
		doorBlock(consumer, "mining", TFBlocks.MINING_DOOR, TFBlocks.MINING_PLANKS);
		doorBlock(consumer, "sorting", TFBlocks.SORTING_DOOR, TFBlocks.SORTING_PLANKS);
		doorBlock(consumer, "time", TFBlocks.TIME_DOOR, TFBlocks.TIME_PLANKS);
		doorBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_DOOR, TFBlocks.TRANSFORMATION_PLANKS);
		doorBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_DOOR, TFBlocks.TWILIGHT_OAK_PLANKS);

		fenceBlock(consumer, "canopy", TFBlocks.CANOPY_FENCE, TFBlocks.CANOPY_PLANKS);
		fenceBlock(consumer, "darkwood", TFBlocks.DARK_FENCE, TFBlocks.DARK_PLANKS);
		fenceBlock(consumer, "mangrove", TFBlocks.MANGROVE_FENCE, TFBlocks.MANGROVE_PLANKS);
		fenceBlock(consumer, "mining", TFBlocks.MINING_FENCE, TFBlocks.MINING_PLANKS);
		fenceBlock(consumer, "sorting", TFBlocks.SORTING_FENCE, TFBlocks.SORTING_PLANKS);
		fenceBlock(consumer, "time", TFBlocks.TIME_FENCE, TFBlocks.TIME_PLANKS);
		fenceBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_FENCE, TFBlocks.TRANSFORMATION_PLANKS);
		fenceBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_FENCE, TFBlocks.TWILIGHT_OAK_PLANKS);

		gateBlock(consumer, "canopy", TFBlocks.CANOPY_GATE, TFBlocks.CANOPY_PLANKS);
		gateBlock(consumer, "darkwood", TFBlocks.DARK_GATE, TFBlocks.DARK_PLANKS);
		gateBlock(consumer, "mangrove", TFBlocks.MANGROVE_GATE, TFBlocks.MANGROVE_PLANKS);
		gateBlock(consumer, "mining", TFBlocks.MINING_GATE, TFBlocks.MINING_PLANKS);
		gateBlock(consumer, "sorting", TFBlocks.SORTING_GATE, TFBlocks.SORTING_PLANKS);
		gateBlock(consumer, "time", TFBlocks.TIME_GATE, TFBlocks.TIME_PLANKS);
		gateBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_GATE, TFBlocks.TRANSFORMATION_PLANKS);
		gateBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_GATE, TFBlocks.TWILIGHT_OAK_PLANKS);

		planksBlock(consumer, "canopy", TFBlocks.CANOPY_PLANKS, TFBlocks.CANOPY_LOG);
		planksBlock(consumer, "darkwood", TFBlocks.DARK_PLANKS, TFBlocks.DARK_LOG);
		planksBlock(consumer, "mangrove", TFBlocks.MANGROVE_PLANKS, TFBlocks.MANGROVE_LOG);
		planksBlock(consumer, "mining", TFBlocks.MINING_PLANKS, TFBlocks.MINING_LOG);
		planksBlock(consumer, "sorting", TFBlocks.SORTING_PLANKS, TFBlocks.SORTING_LOG);
		planksBlock(consumer, "time", TFBlocks.TIME_PLANKS, TFBlocks.TIME_LOG);
		planksBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_PLANKS, TFBlocks.TRANSFORMATION_LOG);
		planksBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_PLANKS, TFBlocks.TWILIGHT_OAK_LOG);

		planksBlock(consumer, "canopy_from_stripped", TFBlocks.CANOPY_PLANKS, TFBlocks.STRIPPED_CANOPY_LOG);
		planksBlock(consumer, "darkwood_from_stripped", TFBlocks.DARK_PLANKS, TFBlocks.STRIPPED_DARK_LOG);
		planksBlock(consumer, "mangrove_from_stripped", TFBlocks.MANGROVE_PLANKS, TFBlocks.STRIPPED_MANGROVE_LOG);
		planksBlock(consumer, "mining_from_stripped", TFBlocks.MINING_PLANKS, TFBlocks.STRIPPED_MINING_LOG);
		planksBlock(consumer, "sorting_from_stripped", TFBlocks.SORTING_PLANKS, TFBlocks.STRIPPED_SORTING_LOG);
		planksBlock(consumer, "time_from_stripped", TFBlocks.TIME_PLANKS, TFBlocks.STRIPPED_TIME_LOG);
		planksBlock(consumer, "transformation_from_stripped", TFBlocks.TRANSFORMATION_PLANKS, TFBlocks.STRIPPED_TRANSFORMATION_LOG);
		planksBlock(consumer, "twilight_oak_from_stripped", TFBlocks.TWILIGHT_OAK_PLANKS, TFBlocks.STRIPPED_TWILIGHT_OAK_LOG);

		planksBlock(consumer, "canopy_from_wood", TFBlocks.CANOPY_PLANKS, TFBlocks.CANOPY_WOOD);
		planksBlock(consumer, "darkwood_from_wood", TFBlocks.DARK_PLANKS, TFBlocks.DARK_WOOD);
		planksBlock(consumer, "mangrove_from_wood", TFBlocks.MANGROVE_PLANKS, TFBlocks.MANGROVE_WOOD);
		planksBlock(consumer, "mining_from_wood", TFBlocks.MINING_PLANKS, TFBlocks.MINING_WOOD);
		planksBlock(consumer, "sorting_from_wood", TFBlocks.SORTING_PLANKS, TFBlocks.SORTING_WOOD);
		planksBlock(consumer, "time_from_wood", TFBlocks.TIME_PLANKS, TFBlocks.TIME_WOOD);
		planksBlock(consumer, "transformation_from_wood", TFBlocks.TRANSFORMATION_PLANKS, TFBlocks.TRANSFORMATION_WOOD);
		planksBlock(consumer, "twilight_oak_from_wood", TFBlocks.TWILIGHT_OAK_PLANKS, TFBlocks.TWILIGHT_OAK_WOOD);

		planksBlock(consumer, "canopy_from_stripped_wood", TFBlocks.CANOPY_PLANKS, TFBlocks.STRIPPED_CANOPY_WOOD);
		planksBlock(consumer, "darkwood_from_stripped_wood", TFBlocks.DARK_PLANKS, TFBlocks.STRIPPED_DARK_WOOD);
		planksBlock(consumer, "mangrove_from_stripped_wood", TFBlocks.MANGROVE_PLANKS, TFBlocks.STRIPPED_MANGROVE_WOOD);
		planksBlock(consumer, "mining_from_stripped_wood", TFBlocks.MINING_PLANKS, TFBlocks.STRIPPED_MINING_WOOD);
		planksBlock(consumer, "sorting_from_stripped_wood", TFBlocks.SORTING_PLANKS, TFBlocks.STRIPPED_SORTING_WOOD);
		planksBlock(consumer, "time_from_stripped_wood", TFBlocks.TIME_PLANKS, TFBlocks.STRIPPED_TIME_WOOD);
		planksBlock(consumer, "transformation_from_stripped_wood", TFBlocks.TRANSFORMATION_PLANKS, TFBlocks.STRIPPED_TRANSFORMATION_WOOD);
		planksBlock(consumer, "twilight_oak_from_stripped_wood", TFBlocks.TWILIGHT_OAK_PLANKS, TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD);

		woodBlock(consumer, "canopy", TFBlocks.CANOPY_WOOD, TFBlocks.CANOPY_LOG);
		woodBlock(consumer, "darkwood", TFBlocks.DARK_WOOD, TFBlocks.DARK_LOG);
		woodBlock(consumer, "mangrove", TFBlocks.MANGROVE_WOOD, TFBlocks.MANGROVE_LOG);
		woodBlock(consumer, "mining", TFBlocks.MINING_WOOD, TFBlocks.MINING_LOG);
		woodBlock(consumer, "sorting", TFBlocks.SORTING_WOOD, TFBlocks.SORTING_LOG);
		woodBlock(consumer, "time", TFBlocks.TIME_WOOD, TFBlocks.TIME_LOG);
		woodBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_WOOD, TFBlocks.TRANSFORMATION_LOG);
		woodBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_WOOD, TFBlocks.TWILIGHT_OAK_LOG);

		strippedWoodBlock(consumer, "canopy", TFBlocks.STRIPPED_CANOPY_WOOD, TFBlocks.STRIPPED_CANOPY_LOG);
		strippedWoodBlock(consumer, "darkwood", TFBlocks.STRIPPED_DARK_WOOD, TFBlocks.STRIPPED_DARK_LOG);
		strippedWoodBlock(consumer, "mangrove", TFBlocks.STRIPPED_MANGROVE_WOOD, TFBlocks.STRIPPED_MANGROVE_LOG);
		strippedWoodBlock(consumer, "mining", TFBlocks.STRIPPED_MINING_WOOD, TFBlocks.STRIPPED_MINING_LOG);
		strippedWoodBlock(consumer, "sorting", TFBlocks.STRIPPED_SORTING_WOOD, TFBlocks.STRIPPED_SORTING_LOG);
		strippedWoodBlock(consumer, "time", TFBlocks.STRIPPED_TIME_WOOD, TFBlocks.STRIPPED_TIME_LOG);
		strippedWoodBlock(consumer, "transformation", TFBlocks.STRIPPED_TRANSFORMATION_WOOD, TFBlocks.STRIPPED_TRANSFORMATION_LOG);
		strippedWoodBlock(consumer, "twilight_oak", TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD, TFBlocks.STRIPPED_TWILIGHT_OAK_LOG);

		plateBlock(consumer, "canopy", TFBlocks.CANOPY_PLATE, TFBlocks.CANOPY_PLANKS);
		plateBlock(consumer, "darkwood", TFBlocks.DARK_PLATE, TFBlocks.DARK_PLANKS);
		plateBlock(consumer, "mangrove", TFBlocks.MANGROVE_PLATE, TFBlocks.MANGROVE_PLANKS);
		plateBlock(consumer, "mining", TFBlocks.MINING_PLATE, TFBlocks.MINING_PLANKS);
		plateBlock(consumer, "sorting", TFBlocks.SORTING_PLATE, TFBlocks.SORTING_PLANKS);
		plateBlock(consumer, "time", TFBlocks.TIME_PLATE, TFBlocks.TIME_PLANKS);
		plateBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_PLATE, TFBlocks.TRANSFORMATION_PLANKS);
		plateBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_PLATE, TFBlocks.TWILIGHT_OAK_PLANKS);

		slabBlock(consumer, "canopy", TFBlocks.CANOPY_SLAB, TFBlocks.CANOPY_PLANKS);
		slabBlock(consumer, "darkwood", TFBlocks.DARK_SLAB, TFBlocks.DARK_PLANKS);
		slabBlock(consumer, "mangrove", TFBlocks.MANGROVE_SLAB, TFBlocks.MANGROVE_PLANKS);
		slabBlock(consumer, "mining", TFBlocks.MINING_SLAB, TFBlocks.MINING_PLANKS);
		slabBlock(consumer, "sorting", TFBlocks.SORTING_SLAB, TFBlocks.SORTING_PLANKS);
		slabBlock(consumer, "time", TFBlocks.TIME_SLAB, TFBlocks.TIME_PLANKS);
		slabBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_SLAB, TFBlocks.TRANSFORMATION_PLANKS);
		slabBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_SLAB, TFBlocks.TWILIGHT_OAK_PLANKS);

		stairsBlock(consumer, locWood("canopy_stairs"), TFBlocks.CANOPY_STAIRS, TFBlocks.CANOPY_PLANKS, TFBlocks.CANOPY_PLANKS);
		stairsBlock(consumer, locWood("darkwood_stairs"), TFBlocks.DARK_STAIRS, TFBlocks.DARK_PLANKS, TFBlocks.DARK_PLANKS);
		stairsBlock(consumer, locWood("mangrove_stairs"), TFBlocks.MANGROVE_STAIRS, TFBlocks.MANGROVE_PLANKS, TFBlocks.MANGROVE_PLANKS);
		stairsBlock(consumer, locWood("mining_stairs"), TFBlocks.MINING_STAIRS, TFBlocks.MINING_PLANKS, TFBlocks.MINING_PLANKS);
		stairsBlock(consumer, locWood("sorting_stairs"), TFBlocks.SORTING_STAIRS, TFBlocks.SORTING_PLANKS, TFBlocks.SORTING_PLANKS);
		stairsBlock(consumer, locWood("time_stairs"), TFBlocks.TIME_STAIRS, TFBlocks.TIME_PLANKS, TFBlocks.TIME_PLANKS);
		stairsBlock(consumer, locWood("transformation_stairs"), TFBlocks.TRANSFORMATION_STAIRS, TFBlocks.TRANSFORMATION_PLANKS, TFBlocks.TRANSFORMATION_PLANKS);
		stairsBlock(consumer, locWood("twilight_oak_stairs"), TFBlocks.TWILIGHT_OAK_STAIRS, TFBlocks.TWILIGHT_OAK_PLANKS, TFBlocks.TWILIGHT_OAK_PLANKS);

		trapdoorBlock(consumer, "canopy", TFBlocks.CANOPY_TRAPDOOR, TFBlocks.CANOPY_PLANKS);
		trapdoorBlock(consumer, "darkwood", TFBlocks.DARK_TRAPDOOR, TFBlocks.DARK_PLANKS);
		trapdoorBlock(consumer, "mangrove", TFBlocks.MANGROVE_TRAPDOOR, TFBlocks.MANGROVE_PLANKS);
		trapdoorBlock(consumer, "mining", TFBlocks.MINING_TRAPDOOR, TFBlocks.MINING_PLANKS);
		trapdoorBlock(consumer, "sorting", TFBlocks.SORTING_TRAPDOOR, TFBlocks.SORTING_PLANKS);
		trapdoorBlock(consumer, "time", TFBlocks.TIME_TRAPDOOR, TFBlocks.TIME_PLANKS);
		trapdoorBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_TRAPDOOR, TFBlocks.TRANSFORMATION_PLANKS);
		trapdoorBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_TRAPDOOR, TFBlocks.TWILIGHT_OAK_PLANKS);

		signBlock(consumer, "canopy_sign", TFBlocks.CANOPY_SIGN, TFBlocks.CANOPY_PLANKS);
		signBlock(consumer, "darkwood_sign", TFBlocks.DARKWOOD_SIGN, TFBlocks.DARK_PLANKS);
		signBlock(consumer, "mangrove_sign", TFBlocks.MANGROVE_SIGN, TFBlocks.MANGROVE_PLANKS);
		signBlock(consumer, "mining_sign", TFBlocks.MINING_SIGN, TFBlocks.MINING_PLANKS);
		signBlock(consumer, "sorting_sign", TFBlocks.SORTING_SIGN, TFBlocks.SORTING_PLANKS);
		signBlock(consumer, "time_sign", TFBlocks.TIME_SIGN, TFBlocks.TIME_PLANKS);
		signBlock(consumer, "transformation_sign", TFBlocks.TRANSFORMATION_SIGN, TFBlocks.TRANSFORMATION_PLANKS);
		signBlock(consumer, "twilight_oak_sign", TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_OAK_PLANKS);

		banisterBlock(consumer, "canopy", TFBlocks.CANOPY_BANISTER, TFBlocks.CANOPY_SLAB);
		banisterBlock(consumer, "darkwood", TFBlocks.DARKWOOD_BANISTER, TFBlocks.DARK_SLAB);
		banisterBlock(consumer, "mangrove", TFBlocks.MANGROVE_BANISTER, TFBlocks.MANGROVE_SLAB);
		banisterBlock(consumer, "mining", TFBlocks.MINING_BANISTER, TFBlocks.MINING_SLAB);
		banisterBlock(consumer, "sorting", TFBlocks.SORTING_BANISTER, TFBlocks.SORTING_SLAB);
		banisterBlock(consumer, "time", TFBlocks.TIME_BANISTER, TFBlocks.TIME_SLAB);
		banisterBlock(consumer, "transformation", TFBlocks.TRANSFORMATION_BANISTER, TFBlocks.TRANSFORMATION_SLAB);
		banisterBlock(consumer, "twilight_oak", TFBlocks.TWILIGHT_OAK_BANISTER, TFBlocks.TWILIGHT_OAK_SLAB);

		banisterBlock(consumer, "oak", TFBlocks.OAK_BANISTER, Blocks.OAK_SLAB);
		banisterBlock(consumer, "spruce", TFBlocks.SPRUCE_BANISTER, Blocks.SPRUCE_SLAB);
		banisterBlock(consumer, "birch", TFBlocks.BIRCH_BANISTER, Blocks.BIRCH_SLAB);
		banisterBlock(consumer, "jungle", TFBlocks.JUNGLE_BANISTER, Blocks.JUNGLE_SLAB);
		banisterBlock(consumer, "acacia", TFBlocks.ACACIA_BANISTER, Blocks.ACACIA_SLAB);
		banisterBlock(consumer, "dark_oak", TFBlocks.DARK_OAK_BANISTER, Blocks.DARK_OAK_SLAB);
		banisterBlock(consumer, "crimson", TFBlocks.CRIMSON_BANISTER, Blocks.CRIMSON_SLAB);
		banisterBlock(consumer, "warped", TFBlocks.WARPED_BANISTER, Blocks.WARPED_SLAB);

	}

	private void nagastoneRecipes(Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(TFBlocks.SPIRAL_BRICKS, 8)
				.pattern("BSS")
				.pattern("BSS")
				.pattern("BBB")
				.define('B', Ingredient.of(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS))//Ingredient.merge(ImmutableList.of(Ingredient.fromTag(Tags.Items.STONE), Ingredient.fromItems(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS))))
				.define('S', Ingredient.of(Blocks.STONE_SLAB, Blocks.STONE_BRICK_SLAB))
				.unlockedBy("has_item", has(TFBlocks.SPIRAL_BRICKS))
				.save(consumer, locNaga("nagastone_spiral"));

		stairsBlock(consumer, locNaga("nagastone_stairs_left"), TFBlocks.NAGASTONE_STAIRS_LEFT, TFBlocks.ETCHED_NAGASTONE, TFBlocks.ETCHED_NAGASTONE);
		stairsRightBlock(consumer, locNaga("nagastone_stairs_right"), TFBlocks.NAGASTONE_STAIRS_RIGHT, TFBlocks.ETCHED_NAGASTONE, TFBlocks.ETCHED_NAGASTONE);

		stairsBlock(consumer, locNaga("mossy_nagastone_stairs_left"), TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT, TFBlocks.MOSSY_ETCHED_NAGASTONE, TFBlocks.MOSSY_ETCHED_NAGASTONE);
		stairsRightBlock(consumer, locNaga("mossy_nagastone_stairs_right"), TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT, TFBlocks.MOSSY_ETCHED_NAGASTONE, TFBlocks.MOSSY_ETCHED_NAGASTONE);

		ShapelessRecipeBuilder.shapeless(TFBlocks.MOSSY_ETCHED_NAGASTONE, 1)
				.requires(Ingredient.of(Blocks.VINE, Blocks.MOSS_BLOCK))
				.requires(Ingredient.of(TFBlocks.ETCHED_NAGASTONE))
				.unlockedBy("has_item", has(TFBlocks.ETCHED_NAGASTONE))
				.save(consumer, locNaga("mossy_etched_nagastone"));

		ShapelessRecipeBuilder.shapeless(TFBlocks.MOSSY_NAGASTONE_PILLAR, 1)
				.requires(Ingredient.of(Blocks.VINE, Blocks.MOSS_BLOCK))
				.requires(Ingredient.of(TFBlocks.NAGASTONE_PILLAR))
				.unlockedBy("has_item", has(TFBlocks.NAGASTONE_PILLAR))
				.save(consumer, locNaga("mossy_nagastone_pillar"));

		stairsBlock(consumer, locNaga("cracked_nagastone_stairs_left"), TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT, TFBlocks.CRACKED_ETCHED_NAGASTONE, TFBlocks.CRACKED_ETCHED_NAGASTONE);
		stairsRightBlock(consumer, locNaga("cracked_nagastone_stairs_right"), TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT, TFBlocks.CRACKED_ETCHED_NAGASTONE, TFBlocks.CRACKED_ETCHED_NAGASTONE);
	}

	private void castleRecipes(Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(TFBlocks.MOSSY_CASTLE_BRICK, 1)
				.requires(Ingredient.of(Blocks.VINE, Blocks.MOSS_BLOCK))
				.requires(Ingredient.of(TFBlocks.CASTLE_BRICK))
				.unlockedBy("has_item", has(TFBlocks.CASTLE_BRICK))
				.save(consumer, locCastle("mossy_castle_brick"));

		castleBlock(consumer, TFBlocks.THICK_CASTLE_BRICK, TFBlocks.CASTLE_BRICK, TFBlocks.WORN_CASTLE_BRICK, TFBlocks.CRACKED_CASTLE_BRICK, TFBlocks.MOSSY_CASTLE_BRICK);
		castleBlock(consumer, TFBlocks.BOLD_CASTLE_BRICK_PILLAR, TFBlocks.THICK_CASTLE_BRICK);
		castleBlock(consumer, TFBlocks.BOLD_CASTLE_BRICK_TILE, TFBlocks.BOLD_CASTLE_BRICK_PILLAR);

		ShapedRecipeBuilder.shaped(TFBlocks.BOLD_CASTLE_BRICK_PILLAR, 4)
				.pattern("##")
				.pattern("##")
				.define('#', Ingredient.of(TFBlocks.BOLD_CASTLE_BRICK_TILE))
				.unlockedBy("has_castle_brick", has(TFBlocks.CASTLE_BRICK))
				.save(consumer, locCastle("bold_castle_pillar_from_tile"));

		ShapedRecipeBuilder.shaped(TFBlocks.ENCASED_CASTLE_BRICK_PILLAR, 6)
				.pattern("#H#")
				.pattern("#H#")
				.define('#', Ingredient.of(TFBlocks.CASTLE_BRICK, TFBlocks.WORN_CASTLE_BRICK, TFBlocks.CRACKED_CASTLE_BRICK, TFBlocks.MOSSY_CASTLE_BRICK, TFBlocks.THICK_CASTLE_BRICK))
				.define('H', Ingredient.of(TFBlocks.ENCASED_CASTLE_BRICK_PILLAR, TFBlocks.ENCASED_CASTLE_BRICK_TILE, TFBlocks.BOLD_CASTLE_BRICK_PILLAR, TFBlocks.BOLD_CASTLE_BRICK_TILE))
				.unlockedBy("has_castle_brick", has(TFBlocks.CASTLE_BRICK))
				.save(consumer, locCastle("encased_castle_pillar"));

		stairsBlock(consumer, locCastle("bold_castle_brick_stairs"), TFBlocks.BOLD_CASTLE_BRICK_STAIRS, TFBlocks.BOLD_CASTLE_BRICK_PILLAR, TFBlocks.BOLD_CASTLE_BRICK_PILLAR, TFBlocks.BOLD_CASTLE_BRICK_TILE);
		stairsBlock(consumer, locCastle("castle_brick_stairs"), TFBlocks.CASTLE_BRICK_STAIRS, TFBlocks.CASTLE_BRICK, TFBlocks.CASTLE_BRICK);
		stairsBlock(consumer, locCastle("cracked_castle_brick_stairs"), TFBlocks.CRACKED_CASTLE_BRICK_STAIRS, TFBlocks.CRACKED_CASTLE_BRICK, TFBlocks.CRACKED_CASTLE_BRICK);
		stairsBlock(consumer, locCastle("encased_castle_brick_stairs"), TFBlocks.ENCASED_CASTLE_BRICK_STAIRS, TFBlocks.ENCASED_CASTLE_BRICK_PILLAR, TFBlocks.ENCASED_CASTLE_BRICK_PILLAR, TFBlocks.ENCASED_CASTLE_BRICK_TILE);
		stairsBlock(consumer, locCastle("mossy_castle_brick_stairs"), TFBlocks.MOSSY_CASTLE_BRICK_STAIRS, TFBlocks.MOSSY_CASTLE_BRICK, TFBlocks.MOSSY_CASTLE_BRICK);
		stairsBlock(consumer, locCastle("worn_castle_brick_stairs"), TFBlocks.WORN_CASTLE_BRICK_STAIRS, TFBlocks.WORN_CASTLE_BRICK, TFBlocks.WORN_CASTLE_BRICK);
	}

	private void fieryConversions(Consumer<FinishedRecipe> consumer) {
		UpgradeRecipeBuilder.smithing(Ingredient.of(Items.IRON_INGOT), Ingredient.of(ItemTagGenerator.FIERY_VIAL), TFItems.FIERY_INGOT).unlocks("has_item", has(TFItems.FIERY_INGOT)).save(consumer, TwilightForestMod.prefix("material/fiery_iron_ingot"));
		UpgradeRecipeBuilder.smithing(Ingredient.of(ItemTagGenerator.FIERY_VIAL), Ingredient.of(Items.IRON_INGOT), TFItems.FIERY_INGOT).unlocks("has_item", has(TFItems.FIERY_INGOT)).save(consumer, TwilightForestMod.prefix("material/fiery_iron_ingot_reversed"));

		ShapelessRecipeBuilder.shapeless(TFItems.FIERY_INGOT)
				.requires(Ingredient.of(ItemTagGenerator.FIERY_VIAL))
				.requires(Ingredient.of(Items.IRON_INGOT))
				.unlockedBy("has_item", has(ItemTagGenerator.FIERY_VIAL))
				.save(consumer, locEquip("fiery_ingot_crafting"));

		fieryConversion(consumer, TFItems.FIERY_HELMET, Items.IRON_HELMET, 5);
		fieryConversion(consumer, TFItems.FIERY_CHESTPLATE, Items.IRON_CHESTPLATE, 8);
		fieryConversion(consumer, TFItems.FIERY_LEGGINGS, Items.IRON_LEGGINGS, 7);
		fieryConversion(consumer, TFItems.FIERY_BOOTS, Items.IRON_BOOTS, 4);
		ShapelessRecipeBuilder.shapeless(TFItems.FIERY_SWORD)
				.requires(Items.IRON_SWORD)
				.requires(Ingredient.of(ItemTagGenerator.FIERY_VIAL), 2)
				.requires(Ingredient.of(Items.BLAZE_ROD))
				.unlockedBy("has_item", has(ItemTagGenerator.FIERY_VIAL))
				.save(consumer, locEquip("fiery_" + Registry.ITEM.getKey(Items.IRON_SWORD).getPath()));

		ShapelessRecipeBuilder.shapeless(TFItems.FIERY_PICKAXE)
				.requires(Items.IRON_PICKAXE)
				.requires(Ingredient.of(ItemTagGenerator.FIERY_VIAL), 3)
				.requires(Ingredient.of(Items.BLAZE_ROD), 2)
				.unlockedBy("has_item", has(ItemTagGenerator.FIERY_VIAL))
				.save(consumer, locEquip("fiery_" + Registry.ITEM.getKey(Items.IRON_PICKAXE).getPath()));
	}

	private void cookingRecipes(Consumer<FinishedRecipe> consumer, String processName, SimpleCookingSerializer<?> process, int smeltingTime) {
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFItems.RAW_MEEF), TFItems.COOKED_MEEF, 0.3f, smeltingTime, process).unlockedBy("has_food", has(TFItems.RAW_MEEF)).save(consumer, TwilightForestMod.prefix("food/" + processName + "_meef").toString());
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFItems.RAW_VENISON), TFItems.COOKED_VENISON, 0.3f, smeltingTime, process).unlockedBy("has_food", has(TFItems.RAW_VENISON)).save(consumer, TwilightForestMod.prefix("food/" + processName + "_venison").toString());
	}

	private void ingotRecipes(Consumer<FinishedRecipe> consumer, String processName, SimpleCookingSerializer<?> process, int smeltingTime) {
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFItems.ARMOR_SHARD_CLUSTER), TFItems.KNIGHTMETAL_INGOT, 1.0f, smeltingTime, process).unlockedBy("has_item", has(TFItems.ARMOR_SHARD_CLUSTER)).save(consumer, TwilightForestMod.prefix( "material/" + processName + "_knightmetal_ingot").toString());
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFItems.RAW_IRONWOOD.get()), TFItems.IRONWOOD_INGOT.get(), 1.0f, smeltingTime, process).unlockedBy("has_item", has(TFItems.RAW_IRONWOOD.get())).save(consumer, TwilightForestMod.prefix( "material/" + processName + "_ironwood_ingot").toString());
	}

	private void crackedWoodRecipes(Consumer<FinishedRecipe> consumer, String processName, SimpleCookingSerializer<?> process, int smeltingTime) {
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFBlocks.TOWERWOOD), TFBlocks.CRACKED_TOWERWOOD, 0.3f, smeltingTime, process).unlockedBy("has_item", has(TFBlocks.TOWERWOOD)).save(consumer, TwilightForestMod.prefix("wood/" + processName + "_cracked_towerwood").toString());
	}

	private void crackedStoneRecipes(Consumer<FinishedRecipe> consumer, String processName, SimpleCookingSerializer<?> process, int smeltingTime) {
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFBlocks.NAGASTONE_PILLAR), TFBlocks.CRACKED_NAGASTONE_PILLAR, 0.3f, smeltingTime, process).unlockedBy("has_item", has(TFBlocks.NAGASTONE_PILLAR)).save(consumer, TwilightForestMod.prefix("nagastone/" + processName + "_cracked_nagastone_pillar").toString());
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFBlocks.ETCHED_NAGASTONE), TFBlocks.CRACKED_ETCHED_NAGASTONE, 0.3f, smeltingTime, process).unlockedBy("has_item", has(TFBlocks.ETCHED_NAGASTONE)).save(consumer, TwilightForestMod.prefix("nagastone/" + processName + "_cracked_etched_nagastone").toString());
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFBlocks.MAZESTONE_BRICK), TFBlocks.CRACKED_MAZESTONE, 0.3f, smeltingTime, process).unlockedBy("has_item", has(TFBlocks.MAZESTONE_BRICK)).save(consumer, TwilightForestMod.prefix("maze_stone/" + processName + "_maze_stone_cracked").toString());
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFBlocks.CASTLE_BRICK), TFBlocks.CRACKED_CASTLE_BRICK, 0.3f, smeltingTime, process).unlockedBy("has_item", has(TFBlocks.CASTLE_BRICK)).save(consumer, TwilightForestMod.prefix("castleblock/" + processName + "_cracked_castle_brick").toString());
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(TFBlocks.UNDERBRICK), TFBlocks.CRACKED_UNDERBRICK, 0.3f, smeltingTime, process).unlockedBy("has_item", has(TFBlocks.UNDERBRICK)).save(consumer, TwilightForestMod.prefix(processName + "_cracked_underbrick").toString());
	}
}