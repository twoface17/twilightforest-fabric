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

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shadow.cloth.autoconfig.serializer.Toml4jConfigSerializerExtended;
import twilightforest.advancements.TFAdvancements;
import twilightforest.block.TFBlocks;
import twilightforest.block.entity.TFBlockEntities;
import twilightforest.client.particle.TFParticleType;
import twilightforest.command.TFCommand;
import twilightforest.compat.TFCompat;
import twilightforest.compat.clothConfig.configFiles.TFConfigCommon;
import twilightforest.dispenser.TFDispenserBehaviors;
import twilightforest.enchantment.TFEnchantments;
import twilightforest.entity.TFEntities;
import twilightforest.inventory.TFContainers;
import twilightforest.item.TFItems;
import twilightforest.loot.TFTreasure;
import twilightforest.network.TFPacketHandler;
import twilightforest.potions.TFMobEffects;
import twilightforest.world.components.BiomeGrassColors;
import twilightforest.util.TFStats;
import twilightforest.world.components.feature.BlockSpikeFeature;
import twilightforest.world.registration.*;
import twilightforest.world.registration.TFBiomeFeatures;
import twilightforest.world.registration.TFDimensions;
import twilightforest.world.registration.TFStructures;
import twilightforest.world.registration.TwilightFeatures;
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
		TFMobEffects.init();  //TFPotions.POTIONS.register(modbus);
		BiomeKeys.init();
		//modbus.addGenericListener(SoundEvent.class, TFSounds::registerSounds);
		TFBlockEntities.init();
		TFParticleType.init();
		TFStructures.registerFabricEvents();
		TFBiomeFeatures.init();
		TFMobEffects.MOB_EFFECTS.register();
		TFContainers.CONTAINERS.register();
		TFEnchantments.ENCHANTMENTS.register();

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
			TFBlocks.tfBurnables();
			TFBlocks.tfPots();
			TFSounds.registerParrotSounds();
			TFDispenserBehaviors.init();

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

			AxeItem.STRIPPABLES.put(TFBlocks.TWILIGHT_OAK_WOOD.get(), TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD.get());
			AxeItem.STRIPPABLES.put(TFBlocks.CANOPY_WOOD.get(), TFBlocks.STRIPPED_CANOPY_WOOD.get());
			AxeItem.STRIPPABLES.put(TFBlocks.MANGROVE_WOOD.get(), TFBlocks.STRIPPED_MANGROVE_WOOD.get());
			AxeItem.STRIPPABLES.put(TFBlocks.DARK_WOOD.get(), TFBlocks.STRIPPED_DARK_WOOD.get());
			AxeItem.STRIPPABLES.put(TFBlocks.TIME_WOOD.get(), TFBlocks.STRIPPED_TIME_WOOD.get());
			AxeItem.STRIPPABLES.put(TFBlocks.TRANSFORMATION_WOOD.get(), TFBlocks.STRIPPED_TRANSFORMATION_WOOD.get());
			AxeItem.STRIPPABLES.put(TFBlocks.MINING_WOOD.get(), TFBlocks.STRIPPED_MINING_WOOD.get());
			AxeItem.STRIPPABLES.put(TFBlocks.SORTING_WOOD.get(), TFBlocks.STRIPPED_SORTING_WOOD.get());
		};
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
