package twilightforest.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import twilightforest.TFConstants;
import twilightforest.block.AbstractSkullCandleBlock;
import twilightforest.block.AbstractTrophyBlock;
import twilightforest.block.TFBlocks;
import twilightforest.block.entity.spawner.*;
import twilightforest.client.ISTER;
import twilightforest.client.renderer.tileentity.*;

import java.util.List;

public class TFBlockEntities {

	public static final BlockEntityType<AntibuilderBlockEntity> ANTIBUILDER               = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":antibuilder",
			BlockEntityType.Builder.of(AntibuilderBlockEntity::new, TFBlocks.antibuilder).build(null));
	public static final BlockEntityType<CinderFurnaceBlockEntity> CINDER_FURNACE          = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":cinder_furnace",
			BlockEntityType.Builder.of(CinderFurnaceBlockEntity::new, TFBlocks.cinder_furnace).build(null));
	public static final BlockEntityType<CarminiteReactorBlockEntity> CARMINITE_REACTOR      = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":carminite_reactor",
			BlockEntityType.Builder.of(CarminiteReactorBlockEntity::new, TFBlocks.carminite_reactor).build(null));
	public static final BlockEntityType<FireJetBlockEntity> FLAME_JET                    = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":flame_jet",
			BlockEntityType.Builder.of(FireJetBlockEntity::new, TFBlocks.fire_jet, TFBlocks.encased_fire_jet).build(null));
	public static final BlockEntityType<GhastTrapBlockEntity> GHAST_TRAP = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":ghast_trap",
			BlockEntityType.Builder.of(GhastTrapBlockEntity::new, TFBlocks.ghast_trap).build(null));
	public static final BlockEntityType<TFSmokerBlockEntity> SMOKER                           = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":smoker",
			BlockEntityType.Builder.of(TFSmokerBlockEntity::new, TFBlocks.smoker, TFBlocks.encased_smoker).build(null));
	public static final BlockEntityType<CarminiteBuilderBlockEntity> TOWER_BUILDER            = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":tower_builder",
			BlockEntityType.Builder.of(CarminiteBuilderBlockEntity::new, TFBlocks.carminite_builder).build(null));
	public static final BlockEntityType<TrophyBlockEntity> TROPHY                         = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":trophy",
			BlockEntityType.Builder.of(TrophyBlockEntity::new, TFBlocks.naga_trophy, TFBlocks.lich_trophy, TFBlocks.minoshroom_trophy,
					TFBlocks.hydra_trophy, TFBlocks.knight_phantom_trophy, TFBlocks.ur_ghast_trophy, TFBlocks.yeti_trophy,
					TFBlocks.snow_queen_trophy, TFBlocks.quest_ram_trophy, TFBlocks.naga_wall_trophy, TFBlocks.lich_wall_trophy,
					TFBlocks.minoshroom_wall_trophy, TFBlocks.hydra_wall_trophy, TFBlocks.knight_phantom_wall_trophy, TFBlocks.ur_ghast_wall_trophy,
					TFBlocks.yeti_wall_trophy, TFBlocks.snow_queen_wall_trophy, TFBlocks.quest_ram_wall_trophy).build(null));
	public static final BlockEntityType<AlphaYetiSpawnerBlockEntity> ALPHA_YETI_SPAWNER     = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":alpha_yeti_spawner",
			BlockEntityType.Builder.of(AlphaYetiSpawnerBlockEntity::new, TFBlocks.boss_spawner_alpha_yeti).build(null));
	public static final BlockEntityType<FinalBossSpawnerBlockEntity> FINAL_BOSS_SPAWNER     = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":final_boss_spawner",
			BlockEntityType.Builder.of(FinalBossSpawnerBlockEntity::new, TFBlocks.boss_spawner_final_boss).build(null));
	public static final BlockEntityType<HydraSpawnerBlockEntity> HYDRA_SPAWNER          = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":hydra_boss_spawner",
			BlockEntityType.Builder.of(HydraSpawnerBlockEntity::new, TFBlocks.boss_spawner_hydra).build(null));
	public static final BlockEntityType<KnightPhantomSpawnerBlockEntity> KNIGHT_PHANTOM_SPAWNER = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":knight_phantom_spawner",
			BlockEntityType.Builder.of(KnightPhantomSpawnerBlockEntity::new, TFBlocks.boss_spawner_knight_phantom).build(null));
	public static final BlockEntityType<LichSpawnerBlockEntity> LICH_SPAWNER           = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":lich_spawner",
			BlockEntityType.Builder.of(LichSpawnerBlockEntity::new, TFBlocks.boss_spawner_lich).build(null));
	public static final BlockEntityType<MinoshroomSpawnerBlockEntity> MINOSHROOM_SPAWNER     = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":minoshroom_spawner",
			BlockEntityType.Builder.of(MinoshroomSpawnerBlockEntity::new, TFBlocks.boss_spawner_minoshroom).build(null));
	public static final BlockEntityType<NagaSpawnerBlockEntity> NAGA_SPAWNER           = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":naga_spawner",
			BlockEntityType.Builder.of(NagaSpawnerBlockEntity::new, TFBlocks.boss_spawner_naga).build(null));
	public static final BlockEntityType<SnowQueenSpawnerBlockEntity> SNOW_QUEEN_SPAWNER     = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":snow_queen_spawner",
			BlockEntityType.Builder.of(SnowQueenSpawnerBlockEntity::new, TFBlocks.boss_spawner_snow_queen).build(null));
	public static final BlockEntityType<UrGhastSpawnerBlockEntity> UR_GHAST_SPAWNER     = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":tower_boss_spawner",
			BlockEntityType.Builder.of(UrGhastSpawnerBlockEntity::new, TFBlocks.boss_spawner_ur_ghast).build(null));

	public static final RegistryObject<BlockEntityType<AntibuilderBlockEntity>> ANTIBUILDER = TILE_ENTITIES.register("antibuilder", () ->
			BlockEntityType.Builder.of(AntibuilderBlockEntity::new, TFBlocks.ANTIBUILDER.get()).build(null));
	public static final RegistryObject<BlockEntityType<CinderFurnaceBlockEntity>> CINDER_FURNACE = TILE_ENTITIES.register("cinder_furnace", () ->
			BlockEntityType.Builder.of(CinderFurnaceBlockEntity::new, TFBlocks.CINDER_FURNACE.get()).build(null));
	public static final RegistryObject<BlockEntityType<CarminiteReactorBlockEntity>> CARMINITE_REACTOR = TILE_ENTITIES.register("carminite_reactor", () ->
			BlockEntityType.Builder.of(CarminiteReactorBlockEntity::new, TFBlocks.CARMINITE_REACTOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<FireJetBlockEntity>> FLAME_JET = TILE_ENTITIES.register("flame_jet", () ->
			BlockEntityType.Builder.of(FireJetBlockEntity::new, TFBlocks.FIRE_JET.get(), TFBlocks.ENCASED_FIRE_JET.get()).build(null));
	public static final RegistryObject<BlockEntityType<GhastTrapBlockEntity>> GHAST_TRAP = TILE_ENTITIES.register("ghast_trap", () ->
			BlockEntityType.Builder.of(GhastTrapBlockEntity::new, TFBlocks.GHAST_TRAP.get()).build(null));
	public static final RegistryObject<BlockEntityType<TFSmokerBlockEntity>> SMOKER = TILE_ENTITIES.register("smoker", () ->
			BlockEntityType.Builder.of(TFSmokerBlockEntity::new, TFBlocks.SMOKER.get(), TFBlocks.ENCASED_SMOKER.get()).build(null));
	public static final RegistryObject<BlockEntityType<CarminiteBuilderBlockEntity>> TOWER_BUILDER = TILE_ENTITIES.register("tower_builder", () ->
			BlockEntityType.Builder.of(CarminiteBuilderBlockEntity::new, TFBlocks.CARMINITE_BUILDER.get()).build(null));
	public static final RegistryObject<BlockEntityType<TrophyBlockEntity>> TROPHY = TILE_ENTITIES.register("trophy", () ->
			BlockEntityType.Builder.of(TrophyBlockEntity::new, TFBlocks.NAGA_TROPHY.get(), TFBlocks.LICH_TROPHY.get(), TFBlocks.MINOSHROOM_TROPHY.get(),
					TFBlocks.HYDRA_TROPHY.get(), TFBlocks.KNIGHT_PHANTOM_TROPHY.get(), TFBlocks.UR_GHAST_TROPHY.get(), TFBlocks.ALPHA_YETI_TROPHY.get(),
					TFBlocks.SNOW_QUEEN_TROPHY.get(), TFBlocks.QUEST_RAM_TROPHY.get(), TFBlocks.NAGA_WALL_TROPHY.get(), TFBlocks.LICH_WALL_TROPHY.get(),
					TFBlocks.MINOSHROOM_WALL_TROPHY.get(), TFBlocks.HYDRA_WALL_TROPHY.get(), TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY.get(), TFBlocks.UR_GHAST_WALL_TROPHY.get(),
					TFBlocks.ALPHA_YETI_WALL_TROPHY.get(), TFBlocks.SNOW_QUEEN_WALL_TROPHY.get(), TFBlocks.QUEST_RAM_WALL_TROPHY.get()).build(null));
	public static final RegistryObject<BlockEntityType<AlphaYetiSpawnerBlockEntity>> ALPHA_YETI_SPAWNER = TILE_ENTITIES.register("alpha_yeti_spawner", () ->
			BlockEntityType.Builder.of(AlphaYetiSpawnerBlockEntity::new, TFBlocks.ALPHA_YETI_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<FinalBossSpawnerBlockEntity>> FINAL_BOSS_SPAWNER = TILE_ENTITIES.register("final_boss_spawner", () ->
			BlockEntityType.Builder.of(FinalBossSpawnerBlockEntity::new, TFBlocks.FINAL_BOSS_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<HydraSpawnerBlockEntity>> HYDRA_SPAWNER = TILE_ENTITIES.register("hydra_boss_spawner", () ->
			BlockEntityType.Builder.of(HydraSpawnerBlockEntity::new, TFBlocks.HYDRA_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<KnightPhantomSpawnerBlockEntity>> KNIGHT_PHANTOM_SPAWNER = TILE_ENTITIES.register("knight_phantom_spawner", () ->
			BlockEntityType.Builder.of(KnightPhantomSpawnerBlockEntity::new, TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<LichSpawnerBlockEntity>> LICH_SPAWNER = TILE_ENTITIES.register("lich_spawner", () ->
			BlockEntityType.Builder.of(LichSpawnerBlockEntity::new, TFBlocks.LICH_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<MinoshroomSpawnerBlockEntity>> MINOSHROOM_SPAWNER = TILE_ENTITIES.register("minoshroom_spawner", () ->
			BlockEntityType.Builder.of(MinoshroomSpawnerBlockEntity::new, TFBlocks.MINOSHROOM_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<NagaSpawnerBlockEntity>> NAGA_SPAWNER = TILE_ENTITIES.register("naga_spawner", () ->
			BlockEntityType.Builder.of(NagaSpawnerBlockEntity::new, TFBlocks.NAGA_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<SnowQueenSpawnerBlockEntity>> SNOW_QUEEN_SPAWNER = TILE_ENTITIES.register("snow_queen_spawner", () ->
			BlockEntityType.Builder.of(SnowQueenSpawnerBlockEntity::new, TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get()).build(null));
	public static final RegistryObject<BlockEntityType<UrGhastSpawnerBlockEntity>> UR_GHAST_SPAWNER = TILE_ENTITIES.register("tower_boss_spawner", () ->
			BlockEntityType.Builder.of(UrGhastSpawnerBlockEntity::new, TFBlocks.UR_GHAST_BOSS_SPAWNER.get()).build(null));

	public static final RegistryObject<BlockEntityType<CicadaBlockEntity>> CICADA = TILE_ENTITIES.register("cicada", () ->
			BlockEntityType.Builder.of(CicadaBlockEntity::new, TFBlocks.CICADA.get()).build(null));
	public static final RegistryObject<BlockEntityType<FireflyBlockEntity>> FIREFLY = TILE_ENTITIES.register("firefly", () ->
			BlockEntityType.Builder.of(FireflyBlockEntity::new, TFBlocks.FIREFLY.get()).build(null));
	public static final RegistryObject<BlockEntityType<MoonwormBlockEntity>> MOONWORM = TILE_ENTITIES.register("moonworm", () ->
			BlockEntityType.Builder.of(MoonwormBlockEntity::new, TFBlocks.MOONWORM.get()).build(null));

	public static final RegistryObject<BlockEntityType<KeepsakeCasketBlockEntity>> KEEPSAKE_CASKET = TILE_ENTITIES.register("keepsake_casket", () ->
			BlockEntityType.Builder.of(KeepsakeCasketBlockEntity::new, TFBlocks.KEEPSAKE_CASKET.get()).build(null));

	public static final RegistryObject<BlockEntityType<TFSignBlockEntity>> TF_SIGN = TILE_ENTITIES.register("tf_sign", () ->
			BlockEntityType.Builder.of(TFSignBlockEntity::new,
					TFBlocks.TWILIGHT_OAK_SIGN.get(), TFBlocks.TWILIGHT_WALL_SIGN.get(),
					TFBlocks.CANOPY_SIGN.get(), TFBlocks.CANOPY_WALL_SIGN.get(),
					TFBlocks.MANGROVE_SIGN.get(), TFBlocks.MANGROVE_WALL_SIGN.get(),
					TFBlocks.DARKWOOD_SIGN.get(), TFBlocks.DARKWOOD_WALL_SIGN.get(),
					TFBlocks.TIME_SIGN.get(), TFBlocks.TIME_WALL_SIGN.get(),
					TFBlocks.TRANSFORMATION_SIGN.get(), TFBlocks.TRANSFORMATION_WALL_SIGN.get(),
					TFBlocks.MINING_SIGN.get(), TFBlocks.MINING_WALL_SIGN.get(),
					TFBlocks.SORTING_SIGN.get(), TFBlocks.SORTING_WALL_SIGN.get()).build(null));

	public static final BlockEntityType<SkullCandleBlockEntity> SKULL_CANDLE = Registry.register(Registry.BLOCK_ENTITY_TYPE, TFConstants.ID+":skull_candle",
			BlockEntityType.Builder.of(SkullCandleBlockEntity::new,
					TFBlocks.ZOMBIE_SKULL_CANDLE.get(), TFBlocks.ZOMBIE_WALL_SKULL_CANDLE.get(),
					TFBlocks.SKELETON_SKULL_CANDLE.get(), TFBlocks.SKELETON_WALL_SKULL_CANDLE.get(),
					TFBlocks.WITHER_SKELE_SKULL_CANDLE.get(), TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE.get(),
					TFBlocks.CREEPER_SKULL_CANDLE.get(), TFBlocks.CREEPER_WALL_SKULL_CANDLE.get(),
					TFBlocks.PLAYER_SKULL_CANDLE.get(), TFBlocks.PLAYER_WALL_SKULL_CANDLE.get()).build(null));

	public static final RegistryObject<BlockEntityType<TomeSpawnerBlockEntity>> TOME_SPAWNER = TILE_ENTITIES.register("tome_spawner", () ->
			BlockEntityType.Builder.of(TomeSpawnerBlockEntity::new, TFBlocks.DEATH_TOME_SPAWNER.get()).build(null));

	public static void init() {}

	@Environment(EnvType.CLIENT)
	public static void registerTileEntityRenders() {
		// tile entities
		//Fabric has a api for this but I already made the aw
		BlockEntityRendererRegistry.INSTANCE.register(FIREFLY, FireflyTileEntityRenderer::new);
		BlockEntityRendererRegistry.INSTANCE.register(CICADA, CicadaTileEntityRenderer::new);
		BlockEntityRendererRegistry.INSTANCE.register(MOONWORM, MoonwormTileEntityRenderer::new);
		BlockEntityRendererRegistry.INSTANCE.register(TROPHY, TrophyTileEntityRenderer::new);
		BlockEntityRenderers.register(TF_SIGN, SignRenderer::new);
		BlockEntityRendererRegistry.INSTANCE.register(KEEPSAKE_CASKET, CasketTileEntityRenderer::new);
		BlockEntityRendererRegistry.INSTANCE.register(SKULL_CANDLE, SkullCandleTileEntityRenderer::new);

		registerTileEntitysItemRenders();
	}

	public static void registerTileEntitysItemRenders(){
		List<AbstractTrophyBlock> TROPHYS = List.of(TFBlocks.naga_trophy, TFBlocks.lich_trophy, TFBlocks.minoshroom_trophy,
				TFBlocks.hydra_trophy, TFBlocks.knight_phantom_trophy, TFBlocks.ur_ghast_trophy, TFBlocks.yeti_trophy,
				TFBlocks.snow_queen_trophy, TFBlocks.quest_ram_trophy);

		List<AbstractSkullCandleBlock> SKULLCANDLES = List.of(TFBlocks.zombie_skull_candle, TFBlocks.skeleton_skull_candle,
				TFBlocks.wither_skele_skull_candle, TFBlocks.creeper_skull_candle, TFBlocks.player_skull_candle);

		for(AbstractTrophyBlock block : TROPHYS){
			BuiltinItemRendererRegistry.INSTANCE.register(block, (itemStack, transform, stack, source, light, overlay) -> {
				new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TROPHY)).renderByItem(itemStack, transform, stack, source, light, overlay);
			});
		}

		for(AbstractSkullCandleBlock block : SKULLCANDLES){
			BuiltinItemRendererRegistry.INSTANCE.register(block, (itemStack, transform, stack, source, light, overlay) -> {
				new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.SKULL_CANDLE)).renderByItem(itemStack, transform, stack, source, light, overlay);
			});
		}

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.cicada, (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.CICADA)).renderByItem(itemStack, transform, stack, source, light, overlay);
		});

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.firefly, (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.FIREFLY)).renderByItem(itemStack, transform, stack, source, light, overlay);
		});

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.moonworm, (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.MOONWORM)).renderByItem(itemStack, transform, stack, source, light, overlay);
		});

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.keepsake_casket, (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.KEEPSAKE_CASKET)).renderByItem(itemStack, transform, stack, source, light, overlay);
		});
	}
}
