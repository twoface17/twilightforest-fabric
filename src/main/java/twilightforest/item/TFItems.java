package twilightforest.item;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPattern;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import twilightforest.TFSounds;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.enums.TwilightArmorMaterial;
import twilightforest.enums.TwilightItemTier;

import javax.annotation.Nullable;
import java.util.UUID;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.food.FoodProperties;

import static twilightforest.TwilightForestMod.creativeTab;

public class TFItems {
	public static final FoodProperties E115 = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build();
	public static final FoodProperties CHOP = new FoodProperties.Builder().nutrition(18).saturationMod(2.0F).meat().effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
	public static final FoodProperties WAFER = new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build();
	public static final FoodProperties MEEF_COOKED = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).meat().build();
	public static final FoodProperties MEEF_RAW = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).meat().build();
	public static final FoodProperties STROGANOFF = new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).alwaysEat().build();
	public static final FoodProperties VENISON_COOKED = new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).meat().build();
	public static final FoodProperties VENISON_RAW = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).meat().build();
	public static final FoodProperties TORCHBERRY = new FoodProperties.Builder().alwaysEat().effect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), 0.75F).build();

	public static final UUID GIANT_REACH_MODIFIER = UUID.fromString("7f10172d-de69-49d7-81bd-9594286a6827");

	//public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TwilightForestMod.ID);

	public static final Item NAGA_SCALE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":naga_scale", new Item(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item NAGA_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":naga_chestplate", new NagaArmorItem(TwilightArmorMaterial.ARMOR_NAGA, EquipmentSlot.CHEST, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item NAGA_LEGGINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":naga_leggings", new NagaArmorItem(TwilightArmorMaterial.ARMOR_NAGA, EquipmentSlot.LEGS, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item TWILIGHT_SCEPTER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":twilight_scepter", new TwilightWandItem(defaultBuilder().durability(99).rarity(Rarity.UNCOMMON)));
	public static final Item LIFEDRAIN_SCEPTER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":lifedrain_scepter", new LifedrainScepterItem(defaultBuilder().durability(99).rarity(Rarity.UNCOMMON)));
	public static final Item ZOMBIE_SCEPTER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":zombie_scepter", new ZombieWandItem(defaultBuilder().durability(9).rarity(Rarity.UNCOMMON)));
	public static final Item FORTIFICATION_SCEPTER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fortification_scepter", new FortificationWandItem(defaultBuilder().durability(9).rarity(Rarity.UNCOMMON)));
	//Registry.register(Registry.ITEM, TwilightForestMod.ID + ":Wand of Pacification [NYI]", new Item().setIconIndex(6).setTranslationKey("wandPacification").setMaxStackSize(1));
	public static final Item ORE_METER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ore_meter", new OreMeterItem(defaultBuilder()));
	public static final Item FILLED_MAGIC_MAP = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":filled_magic_map", new MagicMapItem(new Item.Properties().stacksTo(1)));
	public static final Item FILLED_MAZE_MAP = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":filled_maze_map", new MazeMapItem(false, new Item.Properties().stacksTo(1)));
	public static final Item FILLED_ORE_MAP = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":filled_ore_map", new MazeMapItem(true, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
	public static final Item RAVEN_FEATHER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":raven_feather", new Item(defaultBuilder()));
	public static final Item MAGIC_MAP_FOCUS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":magic_map_focus", new Item(defaultBuilder()));
	public static final Item MAZE_MAP_FOCUS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":maze_map_focus", new Item(defaultBuilder()));
	public static final Item MAGIC_MAP = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":magic_map", new EmptyMagicMapItem(defaultBuilder()));
	public static final Item MAZE_MAP = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":maze_map", new EmptyMazeMapItem(false, defaultBuilder()));
	public static final Item ORE_MAP = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ore_map", new EmptyMazeMapItem(true, defaultBuilder()));
	public static final Item LIVEROOT = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":liveroot", new Item(defaultBuilder()));
	public static final Item RAW_IRONWOOD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":raw_ironwood", new Item(defaultBuilder()));
	public static final Item IRONWOOD_INGOT = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_ingot", new Item(defaultBuilder()));
	public static final Item IRONWOOD_HELMET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_helmet", new IronwoodArmorItem(TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.HEAD, defaultBuilder()));
	public static final Item IRONWOOD_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_chestplate", new IronwoodArmorItem(TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.CHEST, defaultBuilder()));
	public static final Item IRONWOOD_LEGGINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_leggings", new IronwoodArmorItem(TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.LEGS, defaultBuilder()));
	public static final Item IRONWOOD_BOOTS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_boots", new IronwoodArmorItem(TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.FEET, defaultBuilder()));
	public static final Item IRONWOOD_SWORD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_sword", new IronwoodSwordItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
	public static final Item IRONWOOD_SHOVEL = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_shovel", new IronwoodShovelItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
	public static final Item IRONWOOD_PICKAXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_pickaxe", new IronwoodPickItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
	public static final Item IRONWOOD_AXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_axe", new IronwoodAxeItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
	public static final Item IRONWOOD_HOE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ironwood_hoe", new IronwoodHoeItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
	public static final Item TORCHBERRIES = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":torchberries", new Item(defaultBuilder().food(TORCHBERRY)));
	public static final Item RAW_VENISON = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":raw_venison", new Item(defaultBuilder().food(VENISON_RAW)));
	public static final Item COOKED_VENISON = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":cooked_venison", new Item(defaultBuilder().food(VENISON_COOKED)));
	public static final Item HYDRA_CHOP = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":hydra_chop", new HydraChopItem(defaultBuilder().fireResistant().food(CHOP).rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_BLOOD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_blood", new Item(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_TEARS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_tears", new Item(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_INGOT = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_ingot", new Item(defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_HELMET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_helmet", new FieryArmorItem(TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.HEAD, defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_chestplate", new FieryArmorItem(TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.CHEST, defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_LEGGINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_leggings", new FieryArmorItem(TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.LEGS, defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_BOOTS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_boots", new FieryArmorItem(TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.FEET, defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_SWORD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_sword", new FierySwordItem(TwilightItemTier.FIERY, defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item FIERY_PICKAXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":fiery_pickaxe", new FieryPickItem(TwilightItemTier.FIERY, defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item STEELEAF_INGOT = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_ingot", new Item(defaultBuilder()));
	public static final Item STEELEAF_HELMET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_helmet", new SteeleafArmorItem(TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.HEAD, defaultBuilder()));
	public static final Item STEELEAF_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_chestplate", new SteeleafArmorItem(TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.CHEST, defaultBuilder()));
	public static final Item STEELEAF_LEGGINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_leggings", new SteeleafArmorItem(TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.LEGS, defaultBuilder()));
	public static final Item STEELEAF_BOOTS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_boots", new SteeleafArmorItem(TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.FEET, defaultBuilder()));
	public static final Item STEELEAF_SWORD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_sword", new SteeleafSwordItem(TwilightItemTier.STEELEAF, defaultBuilder()));
	public static final Item STEELEAF_SHOVEL = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_shovel", new SteeleafShovelItem(TwilightItemTier.STEELEAF, defaultBuilder()));
	public static final Item STEELEAF_PICKAXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_pickaxe", new SteeleafPickItem(TwilightItemTier.STEELEAF, defaultBuilder()));
	public static final Item STEELEAF_AXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_axe", new SteeleafAxeItem(TwilightItemTier.STEELEAF, defaultBuilder()));
	public static final Item STEELEAF_HOE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":steeleaf_hoe", new SteeleafHoeItem(TwilightItemTier.STEELEAF, defaultBuilder()));
	public static final Item GOLDEN_MINOTAUR_AXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":gold_minotaur_axe", new MinotaurAxeItem(Tiers.GOLD, defaultBuilder().rarity(Rarity.COMMON)));
	public static final Item DIAMOND_MINOTAUR_AXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":diamond_minotaur_axe", new MinotaurAxeItem(Tiers.DIAMOND, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item MAZEBREAKER_PICKAXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":mazebreaker_pickaxe", new MazebreakerPickItem(Tiers.DIAMOND, defaultBuilder()/*.setNoRepair()*/.rarity(Rarity.RARE)));
	public static final Item TRANSFORMATION_POWDER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":transformation_powder", new TransformPowderItem(defaultBuilder()));
	public static final Item RAW_MEEF = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":raw_meef", new Item(defaultBuilder().food(MEEF_RAW)));
	public static final Item COOKED_MEEF = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":cooked_meef", new Item(defaultBuilder().food(MEEF_COOKED)));
	public static final Item MEEF_STROGANOFF = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":meef_stroganoff", new BowlFoodItem(defaultBuilder().food(STROGANOFF).stacksTo(1)));
	public static final Item MAZE_WAFER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":maze_wafer", new Item(defaultBuilder().food(WAFER)));
	public static final Item ORE_MAGNET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ore_magnet", new OreMagnetItem(defaultBuilder().durability(12)));
	public static final Item CRUMBLE_HORN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":crumble_horn", new CrumbleHornItem(defaultBuilder().durability(1024).rarity(Rarity.RARE)));
	public static final Item PEACOCK_FEATHER_FAN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":peacock_feather_fan", new PeacockFanItem(defaultBuilder().durability(1024).rarity(Rarity.RARE)));
	public static final Item MOONWORM_QUEEN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":moonworm_queen", new MoonwormQueenItem(defaultBuilder()/*.setNoRepair()*/.durability(256).rarity(Rarity.RARE)));
	public static final Item BRITTLE_FLASK = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":brittle_potion_flask", new BrittleFlaskItem(defaultBuilder().stacksTo(1)));
	public static final Item GREATER_FLASK = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":greater_potion_flask", new GreaterFlaskItem(defaultBuilder().rarity(Rarity.UNCOMMON).fireResistant().stacksTo(1)));
	public static final Item CHARM_OF_LIFE_1 = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":charm_of_life_1", new CuriosCharmItem(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item CHARM_OF_LIFE_2 = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":charm_of_life_2", new CuriosCharmItem(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item CHARM_OF_KEEPING_1 = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":charm_of_keeping_1", new CuriosCharmItem(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item CHARM_OF_KEEPING_2 = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":charm_of_keeping_2", new CuriosCharmItem(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item CHARM_OF_KEEPING_3 = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":charm_of_keeping_3", new CuriosCharmItem(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item TOWER_KEY = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":tower_key", new Item(defaultBuilder().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final Item BORER_ESSENCE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":borer_essence", new Item(defaultBuilder()));
	public static final Item CARMINITE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":carminite", new Item(defaultBuilder()));
	public static final Item EXPERIMENT_115 = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":experiment_115", new Experiment115Item(TFBlocks.EXPERIMENT_115, defaultBuilder().food(E115)));
	public static final Item ARMOR_SHARD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":armor_shard", new Item(defaultBuilder()));
	public static final Item ARMOR_SHARD_CLUSTER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":armor_shard_cluster", new Item(defaultBuilder()));
	public static final Item KNIGHTMETAL_INGOT = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_ingot", new Item(defaultBuilder()));
	public static final Item KNIGHTMETAL_HELMET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_helmet", new KnightmetalArmorItem(TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.HEAD, defaultBuilder()));
	public static final Item KNIGHTMETAL_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_chestplate", new KnightmetalArmorItem(TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.CHEST, defaultBuilder()));
	public static final Item KNIGHTMETAL_LEGGINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_leggings", new KnightmetalArmorItem(TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.LEGS, defaultBuilder()));
	public static final Item KNIGHTMETAL_BOOTS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_boots", new KnightmetalArmorItem(TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.FEET, defaultBuilder()));
	public static final Item KNIGHTMETAL_SWORD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_sword", new KnightmetalSwordItem(TwilightItemTier.KNIGHTMETAL, defaultBuilder()));
	public static final Item KNIGHTMETAL_PICKAXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_pickaxe", new KnightmetalPickItem(TwilightItemTier.KNIGHTMETAL, defaultBuilder()));
	public static final Item KNIGHTMETAL_AXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_axe", new KnightmetalAxeItem(TwilightItemTier.KNIGHTMETAL, defaultBuilder()));
	public static final Item KNIGHTMETAL_RING = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_ring", new Item(defaultBuilder()));
	public static final Item KNIGHTMETAL_SHIELD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knightmetal_shield", new KnightmetalShieldItem(defaultBuilder().durability(1024)));
	public static final Item BLOCK_AND_CHAIN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":block_and_chain", new ChainBlockItem(defaultBuilder().durability(99)));
	public static final Item PHANTOM_HELMET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":phantom_helmet", new PhantomArmorItem(TwilightArmorMaterial.ARMOR_PHANTOM, EquipmentSlot.HEAD, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item PHANTOM_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":phantom_chestplate", new PhantomArmorItem(TwilightArmorMaterial.ARMOR_PHANTOM, EquipmentSlot.CHEST, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item ICE_BOMB = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ice_bomb", new IceBombItem(defaultBuilder().stacksTo(16)));
	public static final Item ARCTIC_FUR = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":arctic_fur", new Item(defaultBuilder()));
	public static final Item ARCTIC_HELMET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":arctic_helmet", new ArcticArmorItem(TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.HEAD, defaultBuilder()));
	public static final Item ARCTIC_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":arctic_chestplate", new ArcticArmorItem(TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.CHEST, defaultBuilder()));
	public static final Item ARCTIC_LEGGINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":arctic_leggings", new ArcticArmorItem(TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.LEGS, defaultBuilder()));
	public static final Item ARCTIC_BOOTS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":arctic_boots", new ArcticArmorItem(TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.FEET, defaultBuilder()));
	public static final Item ALPHA_YETI_FUR = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":alpha_yeti_fur", new Item(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item YETI_HELMET = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":yeti_helmet", new YetiArmorItem(TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.HEAD, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item YETI_CHESTPLATE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":yeti_chestplate", new YetiArmorItem(TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.CHEST, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item YETI_LEGGINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":yeti_leggings", new YetiArmorItem(TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.LEGS, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item YETI_BOOTS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":yeti_boots", new YetiArmorItem(TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.FEET, defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item TRIPLE_BOW = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":triple_bow", new TripleBowItem(defaultBuilder().rarity(Rarity.UNCOMMON).durability(384)));
	public static final Item SEEKER_BOW = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":seeker_bow", new SeekerBowItem(defaultBuilder().rarity(Rarity.UNCOMMON).durability(384)));
	public static final Item ICE_BOW = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ice_bow", new IceBowItem(defaultBuilder().rarity(Rarity.UNCOMMON).durability(384)));
	public static final Item ENDER_BOW = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ender_bow", new EnderBowItem(defaultBuilder().rarity(Rarity.UNCOMMON).durability(384)));
	public static final Item ICE_SWORD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ice_sword", new IceSwordItem(TwilightItemTier.ICE, defaultBuilder()));
	public static final Item GLASS_SWORD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":glass_sword", new GlassSwordItem(TwilightItemTier.GLASS, defaultBuilder()/*.setNoRepair()*/.rarity(Rarity.RARE)));
	public static final Item MAGIC_BEANS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":magic_beans", new MagicBeansItem(defaultBuilder()));
	public static final Item GIANT_PICKAXE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":giant_pickaxe", new GiantPickItem(TwilightItemTier.GIANT, defaultBuilder()));
	public static final Item GIANT_SWORD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":giant_sword", new GiantSwordItem(TwilightItemTier.GIANT, defaultBuilder()));
	public static final Item LAMP_OF_CINDERS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":lamp_of_cinders", new LampOfCindersItem(defaultBuilder().fireResistant().durability(1024).rarity(Rarity.UNCOMMON)));
	public static final Item CUBE_TALISMAN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":cube_talisman", new Item(defaultBuilder().rarity(Rarity.UNCOMMON)));
	public static final Item CUBE_OF_ANNIHILATION = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":cube_of_annihilation", new CubeOfAnnihilationItem(unstackable().rarity(Rarity.UNCOMMON)));
	public static final Item MOON_DIAL = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":moon_dial", new Item(defaultBuilder()));

	public static final Item MUSIC_DISC_RADIANCE = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_radiance", new RecordItem(15, TFSounds.MUSIC_DISC_RADIANCE, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_STEPS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_steps", new RecordItem(15, TFSounds.MUSIC_DISC_STEPS, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_SUPERSTITIOUS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_superstitious", new RecordItem(15, TFSounds.MUSIC_DISC_SUPERSTITIOUS, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_HOME = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_home", new RecordItem(15, TFSounds.MUSIC_DISC_HOME, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_WAYFARER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_wayfarer", new RecordItem(15, TFSounds.MUSIC_DISC_WAYFARER, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_FINDINGS = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_findings", new RecordItem(15, TFSounds.MUSIC_DISC_FINDINGS, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_MAKER = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_maker", new RecordItem(15, TFSounds.MUSIC_DISC_MAKER, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_THREAD = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_thread", new RecordItem(15, TFSounds.MUSIC_DISC_THREAD, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_MOTION = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":music_disc_motion", new RecordItem(15, TFSounds.MUSIC_DISC_MOTION, defaultBuilder().stacksTo(1).rarity(Rarity.RARE)));

	public static final Item NAGA_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":naga_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_NAGA"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item LICH_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":lich_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_LICH"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item MINOSHROOM_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":minoshroom_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_MINOSHROOM"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item HYDRA_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":hydra_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_HYDRA"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item KNIGHT_PHANTOM_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":knight_phantom_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_PHANTOMS"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item UR_GHAST_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":ur_ghast_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_UR_GHAST"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item ALPHA_YETI_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":alpha_yeti_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_ALPHA_YETI"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item SNOW_QUEEN_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":snow_queen_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_SNOW_QUEEN"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));
	public static final Item QUEST_RAM_BANNER_PATTERN = Registry.register(Registry.ITEM, TwilightForestMod.ID + ":quest_ram_banner_pattern", new BannerPatternItem(ClassTinkerers.getEnum(BannerPattern.class,"TF_QUEST_RAM"), defaultBuilder().stacksTo(1).rarity(TwilightForestMod.getRarity())));

	public static void init(){
	}

	public static Item.Properties defaultBuilder() {
		return new Item.Properties().tab(creativeTab);
	}

	public static Item.Properties unstackable() {
		return defaultBuilder().stacksTo(1);
	}

	@Environment(EnvType.CLIENT)
	public static void addItemModelProperties() {
		ItemProperties.register(CUBE_OF_ANNIHILATION, TwilightForestMod.prefix("thrown"), (stack, world, entity, idk) ->
				CubeOfAnnihilationItem.getThrownUuid(stack) != null ? 1 : 0);

		ItemProperties.register(TFItems.KNIGHTMETAL_SHIELD, new ResourceLocation("blocking"), (stack, world, entity, idk) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

		ItemProperties.register(MOON_DIAL, new ResourceLocation("phase"), new ClampedItemPropertyFunction() {
			@Override
			public float call(ItemStack stack, @Nullable ClientLevel world, @Nullable LivingEntity entityBase, int idk) {
				boolean flag = entityBase != null;
				Entity entity = flag ? entityBase : stack.getFrame();

				if (world == null && entity != null) world = (ClientLevel) entity.level;

				return world == null ? 0.0F : (float) (world.dimensionType().natural() ? Mth.frac(world.getMoonPhase() / 8.0f) : this.wobble(world, Math.random()));
			}

			@Override
			public float unclampedCall(ItemStack itemStack, @org.jetbrains.annotations.Nullable ClientLevel clientLevel, @org.jetbrains.annotations.Nullable LivingEntity livingEntity, int i) {
				return call(itemStack, clientLevel, livingEntity, i);
			}

			@Environment(EnvType.CLIENT)
			double rotation;
			@Environment(EnvType.CLIENT)
			double rota;
			@Environment(EnvType.CLIENT)
			long lastUpdateTick;

			@Environment(EnvType.CLIENT)
			private double wobble(Level world, double rotation) {
				if (world.getGameTime() != this.lastUpdateTick) {
					this.lastUpdateTick = world.getGameTime();
					double delta = rotation - this.rotation;
					delta = Mth.positiveModulo(delta + 0.5D, 1.0D) - 0.5D;
					this.rota += delta * 0.1D;
					this.rota *= 0.9D;
					this.rotation = Mth.positiveModulo(this.rotation + this.rota, 1.0D);
				}
				return this.rotation;
			}
		});

		ItemProperties.register(MOONWORM_QUEEN, TwilightForestMod.prefix("alt"), (stack, world, entity, idk) -> {
			if (entity != null && entity.getUseItem() == stack) {
				int useTime = stack.getUseDuration() - entity.getUseItemRemainingTicks();
				if (useTime >= MoonwormQueenItem.FIRING_TIME && (useTime >>> 1) % 2 == 0) {
					return 1;
				}
			}
			return 0;
		});

		ItemProperties.register(TFItems.ENDER_BOW, new ResourceLocation("pull"), (stack, world, entity, idk) -> {
			if(entity == null) return 0.0F;
			else return entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F; });

		ItemProperties.register(TFItems.ENDER_BOW, new ResourceLocation("pulling"), (stack, world, entity, idk) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

		ItemProperties.register(TFItems.ICE_BOW, new ResourceLocation("pull"), (stack, world, entity, idk) -> {
			if(entity == null) return 0.0F;
			else return entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F; });

		ItemProperties.register(TFItems.ICE_BOW, new ResourceLocation("pulling"), (stack, world, entity, idk) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

		ItemProperties.register(TFItems.SEEKER_BOW, new ResourceLocation("pull"), (stack, world, entity, idk) -> {
			if (entity == null) return 0.0F;
			else return entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F; });

		ItemProperties.register(TFItems.SEEKER_BOW, new ResourceLocation("pulling"), (stack, world, entity, idk) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

		ItemProperties.register(TFItems.TRIPLE_BOW, new ResourceLocation("pull"), (stack, world, entity, idk) -> {
			if (entity == null) return 0.0F;
			else return entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F; });

		ItemProperties.register(TFItems.TRIPLE_BOW, new ResourceLocation("pulling"), (stack, world, entity, idk) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

		ItemProperties.register(ORE_MAGNET, new ResourceLocation("pull"), (stack, world, entity, idk) -> {
			if (entity == null) return 0.0F;
			else {
				ItemStack itemstack = entity.getUseItem();
				return !itemstack.isEmpty() ? (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F : 0.0F;
			}});

		ItemProperties.register(ORE_MAGNET, new ResourceLocation("pulling"), (stack, world, entity, idk) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

		ItemProperties.register(BLOCK_AND_CHAIN, TwilightForestMod.prefix("thrown"), (stack, world, entity, idk) ->
				ChainBlockItem.getThrownUuid(stack) != null ? 1 : 0);

		ItemProperties.register(EXPERIMENT_115, Experiment115Item.THINK, (stack, world, entity, idk) ->
				stack.hasTag() && stack.getTag().contains("think") ? 1 : 0);

		ItemProperties.register(EXPERIMENT_115, Experiment115Item.FULL, (stack, world, entity, idk) ->
				stack.hasTag() && stack.getTag().contains("full") ? 1 : 0);

		ItemProperties.register(TFItems.BRITTLE_FLASK, TwilightForestMod.prefix("breakage"), (stack, world, entity, i) ->
				stack.getOrCreateTag().getInt("Breakage"));

		ItemProperties.register(TFItems.BRITTLE_FLASK, TwilightForestMod.prefix("potion_level"), (stack, world, entity, i) ->
				stack.getOrCreateTag().getInt("Uses"));

		ItemProperties.register(TFItems.GREATER_FLASK, TwilightForestMod.prefix("potion_level"), (stack, world, entity, i) ->
				stack.getOrCreateTag().getInt("Uses"));
	}
}
