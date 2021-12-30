package twilightforest.data;

import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;

import me.alphamode.forgetags.Tags;
import net.fabricmc.fabric.api.tag.TagFactory;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;

public class ItemTagGenerator extends ItemTagsProvider {
	public static final Tag.Named<Item> TWILIGHT_OAK_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("twilight_oak_logs"));
	public static final Tag.Named<Item> CANOPY_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("canopy_logs"));
	public static final Tag.Named<Item> MANGROVE_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("mangrove_logs"));
	public static final Tag.Named<Item> DARKWOOD_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("darkwood_logs"));
	public static final Tag.Named<Item> TIME_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("timewood_logs"));
	public static final Tag.Named<Item> TRANSFORMATION_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("transwood_logs"));
	public static final Tag.Named<Item> MINING_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("mining_logs"));
	public static final Tag.Named<Item> SORTING_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("sortwood_logs"));

	public static final Tag.Named<Item> TWILIGHT_LOGS = TagFactory.ITEM.create(TwilightForestMod.prefix("logs"));
	public static final Tag.Named<Item> TF_FENCES = TagFactory.ITEM.create(TwilightForestMod.prefix("fences"));
	public static final Tag.Named<Item> TF_FENCE_GATES = TagFactory.ITEM.create(TwilightForestMod.prefix("fence_gates"));

	public static final Tag.Named<Item> PAPER = TagFactory.ITEM.create(new ResourceLocation("c:paper"));

	public static final Tag.Named<Item> TOWERWOOD = TagFactory.ITEM.create(TwilightForestMod.prefix("towerwood"));

	public static final Tag.Named<Item> FIERY_VIAL = TagFactory.ITEM.create(TwilightForestMod.prefix("fiery_vial"));

	public static final Tag.Named<Item> ARCTIC_FUR = TagFactory.ITEM.create(TwilightForestMod.prefix("arctic_fur"));
	public static final Tag.Named<Item> CARMINITE_GEMS = TagFactory.ITEM.create(new ResourceLocation("c:carminite_gems"));
	public static final Tag.Named<Item> FIERY_INGOTS = TagFactory.ITEM.create(new ResourceLocation("c:fiery_ingots"));
	public static final Tag.Named<Item> IRONWOOD_INGOTS = TagFactory.ITEM.create(new ResourceLocation("c:ironwood_ingots"));
	public static final Tag.Named<Item> KNIGHTMETAL_INGOTS = TagFactory.ITEM.create(new ResourceLocation("c:knightmetal_ingots"));
	public static final Tag.Named<Item> STEELEAF_INGOTS = TagFactory.ITEM.create(new ResourceLocation("c:steeleaf_ingots"));

	public static final Tag.Named<Item> STORAGE_BLOCKS_ARCTIC_FUR = TagFactory.ITEM.create(new ResourceLocation("c:arctic_fur_storage_blocks"));
	public static final Tag.Named<Item> STORAGE_BLOCKS_CARMINITE = TagFactory.ITEM.create(new ResourceLocation("c:carminite_storage_blocks"));
	public static final Tag.Named<Item> STORAGE_BLOCKS_FIERY = TagFactory.ITEM.create(new ResourceLocation("c:fiery_storage_blocks"));
	public static final Tag.Named<Item> STORAGE_BLOCKS_IRONWOOD = TagFactory.ITEM.create(new ResourceLocation("c:ironwood_storage_blocks"));
	public static final Tag.Named<Item> STORAGE_BLOCKS_KNIGHTMETAL = TagFactory.ITEM.create(new ResourceLocation("c:knightmetal_storage_blocks"));
	public static final Tag.Named<Item> STORAGE_BLOCKS_STEELEAF = TagFactory.ITEM.create(new ResourceLocation("c:steeleaf_storage_blocks"));

	public static final Tag.Named<Item> ORES_IRONWOOD = TagFactory.ITEM.create(new ResourceLocation("c:ironwood_ores"));
	public static final Tag.Named<Item> ORES_KNIGHTMETAL = TagFactory.ITEM.create(new ResourceLocation("c:knightmetal_ores"));

	public static final Tag.Named<Item> PORTAL_ACTIVATOR = TagFactory.ITEM.create(TwilightForestMod.prefix("portal/activator"));

	public static final Tag.Named<Item> WIP = TagFactory.ITEM.create(TwilightForestMod.prefix("wip"));
	public static final Tag.Named<Item> NYI = TagFactory.ITEM.create(TwilightForestMod.prefix("nyi"));

	public static final Tag.Named<Item> KOBOLD_PACIFICATION_BREADS = TagFactory.ITEM.create(TwilightForestMod.prefix("kobold_pacification_breads"));

	public static final Tag.Named<Item> TF_MUSIC_DISCS = TagFactory.ITEM.create(TwilightForestMod.prefix("tf_music_discs"));

	public static final Tag.Named<Item> BANNED_UNCRAFTING_INGREDIENTS = TagFactory.ITEM.create(TwilightForestMod.prefix("banned_uncrafting_ingredients"));
	public static final Tag.Named<Item> BANNED_UNCRAFTABLES = TagFactory.ITEM.create(TwilightForestMod.prefix("banned_uncraftables"));

	public ItemTagGenerator(DataGenerator generator, BlockTagsProvider blockprovider) {
		super(generator, blockprovider);
	}

	@Override
	protected void addTags() {
		this.copy(BlockTagGenerator.TWILIGHT_OAK_LOGS, TWILIGHT_OAK_LOGS);
		this.copy(BlockTagGenerator.CANOPY_LOGS, CANOPY_LOGS);
		this.copy(BlockTagGenerator.MANGROVE_LOGS, MANGROVE_LOGS);
		this.copy(BlockTagGenerator.DARKWOOD_LOGS, DARKWOOD_LOGS);
		this.copy(BlockTagGenerator.TIME_LOGS, TIME_LOGS);
		this.copy(BlockTagGenerator.TRANSFORMATION_LOGS, TRANSFORMATION_LOGS);
		this.copy(BlockTagGenerator.MINING_LOGS, MINING_LOGS);
		this.copy(BlockTagGenerator.SORTING_LOGS, SORTING_LOGS);

		this.copy(BlockTagGenerator.TF_LOGS, TWILIGHT_LOGS);
		tag(ItemTags.LOGS).addTag(TWILIGHT_LOGS);
		tag(ItemTags.LOGS_THAT_BURN)
				.addTag(TWILIGHT_OAK_LOGS).addTag(CANOPY_LOGS).addTag(MANGROVE_LOGS)
				.addTag(TIME_LOGS).addTag(TRANSFORMATION_LOGS).addTag(MINING_LOGS).addTag(SORTING_LOGS);

		this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
		this.copy(BlockTags.LEAVES, ItemTags.LEAVES);

		this.copy(BlockTags.PLANKS, ItemTags.PLANKS);

		this.copy(BlockTagGenerator.TF_FENCES, TF_FENCES);
		this.copy(BlockTagGenerator.TF_FENCE_GATES, TF_FENCE_GATES);
		this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
		this.copy(Tags.Blocks.FENCES, Tags.Items.FENCES);
		this.copy(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
		this.copy(Tags.Blocks.FENCES_WOODEN, Tags.Items.FENCES_WOODEN);
		this.copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);

		this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
		this.copy(BlockTags.SLABS, ItemTags.SLABS);
		this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
		this.copy(BlockTags.STAIRS, ItemTags.STAIRS);

		this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
		this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

		this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
		this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
		tag(ItemTags.SIGNS).add(TFBlocks.TWILIGHT_OAK_SIGN.get().asItem(), TFBlocks.CANOPY_SIGN.get().asItem(),
				TFBlocks.MANGROVE_SIGN.get().asItem(), TFBlocks.DARKWOOD_SIGN.get().asItem(),
				TFBlocks.TIME_SIGN.get().asItem(), TFBlocks.TRANSFORMATION_SIGN.get().asItem(),
				TFBlocks.MINING_SIGN.get().asItem(), TFBlocks.SORTING_SIGN.get().asItem());

		this.copy(Tags.Blocks.CHESTS_WOODEN, Tags.Items.CHESTS_WOODEN);

		this.copy(BlockTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR, STORAGE_BLOCKS_ARCTIC_FUR);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_CARMINITE, STORAGE_BLOCKS_CARMINITE);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_FIERY, STORAGE_BLOCKS_FIERY);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_IRONWOOD, STORAGE_BLOCKS_IRONWOOD);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL, STORAGE_BLOCKS_KNIGHTMETAL);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_STEELEAF, STORAGE_BLOCKS_STEELEAF);

		tag(Tags.Items.STORAGE_BLOCKS)
				.addTag(STORAGE_BLOCKS_FIERY).addTag(STORAGE_BLOCKS_ARCTIC_FUR)
				.addTag(STORAGE_BLOCKS_CARMINITE).addTag(STORAGE_BLOCKS_IRONWOOD)
				.addTag(STORAGE_BLOCKS_KNIGHTMETAL).addTag(STORAGE_BLOCKS_STEELEAF);

		this.copy(BlockTagGenerator.ORES_IRONWOOD, ORES_IRONWOOD);
		this.copy(BlockTagGenerator.ORES_KNIGHTMETAL, ORES_KNIGHTMETAL);

		tag(Tags.Items.ORES).addTag(ORES_IRONWOOD).addTag(ORES_KNIGHTMETAL);

		this.copy(BlockTagGenerator.TOWERWOOD, TOWERWOOD);

		tag(PAPER).add(Items.PAPER);
		tag(Tags.Items.FEATHERS).add(Items.FEATHER).add(TFItems.RAVEN_FEATHER.get());

		tag(FIERY_VIAL).add(TFItems.FIERY_BLOOD.get(), TFItems.FIERY_TEARS.get());

		tag(ARCTIC_FUR).add(TFItems.ARCTIC_FUR.get());
		tag(CARMINITE_GEMS).add(TFItems.CARMINITE.get());
		tag(FIERY_INGOTS).add(TFItems.FIERY_INGOT.get());
		tag(IRONWOOD_INGOTS).add(TFItems.IRONWOOD_INGOT.get());
		tag(KNIGHTMETAL_INGOTS).add(TFItems.KNIGHTMETAL_INGOT.get());
		tag(STEELEAF_INGOTS).add(TFItems.STEELEAF_INGOT.get());

		tag(Tags.Items.GEMS).addTag(CARMINITE_GEMS);

		tag(Tags.Items.INGOTS)
				.addTag(IRONWOOD_INGOTS).addTag(FIERY_INGOTS)
				.addTag(KNIGHTMETAL_INGOTS).addTag(STEELEAF_INGOTS);

		tag(ORES_IRONWOOD).add(TFItems.RAW_IRONWOOD.get());
		tag(ORES_KNIGHTMETAL).add(TFItems.ARMOR_SHARD_CLUSTER.get());

		tag(PORTAL_ACTIVATOR).addTag(Tags.Items.GEMS_DIAMOND);

		tag(ItemTags.FREEZE_IMMUNE_WEARABLES).add(
				TFItems.FIERY_HELMET.get(),
				TFItems.FIERY_CHESTPLATE.get(),
				TFItems.FIERY_LEGGINGS.get(),
				TFItems.FIERY_BOOTS.get(),
				TFItems.ARCTIC_HELMET.get(),
				TFItems.ARCTIC_CHESTPLATE.get(),
				TFItems.ARCTIC_LEGGINGS.get(),
				TFItems.ARCTIC_BOOTS.get(),
				TFItems.YETI_HELMET.get(),
				TFItems.YETI_CHESTPLATE.get(),
				TFItems.YETI_LEGGINGS.get(),
				TFItems.YETI_BOOTS.get()
		);

		tag(WIP).add(
				TFBlocks.KEEPSAKE_CASKET.get().asItem(),
				TFItems.CUBE_OF_ANNIHILATION.get()
		);

		tag(NYI).add(
				TFBlocks.CINDER_FURNACE.get().asItem(),
				TFBlocks.CINDER_LOG.get().asItem(),
				TFBlocks.CINDER_WOOD.get().asItem(),
				TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get().asItem(),
				TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE.get().asItem(),
				TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get().asItem(),
				TFBlocks.AURORALIZED_GLASS.get().asItem(),
				TFBlocks.SLIDER.get().asItem(),
				TFBlocks.TWISTED_STONE.get().asItem(),
				TFBlocks.TWISTED_STONE_PILLAR.get().asItem(),
				TFItems.ORE_METER.get()
		);

		tag(KOBOLD_PACIFICATION_BREADS).add(Items.BREAD);

		tag(TF_MUSIC_DISCS).add(
				TFItems.MUSIC_DISC_FINDINGS.get(),
				TFItems.MUSIC_DISC_HOME.get(),
				TFItems.MUSIC_DISC_MAKER.get(),
				TFItems.MUSIC_DISC_MOTION.get(),
				TFItems.MUSIC_DISC_RADIANCE.get(),
				TFItems.MUSIC_DISC_STEPS.get(),
				TFItems.MUSIC_DISC_SUPERSTITIOUS.get(),
				TFItems.MUSIC_DISC_THREAD.get(),
				TFItems.MUSIC_DISC_WAYFARER.get());

		tag(ItemTags.MUSIC_DISCS).addTag(TF_MUSIC_DISCS);

		tag(BANNED_UNCRAFTING_INGREDIENTS).add(
				TFBlocks.INFESTED_TOWERWOOD.get().asItem(),
				TFBlocks.HOLLOW_OAK_SAPLING.get().asItem(),
				TFBlocks.TIME_SAPLING.get().asItem(),
				TFBlocks.TRANSFORMATION_SAPLING.get().asItem(),
				TFBlocks.MINING_SAPLING.get().asItem(),
				TFBlocks.SORTING_SAPLING.get().asItem());

		tag(BANNED_UNCRAFTABLES).add(TFBlocks.GIANT_LOG.get().asItem());

		tag(ItemTags.PIGLIN_LOVED).add(TFItems.GOLDEN_MINOTAUR_AXE.get(), TFItems.CHARM_OF_KEEPING_3.get(), TFItems.CHARM_OF_LIFE_2.get(), TFItems.LAMP_OF_CINDERS.get());
	}
}
