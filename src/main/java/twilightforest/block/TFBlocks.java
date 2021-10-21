package twilightforest.block;

import net.minecraft.core.Registry;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.core.Direction;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import twilightforest.TwilightForestMod;
import twilightforest.TwilightForestMod;
import twilightforest.compat.TFCompat;
import twilightforest.enums.*;
import twilightforest.item.TFItems;
import twilightforest.world.components.feature.trees.growers.*;

import javax.annotation.Nonnull;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

@SuppressWarnings({"WeakerAccess", "unused", "deprecation"})
@Nonnull
public class TFBlocks {
	//public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TwilightForestMod.ID);

	public static final TFPortalBlock TWILIGHT_PORTAL = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_portal", new TFPortalBlock(BlockBehaviour.Properties.of(Material.PORTAL).strength(-1.0F).sound(SoundType.GLASS).lightLevel((state) -> 11).noCollission().noOcclusion().noDrops()));

	//misc.
	public static final Block HEDGE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hedge", new HedgeBlock(BlockBehaviour.Properties.of(Material.CACTUS).strength(2.0F, 10.0F).sound(SoundType.GRASS)));
	public static final Block FIREFLY_JAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":firefly_jar", new JarBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F, 0.0F).sound(SoundType.WOOD).lightLevel((state) -> 15).noOcclusion()));
	public static final Block FIREFLY_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":firefly_particle_spawner", new FireflySpawnerBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(1.0F, 0.0F).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion()));
	public static final Block CICADA_JAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cicada_jar", new JarBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F, 0.0F).sound(SoundType.WOOD).noOcclusion().randomTicks()));
	public static final Block MOSS_PATCH = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":moss_patch", new TFPlantBlock(PlantVariant.MOSSPATCH, BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.MOSS).noCollission().noOcclusion()));
	public static final Block MAYAPPLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mayapple", new TFPlantBlock(PlantVariant.MAYAPPLE, BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().noOcclusion()));
	public static final Block CLOVER_PATCH = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":clover_patch", new TFPlantBlock(PlantVariant.CLOVERPATCH, BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().noOcclusion()));
	public static final Block FIDDLEHEAD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":fiddlehead", new TFPlantBlock(PlantVariant.FIDDLEHEAD, BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().noOcclusion()));
	public static final Block MUSHGLOOM = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mushgloom", new TFPlantBlock(PlantVariant.MUSHGLOOM, BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.FUNGUS).noCollission().noOcclusion().lightLevel((state) -> 3)));
	public static final Block TORCHBERRY_PLANT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":torchberry_plant", new TorchberryPlantBlock(PlantVariant.TORCHBERRY, BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.HANGING_ROOTS).noCollission().noOcclusion().lightLevel((state) -> (state.getValue(TorchberryPlantBlock.HAS_BERRIES) ? 8 : 0))));
	public static final Block ROOT_STRAND = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":root_strand", new TFPlantBlock(PlantVariant.ROOT_STRAND, BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.HANGING_ROOTS).noCollission().noOcclusion()));
	public static final Block FALLEN_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":fallen_leaves", new TFPlantBlock(PlantVariant.FALLEN_LEAVES, BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).strength(0.0F).sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
	public static final Block ROOT_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":root", new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block LIVEROOT_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":liveroot_block", new LiverootBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block UNCRAFTING_TABLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":uncrafting_table", new UncraftingTableBlock());
	public static final Block SMOKER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":smoker", new TFSmokerBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.GRASS).strength(1.5F, 0.0F).sound(SoundType.WOOD)));
	public static final Block ENCASED_SMOKER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":encased_smoker", new EncasedSmokerBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).requiresCorrectToolForDrops().strength(1.5F, 0.0F).sound(SoundType.WOOD)));
	public static final Block FIRE_JET = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":fire_jet", new FireJetBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.GRASS).strength(1.5F, 0.0F).sound(SoundType.WOOD).randomTicks().lightLevel((state) -> state.getValue(FireJetBlock.STATE) != FireJetVariant.FLAME ? 0 : 15)));
	public static final Block ENCASED_FIRE_JET = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":encased_fire_jet", new EncasedFireJetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).requiresCorrectToolForDrops().strength(1.5F, 0.0F).sound(SoundType.WOOD).lightLevel((state) -> 15)));
	public static final Block FIREFLY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":firefly", new FireflyBlock(BlockBehaviour.Properties.of(new Material.Builder(MaterialColor.GRASS).noCollider().nonSolid().build()).lightLevel((state) -> 15).sound(SoundType.SLIME_BLOCK).strength(0.0F).noCollission()));
	public static final Block CICADA = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cicada", new CicadaBlock(BlockBehaviour.Properties.of(new Material.Builder(MaterialColor.GRASS).noCollider().nonSolid().build()).sound(SoundType.SLIME_BLOCK).strength(0.0F).noCollission()));
	public static final Block MOONWORM = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":moonworm", new MoonwormBlock(BlockBehaviour.Properties.of(new Material.Builder(MaterialColor.GRASS).noCollider().nonSolid().build()).lightLevel((state) -> 14).sound(SoundType.SLIME_BLOCK).strength(0.0F).noCollission()));
	public static final HugeLilyPadBlock HUGE_LILY_PAD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":huge_lily_pad", new HugeLilyPadBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS)));
	public static final Block HUGE_WATER_LILY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":huge_water_lily", new HugeWaterLilyBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS)));
	public static final RotatedPillarBlock SLIDER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":slider", new SliderBlock());
	public static final Block IRON_LADDER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":iron_ladder", new IronLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).requiresCorrectToolForDrops().strength(5.0F, 10.0F).sound(SoundType.METAL).noOcclusion()));

	//naga courtyard
	public static final Block NAGASTONE_HEAD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":nagastone_head", new TFHorizontalBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block NAGASTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":nagastone", new NagastoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block SPIRAL_BRICKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":spiral_bricks", new SpiralBrickBlock());
	public static final Block ETCHED_NAGASTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":etched_nagastone", new EtchedNagastoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block NAGASTONE_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":nagastone_pillar", new NagastonePillarBlock());
	public static final StairBlock NAGASTONE_STAIRS_LEFT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":nagastone_stairs_left", new StairBlock(ETCHED_NAGASTONE.defaultBlockState(), BlockBehaviour.Properties.copy(ETCHED_NAGASTONE)));
	public static final StairBlock NAGASTONE_STAIRS_RIGHT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":nagastone_stairs_right", new StairBlock(ETCHED_NAGASTONE.defaultBlockState(), BlockBehaviour.Properties.copy(ETCHED_NAGASTONE)));
	public static final Block MOSSY_ETCHED_NAGASTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_etched_nagastone", new EtchedNagastoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block MOSSY_NAGASTONE_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_nagastone_pillar", new NagastonePillarBlock());
	public static final StairBlock MOSSY_NAGASTONE_STAIRS_LEFT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_nagastone_stairs_left", new StairBlock(MOSSY_ETCHED_NAGASTONE.defaultBlockState(), BlockBehaviour.Properties.copy(MOSSY_ETCHED_NAGASTONE)));
	public static final StairBlock MOSSY_NAGASTONE_STAIRS_RIGHT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_nagastone_stairs_right", new StairBlock(MOSSY_ETCHED_NAGASTONE.defaultBlockState(), BlockBehaviour.Properties.copy(MOSSY_ETCHED_NAGASTONE)));
	public static final Block CRACKED_ETCHED_NAGASTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_etched_nagastone", new EtchedNagastoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block CRACKED_NAGASTONE_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_nagastone_pillar", new NagastonePillarBlock());
	public static final StairBlock CRACKED_NAGASTONE_STAIRS_LEFT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_nagastone_stairs_left", new StairBlock(CRACKED_ETCHED_NAGASTONE.defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_ETCHED_NAGASTONE)));
	public static final StairBlock CRACKED_NAGASTONE_STAIRS_RIGHT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_nagastone_stairs_right", new StairBlock(CRACKED_ETCHED_NAGASTONE.defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_ETCHED_NAGASTONE)));

	//lich tower
	//public static final Block TERRORCOTTA_CIRCLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":terrorcotta_circle", new BlockTFHorizontal(Block.Properties.create(Material.ROCK, MaterialColor.SAND).setRequiresTool().hardnessAndResistance(1.7F).sound(SoundType.STONE)));
	//public static final Block TERRORCOTTA_DIAGONAL = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":terrorcotta_diagonal", new BlockTFDiagonal(Block.Properties.create(Material.ROCK, MaterialColor.SAND).setRequiresTool().hardnessAndResistance(1.7F).sound(SoundType.STONE)));
	public static final RotatedPillarBlock TWISTED_STONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twisted_stone", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
	public static final Block TWISTED_STONE_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twisted_stone_pillar", new WallPillarBlock(Material.STONE, 12, 16));
	//public static final Block LAPIS_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":lapis_block", new Block(Block.Properties.create(Material.IRON).setRequiresTool().hardnessAndResistance(3.0F, 5.0F).sound(SoundType.STONE)));
	public static final KeepsakeCasketBlock KEEPSAKE_CASKET = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":keepsake_casket", new KeepsakeCasketBlock());
	public static final RotatedPillarBlock BOLD_STONE_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":bold_stone_pillar", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
	public static final Block DEATH_TOME_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":death_tome_spawner", new TomeSpawnerBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block EMPTY_CANOPY_BOOKSHELF = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":empty_canopy_bookshelf", new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD)));
	public static final CandelabraBlock CANDELABRA = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":candelabra", new CandelabraBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.STONE).lightLevel(state -> state.getValue(CandelabraBlock.LIT) ? 15 : 0)));
	public static final AbstractSkullCandleBlock ZOMBIE_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":zombie_skull_candle", new SkullCandleBlock(SkullBlock.Types.ZOMBIE, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock ZOMBIE_WALL_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":zombie_wall_skull_candle", new WallSkullCandleBlock(SkullBlock.Types.ZOMBIE, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock SKELETON_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":skeleton_skull_candle", new SkullCandleBlock(SkullBlock.Types.SKELETON, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock SKELETON_WALL_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":skeleton_wall_skull_candle", new WallSkullCandleBlock(SkullBlock.Types.SKELETON, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock WITHER_SKELE_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":wither_skeleton_skull_candle", new SkullCandleBlock(SkullBlock.Types.WITHER_SKELETON, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock WITHER_SKELE_WALL_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":wither_skeleton_wall_skull_candle", new WallSkullCandleBlock(SkullBlock.Types.WITHER_SKELETON, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock CREEPER_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":creeper_skull_candle", new SkullCandleBlock(SkullBlock.Types.CREEPER, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock CREEPER_WALL_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":creeper_wall_skull_candle", new WallSkullCandleBlock(SkullBlock.Types.CREEPER, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock PLAYER_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":player_skull_candle", new SkullCandleBlock(SkullBlock.Types.PLAYER, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));
	public static final AbstractSkullCandleBlock PLAYER_WALL_SKULL_CANDLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":player_wall_skull_candle", new WallSkullCandleBlock(SkullBlock.Types.PLAYER, BlockBehaviour.Properties.copy(Blocks.ZOMBIE_HEAD).lightLevel(AbstractSkullCandleBlock.LIGHT_EMISSION)));

	//labyrinth
	public static final Block MAZESTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mazestone", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));
	public static final Block MAZESTONE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mazestone_brick", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));
	public static final Block CUT_MAZESTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cut_mazestone", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));
	public static final Block DECORATIVE_MAZESTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":decorative_mazestone", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));
	public static final Block CRACKED_MAZESTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_mazestone", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));
	public static final Block MOSSY_MAZESTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_mazestone", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));
	public static final Block MAZESTONE_MOSAIC = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mazestone_mosaic", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));
	public static final Block MAZESTONE_BORDER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mazestone_border", new MazestoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 5.0F).sound(SoundType.STONE)));

	//stronghold
	public static final Block STRONGHOLD_SHIELD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stronghold_shield", new StrongholdShieldBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(-1.0F, 6000000.0F).sound(SoundType.METAL).noDrops()));
	public static final Block TROPHY_PEDESTAL = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":trophy_pedestal", new TrophyPedestalBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.0F, 2000.0F).sound(SoundType.STONE)));
	public static final Block UNDERBRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":underbrick", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block MOSSY_UNDERBRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_underbrick", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block CRACKED_UNDERBRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_underbrick", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));
	public static final Block UNDERBRICK_FLOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":underbrick_floor", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).requiresCorrectToolForDrops().strength(1.5F, 10.0F).sound(SoundType.STONE)));

	//dark tower
	public static final Block TOWERWOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":towerwood", new FlammableBlock(1, 0, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(40.0F, 10.0F).sound(SoundType.WOOD)));
	public static final Block ENCASED_TOWERWOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":encased_towerwood", new FlammableBlock(1, 0, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(40.0F, 10.0F).sound(SoundType.WOOD)));
	public static final Block CRACKED_TOWERWOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_towerwood", new FlammableBlock(1, 0, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(40.0F, 10.0F).sound(SoundType.WOOD)));
	public static final Block MOSSY_TOWERWOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_towerwood", new FlammableBlock(1, 0, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(40.0F, 10.0F).sound(SoundType.WOOD)));
	public static final Block INFESTED_TOWERWOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":infested_towerwood", new InfestedTowerwoodBlock(1, 0, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(0.75F, 10.0F).sound(SoundType.WOOD)));
	public static final Block REAPPEARING_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":reappearing_block", new ReappearingBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).requiresCorrectToolForDrops().strength(10.0F, 35.0F).sound(SoundType.WOOD).lightLevel((state) -> 4)));
	// FIXME Split Vanishing block into regular breakable variant, and then the unbreakable variant
	public static final Block VANISHING_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":vanishing_block", new VanishingBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(-1.0F, 35.0F).sound(SoundType.WOOD).lightLevel((state) -> state.getValue(VanishingBlock.ACTIVE) ? 4 : 0)));
	public static final Block LOCKED_VANISHING_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":locked_vanishing_block", new LockedVanishingBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(-1.0F, 35.0F).sound(SoundType.WOOD)));
	public static final Block CARMINITE_BUILDER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":carminite_builder", new BuilderBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).requiresCorrectToolForDrops().strength(10.0F, 35.0F).sound(SoundType.WOOD).lightLevel((state) -> state.getValue(BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_ACTIVE ? 4 : 0)));
	public static final Block BUILT_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":built_block", new TranslucentBuiltBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(50.0F, 2000.0F).sound(SoundType.METAL).noOcclusion().noDrops()));
	public static final Block ANTIBUILDER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":antibuilder", new AntibuilderBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).requiresCorrectToolForDrops().strength(10.0F, 35.0F).sound(SoundType.WOOD).lightLevel((state) -> 10)));
	public static final Block ANTIBUILT_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":antibuilt_block", new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F, 2000.0F).sound(SoundType.METAL).noDrops().noOcclusion()));
	public static final GhastTrapBlock GHAST_TRAP = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":ghast_trap", new GhastTrapBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).requiresCorrectToolForDrops().strength(10.0F, 35.0F).sound(SoundType.WOOD).lightLevel((state) -> state.getValue(GhastTrapBlock.ACTIVE) ? 15 : 0)));
	public static final Block CARMINITE_REACTOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":carminite_reactor", new CarminiteReactorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).requiresCorrectToolForDrops().strength(10.0F, 35.0F).sound(SoundType.WOOD).lightLevel((state) -> state.getValue(CarminiteReactorBlock.ACTIVE) ? 15 : 0)));
	public static final Block REACTOR_DEBRIS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":reactor_debris", new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F, 2000.0F).sound(SoundType.METAL).noDrops().noOcclusion()));
	public static final Block FAKE_GOLD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":fake_gold", new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(50.0F, 2000.0F).sound(SoundType.METAL).noDrops()));
	public static final Block FAKE_DIAMOND = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":fake_diamond", new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(50.0F, 2000.0F).sound(SoundType.METAL).noDrops()));
	public static final Block EXPERIMENT_115 = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":experiment_115", new Experiment115Block());

	//aurora palace
	public static final Block AURORA_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":aurora_block", new AuroraBrickBlock(BlockBehaviour.Properties.of(Material.ICE_SOLID).strength(10.0F, 10.0F)));
	public static final RotatedPillarBlock AURORA_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":aurora_pillar", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.ICE_SOLID).requiresCorrectToolForDrops().strength(2.0F, 10.0F)));
	public static final Block AURORA_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":aurora_slab", new SlabBlock(BlockBehaviour.Properties.of(Material.ICE_SOLID).requiresCorrectToolForDrops().strength(2.0F, 10.0F)));
	public static final Block AURORALIZED_GLASS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":auroralized_glass", new AuroralizedGlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

	//highlands/thornlands
	public static final Block BROWN_THORNS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":brown_thorns", new ThornsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(50.0F, 2000.0F).sound(SoundType.WOOD).noDrops()));
	public static final Block GREEN_THORNS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":green_thorns", new ThornsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(50.0F, 2000.0F).sound(SoundType.WOOD).noDrops()));
	public static final Block BURNT_THORNS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":burnt_thorns", new BurntThornsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.STONE).strength(0.01F, 0.0F).sound(SoundType.SAND).noDrops()));
	public static final Block THORN_ROSE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":thorn_rose", new ThornRoseBlock(BlockBehaviour.Properties.of(Material.PLANT).strength(10.0F, 0.0F).sound(SoundType.GRASS).noCollission()));
	public static final Block THORN_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":thorn_leaves", new TFLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES)));
	public static final Block BEANSTALK_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":beanstalk_leaves", new TFLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES)));
	public static final Block DEADROCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":deadrock", new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 6000000.0F).sound(SoundType.STONE)));
	public static final Block CRACKED_DEADROCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_deadrock", new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 6000000.0F).sound(SoundType.STONE)));
	public static final Block WEATHERED_DEADROCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":weathered_deadrock", new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(100.0F, 6000000.0F).sound(SoundType.STONE)));
	public static final Block TROLLSTEINN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":trollsteinn", new TrollsteinnBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.0F, 15.0F).sound(SoundType.STONE)));
	public static final Block WISPY_CLOUD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":wispy_cloud", new HalfTransparentBlock(BlockBehaviour.Properties.of(Material.TOP_SNOW).strength(0.3F).sound(SoundType.WOOL).noOcclusion()));
	public static final Block FLUFFY_CLOUD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":fluffy_cloud", new Block(BlockBehaviour.Properties.of(Material.ICE_SOLID).strength(0.8F, 0.0F).sound(SoundType.WOOL)));
	public static final Block GIANT_COBBLESTONE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":giant_cobblestone", new GiantBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).requiresCorrectToolForDrops().strength(128, 10)));
	public static final Block GIANT_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":giant_log", new GiantLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops().strength(128, 0)));
	public static final Block GIANT_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":giant_leaves", new GiantLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops().strength(0.2F * 64F, 0.0F).sound(SoundType.AZALEA_LEAVES).noOcclusion()));
	public static final Block GIANT_OBSIDIAN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":giant_obsidian", new GiantBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).requiresCorrectToolForDrops().strength(50.0F * 64F * 64F, 2000.0F * 64F * 64F)));
	public static final Block UBEROUS_SOIL = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":uberous_soil", new UberousSoilBlock(BlockBehaviour.Properties.of(Material.DIRT).strength(0.6F).sound(SoundType.GRAVEL)));
	public static final RotatedPillarBlock HUGE_STALK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":huge_stalk", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.25F, 7.0F).sound(SoundType.STEM)));
	public static final Block HUGE_MUSHGLOOM = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":huge_mushgloom", new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(0.2F).sound(SoundType.WOOD).lightLevel((state) -> 5)));
	public static final Block HUGE_MUSHGLOOM_STEM = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":huge_mushgloom_stem", new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(0.2F).sound(SoundType.WOOD).lightLevel((state) -> 5)));
	public static final Block TROLLVIDR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":trollvidr", new TrollRootBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission()));
	public static final Block UNRIPE_TROLLBER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":unripe_trollber", new UnripeTorchClusterBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final Block TROLLBER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":trollber", new TrollRootBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().lightLevel((state) -> 15)));

	//plateau castle
	public static final Block CASTLE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":castle_brick", new CastleBlock(MaterialColor.QUARTZ));
	public static final Block WORN_CASTLE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":worn_castle_brick", new CastleBlock(MaterialColor.QUARTZ));
	public static final Block CRACKED_CASTLE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_castle_brick", new CastleBlock(MaterialColor.QUARTZ));
	public static final Block CASTLE_ROOF_TILE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":castle_roof_tile", new CastleBlock(MaterialColor.COLOR_GRAY));
	public static final Block MOSSY_CASTLE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_castle_brick", new CastleBlock(MaterialColor.QUARTZ));
	public static final Block THICK_CASTLE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":thick_castle_brick", new CastleBlock(MaterialColor.QUARTZ));
	public static final Block ENCASED_CASTLE_BRICK_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":encased_castle_brick_pillar", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 35.0F).sound(SoundType.STONE)));
	public static final Block ENCASED_CASTLE_BRICK_TILE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":encased_castle_brick_tile", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 35.0F).sound(SoundType.STONE)));
	public static final Block BOLD_CASTLE_BRICK_PILLAR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":bold_castle_brick_pillar", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 35.0F).sound(SoundType.STONE)));
	public static final Block BOLD_CASTLE_BRICK_TILE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":bold_castle_brick_tile", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 35.0F).sound(SoundType.STONE)));
	public static final StairBlock CASTLE_BRICK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":castle_brick_stairs", new StairBlock(CASTLE_BRICK.defaultBlockState(), BlockBehaviour.Properties.copy(CASTLE_BRICK)));
	public static final StairBlock WORN_CASTLE_BRICK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":worn_castle_brick_stairs", new StairBlock(WORN_CASTLE_BRICK.defaultBlockState(), BlockBehaviour.Properties.copy(WORN_CASTLE_BRICK)));
	public static final StairBlock CRACKED_CASTLE_BRICK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cracked_castle_brick_stairs", new StairBlock(CRACKED_CASTLE_BRICK.defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_CASTLE_BRICK)));
	public static final StairBlock MOSSY_CASTLE_BRICK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mossy_castle_brick_stairs", new StairBlock(MOSSY_CASTLE_BRICK.defaultBlockState(), BlockBehaviour.Properties.copy(MOSSY_CASTLE_BRICK)));
	public static final StairBlock ENCASED_CASTLE_BRICK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":encased_castle_brick_stairs", new StairBlock(ENCASED_CASTLE_BRICK_PILLAR.defaultBlockState(), BlockBehaviour.Properties.copy(ENCASED_CASTLE_BRICK_PILLAR)));
	public static final StairBlock BOLD_CASTLE_BRICK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":bold_castle_brick_stairs", new StairBlock(BOLD_CASTLE_BRICK_PILLAR.defaultBlockState(), BlockBehaviour.Properties.copy(BOLD_CASTLE_BRICK_PILLAR)));
	public static final Block PINK_CASTLE_RUNE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":pink_castle_rune_brick", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 15.0F).sound(SoundType.STONE)));
	public static final Block BLUE_CASTLE_RUNE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":blue_castle_rune_brick", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 15.0F).sound(SoundType.STONE)));
	public static final Block YELLOW_CASTLE_RUNE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":yellow_castle_rune_brick", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 15.0F).sound(SoundType.STONE)));
	public static final Block VIOLET_CASTLE_RUNE_BRICK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":violet_castle_rune_brick", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(100.0F, 15.0F).sound(SoundType.STONE)));
	public static final Block VIOLET_FORCE_FIELD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":violet_force_field", new ForceFieldBlock(BlockBehaviour.Properties.of(Material.BARRIER).strength(-1.0F).lightLevel((state) -> 2).noDrops().noOcclusion()));
	public static final Block PINK_FORCE_FIELD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":pink_force_field", new ForceFieldBlock(BlockBehaviour.Properties.of(Material.BARRIER).strength(-1.0F).lightLevel((state) -> 2).noDrops().noOcclusion()));
	public static final Block ORANGE_FORCE_FIELD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":orange_force_field", new ForceFieldBlock(BlockBehaviour.Properties.of(Material.BARRIER).strength(-1.0F).lightLevel((state) -> 2).noDrops().noOcclusion()));
	public static final Block GREEN_FORCE_FIELD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":green_force_field", new ForceFieldBlock(BlockBehaviour.Properties.of(Material.BARRIER).strength(-1.0F).lightLevel((state) -> 2).noDrops().noOcclusion()));
	public static final Block BLUE_FORCE_FIELD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":blue_force_field", new ForceFieldBlock(BlockBehaviour.Properties.of(Material.BARRIER).strength(-1.0F).lightLevel((state) -> 2).noDrops().noOcclusion()));
	public static final Block CINDER_FURNACE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cinder_furnace", new CinderFurnaceBlock());
	public static final RotatedPillarBlock CINDER_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cinder_log", new TFLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(1.0F)));
	public static final Block CINDER_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":cinder_wood", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(1.0F)));
	public static final Block YELLOW_CASTLE_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":yellow_castle_door", new CastleDoorBlock(BlockBehaviour.Properties.of(Material.STONE, (state) -> state.getValue(CastleDoorBlock.VANISHED) ? MaterialColor.NONE : MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(100.0F, 35.0F)));
	public static final Block VIOLET_CASTLE_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":violet_castle_door", new CastleDoorBlock(BlockBehaviour.Properties.of(Material.STONE, (state) -> state.getValue(CastleDoorBlock.VANISHED) ? MaterialColor.NONE : MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(100.0F, 35.0F)));
	public static final Block PINK_CASTLE_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":pink_castle_door", new CastleDoorBlock(BlockBehaviour.Properties.of(Material.STONE, (state) -> state.getValue(CastleDoorBlock.VANISHED) ? MaterialColor.NONE : MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(100.0F, 35.0F)));
	public static final Block BLUE_CASTLE_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":blue_castle_door", new CastleDoorBlock(BlockBehaviour.Properties.of(Material.STONE, (state) -> state.getValue(CastleDoorBlock.VANISHED) ? MaterialColor.NONE : MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(100.0F, 35.0F)));

	//mini structures
	public static final Block TWILIGHT_PORTAL_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_portal_miniature_structure", new MiniatureStructureBlock());
