package twilightforest.data;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import twilightforest.world.registration.TFStructures;
import twilightforest.TwilightForestMod;
import twilightforest.advancements.*;
import twilightforest.block.Experiment115Block;
import twilightforest.block.TFBlocks;
import twilightforest.entity.TFEntities;
import twilightforest.item.TFItems;
import twilightforest.util.TFStats;
import twilightforest.world.registration.TFStructures;

import java.util.function.Consumer;

public class AdvancementGenerator implements Consumer<Consumer<Advancement>> {

	private static final EntityType<?>[] TF_KILLABLE = new EntityType<?>[]{TFEntities.ADHERENT, TFEntities.ARMORED_GIANT, TFEntities.BIGHORN_SHEEP, TFEntities.BLOCKCHAIN_GOBLIN, TFEntities.DWARF_RABBIT, TFEntities.DEATH_TOME, TFEntities.DEER, TFEntities.FIRE_BEETLE, TFEntities.GIANT_MINER, TFEntities.LOWER_GOBLIN_KNIGHT, TFEntities.UPPER_GOBLIN_KNIGHT, TFEntities.HARBINGER_CUBE, TFEntities.HEDGE_SPIDER, TFEntities.HELMET_CRAB, TFEntities.HOSTILE_WOLF, TFEntities.HYDRA, TFEntities.KING_SPIDER, TFEntities.KNIGHT_PHANTOM, TFEntities.KOBOLD, TFEntities.LICH, TFEntities.LICH_MINION, TFEntities.MAZE_SLIME, TFEntities.CARMINITE_GHASTLING, TFEntities.MINOSHROOM, TFEntities.MINOTAUR, TFEntities.MIST_WOLF, TFEntities.MOSQUITO_SWARM, TFEntities.NAGA, TFEntities.PENGUIN, TFEntities.PINCH_BEETLE, TFEntities.PLATEAU_BOSS, TFEntities.QUEST_RAM, TFEntities.RAVEN, TFEntities.REDCAP, TFEntities.REDCAP_SAPPER, TFEntities.SKELETON_DRUID, TFEntities.SLIME_BEETLE, TFEntities.SNOW_GUARDIAN, TFEntities.SNOW_QUEEN, TFEntities.SQUIRREL, TFEntities.STABLE_ICE_CORE, TFEntities.SWARM_SPIDER, TFEntities.TINY_BIRD, TFEntities.CARMINITE_BROODLING, TFEntities.CARMINITE_GHASTGUARD, TFEntities.CARMINITE_GOLEM, TFEntities.TOWERWOOD_BORER, TFEntities.TROLL, TFEntities.UNSTABLE_ICE_CORE, TFEntities.UR_GHAST, TFEntities.BOAR, TFEntities.WINTER_WOLF, TFEntities.WRAITH, TFEntities.YETI, TFEntities.ALPHA_YETI};
	//man this is a pain
	private static final Block[] DENDROLOGIST_BLOCKS = new Block[]{
			TFBlocks.TWILIGHT_OAK_LOG, TFBlocks.TWILIGHT_OAK_WOOD, TFBlocks.STRIPPED_TWILIGHT_OAK_LOG, TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD, TFBlocks.TWILIGHT_OAK_LEAVES, TFBlocks.TWILIGHT_OAK_SAPLING, TFBlocks.TWILIGHT_OAK_PLANKS, TFBlocks.TWILIGHT_OAK_SLAB, TFBlocks.TWILIGHT_OAK_STAIRS, TFBlocks.TWILIGHT_OAK_BUTTON, TFBlocks.TWILIGHT_OAK_FENCE, TFBlocks.TWILIGHT_OAK_GATE, TFBlocks.TWILIGHT_OAK_PLATE, TFBlocks.TWILIGHT_OAK_DOOR, TFBlocks.TWILIGHT_OAK_TRAPDOOR, TFBlocks.TWILIGHT_OAK_SIGN,
			TFBlocks.CANOPY_LOG, TFBlocks.CANOPY_WOOD, TFBlocks.STRIPPED_CANOPY_LOG, TFBlocks.STRIPPED_CANOPY_WOOD, TFBlocks.CANOPY_LEAVES, TFBlocks.CANOPY_SAPLING, TFBlocks.CANOPY_PLANKS, TFBlocks.CANOPY_SLAB, TFBlocks.CANOPY_STAIRS, TFBlocks.CANOPY_BUTTON, TFBlocks.CANOPY_FENCE, TFBlocks.CANOPY_GATE, TFBlocks.CANOPY_PLATE, TFBlocks.CANOPY_DOOR, TFBlocks.CANOPY_TRAPDOOR, TFBlocks.CANOPY_SIGN,
			TFBlocks.MANGROVE_LOG, TFBlocks.MANGROVE_WOOD, TFBlocks.STRIPPED_MANGROVE_LOG, TFBlocks.STRIPPED_MANGROVE_WOOD, TFBlocks.MANGROVE_LEAVES, TFBlocks.MANGROVE_SAPLING, TFBlocks.MANGROVE_PLANKS, TFBlocks.MANGROVE_SLAB, TFBlocks.MANGROVE_STAIRS, TFBlocks.MANGROVE_BUTTON, TFBlocks.MANGROVE_FENCE, TFBlocks.MANGROVE_GATE, TFBlocks.MANGROVE_PLATE, TFBlocks.MANGROVE_DOOR, TFBlocks.MANGROVE_TRAPDOOR, TFBlocks.MANGROVE_SIGN,
			TFBlocks.DARK_LOG, TFBlocks.DARK_WOOD, TFBlocks.STRIPPED_DARK_LOG, TFBlocks.STRIPPED_DARK_WOOD, TFBlocks.DARK_LEAVES, TFBlocks.DARKWOOD_SAPLING, TFBlocks.DARK_PLANKS, TFBlocks.DARK_SLAB, TFBlocks.DARK_STAIRS, TFBlocks.DARK_BUTTON, TFBlocks.DARK_FENCE, TFBlocks.DARK_GATE, TFBlocks.DARK_PLATE, TFBlocks.DARK_DOOR, TFBlocks.DARK_TRAPDOOR, TFBlocks.DARKWOOD_SIGN,
			TFBlocks.TIME_LOG, TFBlocks.TIME_WOOD, TFBlocks.STRIPPED_TIME_LOG, TFBlocks.STRIPPED_TIME_WOOD, TFBlocks.TIME_LEAVES, TFBlocks.TIME_SAPLING, TFBlocks.TIME_PLANKS, TFBlocks.TIME_SLAB, TFBlocks.TIME_STAIRS, TFBlocks.TIME_BUTTON, TFBlocks.TIME_FENCE, TFBlocks.TIME_GATE, TFBlocks.TIME_PLATE, TFBlocks.TIME_DOOR, TFBlocks.TIME_TRAPDOOR, TFBlocks.TIME_SIGN,
			TFBlocks.TRANSFORMATION_LOG, TFBlocks.TRANSFORMATION_WOOD, TFBlocks.STRIPPED_TRANSFORMATION_LOG, TFBlocks.STRIPPED_TRANSFORMATION_WOOD, TFBlocks.TRANSFORMATION_LEAVES, TFBlocks.TRANSFORMATION_SAPLING, TFBlocks.TRANSFORMATION_PLANKS, TFBlocks.TRANSFORMATION_SLAB, TFBlocks.TRANSFORMATION_STAIRS, TFBlocks.TRANSFORMATION_BUTTON, TFBlocks.TRANSFORMATION_FENCE, TFBlocks.TRANSFORMATION_GATE, TFBlocks.TRANSFORMATION_PLATE, TFBlocks.TRANSFORMATION_DOOR, TFBlocks.TRANSFORMATION_TRAPDOOR, TFBlocks.TRANSFORMATION_SIGN,
			TFBlocks.MINING_LOG, TFBlocks.MINING_WOOD, TFBlocks.STRIPPED_MINING_LOG, TFBlocks.STRIPPED_MINING_WOOD, TFBlocks.MINING_LEAVES, TFBlocks.MINING_SAPLING, TFBlocks.MINING_PLANKS, TFBlocks.MINING_SLAB, TFBlocks.MINING_STAIRS, TFBlocks.MINING_BUTTON, TFBlocks.MINING_FENCE, TFBlocks.MINING_GATE, TFBlocks.MINING_PLATE, TFBlocks.MINING_DOOR, TFBlocks.MINING_TRAPDOOR, TFBlocks.MINING_SIGN,
			TFBlocks.SORTING_LOG, TFBlocks.SORTING_WOOD, TFBlocks.STRIPPED_SORTING_LOG, TFBlocks.STRIPPED_SORTING_WOOD, TFBlocks.SORTING_LEAVES, TFBlocks.SORTING_SAPLING, TFBlocks.SORTING_PLANKS, TFBlocks.SORTING_SLAB, TFBlocks.SORTING_STAIRS, TFBlocks.SORTING_BUTTON, TFBlocks.SORTING_FENCE, TFBlocks.SORTING_GATE, TFBlocks.SORTING_PLATE, TFBlocks.SORTING_DOOR, TFBlocks.SORTING_TRAPDOOR, TFBlocks.SORTING_SIGN,
			TFBlocks.ROOT_BLOCK, TFBlocks.ROOT_STRAND, TFBlocks.LIVEROOT_BLOCK, TFBlocks.HOLLOW_OAK_SAPLING, TFBlocks.RAINBOW_OAK_SAPLING, TFBlocks.RAINBOW_OAK_LEAVES, TFBlocks.TOWERWOOD, TFBlocks.GIANT_LOG, TFBlocks.GIANT_LEAVES, TFBlocks.HUGE_STALK, TFBlocks.BEANSTALK_LEAVES, TFBlocks.THORN_LEAVES, TFBlocks.THORN_ROSE, TFBlocks.HEDGE, TFBlocks.FALLEN_LEAVES, TFBlocks.MANGROVE_ROOT,
			// TFBlocks.OAK_BANISTER, TFBlocks.SPRUCE_BANISTER, TFBlocks.BIRCH_BANISTER, TFBlocks.JUNGLE_BANISTER, TFBlocks.ACACIA_BANISTER, TFBlocks.DARK_OAK_BANISTER, TFBlocks.CRIMSON_BANISTER, TFBlocks.WARPED_BANISTER,
			TFBlocks.TWILIGHT_OAK_BANISTER, TFBlocks.CANOPY_BANISTER, TFBlocks.MANGROVE_BANISTER, TFBlocks.DARKWOOD_BANISTER, TFBlocks.TIME_BANISTER, TFBlocks.TRANSFORMATION_BANISTER, TFBlocks.MINING_BANISTER, TFBlocks.SORTING_BANISTER
	};

