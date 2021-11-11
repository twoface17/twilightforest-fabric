package twilightforest;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.Maps;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shadow.cloth.autoconfig.serializer.Toml4jConfigSerializerExtended;
import twilightforest.advancements.TFAdvancements;
import twilightforest.api.TFInternalApi;
import twilightforest.block.TFBlocks;
import twilightforest.block.entity.TFBlockEntities;
import twilightforest.client.particle.TFParticleType;
import twilightforest.command.TFCommand;
import twilightforest.compat.TFCompat;
import twilightforest.compat.clothConfig.configFiles.TFConfigCommon;
import twilightforest.data.BlockTagGenerator;
import twilightforest.data.DataGenerators;
import twilightforest.dispenser.CrumbleDispenseBehavior;
import twilightforest.dispenser.FeatherFanDispenseBehavior;
import twilightforest.dispenser.MoonwormDispenseBehavior;
import twilightforest.dispenser.TransformationDispenseBehavior;
import twilightforest.enchantment.TFEnchantments;
import twilightforest.entity.TFEntities;
import twilightforest.entity.projectile.MoonwormShot;
import twilightforest.entity.projectile.TwilightWandBolt;
import twilightforest.item.TFItems;
import twilightforest.loot.TFTreasure;
import twilightforest.network.TFPacketHandler;
import twilightforest.potions.TFPotions;
import twilightforest.world.components.BiomeGrassColors;
import twilightforest.util.TFStats;
import twilightforest.world.components.feature.BlockSpikeFeature;
import twilightforest.world.registration.*;
import twilightforest.world.registration.biomes.BiomeKeys;

import java.util.Locale;

import net.minecraft.world.item.Rarity;

public class TwilightForestMod implements ModInitializer {

	// TODO: might be a good idea to find proper spots for all of these? also remove redundants
	public static final String ID = "twilightforest";

    private static final String MODEL_DIR = "textures/model/";
	private static final String GUI_DIR = "textures/gui/";
	private static final String ENVIRO_DIR = "textures/environment/";
	// odd one out, as armor textures are a stringy mess at present
	private static final String ARMOR_DIR = "textures/armor/";