//	public static final Block HEDGE_MAZE_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hedge_maze_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block HOLLOW_HILL_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hollow_hill_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block QUEST_GROVE_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":quest_grove_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block MUSHROOM_TOWER_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mushroom_tower_miniature_structure", new BlockTFMiniatureStructure());
	public static final Block NAGA_COURTYARD_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":naga_courtyard_miniature_structure", new MiniatureStructureBlock());
	public static final Block LICH_TOWER_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":lich_tower_miniature_structure", new MiniatureStructureBlock());
//	public static final Block MINOTAUR_LABYRINTH_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":minotaur_labyrinth_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block HYDRA_LAIR_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hydra_lair_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block GOBLIN_STRONGHOLD_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":goblin_stronghold_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block DARK_TOWER_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_tower_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block YETI_CAVE_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":yeti_cave_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block AURORA_PALACE_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":aurora_palace_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block TROLL_CAVE_COTTAGE_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":troll_cave_cottage_miniature_structure", new BlockTFMiniatureStructure());
//	public static final Block FINAL_CASTLE_MINIATURE_STRUCTURE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":final_castle_miniature_structure", new BlockTFMiniatureStructure());
	public static final Block KNIGHTMETAL_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":knightmetal_block", new KnightmetalBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F, 41.0F).sound(SoundType.NETHERITE_BLOCK)));
	public static final Block IRONWOOD_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":ironwood_block", new CompressedBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(5.0F, 10.0F).sound(SoundType.WOOD)));
	public static final Block FIERY_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":fiery_block", new CompressedBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_BLACK).requiresCorrectToolForDrops().strength(5.0F, 10.0F).sound(SoundType.METAL).noOcclusion().emissiveRendering((state, world, pos) -> true)));
	public static final Block STEELEAF_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":steeleaf_block", new CompressedBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.PLANT).strength(5.0F, 10.0F).sound(SoundType.MOSS)));
	public static final Block ARCTIC_FUR_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":arctic_fur_block", new CompressedBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.8F, 10.0F).sound(SoundType.WOOL)));
	public static final Block CARMINITE_BLOCK = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":carminite_block", new CompressedBlock(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.COLOR_RED).strength(0.0F, 10.0F).sound(SoundType.SLIME_BLOCK)));

	//boss trophies and spawners
	public static final Block NAGA_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":naga_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.NAGA));
	public static final Block LICH_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":lich_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.LICH));
	public static final Block HYDRA_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hydra_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.HYDRA));
	public static final Block UR_GHAST_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":ur_ghast_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.UR_GHAST));
	public static final Block KNIGHT_PHANTOM_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":knight_phantom_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.KNIGHT_PHANTOM));
	public static final Block SNOW_QUEEN_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":snow_queen_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.SNOW_QUEEN));
	public static final Block MINOSHROOM_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":minoshroom_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.MINOSHROOM));
	public static final Block ALPHA_YETI_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":alpha_yeti_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.ALPHA_YETI));
	public static final Block FINAL_BOSS_BOSS_SPAWNER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":final_boss_boss_spawner", new BossSpawnerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F).noOcclusion().noDrops(), BossVariant.FINAL_BOSS));
	public static final TrophyBlock NAGA_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":naga_trophy", new TrophyBlock(BossVariant.NAGA, 5));
	public static final TrophyBlock LICH_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":lich_trophy", new TrophyBlock(BossVariant.LICH, 6));
	public static final TrophyBlock HYDRA_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hydra_trophy", new TrophyBlock(BossVariant.HYDRA, 12));
	public static final TrophyBlock UR_GHAST_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":ur_ghast_trophy", new TrophyBlock(BossVariant.UR_GHAST, 13));
	public static final TrophyBlock KNIGHT_PHANTOM_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":knight_phantom_trophy", new TrophyBlock(BossVariant.KNIGHT_PHANTOM, 8));
	public static final TrophyBlock SNOW_QUEEN_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":snow_queen_trophy", new TrophyBlock(BossVariant.SNOW_QUEEN, 14));
	public static final TrophyBlock MINOSHROOM_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":minoshroom_trophy", new TrophyBlock(BossVariant.MINOSHROOM, 7));
	public static final TrophyBlock ALPHA_YETI_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":alpha_yeti_trophy", new TrophyBlock(BossVariant.ALPHA_YETI, 9));
	public static final TrophyBlock QUEST_RAM_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":quest_ram_trophy", new TrophyBlock(BossVariant.QUEST_RAM, 1));
	public static final TrophyWallBlock NAGA_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":naga_wall_trophy", new TrophyWallBlock(BossVariant.NAGA));
	public static final TrophyWallBlock LICH_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":lich_wall_trophy", new TrophyWallBlock(BossVariant.LICH));
	public static final TrophyWallBlock HYDRA_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hydra_wall_trophy", new TrophyWallBlock(BossVariant.HYDRA));
	public static final TrophyWallBlock UR_GHAST_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":ur_ghast_wall_trophy", new TrophyWallBlock(BossVariant.UR_GHAST));
	public static final TrophyWallBlock KNIGHT_PHANTOM_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":knight_phantom_wall_trophy", new TrophyWallBlock(BossVariant.KNIGHT_PHANTOM));
	public static final TrophyWallBlock SNOW_QUEEN_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":snow_queen_wall_trophy", new TrophyWallBlock(BossVariant.SNOW_QUEEN));
	public static final TrophyWallBlock MINOSHROOM_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":minoshroom_wall_trophy", new TrophyWallBlock(BossVariant.MINOSHROOM));
	public static final TrophyWallBlock ALPHA_YETI_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":alpha_yeti_wall_trophy", new TrophyWallBlock(BossVariant.ALPHA_YETI));
	public static final TrophyWallBlock QUEST_RAM_WALL_TROPHY = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":quest_ram_wall_trophy", new TrophyWallBlock(BossVariant.QUEST_RAM));

	//all tree related stuff
	public static final BanisterBlock OAK_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":oak_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final BanisterBlock SPRUCE_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":spruce_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
	public static final BanisterBlock BIRCH_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":birch_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
	public static final BanisterBlock JUNGLE_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":jungle_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
	public static final BanisterBlock ACACIA_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":acacia_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final BanisterBlock DARK_OAK_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_oak_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
	public static final BanisterBlock CRIMSON_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":crimson_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
	public static final BanisterBlock WARPED_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":warped_banister", new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

	public static final WoodType TWILIGHT_OAK = WoodType.register(new WoodType("twilight_oak"));
	public static final WoodType CANOPY = WoodType.register(new WoodType("canopy"));
	public static final WoodType MANGROVE = WoodType.register(new WoodType("mangrove"));
	public static final WoodType DARKWOOD = WoodType.register(new WoodType("darkwood"));
	public static final WoodType TIMEWOOD = WoodType.register(new WoodType("timewood"));
	public static final WoodType TRANSFORMATION = WoodType.register(new WoodType("transformation"));
	public static final WoodType MINING = WoodType.register(new WoodType("mining"));
	public static final WoodType SORTING = WoodType.register(new WoodType("sorting"));

	public static final RotatedPillarBlock TWILIGHT_OAK_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_log", new TFLogBlock(logProperties(MaterialColor.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock CANOPY_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_log", new TFLogBlock(logProperties(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock MANGROVE_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_log", new TFLogBlock(logProperties(MaterialColor.DIRT, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock DARK_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_log", new TFLogBlock(logProperties(MaterialColor.COLOR_BROWN, MaterialColor.STONE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock TIME_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_log", new TFLogBlock(logProperties(MaterialColor.DIRT, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock TRANSFORMATION_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_log", new TFLogBlock(logProperties(MaterialColor.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock MINING_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_log", new TFLogBlock(logProperties(MaterialColor.SAND, MaterialColor.QUARTZ).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock SORTING_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_log", new TFLogBlock(logProperties(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));

	public static final Block TIME_LOG_CORE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_log_core", new SpecialMagicLogBlock(logProperties(MaterialColor.DIRT, MaterialColor.PODZOL), MagicWoodVariant.TIME));
	public static final Block TRANSFORMATION_LOG_CORE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_log_core", new SpecialMagicLogBlock(logProperties(MaterialColor.WOOD, MaterialColor.PODZOL), MagicWoodVariant.TRANS));
	public static final Block MINING_LOG_CORE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_log_core", new SpecialMagicLogBlock(logProperties(MaterialColor.SAND, MaterialColor.QUARTZ), MagicWoodVariant.MINE));
	public static final Block SORTING_LOG_CORE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_log_core", new SpecialMagicLogBlock(logProperties(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN), MagicWoodVariant.SORT));

	public static final RotatedPillarBlock STRIPPED_TWILIGHT_OAK_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_twilight_oak_log", new TFLogBlock(logProperties(MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_CANOPY_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_canopy_log", new TFLogBlock(logProperties(MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_MANGROVE_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_mangrove_log", new TFLogBlock(logProperties(MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_DARK_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_dark_log", new TFLogBlock(logProperties(MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_TIME_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_time_log", new TFLogBlock(logProperties(MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_TRANSFORMATION_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_transformation_log", new TFLogBlock(logProperties(MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_MINING_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_mining_log", new TFLogBlock(logProperties(MaterialColor.SAND).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_SORTING_LOG = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_sorting_log", new TFLogBlock(logProperties(MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));

	public static final RotatedPillarBlock TWILIGHT_OAK_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_wood", new TFLogBlock(logProperties(MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock CANOPY_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_wood", new TFLogBlock(logProperties(MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock MANGROVE_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_wood", new TFLogBlock(logProperties(MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock DARK_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_wood", new TFLogBlock(logProperties(MaterialColor.STONE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock TIME_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_wood", new TFLogBlock(logProperties(MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock TRANSFORMATION_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_wood", new TFLogBlock(logProperties(MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock MINING_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_wood", new TFLogBlock(logProperties(MaterialColor.SAND).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock SORTING_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_wood", new TFLogBlock(logProperties(MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));

	public static final Block MANGROVE_ROOT = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_root", new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));

	public static final RotatedPillarBlock STRIPPED_TWILIGHT_OAK_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_twilight_oak_wood", new TFLogBlock(logProperties(MaterialColor.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_CANOPY_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_canopy_wood", new TFLogBlock(logProperties(MaterialColor.PODZOL, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_MANGROVE_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_mangrove_wood", new TFLogBlock(logProperties(MaterialColor.DIRT, MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_DARK_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_dark_wood", new TFLogBlock(logProperties(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_TIME_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_time_wood", new TFLogBlock(logProperties(MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_TRANSFORMATION_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_transformation_wood", new TFLogBlock(logProperties(MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_MINING_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_mining_wood", new TFLogBlock(logProperties(MaterialColor.SAND).strength(2.0F).sound(SoundType.WOOD)));
	public static final RotatedPillarBlock STRIPPED_SORTING_WOOD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":stripped_sorting_wood", new TFLogBlock(logProperties(MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));

	public static final Block TWILIGHT_OAK_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_leaves", new TFLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES)));
	public static final Block CANOPY_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_leaves", new TFLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES)));
	public static final Block MANGROVE_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_leaves", new MangroveLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES)));
	public static final Block DARK_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_leaves", new DarkLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(2.0F, 10.0F).sound(SoundType.AZALEA_LEAVES)));
	public static final Block HARDENED_DARK_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hardened_dark_leaves", new HardenedDarkLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(2.0F, 10.0F).sound(SoundType.AZALEA_LEAVES)));
	public static final Block RAINBOW_OAK_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":rainbow_oak_leaves", new TFLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES)));
	public static final Block TIME_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_leaves", new MagicLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).sound(SoundType.AZALEA_LEAVES).randomTicks().noOcclusion()));
	public static final Block TRANSFORMATION_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_leaves", new MagicLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).sound(SoundType.AZALEA_LEAVES).randomTicks().noOcclusion()));
	public static final Block MINING_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_leaves", new MagicLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).sound(SoundType.AZALEA_LEAVES).randomTicks().noOcclusion()));
	public static final Block SORTING_LEAVES = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_leaves", new MagicLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).sound(SoundType.AZALEA_LEAVES).randomTicks().noOcclusion()));

	public static final SaplingBlock TWILIGHT_OAK_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_sapling", new SaplingBlock(new SmallOakTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock CANOPY_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_sapling", new SaplingBlock(new CanopyTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock MANGROVE_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_sapling", new MangroveSaplingBlock(new MangroveTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock DARKWOOD_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":darkwood_sapling", new SaplingBlock(new DarkCanopyTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock HOLLOW_OAK_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":hollow_oak_sapling", new SaplingBlock(new HollowTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock TIME_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_sapling", new SaplingBlock(new TimeTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock TRANSFORMATION_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_sapling", new SaplingBlock(new TransformationTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock MINING_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_sapling", new SaplingBlock(new MinersTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock SORTING_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_sapling", new SaplingBlock(new SortingTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	public static final SaplingBlock RAINBOW_OAK_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":rainbow_oak_sapling", new SaplingBlock(new RainboakTree(), BlockBehaviour.Properties.of(Material.PLANT).strength(0.0F).sound(SoundType.GRASS).noCollission().randomTicks()));
	// TODO chests? boats?
	public static final Block TWILIGHT_OAK_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock TWILIGHT_OAK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_stairs", new StairBlock(TWILIGHT_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS)));
	public static final Block TWILIGHT_OAK_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_slab", new SlabBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS)));
	public static final Block TWILIGHT_OAK_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block TWILIGHT_OAK_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_fence", new FenceBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS)));
	public static final Block TWILIGHT_OAK_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS)));
	public static final Block TWILIGHT_OAK_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock TWILIGHT_OAK_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_door", new DoorBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock TWILIGHT_OAK_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock TWILIGHT_OAK_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_sign", new TFSignBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), TWILIGHT_OAK));
	public static final WallSignBlock TWILIGHT_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), TWILIGHT_OAK));
	public static final BanisterBlock TWILIGHT_OAK_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_banister", new BanisterBlock(BlockBehaviour.Properties.copy(TWILIGHT_OAK_PLANKS)));
	public static final Block CANOPY_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock CANOPY_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_stairs", new StairBlock(CANOPY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(CANOPY_PLANKS)));
	public static final Block CANOPY_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_slab", new SlabBlock(BlockBehaviour.Properties.copy(CANOPY_PLANKS)));
	public static final Block CANOPY_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(CANOPY_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block CANOPY_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_fence", new FenceBlock(BlockBehaviour.Properties.copy(CANOPY_PLANKS)));
	public static final Block CANOPY_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(CANOPY_PLANKS)));
	public static final Block CANOPY_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(CANOPY_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock CANOPY_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_door", new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock CANOPY_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock CANOPY_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_sign", new TFSignBlock(BlockBehaviour.Properties.copy(CANOPY_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), CANOPY));
	public static final WallSignBlock CANOPY_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(CANOPY_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), CANOPY));
	public static final Block CANOPY_BOOKSHELF = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_bookshelf", new BookshelfBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(1.5F).sound(SoundType.WOOD)));
	public static final BanisterBlock CANOPY_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_banister", new BanisterBlock(BlockBehaviour.Properties.copy(CANOPY_PLANKS)));
	public static final Block MANGROVE_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock MANGROVE_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_stairs", new StairBlock(MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(MANGROVE_PLANKS)));
	public static final Block MANGROVE_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_slab", new SlabBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final Block MANGROVE_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block MANGROVE_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_fence", new FenceBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS)));
	public static final Block MANGROVE_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS)));
	public static final Block MANGROVE_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(MANGROVE_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock MANGROVE_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_door", new DoorBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock MANGROVE_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock MANGROVE_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_sign", new TFSignBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), MANGROVE));
	public static final WallSignBlock MANGROVE_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), MANGROVE));
	public static final BanisterBlock MANGROVE_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_banister", new BanisterBlock(BlockBehaviour.Properties.copy(MANGROVE_PLANKS)));
	public static final Block DARK_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock DARK_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_stairs", new StairBlock(DARK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(DARK_PLANKS)));
	public static final Block DARK_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_slab", new SlabBlock(BlockBehaviour.Properties.copy(DARK_PLANKS).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final Block DARK_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(DARK_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block DARK_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_fence", new FenceBlock(BlockBehaviour.Properties.copy(DARK_PLANKS)));
	public static final Block DARK_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(DARK_PLANKS)));
	public static final Block DARK_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(DARK_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock DARK_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_door", new DoorBlock(BlockBehaviour.Properties.copy(DARK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock DARK_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":dark_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(DARK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock DARKWOOD_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":darkwood_sign", new TFSignBlock(BlockBehaviour.Properties.copy(DARK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), DARKWOOD));
	public static final WallSignBlock DARKWOOD_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":darkwood_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(DARK_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), DARKWOOD));
	public static final BanisterBlock DARKWOOD_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":darkwood_banister", new BanisterBlock(BlockBehaviour.Properties.copy(DARK_PLANKS)));
	public static final Block TIME_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock TIME_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_stairs", new StairBlock(TIME_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(TIME_PLANKS)));
	public static final Block TIME_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_slab", new SlabBlock(BlockBehaviour.Properties.copy(TIME_PLANKS).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final Block TIME_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(TIME_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block TIME_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_fence", new FenceBlock(BlockBehaviour.Properties.copy(TIME_PLANKS)));
	public static final Block TIME_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(TIME_PLANKS)));
	public static final Block TIME_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(TIME_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock TIME_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_door", new DoorBlock(BlockBehaviour.Properties.copy(TIME_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock TIME_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(TIME_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock TIME_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_sign", new TFSignBlock(BlockBehaviour.Properties.copy(TIME_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), TIMEWOOD));
	public static final WallSignBlock TIME_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(TIME_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), TIMEWOOD));
	public static final BanisterBlock TIME_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_banister", new BanisterBlock(BlockBehaviour.Properties.copy(TIME_PLANKS)));
	public static final Block TRANSFORMATION_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock TRANSFORMATION_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_stairs", new StairBlock(TRANSFORMATION_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS)));
	public static final Block TRANSFORMATION_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_slab", new SlabBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final Block TRANSFORMATION_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block TRANSFORMATION_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_fence", new FenceBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS)));
	public static final Block TRANSFORMATION_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS)));
	public static final Block TRANSFORMATION_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock TRANSFORMATION_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_door", new DoorBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock TRANSFORMATION_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock TRANSFORMATION_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_sign", new TFSignBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), TRANSFORMATION));
	public static final WallSignBlock TRANSFORMATION_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), TRANSFORMATION));
	public static final BanisterBlock TRANSFORMATION_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_banister", new BanisterBlock(BlockBehaviour.Properties.copy(TRANSFORMATION_PLANKS)));
	public static final Block MINING_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock MINING_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_stairs", new StairBlock(MINING_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(MINING_PLANKS)));
	public static final Block MINING_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_slab", new SlabBlock(BlockBehaviour.Properties.copy(MINING_PLANKS).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final Block MINING_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(MINING_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block MINING_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_fence", new FenceBlock(BlockBehaviour.Properties.copy(MINING_PLANKS)));
	public static final Block MINING_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(MINING_PLANKS)));
	public static final Block MINING_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(MINING_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock MINING_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_door", new DoorBlock(BlockBehaviour.Properties.copy(MINING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock MINING_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(MINING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock MINING_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_sign", new TFSignBlock(BlockBehaviour.Properties.copy(MINING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), MINING));
	public static final WallSignBlock MINING_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(MINING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), MINING));
	public static final BanisterBlock MINING_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_banister", new BanisterBlock(BlockBehaviour.Properties.copy(MINING_PLANKS)));
	public static final Block SORTING_PLANKS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final StairBlock SORTING_STAIRS = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_stairs", new StairBlock(SORTING_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(SORTING_PLANKS)));
	public static final Block SORTING_SLAB = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_slab", new SlabBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS).strength(2.0F, 5.0F).sound(SoundType.WOOD)));
	public static final Block SORTING_BUTTON = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final Block SORTING_FENCE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_fence", new FenceBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS)));
	public static final Block SORTING_GATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS)));
	public static final Block SORTING_PLATE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(SORTING_PLANKS).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final DoorBlock SORTING_DOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_door", new DoorBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final TrapDoorBlock SORTING_TRAPDOOR = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final StandingSignBlock SORTING_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_sign", new TFSignBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), SORTING));
	public static final WallSignBlock SORTING_WALL_SIGN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_wall_sign", new TFWallSignBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS).strength(3.0F).sound(SoundType.WOOD).noOcclusion().noCollission(), SORTING));
	public static final BanisterBlock SORTING_BANISTER = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_banister", new BanisterBlock(BlockBehaviour.Properties.copy(SORTING_PLANKS)));

	public static final TwilightChest TWILIGHT_OAK_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":twilight_oak_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final TwilightChest CANOPY_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":canopy_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final TwilightChest MANGROVE_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mangrove_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final TwilightChest DARKWOOD_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":darkwood_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final TwilightChest TIME_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":time_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final TwilightChest TRANSFORMATION_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":transformation_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final TwilightChest MINING_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":mining_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final TwilightChest SORTING_CHEST = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":sorting_chest", new TwilightChest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

	//Flower Pots
	public static final FlowerPotBlock POTTED_TWILIGHT_OAK_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_twilight_oak_sapling", new FlowerPotBlock(TWILIGHT_OAK_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_CANOPY_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_canopy_sapling", new FlowerPotBlock(CANOPY_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_MANGROVE_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_mangrove_sapling", new FlowerPotBlock(MANGROVE_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_DARKWOOD_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_darkwood_sapling", new FlowerPotBlock(DARKWOOD_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_HOLLOW_OAK_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_hollow_oak_sapling", new FlowerPotBlock(HOLLOW_OAK_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_RAINBOW_OAK_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_rainbow_oak_sapling", new FlowerPotBlock(RAINBOW_OAK_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_TIME_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_time_sapling", new FlowerPotBlock(TIME_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_TRANSFORMATION_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_transformation_sapling", new FlowerPotBlock(TRANSFORMATION_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_MINING_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_mining_sapling", new FlowerPotBlock(MINING_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_SORTING_SAPLING = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_sorting_sapling", new FlowerPotBlock(SORTING_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_MAYAPPLE = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_mayapple", new FlowerPotBlock(MAYAPPLE, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_FIDDLEHEAD = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_fiddlehead", new FlowerPotBlock(FIDDLEHEAD, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_MUSHGLOOM = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_mushgloom", new FlowerPotBlock(MUSHGLOOM, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_THORN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_thorn", new FlowerPotBlock(BROWN_THORNS, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_GREEN_THORN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_green_thorn", new FlowerPotBlock(GREEN_THORNS, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final FlowerPotBlock POTTED_DEAD_THORN = Registry.register(Registry.BLOCK, TwilightForestMod.ID + ":potted_dead_thorn", new FlowerPotBlock(BURNT_THORNS, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));

	public static void registerItemblocks() {
		TFBlockItems.registerBlockItems();
		TFCompat.initCompatItems();
	}

	private static BlockBehaviour.Properties logProperties(MaterialColor color) {
		return logProperties(color, color);
	}

	private static BlockBehaviour.Properties logProperties(MaterialColor top, MaterialColor side) {
		return BlockBehaviour.Properties.of(Material.WOOD, (state) ->
				state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? top : side);
	}

	public static void registerCompostor(float chance, ItemLike item) {
		CompostingChanceRegistry.INSTANCE.add(item, chance);
	}


	public static void tfCompostables() {
		registerCompostor(0.1F, FALLEN_LEAVES);
		registerCompostor(0.3F, CANOPY_LEAVES);
		registerCompostor(0.3F, CLOVER_PATCH);
		registerCompostor(0.3F, DARK_LEAVES);
		registerCompostor(0.3F, FIDDLEHEAD);
		registerCompostor(0.3F, HEDGE);
		registerCompostor(0.3F, MANGROVE_LEAVES);
		registerCompostor(0.3F, MAYAPPLE);
		registerCompostor(0.3F, MINING_LEAVES);
		registerCompostor(0.3F, TWILIGHT_OAK_LEAVES);
		registerCompostor(0.3F, RAINBOW_OAK_LEAVES);
		registerCompostor(0.3F, ROOT_STRAND);
		registerCompostor(0.3F, SORTING_LEAVES);
		registerCompostor(0.3F, THORN_LEAVES);
		registerCompostor(0.3F, TIME_LEAVES);
		registerCompostor(0.3F, TRANSFORMATION_LEAVES);
		registerCompostor(0.3F, TWILIGHT_OAK_SAPLING);
		registerCompostor(0.3F, CANOPY_SAPLING);
		registerCompostor(0.3F, MANGROVE_SAPLING);
		registerCompostor(0.3F, DARKWOOD_SAPLING);
		registerCompostor(0.3F, RAINBOW_OAK_SAPLING);
		registerCompostor(0.5F, BEANSTALK_LEAVES);
		registerCompostor(0.5F, MOSS_PATCH);
		registerCompostor(0.5F, ROOT_BLOCK);
		registerCompostor(0.5F, THORN_ROSE);
		registerCompostor(0.5F, TROLLVIDR);
		registerCompostor(0.5F, HOLLOW_OAK_SAPLING);
		registerCompostor(0.5F, TIME_SAPLING);
		registerCompostor(0.5F, TRANSFORMATION_SAPLING);
		registerCompostor(0.5F, MINING_SAPLING);
		registerCompostor(0.5F, SORTING_SAPLING);
		registerCompostor(0.5F, TORCHBERRY_PLANT);
		registerCompostor(0.65F, HUGE_MUSHGLOOM_STEM);
		registerCompostor(0.65F, HUGE_WATER_LILY);
		registerCompostor(0.65F, LIVEROOT_BLOCK);
		registerCompostor(0.65F, MUSHGLOOM);
		registerCompostor(0.65F, UBEROUS_SOIL);
		registerCompostor(0.65F, HUGE_STALK);
		registerCompostor(0.65F, UNRIPE_TROLLBER);
		registerCompostor(0.65F, TROLLBER);
		registerCompostor(0.85F, HUGE_LILY_PAD);
		registerCompostor(0.85F, HUGE_MUSHGLOOM);

		//eh, we'll do items here too
		registerCompostor(0.3F, TFItems.TORCHBERRIES);
		registerCompostor(0.5F, TFItems.LIVEROOT);
		registerCompostor(0.65F, TFItems.MAZE_WAFER);
		registerCompostor(0.85F, TFItems.EXPERIMENT_115);
		registerCompostor(0.85F, TFItems.MAGIC_BEANS);
	}

	public static void TFBurnables() {
		//FireBlock fireblock = (FireBlock)Blocks.FIRE;
		FlammableBlockRegistry.getDefaultInstance().add(ROOT_BLOCK, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(LIVEROOT_BLOCK, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EMPTY_CANOPY_BOOKSHELF, 30, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TWILIGHT_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(TWILIGHT_OAK_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TWILIGHT_OAK_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TWILIGHT_OAK_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TWILIGHT_OAK_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TWILIGHT_OAK_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(CANOPY_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(CANOPY_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(CANOPY_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(CANOPY_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(CANOPY_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(CANOPY_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TIME_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(TIME_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TIME_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TIME_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TIME_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TIME_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TRANSFORMATION_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(TRANSFORMATION_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TRANSFORMATION_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TRANSFORMATION_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TRANSFORMATION_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TRANSFORMATION_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MINING_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(MINING_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MINING_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MINING_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MINING_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(MINING_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(SORTING_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(SORTING_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(SORTING_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(SORTING_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(SORTING_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(SORTING_GATE, 5, 20);
	}

	public static void TFPots() {
//		FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
//
//		pot.addPlant(TWILIGHT_OAK_SAPLING.getId(), POTTED_TWILIGHT_OAK_SAPLING);
//		pot.addPlant(CANOPY_SAPLING.getId(), POTTED_CANOPY_SAPLING);
//		pot.addPlant(MANGROVE_SAPLING.getId(), POTTED_MANGROVE_SAPLING);
//		pot.addPlant(DARKWOOD_SAPLING.getId(), POTTED_DARKWOOD_SAPLING);
//		pot.addPlant(HOLLOW_OAK_SAPLING.getId(), POTTED_HOLLOW_OAK_SAPLING);
//		pot.addPlant(RAINBOW_OAK_SAPLING.getId(), POTTED_RAINBOW_OAK_SAPLING);
//		pot.addPlant(TIME_SAPLING.getId(), POTTED_TIME_SAPLING);
//		pot.addPlant(TRANSFORMATION_SAPLING.getId(), POTTED_TRANSFORMATION_SAPLING);
//		pot.addPlant(MINING_SAPLING.getId(), POTTED_MINING_SAPLING);
//		pot.addPlant(SORTING_SAPLING.getId(), POTTED_SORTING_SAPLING);
//		pot.addPlant(MAYAPPLE.getId(), POTTED_MAYAPPLE);
//		pot.addPlant(FIDDLEHEAD.getId(), POTTED_FIDDLEHEAD);
//		pot.addPlant(MUSHGLOOM.getId(), POTTED_MUSHGLOOM);
//		pot.addPlant(BROWN_THORNS.getId(), POTTED_THORN);
//		pot.addPlant(GREEN_THORNS.getId(), POTTED_GREEN_THORN);
//		pot.addPlant(BURNT_THORNS.getId(), POTTED_DEAD_THORN);
	}
}