	@Override
	public void accept(Consumer<Advancement> consumer) {
		Advancement root = Advancement.Builder.advancement().display(
				TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE,
				new TranslatableComponent("itemGroup.twilightforest"),
				new TranslatableComponent("advancement.twilightforest.root.desc"),
				new ResourceLocation(TwilightForestMod.ID, "textures/block/mazestone_large_brick.png"),
				FrameType.TASK,
				true, false, false)
				.requirements(RequirementsStrategy.OR)
				.addCriterion("in_tf",
						LocationTrigger.TriggerInstance.located(
								LocationPredicate.inDimension(
										ResourceKey.create(Registry.DIMENSION_REGISTRY,
												new ResourceLocation(TwilightForestMod.COMMON_CONFIG.dimension.portalDestinationID)))))
				.addCriterion("make_portal",
						MakePortalTrigger.Instance.makePortal())
				.save(consumer, "twilightforest:root");

		Advancement silence = this.addTFKillable(Advancement.Builder.advancement().parent(root).display(
				TFItems.RAVEN_FEATHER,
						new TranslatableComponent("advancement.twilightforest.twilight_hunter"),
						new TranslatableComponent("advancement.twilightforest.twilight_hunter.desc"),
				null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR))
				.save(consumer, "twilightforest:twilight_hunter");

		Advancement naga = Advancement.Builder.advancement().parent(silence).display(
				TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE,
				new TranslatableComponent("advancement.twilightforest.kill_naga"),
				new TranslatableComponent("advancement.twilightforest.kill_naga.desc",
						new TranslatableComponent(TFEntities.NAGA.getDescriptionId()),
						new TranslatableComponent(TFItems.NAGA_SCALE.getDescriptionId())),
				null, FrameType.GOAL, true, true, false)
				.addCriterion("naga", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.NAGA)))
				.addCriterion("scale", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.NAGA_SCALE))
				.addCriterion("kill_mob", HasAdvancementTrigger.Instance.hasAdvancement(silence.getId()))
				.requirements(new CountRequirementsStrategy(2, 1))
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_naga");

		Advancement lich = Advancement.Builder.advancement().parent(naga).display(
						TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE,
						new TranslatableComponent("advancement.twilightforest.kill_lich"),
						new TranslatableComponent("advancement.twilightforest.kill_lich.desc",
								new TranslatableComponent(TFEntities.LICH.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("kill_lich", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.LICH)))
				.addCriterion("trophy", InventoryChangeTrigger.TriggerInstance.hasItems(TFBlocks.LICH_TROPHY))
				.addCriterion("lifedrain_scepter", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.LIFEDRAIN_SCEPTER))
				.addCriterion("twilight_scepter", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.TWILIGHT_SCEPTER))
				.addCriterion("zombie_scepter", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.ZOMBIE_SCEPTER))
				.addCriterion("shield_scepter", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FORTIFICATION_SCEPTER))
				.addCriterion("kill_naga", HasAdvancementTrigger.Instance.hasAdvancement(naga.getId()))
				.requirements(new CountRequirementsStrategy(6, 1))
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_lich");

		Advancement minoshroom = Advancement.Builder.advancement().parent(lich).display(
						TFItems.MEEF_STROGANOFF,
						new TranslatableComponent("advancement.twilightforest.progress_labyrinth"),
						new TranslatableComponent("advancement.twilightforest.progress_labyrinth.desc"),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("meef", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.MEEF_STROGANOFF))
				.addCriterion("kill_lich", HasAdvancementTrigger.Instance.hasAdvancement(lich.getId()))
				.requirements(RequirementsStrategy.AND)
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_labyrinth");

		Advancement hydra = Advancement.Builder.advancement().parent(minoshroom).display(
						TFBlocks.HYDRA_TROPHY,
						new TranslatableComponent("advancement.twilightforest.kill_hydra"),
						new TranslatableComponent("advancement.twilightforest.kill_hydra.desc",
								new TranslatableComponent(TFEntities.HYDRA.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("kill_hydra", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.HYDRA)))
				.addCriterion("trophy", InventoryChangeTrigger.TriggerInstance.hasItems(TFBlocks.HYDRA_TROPHY))
				.addCriterion("blood", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_BLOOD))
				.addCriterion("stroganoff", HasAdvancementTrigger.Instance.hasAdvancement(minoshroom.getId()))
				.requirements(new CountRequirementsStrategy(3, 1))
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_hydra");

		Advancement trophy_pedestal = Advancement.Builder.advancement().parent(lich).display(
						TFBlocks.TROPHY_PEDESTAL,
						new TranslatableComponent("advancement.twilightforest.progress_trophy_pedestal"),
						new TranslatableComponent("advancement.twilightforest.progress_trophy_pedestal.desc"),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("trophy_pedestal", new TrophyPedestalTrigger.Instance(EntityPredicate.Composite.ANY))
				.addCriterion("kill_lich", HasAdvancementTrigger.Instance.hasAdvancement(lich.getId()))
				.requirements(RequirementsStrategy.AND)
				.save(consumer, "twilightforest:progress_trophy_pedestal");

		Advancement knights = Advancement.Builder.advancement().parent(trophy_pedestal).display(
						TFBlocks.KNIGHT_PHANTOM_TROPHY,
						new TranslatableComponent("advancement.twilightforest.progress_knights"),
						new TranslatableComponent("advancement.twilightforest.progress_knights.desc"),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("knight", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.KNIGHT_PHANTOM)))
				.addCriterion("trophy", InventoryChangeTrigger.TriggerInstance.hasItems(TFBlocks.KNIGHT_PHANTOM_TROPHY))
				.addCriterion("previous_progression", HasAdvancementTrigger.Instance.hasAdvancement(trophy_pedestal.getId()))
				.requirements(new CountRequirementsStrategy(2, 1))
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_knights");

		Advancement trap = Advancement.Builder.advancement().parent(knights).display(
				TFBlocks.GHAST_TRAP,
				new TranslatableComponent("advancement.twilightforest.ghast_trap"),
				new TranslatableComponent("advancement.twilightforest.ghast_trap.desc",
						new TranslatableComponent(TFEntities.CARMINITE_GHASTLING.getDescriptionId()),
						new TranslatableComponent(TFBlocks.GHAST_TRAP.getDescriptionId()),
						new TranslatableComponent(TFEntities.UR_GHAST.getDescriptionId())),
				null, FrameType.TASK, true, true, false)
				.addCriterion("activate_ghast_trap", ActivateGhastTrapTrigger.Instance.activateTrap())
				.save(consumer, "twilightforest:ghast_trap");

		Advancement ur_ghast = Advancement.Builder.advancement().parent(trap).display(
						TFBlocks.UR_GHAST_TROPHY,
						new TranslatableComponent("advancement.twilightforest.progress_ur_ghast"),
						new TranslatableComponent("advancement.twilightforest.progress_ur_ghast.desc",
								new TranslatableComponent(TFEntities.UR_GHAST.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("ghast", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.UR_GHAST)))
				.addCriterion("trophy", InventoryChangeTrigger.TriggerInstance.hasItems(TFBlocks.UR_GHAST_TROPHY))
				.addCriterion("tear", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_TEARS))
				.addCriterion("previous_progression", HasAdvancementTrigger.Instance.hasAdvancement(trap.getId()))
				.requirements(new CountRequirementsStrategy(3, 1))
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_ur_ghast");

		Advancement yeti = Advancement.Builder.advancement().parent(lich).display(
						TFItems.ALPHA_YETI_FUR,
						new TranslatableComponent("advancement.twilightforest.progress_yeti"),
						new TranslatableComponent("advancement.twilightforest.progress_yeti.desc",
								new TranslatableComponent(TFEntities.ALPHA_YETI.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("yeti", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.ALPHA_YETI)))
				.addCriterion("trophy", InventoryChangeTrigger.TriggerInstance.hasItems(TFBlocks.ALPHA_YETI_TROPHY))
				.addCriterion("fur", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.ALPHA_YETI_FUR))
				.addCriterion("previous_progression", HasAdvancementTrigger.Instance.hasAdvancement(lich.getId()))
				.requirements(new CountRequirementsStrategy(3, 1))
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_yeti");

		Advancement snow_queen = Advancement.Builder.advancement().parent(yeti).display(
						TFBlocks.SNOW_QUEEN_TROPHY,
						new TranslatableComponent("advancement.twilightforest.progress_glacier"),
						new TranslatableComponent("advancement.twilightforest.progress_glacier.desc",
								new TranslatableComponent(TFEntities.SNOW_QUEEN.getDescriptionId()),
								new TranslatableComponent("structure.aurora_palace")),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("queen", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.SNOW_QUEEN)))
				.addCriterion("trophy", InventoryChangeTrigger.TriggerInstance.hasItems(TFBlocks.SNOW_QUEEN_TROPHY))
				.addCriterion("previous_progression", HasAdvancementTrigger.Instance.hasAdvancement(yeti.getId()))
				.requirements(new CountRequirementsStrategy(2, 1))
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")))
				.save(consumer, "twilightforest:progress_glacier");

		Advancement merge = Advancement.Builder.advancement().parent(lich).display(
						TFBlocks.UBEROUS_SOIL,
						new TranslatableComponent("advancement.twilightforest.progress_merge"),
						new TranslatableComponent("advancement.twilightforest.progress_merge.desc",
								new TranslatableComponent(TFEntities.HYDRA.getDescriptionId()),
								new TranslatableComponent(TFEntities.UR_GHAST.getDescriptionId()),
								new TranslatableComponent(TFEntities.SNOW_QUEEN.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("hydra", HasAdvancementTrigger.Instance.hasAdvancement(hydra.getId()))
				.addCriterion("ur_ghast", HasAdvancementTrigger.Instance.hasAdvancement(ur_ghast.getId()))
				.addCriterion("snow_queen", HasAdvancementTrigger.Instance.hasAdvancement(snow_queen.getId()))
				.save(consumer, "twilightforest:progress_merge");

		Advancement troll = Advancement.Builder.advancement().parent(merge).display(
						TFItems.MAGIC_BEANS,
						new TranslatableComponent("advancement.twilightforest.troll"),
						new TranslatableComponent("advancement.twilightforest.troll.desc",
								new TranslatableComponent(TFEntities.TROLL.getDescriptionId())),
						null, FrameType.TASK, true, true, false)
				.addCriterion("troll", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.TROLL).located(LocationPredicate.inFeature(TFStructures.TROLL_CAVE))))
				.save(consumer, "twilightforest:troll");

		Advancement beanstalk = Advancement.Builder.advancement().parent(troll).display(
						TFBlocks.HUGE_STALK,
						new TranslatableComponent("advancement.twilightforest.beanstalk"),
						new TranslatableComponent("advancement.twilightforest.beanstalk.desc",
								new TranslatableComponent(TFItems.MAGIC_BEANS.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("beans", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.MAGIC_BEANS))
				.addCriterion("use_beans", ItemUsedOnBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(TFBlocks.UBEROUS_SOIL).build()), ItemPredicate.Builder.item().of(TFItems.MAGIC_BEANS)))
				.save(consumer, "twilightforest:beanstalk");

		Advancement giants = Advancement.Builder.advancement().parent(beanstalk).display(
						TFItems.GIANT_PICKAXE,
						new TranslatableComponent("advancement.twilightforest.giants"),
						new TranslatableComponent("advancement.twilightforest.giants.desc",
								new TranslatableComponent(TFEntities.GIANT_MINER.getDescriptionId()),
								new TranslatableComponent(TFItems.GIANT_PICKAXE.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("giant", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.GIANT_MINER)))
				.addCriterion("pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.MAGIC_BEANS))
				.save(consumer, "twilightforest:giants");

		Advancement lamp = Advancement.Builder.advancement().parent(giants).display(
						TFItems.LAMP_OF_CINDERS,
						new TranslatableComponent("advancement.twilightforest.progress_troll"),
						new TranslatableComponent("advancement.twilightforest.progress_troll.desc",
								new TranslatableComponent(TFItems.LAMP_OF_CINDERS.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("lamp", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.LAMP_OF_CINDERS))
				.addCriterion("previous_progression", HasAdvancementTrigger.Instance.hasAdvancement(merge.getId()))
				.save(consumer, "twilightforest:progress_troll");

		Advancement thornlands = Advancement.Builder.advancement().parent(lamp).display(
						TFBlocks.BROWN_THORNS,
						new TranslatableComponent("advancement.twilightforest.progress_thorns"),
						new TranslatableComponent("advancement.twilightforest.progress_thorns.desc"),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("castle", LocationTrigger.TriggerInstance.located(LocationPredicate.inFeature(TFStructures.FINAL_CASTLE)))
				.addCriterion("previous_progression", HasAdvancementTrigger.Instance.hasAdvancement(lamp.getId()))
				.save(consumer, "twilightforest:progress_thorns");

		Advancement.Builder.advancement().parent(thornlands).display(
						TFBlocks.VIOLET_CASTLE_RUNE_BRICK,
						new TranslatableComponent("advancement.twilightforest.progress_castle"),
						new TranslatableComponent("advancement.twilightforest.progress_castle.desc"),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("castle", LocationTrigger.TriggerInstance.located(LocationPredicate.inFeature(TFStructures.FINAL_CASTLE)))
				.addCriterion("previous_progression", HasAdvancementTrigger.Instance.hasAdvancement(thornlands.getId()))
				.save(consumer, "twilightforest:progress_castle");

		Advancement.Builder.advancement().parent(root).display(
						TFBlocks.QUEST_RAM_TROPHY,
						new TranslatableComponent("advancement.twilightforest.quest_ram"),
						new TranslatableComponent("advancement.twilightforest.quest_ram.desc",
								new TranslatableComponent(TFEntities.QUEST_RAM.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("quest_ram_complete", QuestRamCompletionTrigger.Instance.completeRam())
				.rewards(AdvancementRewards.Builder.function(TwilightForestMod.prefix("give_3_shields")).addExperience(100))
				.save(consumer, "twilightforest:quest_ram");

		Advancement.Builder.advancement().parent(root).display(
						TFBlocks.CICADA,
						new TranslatableComponent("advancement.twilightforest.kill_cicada"),
						new TranslatableComponent("advancement.twilightforest.kill_cicada.desc",
								new TranslatableComponent(TFBlocks.CICADA.getDescriptionId())),
						null, FrameType.TASK, true, true, true)
				.addCriterion("kill_cicada", KillBugTrigger.Instance.killBug(TFBlocks.CICADA))
				.save(consumer, "twilightforest:kill_cicada");

		Advancement focus = Advancement.Builder.advancement().parent(silence).display(
						TFItems.MAGIC_MAP_FOCUS,
						new TranslatableComponent("advancement.twilightforest.magic_map_focus"),
						new TranslatableComponent("advancement.twilightforest.magic_map_focus.desc",
								new TranslatableComponent(TFItems.MAGIC_MAP_FOCUS.getDescriptionId()),
								new TranslatableComponent(TFItems.RAVEN_FEATHER.getDescriptionId()),
								new TranslatableComponent(Items.GLOWSTONE_DUST.getDescriptionId()),
								new TranslatableComponent(TFItems.TORCHBERRIES.getDescriptionId())),
						null, FrameType.TASK, true, true, false)
				.addCriterion("focus", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.MAGIC_MAP_FOCUS))
				.save(consumer, "twilightforest:magic_map_focus");

		Advancement magic_map = Advancement.Builder.advancement().parent(focus).display(
						TFItems.FILLED_MAGIC_MAP,
						new TranslatableComponent("advancement.twilightforest.magic_map"),
						new TranslatableComponent("advancement.twilightforest.magic_map.desc",
								new TranslatableComponent(TFItems.FILLED_MAGIC_MAP.getDescriptionId())),
						null, FrameType.TASK, true, true, false)
				.addCriterion("magic_map", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FILLED_MAGIC_MAP))
				.save(consumer, "twilightforest:magic_map");

		Advancement maze_map = Advancement.Builder.advancement().parent(magic_map).display(
						TFItems.FILLED_MAZE_MAP,
						new TranslatableComponent("advancement.twilightforest.maze_map"),
						new TranslatableComponent("advancement.twilightforest.maze_map.desc",
								new TranslatableComponent(TFItems.FILLED_MAZE_MAP.getDescriptionId())),
						null, FrameType.GOAL, true, true, false)
				.addCriterion("maze_map", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FILLED_MAZE_MAP))
				.save(consumer, "twilightforest:maze_map");

		Advancement.Builder.advancement().parent(maze_map).display(
						TFItems.FILLED_ORE_MAP,
						new TranslatableComponent("advancement.twilightforest.ore_map"),
						new TranslatableComponent("advancement.twilightforest.ore_map.desc",
								new TranslatableComponent(TFItems.FILLED_ORE_MAP.getDescriptionId())),
						null, FrameType.CHALLENGE, true, true, true)
				.addCriterion("ore_map", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FILLED_ORE_MAP))
				.save(consumer, "twilightforest:ore_map");

		Advancement hill1 =  Advancement.Builder.advancement().parent(root).display(
						Items.IRON_BOOTS,
						new TranslatableComponent("advancement.twilightforest.hill1"),
						new TranslatableComponent("advancement.twilightforest.hill1.desc",
								new TranslatableComponent(TFEntities.REDCAP.getDescriptionId()),
								new TranslatableComponent("structure.hollow_hill")),
						null, FrameType.TASK, true, true, false)
				.addCriterion("redcap", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.REDCAP).located(LocationPredicate.inFeature(TFStructures.HOLLOW_HILL_SMALL))))
				.save(consumer, "twilightforest:hill1");

		Advancement hill2 =  Advancement.Builder.advancement().parent(hill1).display(
						TFItems.IRONWOOD_PICKAXE,
						new TranslatableComponent("advancement.twilightforest.hill2"),
						new TranslatableComponent("advancement.twilightforest.hill2.desc",
								new TranslatableComponent(TFEntities.REDCAP_SAPPER.getDescriptionId()),
								new TranslatableComponent("structure.hollow_hill")),
						null, FrameType.TASK, true, true, false)
				.addCriterion("redcap", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.REDCAP_SAPPER).located(LocationPredicate.inFeature(TFStructures.HOLLOW_HILL_MEDIUM))))
				.save(consumer, "twilightforest:hill2");

		Advancement.Builder.advancement().parent(hill2).display(
						Items.GLOWSTONE_DUST,
						new TranslatableComponent("advancement.twilightforest.hill3"),
						new TranslatableComponent("advancement.twilightforest.hill3.desc",
								new TranslatableComponent(TFEntities.WRAITH.getDescriptionId()),
								new TranslatableComponent("structure.hollow_hill")),
						null, FrameType.TASK, true, true, false)
				.addCriterion("redcap", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.WRAITH).located(LocationPredicate.inFeature(TFStructures.HOLLOW_HILL_LARGE))))
				.save(consumer, "twilightforest:hill3");

		Advancement.Builder.advancement().parent(root).display(
						TFBlocks.HEDGE,
						new TranslatableComponent("advancement.twilightforest.hedge"),
						new TranslatableComponent("advancement.twilightforest.hedge.desc",
								new TranslatableComponent("structure.hedge_maze")),
						null, FrameType.TASK, true, true, false)
				.addCriterion("hedge_spider", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.HEDGE_SPIDER).located(LocationPredicate.inFeature(TFStructures.HEDGE_MAZE))))
				.addCriterion("swarm_spider", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(TFEntities.SWARM_SPIDER).located(LocationPredicate.inFeature(TFStructures.HEDGE_MAZE))))
				.requirements(RequirementsStrategy.OR)
				.save(consumer, "twilightforest:hedge");

		Advancement.Builder.advancement().parent(root).display(
						Items.BOWL,
						new TranslatableComponent("advancement.twilightforest.twilight_dining"),
						new TranslatableComponent("advancement.twilightforest.twilight_dining.desc"),
						null, FrameType.CHALLENGE, true, true, false)
				.addCriterion("raw_venison", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.RAW_VENISON))
				.addCriterion("cooked_venison", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.COOKED_VENISON))
				.addCriterion("raw_meef", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.RAW_MEEF))
				.addCriterion("cooked_meef", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.COOKED_MEEF))
				.addCriterion("meef_stroganoff", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.MEEF_STROGANOFF))
				.addCriterion("hydra_chop", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.HYDRA_CHOP))
				.addCriterion("maze_wafer", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.MAZE_WAFER))
				.addCriterion("experiment_115", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.EXPERIMENT_115))
				.addCriterion("torchberries", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.TORCHBERRIES.get()))
				.requirements(new CountRequirementsStrategy(2, 2, 1, 1, 1, 1, 1))
				.rewards(AdvancementRewards.Builder.experience(75))
				.save(consumer, "twilightforest:twilight_dinner");

		Advancement.Builder.advancement().parent(naga).display(
						TFItems.NAGA_CHESTPLATE,
						new TranslatableComponent("advancement.twilightforest.naga_armors"),
						new TranslatableComponent("advancement.twilightforest.naga_armors.desc",
								new TranslatableComponent(TFItems.NAGA_SCALE.getDescriptionId())),
						null, FrameType.CHALLENGE, true, true, false)
				.addCriterion("armor", InventoryChangeTrigger.TriggerInstance.hasItems(
						TFItems.NAGA_CHESTPLATE, TFItems.NAGA_LEGGINGS))
				.rewards(AdvancementRewards.Builder.experience(25))
				.save(consumer, "twilightforest:naga_armors");

		Advancement.Builder.advancement().parent(lich).display(
						TFItems.ZOMBIE_SCEPTER,
						new TranslatableComponent("advancement.twilightforest.lich_scepters"),
						new TranslatableComponent("advancement.twilightforest.lich_scepters.desc"),
						null, FrameType.CHALLENGE, true, true, true)
				.addCriterion("scepters", InventoryChangeTrigger.TriggerInstance.hasItems(
						TFItems.LIFEDRAIN_SCEPTER, TFItems.TWILIGHT_SCEPTER,
						TFItems.ZOMBIE_SCEPTER, TFItems.FORTIFICATION_SCEPTER))
				.rewards(AdvancementRewards.Builder.experience(100))
				.save(consumer, "twilightforest:lich_scepters");

		Advancement.Builder.advancement().parent(lich).display(
						flaskWithHarming(),
						new TranslatableComponent("advancement.twilightforest.full_mettle_alchemist"),
						new TranslatableComponent("advancement.twilightforest.full_mettle_alchemist.desc"),
						null, FrameType.CHALLENGE, true, true, true)
				.addCriterion("drink_4_harming", DrinkFromFlaskTrigger.Instance.drankPotion(4, Potions.STRONG_HARMING))
				.rewards(AdvancementRewards.Builder.experience(100))
				.save(consumer, "twilightforest:full_mettle_alchemist");

		Advancement.Builder.advancement().parent(minoshroom).display(
						TFItems.MAZEBREAKER_PICKAXE,
						new TranslatableComponent("advancement.twilightforest.mazebreaker"),
						new TranslatableComponent("advancement.twilightforest.mazebreaker.desc",
								new TranslatableComponent(TFItems.MAZEBREAKER_PICKAXE.getDescriptionId())),
						null, FrameType.CHALLENGE, true, true, false)
				.addCriterion("pick", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.MAZEBREAKER_PICKAXE))
				.rewards(AdvancementRewards.Builder.experience(50))
				.save(consumer, "twilightforest:mazebreaker");

		Advancement.Builder.advancement().parent(hydra).display(
						TFItems.HYDRA_CHOP,
						new TranslatableComponent("advancement.twilightforest.hydra_chop"),
						new TranslatableComponent("advancement.twilightforest.hydra_chop.desc",
								new TranslatableComponent(TFEntities.HYDRA.getDescriptionId())),
						null, FrameType.TASK, true, true, false)
				.addCriterion("hydra_chop", HydraChopTrigger.Instance.eatChop())
				.save(consumer, "twilightforest:hydra_chop");

		Advancement.Builder.advancement().parent(hydra).display(
						TFItems.FIERY_SWORD,
						new TranslatableComponent("advancement.twilightforest.fiery_set"),
						new TranslatableComponent("advancement.twilightforest.fiery_set.desc"),
						null, FrameType.CHALLENGE, true, true, false)
				.addCriterion("fiery_pick", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_PICKAXE))
				.addCriterion("fiery_sword", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_SWORD))
				.addCriterion("fiery_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_HELMET))
				.addCriterion("fiery_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_CHESTPLATE))
				.addCriterion("fiery_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_LEGGINGS))
				.addCriterion("fiery_boots", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.FIERY_BOOTS))
				.requirements(new CountRequirementsStrategy(2, 4))
				.rewards(AdvancementRewards.Builder.experience(75))
				.save(consumer, "twilightforest:fiery_set");

		Advancement e115 = Advancement.Builder.advancement().parent(knights).display(
						TFItems.EXPERIMENT_115,
						new TranslatableComponent("advancement.twilightforest.experiment_115"),
						new TranslatableComponent("advancement.twilightforest.experiment_115.desc"),
						null, FrameType.TASK, true, true, false)
				.addCriterion("eat_experiment_115", ConsumeItemTrigger.TriggerInstance.usedItem(TFItems.EXPERIMENT_115))
				.save(consumer, "twilightforest:experiment_115");

		Advancement.Builder.advancement().parent(e115).display(
						e115Tag("think"),
						new TranslatableComponent("advancement.twilightforest.experiment_115_3"),
						new TranslatableComponent("advancement.twilightforest.experiment_115_3.desc"),
						null, FrameType.CHALLENGE, true, true, true)
				.addCriterion("eat_115_e115", LocationTrigger.TriggerInstance.located(EntityPredicate.Builder.entity().player(PlayerPredicate.Builder.player().addStat(Stats.CUSTOM.get(TFStats.E115_SLICES_EATEN), MinMaxBounds.Ints.atLeast(115)).build()).build()))
				.save(consumer, "twilightforest:experiment_115_115");

		Advancement.Builder.advancement().parent(e115).display(
						e115Tag("full"),
						new TranslatableComponent("advancement.twilightforest.experiment_115_2"),
						new TranslatableComponent("advancement.twilightforest.experiment_115_2.desc"),
						null, FrameType.CHALLENGE, true, true, true)
				.addCriterion("place_complete_e115", ItemUsedOnBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(TFBlocks.EXPERIMENT_115).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Experiment115Block.BITES_TAKEN, 0).hasProperty(Experiment115Block.REGENERATE, false).build()).build()), ItemPredicate.Builder.item().of(Items.REDSTONE)))
				.save(consumer, "twilightforest:experiment_115_self_replenishing");

		Advancement.Builder.advancement().parent(yeti).display(
						TFItems.ARCTIC_CHESTPLATE,
						new TranslatableComponent("advancement.twilightforest.arctic_dyed"),
						new TranslatableComponent("advancement.twilightforest.arctic_dyed.desc"),
						null, FrameType.TASK, true, true, false)
				.addCriterion("helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(TFItems.ARCTIC_HELMET).hasNbt(arcticDye(TFItems.ARCTIC_HELMET)).build()))
				.addCriterion("chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(TFItems.ARCTIC_CHESTPLATE).hasNbt(arcticDye(TFItems.ARCTIC_CHESTPLATE)).build()))
				.addCriterion("leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(TFItems.ARCTIC_LEGGINGS).hasNbt(arcticDye(TFItems.ARCTIC_LEGGINGS)).build()))
				.addCriterion("boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(TFItems.ARCTIC_BOOTS).hasNbt(arcticDye(TFItems.ARCTIC_BOOTS)).build()))
				.rewards(AdvancementRewards.Builder.experience(25))
				.save(consumer, "twilightforest:arctic_armor_dyed");

		Advancement.Builder.advancement().parent(yeti).display(
						TFItems.GLASS_SWORD,
						new TranslatableComponent("advancement.twilightforest.glass_sword"),
						new TranslatableComponent("advancement.twilightforest.glass_sword.desc"),
						null, FrameType.CHALLENGE, true, true, true)
				.addCriterion("broken_sword", ItemDurabilityTrigger.TriggerInstance.changedDurability(ItemPredicate.Builder.item().of(TFItems.GLASS_SWORD).build(), MinMaxBounds.Ints.exactly(-1)))
				.rewards(AdvancementRewards.Builder.experience(42).addLootTable(TwilightForestMod.prefix("glass_sword")))
				.save(consumer, "twilightforest:break_glass_sword");

		this.addDendrologistBlock(Advancement.Builder.advancement().parent(root)
				.display(TFBlocks.TWILIGHT_OAK_FENCE,
						new TranslatableComponent("advancement.twilightforest.arborist"),
						new TranslatableComponent("advancement.twilightforest.arborist.desc"),
						null, FrameType.CHALLENGE, true, true, false)
				.requirements(RequirementsStrategy.AND))
				.addCriterion("liveroot", InventoryChangeTrigger.TriggerInstance.hasItems(TFItems.LIVEROOT))
				.rewards(AdvancementRewards.Builder.experience(1000))
				.save(consumer, "twilightforest:arborist");

	}

	private ItemStack e115Tag(String nbt) {
		ItemStack itemstack = new ItemStack(TFItems.EXPERIMENT_115);
		CompoundTag compoundtag = itemstack.getOrCreateTagElement(nbt);
		compoundtag.putInt(nbt, 1);
		return itemstack;
	}

	private ItemStack flaskWithHarming() {
		ItemStack itemstack = new ItemStack(TFItems.GREATER_FLASK);
		CompoundTag compoundtag = itemstack.getOrCreateTag();
		compoundtag.putInt("Uses", 4);
		compoundtag.putString("Potion", Registry.POTION.getKey(Potions.STRONG_HARMING).toString());
		return itemstack;
	}

	private CompoundTag arcticDye(Item item) {
		ItemStack itemstack = new ItemStack(item);
		CompoundTag compoundtag = itemstack.getOrCreateTagElement("display");
		CompoundTag color = itemstack.getOrCreateTagElement("hasColor");
		color.putBoolean("hasColor", true);
		compoundtag.put("display", color);
		return compoundtag;
	}

	private Advancement.Builder addTFKillable(Advancement.Builder builder) {
		for (EntityType<?> entity : TF_KILLABLE) {
			builder.addCriterion(EntityType.getKey(entity).getPath(),
					KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entity)
							.located(
									LocationPredicate.inDimension(
											ResourceKey.create(Registry.DIMENSION_REGISTRY,
													new ResourceLocation(TwilightForestMod.COMMON_CONFIG.dimension.portalDestinationID))))));
		}
		return builder;
	}

	private Advancement.Builder addDendrologistBlock(Advancement.Builder builder) {
		for (Block dendrologistBlock : DENDROLOGIST_BLOCKS) {
			if(!builder.getCriteria().containsKey(Registry.BLOCK.getKey(dendrologistBlock).getPath()))
				builder.addCriterion(Registry.BLOCK.getKey(dendrologistBlock).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(dendrologistBlock));
		}
		return builder;
	}
}