	public static final GameRules.Key<GameRules.BooleanValue> ENFORCED_PROGRESSION_RULE = GameRuleRegistry.register("tfEnforcedProgression", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true)); //Putting it in UPDATES since other world stuff is here

    public static CreativeModeTab creativeTab = FabricItemGroupBuilder.build(TwilightForestMod.prefix(TwilightForestMod.ID), () -> new ItemStack(TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE));

    // TODO: might be a good idea to find proper spots for all of these? also remove redundants

    public static final Logger LOGGER = LogManager.getLogger(ID);

	public static final Rarity rarity = ClassTinkerers.getEnum(Rarity.class, "TWILIGHT");


	public static boolean SERVER_SIDE_ONLY = true;

    @Override
	public void onInitialize() {
		TwilightForestMod();
		init();

	}

	public void TwilightForestMod() {
		// FIXME: safeRunWhenOn is being real jank for some reason, look into it
		//noinspection Convert2Lambda,Anonymous2MethodRef

		//Cloth Config Setup
		clothConfigSetup();

		registerCommands();

		TFBlocks.registerItemblocks();
		TFItems.init();
		TFPotions.init();  //TFPotions.POTIONS.register(modbus);
		BiomeKeys.init();
		//modbus.addGenericListener(SoundEvent.class, TFSounds::registerSounds);
		TFBlockEntities.init();
		TFParticleType.init();
		TFEnchantments.init();
		TFStructures.registerFabricEvents();
		TFBiomeFeatures.init();
		//TFContainers.CONTAINERS.register(modbus);
		//TFEnchantments.ENCHANTMENTS.register(modbus);

		TFStructureProcessors.init();
		TreeConfigurations.init();
		TreeDecorators.init();
		TFStructures.register();
		ConfiguredWorldCarvers.register();
		TwilightFeatures.registerPlacementConfigs();
		ConfiguredFeatures.init();
		TwilightSurfaceBuilders.register();
		registerSerializers();

		// Poke these so they exist when we need them FIXME this is probably terrible design
		new TwilightFeatures();
		new BiomeGrassColors();

		if (TFConfig.COMMON_CONFIG.doCompat) {
			try {
				TFCompat.preInitCompat();
			} catch (Exception e) {
				TFConfig.COMMON_CONFIG.doCompat = false;
				LOGGER.error("Had an error loading preInit compatibility!");
				LOGGER.catching(e.fillInStackTrace());
			}
		} else {
			LOGGER.warn("Skipping compatibility!");
		}

		WoodType.register(TFBlocks.TWILIGHT_OAK);
		WoodType.register(TFBlocks.CANOPY);
		WoodType.register(TFBlocks.MANGROVE);
		WoodType.register(TFBlocks.DARKWOOD);
		WoodType.register(TFBlocks.TIMEWOOD);
		WoodType.register(TFBlocks.TRANSFORMATION);
		WoodType.register(TFBlocks.MINING);
		WoodType.register(TFBlocks.SORTING);
	}

	//TODO: PORT THE NEW LEGACY/CLASSIC LOADING PROCESS
	/*
	@SubscribeEvent
	public static void addClassicPack(AddPackFindersEvent event) {
		try {
			if (event.getPackType() == PackType.CLIENT_RESOURCES) {
				var resourcePath = ModList.get().getModFileById(TwilightForestMod.ID).getFile().findResource("classic");
				var pack = new PathResourcePack(ModList.get().getModFileById(TwilightForestMod.ID).getFile().getFileName() + ":" + resourcePath, resourcePath);
				var metadataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
				if (metadataSection != null) {
					event.addRepositorySource((packConsumer, packConstructor) ->
							packConsumer.accept(packConstructor.create(
									"builtin/twilight_forest_legacy_resources", new TextComponent("Twilight Classic"), false,
									() -> pack, metadataSection, Pack.Position.TOP, PackSource.BUILT_IN, false)));
				}
			}
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	 */

	public static void registerSerializers() {
		//How do I add a condition serializer as fast as possible? An event that fires really early
		//CraftingHelper.register(new UncraftingEnabledCondition.Serializer());
		TFTreasure.init();
	}

	public void registerCommands() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> TFCommand.register(dispatcher));
	}

//	@SubscribeEvent
//	public static void registerLootModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> evt) {
//		evt.getRegistry().register(new FieryPickItem.Serializer().setRegistryName(ID + ":fiery_pick_smelting"));
//		evt.getRegistry().register(new TFEventListener.Serializer().setRegistryName(ID + ":giant_block_grouping"));
//	}

