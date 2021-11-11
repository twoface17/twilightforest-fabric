package twilightforest.block;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import twilightforest.TwilightForestMod;
import twilightforest.client.ISTER;
import twilightforest.item.*;
import twilightforest.block.entity.TFBlockEntities;

import static twilightforest.TwilightForestMod.creativeTab;
import java.util.HashMap;
import java.util.Map;

public class TFBlockItems {

	public static void registerBlockItems() {
		trophyBlock(TFBlocks.NAGA_TROPHY, TFBlocks.NAGA_WALL_TROPHY);
		trophyBlock(TFBlocks.LICH_TROPHY, TFBlocks.LICH_WALL_TROPHY);
		trophyBlock(TFBlocks.MINOSHROOM_TROPHY, TFBlocks.MINOSHROOM_WALL_TROPHY);
		trophyBlock(TFBlocks.HYDRA_TROPHY, TFBlocks.HYDRA_WALL_TROPHY);
		trophyBlock(TFBlocks.KNIGHT_PHANTOM_TROPHY, TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY);
		trophyBlock(TFBlocks.UR_GHAST_TROPHY, TFBlocks.UR_GHAST_WALL_TROPHY);
		trophyBlock(TFBlocks.ALPHA_YETI_TROPHY, TFBlocks.ALPHA_YETI_WALL_TROPHY);
		trophyBlock(TFBlocks.SNOW_QUEEN_TROPHY, TFBlocks.SNOW_QUEEN_WALL_TROPHY);
		trophyBlock(TFBlocks.QUEST_RAM_TROPHY, TFBlocks.QUEST_RAM_WALL_TROPHY);

		blockItem(TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.HEDGE_MAZE_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.HOLLOW_HILL_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.MUSHROOM_TOWER_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.QUEST_GROVE_MINIATURE_STRUCTURE);
		blockItem(TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE);
		blockItem(TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.MINOTAUR_LABYRINTH_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.HYDRA_LAIR_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.GOBLIN_STRONGHOLD_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.DARK_TOWER_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.YETI_CAVE_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.AURORA_PALACE_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.TROLL_CAVE_COTTAGE_MINIATURE_STRUCTURE);
//      blockItem(TFBlocks.FINAL_CASTLE_MINIATURE_STRUCTURE);

		blockItem(TFBlocks.NAGA_BOSS_SPAWNER);
		blockItem(TFBlocks.LICH_BOSS_SPAWNER);
		blockItem(TFBlocks.MINOSHROOM_BOSS_SPAWNER);
		blockItem(TFBlocks.HYDRA_BOSS_SPAWNER);
		blockItem(TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER);
		blockItem(TFBlocks.UR_GHAST_BOSS_SPAWNER);
		blockItem(TFBlocks.ALPHA_YETI_BOSS_SPAWNER);
		blockItem(TFBlocks.SNOW_QUEEN_BOSS_SPAWNER);
		blockItem(TFBlocks.FINAL_BOSS_BOSS_SPAWNER);

		blockItem(TFBlocks.ETCHED_NAGASTONE);
		blockItem(TFBlocks.CRACKED_ETCHED_NAGASTONE);
		blockItem(TFBlocks.MOSSY_ETCHED_NAGASTONE);
		blockItem(TFBlocks.NAGASTONE_PILLAR);
		blockItem(TFBlocks.CRACKED_NAGASTONE_PILLAR);
		blockItem(TFBlocks.MOSSY_NAGASTONE_PILLAR);
		blockItem(TFBlocks.NAGASTONE_STAIRS_LEFT);
		blockItem(TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT);
		blockItem(TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT);
		blockItem(TFBlocks.NAGASTONE_STAIRS_RIGHT);
		blockItem(TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT);
		blockItem(TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT);
		blockItem(TFBlocks.NAGASTONE_HEAD);
		blockItem(TFBlocks.NAGASTONE);
		blockItem(TFBlocks.SPIRAL_BRICKS);
//      blockItem(TFBlocks.TERRORCOTTA_CIRCLE);
//      blockItem(TFBlocks.TERRORCOTTA_DIAGONAL);
//      blockItem(TFBlocks.LAPIS_BLOCK);
		blockItem(TFBlocks.TWISTED_STONE);
		blockItem(TFBlocks.TWISTED_STONE_PILLAR);
		makeBlockItem(new BlockItem(TFBlocks.KEEPSAKE_CASKET, TFItems.defaultBuilder().fireResistant()) {
//			@Override
//			public void initializeClient(Consumer<IItemRenderProperties> consumer) {
//				consumer.accept(new IItemRenderProperties() {
//					@Override
//					public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
//						return new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.KEEPSAKE_CASKET);
//					}
//				});
//			}
		}, TFBlocks.KEEPSAKE_CASKET);
		blockItem(TFBlocks.CANDELABRA);
		blockItem(TFBlocks.BOLD_STONE_PILLAR);
		blockItem(TFBlocks.DEATH_TOME_SPAWNER);
		blockItem(TFBlocks.EMPTY_CANOPY_BOOKSHELF);
		skullCandleItem(TFBlocks.ZOMBIE_SKULL_CANDLE, TFBlocks.ZOMBIE_WALL_SKULL_CANDLE);
		skullCandleItem(TFBlocks.SKELETON_SKULL_CANDLE, TFBlocks.SKELETON_WALL_SKULL_CANDLE);
		skullCandleItem(TFBlocks.WITHER_SKELE_SKULL_CANDLE, TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE);
		skullCandleItem(TFBlocks.CREEPER_SKULL_CANDLE, TFBlocks.CREEPER_WALL_SKULL_CANDLE);
		skullCandleItem(TFBlocks.PLAYER_SKULL_CANDLE, TFBlocks.PLAYER_WALL_SKULL_CANDLE);
		makeBlockItem(new HugeWaterLilyItem(TFBlocks.HUGE_WATER_LILY, TFItems.defaultBuilder()), TFBlocks.HUGE_WATER_LILY);
		makeBlockItem(new HugeLilyPadItem(TFBlocks.HUGE_LILY_PAD, TFItems.defaultBuilder()), TFBlocks.HUGE_LILY_PAD);
		blockItem(TFBlocks.MAZESTONE);
		blockItem(TFBlocks.MAZESTONE_BRICK);
		blockItem(TFBlocks.CRACKED_MAZESTONE);
		blockItem(TFBlocks.MOSSY_MAZESTONE);
		blockItem(TFBlocks.DECORATIVE_MAZESTONE);
		blockItem(TFBlocks.CUT_MAZESTONE);
		blockItem(TFBlocks.MAZESTONE_BORDER);
		blockItem(TFBlocks.MAZESTONE_MOSAIC);
		blockItem(TFBlocks.SMOKER);
		blockItem(TFBlocks.ENCASED_SMOKER);
		blockItem(TFBlocks.FIRE_JET);
		blockItem(TFBlocks.ENCASED_FIRE_JET);
		blockItem(TFBlocks.STRONGHOLD_SHIELD);
		blockItem(TFBlocks.TROPHY_PEDESTAL);
		blockItem(TFBlocks.UNDERBRICK);
		blockItem(TFBlocks.CRACKED_UNDERBRICK);
		blockItem(TFBlocks.MOSSY_UNDERBRICK);
		blockItem(TFBlocks.UNDERBRICK_FLOOR);
		blockItem(TFBlocks.TOWERWOOD);
		blockItem(TFBlocks.CRACKED_TOWERWOOD);
		blockItem(TFBlocks.MOSSY_TOWERWOOD);
		blockItem(TFBlocks.INFESTED_TOWERWOOD);
		blockItem(TFBlocks.ENCASED_TOWERWOOD);
		blockItem(TFBlocks.VANISHING_BLOCK);
		blockItem(TFBlocks.REAPPEARING_BLOCK);
		blockItem(TFBlocks.LOCKED_VANISHING_BLOCK);
		blockItem(TFBlocks.CARMINITE_BUILDER);
		blockItem(TFBlocks.ANTIBUILDER);
		blockItem(TFBlocks.CARMINITE_REACTOR);
		blockItem(TFBlocks.GHAST_TRAP);
		blockItem(TFBlocks.AURORA_BLOCK);
		blockItem(TFBlocks.AURORA_PILLAR);
		blockItem(TFBlocks.AURORA_SLAB);
		blockItem(TFBlocks.AURORALIZED_GLASS);
		blockItem(TFBlocks.TROLLSTEINN);
		blockItem(TFBlocks.TROLLVIDR);
		blockItem(TFBlocks.UNRIPE_TROLLBER);
		blockItem(TFBlocks.TROLLBER);
		blockItem(TFBlocks.HUGE_MUSHGLOOM);
		blockItem(TFBlocks.HUGE_MUSHGLOOM_STEM);
		blockItem(TFBlocks.UBEROUS_SOIL);
		blockItem(TFBlocks.HUGE_STALK);
		blockItem(TFBlocks.BEANSTALK_LEAVES);
		blockItem(TFBlocks.WISPY_CLOUD);
		blockItem(TFBlocks.FLUFFY_CLOUD);
		blockItem(TFBlocks.GIANT_COBBLESTONE);
		blockItem(TFBlocks.GIANT_LOG);
		blockItem(TFBlocks.GIANT_LEAVES);
		blockItem(TFBlocks.GIANT_OBSIDIAN);
		blockItem(TFBlocks.DEADROCK);
		blockItem(TFBlocks.CRACKED_DEADROCK);
		blockItem(TFBlocks.WEATHERED_DEADROCK);
		blockItem(TFBlocks.BROWN_THORNS);
		blockItem(TFBlocks.GREEN_THORNS);
		blockItem(TFBlocks.BURNT_THORNS);
		blockItem(TFBlocks.THORN_ROSE);
		blockItem(TFBlocks.THORN_LEAVES);
		blockItem(TFBlocks.CASTLE_BRICK);
		blockItem(TFBlocks.WORN_CASTLE_BRICK);
		blockItem(TFBlocks.CRACKED_CASTLE_BRICK);
		blockItem(TFBlocks.MOSSY_CASTLE_BRICK);
		blockItem(TFBlocks.THICK_CASTLE_BRICK);
		blockItem(TFBlocks.CASTLE_ROOF_TILE);
		blockItem(TFBlocks.ENCASED_CASTLE_BRICK_PILLAR);
		blockItem(TFBlocks.ENCASED_CASTLE_BRICK_TILE);
		blockItem(TFBlocks.BOLD_CASTLE_BRICK_PILLAR);
		blockItem(TFBlocks.BOLD_CASTLE_BRICK_TILE);
		blockItem(TFBlocks.CASTLE_BRICK_STAIRS);
		blockItem(TFBlocks.WORN_CASTLE_BRICK_STAIRS);
		blockItem(TFBlocks.CRACKED_CASTLE_BRICK_STAIRS);
		blockItem(TFBlocks.MOSSY_CASTLE_BRICK_STAIRS);
		blockItem(TFBlocks.ENCASED_CASTLE_BRICK_STAIRS);
		blockItem(TFBlocks.BOLD_CASTLE_BRICK_STAIRS);
		blockItem(TFBlocks.PINK_CASTLE_RUNE_BRICK);
		blockItem(TFBlocks.YELLOW_CASTLE_RUNE_BRICK);
		blockItem(TFBlocks.BLUE_CASTLE_RUNE_BRICK);
		blockItem(TFBlocks.VIOLET_CASTLE_RUNE_BRICK);
		blockItem(TFBlocks.PINK_CASTLE_DOOR);
		blockItem(TFBlocks.YELLOW_CASTLE_DOOR);
		blockItem(TFBlocks.BLUE_CASTLE_DOOR);
		blockItem(TFBlocks.VIOLET_CASTLE_DOOR);
		blockItem(TFBlocks.PINK_FORCE_FIELD);
		blockItem(TFBlocks.ORANGE_FORCE_FIELD);
		blockItem(TFBlocks.GREEN_FORCE_FIELD);
		blockItem(TFBlocks.BLUE_FORCE_FIELD);
		blockItem(TFBlocks.VIOLET_FORCE_FIELD);

		blockItem(TFBlocks.UNCRAFTING_TABLE);
		blockItem(TFBlocks.CINDER_FURNACE);
		blockItem(TFBlocks.CINDER_LOG);
		blockItem(TFBlocks.CINDER_WOOD);
		blockItem(TFBlocks.SLIDER);
		blockItem(TFBlocks.IRON_LADDER);

		blockItem(TFBlocks.IRONWOOD_BLOCK);
		blockItem(TFBlocks.STEELEAF_BLOCK);
		blockItem(TFBlocks.FIERY_BLOCK);
		blockItem(TFBlocks.KNIGHTMETAL_BLOCK);
		blockItem(TFBlocks.CARMINITE_BLOCK);
		blockItem(TFBlocks.ARCTIC_FUR_BLOCK);

		blockItem(TFBlocks.MOSS_PATCH);
		blockItem(TFBlocks.MAYAPPLE);
		blockItem(TFBlocks.CLOVER_PATCH);
		blockItem(TFBlocks.FIDDLEHEAD);
		blockItem(TFBlocks.MUSHGLOOM);
		blockItem(TFBlocks.TORCHBERRY_PLANT);
		blockItem(TFBlocks.ROOT_STRAND);
		blockItem(TFBlocks.FALLEN_LEAVES);
		wearableBlock(TFBlocks.FIREFLY, TFBlockEntities.FIREFLY);
		wearableBlock(TFBlocks.CICADA, TFBlockEntities.CICADA);
		wearableBlock(TFBlocks.MOONWORM, TFBlockEntities.MOONWORM);
		blockItem(TFBlocks.FIREFLY_JAR);
		blockItem(TFBlocks.FIREFLY_SPAWNER);
		blockItem(TFBlocks.CICADA_JAR);
		blockItem(TFBlocks.HEDGE);
		blockItem(TFBlocks.ROOT_BLOCK);
		blockItem(TFBlocks.LIVEROOT_BLOCK);

		blockItem(TFBlocks.TWILIGHT_OAK_LEAVES);
		blockItem(TFBlocks.CANOPY_LEAVES);
		blockItem(TFBlocks.MANGROVE_LEAVES);
		blockItem(TFBlocks.DARK_LEAVES);
		blockItem(TFBlocks.TIME_LEAVES);
		blockItem(TFBlocks.TRANSFORMATION_LEAVES);
		blockItem(TFBlocks.MINING_LEAVES);
		blockItem(TFBlocks.SORTING_LEAVES);
		blockItem(TFBlocks.RAINBOW_OAK_LEAVES);
		blockItem(TFBlocks.TWILIGHT_OAK_LOG);
		blockItem(TFBlocks.CANOPY_LOG);
		blockItem(TFBlocks.MANGROVE_LOG);
		blockItem(TFBlocks.DARK_LOG);
		blockItem(TFBlocks.TIME_LOG);
		blockItem(TFBlocks.TRANSFORMATION_LOG);
		blockItem(TFBlocks.MINING_LOG);
		blockItem(TFBlocks.SORTING_LOG);
		blockItem(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG);
		blockItem(TFBlocks.STRIPPED_CANOPY_LOG);
		blockItem(TFBlocks.STRIPPED_MANGROVE_LOG);
		blockItem(TFBlocks.STRIPPED_DARK_LOG);
		blockItem(TFBlocks.STRIPPED_TIME_LOG);
		blockItem(TFBlocks.STRIPPED_TRANSFORMATION_LOG);
		blockItem(TFBlocks.STRIPPED_MINING_LOG);
		blockItem(TFBlocks.STRIPPED_SORTING_LOG);
		blockItem(TFBlocks.TWILIGHT_OAK_WOOD);
		blockItem(TFBlocks.CANOPY_WOOD);
		blockItem(TFBlocks.MANGROVE_WOOD);
		blockItem(TFBlocks.DARK_WOOD);
		blockItem(TFBlocks.TIME_WOOD);
		blockItem(TFBlocks.TRANSFORMATION_WOOD);
		blockItem(TFBlocks.MINING_WOOD);
		blockItem(TFBlocks.SORTING_WOOD);
		blockItem(TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD);
		blockItem(TFBlocks.STRIPPED_CANOPY_WOOD);
		blockItem(TFBlocks.STRIPPED_MANGROVE_WOOD);
		blockItem(TFBlocks.STRIPPED_DARK_WOOD);
		blockItem(TFBlocks.STRIPPED_TIME_WOOD);
		blockItem(TFBlocks.STRIPPED_TRANSFORMATION_WOOD);
		blockItem(TFBlocks.STRIPPED_MINING_WOOD);
		blockItem(TFBlocks.STRIPPED_SORTING_WOOD);

		blockItem(TFBlocks.TIME_LOG_CORE);
		blockItem(TFBlocks.TRANSFORMATION_LOG_CORE);
		blockItem(TFBlocks.MINING_LOG_CORE);
		blockItem(TFBlocks.SORTING_LOG_CORE);
		blockItem(TFBlocks.TWILIGHT_OAK_SAPLING);
		blockItem(TFBlocks.CANOPY_SAPLING);
		blockItem(TFBlocks.MANGROVE_SAPLING);
		blockItem(TFBlocks.DARKWOOD_SAPLING);
		blockItem(TFBlocks.HOLLOW_OAK_SAPLING);
		blockItem(TFBlocks.TIME_SAPLING);
		blockItem(TFBlocks.TRANSFORMATION_SAPLING);
		blockItem(TFBlocks.MINING_SAPLING);
		blockItem(TFBlocks.SORTING_SAPLING);
		blockItem(TFBlocks.RAINBOW_OAK_SAPLING);
		blockItem(TFBlocks.MANGROVE_ROOT);

		blockItem(TFBlocks.OAK_BANISTER);
		blockItem(TFBlocks.SPRUCE_BANISTER);
		blockItem(TFBlocks.BIRCH_BANISTER);
		blockItem(TFBlocks.JUNGLE_BANISTER);
		blockItem(TFBlocks.ACACIA_BANISTER);
		blockItem(TFBlocks.DARK_OAK_BANISTER);
		blockItem(TFBlocks.CRIMSON_BANISTER);
		blockItem(TFBlocks.WARPED_BANISTER);

		hollowLog(TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_OAK_LOG_CLIMBABLE, "hollow_oak_log");
		hollowLog(TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL, TFBlocks.HOLLOW_SPRUCE_LOG_VERTICAL, TFBlocks.HOLLOW_SPRUCE_LOG_CLIMBABLE, "hollow_spruce_log");
		hollowLog(TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL, TFBlocks.HOLLOW_BIRCH_LOG_VERTICAL, TFBlocks.HOLLOW_BIRCH_LOG_CLIMBABLE, "hollow_birch_log");
		hollowLog(TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL, TFBlocks.HOLLOW_JUNGLE_LOG_VERTICAL, TFBlocks.HOLLOW_JUNGLE_LOG_CLIMBABLE, "hollow_jungle_log");
		hollowLog(TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL, TFBlocks.HOLLOW_ACACIA_LOG_VERTICAL, TFBlocks.HOLLOW_ACACIA_LOG_CLIMBABLE, "hollow_acacia_log");
		hollowLog(TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_DARK_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_DARK_OAK_LOG_CLIMBABLE, "hollow_dark_oak_log");
		hollowLog(TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL, TFBlocks.HOLLOW_CRIMSON_STEM_VERTICAL, TFBlocks.HOLLOW_CRIMSON_STEM_CLIMBABLE, "hollow_crimson_stem");
		hollowLog(TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL, TFBlocks.HOLLOW_WARPED_STEM_VERTICAL, TFBlocks.HOLLOW_WARPED_STEM_CLIMBABLE, "hollow_warped_stem");

		hollowLog(TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_CLIMBABLE, "hollow_twilight_oak_log");
		hollowLog(TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL, TFBlocks.HOLLOW_CANOPY_LOG_VERTICAL, TFBlocks.HOLLOW_CANOPY_LOG_CLIMBABLE, "hollow_canopy_log");
		hollowLog(TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL, TFBlocks.HOLLOW_MANGROVE_LOG_VERTICAL, TFBlocks.HOLLOW_MANGROVE_LOG_CLIMBABLE, "hollow_mangrove_log");
		hollowLog(TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL, TFBlocks.HOLLOW_DARK_LOG_VERTICAL, TFBlocks.HOLLOW_DARK_LOG_CLIMBABLE, "hollow_dark_log");
		hollowLog(TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL, TFBlocks.HOLLOW_TIME_LOG_VERTICAL, TFBlocks.HOLLOW_TIME_LOG_CLIMBABLE, "hollow_time_log");
		hollowLog(TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL, TFBlocks.HOLLOW_TRANSFORMATION_LOG_VERTICAL, TFBlocks.HOLLOW_TRANSFORMATION_LOG_CLIMBABLE, "hollow_transformation_log");
		hollowLog(TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL, TFBlocks.HOLLOW_MINING_LOG_VERTICAL, TFBlocks.HOLLOW_MINING_LOG_CLIMBABLE, "hollow_mining_log");
		hollowLog(TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL, TFBlocks.HOLLOW_SORTING_LOG_VERTICAL, TFBlocks.HOLLOW_SORTING_LOG_CLIMBABLE, "hollow_sorting_log");

		blockItem(TFBlocks.TWILIGHT_OAK_PLANKS);
		blockItem(TFBlocks.TWILIGHT_OAK_STAIRS);
		blockItem(TFBlocks.TWILIGHT_OAK_SLAB);
		blockItem(TFBlocks.TWILIGHT_OAK_BUTTON);
		burningItem(TFBlocks.TWILIGHT_OAK_FENCE, 300);
		burningItem(TFBlocks.TWILIGHT_OAK_GATE, 300);
		blockItem(TFBlocks.TWILIGHT_OAK_PLATE);
		blockItem(TFBlocks.TWILIGHT_OAK_TRAPDOOR);
		tallBlock(TFBlocks.TWILIGHT_OAK_DOOR);
		signBlock(TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_WALL_SIGN);
		blockItem(TFBlocks.TWILIGHT_OAK_BANISTER);
		blockItem(TFBlocks.CANOPY_PLANKS);
		blockItem(TFBlocks.CANOPY_STAIRS);
		blockItem(TFBlocks.CANOPY_SLAB);
		blockItem(TFBlocks.CANOPY_BUTTON);
		burningItem(TFBlocks.CANOPY_FENCE, 300);
		burningItem(TFBlocks.CANOPY_GATE, 300);
		blockItem(TFBlocks.CANOPY_PLATE);
		blockItem(TFBlocks.CANOPY_TRAPDOOR);
		tallBlock(TFBlocks.CANOPY_DOOR);
		signBlock(TFBlocks.CANOPY_SIGN, TFBlocks.CANOPY_WALL_SIGN);
		blockItem(TFBlocks.CANOPY_BANISTER);
		blockItem(TFBlocks.CANOPY_BOOKSHELF);
		blockItem(TFBlocks.MANGROVE_PLANKS);
		blockItem(TFBlocks.MANGROVE_STAIRS);
		blockItem(TFBlocks.MANGROVE_SLAB);
		blockItem(TFBlocks.MANGROVE_BUTTON);
		burningItem(TFBlocks.MANGROVE_FENCE, 300);
		burningItem(TFBlocks.MANGROVE_GATE, 300);
		blockItem(TFBlocks.MANGROVE_PLATE);
		blockItem(TFBlocks.MANGROVE_TRAPDOOR);
		tallBlock(TFBlocks.MANGROVE_DOOR);
		signBlock(TFBlocks.MANGROVE_SIGN, TFBlocks.MANGROVE_WALL_SIGN);
		blockItem(TFBlocks.MANGROVE_BANISTER);
		blockItem(TFBlocks.DARK_PLANKS);
		blockItem(TFBlocks.DARK_STAIRS);
		blockItem(TFBlocks.DARK_SLAB);
		blockItem(TFBlocks.DARK_BUTTON);
		burningItem(TFBlocks.DARK_FENCE, 300);
		burningItem(TFBlocks.DARK_GATE, 300);
		blockItem(TFBlocks.DARK_PLATE);
		blockItem(TFBlocks.DARK_TRAPDOOR);
		tallBlock(TFBlocks.DARK_DOOR);
		signBlock(TFBlocks.DARKWOOD_SIGN, TFBlocks.DARKWOOD_WALL_SIGN);
		blockItem(TFBlocks.DARKWOOD_BANISTER);
		blockItem(TFBlocks.TIME_PLANKS);
		blockItem(TFBlocks.TIME_STAIRS);
		blockItem(TFBlocks.TIME_SLAB);
		blockItem(TFBlocks.TIME_BUTTON);
		burningItem(TFBlocks.TIME_FENCE, 300);
		burningItem(TFBlocks.TIME_GATE, 300);
		blockItem(TFBlocks.TIME_PLATE);
		blockItem(TFBlocks.TIME_TRAPDOOR);
		tallBlock(TFBlocks.TIME_DOOR);
		signBlock(TFBlocks.TIME_SIGN, TFBlocks.TIME_WALL_SIGN);
		blockItem(TFBlocks.TIME_BANISTER);
		blockItem(TFBlocks.TRANSFORMATION_PLANKS);
		blockItem(TFBlocks.TRANSFORMATION_STAIRS);
		blockItem(TFBlocks.TRANSFORMATION_SLAB);
		blockItem(TFBlocks.TRANSFORMATION_BUTTON);
		burningItem(TFBlocks.TRANSFORMATION_FENCE, 300);
		burningItem(TFBlocks.TRANSFORMATION_GATE, 300);
		blockItem(TFBlocks.TRANSFORMATION_PLATE);
		blockItem(TFBlocks.TRANSFORMATION_TRAPDOOR);
		tallBlock(TFBlocks.TRANSFORMATION_DOOR);
		signBlock(TFBlocks.TRANSFORMATION_SIGN, TFBlocks.TRANSFORMATION_WALL_SIGN);
		blockItem(TFBlocks.TRANSFORMATION_BANISTER);
		blockItem(TFBlocks.MINING_PLANKS);
		blockItem(TFBlocks.MINING_STAIRS);
		blockItem(TFBlocks.MINING_SLAB);
		blockItem(TFBlocks.MINING_BUTTON);
		burningItem(TFBlocks.MINING_FENCE, 300);
		burningItem(TFBlocks.MINING_GATE, 300);
		blockItem(TFBlocks.MINING_PLATE);
		blockItem(TFBlocks.MINING_TRAPDOOR);
		tallBlock(TFBlocks.MINING_DOOR);
		signBlock(TFBlocks.MINING_SIGN, TFBlocks.MINING_WALL_SIGN);
		blockItem(TFBlocks.MINING_BANISTER);
		blockItem(TFBlocks.SORTING_PLANKS);
		blockItem(TFBlocks.SORTING_STAIRS);
		blockItem(TFBlocks.SORTING_SLAB);
		blockItem(TFBlocks.SORTING_BUTTON);
		burningItem(TFBlocks.SORTING_FENCE, 300);
		burningItem(TFBlocks.SORTING_GATE, 300);
		blockItem(TFBlocks.SORTING_PLATE);
		blockItem(TFBlocks.SORTING_TRAPDOOR);
		tallBlock(TFBlocks.SORTING_DOOR);
		signBlock(TFBlocks.SORTING_SIGN, TFBlocks.SORTING_WALL_SIGN);
		blockItem(TFBlocks.SORTING_BANISTER);

		makeBEWLRItem(TFBlocks.TWILIGHT_OAK_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
		makeBEWLRItem(TFBlocks.CANOPY_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
		makeBEWLRItem(TFBlocks.MANGROVE_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
		makeBEWLRItem(TFBlocks.DARKWOOD_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
		makeBEWLRItem(TFBlocks.TIME_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
		makeBEWLRItem(TFBlocks.TRANSFORMATION_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
		makeBEWLRItem(TFBlocks.MINING_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
		makeBEWLRItem(TFBlocks.SORTING_CHEST, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TF_CHEST));
	}
	//TODO: PORT the ability to set Registry names
	private static <B extends Block> Item hollowLog(HollowLogHorizontal horizontalLog, HollowLogVertical verticalLog, HollowLogClimbable climbable, String name) {
		return makeBlockItem(new HollowLogItem(horizontalLog, verticalLog, climbable, TFItems.defaultBuilder()), new ResourceLocation(TwilightForestMod.ID, name));//.setRegistryName(TwilightForestMod.ID, name);
	}

	private static final Map<Item, ResourceLocation> UNMAPPED = new HashMap<>();

	@Environment(EnvType.CLIENT)
	public static void registerRenderers() {
		for(Map.Entry<Item, ResourceLocation> info : UNMAPPED.entrySet()) {
			BuiltinItemRendererRegistry.INSTANCE.register(info.getKey(), new ISTER(info.getValue())::renderByItem);
		}
	}

	private static <B extends Block> Item blockItem(B block) {
		return makeBlockItem(new BlockItem(block, defaultBuilder()), block);
	}

	private static <B extends AbstractSkullCandleBlock> Item skullCandleItem(B floor, B wall) {
		Item item = makeBlockItem(new SkullCandleItem(floor, wall, defaultBuilder().rarity(Rarity.UNCOMMON)), floor);
		UNMAPPED.put(item, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.SKULL_CANDLE));
		return item;
	}

	private static <B extends Block> Item burningItem(B block, int burntime) {
		return makeBlockItem(new FurnaceFuelItem(block, defaultBuilder(), burntime), block);
	}

	private static <B extends Block, W extends Block> Item trophyBlock(B block, W wallblock) {
		Item item = makeBlockItem(new TrophyItem(block, wallblock, defaultBuilder().rarity(TwilightForestMod.getRarity())), block);
		UNMAPPED.put(item, Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TROPHY));
		return item;
	}

	private static <T extends Block, E extends BlockEntity> Item wearableBlock(T block, BlockEntityType<E> tileentity) {
		Item item = makeBlockItem(new WearableItem(block, defaultBuilder()), block);
		UNMAPPED.put(item, Registry.BLOCK_ENTITY_TYPE.getKey(tileentity));
		return item;
	}


	private static <B extends Block> Item tallBlock(B block) {
		return makeBlockItem(new DoubleHighBlockItem(block, defaultBuilder()), block);
	}

	private static <B extends Block, W extends Block> Item signBlock(B block, W wallblock) {
		return makeBlockItem(new SignItem(defaultBuilder().stacksTo(16), block, wallblock), block);
	}

	private static Item makeBlockItem(Item blockitem, Block block) {
		return Registry.register(Registry.ITEM, Registry.BLOCK.getKey(block), blockitem);
	}

	private static Item makeBlockItem(Item blockitem, ResourceLocation location) {
		return Registry.register(Registry.ITEM, location, blockitem);
	}

	private static void makeBEWLRItem(Block block, ResourceLocation rl) {
		Item item = makeBlockItem(new BlockItem(block, TFItems.defaultBuilder()), block);
		UNMAPPED.put(item, rl);
	}

	public static Item.Properties defaultBuilder() {
		return new Item.Properties().tab(creativeTab);
	}
}
