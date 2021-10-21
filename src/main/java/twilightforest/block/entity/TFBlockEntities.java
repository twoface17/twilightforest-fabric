package twilightforest.block.entity;

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import twilightforest.TwilightForestMod;
import twilightforest.block.AbstractSkullCandleBlock;
import twilightforest.block.AbstractTrophyBlock;
import twilightforest.block.TFBlocks;
import twilightforest.client.ISTER;
import twilightforest.client.renderer.tileentity.*;
import twilightforest.block.entity.spawner.*;

import java.util.List;

public class TFBlockEntities {

	//public static final DeferredRegister<BlockEntityType<?> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TwilightForestMod.ID);

	public static final BlockEntityType<AntibuilderBlockEntity> ANTIBUILDER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":antibuilder",
			BlockEntityType.Builder.of(AntibuilderBlockEntity::new, TFBlocks.ANTIBUILDER).build(null));
	public static final BlockEntityType<CinderFurnaceBlockEntity> CINDER_FURNACE = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":cinder_furnace",
			BlockEntityType.Builder.of(CinderFurnaceBlockEntity::new, TFBlocks.CINDER_FURNACE).build(null));
	public static final BlockEntityType<CarminiteReactorBlockEntity> CARMINITE_REACTOR = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":carminite_reactor",
			BlockEntityType.Builder.of(CarminiteReactorBlockEntity::new, TFBlocks.CARMINITE_REACTOR).build(null));
	public static final BlockEntityType<FireJetBlockEntity> FLAME_JET = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":flame_jet",
			BlockEntityType.Builder.of(FireJetBlockEntity::new, TFBlocks.FIRE_JET, TFBlocks.ENCASED_FIRE_JET).build(null));
	public static final BlockEntityType<GhastTrapBlockEntity> GHAST_TRAP = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":ghast_trap",
			BlockEntityType.Builder.of(GhastTrapBlockEntity::new, TFBlocks.GHAST_TRAP).build(null));
	public static final BlockEntityType<TFSmokerBlockEntity> SMOKER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":smoker",
			BlockEntityType.Builder.of(TFSmokerBlockEntity::new, TFBlocks.SMOKER, TFBlocks.ENCASED_SMOKER).build(null));
	public static final BlockEntityType<CarminiteBuilderBlockEntity> TOWER_BUILDER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":tower_builder",
			BlockEntityType.Builder.of(CarminiteBuilderBlockEntity::new, TFBlocks.CARMINITE_BUILDER).build(null));
	public static final BlockEntityType<TrophyBlockEntity> TROPHY = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":trophy",
			BlockEntityType.Builder.of(TrophyBlockEntity::new, TFBlocks.NAGA_TROPHY, TFBlocks.LICH_TROPHY, TFBlocks.MINOSHROOM_TROPHY,
					TFBlocks.HYDRA_TROPHY, TFBlocks.KNIGHT_PHANTOM_TROPHY, TFBlocks.UR_GHAST_TROPHY, TFBlocks.ALPHA_YETI_TROPHY,
					TFBlocks.SNOW_QUEEN_TROPHY, TFBlocks.QUEST_RAM_TROPHY, TFBlocks.NAGA_WALL_TROPHY, TFBlocks.LICH_WALL_TROPHY,
					TFBlocks.MINOSHROOM_WALL_TROPHY, TFBlocks.HYDRA_WALL_TROPHY, TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY, TFBlocks.UR_GHAST_WALL_TROPHY,
					TFBlocks.ALPHA_YETI_WALL_TROPHY, TFBlocks.SNOW_QUEEN_WALL_TROPHY, TFBlocks.QUEST_RAM_WALL_TROPHY).build(null));
	public static final BlockEntityType<AlphaYetiSpawnerBlockEntity> ALPHA_YETI_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":alpha_yeti_spawner",
			BlockEntityType.Builder.of(AlphaYetiSpawnerBlockEntity::new, TFBlocks.ALPHA_YETI_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<FinalBossSpawnerBlockEntity> FINAL_BOSS_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":final_boss_spawner",
			BlockEntityType.Builder.of(FinalBossSpawnerBlockEntity::new, TFBlocks.FINAL_BOSS_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<HydraSpawnerBlockEntity> HYDRA_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":hydra_boss_spawner",
			BlockEntityType.Builder.of(HydraSpawnerBlockEntity::new, TFBlocks.HYDRA_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<KnightPhantomSpawnerBlockEntity> KNIGHT_PHANTOM_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":knight_phantom_spawner",
			BlockEntityType.Builder.of(KnightPhantomSpawnerBlockEntity::new, TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<LichSpawnerBlockEntity> LICH_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":lich_spawner",
			BlockEntityType.Builder.of(LichSpawnerBlockEntity::new, TFBlocks.LICH_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<MinoshroomSpawnerBlockEntity> MINOSHROOM_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":minoshroom_spawner",
			BlockEntityType.Builder.of(MinoshroomSpawnerBlockEntity::new, TFBlocks.MINOSHROOM_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<NagaSpawnerBlockEntity> NAGA_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":naga_spawner",
			BlockEntityType.Builder.of(NagaSpawnerBlockEntity::new, TFBlocks.NAGA_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<SnowQueenSpawnerBlockEntity> SNOW_QUEEN_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":snow_queen_spawner",
			BlockEntityType.Builder.of(SnowQueenSpawnerBlockEntity::new, TFBlocks.SNOW_QUEEN_BOSS_SPAWNER).build(null));
	public static final BlockEntityType<UrGhastSpawnerBlockEntity> UR_GHAST_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":tower_boss_spawner",
			BlockEntityType.Builder.of(UrGhastSpawnerBlockEntity::new, TFBlocks.UR_GHAST_BOSS_SPAWNER).build(null));

	public static final BlockEntityType<CicadaBlockEntity> CICADA = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":cicada",
			BlockEntityType.Builder.of(CicadaBlockEntity::new, TFBlocks.CICADA).build(null));
	public static final BlockEntityType<FireflyBlockEntity> FIREFLY = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":firefly",
			BlockEntityType.Builder.of(FireflyBlockEntity::new, TFBlocks.FIREFLY).build(null));
	public static final BlockEntityType<MoonwormBlockEntity> MOONWORM = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":moonworm",
			BlockEntityType.Builder.of(MoonwormBlockEntity::new, TFBlocks.MOONWORM).build(null));

	public static final BlockEntityType<KeepsakeCasketBlockEntity> KEEPSAKE_CASKET = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":keepsake_casket",
			BlockEntityType.Builder.of(KeepsakeCasketBlockEntity::new, TFBlocks.KEEPSAKE_CASKET).build(null));

	public static final BlockEntityType<TFSignBlockEntity> TF_SIGN = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":tf_sign",
			BlockEntityType.Builder.of(TFSignBlockEntity::new,
					TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_WALL_SIGN,
					TFBlocks.CANOPY_SIGN, TFBlocks.CANOPY_WALL_SIGN,
					TFBlocks.MANGROVE_SIGN, TFBlocks.MANGROVE_WALL_SIGN,
					TFBlocks.DARKWOOD_SIGN, TFBlocks.DARKWOOD_WALL_SIGN,
					TFBlocks.TIME_SIGN, TFBlocks.TIME_WALL_SIGN,
					TFBlocks.TRANSFORMATION_SIGN, TFBlocks.TRANSFORMATION_WALL_SIGN,
					TFBlocks.MINING_SIGN, TFBlocks.MINING_WALL_SIGN,
					TFBlocks.SORTING_SIGN, TFBlocks.SORTING_WALL_SIGN).build(null));

	public static final BlockEntityType<TwilightChestEntity> TF_CHEST = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":tf_chest",
			BlockEntityType.Builder.of(TwilightChestEntity::new,
					TFBlocks.TWILIGHT_OAK_CHEST, TFBlocks.CANOPY_CHEST, TFBlocks.MANGROVE_CHEST,
					TFBlocks.DARKWOOD_CHEST, TFBlocks.TIME_CHEST, TFBlocks.TRANSFORMATION_CHEST,
					TFBlocks.MINING_CHEST, TFBlocks.SORTING_CHEST).build(null));

	public static final BlockEntityType<SkullCandleBlockEntity> SKULL_CANDLE = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":skull_candle",
			BlockEntityType.Builder.of(SkullCandleBlockEntity::new,
					TFBlocks.ZOMBIE_SKULL_CANDLE, TFBlocks.ZOMBIE_WALL_SKULL_CANDLE,
					TFBlocks.SKELETON_SKULL_CANDLE, TFBlocks.SKELETON_WALL_SKULL_CANDLE,
					TFBlocks.WITHER_SKELE_SKULL_CANDLE, TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE,
					TFBlocks.CREEPER_SKULL_CANDLE, TFBlocks.CREEPER_WALL_SKULL_CANDLE,
					TFBlocks.PLAYER_SKULL_CANDLE, TFBlocks.PLAYER_WALL_SKULL_CANDLE).build(null));

	public static final BlockEntityType<TomeSpawnerBlockEntity> TOME_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TwilightForestMod.ID + ":tome_spawner",
			BlockEntityType.Builder.of(TomeSpawnerBlockEntity::new, TFBlocks.DEATH_TOME_SPAWNER).build(null));

	public static void init() {}

	@Environment(EnvType.CLIENT)
	public static void registerTileEntityRenders() {
		// tile entities
		BlockEntityRendererRegistry.register(FIREFLY, FireflyTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(CICADA, CicadaTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(MOONWORM, MoonwormTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(TROPHY, TrophyTileEntityRenderer::new);
		BlockEntityRenderers.register(TF_SIGN,  SignRenderer::new);
		BlockEntityRendererRegistry.register(TF_CHEST, TwilightChestRenderer::new);
		BlockEntityRendererRegistry.register(KEEPSAKE_CASKET, CasketTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(SKULL_CANDLE, SkullCandleTileEntityRenderer::new);
	}
}