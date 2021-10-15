package twilightforest.data;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNbtFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import twilightforest.TwilightForestMod;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;
import twilightforest.loot.TFTreasure;
import twilightforest.loot.conditions.ModExists;
import twilightforest.loot.functions.Enchant;
import twilightforest.loot.functions.ModItemSwap;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ChestLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> register) {
        register.accept(TFTreasure.USELESS_LOOT.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Items.POPPY).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.DANDELION).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.FEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                                .add(LootItem.lootTableItem(Items.WHEAT_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(Items.FLINT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(Items.CACTUS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(Items.SUGAR_CANE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.SAND).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.FLOWER_POT))
                                .add(LootItem.lootTableItem(Items.BONE_MEAL))));

        register.accept(TFTreasure.BASEMENT.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:water")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POISONOUS_POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WHEAT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WATER_BUCKET).setWeight(75))
                                .add(LootItem.lootTableItem(Items.TORCH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MUSHROOM_STEW).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MILK_BUCKET).setWeight(75))
								.add(LootItem.lootTableItem(Items.SWEET_BERRIES).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 7))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MELON_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.BREAD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                                .add(LootItem.lootTableItem(Items.COOKED_BEEF).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(Items.COOKED_PORKCHOP).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                                .add(LootItem.lootTableItem(Items.BAKED_POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                                .add(LootItem.lootTableItem(Items.COOKED_CHICKEN).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 10))))
                                .add(LootItem.lootTableItem(Items.COOKED_COD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.GLISTERING_MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.APPLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MAP).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.CAKE).setWeight(25))
                                .add(LootItem.lootTableItem(Items.OAK_BOAT).setWeight(25))
                                .add(LootItem.lootTableItem(TFBlocks.HOLLOW_OAK_SAPLING.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_HOME).setWeight(15))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_RADIANCE).setWeight(15))));

        register.accept(TFTreasure.FOUNDATION_BASEMENT.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:water")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POISONOUS_POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WATER_BUCKET).setWeight(75))
                                .add(LootItem.lootTableItem(Items.TORCH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MILK_BUCKET).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
								.add(LootItem.lootTableItem(Items.WHEAT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
								.add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:awkward")))))
								.add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:mundane")))))
								.add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:thick")))))
								.add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
								.add(LootItem.lootTableItem(Items.MELON_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
								.add(LootItem.lootTableItem(Items.PUMPKIN_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.GLISTERING_MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MAP).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.OAK_BOAT).setWeight(25))
                                .add(LootItem.lootTableItem(TFBlocks.HOLLOW_OAK_SAPLING.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_THREAD).setWeight(25))));

        register.accept(TFTreasure.WELL.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.IRON_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))).setWeight(75))
                                .add(EmptyLootItem.emptyItem().setWeight(25)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.BUCKET))
                                .add(LootItem.lootTableItem(Items.MELON_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.PUMPKIN_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.INK_SAC).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(Items.WATER_BUCKET))
                                .add(LootItem.lootTableItem(Items.BOWL))
                                .add(LootItem.lootTableItem(TFItems.RAW_IRONWOOD))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(Items.GOLD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(Items.COPPER_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.SHEARS))
                                .add(LootItem.lootTableItem(Items.SADDLE))
                                .add(LootItem.lootTableItem(Items.DIAMOND))
                                .add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))));

		register.accept(TFTreasure.FANCY_WELL.lootTable,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(4))
								//common loot
								.add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 15))))
								.add(LootItem.lootTableItem(Items.IRON_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 12))))
								.add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 7))))
								.add(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 20)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(2))
								//uncommon loot
								.add(LootItem.lootTableItem(Items.BUCKET))
								.add(LootItem.lootTableItem(Items.WATER_BUCKET))
								.add(LootItem.lootTableItem(TFItems.RAW_IRONWOOD).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
								.add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))))
								.add(LootItem.lootTableItem(Items.GOLD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
								.add(LootItem.lootTableItem(Items.COPPER_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8)))))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								//rare loot
								.add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 9))).setWeight(75))
								.add(LootItem.lootTableItem(Items.DIAMOND).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))).setWeight(75))
								.add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 9))).setWeight(75))
								.add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1).setWeight(75))
								//ultrarare loot
								.add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_2).setWeight(25))
								.add(LootItem.lootTableItem(TFItems.TRANSFORMATION_POWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 17))).setWeight(25))
								.add(LootItem.lootTableItem(TFItems.MUSIC_DISC_STEPS).setWeight(25))));

        register.accept(TFTreasure.HEDGE_MAZE.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Blocks.OAK_PLANKS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Blocks.BROWN_MUSHROOM).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Blocks.RED_MUSHROOM).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WHEAT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75)))
                          .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.MELON_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.PUMPKIN_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.COBWEB).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.APPLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.SHEARS).setWeight(75))
                                .add(LootItem.lootTableItem(Items.SADDLE).setWeight(75))
                                .add(LootItem.lootTableItem(Items.BOW).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(25))
                                .add(LootItem.lootTableItem(Items.MUSHROOM_STEW).setWeight(25))
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(25))
                                .add(LootItem.lootTableItem(Items.DIAMOND_HOE).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_MOTION).setWeight(15))));

        register.accept(TFTreasure.TREE_CACHE.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.POISONOUS_POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WHEAT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MELON_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WATER_BUCKET).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MILK_BUCKET).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFBlocks.TWILIGHT_OAK_SAPLING.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(TFBlocks.CANOPY_SAPLING.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(TFBlocks.MANGROVE_SAPLING.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(TFBlocks.DARKWOOD_SAPLING.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.PUMPKIN_PIE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.APPLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(TFBlocks.HOLLOW_OAK_SAPLING.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFBlocks.TIME_SAPLING.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFBlocks.TRANSFORMATION_SAPLING.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFBlocks.MINING_SAPLING.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFBlocks.SORTING_SAPLING.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_SUPERSTITIOUS).setWeight(25))));

        register.accept(TFTreasure.GRAVEYARD.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(Items.PUMPKIN_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 32))))
                                .add(LootItem.lootTableItem(Items.PUMPKIN_PIE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.TORCHBERRIES).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 16)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.DIAMOND).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.MOON_DIAL)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.TRANSFORMATION_POWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFBlocks.UNCRAFTING_TABLE.asItem()))
                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE))));

        register.accept(TFTreasure.SMALL_HOLLOW_HILL.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WHEAT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.BUCKET).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.TORCH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.BREAD))
                                .add(LootItem.lootTableItem(TFItems.ORE_MAGNET)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.LIVEROOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GOLD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.IRON_PICKAXE).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.TRANSFORMATION_POWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_FINDINGS).setWeight(25))));

        register.accept(TFTreasure.MEDIUM_HOLLOW_HILL.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.LADDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.BUCKET).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.BAKED_POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.TORCH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFItems.ORE_MAGNET))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.MAGIC_MAP).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.TRANSFORMATION_POWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(TFBlocks.UNCRAFTING_TABLE.asItem()).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(25))
                                .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.PEACOCK_FEATHER_FAN).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_WAYFARER).setWeight(25))));

        register.accept(TFTreasure.LARGE_HOLLOW_HILL.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.COD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.TORCHBERRIES).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.TORCH).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.PUMPKIN_PIE))
                                .add(LootItem.lootTableItem(TFItems.ORE_MAGNET)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.TRANSFORMATION_POWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_PICKAXE).apply(Enchant.builder().apply(Enchantments.BLOCK_EFFICIENCY, 1).apply(Enchantments.BLOCK_FORTUNE, 1)).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.MAGIC_MAP).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.DIAMOND).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MOONWORM_QUEEN).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1).setWeight(25))
                                .add(LootItem.lootTableItem(TFBlocks.IRONWOOD_BLOCK.asItem()).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MUSIC_DISC_MAKER).setWeight(20))));

        register.accept(TFTreasure.QUEST_GROVE.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootItem.lootTableItem(Blocks.WHITE_WOOL))
                                .add(LootItem.lootTableItem(Blocks.ORANGE_WOOL))
                                .add(LootItem.lootTableItem(Blocks.MAGENTA_WOOL))
                                .add(LootItem.lootTableItem(Blocks.LIGHT_BLUE_WOOL))
                                .add(LootItem.lootTableItem(Blocks.YELLOW_WOOL))
                                .add(LootItem.lootTableItem(Blocks.LIME_WOOL))
                                .add(LootItem.lootTableItem(Blocks.PINK_WOOL))
                                .add(LootItem.lootTableItem(Blocks.GRAY_WOOL))
                                .add(LootItem.lootTableItem(Blocks.LIGHT_GRAY_WOOL))
                                .add(LootItem.lootTableItem(Blocks.CYAN_WOOL))
                                .add(LootItem.lootTableItem(Blocks.PURPLE_WOOL))
                                .add(LootItem.lootTableItem(Blocks.BLUE_WOOL))
                                .add(LootItem.lootTableItem(Blocks.BROWN_WOOL))
                                .add(LootItem.lootTableItem(Blocks.GREEN_WOOL))
                                .add(LootItem.lootTableItem(Blocks.RED_WOOL))
                                .add(LootItem.lootTableItem(Blocks.BLACK_WOOL))));

        register.accept(TFTreasure.TOWER_LIBRARY.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:water")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GLASS_BOTTLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.LADDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.PAPER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.CLAY_BALL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.IRON_LEGGINGS).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(5))))
                                .add(LootItem.lootTableItem(Items.FIRE_CHARGE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                                .add(LootItem.lootTableItem(Items.BOOK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(Items.MAP))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:poison")))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:awkward")))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:weakness"))))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.STONE_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(10))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WOODEN_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(15))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.BOW).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(5))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.SPLASH_POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:weakness")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_regeneration")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_healing")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_swiftness")))).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_PICKAXE).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(10))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.IRON_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.BOW).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.BOOKSHELF).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENDER_PEARL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(25))));

        register.accept(TFTreasure.TOWER_ROOM.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:water")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GLASS_BOTTLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.SUGAR).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.SPIDER_EYE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GHAST_TEAR).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MAGMA_CREAM).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.FERMENTED_SPIDER_EYE).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GLISTERING_MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.BLAZE_POWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.PAPER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(10))))
                                .add(LootItem.lootTableItem(Items.GOLDEN_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(7))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:swiftness")))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:healing")))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:fire_resistance")))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:harming"))))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_HELMET).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(10))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.TRANSFORMATION_POWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1).setWeight(75))
                                .add(LootItem.lootTableItem(Items.SPLASH_POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:healing")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.SPLASH_POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_harming")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_swiftness")))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_regeneration")))).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_AXE).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(25))
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.MOONWORM_QUEEN).setWeight(25))
                                .add(LootItem.lootTableItem(TFItems.PEACOCK_FEATHER_FAN).setWeight(25))
                                .add(LootItem.lootTableItem(Items.OBSIDIAN).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(25))));

        register.accept(TFTreasure.LABYRINTH_DEAD_END.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MUSHROOM_STEW).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.MAZE_WAFER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.PAPER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.MILK_BUCKET))
                                .add(LootItem.lootTableItem(Items.PAPER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE))
                                .add(LootItem.lootTableItem(Items.BLAZE_ROD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))));

        register.accept(TFTreasure.LABYRINTH_ROOM.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.MILK_BUCKET))
                                .add(LootItem.lootTableItem(TFItems.MAZE_WAFER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_HELMET))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_LEGGINGS))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_BOOTS))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_PICKAXE))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_SWORD)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.MAZE_MAP_FOCUS))
                                .add(LootItem.lootTableItem(Items.TNT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_healing")))))));

        register.accept(TFTreasure.LABYRINTH_VAULT.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))))
                                .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))))
                                .add(LootItem.lootTableItem(TFItems.MAZE_WAFER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_regeneration")))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_healing")))))
                                .add(LootItem.lootTableItem(Items.POTION).apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("Potion", "minecraft:strong_swiftness"))))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.BOW).apply(Enchant.builder().apply(Enchantments.INFINITY_ARROWS, 1).apply(Enchantments.PUNCH_ARROWS, 2)))
                                .add(LootItem.lootTableItem(Items.BOW).apply(Enchant.builder().apply(Enchantments.POWER_ARROWS, 3).apply(Enchantments.FLAMING_ARROWS, 1)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_SHOVEL).apply(Enchant.builder().apply(Enchantments.BLOCK_EFFICIENCY, 4).apply(Enchantments.UNBREAKING, 2)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_AXE).apply(Enchant.builder().apply(Enchantments.BLOCK_EFFICIENCY, 5)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_CHESTPLATE).apply(Enchant.builder().apply(Enchantments.ALL_DAMAGE_PROTECTION, 3)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_BOOTS).apply(Enchant.builder().apply(Enchantments.ALL_DAMAGE_PROTECTION, 2)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_LEGGINGS).apply(Enchant.builder().apply(Enchantments.FIRE_PROTECTION, 4)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_HELMET).apply(Enchant.builder().apply(Enchantments.RESPIRATION, 3))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(Items.EMERALD_BLOCK))
                                .add(LootItem.lootTableItem(Items.ENDER_CHEST))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_PICKAXE).apply(Enchant.builder().apply(Enchantments.BLOCK_EFFICIENCY, 4).apply(Enchantments.SILK_TOUCH, 1)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_SWORD).apply(Enchant.builder().apply(Enchantments.SHARPNESS, 4).apply(Enchantments.KNOCKBACK, 2)))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_SWORD).apply(Enchant.builder().apply(Enchantments.BANE_OF_ARTHROPODS, 5).apply(Enchantments.FIRE_ASPECT, 2)))
                                .add(LootItem.lootTableItem(TFItems.MAZEBREAKER_PICKAXE).apply(Enchant.builder().apply(Enchantments.BLOCK_EFFICIENCY, 4).apply(Enchantments.UNBREAKING, 3).apply(Enchantments.BLOCK_FORTUNE, 2)))));

        register.accept(TFTreasure.STRONGHOLD_CACHE.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFItems.MAZE_WAFER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))))
                                .add(LootItem.lootTableItem(Items.BLUE_WOOL))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.BUCKET))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1))
                                .add(LootItem.lootTableItem(TFItems.ARMOR_SHARD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.BOW).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.IRON_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(15))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(10))).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.BANE_OF_ARTHROPODS, 4)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.SHARPNESS, 4)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.SMITE, 4)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.UNBREAKING, 2)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.ALL_DAMAGE_PROTECTION, 3)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.PROJECTILE_PROTECTION, 3)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.FALL_PROTECTION, 3)).setWeight(25))));

        register.accept(TFTreasure.STRONGHOLD_ROOM.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.MILK_BUCKET).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.MAZE_WAFER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_HELMET))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_LEGGINGS))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_BOOTS))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_PICKAXE))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_SWORD)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(25))))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))))
                                .add(LootItem.lootTableItem(Items.IRON_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30))))
                                .add(LootItem.lootTableItem(Items.BOW).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30))))
                                .add(LootItem.lootTableItem(Items.DIAMOND_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(15))))
                                .add(LootItem.lootTableItem(TFItems.MAZE_MAP_FOCUS))));

        register.accept(TFTreasure.STRONGHOLD_BOSS.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))))
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_PICKAXE).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))))
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_AXE).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFItems.PHANTOM_HELMET).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))))
                                .add(LootItem.lootTableItem(TFItems.PHANTOM_CHESTPLATE).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.PHANTOM_HELMET).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30))))
                                .add(LootItem.lootTableItem(TFItems.PHANTOM_CHESTPLATE).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(TFBlocks.KNIGHT_PHANTOM_TROPHY.asItem())))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_INGOT)
                                        .when(ModExists.builder("immersiveengineering"))
                                        .apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), TFItems.KNIGHTMETAL_INGOT))
                                        .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:knight_phantom"))))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_INGOT)
                                        .when(ModExists.builder("immersiveengineering"))
                                        .apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), TFItems.KNIGHTMETAL_INGOT)))));

        register.accept(TFTreasure.DARKTOWER_CACHE.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.CHARCOAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.EXPERIMENT_115).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.RED_WOOL).setWeight(75))
                                .add(LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(Items.REDSTONE_LAMP).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                                .add(LootItem.lootTableItem(Items.DIAMOND).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));

        register.accept(TFTreasure.DARKTOWER_KEY.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.EXPERIMENT_115).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GLOWSTONE_DUST).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_HELMET))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_LEGGINGS))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_BOOTS))
                                .add(LootItem.lootTableItem(TFItems.STEELEAF_PICKAXE))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_SWORD)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.FALL_PROTECTION, 3)))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.KNOCKBACK, 2)))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.BLOCK_EFFICIENCY, 3))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(TFItems.TOWER_KEY))));

        register.accept(TFTreasure.DARKTOWER_BOSS.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootItem.lootTableItem(TFItems.CARMINITE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                .add(LootItem.lootTableItem(TFItems.FIERY_TEARS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(TFBlocks.UR_GHAST_TROPHY.asItem())))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(TFItems.CARMINITE)
                                        .when(ModExists.builder("immersiveengineering"))
                                        .apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader")), TFItems.CARMINITE))
                                        .apply(SetNbtFunction.setTag(Util.make(new CompoundTag(), (nbt) -> nbt.putString("shader_name", "twilightforest:ur-ghast"))))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(TFItems.CARMINITE)
                                        .when(ModExists.builder("immersiveengineering"))
                                        .apply(ModItemSwap.builder().apply("immersiveengineering", Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_twilight")), TFItems.CARMINITE)))));

        register.accept(TFTreasure.AURORA_CACHE.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootTableReference.lootTableReference(TFTreasure.USELESS_LOOT.lootTable).setWeight(25))
                                //common loot
                                .add(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.ARROW).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.ICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(Items.PACKED_ICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.MAZE_WAFER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))).setWeight(75)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_KEEPING_1))
                                .add(LootItem.lootTableItem(TFItems.IRONWOOD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(TFBlocks.AURORA_BLOCK.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFItems.ARCTIC_FUR).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.ARCTIC_FUR).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.ICE_BOW).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.ENDER_BOW).setWeight(75))
                                .add(LootItem.lootTableItem(TFItems.ICE_SWORD).setWeight(75))
                                //ultrarare loot
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.SHARPNESS, 4)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.POWER_ARROWS, 4)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.PUNCH_ARROWS, 2)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.UNBREAKING, 2)).setWeight(25))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(Enchant.builder().apply(Enchantments.INFINITY_ARROWS, 1)).setWeight(25))));

        register.accept(TFTreasure.AURORA_ROOM.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(TFItems.MAZE_WAFER).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))))
                                .add(LootItem.lootTableItem(TFItems.ICE_BOMB).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(TFBlocks.FIREFLY.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                                .add(LootItem.lootTableItem(Items.ICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.PACKED_ICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFItems.ARCTIC_FUR).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(TFItems.ARCTIC_HELMET))
                                .add(LootItem.lootTableItem(TFItems.ARCTIC_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.ARCTIC_LEGGINGS))
                                .add(LootItem.lootTableItem(TFItems.ARCTIC_BOOTS))
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_CHESTPLATE))
                                .add(LootItem.lootTableItem(TFItems.KNIGHTMETAL_SWORD))
                                .add(LootItem.lootTableItem(TFItems.CHARM_OF_LIFE_1)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.ICE_BOW).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30))))
                                .add(LootItem.lootTableItem(TFItems.ENDER_BOW).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(5))))
                                .add(LootItem.lootTableItem(TFItems.ICE_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(25))))
                                .add(LootItem.lootTableItem(TFItems.GLASS_SWORD).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20))))));

        register.accept(TFTreasure.TROLL_GARDEN.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(Items.RED_MUSHROOM).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.BROWN_MUSHROOM).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                .add(LootItem.lootTableItem(Items.WHEAT_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(Items.CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(Items.POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(Items.MELON_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(Items.BONE_MEAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFBlocks.UBEROUS_SOIL.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.MAGIC_BEANS))));

        register.accept(TFTreasure.TROLL_VAULT.lootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                //common loot
                                .add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 32))))
                                .add(LootItem.lootTableItem(TFItems.TORCHBERRIES).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 16))))
                                .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                //uncommon loot
                                .add(LootItem.lootTableItem(TFBlocks.TROLLSTEINN.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                                .add(LootItem.lootTableItem(Items.OBSIDIAN).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                //rare loot
                                .add(LootItem.lootTableItem(TFItems.LAMP_OF_CINDERS))));
    }
}
