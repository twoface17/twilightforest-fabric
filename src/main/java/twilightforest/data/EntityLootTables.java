package twilightforest.data;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import com.google.common.collect.Sets;
import twilightforest.TFConstants;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.entity.TFEntities;
import twilightforest.item.TFItems;
import twilightforest.loot.TFTreasure;
import twilightforest.loot.conditions.IsMinion;
import twilightforest.loot.conditions.ModExists;
import twilightforest.loot.functions.ModItemSwap;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

public class EntityLootTables extends net.minecraft.data.loot.EntityLoot {

	private final Set<EntityType<?>> knownEntities = new HashSet<>();

	@Override
	public void add(EntityType<?> entity, LootTable.Builder builder) {
		super.add(entity, builder);
		knownEntities.add(entity);
	}

	@Override
	public void add(ResourceLocation id, LootTable.Builder table) {
		super.add(id, table);
	}

	protected void addTables() {
		add(TFEntities.ADHERENT, emptyLootTable());
		add(TFEntities.HARBINGER_CUBE, emptyLootTable());
		add(TFEntities.MOSQUITO_SWARM, emptyLootTable());
		add(TFEntities.PINCH_BEETLE, emptyLootTable());
		add(TFEntities.QUEST_RAM, emptyLootTable());
		add(TFEntities.ROVING_CUBE, emptyLootTable());
		add(TFEntities.SQUIRREL, emptyLootTable());
		add(TFEntities.DWARF_RABBIT, fromEntityLootTable(EntityType.RABBIT));
		add(TFEntities.HEDGE_SPIDER, fromEntityLootTable(EntityType.SPIDER));
		add(TFEntities.FIRE_BEETLE, fromEntityLootTable(EntityType.CREEPER));
		add(TFEntities.HOSTILE_WOLF, fromEntityLootTable(EntityType.WOLF));
		add(TFEntities.KING_SPIDER, fromEntityLootTable(EntityType.SPIDER));
		add(TFEntities.MIST_WOLF, fromEntityLootTable(EntityType.WOLF));
		add(TFEntities.REDCAP_SAPPER, fromEntityLootTable(TFEntities.REDCAP));
		add(TFEntities.SLIME_BEETLE, fromEntityLootTable(EntityType.SLIME));
		add(TFEntities.SWARM_SPIDER, fromEntityLootTable(EntityType.SPIDER));
		add(TFEntities.CARMINITE_BROODLING, fromEntityLootTable(EntityType.SPIDER));
		add(TFEntities.CARMINITE_GHASTGUARD, fromEntityLootTable(EntityType.GHAST));
		add(TFEntities.BIGHORN_SHEEP, fromEntityLootTable(EntityType.SHEEP));
		add(TFTreasure.BIGHORN_SHEEP_BLACK, sheepLootTableBuilderWithDrop(Blocks.BLACK_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_BLUE, sheepLootTableBuilderWithDrop(Blocks.BLUE_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_BROWN, sheepLootTableBuilderWithDrop(Blocks.BROWN_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_CYAN, sheepLootTableBuilderWithDrop(Blocks.CYAN_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_GRAY, sheepLootTableBuilderWithDrop(Blocks.GRAY_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_GREEN, sheepLootTableBuilderWithDrop(Blocks.GREEN_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_LIGHT_BLUE, sheepLootTableBuilderWithDrop(Blocks.LIGHT_BLUE_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_LIGHT_GRAY, sheepLootTableBuilderWithDrop(Blocks.LIGHT_GRAY_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_LIME, sheepLootTableBuilderWithDrop(Blocks.LIME_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_MAGENTA, sheepLootTableBuilderWithDrop(Blocks.MAGENTA_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_ORANGE, sheepLootTableBuilderWithDrop(Blocks.ORANGE_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_PINK, sheepLootTableBuilderWithDrop(Blocks.PINK_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_PURPLE, sheepLootTableBuilderWithDrop(Blocks.PURPLE_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_RED, sheepLootTableBuilderWithDrop(Blocks.RED_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_WHITE, sheepLootTableBuilderWithDrop(Blocks.WHITE_WOOL));
		add(TFTreasure.BIGHORN_SHEEP_YELLOW, sheepLootTableBuilderWithDrop(Blocks.YELLOW_WOOL));

		add(TFEntities.ARMORED_GIANT,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.GIANT_SWORD))
								.when(LootItemKilledByPlayerCondition.killedByPlayer())));

		add(TFEntities.GIANT_MINER,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.GIANT_PICKAXE))
								.when(LootItemKilledByPlayerCondition.killedByPlayer())));

		add(TFEntities.BLOCKCHAIN_GOBLIN,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ARMOR_SHARD)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.CARMINITE_GHASTLING,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootTableReference.lootTableReference(EntityType.GHAST.getDefaultLootTable()))
								.when(IsMinion.builder(true))));

		/*registerLootTable(TFEntities.BOGGARD,
				LootTable.builder()
						.addLootPool(LootPool.builder()
								.rolls(ConstantRange.of(1))
								.addEntry(ItemLootEntry.builder(TFItems.MAZE_MAP_FOCUS)
										.acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(1.0F, 1.0F))))
								.acceptCondition(RandomChance.builder(0.2F)))
						.addLootPool(LootPool.builder()
								.rolls(ConstantRange.of(1))
								.addEntry(ItemLootEntry.builder(Items.IRON_BOOTS)
										.acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(1.0F, 1.0F))))
								.acceptCondition(RandomChance.builder(0.1666F)))
						.addLootPool(LootPool.builder()
								.rolls(ConstantRange.of(1))
								.addEntry(ItemLootEntry.builder(Items.IRON_PICKAXE)
										.acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(1.0F, 1.0F))))
								.acceptCondition(RandomChance.builder(0.1111F))));*/

		add(TFEntities.BOAR,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.PORKCHOP)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
										.apply(SmeltItemFunction.smelted()
												.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.HELMET_CRAB,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ARMOR_SHARD)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.COD)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
										.apply(SmeltItemFunction.smelted()
												.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
								.when(LootItemRandomChanceCondition.randomChance(0.5F))));

		add(TFEntities.UPPER_GOBLIN_KNIGHT,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ARMOR_SHARD)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.LOWER_GOBLIN_KNIGHT,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ARMOR_SHARD)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.WRAITH,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.GLOWSTONE_DUST)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.REDCAP,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.COAL)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.YETI,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ARCTIC_FUR)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.WINTER_WOLF,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ARCTIC_FUR)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.TINY_BIRD,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.FEATHER)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.PENGUIN,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.FEATHER)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.ICE_CRYSTAL,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.SNOWBALL)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.UNSTABLE_ICE_CORE,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.SNOWBALL)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.STABLE_ICE_CORE,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.SNOWBALL)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.SNOW_GUARDIAN,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.SNOWBALL)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.RAVEN,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.RAVEN_FEATHER)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.TOWERWOOD_BORER,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.BORER_ESSENCE)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.SKELETON_DRUID,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.BONE)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
								.withPool(LootPool.lootPool()
										.setRolls(ConstantValue.exactly(1))
										.add(LootItem.lootTableItem(TFItems.TORCHBERRIES)
												.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
												.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.DEER,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.LEATHER)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.RAW_VENISON)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
										.apply(SmeltItemFunction.smelted()
												.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		add(TFEntities.KOBOLD,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.WHEAT)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.GOLD_NUGGET)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(-1.0F, 1.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
								.when(LootItemKilledByPlayerCondition.killedByPlayer())));

		add(TFEntities.MAZE_SLIME,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.SLIME_BALL)
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1))
								.when(LootItemRandomChanceCondition.randomChance(0.025F))));

		add(TFEntities.MINOTAUR,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.RAW_MEEF)
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
										.apply(SmeltItemFunction.smelted()
												.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.MAZE_MAP_FOCUS))
								.when(LootItemRandomChanceCondition.randomChance(0.025F))));

		add(TFEntities.CARMINITE_GOLEM,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.IRON_INGOT)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFBlocks.TOWERWOOD))
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))));

		add(TFEntities.TROLL,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.MAGIC_BEANS))
								.when(LootItemRandomChanceCondition.randomChance(0.025F))));

		add(TFEntities.DEATH_TOME,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.PAPER))
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(3)))
								.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1, 1))))
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.WRITABLE_BOOK).setWeight(2).setQuality(3))
								.add(LootItem.lootTableItem(Items.BOOK).setWeight(19))
								.add(LootTableReference.lootTableReference(TFTreasure.DEATH_TOME_BOOKS).setWeight(1)))
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
								.when(LootItemKilledByPlayerCondition.killedByPlayer())
								.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.005F))
								.add(LootItem.lootTableItem(TFItems.MAGIC_MAP_FOCUS))));

		add(TFTreasure.DEATH_TOME_HURT,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootTableReference.lootTableReference(BuiltInLootTables.EMPTY))
								.add(LootItem.lootTableItem(Items.PAPER))));

		add(TFTreasure.DEATH_TOME_BOOKS,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.BOOK).setWeight(32)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(1, 10))))
								.add(LootItem.lootTableItem(Items.BOOK).setWeight(8)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(11, 20))))
								.add(LootItem.lootTableItem(Items.BOOK).setWeight(4)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(21, 30))))
								.add(LootItem.lootTableItem(Items.BOOK).setWeight(1)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(31, 40))))));

		add(TFEntities.NAGA,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.NAGA_SCALE)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 11)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFBlocks.NAGA_TROPHY.asItem())))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.NAGA_SCALE)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), TFItems.NAGA_SCALE))
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:naga"))))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.NAGA_SCALE)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), TFItems.NAGA_SCALE)))));

		add(TFEntities.LICH,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.TWILIGHT_SCEPTER))
								.add(LootItem.lootTableItem(TFItems.LIFEDRAIN_SCEPTER))
								.add(LootItem.lootTableItem(TFItems.ZOMBIE_SCEPTER))
								.add(LootItem.lootTableItem(TFItems.FORTIFICATION_SCEPTER)))
						.withPool(LootPool.lootPool()
								.setRolls(UniformGenerator.between(2, 4))
								.add(LootItem.lootTableItem(Items.GOLDEN_SWORD)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(10, 40))))
								.add(LootItem.lootTableItem(Items.GOLDEN_HELMET)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(10, 40))))
								.add(LootItem.lootTableItem(Items.GOLDEN_CHESTPLATE)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(10, 40))))
								.add(LootItem.lootTableItem(Items.GOLDEN_LEGGINGS)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(10, 40))))
								.add(LootItem.lootTableItem(Items.GOLDEN_BOOTS)
										.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(10, 40)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.ENDER_PEARL)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.BONE)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 9)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFBlocks.LICH_TROPHY.asItem())))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.GOLD_NUGGET)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), Items.GOLD_NUGGET))
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:lich"))))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.GOLD_NUGGET)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), Items.GOLD_NUGGET)))));

		add(TFEntities.MINOSHROOM,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.MEEF_STROGANOFF)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFBlocks.MINOSHROOM_TROPHY.asItem())))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.MEEF_STROGANOFF)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), TFItems.MEEF_STROGANOFF))
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:minoshroom"))))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.MEEF_STROGANOFF)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), TFItems.MEEF_STROGANOFF)))));

		add(TFEntities.HYDRA,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.HYDRA_CHOP)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 35)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 2)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.FIERY_BLOOD)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(7, 10)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFBlocks.HYDRA_TROPHY.asItem())))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.FIERY_BLOOD)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), TFItems.FIERY_BLOOD))
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:hydra"))))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.FIERY_BLOOD)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), TFItems.FIERY_BLOOD)))));

		add(TFEntities.ALPHA_YETI,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ALPHA_YETI_FUR)
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(6)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ICE_BOMB)
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(6)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFBlocks.ALPHA_YETI_TROPHY.asItem())))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ICE_BOMB)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), TFItems.ICE_BOMB))
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:alpha_yeti"))))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ICE_BOMB)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), TFItems.ICE_BOMB)))));

		add(TFEntities.SNOW_QUEEN,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.TRIPLE_BOW))
								.add(LootItem.lootTableItem(TFItems.SEEKER_BOW)))
						.withPool(LootPool.lootPool()
								.setRolls(UniformGenerator.between(1, 4))
								.add(LootItem.lootTableItem(Blocks.PACKED_ICE.asItem())
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(7)))
										.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))
						.withPool(LootPool.lootPool()
								.setRolls(UniformGenerator.between(2, 5))
								.add(LootItem.lootTableItem(Items.SNOWBALL)
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(16)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFBlocks.SNOW_QUEEN_TROPHY.asItem())))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ICE_BOMB)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), TFItems.ICE_BOMB))
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:snow_queen"))))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.ICE_BOMB)
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), TFItems.ICE_BOMB)))));

		add(TFTreasure.QUESTING_RAM_REWARDS,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(TFItems.CRUMBLE_HORN)))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Items.BUNDLE)
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> {
											ListTag items = new ListTag();

											// Do NOT overstuff the bag.
											items.add(serializeNBT(new ItemStack(TFBlocks.QUEST_RAM_TROPHY)));
											items.add(serializeNBT(new ItemStack(Blocks.COAL_BLOCK)));
											items.add(serializeNBT(new ItemStack(Blocks.IRON_BLOCK)));
											items.add(serializeNBT(new ItemStack(Blocks.COPPER_BLOCK)));
											items.add(serializeNBT(new ItemStack(Blocks.LAPIS_BLOCK)));
											items.add(serializeNBT(new ItemStack(Blocks.GOLD_BLOCK)));
											items.add(serializeNBT(new ItemStack(Blocks.DIAMOND_BLOCK)));
											items.add(serializeNBT(new ItemStack(Blocks.EMERALD_BLOCK)));

											nbt.put("Items", items);
										})))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Blocks.COAL_BLOCK.asItem())
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), Blocks.COAL_BLOCK.asItem()))
										.apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:questing_ram"))))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(Blocks.COAL_BLOCK.asItem())
										.when(ModExists.builder("immersiveengineering"))
										.apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), Blocks.COAL_BLOCK.asItem())))));
	}

	private CompoundTag serializeNBT(ItemStack stack)
	{
		CompoundTag ret = new CompoundTag();
		stack.save(ret);
		return ret;
	}

	@Override
	public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_124377_) {
		this.addTables();
		Set<ResourceLocation> set = Sets.newHashSet();

		for(EntityType<?> entitytype : getKnownEntities()) {
			ResourceLocation resourcelocation = entitytype.getDefaultLootTable();
			if (isNonLiving(entitytype)) {
				if (resourcelocation != BuiltInLootTables.EMPTY && this.map.remove(resourcelocation) != null) {
					throw new IllegalStateException(String.format("Weird loottable '%s' for '%s', not a LivingEntity so should not have loot", resourcelocation, Registry.ENTITY_TYPE.getKey(entitytype)));
				}
			} else if (resourcelocation != BuiltInLootTables.EMPTY && set.add(resourcelocation)) {
				LootTable.Builder loottable$builder = this.map.remove(resourcelocation);
				if (loottable$builder == null) {
					throw new IllegalStateException(String.format("Missing loottable '%s' for '%s'", resourcelocation, Registry.ENTITY_TYPE.getKey(entitytype)));
				}

				p_124377_.accept(resourcelocation, loottable$builder);
			}
		}

		this.map.forEach(p_124377_::accept);
	}

	protected boolean isNonLiving(EntityType<?> entitytype) {
		return !SPECIAL_LOOT_TABLE_TYPES.contains(entitytype) && entitytype.getCategory() == MobCategory.MISC;
	}

	public LootTable.Builder emptyLootTable() {
		return LootTable.lootTable();
	}

	public LootTable.Builder fromEntityLootTable(EntityType<?> parent) {
		return LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootTableReference.lootTableReference(parent.getDefaultLootTable())));
	}

	private static LootTable.Builder sheepLootTableBuilderWithDrop(ItemLike wool) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(wool))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootTableReference.lootTableReference(EntityType.SHEEP.getDefaultLootTable())));
	}

	public Set<EntityType<?>> getKnownEntities() {
		return knownEntities;
	}
}
