package twilightforest.data;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.tag.TagFactory;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;

import java.util.Set;
import java.util.function.Predicate;

public class BlockTagGenerator extends BlockTagsProvider {
    public static final Tag.Named<Block> TOWERWOOD = TagFactory.BLOCK.create(TwilightForestMod.prefix("towerwood"));

    public static final Tag.Named<Block> TWILIGHT_OAK_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("twilight_oak_logs"));
    public static final Tag.Named<Block> CANOPY_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("canopy_logs"));
    public static final Tag.Named<Block> MANGROVE_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("mangrove_logs"));
    public static final Tag.Named<Block> DARKWOOD_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("darkwood_logs"));
    public static final Tag.Named<Block> TIME_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("timewood_logs"));
    public static final Tag.Named<Block> TRANSFORMATION_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("transwood_logs"));
    public static final Tag.Named<Block> MINING_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("mining_logs"));
    public static final Tag.Named<Block> SORTING_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("sortwood_logs"));

    public static final Tag.Named<Block> TF_LOGS = TagFactory.BLOCK.create(TwilightForestMod.prefix("logs"));
    public static final Tag.Named<Block> TF_FENCES = TagFactory.BLOCK.create(TwilightForestMod.prefix("fences"));
    public static final Tag.Named<Block> TF_FENCE_GATES = TagFactory.BLOCK.create(TwilightForestMod.prefix("fence_gates"));
    public static final Tag.Named<Block> BANISTERS = TagFactory.BLOCK.create(TwilightForestMod.prefix("banisters"));
    public static final Tag.Named<Block> HOLLOW_LOGS_HORIZONTAL = BlockTags.bind(TwilightForestMod.prefix("hollow_logs_horizontal").toString());
    public static final Tag.Named<Block> HOLLOW_LOGS_VERTICAL = BlockTags.bind(TwilightForestMod.prefix("hollow_logs_vertical").toString());
    public static final Tag.Named<Block> HOLLOW_LOGS_CLIMBABLE = BlockTags.bind(TwilightForestMod.prefix("hollow_logs_climbable").toString());
    public static final Tag.Named<Block> HOLLOW_LOGS = BlockTags.bind(TwilightForestMod.prefix("hollow_logs").toString());

    public static final Tag.Named<Block> STORAGE_BLOCKS_ARCTIC_FUR = TagFactory.BLOCK.create(new ResourceLocation("c:arctic_fur_storage_block"));
    public static final Tag.Named<Block> STORAGE_BLOCKS_CARMINITE = TagFactory.BLOCK.create(new ResourceLocation("c:carminite_storage_block"));
    public static final Tag.Named<Block> STORAGE_BLOCKS_FIERY = TagFactory.BLOCK.create(new ResourceLocation("c:fiery_storage_block"));
    public static final Tag.Named<Block> STORAGE_BLOCKS_IRONWOOD = TagFactory.BLOCK.create(new ResourceLocation("c:ironwood_storage_block"));
    public static final Tag.Named<Block> STORAGE_BLOCKS_KNIGHTMETAL = TagFactory.BLOCK.create(new ResourceLocation("c:knightmetal_storage_block"));
    public static final Tag.Named<Block> STORAGE_BLOCKS_STEELEAF = TagFactory.BLOCK.create(new ResourceLocation("c:steeleaf_storage_block"));

    public static final Tag.Named<Block> ORES_IRONWOOD = TagFactory.BLOCK.create(new ResourceLocation("c:ironwood_ores"));
    public static final Tag.Named<Block> ORES_KNIGHTMETAL = TagFactory.BLOCK.create(new ResourceLocation("c:knightmetal_ores"));

    public static final Tag.Named<Block> CHESTS_WOODEN = TagFactory.BLOCK.create(new ResourceLocation("c:wooden_chests"));

    public static final Tag.Named<Block> PORTAL_EDGE = TagFactory.BLOCK.create(TwilightForestMod.prefix("portal/edge"));
    public static final Tag.Named<Block> PORTAL_POOL = TagFactory.BLOCK.create(TwilightForestMod.prefix("portal/fluid"));
    public static final Tag.Named<Block> PORTAL_DECO = TagFactory.BLOCK.create(TwilightForestMod.prefix("portal/decoration"));

    public static final Tag.Named<Block> SPECIAL_POTS = TagFactory.BLOCK.create(TwilightForestMod.prefix("dark_tower_excluded_pots"));
    public static final Tag.Named<Block> TROPHIES = TagFactory.BLOCK.create(TwilightForestMod.prefix("trophies"));
    public static final Tag.Named<Block> FIRE_JET_FUEL = TagFactory.BLOCK.create(TwilightForestMod.prefix("fire_jet_fuel"));

    public static final Tag.Named<Block> WORLDGEN_SKIPPABLES = BlockTags.bind(TwilightForestMod.prefix("worldgen_skippables").toString());
    public static final Tag.Named<Block> WORLDGEN_REPLACEABLES = BlockTags.bind(TwilightForestMod.prefix("worldgen_replaceables").toString());

    public static final Tag.Named<Block> COMMON_PROTECTIONS = TagFactory.BLOCK.create(TwilightForestMod.prefix("common_protections"));
    public static final Tag.Named<Block> ANNIHILATION_INCLUSIONS = TagFactory.BLOCK.create(TwilightForestMod.prefix("annihilation_inclusions"));
    public static final Tag.Named<Block> ANTIBUILDER_IGNORES = TagFactory.BLOCK.create(TwilightForestMod.prefix("antibuilder_ignores"));
    public static final Tag.Named<Block> CARMINITE_REACTOR_IMMUNE = TagFactory.BLOCK.create(TwilightForestMod.prefix("carminite_reactor_immune"));
    public static final Tag.Named<Block> STRUCTURE_BANNED_INTERACTIONS = TagFactory.BLOCK.create(TwilightForestMod.prefix("structure_banned_interactions"));

    public static final Tag.Named<Block> ORE_MAGNET_SAFE_REPLACE_BLOCK = TagFactory.BLOCK.create(TwilightForestMod.prefix("ore_magnet/ore_safe_replace_block"));
    public static final Tag.Named<Block> ORE_MAGNET_BLOCK_REPLACE_ORE = TagFactory.BLOCK.create(TwilightForestMod.prefix("ore_magnet/block_replace_ore"));
    public static final Tag.Named<Block> ORE_MAGNET_STONE = TagFactory.BLOCK.create(TwilightForestMod.prefix("ore_magnet/minecraft/stone"));
    public static final Tag.Named<Block> ORE_MAGNET_NETHERRACK = TagFactory.BLOCK.create(TwilightForestMod.prefix("ore_magnet/minecraft/netherrack"));
    public static final Tag.Named<Block> ORE_MAGNET_END_STONE = TagFactory.BLOCK.create(TwilightForestMod.prefix("ore_magnet/minecraft/end_stone"));
    public static final Tag.Named<Block> ORE_MAGNET_ROOT = TagFactory.BLOCK.create(TwilightForestMod.prefix("ore_magnet/" + TwilightForestMod.ID + "/root"));
    public static final Tag.Named<Block> ORE_MAGNET_DEEPSLATE = TagFactory.BLOCK.create(TwilightForestMod.prefix("ore_magnet/minecraft/deepslate"));

    public BlockTagGenerator(DataGenerator generator) {
        super(generator);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        tag(TWILIGHT_OAK_LOGS)
                .add(TFBlocks.TWILIGHT_OAK_LOG, TFBlocks.STRIPPED_TWILIGHT_OAK_LOG, TFBlocks.TWILIGHT_OAK_WOOD, TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD);
        tag(CANOPY_LOGS)
                .add(TFBlocks.CANOPY_LOG, TFBlocks.STRIPPED_CANOPY_LOG, TFBlocks.CANOPY_WOOD, TFBlocks.STRIPPED_CANOPY_WOOD);
        tag(MANGROVE_LOGS)
                .add(TFBlocks.MANGROVE_LOG, TFBlocks.STRIPPED_MANGROVE_LOG, TFBlocks.MANGROVE_WOOD, TFBlocks.STRIPPED_MANGROVE_WOOD);
        tag(DARKWOOD_LOGS)
                .add(TFBlocks.DARK_LOG, TFBlocks.STRIPPED_DARK_LOG, TFBlocks.DARK_WOOD, TFBlocks.STRIPPED_DARK_WOOD);
        tag(TIME_LOGS)
                .add(TFBlocks.TIME_LOG, TFBlocks.STRIPPED_TIME_LOG, TFBlocks.TIME_WOOD, TFBlocks.STRIPPED_TIME_WOOD);
        tag(TRANSFORMATION_LOGS)
                .add(TFBlocks.TRANSFORMATION_LOG, TFBlocks.STRIPPED_TRANSFORMATION_LOG, TFBlocks.TRANSFORMATION_WOOD, TFBlocks.STRIPPED_TRANSFORMATION_WOOD);
        tag(MINING_LOGS)
                .add(TFBlocks.MINING_LOG, TFBlocks.STRIPPED_MINING_LOG, TFBlocks.MINING_WOOD, TFBlocks.STRIPPED_MINING_WOOD);
        tag(SORTING_LOGS)
                .add(TFBlocks.SORTING_LOG, TFBlocks.STRIPPED_SORTING_LOG, TFBlocks.SORTING_WOOD, TFBlocks.STRIPPED_SORTING_WOOD);

        tag(TF_LOGS)
                .addTag(TWILIGHT_OAK_LOGS).addTag(CANOPY_LOGS).addTag(MANGROVE_LOGS).addTag(DARKWOOD_LOGS).addTag(TIME_LOGS).addTag(TRANSFORMATION_LOGS).addTag(MINING_LOGS).addTag(SORTING_LOGS);
        tag(BlockTags.LOGS)
                .addTag(TF_LOGS);

        tag(BlockTags.LOGS_THAT_BURN)
                .addTag(TWILIGHT_OAK_LOGS).addTag(CANOPY_LOGS).addTag(MANGROVE_LOGS).addTag(DARKWOOD_LOGS).addTag(TIME_LOGS).addTag(TRANSFORMATION_LOGS).addTag(MINING_LOGS).addTag(SORTING_LOGS);

        tag(BlockTags.SAPLINGS)
                .add(TFBlocks.TWILIGHT_OAK_SAPLING, TFBlocks.CANOPY_SAPLING, TFBlocks.MANGROVE_SAPLING, TFBlocks.DARKWOOD_SAPLING)
                .add(TFBlocks.TIME_SAPLING, TFBlocks.TRANSFORMATION_SAPLING, TFBlocks.MINING_SAPLING, TFBlocks.SORTING_SAPLING)
                .add(TFBlocks.HOLLOW_OAK_SAPLING, TFBlocks.RAINBOW_OAK_SAPLING);
        tag(BlockTags.LEAVES)
                .add(TFBlocks.RAINBOW_OAK_LEAVES, TFBlocks.TWILIGHT_OAK_LEAVES, TFBlocks.CANOPY_LEAVES, TFBlocks.MANGROVE_LEAVES, TFBlocks.DARK_LEAVES)
                .add(TFBlocks.TIME_LEAVES, TFBlocks.TRANSFORMATION_LEAVES, TFBlocks.MINING_LEAVES, TFBlocks.SORTING_LEAVES)
                .add(TFBlocks.THORN_LEAVES, TFBlocks.BEANSTALK_LEAVES);

        tag(BlockTags.PLANKS)
                .add(TFBlocks.TWILIGHT_OAK_PLANKS, TFBlocks.CANOPY_PLANKS, TFBlocks.MANGROVE_PLANKS, TFBlocks.DARK_PLANKS)
                .add(TFBlocks.TIME_PLANKS, TFBlocks.TRANSFORMATION_PLANKS, TFBlocks.MINING_PLANKS, TFBlocks.SORTING_PLANKS)
                .add(TFBlocks.TOWERWOOD, TFBlocks.ENCASED_TOWERWOOD, TFBlocks.CRACKED_TOWERWOOD, TFBlocks.MOSSY_TOWERWOOD, TFBlocks.INFESTED_TOWERWOOD);

        tag(TF_FENCES)
                .add(TFBlocks.TWILIGHT_OAK_FENCE, TFBlocks.CANOPY_FENCE, TFBlocks.MANGROVE_FENCE, TFBlocks.DARK_FENCE)
                .add(TFBlocks.TIME_FENCE, TFBlocks.TRANSFORMATION_FENCE, TFBlocks.MINING_FENCE, TFBlocks.SORTING_FENCE);
        tag(TF_FENCE_GATES)
                .add(TFBlocks.TWILIGHT_OAK_GATE, TFBlocks.CANOPY_GATE, TFBlocks.MANGROVE_GATE, TFBlocks.DARK_GATE)
                .add(TFBlocks.TIME_GATE, TFBlocks.TRANSFORMATION_GATE, TFBlocks.MINING_GATE, TFBlocks.SORTING_GATE);
        tag(BlockTags.WOODEN_FENCES)
                .add(TFBlocks.TWILIGHT_OAK_FENCE, TFBlocks.CANOPY_FENCE, TFBlocks.MANGROVE_FENCE, TFBlocks.DARK_FENCE)
                .add(TFBlocks.TIME_FENCE, TFBlocks.TRANSFORMATION_FENCE, TFBlocks.MINING_FENCE, TFBlocks.SORTING_FENCE);
        tag(BlockTags.FENCE_GATES)
                .add(TFBlocks.TWILIGHT_OAK_GATE, TFBlocks.CANOPY_GATE, TFBlocks.MANGROVE_GATE, TFBlocks.DARK_GATE)
                .add(TFBlocks.TIME_GATE, TFBlocks.TRANSFORMATION_GATE, TFBlocks.MINING_GATE, TFBlocks.SORTING_GATE);
//        tag(Tags.Blocks.FENCES)
//                .add(TFBlocks.TWILIGHT_OAK_FENCE, TFBlocks.CANOPY_FENCE, TFBlocks.MANGROVE_FENCE, TFBlocks.DARK_FENCE)
//                .add(TFBlocks.TIME_FENCE, TFBlocks.TRANSFORMATION_FENCE, TFBlocks.MINING_FENCE, TFBlocks.SORTING_FENCE);
//        tag(Tags.Blocks.FENCE_GATES)
//                .add(TFBlocks.TWILIGHT_OAK_GATE, TFBlocks.CANOPY_GATE, TFBlocks.MANGROVE_GATE, TFBlocks.DARK_GATE)
//                .add(TFBlocks.TIME_GATE, TFBlocks.TRANSFORMATION_GATE, TFBlocks.MINING_GATE, TFBlocks.SORTING_GATE);
//        tag(Tags.Blocks.FENCES_WOODEN)
//                .add(TFBlocks.TWILIGHT_OAK_FENCE, TFBlocks.CANOPY_FENCE, TFBlocks.MANGROVE_FENCE, TFBlocks.DARK_FENCE)
//                .add(TFBlocks.TIME_FENCE, TFBlocks.TRANSFORMATION_FENCE, TFBlocks.MINING_FENCE, TFBlocks.SORTING_FENCE);
//        tag(Tags.Blocks.FENCE_GATES_WOODEN)
//                .add(TFBlocks.TWILIGHT_OAK_GATE, TFBlocks.CANOPY_GATE, TFBlocks.MANGROVE_GATE, TFBlocks.DARK_GATE)
//                .add(TFBlocks.TIME_GATE, TFBlocks.TRANSFORMATION_GATE, TFBlocks.MINING_GATE, TFBlocks.SORTING_GATE);

        tag(BlockTags.WOODEN_SLABS)
                .add(TFBlocks.TWILIGHT_OAK_SLAB, TFBlocks.CANOPY_SLAB, TFBlocks.MANGROVE_SLAB, TFBlocks.DARK_SLAB)
                .add(TFBlocks.TIME_SLAB, TFBlocks.TRANSFORMATION_SLAB, TFBlocks.MINING_SLAB, TFBlocks.SORTING_SLAB);
        tag(BlockTags.SLABS)
                .add(TFBlocks.AURORA_SLAB);
        tag(BlockTags.WOODEN_STAIRS)
                .add(TFBlocks.TWILIGHT_OAK_STAIRS, TFBlocks.CANOPY_STAIRS, TFBlocks.MANGROVE_STAIRS, TFBlocks.DARK_STAIRS)
                .add(TFBlocks.TIME_STAIRS, TFBlocks.TRANSFORMATION_STAIRS, TFBlocks.MINING_STAIRS, TFBlocks.SORTING_STAIRS);
        tag(BlockTags.STAIRS)
                .add(TFBlocks.CASTLE_BRICK_STAIRS, TFBlocks.WORN_CASTLE_BRICK_STAIRS, TFBlocks.CRACKED_CASTLE_BRICK_STAIRS, TFBlocks.MOSSY_CASTLE_BRICK_STAIRS, TFBlocks.ENCASED_CASTLE_BRICK_STAIRS, TFBlocks.BOLD_CASTLE_BRICK_STAIRS)
                .add(TFBlocks.NAGASTONE_STAIRS_LEFT, TFBlocks.NAGASTONE_STAIRS_RIGHT, TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT, TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT, TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT, TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT);

        tag(BlockTags.WOODEN_BUTTONS)
                .add(TFBlocks.TWILIGHT_OAK_BUTTON, TFBlocks.CANOPY_BUTTON, TFBlocks.MANGROVE_BUTTON, TFBlocks.DARK_BUTTON)
                .add(TFBlocks.TIME_BUTTON, TFBlocks.TRANSFORMATION_BUTTON, TFBlocks.MINING_BUTTON, TFBlocks.SORTING_BUTTON);
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(TFBlocks.TWILIGHT_OAK_PLATE, TFBlocks.CANOPY_PLATE, TFBlocks.MANGROVE_PLATE, TFBlocks.DARK_PLATE)
                .add(TFBlocks.TIME_PLATE, TFBlocks.TRANSFORMATION_PLATE, TFBlocks.MINING_PLATE, TFBlocks.SORTING_PLATE);

        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(TFBlocks.TWILIGHT_OAK_TRAPDOOR, TFBlocks.CANOPY_TRAPDOOR, TFBlocks.MANGROVE_TRAPDOOR, TFBlocks.DARK_TRAPDOOR)
                .add(TFBlocks.TIME_TRAPDOOR, TFBlocks.TRANSFORMATION_TRAPDOOR, TFBlocks.MINING_TRAPDOOR, TFBlocks.SORTING_TRAPDOOR);
        tag(BlockTags.WOODEN_DOORS)
                .add(TFBlocks.TWILIGHT_OAK_DOOR, TFBlocks.CANOPY_DOOR, TFBlocks.MANGROVE_DOOR, TFBlocks.DARK_DOOR)
                .add(TFBlocks.TIME_DOOR, TFBlocks.TRANSFORMATION_DOOR, TFBlocks.MINING_DOOR, TFBlocks.SORTING_DOOR);

        tag(CHESTS_WOODEN)
                .add(Blocks.CHEST).add(Blocks.TRAPPED_CHEST)
                .add(TFBlocks.TWILIGHT_OAK_CHEST, TFBlocks.CANOPY_CHEST, TFBlocks.MANGROVE_CHEST, TFBlocks.DARKWOOD_CHEST)
                .add(TFBlocks.TIME_CHEST, TFBlocks.TRANSFORMATION_CHEST, TFBlocks.MINING_CHEST, TFBlocks.SORTING_CHEST);
        tag(BlockTags.FLOWER_POTS)
                .add(TFBlocks.POTTED_TWILIGHT_OAK_SAPLING, TFBlocks.POTTED_CANOPY_SAPLING, TFBlocks.POTTED_MANGROVE_SAPLING, TFBlocks.POTTED_DARKWOOD_SAPLING, TFBlocks.POTTED_RAINBOW_OAK_SAPLING)
                .add(TFBlocks.POTTED_HOLLOW_OAK_SAPLING, TFBlocks.POTTED_TIME_SAPLING, TFBlocks.POTTED_TRANSFORMATION_SAPLING, TFBlocks.POTTED_MINING_SAPLING, TFBlocks.POTTED_SORTING_SAPLING)
                .add(TFBlocks.POTTED_MAYAPPLE, TFBlocks.POTTED_FIDDLEHEAD, TFBlocks.POTTED_MUSHGLOOM, TFBlocks.POTTED_THORN, TFBlocks.POTTED_GREEN_THORN, TFBlocks.POTTED_DEAD_THORN);

        tag(BANISTERS).add(
                TFBlocks.OAK_BANISTER,
                TFBlocks.SPRUCE_BANISTER,
                TFBlocks.BIRCH_BANISTER,
                TFBlocks.JUNGLE_BANISTER,
                TFBlocks.ACACIA_BANISTER,
                TFBlocks.DARK_OAK_BANISTER,
                TFBlocks.CRIMSON_BANISTER,
                TFBlocks.WARPED_BANISTER,

                TFBlocks.TWILIGHT_OAK_BANISTER,
                TFBlocks.CANOPY_BANISTER,
                TFBlocks.MANGROVE_BANISTER,
                TFBlocks.DARKWOOD_BANISTER,
                TFBlocks.TIME_BANISTER,
                TFBlocks.TRANSFORMATION_BANISTER,
                TFBlocks.MINING_BANISTER,
                TFBlocks.SORTING_BANISTER
        );

        tag(HOLLOW_LOGS_HORIZONTAL).add(
                TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL.get(),
                TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL.get(),
                TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL.get(),
                TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL.get()
        );

        tag(HOLLOW_LOGS_VERTICAL).add(
                TFBlocks.HOLLOW_OAK_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_SPRUCE_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_BIRCH_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_JUNGLE_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_ACACIA_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_DARK_OAK_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_CRIMSON_STEM_VERTICAL.get(),
                TFBlocks.HOLLOW_WARPED_STEM_VERTICAL.get(),

                TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_CANOPY_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_MANGROVE_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_DARK_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_TIME_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_TRANSFORMATION_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_MINING_LOG_VERTICAL.get(),
                TFBlocks.HOLLOW_SORTING_LOG_VERTICAL.get()
        );

        tag(HOLLOW_LOGS_CLIMBABLE).add(
                TFBlocks.HOLLOW_OAK_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_SPRUCE_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_BIRCH_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_JUNGLE_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_ACACIA_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_DARK_OAK_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_CRIMSON_STEM_CLIMBABLE.get(),
                TFBlocks.HOLLOW_WARPED_STEM_CLIMBABLE.get(),

                TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_CANOPY_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_MANGROVE_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_DARK_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_TIME_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_TRANSFORMATION_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_MINING_LOG_CLIMBABLE.get(),
                TFBlocks.HOLLOW_SORTING_LOG_CLIMBABLE.get()
        );

        tag(HOLLOW_LOGS).addTags(HOLLOW_LOGS_HORIZONTAL, HOLLOW_LOGS_VERTICAL, HOLLOW_LOGS_CLIMBABLE);

        tag(BlockTags.STRIDER_WARM_BLOCKS).add(TFBlocks.FIERY_BLOCK);
        tag(BlockTags.PORTALS).add(TFBlocks.TWILIGHT_PORTAL);

        tag(BlockTags.CLIMBABLE).add(TFBlocks.IRON_LADDER, TFBlocks.ROOT_STRAND).addTag(HOLLOW_LOGS_CLIMBABLE);

        tag(BlockTags.STANDING_SIGNS).add(TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.CANOPY_SIGN,
                TFBlocks.MANGROVE_SIGN, TFBlocks.DARKWOOD_SIGN,
                TFBlocks.TIME_SIGN, TFBlocks.TRANSFORMATION_SIGN,
                TFBlocks.MINING_SIGN, TFBlocks.SORTING_SIGN);

        tag(BlockTags.WALL_SIGNS).add(TFBlocks.TWILIGHT_WALL_SIGN, TFBlocks.CANOPY_WALL_SIGN,
                TFBlocks.MANGROVE_WALL_SIGN, TFBlocks.DARKWOOD_WALL_SIGN,
                TFBlocks.TIME_WALL_SIGN, TFBlocks.TRANSFORMATION_WALL_SIGN,
                TFBlocks.MINING_WALL_SIGN, TFBlocks.SORTING_WALL_SIGN);

        tag(TOWERWOOD).add(TFBlocks.TOWERWOOD, TFBlocks.MOSSY_TOWERWOOD, TFBlocks.CRACKED_TOWERWOOD, TFBlocks.INFESTED_TOWERWOOD);

        tag(STORAGE_BLOCKS_ARCTIC_FUR).add(TFBlocks.ARCTIC_FUR_BLOCK);
        tag(STORAGE_BLOCKS_CARMINITE).add(TFBlocks.CARMINITE_BLOCK);
        tag(STORAGE_BLOCKS_FIERY).add(TFBlocks.FIERY_BLOCK);
        tag(STORAGE_BLOCKS_IRONWOOD).add(TFBlocks.IRONWOOD_BLOCK);
        tag(STORAGE_BLOCKS_KNIGHTMETAL).add(TFBlocks.KNIGHTMETAL_BLOCK);
        tag(STORAGE_BLOCKS_STEELEAF).add(TFBlocks.STEELEAF_BLOCK);

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .addTag(STORAGE_BLOCKS_ARCTIC_FUR)
                .addTag(STORAGE_BLOCKS_CARMINITE)
                .addTag(STORAGE_BLOCKS_FIERY)
                .addTag(STORAGE_BLOCKS_IRONWOOD)
                .addTag(STORAGE_BLOCKS_KNIGHTMETAL)
                .addTag(STORAGE_BLOCKS_STEELEAF);

        //tag(Tags.Blocks.STORAGE_BLOCKS).addTags(STORAGE_BLOCKS_ARCTIC_FUR, STORAGE_BLOCKS_CARMINITE, STORAGE_BLOCKS_FIERY,  STORAGE_BLOCKS_IRONWOOD, STORAGE_BLOCKS_KNIGHTMETAL, STORAGE_BLOCKS_STEELEAF);

        //tag(Tags.Blocks.ORES).addTags(ORES_IRONWOOD, ORES_KNIGHTMETAL);
        tag(ORES_IRONWOOD); // Intentionally blank
        tag(ORES_KNIGHTMETAL); // Intentionally blank

        tag(BlockTags.DIRT).add(TFBlocks.UBEROUS_SOIL);
        tag(PORTAL_EDGE).addTag(BlockTags.DIRT);
        // So yes, we could do fluid tags for the portal pool but the problem is that we're -replacing- the block, effectively replacing what would be waterlogged, with the portal block
        // In the future if we can "portal log" blocks then we can re-explore doing it as a fluid
        tag(PORTAL_POOL).add(Blocks.WATER);
        tag(BlockTags.FLOWERS);
        tag(BlockTags.LEAVES);
        tag(BlockTags.SAPLINGS);
        tag(BlockTags.CROPS);
        tag(PORTAL_DECO)
                .addTag(BlockTags.FLOWERS).addTag(BlockTags.LEAVES).addTag(BlockTags.SAPLINGS).addTag(BlockTags.CROPS)
                .add(Blocks.BAMBOO)
                .add(getAllMinecraftOrTwilightBlocks(b -> (b.material == Material.PLANT || b.material == Material.REPLACEABLE_PLANT || b.material == Material.LEAVES) && !plants.contains(b)));

        tag(DARK_TOWER_ALLOWED_POTS)
                .add(TFBlocks.POTTED_TWILIGHT_OAK_SAPLING, TFBlocks.POTTED_CANOPY_SAPLING, TFBlocks.POTTED_MANGROVE_SAPLING,
                        TFBlocks.POTTED_DARKWOOD_SAPLING, TFBlocks.POTTED_RAINBOW_OAK_SAPLING, TFBlocks.POTTED_MAYAPPLE,
                        TFBlocks.POTTED_FIDDLEHEAD, TFBlocks.POTTED_MUSHGLOOM)
                .add(Blocks.FLOWER_POT, Blocks.POTTED_POPPY, Blocks.POTTED_BLUE_ORCHID, Blocks.POTTED_ALLIUM, Blocks.POTTED_AZURE_BLUET,
                        Blocks.POTTED_RED_TULIP, Blocks.POTTED_ORANGE_TULIP, Blocks.POTTED_WHITE_TULIP, Blocks.POTTED_PINK_TULIP,
                        Blocks.POTTED_OXEYE_DAISY, Blocks.POTTED_DANDELION, Blocks.POTTED_OAK_SAPLING, Blocks.POTTED_SPRUCE_SAPLING,
                        Blocks.POTTED_BIRCH_SAPLING, Blocks.POTTED_JUNGLE_SAPLING, Blocks.POTTED_ACACIA_SAPLING, Blocks.POTTED_DARK_OAK_SAPLING,
                        Blocks.POTTED_RED_MUSHROOM, Blocks.POTTED_BROWN_MUSHROOM, Blocks.POTTED_DEAD_BUSH, Blocks.POTTED_FERN,
                        Blocks.POTTED_CACTUS, Blocks.POTTED_CORNFLOWER, Blocks.POTTED_LILY_OF_THE_VALLEY, Blocks.POTTED_WITHER_ROSE,
                        Blocks.POTTED_BAMBOO, Blocks.POTTED_CRIMSON_FUNGUS, Blocks.POTTED_WARPED_FUNGUS, Blocks.POTTED_CRIMSON_ROOTS,
                        Blocks.POTTED_WARPED_ROOTS, Blocks.POTTED_AZALEA, Blocks.POTTED_FLOWERING_AZALEA);;

        tag(TROPHIES)
                .add(TFBlocks.NAGA_TROPHY, TFBlocks.NAGA_WALL_TROPHY)
                .add(TFBlocks.LICH_TROPHY, TFBlocks.LICH_WALL_TROPHY)
                .add(TFBlocks.MINOSHROOM_TROPHY, TFBlocks.MINOSHROOM_WALL_TROPHY)
                .add(TFBlocks.HYDRA_TROPHY, TFBlocks.HYDRA_WALL_TROPHY)
                .add(TFBlocks.KNIGHT_PHANTOM_TROPHY, TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY)
                .add(TFBlocks.UR_GHAST_TROPHY, TFBlocks.UR_GHAST_WALL_TROPHY)
                .add(TFBlocks.ALPHA_YETI_TROPHY, TFBlocks.ALPHA_YETI_WALL_TROPHY)
                .add(TFBlocks.SNOW_QUEEN_TROPHY, TFBlocks.SNOW_QUEEN_WALL_TROPHY)
                .add(TFBlocks.QUEST_RAM_TROPHY, TFBlocks.QUEST_RAM_WALL_TROPHY);

        tag(FIRE_JET_FUEL).add(Blocks.LAVA);

        tag(COMMON_PROTECTIONS).add( // For any blocks that absolutely should not be meddled with
                TFBlocks.NAGA_BOSS_SPAWNER,
                TFBlocks.LICH_BOSS_SPAWNER,
                TFBlocks.MINOSHROOM_BOSS_SPAWNER,
                TFBlocks.HYDRA_BOSS_SPAWNER,
                TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER,
                TFBlocks.UR_GHAST_BOSS_SPAWNER,
                TFBlocks.ALPHA_YETI_BOSS_SPAWNER,
                TFBlocks.SNOW_QUEEN_BOSS_SPAWNER,
                TFBlocks.FINAL_BOSS_BOSS_SPAWNER,
                TFBlocks.STRONGHOLD_SHIELD,
                TFBlocks.VANISHING_BLOCK,
                TFBlocks.LOCKED_VANISHING_BLOCK,
                TFBlocks.PINK_FORCE_FIELD,
                TFBlocks.ORANGE_FORCE_FIELD,
                TFBlocks.GREEN_FORCE_FIELD,
                TFBlocks.BLUE_FORCE_FIELD,
                TFBlocks.VIOLET_FORCE_FIELD,
                TFBlocks.KEEPSAKE_CASKET,
                TFBlocks.TROPHY_PEDESTAL
        ).add( // [VanillaCopy] WITHER_IMMUNE - Do NOT include that tag in this tag
                Blocks.BARRIER,
                Blocks.BEDROCK,
                Blocks.END_PORTAL,
                Blocks.END_PORTAL_FRAME,
                Blocks.END_GATEWAY,
                Blocks.COMMAND_BLOCK,
                Blocks.REPEATING_COMMAND_BLOCK,
                Blocks.CHAIN_COMMAND_BLOCK,
                Blocks.STRUCTURE_BLOCK,
                Blocks.JIGSAW,
                Blocks.MOVING_PISTON
        );

        // TODO Test behavior with giant blocks for immunity stuffs
        tag(BlockTags.DRAGON_IMMUNE).addTag(COMMON_PROTECTIONS).add(TFBlocks.GIANT_OBSIDIAN, TFBlocks.FAKE_DIAMOND,  TFBlocks.FAKE_GOLD);

        tag(BlockTags.WITHER_IMMUNE).addTag(COMMON_PROTECTIONS).add(TFBlocks.FAKE_DIAMOND, TFBlocks.FAKE_GOLD);

        tag(CARMINITE_REACTOR_IMMUNE).addTag(COMMON_PROTECTIONS);

        tag(ANNIHILATION_INCLUSIONS) // This is NOT a blacklist! This is a whitelist
                .add(TFBlocks.DEADROCK, TFBlocks.CRACKED_DEADROCK, TFBlocks.WEATHERED_DEADROCK)
                .add(TFBlocks.CASTLE_BRICK, TFBlocks.CRACKED_DEADROCK, TFBlocks.THICK_CASTLE_BRICK, TFBlocks.MOSSY_CASTLE_BRICK, TFBlocks.CASTLE_ROOF_TILE, TFBlocks.WORN_CASTLE_BRICK)
                .add(TFBlocks.BLUE_CASTLE_RUNE_BRICK, TFBlocks.VIOLET_CASTLE_RUNE_BRICK, TFBlocks.YELLOW_CASTLE_RUNE_BRICK, TFBlocks.PINK_CASTLE_RUNE_BRICK)
                .add(TFBlocks.PINK_FORCE_FIELD, TFBlocks.ORANGE_FORCE_FIELD, TFBlocks.GREEN_FORCE_FIELD, TFBlocks.BLUE_FORCE_FIELD, TFBlocks.VIOLET_FORCE_FIELD)
                .add(TFBlocks.BROWN_THORNS, TFBlocks.GREEN_THORNS);

        tag(ANTIBUILDER_IGNORES).addTag(COMMON_PROTECTIONS).addOptional(new ResourceLocation("gravestone:gravestone")).add(
                Blocks.REDSTONE_LAMP,
                Blocks.TNT,
                Blocks.WATER,
                TFBlocks.ANTIBUILDER,
                TFBlocks.CARMINITE_BUILDER,
                TFBlocks.BUILT_BLOCK,
                TFBlocks.REACTOR_DEBRIS,
                TFBlocks.CARMINITE_REACTOR,
                TFBlocks.REAPPEARING_BLOCK,
                TFBlocks.GHAST_TRAP,
                TFBlocks.FAKE_DIAMOND,
                TFBlocks.FAKE_GOLD
        );

        tag(BlockTags.BUTTONS);
        tag(STRUCTURE_BANNED_INTERACTIONS)
                .addTag(BlockTags.BUTTONS).add(Blocks.CHEST).add(Blocks.TRAPPED_CHEST).add(Blocks.ENDER_CHEST).add(Blocks.LEVER)
                .add(TFBlocks.ANTIBUILDER);

        tag(BlockTags.SAND);
        tag(ORE_MAGNET_SAFE_REPLACE_BLOCK)
                .addTag(ORE_MAGNET_BLOCK_REPLACE_ORE).addTag(BlockTags.DIRT).add(Blocks.GRAVEL).addTag(BlockTags.SAND)
                .add(Blocks.GRANITE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.TUFF, Blocks.CALCITE);

        tag(ORE_MAGNET_BLOCK_REPLACE_ORE)
                .add(Blocks.STONE, Blocks.NETHERRACK, Blocks.END_STONE, TFBlocks.ROOT_BLOCK, Blocks.DEEPSLATE);

        // Don't add general ore taglists here, since those will include non-stone ores
        tag(ORE_MAGNET_STONE).add(
                Blocks.GOLD_ORE,
                Blocks.IRON_ORE,
                Blocks.COAL_ORE,
                Blocks.LAPIS_ORE,
                Blocks.DIAMOND_ORE,
                Blocks.REDSTONE_ORE,
                Blocks.EMERALD_ORE,
                Blocks.COPPER_ORE
        );

        tag(ORE_MAGNET_NETHERRACK).add(Blocks.NETHER_GOLD_ORE, Blocks.NETHER_QUARTZ_ORE);

        // Using a Quark ore as an example filler
        tag(ORE_MAGNET_END_STONE).addOptional(new ResourceLocation("quark", "biotite_ore"));

        tag(ORE_MAGNET_DEEPSLATE).add(
                Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.DEEPSLATE_IRON_ORE,
                Blocks.DEEPSLATE_COAL_ORE,
                Blocks.DEEPSLATE_LAPIS_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                Blocks.DEEPSLATE_REDSTONE_ORE,
                Blocks.DEEPSLATE_EMERALD_ORE,
                Blocks.DEEPSLATE_COPPER_ORE
        );

        tag(ORE_MAGNET_ROOT).add(TFBlocks.LIVEROOT_BLOCK);

        tag(BlockTags.OCCLUDES_VIBRATION_SIGNALS).add(TFBlocks.ARCTIC_FUR_BLOCK.get());

        // For anything that you consider okay for placer systems to pass through during Worldgen
        tag(WORLDGEN_SKIPPABLES).addTags(BlockTags.LOGS, COMMON_PROTECTIONS).add(TFBlocks.LIVEROOT_BLOCK.get(), TFBlocks.MANGROVE_ROOT.get());
        // For anything that permits replacement during Worldgen
        tag(WORLDGEN_REPLACEABLES).addTags(BlockTags.LUSH_GROUND_REPLACEABLE);

        tag(BlockTags.MINEABLE_WITH_AXE).addTags(BANISTERS, HOLLOW_LOGS).add(
                TFBlocks.HEDGE,
                TFBlocks.ROOT_BLOCK,
                TFBlocks.LIVEROOT_BLOCK,
                TFBlocks.MANGROVE_ROOT,
                TFBlocks.UNCRAFTING_TABLE,
                TFBlocks.ENCASED_SMOKER,
                TFBlocks.ENCASED_FIRE_JET,
                TFBlocks.TIME_LOG_CORE,
                TFBlocks.TRANSFORMATION_LOG_CORE,
                TFBlocks.MINING_LOG_CORE,
                TFBlocks.SORTING_LOG_CORE,
                TFBlocks.TOWERWOOD,
                TFBlocks.MOSSY_TOWERWOOD,
                TFBlocks.CRACKED_TOWERWOOD,
                TFBlocks.INFESTED_TOWERWOOD,
                TFBlocks.ENCASED_TOWERWOOD,
                TFBlocks.REAPPEARING_BLOCK,
                TFBlocks.ANTIBUILDER,
                TFBlocks.CARMINITE_REACTOR,
                TFBlocks.CARMINITE_BUILDER,
                TFBlocks.GHAST_TRAP,
                TFBlocks.HUGE_STALK,
                TFBlocks.HUGE_MUSHGLOOM,
                TFBlocks.HUGE_MUSHGLOOM_STEM,
                TFBlocks.CINDER_LOG,
                TFBlocks.CINDER_WOOD,
                TFBlocks.IRONWOOD_BLOCK,
                TFBlocks.DEATH_TOME_SPAWNER,
                TFBlocks.EMPTY_CANOPY_BOOKSHELF,
                TFBlocks.CANOPY_BOOKSHELF
        );

        tag(BlockTags.MINEABLE_WITH_HOE).add(
                //vanilla doesnt use the leaves tag
                TFBlocks.TWILIGHT_OAK_LEAVES,
                TFBlocks.CANOPY_LEAVES,
                TFBlocks.MANGROVE_LEAVES,
                TFBlocks.DARK_LEAVES,
                TFBlocks.RAINBOW_OAK_LEAVES,
                TFBlocks.TIME_LEAVES,
                TFBlocks.TRANSFORMATION_LEAVES,
                TFBlocks.MINING_LEAVES,
                TFBlocks.SORTING_LEAVES,
                TFBlocks.THORN_LEAVES,
                TFBlocks.THORN_ROSE,
                TFBlocks.BEANSTALK_LEAVES,
                TFBlocks.STEELEAF_BLOCK,
                TFBlocks.ARCTIC_FUR_BLOCK
        );

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TFBlocks.MAZESTONE,
                TFBlocks.MAZESTONE_BORDER,
                TFBlocks.MAZESTONE_BRICK,
                TFBlocks.CUT_MAZESTONE,
                TFBlocks.CRACKED_MAZESTONE,
                TFBlocks.DECORATIVE_MAZESTONE,
                TFBlocks.MAZESTONE_MOSAIC,
                TFBlocks.MOSSY_MAZESTONE,
                TFBlocks.NAGASTONE,
                TFBlocks.NAGASTONE_HEAD,
                TFBlocks.STRONGHOLD_SHIELD,
                TFBlocks.TROPHY_PEDESTAL,
                TFBlocks.AURORA_PILLAR,
                TFBlocks.AURORA_SLAB,
                TFBlocks.UNDERBRICK,
                TFBlocks.MOSSY_UNDERBRICK,
                TFBlocks.CRACKED_UNDERBRICK,
                TFBlocks.UNDERBRICK_FLOOR,
                TFBlocks.DEADROCK,
                TFBlocks.CRACKED_DEADROCK,
                TFBlocks.WEATHERED_DEADROCK,
                TFBlocks.TROLLSTEINN,
                TFBlocks.GIANT_LEAVES,
                TFBlocks.GIANT_OBSIDIAN,
                TFBlocks.GIANT_COBBLESTONE,
                TFBlocks.GIANT_LOG,
                TFBlocks.CASTLE_BRICK,
                TFBlocks.WORN_CASTLE_BRICK,
                TFBlocks.CRACKED_CASTLE_BRICK,
                TFBlocks.CASTLE_ROOF_TILE,
                TFBlocks.MOSSY_CASTLE_BRICK,
                TFBlocks.THICK_CASTLE_BRICK,
                TFBlocks.ENCASED_CASTLE_BRICK_PILLAR,
                TFBlocks.ENCASED_CASTLE_BRICK_TILE,
                TFBlocks.BOLD_CASTLE_BRICK_PILLAR,
                TFBlocks.BOLD_CASTLE_BRICK_TILE,
                TFBlocks.CASTLE_BRICK_STAIRS,
                TFBlocks.WORN_CASTLE_BRICK_STAIRS,
                TFBlocks.CRACKED_CASTLE_BRICK_STAIRS,
                TFBlocks.MOSSY_CASTLE_BRICK_STAIRS,
                TFBlocks.ENCASED_CASTLE_BRICK_STAIRS,
                TFBlocks.BOLD_CASTLE_BRICK_STAIRS,
                TFBlocks.PINK_CASTLE_RUNE_BRICK,
                TFBlocks.YELLOW_CASTLE_RUNE_BRICK,
                TFBlocks.BLUE_CASTLE_RUNE_BRICK,
                TFBlocks.VIOLET_CASTLE_RUNE_BRICK,
                TFBlocks.PINK_CASTLE_DOOR,
                TFBlocks.YELLOW_CASTLE_DOOR,
                TFBlocks.BLUE_CASTLE_DOOR,
                TFBlocks.VIOLET_CASTLE_DOOR,
                TFBlocks.CINDER_FURNACE,
                TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE,
                //TFBlocks.HEDGE_MAZE_MINIATURE_STRUCTURE,
                //TFBlocks.HOLLOW_HILL_MINIATURE_STRUCTURE,
                //TFBlocks.QUEST_GROVE_MINIATURE_STRUCTURE,
                //TFBlocks.MUSHROOM_TOWER_MINIATURE_STRUCTURE,
                TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE,
                TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE,
                //TFBlocks.MINOTAUR_LABYRINTH_MINIATURE_STRUCTURE,
                //TFBlocks.HYDRA_LAIR_MINIATURE_STRUCTURE,
                //TFBlocks.GOBLIN_STRONGHOLD_MINIATURE_STRUCTURE,
                //TFBlocks.DARK_TOWER_MINIATURE_STRUCTURE,
                //TFBlocks.YETI_CAVE_MINIATURE_STRUCTURE,
                //TFBlocks.AURORA_PALACE_MINIATURE_STRUCTURE,
                //TFBlocks.TROLL_CAVE_COTTAGE_MINIATURE_STRUCTURE,
                //TFBlocks.FINAL_CASTLE_MINIATURE_STRUCTURE,
                TFBlocks.KNIGHTMETAL_BLOCK,
                TFBlocks.IRONWOOD_BLOCK,
                TFBlocks.FIERY_BLOCK,
                TFBlocks.SPIRAL_BRICKS,
                TFBlocks.ETCHED_NAGASTONE,
                TFBlocks.NAGASTONE_PILLAR,
                TFBlocks.NAGASTONE_STAIRS_LEFT,
                TFBlocks.NAGASTONE_STAIRS_RIGHT,
                TFBlocks.MOSSY_ETCHED_NAGASTONE,
                TFBlocks.MOSSY_NAGASTONE_PILLAR,
                TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT,
                TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT,
                TFBlocks.CRACKED_ETCHED_NAGASTONE,
                TFBlocks.CRACKED_NAGASTONE_PILLAR,
                TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT,
                TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT,
                TFBlocks.IRON_LADDER,
                //TFBlocks.TERRORCOTTA_CIRCLE,
                //TFBlocks.TERRORCOTTA_DIAGONAL,
                TFBlocks.TWISTED_STONE,
                TFBlocks.TWISTED_STONE_PILLAR,
                //TFBlocks.LAPIS_BLOCK,
                TFBlocks.KEEPSAKE_CASKET,
                TFBlocks.BOLD_STONE_PILLAR
        );

        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                TFBlocks.SMOKER,
                TFBlocks.FIRE_JET,
                TFBlocks.UBEROUS_SOIL
        );
    }

    private static Block[] getAllMinecraftOrTwilightBlocks(Predicate<Block> predicate) {
        return Registry.BLOCK.stream()
                .filter(b -> Registry.BLOCK.getKey(b) != null && (Registry.BLOCK.getKey(b).getNamespace().equals(TwilightForestMod.ID) || Registry.BLOCK.getKey(b).getNamespace().equals("minecraft")) && predicate.test(b))
                .toArray(Block[]::new);
    }

    private static final Set<Block> plants;
    static {
        plants = ImmutableSet.<Block>builder().add(
                Blocks.DANDELION, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM, Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.CORNFLOWER, Blocks.LILY_OF_THE_VALLEY, Blocks.WITHER_ROSE, // BlockTags.SMALL_FLOWERS
                Blocks.SUNFLOWER, Blocks.LILAC, Blocks.PEONY, Blocks.ROSE_BUSH, // BlockTags.TALL_FLOWERS
                Blocks.FLOWERING_AZALEA_LEAVES, Blocks.FLOWERING_AZALEA, // BlockTags.FLOWERS
                Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES, // BlockTags.LEAVES
                Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.AZALEA, Blocks.FLOWERING_AZALEA, // BlockTags.SAPLINGS
                Blocks.BEETROOTS, Blocks.CARROTS, Blocks.POTATOES, Blocks.WHEAT, Blocks.MELON_STEM, Blocks.PUMPKIN_STEM // BlockTags.CROPS
        ).add( // TF addons of above taglists
                TFBlocks.TWILIGHT_OAK_SAPLING,
                TFBlocks.CANOPY_SAPLING,
                TFBlocks.MANGROVE_SAPLING,
                TFBlocks.DARKWOOD_SAPLING,
                TFBlocks.TIME_SAPLING,
                TFBlocks.TRANSFORMATION_SAPLING,
                TFBlocks.MINING_SAPLING,
                TFBlocks.SORTING_SAPLING,
                TFBlocks.HOLLOW_OAK_SAPLING,
                TFBlocks.RAINBOW_OAK_SAPLING,
                TFBlocks.RAINBOW_OAK_LEAVES,
                TFBlocks.TWILIGHT_OAK_LEAVES,
                TFBlocks.CANOPY_LEAVES,
                TFBlocks.MANGROVE_LEAVES,
                TFBlocks.DARK_LEAVES,
                TFBlocks.TIME_LEAVES,
                TFBlocks.TRANSFORMATION_LEAVES,
                TFBlocks.MINING_LEAVES,
                TFBlocks.SORTING_LEAVES,
                TFBlocks.THORN_LEAVES,
                TFBlocks.BEANSTALK_LEAVES
        ).build();
    }
}