//	@SubscribeEvent
//	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
//		event.register(IShieldCapability.class);
//	}

	public void sendIMCs() {
		TFCompat.IMCSender();
	}

	public static void init() {
		TFPacketHandler.init();
		TFAdvancements.init();
		BiomeKeys.addBiomeTypes();
		TFDimensions.init();
		TFStats.init();

		{
			TFEntities.registerEntities();
			TFEntities.addEntityAttributes();
			TFEntities.registerSpawnEggs();
		}

		TFEventListener.registerFabricEvents();

		if (TFConfig.COMMON_CONFIG.doCompat) {
			try {
				TFCompat.initCompat();
			} catch (Exception e) {
				TFConfig.COMMON_CONFIG.doCompat = false;
				LOGGER.error("Had an error loading init compatibility!");
				LOGGER.catching(e.fillInStackTrace());
			}
		}

		if (TFConfig.COMMON_CONFIG.doCompat) {
			try {
				TFCompat.postInitCompat();
			} catch (Exception e) {
				TFConfig.COMMON_CONFIG.doCompat = false;
				LOGGER.error("Had an error loading postInit compatibility!");
				LOGGER.catching(e.fillInStackTrace());
			}
		}

		BlockSpikeFeature.loadStalactites();

		{
			TFBlocks.tfCompostables();
			TFBlocks.TFBurnables();
			TFBlocks.TFPots();
			TFSounds.registerParrotSounds();

			//TODO: PORT????
			/*
			CauldronInteraction.WATER.put(TFItems.ARCTIC_HELMET.get(), CauldronInteraction.DYED_ITEM);
			CauldronInteraction.WATER.put(TFItems.ARCTIC_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);
			CauldronInteraction.WATER.put(TFItems.ARCTIC_LEGGINGS.get(), CauldronInteraction.DYED_ITEM);
			CauldronInteraction.WATER.put(TFItems.ARCTIC_BOOTS.get(), CauldronInteraction.DYED_ITEM);
			 */

			AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
			AxeItem.STRIPPABLES.put(TFBlocks.TWILIGHT_OAK_LOG, TFBlocks.STRIPPED_TWILIGHT_OAK_LOG);
			AxeItem.STRIPPABLES.put(TFBlocks.CANOPY_LOG, TFBlocks.STRIPPED_CANOPY_LOG);
			AxeItem.STRIPPABLES.put(TFBlocks.MANGROVE_LOG, TFBlocks.STRIPPED_MANGROVE_LOG);
			AxeItem.STRIPPABLES.put(TFBlocks.DARK_LOG, TFBlocks.STRIPPED_DARK_LOG);
			AxeItem.STRIPPABLES.put(TFBlocks.TIME_LOG, TFBlocks.STRIPPED_TIME_LOG);
			AxeItem.STRIPPABLES.put(TFBlocks.TRANSFORMATION_LOG, TFBlocks.STRIPPED_TRANSFORMATION_LOG);
			AxeItem.STRIPPABLES.put(TFBlocks.MINING_LOG, TFBlocks.STRIPPED_MINING_LOG);
			AxeItem.STRIPPABLES.put(TFBlocks.SORTING_LOG, TFBlocks.STRIPPED_SORTING_LOG);

			AxeItem.STRIPPABLES.put(TFBlocks.TWILIGHT_OAK_WOOD, TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD);
			AxeItem.STRIPPABLES.put(TFBlocks.CANOPY_WOOD, TFBlocks.STRIPPED_CANOPY_WOOD);
			AxeItem.STRIPPABLES.put(TFBlocks.MANGROVE_WOOD, TFBlocks.STRIPPED_MANGROVE_WOOD);
			AxeItem.STRIPPABLES.put(TFBlocks.DARK_WOOD, TFBlocks.STRIPPED_DARK_WOOD);
			AxeItem.STRIPPABLES.put(TFBlocks.TIME_WOOD, TFBlocks.STRIPPED_TIME_WOOD);
			AxeItem.STRIPPABLES.put(TFBlocks.TRANSFORMATION_WOOD, TFBlocks.STRIPPED_TRANSFORMATION_WOOD);
			AxeItem.STRIPPABLES.put(TFBlocks.MINING_WOOD, TFBlocks.STRIPPED_MINING_WOOD);
			AxeItem.STRIPPABLES.put(TFBlocks.SORTING_WOOD, TFBlocks.STRIPPED_SORTING_WOOD);

			DispenserBlock.registerBehavior(TFItems.MOONWORM_QUEEN, new MoonwormDispenseBehavior() {
				@Override
				protected Projectile getProjectileEntity(Level worldIn, Position position, ItemStack stackIn) {
					return new MoonwormShot(worldIn, position.x(), position.y(), position.z());
				}
			});

			DispenseItemBehavior idispenseitembehavior = new OptionalDispenseItemBehavior() {
				/**
				 * Dispense the specified stack, play the dispense sound and spawn particles.
				 */
				protected ItemStack execute(BlockSource source, ItemStack stack) {
					this.setSuccess(ArmorItem.dispenseArmor(source, stack));
					return stack;
				}
			};
			DispenserBlock.registerBehavior(TFBlocks.NAGA_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.LICH_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.MINOSHROOM_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.HYDRA_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.KNIGHT_PHANTOM_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.UR_GHAST_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.SNOW_QUEEN_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.QUEST_RAM_TROPHY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.CICADA.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.FIREFLY.asItem(), idispenseitembehavior);
			DispenserBlock.registerBehavior(TFBlocks.MOONWORM.asItem(), idispenseitembehavior);

			DispenseItemBehavior pushmobsbehavior = new FeatherFanDispenseBehavior();
			DispenserBlock.registerBehavior(TFItems.PEACOCK_FEATHER_FAN.asItem(), pushmobsbehavior);

			DispenseItemBehavior crumblebehavior = new CrumbleDispenseBehavior();
			DispenserBlock.registerBehavior(TFItems.CRUMBLE_HORN.asItem(), crumblebehavior);

			DispenseItemBehavior transformbehavior = new TransformationDispenseBehavior();
			DispenserBlock.registerBehavior(TFItems.TRANSFORMATION_POWDER.asItem(), transformbehavior);

			DispenserBlock.registerBehavior(TFItems.TWILIGHT_SCEPTER, new MoonwormDispenseBehavior() {
				@Override
				protected Projectile getProjectileEntity(Level worldIn, Position position, ItemStack stackIn) {
					return new TwilightWandBolt(worldIn, position.x(), position.y(), position.z());
				}

				@Override
				protected void playSound(BlockSource source) {
					BlockPos pos = source.getPos();
					source.getLevel().playSound(null, pos, TFSounds.SCEPTER_PEARL, SoundSource.BLOCKS, 1, 1);
				}
			});
			WoodType.register(TFBlocks.TWILIGHT_OAK);
			WoodType.register(TFBlocks.CANOPY);
			WoodType.register(TFBlocks.MANGROVE);
			WoodType.register(TFBlocks.DARKWOOD);
			WoodType.register(TFBlocks.TIMEWOOD);
			WoodType.register(TFBlocks.TRANSFORMATION);
			WoodType.register(TFBlocks.MINING);
			WoodType.register(TFBlocks.SORTING);
		}
		TFInternalApi.init();
		//DataGenerators.gatherData();
	}

	public static ResourceLocation prefix(String name) {
		return new ResourceLocation(ID, name.toLowerCase(Locale.ROOT));
	}

	public static ResourceLocation getModelTexture(String name) {
		return new ResourceLocation(ID, MODEL_DIR + name);
	}

	public static ResourceLocation getGuiTexture(String name) {
		return new ResourceLocation(ID, GUI_DIR + name);
	}

	public static ResourceLocation getEnvTexture(String name) {
		return new ResourceLocation(ID, ENVIRO_DIR + name);
	}

	public static ResourceLocation getArmorTexture(String name) {
		return new ResourceLocation(ID, ARMOR_DIR + name);
	}

	public static Rarity getRarity() {
		return rarity != null ? rarity : Rarity.EPIC;
	}

	//-----FABRIC ONLY METHODS-----
	public static void commonConfigInit() {
		if(SERVER_SIDE_ONLY){
			TFConfig.COMMON_CONFIG = AutoConfig.getConfigHolder(TFConfigCommon.class).getConfig();
		}

		else{
			TFConfig.COMMON_CONFIG = AutoConfig.getConfigHolder(twilightforest.compat.clothConfig.configFiles.TFConfig.class).getConfig().tfConfigCommon;
		}
	}

	public void clothConfigSetup() {
		AutoConfig.register(TFConfigCommon.class, Toml4jConfigSerializerExtended::new);
		commonConfigInit();

		ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
			if(SERVER_SIDE_ONLY) {
				AutoConfig.getConfigHolder(TFConfigCommon.class).registerLoadListener((manager, newData) -> {
					TFConfig.COMMON_CONFIG = newData;
					//COMMON_CONFIG = AutoConfig.getConfigHolder(newData.getClass()).getConfig();
					LOGGER.debug("Test: The TFConfigCommon has be reload after a load event!");
					return InteractionResult.SUCCESS;
				});

				AutoConfig.getConfigHolder(TFConfigCommon.class).registerSaveListener((manager, newData) -> {
					TFConfig.COMMON_CONFIG = newData;
					LOGGER.debug("Test: The TFConfigCommon has be reload after a save event!");
					//COMMON_CONFIG = AutoConfig.getConfigHolder(newData.getClass()).getConfig();
					return InteractionResult.SUCCESS;
				});
			}
		});
	}

}
