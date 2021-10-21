package twilightforest.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.SharedConstants;
import net.minecraft.client.model.SilverfishModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;

import twilightforest.TwilightForestMod;
import twilightforest.client.model.TFModelLayers;
import twilightforest.client.model.entity.*;
import twilightforest.client.renderer.entity.*;
import twilightforest.entity.boss.*;
import twilightforest.entity.monster.*;
import twilightforest.entity.passive.*;
import twilightforest.entity.projectile.*;
import twilightforest.item.TFItems;
import twilightforest.item.TransformPowderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TFEntities {

	public static final SpawnPlacements.Type ON_ICE = SpawnPlacements.Type.ON_GROUND;//SpawnPlacements.Type.valueOf("TF_ON_ICE");

	public static final SpawnPlacements.Type CLOUDS = SpawnPlacements.Type.NO_RESTRICTIONS;
//	public static final SpawnPlacements.Type CLOUDS = SpawnPlacements.Type.create("CLOUD_DWELLERS", (world, pos, entityType) -> {
//		BlockState state = world.getBlockState(pos.below());
//		Block block = state.getBlock();
//		BlockPos up = pos.above();
//		return (block == TFBlocks.WISPY_CLOUD.get() || block == TFBlocks.FLUFFY_CLOUD.get()) && block != Blocks.BEDROCK && block != Blocks.BARRIER && NaturalSpawner.isValidEmptySpawnBlock(world, pos, world.getBlockState(pos), world.getFluidState(pos), entityType) && NaturalSpawner.isValidEmptySpawnBlock(world, up, world.getBlockState(up), world.getFluidState(up), entityType);
//	});

	private static final List<EntityType<?>> ALL = new ArrayList<>();
	public static final EntityType<Boar> BOAR = make(TFEntityNames.BOAR, Boar::new, MobCategory.CREATURE, 0.9F, 0.9F);
	public static final EntityType<Bighorn> BIGHORN_SHEEP = make(TFEntityNames.BIGHORN_SHEEP, Bighorn::new, MobCategory.CREATURE, 0.9F, 1.3F);
	public static final EntityType<Deer> DEER = make(TFEntityNames.DEER, Deer::new, MobCategory.CREATURE, 0.7F, 1.8F);
	public static final EntityType<Redcap> REDCAP = make(TFEntityNames.REDCAP, Redcap::new, MobCategory.MONSTER, 0.9F, 1.4F);
	public static final EntityType<SwarmSpider> SWARM_SPIDER = make(TFEntityNames.SWARM_SPIDER, SwarmSpider::new, MobCategory.MONSTER, 0.8F, 0.4F);
	public static final EntityType<Naga> NAGA = make(TFEntityNames.NAGA, Naga::new, MobCategory.MONSTER, 1.75f, 3.0f);
	public static final EntityType<SkeletonDruid> SKELETON_DRUID = make(TFEntityNames.SKELETON_DRUID, SkeletonDruid::new, MobCategory.MONSTER, 0.6F, 1.99F);
	public static final EntityType<HostileWolf> HOSTILE_WOLF = make(TFEntityNames.HOSTILE_WOLF, HostileWolf::new, MobCategory.MONSTER, 0.6F, 0.85F);
	public static final EntityType<Wraith> WRAITH = make(TFEntityNames.WRAITH, Wraith::new, MobCategory.MONSTER);
	public static final EntityType<HedgeSpider> HEDGE_SPIDER = make(TFEntityNames.HEDGE_SPIDER, HedgeSpider::new, MobCategory.MONSTER, 1.4F, 0.9F);
	public static final EntityType<Hydra> HYDRA = make(TFEntityNames.HYDRA, Hydra::new, MobCategory.MONSTER, 16F, 12F);
	public static final EntityType<Lich> LICH = make(TFEntityNames.LICH, Lich::new, MobCategory.MONSTER, 1.1F, 2.1F);
	public static final EntityType<Penguin> PENGUIN = make(TFEntityNames.PENGUIN, Penguin::new, MobCategory.CREATURE, 0.5F, 0.9F);
	public static final EntityType<LichMinion> LICH_MINION = make(TFEntityNames.LICH_MINION, LichMinion::new, MobCategory.MONSTER, 0.6F, 1.95F);
	public static final EntityType<LoyalZombie> LOYAL_ZOMBIE = make(TFEntityNames.LOYAL_ZOMBIE, LoyalZombie::new, MobCategory.MONSTER);
	public static final EntityType<TinyBird> TINY_BIRD = make(TFEntityNames.TINY_BIRD, TinyBird::new, MobCategory.CREATURE, 0.3F, 0.3F);
	public static final EntityType<Squirrel> SQUIRREL = make(TFEntityNames.SQUIRREL, Squirrel::new, MobCategory.CREATURE, 0.3F, 0.5F);
	public static final EntityType<DwarfRabbit> DWARF_RABBIT = make(TFEntityNames.DWARF_RABBIT, DwarfRabbit::new, MobCategory.CREATURE, 0.4F, 0.4F);
	public static final EntityType<Raven> RAVEN = make(TFEntityNames.RAVEN, Raven::new, MobCategory.CREATURE, 0.3F, 0.5F);
	public static final EntityType<QuestRam> QUEST_RAM = make(TFEntityNames.QUEST_RAM, QuestRam::new, MobCategory.CREATURE, 1.25F, 2.9F);
	public static final EntityType<Kobold> KOBOLD = make(TFEntityNames.KOBOLD, Kobold::new, MobCategory.MONSTER, 0.8F, 1.1F);
	public static final EntityType<MosquitoSwarm> MOSQUITO_SWARM = make(TFEntityNames.MOSQUITO_SWARM, MosquitoSwarm::new, MobCategory.MONSTER, 0.7F, 1.9F);
	public static final EntityType<DeathTome> DEATH_TOME = make(TFEntityNames.DEATH_TOME, DeathTome::new, MobCategory.MONSTER);
	public static final EntityType<Minotaur> MINOTAUR = make(TFEntityNames.MINOTAUR, Minotaur::new, MobCategory.MONSTER, 0.6F, 2.1F);
	public static final EntityType<Minoshroom> MINOSHROOM = make(TFEntityNames.MINOSHROOM, Minoshroom::new, MobCategory.MONSTER, 1.49F, 2.5F);
	public static final EntityType<FireBeetle> FIRE_BEETLE = make(TFEntityNames.FIRE_BEETLE, FireBeetle::new, MobCategory.MONSTER, 1.1F, 0.5F);
	public static final EntityType<SlimeBeetle> SLIME_BEETLE = make(TFEntityNames.SLIME_BEETLE, SlimeBeetle::new, MobCategory.MONSTER, 0.9F, 0.5F);
	public static final EntityType<PinchBeetle> PINCH_BEETLE = make(TFEntityNames.PINCH_BEETLE, PinchBeetle::new, MobCategory.MONSTER, 1.2F, 0.5F);
	public static final EntityType<MazeSlime> MAZE_SLIME = make(TFEntityNames.MAZE_SLIME, MazeSlime::new, MobCategory.MONSTER, 2.04F, 2.04F);
	public static final EntityType<RedcapSapper> REDCAP_SAPPER = make(TFEntityNames.REDCAP_SAPPER, RedcapSapper::new, MobCategory.MONSTER, 0.9F, 1.4F);
	public static final EntityType<MistWolf> MIST_WOLF = make(TFEntityNames.MIST_WOLF, MistWolf::new, MobCategory.MONSTER, 1.4F, 1.9F);
	public static final EntityType<KingSpider> KING_SPIDER = make(TFEntityNames.KING_SPIDER, KingSpider::new, MobCategory.MONSTER, 1.6F, 1.6F);
	public static final EntityType<CarminiteGhastling> CARMINITE_GHASTLING = make(TFEntityNames.CARMINITE_GHASTLING, CarminiteGhastling::new, MobCategory.MONSTER, 1.1F, 1.5F);
	public static final EntityType<CarminiteGhastguard> CARMINITE_GHASTGUARD = make(TFEntityNames.CARMINITE_GHASTGUARD, CarminiteGhastguard::new, MobCategory.MONSTER, 4.0F, 6.0F);
	public static final EntityType<CarminiteGolem> CARMINITE_GOLEM = make(TFEntityNames.CARMINITE_GOLEM, CarminiteGolem::new, MobCategory.MONSTER, 1.4F, 2.9F);
	public static final EntityType<TowerwoodBorer> TOWERWOOD_BORER = make(TFEntityNames.TOWERWOOD_BORER, TowerwoodBorer::new, MobCategory.MONSTER, 0.4F, 0.3F);
	public static final EntityType<TowerBroodling> CARMINITE_BROODLING = make(TFEntityNames.CARMINITE_BROODLING, TowerBroodling::new, MobCategory.MONSTER, 0.7F, 0.5F);
	public static final EntityType<UrGhast> UR_GHAST = make(TFEntityNames.UR_GHAST, UrGhast::new, MobCategory.MONSTER, 14.0F, 18.0F);
	public static final EntityType<BlockChainGoblin> BLOCKCHAIN_GOBLIN = make(TFEntityNames.BLOCKCHAIN_GOBLIN, BlockChainGoblin::new, MobCategory.MONSTER, 0.9F, 1.4F);
	public static final EntityType<UpperGoblinKnight> UPPER_GOBLIN_KNIGHT = make(TFEntityNames.UPPER_GOBLIN_KNIGHT, UpperGoblinKnight::new, MobCategory.MONSTER, 1.1F, 1.3F);
	public static final EntityType<LowerGoblinKnight> LOWER_GOBLIN_KNIGHT = make(TFEntityNames.LOWER_GOBLIN_KNIGHT, LowerGoblinKnight::new, MobCategory.MONSTER, 0.7F, 1.1F);
	public static final EntityType<HelmetCrab> HELMET_CRAB = make(TFEntityNames.HELMET_CRAB, HelmetCrab::new, MobCategory.MONSTER, 0.8F, 1.1F);
	public static final EntityType<KnightPhantom> KNIGHT_PHANTOM = make(TFEntityNames.KNIGHT_PHANTOM, KnightPhantom::new, MobCategory.MONSTER, 1.5F, 3.0F);
	public static final EntityType<Yeti> YETI = make(TFEntityNames.YETI, Yeti::new, MobCategory.MONSTER, 1.4F, 2.4F);
	public static final EntityType<AlphaYeti> ALPHA_YETI = make(TFEntityNames.ALPHA_YETI, AlphaYeti::new, MobCategory.MONSTER, 3.8F, 5.0F);
	public static final EntityType<WinterWolf> WINTER_WOLF = make(TFEntityNames.WINTER_WOLF, WinterWolf::new, MobCategory.MONSTER, 1.4F, 1.9F);
	public static final EntityType<SnowGuardian> SNOW_GUARDIAN = make(TFEntityNames.SNOW_GUARDIAN, SnowGuardian::new, MobCategory.MONSTER, 0.6F, 1.8F);
	public static final EntityType<StableIceCore> STABLE_ICE_CORE = make(TFEntityNames.STABLE_ICE_CORE, StableIceCore::new, MobCategory.MONSTER, 0.8F, 1.8F);
	public static final EntityType<UnstableIceCore> UNSTABLE_ICE_CORE = make(TFEntityNames.UNSTABLE_ICE_CORE, UnstableIceCore::new, MobCategory.MONSTER, 0.8F, 1.8F);
	public static final EntityType<SnowQueen> SNOW_QUEEN = make(TFEntityNames.SNOW_QUEEN, SnowQueen::new, MobCategory.MONSTER, 0.7F, 2.2F);
	public static final EntityType<Troll> TROLL = make(TFEntityNames.TROLL, Troll::new, MobCategory.MONSTER, 1.4F, 2.4F);
	public static final EntityType<GiantMiner> GIANT_MINER = make(TFEntityNames.GIANT_MINER, GiantMiner::new, MobCategory.MONSTER, 2.4F, 7.2F);
	public static final EntityType<ArmoredGiant> ARMORED_GIANT = make(TFEntityNames.ARMORED_GIANT, ArmoredGiant::new, MobCategory.MONSTER, 2.4F, 7.2F);
	public static final EntityType<IceCrystal> ICE_CRYSTAL = make(TFEntityNames.ICE_CRYSTAL, IceCrystal::new, MobCategory.MONSTER, 0.6F, 1.8F);
	public static final EntityType<HarbingerCube> HARBINGER_CUBE = make(TFEntityNames.HARBINGER_CUBE, HarbingerCube::new, MobCategory.MONSTER, 1.9F, 2.4F);
	public static final EntityType<Adherent> ADHERENT = make(TFEntityNames.ADHERENT, Adherent::new, MobCategory.MONSTER, 0.8F, 2.2F);
	public static final EntityType<RovingCube> ROVING_CUBE = make(TFEntityNames.ROVING_CUBE, RovingCube::new, MobCategory.MONSTER, 1.2F, 2.1F);
	//public static final EntityType<EntityTFCastleGuardian> CASTLE_GUARDIAN = make(TFEntityNames.CASTLE_GUARDIAN, EntityTFCastleGuardian::new, EntityClassification.MONSTER, 1.8F, 2.4F);
	public static final EntityType<PlateauBoss> PLATEAU_BOSS = make(TFEntityNames.PLATEAU_BOSS, PlateauBoss::new, MobCategory.MONSTER, 1F, 1F);

	public static final EntityType<NatureBolt> NATURE_BOLT = build(TFEntityNames.NATURE_BOLT, makeCastedBuilder(NatureBolt.class, NatureBolt::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*//*.setUpdateInterval(5)*/);
	public static final EntityType<LichBolt> LICH_BOLT = build(TFEntityNames.LICH_BOLT, makeCastedBuilder(LichBolt.class, LichBolt::new, MobCategory.MISC).sized(0.25F, 0.25F)/*/*.setTrackingRange(150)*//*/*.setUpdateInterval(2)*/);
	public static final EntityType<TwilightWandBolt> WAND_BOLT = build(TFEntityNames.WAND_BOLT, makeCastedBuilder(TwilightWandBolt.class, TwilightWandBolt::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*//*.setUpdateInterval(5)*/);
	public static final EntityType<TomeBolt> TOME_BOLT = build(TFEntityNames.TOME_BOLT, makeCastedBuilder(TomeBolt.class, TomeBolt::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*//*.setUpdateInterval(5)*/);
	public static final EntityType<HydraMortarHead> HYDRA_MORTAR = build(TFEntityNames.HYDRA_MORTAR, makeCastedBuilder(HydraMortarHead.class, HydraMortarHead::new, MobCategory.MISC).sized(0.75F, 0.75F)/*.setTrackingRange(150)*/);
	public static final EntityType<LichBomb> LICH_BOMB = build(TFEntityNames.LICH_BOMB, makeCastedBuilder(LichBomb.class, LichBomb::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*/);
	public static final EntityType<MoonwormShot> MOONWORM_SHOT = build(TFEntityNames.MOONWORM_SHOT, makeCastedBuilder(MoonwormShot.class, MoonwormShot::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*/);
	public static final EntityType<CicadaShot> CICADA_SHOT = build(TFEntityNames.CICADA_SHOT, makeCastedBuilder(CicadaShot.class, CicadaShot::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*/);
	public static final EntityType<SlimeProjectile> SLIME_BLOB = build(TFEntityNames.SLIME_BLOB, makeCastedBuilder(SlimeProjectile.class, SlimeProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*/);
	public static final EntityType<CharmEffect> CHARM_EFFECT = make(TFEntityNames.CHARM_EFFECT, CharmEffect::new, MobCategory.MISC, 0.25F, 0.25F);
	public static final EntityType<ThrownWep> THROWN_WEP = make(TFEntityNames.THROWN_WEP, ThrownWep::new, MobCategory.MISC, 0.5F, 0.5F);
	public static final EntityType<FallingIce> FALLING_ICE = make(TFEntityNames.FALLING_ICE, FallingIce::new, MobCategory.MISC, 2.98F, 2.98F);
	public static final EntityType<IceBomb> THROWN_ICE = build(TFEntityNames.THROWN_ICE, makeCastedBuilder(IceBomb.class, IceBomb::new, MobCategory.MISC).sized(1.0F, 1.0F)/*.setUpdateInterval(2)*/);
	public static final EntityType<SeekerArrow> SEEKER_ARROW = build(TFEntityNames.SEEKER_ARROW, makeCastedBuilder(SeekerArrow.class, SeekerArrow::new, MobCategory.MISC).sized(0.5F, 0.5F)/*.setTrackingRange(150)*//*.setUpdateInterval(1)*/);
	public static final EntityType<IceArrow> ICE_ARROW = build(TFEntityNames.ICE_ARROW, makeCastedBuilder(IceArrow.class, IceArrow::new, MobCategory.MISC).sized(0.5F, 0.5F)/*.setTrackingRange(150)*//*.setUpdateInterval(1)*/);
	public static final EntityType<IceSnowball> ICE_SNOWBALL = build(TFEntityNames.ICE_SNOWBALL, makeCastedBuilder(IceSnowball.class, IceSnowball::new, MobCategory.MISC).sized(0.25F, 0.25F)/*.setTrackingRange(150)*/);
	public static final EntityType<ChainBlock> CHAIN_BLOCK = build(TFEntityNames.CHAIN_BLOCK, makeCastedBuilder(ChainBlock.class, ChainBlock::new, MobCategory.MISC).sized(0.6F, 0.6F)/*.setUpdateInterval(1)*/);
	public static final EntityType<CubeOfAnnihilation> CUBE_OF_ANNIHILATION = build(TFEntityNames.CUBE_OF_ANNIHILATION, makeCastedBuilder(CubeOfAnnihilation.class, CubeOfAnnihilation::new, MobCategory.MISC).sized(1F, 1F)/*.setUpdateInterval(1)*/);
	public static final EntityType<SlideBlock> SLIDER = build(TFEntityNames.SLIDER, makeCastedBuilder(SlideBlock.class, SlideBlock::new, MobCategory.MISC).sized(0.98F, 0.98F)/*.setUpdateInterval(1)*/);
	//public static final EntityType<EntityTFBoggard> BOGGARD = make(TFEntityNames.BOGGARD, EntityTFBoggard::new, EntityClassification.MONSTER, 0.8F, 1.1F);
	public static final EntityType<RisingZombie> RISING_ZOMBIE = make(TFEntityNames.RISING_ZOMBIE, RisingZombie::new, MobCategory.MONSTER, 0.6F, 1.95F);
	public static final EntityType<ProtectionBox> PROTECTION_BOX = build(TFEntityNames.PROTECTION_BOX, makeCastedBuilder(ProtectionBox.class, ProtectionBox::new, MobCategory.MISC).noSave().noSummon().sized(0, 0));

	private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height) {
		return build(id, makeBuilder(factory, classification).sized(width, height));
	}

	private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification) {
		return make(id, factory, classification, 0.6F, 1.8F);
	}

	@SuppressWarnings("unchecked")
	private static <E extends Entity> EntityType<E> build(ResourceLocation id, EntityType.Builder<E> builder) {
		boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
		SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
		EntityType<E> ret = Registry.register(Registry.ENTITY_TYPE, id,builder.build(id.toString()));
		SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
		ALL.add(ret);
		return ret;
	}

	private static <E extends Entity> EntityType.Builder<E> makeCastedBuilder(@SuppressWarnings("unused") Class<E> cast, EntityType.EntityFactory<E> factory, MobCategory classification) {
		return makeBuilder(factory, classification);
	}

	private static <E extends Entity> EntityType.Builder<E> makeBuilder(EntityType.EntityFactory<E> factory, MobCategory classification) {
		return EntityType.Builder.of(factory, classification).
				sized(0.6F, 1.8F);
				/*setTrackingRange(80).
				setUpdateInterval(3).
				setShouldReceiveVelocityUpdates(true);*/
	}

	private static Item spawnEgg(EntityType<? extends Mob> type, int color, int color2) {
		ResourceLocation eggId = new ResourceLocation(Registry.ENTITY_TYPE.getKey(type).getNamespace(), Registry.ENTITY_TYPE.getKey(type).getPath() + "_spawn_egg");
		return Registry.register(Registry.ITEM, eggId, new SpawnEggItem(type, color, color2, TFItems.defaultBuilder()));
	}

	public static void registerSpawnEggs() {
		spawnEgg(ADHERENT, 0x0a0000, 0x00008b);
		spawnEgg(ALPHA_YETI, 0xcdcdcd, 0x29486e);
		spawnEgg(ARMORED_GIANT, 0x239391, 0x9a9a9a);
		spawnEgg(BIGHORN_SHEEP, 0xdbceaf, 0xd7c771);
		spawnEgg(BLOCKCHAIN_GOBLIN, 0xd3e7bc, 0x1f3fff);
		spawnEgg(CARMINITE_BROODLING, 0x343c14, 0xbaee02);
		spawnEgg(CARMINITE_GHASTGUARD, 0xbcbcbc, 0xb77878);
		spawnEgg(CARMINITE_GHASTLING, 0xbcbcbc, 0xa74343);
		spawnEgg(CARMINITE_GOLEM, 0x6b3d20, 0xe2ddda);
		spawnEgg(TROLL, 0x9ea98f, 0xb0948e);
		spawnEgg(DEATH_TOME, 0x774e22, 0xdbcdbe);
		spawnEgg(DEER, 0x7b4d2e, 0x4b241d);
		spawnEgg(DWARF_RABBIT, 0xfefeee, 0xccaa99);
		spawnEgg(FIRE_BEETLE, 0x1d0b00, 0xcb6f25);
		spawnEgg(SQUIRREL, 0x904f12, 0xeeeeee);
		spawnEgg(GIANT_MINER, 0x211b52, 0x9a9a9a);
		spawnEgg(LOWER_GOBLIN_KNIGHT, 0x566055, 0xd3e7bc);
		spawnEgg(HARBINGER_CUBE, 0x00000a, 0x8b0000);
		spawnEgg(HEDGE_SPIDER, 0x235f13, 0x562653);
		spawnEgg(HELMET_CRAB, 0xfb904b, 0xd3e7bc);
		spawnEgg(HOSTILE_WOLF, 0xd7d3d3, 0xab1e14);
		spawnEgg(HYDRA, 0x142940, 0x29806b);
		spawnEgg(ICE_CRYSTAL, 0xdce9fe, 0xadcafb);
		spawnEgg(KING_SPIDER, 0x2c1a0e, 0xffc017);
		spawnEgg(KNIGHT_PHANTOM, 0xa6673b, 0xd3e7bc);
		spawnEgg(KOBOLD, 0x372096, 0x895d1b);
		spawnEgg(MAZE_SLIME, 0xa3a3a3, 0x2a3b17);
		spawnEgg(MINOSHROOM, 0xa81012, 0xaa7d66);
		spawnEgg(MINOTAUR, 0x3f3024, 0xaa7d66);
		spawnEgg(MIST_WOLF, 0x3a1411, 0xe2c88a);
		spawnEgg(MOSQUITO_SWARM, 0x080904, 0x2d2f21);
		spawnEgg(NAGA, 0xa4d316, 0x1b380b);
		spawnEgg(PENGUIN, 0x12151b, 0xf9edd2);
		spawnEgg(PINCH_BEETLE, 0xbc9327, 0x241609);
		spawnEgg(QUEST_RAM, 0xfefeee, 0x33aadd);
		spawnEgg(RAVEN, 0x000011, 0x222233);
		spawnEgg(REDCAP, 0x3b3a6c, 0xab1e14);
		spawnEgg(REDCAP_SAPPER, 0x575d21, 0xab1e14);
		spawnEgg(ROVING_CUBE, 0x0a0000, 0x00009b);
		spawnEgg(SKELETON_DRUID, 0xa3a3a3, 0x2a3b17);
		spawnEgg(SLIME_BEETLE, 0x0c1606, 0x60a74c);
		spawnEgg(SNOW_GUARDIAN, 0xd3e7bc, 0xfefefe);
		spawnEgg(SNOW_QUEEN, 0xb1b2d4, 0x87006e);
		spawnEgg(STABLE_ICE_CORE, 0xa1bff3, 0x7000f8);
		spawnEgg(SWARM_SPIDER, 0x32022e, 0x17251e);
		spawnEgg(TINY_BIRD, 0x33aadd, 0x1188ee);
		spawnEgg(TOWERWOOD_BORER, 0x5d2b21, 0xaca03a);
		spawnEgg(LICH, 0xaca489, 0x360472);
		spawnEgg(UNSTABLE_ICE_CORE, 0x9aacf5, 0x9b0fa5);
		spawnEgg(UR_GHAST, 0xbcbcbc, 0xb77878);
		spawnEgg(BOAR, 0x83653b, 0xffefca);
		spawnEgg(WINTER_WOLF, 0xdfe3e5, 0xb2bcca);
		spawnEgg(WRAITH, 0x505050, 0x838383);
		spawnEgg(YETI, 0xdedede, 0x4675bb);
	}

	public static void registerEntities() {
		((TransformPowderItem) TFItems.TRANSFORMATION_POWDER).initTransformations();

		SpawnPlacements.register(BOAR, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(BIGHORN_SHEEP, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(DEER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(REDCAP, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(SKELETON_DRUID, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SkeletonDruid::skeletonDruidSpawnHandler);
		SpawnPlacements.register(WRAITH, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Wraith::getCanSpawnHere);
		SpawnPlacements.register(HYDRA, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(LICH, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(PENGUIN, ON_ICE, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Penguin::canSpawn);
		SpawnPlacements.register(LICH_MINION, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(LOYAL_ZOMBIE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(TINY_BIRD, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(SQUIRREL, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(DWARF_RABBIT, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(RAVEN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(QUEST_RAM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(KOBOLD, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MOSQUITO_SWARM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
		SpawnPlacements.register(DEATH_TOME, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MINOTAUR, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MINOSHROOM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(FIRE_BEETLE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(SLIME_BEETLE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(PINCH_BEETLE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MIST_WOLF, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HostileWolf::getCanSpawnHere);
		SpawnPlacements.register(CARMINITE_GHASTLING, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastling::canSpawnHere);
		SpawnPlacements.register(CARMINITE_GOLEM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(TOWERWOOD_BORER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(CARMINITE_GHASTGUARD, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastguard::ghastSpawnHandler);
		SpawnPlacements.register(UR_GHAST, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(BLOCKCHAIN_GOBLIN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(UPPER_GOBLIN_KNIGHT, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(LOWER_GOBLIN_KNIGHT, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(HELMET_CRAB, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(KNIGHT_PHANTOM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(NAGA, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(SWARM_SPIDER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SwarmSpider::getCanSpawnHere);
		SpawnPlacements.register(KING_SPIDER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(CARMINITE_BROODLING, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SwarmSpider::getCanSpawnHere);
		SpawnPlacements.register(HEDGE_SPIDER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HedgeSpider::canSpawn);
		SpawnPlacements.register(REDCAP_SAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MAZE_SLIME, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MazeSlime::getCanSpawnHere);
		SpawnPlacements.register(YETI, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Yeti::yetiSnowyForestSpawnHandler);
		SpawnPlacements.register(ALPHA_YETI, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(WINTER_WOLF, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WinterWolf::canSpawnHere);
		SpawnPlacements.register(SNOW_GUARDIAN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(STABLE_ICE_CORE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(UNSTABLE_ICE_CORE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(SNOW_QUEEN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(TROLL, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Troll::canSpawn);
		SpawnPlacements.register(GIANT_MINER, CLOUDS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantMiner::canSpawn);
		SpawnPlacements.register(ARMORED_GIANT, CLOUDS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantMiner::canSpawn);
		SpawnPlacements.register(ICE_CRYSTAL, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(HARBINGER_CUBE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
		SpawnPlacements.register(ADHERENT, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(ROVING_CUBE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
		SpawnPlacements.register(RISING_ZOMBIE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);

		//EntitySpawnPlacementRegistry.register(CASTLE_GUARDIAN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
	}

	public static void addEntityAttributes() {
		FabricDefaultAttributeRegistry.register(BOAR, Pig.createAttributes());
		FabricDefaultAttributeRegistry.register(BIGHORN_SHEEP, Sheep.createAttributes());
		FabricDefaultAttributeRegistry.register(DEER, Deer.registerAttributes());
		FabricDefaultAttributeRegistry.register(REDCAP, Redcap.registerAttributes());
		FabricDefaultAttributeRegistry.register(SWARM_SPIDER, SwarmSpider.registerAttributes());
		FabricDefaultAttributeRegistry.register(NAGA, Naga.registerAttributes());
		FabricDefaultAttributeRegistry.register(SKELETON_DRUID, AbstractSkeleton.createAttributes());
		FabricDefaultAttributeRegistry.register(HOSTILE_WOLF, HostileWolf.registerAttributes());
		FabricDefaultAttributeRegistry.register(WRAITH, Wraith.registerAttributes());
		FabricDefaultAttributeRegistry.register(HEDGE_SPIDER, Spider.createAttributes());
		FabricDefaultAttributeRegistry.register(HYDRA, Hydra.registerAttributes());
		FabricDefaultAttributeRegistry.register(LICH, Lich.registerAttributes());
		FabricDefaultAttributeRegistry.register(PENGUIN, Penguin.registerAttributes());
		FabricDefaultAttributeRegistry.register(LICH_MINION, Zombie.createAttributes());
		FabricDefaultAttributeRegistry.register(LOYAL_ZOMBIE, LoyalZombie.registerAttributes());
		FabricDefaultAttributeRegistry.register(TINY_BIRD, TinyBird.registerAttributes());
		FabricDefaultAttributeRegistry.register(SQUIRREL, Squirrel.registerAttributes());
		FabricDefaultAttributeRegistry.register(DWARF_RABBIT, DwarfRabbit.registerAttributes());
		FabricDefaultAttributeRegistry.register(RAVEN, Raven.registerAttributes());
		FabricDefaultAttributeRegistry.register(QUEST_RAM, QuestRam.registerAttributes());
		FabricDefaultAttributeRegistry.register(KOBOLD, Kobold.registerAttributes());
		FabricDefaultAttributeRegistry.register(MOSQUITO_SWARM, MosquitoSwarm.registerAttributes());
		FabricDefaultAttributeRegistry.register(DEATH_TOME, DeathTome.registerAttributes());
		FabricDefaultAttributeRegistry.register(MINOTAUR, Minotaur.registerAttributes());
		FabricDefaultAttributeRegistry.register(MINOSHROOM, Minoshroom.registerAttributes());
		FabricDefaultAttributeRegistry.register(FIRE_BEETLE, FireBeetle.registerAttributes());
		FabricDefaultAttributeRegistry.register(SLIME_BEETLE, SlimeBeetle.registerAttributes());
		FabricDefaultAttributeRegistry.register(PINCH_BEETLE, PinchBeetle.registerAttributes());
		FabricDefaultAttributeRegistry.register(MAZE_SLIME, MazeSlime.registerAttributes());
		FabricDefaultAttributeRegistry.register(REDCAP_SAPPER, RedcapSapper.registerAttributes());
		FabricDefaultAttributeRegistry.register(MIST_WOLF, MistWolf.registerAttributes());
		FabricDefaultAttributeRegistry.register(KING_SPIDER, KingSpider.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_GHASTLING, CarminiteGhastling.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_GHASTGUARD, CarminiteGhastguard.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_GOLEM, CarminiteGolem.registerAttributes());
		FabricDefaultAttributeRegistry.register(TOWERWOOD_BORER, TowerwoodBorer.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_BROODLING, TowerBroodling.registerAttributes());
		FabricDefaultAttributeRegistry.register(UR_GHAST, UrGhast.registerAttributes());
		FabricDefaultAttributeRegistry.register(BLOCKCHAIN_GOBLIN, BlockChainGoblin.registerAttributes());
		FabricDefaultAttributeRegistry.register(UPPER_GOBLIN_KNIGHT, UpperGoblinKnight.registerAttributes());
		FabricDefaultAttributeRegistry.register(LOWER_GOBLIN_KNIGHT, LowerGoblinKnight.registerAttributes());
		FabricDefaultAttributeRegistry.register(HELMET_CRAB, HelmetCrab.registerAttributes());
		FabricDefaultAttributeRegistry.register(KNIGHT_PHANTOM, KnightPhantom.registerAttributes());
		FabricDefaultAttributeRegistry.register(YETI, Yeti.registerAttributes());
		FabricDefaultAttributeRegistry.register(ALPHA_YETI, AlphaYeti.registerAttributes());
		FabricDefaultAttributeRegistry.register(WINTER_WOLF, WinterWolf.registerAttributes());
		FabricDefaultAttributeRegistry.register(SNOW_GUARDIAN, SnowGuardian.registerAttributes());
		FabricDefaultAttributeRegistry.register(STABLE_ICE_CORE, StableIceCore.registerAttributes());
		FabricDefaultAttributeRegistry.register(UNSTABLE_ICE_CORE, UnstableIceCore.registerAttributes());
		FabricDefaultAttributeRegistry.register(SNOW_QUEEN, SnowQueen.registerAttributes());
		FabricDefaultAttributeRegistry.register(TROLL, Troll.registerAttributes());
		FabricDefaultAttributeRegistry.register(GIANT_MINER, GiantMiner.registerAttributes());
		FabricDefaultAttributeRegistry.register(ARMORED_GIANT, GiantMiner.registerAttributes());
		FabricDefaultAttributeRegistry.register(ICE_CRYSTAL, IceCrystal.registerAttributes());
		FabricDefaultAttributeRegistry.register(HARBINGER_CUBE, HarbingerCube.registerAttributes());
		FabricDefaultAttributeRegistry.register(ADHERENT, Adherent.registerAttributes());
		FabricDefaultAttributeRegistry.register(ROVING_CUBE, RovingCube.registerAttributes());
		//FabricDefaultAttributeRegistry.register(CASTLE_GUARDIAN, MobEntity.createMobAttributes().create());
		FabricDefaultAttributeRegistry.register(PLATEAU_BOSS, PlateauBoss.registerAttributes());

		//FabricDefaultAttributeRegistry.register(BOGGARD, EntityTFBoggard.registerAttributes().create());
		FabricDefaultAttributeRegistry.register(RISING_ZOMBIE, Zombie.createAttributes());
	}

	@Environment(EnvType.CLIENT)
	public static class EntityRenderers {
		public static void registerEntityRenderer() {
			EntityRendererRegistry.register(BOAR, m -> new BoarRenderer(m, new BoarModel<>(m.bakeLayer(TFModelLayers.BOAR))));
			EntityRendererRegistry.register(BIGHORN_SHEEP, m -> new BighornRenderer(m, new BighornModel<>(m.bakeLayer(TFModelLayers.BIGHORN_SHEEP)), new BighornFurLayer(m.bakeLayer(TFModelLayers.BIGHORN_SHEEP_FUR)), 0.7F));
			EntityRendererRegistry.register(DEER, m -> new TFGenericMobRenderer<>(m, new DeerModel(m.bakeLayer(TFModelLayers.DEER)), 0.7F, "wilddeer.png"));
			EntityRendererRegistry.register(REDCAP, m -> new TFBipedRenderer<>(m, new RedcapModel<>(m.bakeLayer(TFModelLayers.REDCAP)), new RedcapModel<>(m.bakeLayer(TFModelLayers.REDCAP_ARMOR_INNER)), new RedcapModel<>(m.bakeLayer(TFModelLayers.REDCAP_ARMOR_OUTER)), 0.4F, "redcap.png"));
			EntityRendererRegistry.register(SKELETON_DRUID, m -> new TFBipedRenderer<>(m, new SkeletonDruidModel(m.bakeLayer(TFModelLayers.SKELETON_DRUID)), new SkeletonDruidModel(m.bakeLayer(TFModelLayers.SKELETON_DRUID_INNER_ARMOR)), new SkeletonDruidModel(m.bakeLayer(TFModelLayers.SKELETON_DRUID_OUTER_ARMOR)), 0.5F, "skeletondruid.png"));
			EntityRendererRegistry.register(HOSTILE_WOLF, WolfRenderer::new);
			EntityRendererRegistry.register(WRAITH, m -> new WraithRenderer(m, new WraithModel(m.bakeLayer(TFModelLayers.WRAITH)), 0.5F));
			EntityRendererRegistry.register(HYDRA, m -> new HydraRenderer(m, new HydraModel(m.bakeLayer(TFModelLayers.HYDRA)), 4.0F));
			EntityRendererRegistry.register(LICH, m -> new LichRenderer(m, new LichModel(m.bakeLayer(TFModelLayers.LICH)), 0.6F));
			EntityRendererRegistry.register(PENGUIN, m -> new BirdRenderer<>(m, new PenguinModel(m.bakeLayer(TFModelLayers.PENGUIN)), 0.375F, "penguin.png"));
			EntityRendererRegistry.register(LICH_MINION, m -> new TFBipedRenderer<>(m, new LichMinionModel(m.bakeLayer(TFModelLayers.LICH_MINION)), new LichMinionModel(m.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)), new LichMinionModel(m.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR)), 0.5F, "textures/entity/zombie/zombie.png"));
			EntityRendererRegistry.register(LOYAL_ZOMBIE, m -> new TFBipedRenderer<>(m, new LoyalZombieModel(m.bakeLayer(TFModelLayers.LOYAL_ZOMBIE)), new LoyalZombieModel(m.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)), new LoyalZombieModel(m.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR)), 0.5F, "textures/entity/zombie/zombie.png"));
			EntityRendererRegistry.register(TINY_BIRD, m -> new TinyBirdRenderer(m, new TinyBirdModel(m.bakeLayer(TFModelLayers.TINY_BIRD)), 0.3F));
			EntityRendererRegistry.register(SQUIRREL, m -> new TFGenericMobRenderer<>(m, new SquirrelModel(m.bakeLayer(TFModelLayers.SQUIRREL)), 0.3F, "squirrel2.png"));
			EntityRendererRegistry.register(DWARF_RABBIT, m -> new BunnyRenderer(m, new BunnyModel(m.bakeLayer(TFModelLayers.BUNNY)), 0.3F));
			EntityRendererRegistry.register(RAVEN, m -> new BirdRenderer<>(m, new RavenModel(m.bakeLayer(TFModelLayers.RAVEN)), 0.3F, "raven.png"));
			EntityRendererRegistry.register(QUEST_RAM, m -> new QuestRamRenderer(m, new QuestRamModel(m.bakeLayer(TFModelLayers.QUEST_RAM))));
			EntityRendererRegistry.register(KOBOLD, m -> new KoboldRenderer(m, new KoboldModel(m.bakeLayer(TFModelLayers.KOBOLD)), 0.4F, "kobold.png"));
			//EntityRendererRegistry.register(BOGGARD, m -> new RenderTFBiped<>(m, new BipedModel<>(0), 0.625F, "kobold.png"));
			EntityRendererRegistry.register(MOSQUITO_SWARM, m -> new TFGenericMobRenderer<>(m, new MosquitoSwarmModel(m.bakeLayer(TFModelLayers.MOSQUITO_SWARM)), 0.0F, "mosquitoswarm.png"));
			EntityRendererRegistry.register(DEATH_TOME, m -> new TFGenericMobRenderer<>(m, new DeathTomeModel(m.bakeLayer(TFModelLayers.DEATH_TOME)), 0.3F, "textures/entity/enchanting_table_book.png"));
			EntityRendererRegistry.register(MINOTAUR, m -> new TFBipedRenderer<>(m, new MinotaurModel(m.bakeLayer(TFModelLayers.MINOTAUR)), 0.625F, "minotaur.png"));
			EntityRendererRegistry.register(MINOSHROOM, m -> new MinoshroomRenderer(m, new MinoshroomModel(m.bakeLayer(TFModelLayers.MINOSHROOM)), 0.625F));
			EntityRendererRegistry.register(FIRE_BEETLE, m -> new TFGenericMobRenderer<>(m, new FireBeetleModel(m.bakeLayer(TFModelLayers.FIRE_BEETLE)), 0.8F, "firebeetle.png"));
			EntityRendererRegistry.register(SLIME_BEETLE, m -> new SlimeBeetleRenderer(m, new SlimeBeetleModel(m.bakeLayer(TFModelLayers.SLIME_BEETLE), false), 0.6F));
			EntityRendererRegistry.register(PINCH_BEETLE, m -> new TFGenericMobRenderer<>(m, new PinchBeetleModel(m.bakeLayer(TFModelLayers.PINCH_BEETLE)), 0.6F, "pinchbeetle.png"));
			EntityRendererRegistry.register(MIST_WOLF, MistWolfRenderer::new);
			EntityRendererRegistry.register(CARMINITE_GHASTLING, m -> new TFGhastRenderer<>(m, new TFGhastModel<>(m.bakeLayer(TFModelLayers.CARMINITE_GHASTLING)), 0.625F));
			EntityRendererRegistry.register(CARMINITE_GOLEM, m -> new CarminiteGolemRenderer<>(m, new CarminiteGolemModel<>(m.bakeLayer(TFModelLayers.CARMINITE_GOLEM)), 0.75F));
			EntityRendererRegistry.register(TOWERWOOD_BORER, m -> new TFGenericMobRenderer<>(m, new SilverfishModel<>(m.bakeLayer(ModelLayers.SILVERFISH)), 0.3F, "towertermite.png"));
			EntityRendererRegistry.register(CARMINITE_GHASTGUARD, m -> new CarminiteGhastRenderer<>(m, new TFGhastModel<>(m.bakeLayer(TFModelLayers.CARMINITE_GHASTGUARD)), 3.0F));
			EntityRendererRegistry.register(UR_GHAST, m -> new UrGhastRenderer(m, new UrGhastModel(m.bakeLayer(TFModelLayers.UR_GHAST)), 8.0F, 24F));
			EntityRendererRegistry.register(BLOCKCHAIN_GOBLIN, m -> new BlockChainGoblinRenderer<>(m, new BlockChainGoblinModel<>(m.bakeLayer(TFModelLayers.BLOCKCHAIN_GOBLIN)), 0.4F));
			EntityRendererRegistry.register(UPPER_GOBLIN_KNIGHT, m -> new UpperGoblinKnightRenderer(m, new UpperGoblinKnightModel(m.bakeLayer(TFModelLayers.UPPER_GOBLIN_KNIGHT)), 0.625F));
			EntityRendererRegistry.register(LOWER_GOBLIN_KNIGHT, m -> new TFBipedRenderer<>(m, new LowerGoblinKnightModel(m.bakeLayer(TFModelLayers.LOWER_GOBLIN_KNIGHT)), 0.625F, "doublegoblin.png"));
			EntityRendererRegistry.register(HELMET_CRAB, m -> new TFGenericMobRenderer<>(m, new HelmetCrabModel(m.bakeLayer(TFModelLayers.HELMET_CRAB)), 0.625F, "helmetcrab.png"));
			EntityRendererRegistry.register(KNIGHT_PHANTOM, m -> new KnightPhantomRenderer(m, new KnightPhantomModel(m.bakeLayer(TFModelLayers.KNIGHT_PHANTOM)), 0.625F));
			EntityRendererRegistry.register(NAGA, m -> new NagaRenderer<>(m, new NagaModel<>(m.bakeLayer(TFModelLayers.NAGA)), 1.45F));
			EntityRendererRegistry.register(SWARM_SPIDER, SwarmSpiderRenderer::new);
			EntityRendererRegistry.register(KING_SPIDER, KingSpiderRenderer::new);
			EntityRendererRegistry.register(CARMINITE_BROODLING, CarminiteBroodlingRenderer::new);
			EntityRendererRegistry.register(HEDGE_SPIDER, HedgeSpiderRenderer::new);
			EntityRendererRegistry.register(REDCAP_SAPPER, m -> new TFBipedRenderer<>(m, new RedcapModel<>(m.bakeLayer(TFModelLayers.REDCAP)), new RedcapModel<>(m.bakeLayer(TFModelLayers.REDCAP_ARMOR_INNER)), new RedcapModel<>(m.bakeLayer(TFModelLayers.REDCAP_ARMOR_OUTER)), 0.4F, "redcapsapper.png"));
			EntityRendererRegistry.register(MAZE_SLIME, m -> new MazeSlimeRenderer(m, 0.625F));
			EntityRendererRegistry.register(YETI, m -> new TFBipedRenderer<>(m, new YetiModel<>(m.bakeLayer(TFModelLayers.YETI)), 0.625F, "yeti2.png"));
			EntityRendererRegistry.register(PROTECTION_BOX, ProtectionBoxRenderer::new);
			EntityRendererRegistry.register(ALPHA_YETI, m -> new TFBipedRenderer<>(m, new AlphaYetiModel(m.bakeLayer(TFModelLayers.ALPHA_YETI)), 1.75F, "yetialpha.png"));
			EntityRendererRegistry.register(WINTER_WOLF, WinterWolfRenderer::new);
			EntityRendererRegistry.register(SNOW_GUARDIAN, m -> new SnowGuardianRenderer(m, new NoopModel<>(m.bakeLayer(TFModelLayers.NOOP))));
			EntityRendererRegistry.register(STABLE_ICE_CORE, m -> new StableIceCoreRenderer(m, new StableIceCoreModel(m.bakeLayer(TFModelLayers.STABLE_ICE_CORE))));
			EntityRendererRegistry.register(UNSTABLE_ICE_CORE, m -> new UnstableIceCoreRenderer<>(m, new UnstableIceCoreModel<>(m.bakeLayer(TFModelLayers.UNSTABLE_ICE_CORE))));
			EntityRendererRegistry.register(SNOW_QUEEN, m -> new SnowQueenRenderer(m, new SnowQueenModel(m.bakeLayer(TFModelLayers.SNOW_QUEEN))));
			EntityRendererRegistry.register(TROLL, m -> new TFBipedRenderer<>(m, new TrollModel(m.bakeLayer(TFModelLayers.TROLL)), 0.625F, "troll.png"));
			EntityRendererRegistry.register(GIANT_MINER, TFGiantRenderer::new);
			EntityRendererRegistry.register(ARMORED_GIANT, TFGiantRenderer::new);
			EntityRendererRegistry.register(ICE_CRYSTAL, IceCrystalRenderer::new);
			EntityRendererRegistry.register(CHAIN_BLOCK, BlockChainRenderer::new);
			EntityRendererRegistry.register(CUBE_OF_ANNIHILATION, CubeOfAnnihilationRenderer::new);
			EntityRendererRegistry.register(HARBINGER_CUBE, HarbingerCubeRenderer::new);
			EntityRendererRegistry.register(ADHERENT, AdherentRenderer::new);
			EntityRendererRegistry.register(ROVING_CUBE, RovingCubeRenderer::new);
			EntityRendererRegistry.register(RISING_ZOMBIE, m -> new TFBipedRenderer<>(m, new RisingZombieModel(m.bakeLayer(TFModelLayers.RISING_ZOMBIE)), new RisingZombieModel(m.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)), new RisingZombieModel(m.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR)), 0.5F, "textures/entity/zombie/zombie.png"));
			//EntityRendererRegistry.register(CASTLE_GUARDIAN, m -> new RenderTFCastleGuardian(m, new ModelTFCastleGuardian(), 2.0F, "finalcastle/castle_guardian.png"));
			EntityRendererRegistry.register(PLATEAU_BOSS, NoopRenderer::new);

			// projectiles
			EntityRendererRegistry.register(NATURE_BOLT, ThrownItemRenderer::new);
			EntityRendererRegistry.register(LICH_BOLT, c -> new CustomProjectileTextureRenderer(c, TwilightForestMod.prefix("textures/items/twilight_orb.png")));
			EntityRendererRegistry.register(WAND_BOLT, c -> new CustomProjectileTextureRenderer(c, TwilightForestMod.prefix("textures/items/twilight_orb.png")));
			EntityRendererRegistry.register(TOME_BOLT, ThrownItemRenderer::new);
			EntityRendererRegistry.register(HYDRA_MORTAR, HydraMortarRenderer::new);
			EntityRendererRegistry.register(SLIME_BLOB, ThrownItemRenderer::new);
			EntityRendererRegistry.register(CICADA_SHOT, CicadaShotRenderer::new);
			EntityRendererRegistry.register(MOONWORM_SHOT, MoonwormShotRenderer::new);
			EntityRendererRegistry.register(CHARM_EFFECT, ThrownItemRenderer::new);
			EntityRendererRegistry.register(LICH_BOMB, ThrownItemRenderer::new);
			EntityRendererRegistry.register(THROWN_WEP, ThrownWepRenderer::new);
			EntityRendererRegistry.register(FALLING_ICE, FallingIceRenderer::new);
			EntityRendererRegistry.register(THROWN_ICE, ThrownIceRenderer::new);
			EntityRendererRegistry.register(ICE_SNOWBALL, ThrownItemRenderer::new);
			EntityRendererRegistry.register(SLIDER, SlideBlockRenderer::new);
			EntityRendererRegistry.register(SEEKER_ARROW, DefaultArrowRenderer::new);
			EntityRendererRegistry.register(ICE_ARROW, DefaultArrowRenderer::new);
		}
	}

	@Environment(EnvType.CLIENT)
	public static class BakedMultiPartRenderers {

		private static final Map<ResourceLocation, EntityRenderer<?>> renderers = new HashMap<>();

		public static void bakeMultiPartRenderers(EntityRendererProvider.Context context) {
			renderers.put(TFPart.RENDERER, new NoopRenderer<>(context));
			renderers.put(HydraHead.RENDERER, new HydraHeadRenderer(context));
			renderers.put(HydraNeck.RENDERER, new HydraNeckRenderer(context));
			renderers.put(SnowQueenIceShield.RENDERER, new SnowQueenIceShieldLayer<>(context));
			renderers.put(NagaSegment.RENDERER, new NagaSegmentRenderer<>(context));
		}

		public static EntityRenderer<?> lookup(ResourceLocation location) {
			return renderers.get(location);
		}

	}
}
