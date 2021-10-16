package twilightforest.block.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
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

	public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(TwilightForestMod.ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

	public static final RegistrySupplier<BlockEntityType<AntibuilderBlockEntity>> ANTIBUILDER = TILE_ENTITIES.register("antibuilder", () ->
			BlockEntityType.Builder.of(AntibuilderBlockEntity::new, TFBlocks.ANTIBUILDER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<CinderFurnaceBlockEntity>> CINDER_FURNACE = TILE_ENTITIES.register("cinder_furnace", () ->
			BlockEntityType.Builder.of(CinderFurnaceBlockEntity::new, TFBlocks.CINDER_FURNACE.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<CarminiteReactorBlockEntity>> CARMINITE_REACTOR = TILE_ENTITIES.register("carminite_reactor", () ->
			BlockEntityType.Builder.of(CarminiteReactorBlockEntity::new, TFBlocks.CARMINITE_REACTOR.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<FireJetBlockEntity>> FLAME_JET = TILE_ENTITIES.register("flame_jet", () ->
			BlockEntityType.Builder.of(FireJetBlockEntity::new, TFBlocks.FIRE_JET.get(), TFBlocks.ENCASED_FIRE_JET.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<GhastTrapBlockEntity>> GHAST_TRAP = TILE_ENTITIES.register("ghast_trap", () ->
			BlockEntityType.Builder.of(GhastTrapBlockEntity::new, TFBlocks.GHAST_TRAP.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<TFSmokerBlockEntity>> SMOKER = TILE_ENTITIES.register("smoker", () ->
			BlockEntityType.Builder.of(TFSmokerBlockEntity::new, TFBlocks.SMOKER.get(), TFBlocks.ENCASED_SMOKER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<CarminiteBuilderBlockEntity>> TOWER_BUILDER = TILE_ENTITIES.register("tower_builder", () ->
			BlockEntityType.Builder.of(CarminiteBuilderBlockEntity::new, TFBlocks.CARMINITE_BUILDER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<TrophyBlockEntity>> TROPHY = TILE_ENTITIES.register("trophy", () ->
			BlockEntityType.Builder.of(TrophyBlockEntity::new, TFBlocks.NAGA_TROPHY.get(), TFBlocks.LICH_TROPHY.get(), TFBlocks.MINOSHROOM_TROPHY.get(),
					TFBlocks.HYDRA_TROPHY.get(), TFBlocks.KNIGHT_PHANTOM_TROPHY.get(), TFBlocks.UR_GHAST_TROPHY.get(), TFBlocks.ALPHA_YETI_TROPHY.get(),
					TFBlocks.SNOW_QUEEN_TROPHY.get(), TFBlocks.QUEST_RAM_TROPHY.get(), TFBlocks.NAGA_WALL_TROPHY.get(), TFBlocks.LICH_WALL_TROPHY.get(),
					TFBlocks.MINOSHROOM_WALL_TROPHY.get(), TFBlocks.HYDRA_WALL_TROPHY.get(), TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY.get(), TFBlocks.UR_GHAST_WALL_TROPHY.get(),
					TFBlocks.ALPHA_YETI_WALL_TROPHY.get(), TFBlocks.SNOW_QUEEN_WALL_TROPHY.get(), TFBlocks.QUEST_RAM_WALL_TROPHY.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<AlphaYetiSpawnerBlockEntity>> ALPHA_YETI_SPAWNER = TILE_ENTITIES.register("alpha_yeti_spawner", () ->
			BlockEntityType.Builder.of(AlphaYetiSpawnerBlockEntity::new, TFBlocks.ALPHA_YETI_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<FinalBossSpawnerBlockEntity>> FINAL_BOSS_SPAWNER = TILE_ENTITIES.register("final_boss_spawner", () ->
			BlockEntityType.Builder.of(FinalBossSpawnerBlockEntity::new, TFBlocks.FINAL_BOSS_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<HydraSpawnerBlockEntity>> HYDRA_SPAWNER = TILE_ENTITIES.register("hydra_boss_spawner", () ->
			BlockEntityType.Builder.of(HydraSpawnerBlockEntity::new, TFBlocks.HYDRA_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<KnightPhantomSpawnerBlockEntity>> KNIGHT_PHANTOM_SPAWNER = TILE_ENTITIES.register("knight_phantom_spawner", () ->
			BlockEntityType.Builder.of(KnightPhantomSpawnerBlockEntity::new, TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<LichSpawnerBlockEntity>> LICH_SPAWNER = TILE_ENTITIES.register("lich_spawner", () ->
			BlockEntityType.Builder.of(LichSpawnerBlockEntity::new, TFBlocks.LICH_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<MinoshroomSpawnerBlockEntity>> MINOSHROOM_SPAWNER = TILE_ENTITIES.register("minoshroom_spawner", () ->
			BlockEntityType.Builder.of(MinoshroomSpawnerBlockEntity::new, TFBlocks.MINOSHROOM_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<NagaSpawnerBlockEntity>> NAGA_SPAWNER = TILE_ENTITIES.register("naga_spawner", () ->
			BlockEntityType.Builder.of(NagaSpawnerBlockEntity::new, TFBlocks.NAGA_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<SnowQueenSpawnerBlockEntity>> SNOW_QUEEN_SPAWNER = TILE_ENTITIES.register("snow_queen_spawner", () ->
			BlockEntityType.Builder.of(SnowQueenSpawnerBlockEntity::new, TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<UrGhastSpawnerBlockEntity>> UR_GHAST_SPAWNER = TILE_ENTITIES.register("tower_boss_spawner", () ->
			BlockEntityType.Builder.of(UrGhastSpawnerBlockEntity::new, TFBlocks.UR_GHAST_BOSS_SPAWNER.get()).build(null));

	public static final RegistrySupplier<BlockEntityType<CicadaBlockEntity>> CICADA = TILE_ENTITIES.register("cicada", () ->
			BlockEntityType.Builder.of(CicadaBlockEntity::new, TFBlocks.CICADA.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<FireflyBlockEntity>> FIREFLY = TILE_ENTITIES.register("firefly", () ->
			BlockEntityType.Builder.of(FireflyBlockEntity::new, TFBlocks.FIREFLY.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<MoonwormBlockEntity>> MOONWORM = TILE_ENTITIES.register("moonworm", () ->
			BlockEntityType.Builder.of(MoonwormBlockEntity::new, TFBlocks.MOONWORM.get()).build(null));

	public static final RegistrySupplier<BlockEntityType<KeepsakeCasketBlockEntity>> KEEPSAKE_CASKET = TILE_ENTITIES.register("keepsake_casket", () ->
			BlockEntityType.Builder.of(KeepsakeCasketBlockEntity::new, TFBlocks.KEEPSAKE_CASKET.get()).build(null));

	public static final RegistrySupplier<BlockEntityType<TFSignBlockEntity>> TF_SIGN = TILE_ENTITIES.register("tf_sign", () ->
			BlockEntityType.Builder.of(TFSignBlockEntity::new,
					TFBlocks.TWILIGHT_OAK_SIGN.get(), TFBlocks.TWILIGHT_WALL_SIGN.get(),
					TFBlocks.CANOPY_SIGN.get(), TFBlocks.CANOPY_WALL_SIGN.get(),
					TFBlocks.MANGROVE_SIGN.get(), TFBlocks.MANGROVE_WALL_SIGN.get(),
					TFBlocks.DARKWOOD_SIGN.get(), TFBlocks.DARKWOOD_WALL_SIGN.get(),
					TFBlocks.TIME_SIGN.get(), TFBlocks.TIME_WALL_SIGN.get(),
					TFBlocks.TRANSFORMATION_SIGN.get(), TFBlocks.TRANSFORMATION_WALL_SIGN.get(),
					TFBlocks.MINING_SIGN.get(), TFBlocks.MINING_WALL_SIGN.get(),
					TFBlocks.SORTING_SIGN.get(), TFBlocks.SORTING_WALL_SIGN.get()).build(null));

	public static final RegistrySupplier<BlockEntityType<SkullCandleBlockEntity>> SKULL_CANDLE = TILE_ENTITIES.register("skull_candle", () ->
			BlockEntityType.Builder.of(SkullCandleBlockEntity::new,
					TFBlocks.ZOMBIE_SKULL_CANDLE.get(), TFBlocks.ZOMBIE_WALL_SKULL_CANDLE.get(),
					TFBlocks.SKELETON_SKULL_CANDLE.get(), TFBlocks.SKELETON_WALL_SKULL_CANDLE.get(),
					TFBlocks.WITHER_SKELE_SKULL_CANDLE.get(), TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE.get(),
					TFBlocks.CREEPER_SKULL_CANDLE.get(), TFBlocks.CREEPER_WALL_SKULL_CANDLE.get(),
					TFBlocks.PLAYER_SKULL_CANDLE.get(), TFBlocks.PLAYER_WALL_SKULL_CANDLE.get()).build(null));

	public static final RegistrySupplier<BlockEntityType<TomeSpawnerBlockEntity>> TOME_SPAWNER = TILE_ENTITIES.register("tome_spawner", () ->
			BlockEntityType.Builder.of(TomeSpawnerBlockEntity::new, TFBlocks.DEATH_TOME_SPAWNER.get()).build(null));

	public static void init() {}

	@Environment(EnvType.CLIENT)
	public static void registerTileEntityRenders() {
		// tile entities
		BlockEntityRendererRegistry.register(FIREFLY.get(), FireflyTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(CICADA.get(), CicadaTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(MOONWORM.get(), MoonwormTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(TROPHY.get(), TrophyTileEntityRenderer::new);
		BlockEntityRenderers.register(TF_SIGN.get(), SignRenderer::new);
		BlockEntityRendererRegistry.register(KEEPSAKE_CASKET.get(), CasketTileEntityRenderer::new);
		BlockEntityRendererRegistry.register(SKULL_CANDLE.get(), SkullCandleTileEntityRenderer::new);

		registerTileEntitysItemRenders();
	}

	public static void registerTileEntitysItemRenders() {
		List<AbstractTrophyBlock> TROPHYS = List.of(TFBlocks.NAGA_TROPHY.get(), TFBlocks.LICH_TROPHY.get(), TFBlocks.MINOSHROOM_TROPHY.get(),
				TFBlocks.HYDRA_TROPHY.get(), TFBlocks.KNIGHT_PHANTOM_TROPHY.get(), TFBlocks.UR_GHAST_TROPHY.get(), TFBlocks.ALPHA_YETI_TROPHY.get(),
				TFBlocks.SNOW_QUEEN_TROPHY.get(), TFBlocks.QUEST_RAM_TROPHY.get());

		List<AbstractSkullCandleBlock> SKULLCANDLES = List.of(TFBlocks.ZOMBIE_SKULL_CANDLE.get(), TFBlocks.SKELETON_SKULL_CANDLE.get(),
				TFBlocks.WITHER_SKELE_SKULL_CANDLE.get(), TFBlocks.CREEPER_SKULL_CANDLE.get(), TFBlocks.PLAYER_SKULL_CANDLE.get());

		for(AbstractTrophyBlock block : TROPHYS){
			BuiltinItemRendererRegistry.INSTANCE.register(block, (itemStack, transform, stack, source, light, overlay) -> {
				new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.TROPHY.get())).renderByItem(itemStack, transform, stack, source, light, overlay);
			});
		}

		for(AbstractSkullCandleBlock block : SKULLCANDLES){
			BuiltinItemRendererRegistry.INSTANCE.register(block, (itemStack, transform, stack, source, light, overlay) -> {
				new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.SKULL_CANDLE.get())).renderByItem(itemStack, transform, stack, source, light, overlay);
			});
		}

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.CICADA.get(), (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.CICADA.get())).renderByItem(itemStack, transform, stack, source, light, overlay);
		});

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.FIREFLY.get(), (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.FIREFLY.get())).renderByItem(itemStack, transform, stack, source, light, overlay);
		});

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.MOONWORM.get(), (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.MOONWORM.get())).renderByItem(itemStack, transform, stack, source, light, overlay);
		});

		BuiltinItemRendererRegistry.INSTANCE.register(TFBlocks.KEEPSAKE_CASKET.get(), (itemStack, transform, stack, source, light, overlay) -> {
			new ISTER(Registry.BLOCK_ENTITY_TYPE.getKey(TFBlockEntities.KEEPSAKE_CASKET.get())).renderByItem(itemStack, transform, stack, source, light, overlay);
		});
	}

}