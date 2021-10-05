package twilightforest.client;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import twilightforest.TwilightForestMod;
import twilightforest.block.AuroraBrickBlock;
import twilightforest.block.TFBlocks;
import twilightforest.item.ArcticArmorItem;
import twilightforest.item.TFItems;

import java.awt.*;

@Environment(EnvType.CLIENT)
public final class ColorHandler {

	public static void registerBlockColors(BlockColors blockColors) {

		blockColors.register((state, worldIn, pos, tintIndex) -> tintIndex > 15 ? 0xFFFFFF : Color.HSBtoRGB(worldIn == null ? 0.45F : AuroraBrickBlock.rippleFractialNoise(2, 128.0f, pos != null ? pos.above(128) : new BlockPos(0, 0, 0), 0.37f, 0.67f, 1.5f), 1.0f, 1.0f), TFBlocks.AURORA_BLOCK);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			int normalColor = blockColors.getColor(TFBlocks.AURORA_BLOCK.defaultBlockState(), worldIn, pos, tintIndex);

			int red = (normalColor >> 16) & 255;
			int blue = normalColor & 255;
			int green = (normalColor >> 8) & 255;

			float[] hsb = Color.RGBtoHSB(red, blue, green, null);

			return Color.HSBtoRGB(hsb[0], hsb[1] * 0.5F, Math.min(hsb[2] + 0.4F, 0.9F));
		}, TFBlocks.AURORA_PILLAR, TFBlocks.AURORA_SLAB, TFBlocks.AURORALIZED_GLASS);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (worldIn == null || pos == null) {
				return FoliageColor.getDefaultColor();
			}

			int red = 0;
			int grn = 0;
			int blu = 0;

			for (int dz = -1; dz <= 1; ++dz) {
				for (int dx = -1; dx <= 1; ++dx) {
					//int i2 = worldIn.getBiome(pos.add(dx, 0, dz)).getFoliageColor(pos.add(dx, 0, dz));
					int i2 = BiomeColors.getAverageFoliageColor(worldIn, pos.offset(dx, 0, dz));
					red += (i2 & 16711680) >> 16;
					grn += (i2 & 65280) >> 8;
					blu += i2 & 255;
				}
			}

			return (red / 9 & 255) << 16 | (grn / 9 & 255) << 8 | blu / 9 & 255;
		}, TFBlocks.DARK_LEAVES, TFBlocks.HARDENED_DARK_LEAVES, TFBlocks.GIANT_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> tintIndex > 15 ? 0xFFFFFF : blockColors.getColor(Blocks.GRASS.defaultBlockState(), worldIn, pos, tintIndex), TFBlocks.SMOKER, TFBlocks.FIRE_JET);
		blockColors.register((state, worldIn, pos, tintIndex) -> worldIn != null && pos != null ? 2129968 : 7455580, TFBlocks.HUGE_LILY_PAD);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (worldIn == null || pos == null) {
				return 106 << 16 | 156 << 8 | 23;
			} else {
				int red, green, blue;

				int fade = pos.getX() * 16 + pos.getY() * 16 + pos.getZ() * 16;
				if ((fade & 256) != 0) {
					fade = 255 - (fade & 255);
				}
				fade &= 255;

				float spring = (255 - fade) / 255F;
				float fall = fade / 255F;

				red = (int) (spring * 106 + fall * 251);
				green = (int) (spring * 156 + fall * 108);
				blue = (int) (spring * 23 + fall * 27);

				return red << 16 | green << 8 | blue;
			}
		}, TFBlocks.TIME_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (worldIn == null || pos == null) {
				return 108 << 16 | 204 << 8 | 234;
			} else {
				int red, green, blue;

				int fade = pos.getX() * 27 + pos.getY() * 63 + pos.getZ() * 39;
				if ((fade & 256) != 0) {
					fade = 255 - (fade & 255);
				}
				fade &= 255;

				float spring = (255 - fade) / 255F;
				float fall = fade / 255F;

				red = (int) (spring * 108 + fall * 96);
				green = (int) (spring * 204 + fall * 107);
				blue = (int) (spring * 234 + fall * 121);

				return red << 16 | green << 8 | blue;
			}
		}, TFBlocks.TRANSFORMATION_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (worldIn == null || pos == null) {
				return 252 << 16 | 241 << 8 | 68;
			} else {
				int red, green, blue;

				int fade = pos.getX() * 31 + pos.getY() * 33 + pos.getZ() * 32;
				if ((fade & 256) != 0) {
					fade = 255 - (fade & 255);
				}
				fade &= 255;

				float spring = (255 - fade) / 255F;
				float fall = fade / 255F;

				red = (int) (spring * 252 + fall * 237);
				green = (int) (spring * 241 + fall * 172);
				blue = (int) (spring * 68 + fall * 9);

				return red << 16 | green << 8 | blue;
			}
		}, TFBlocks.MINING_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (worldIn == null || pos == null) {
				return 54 << 16 | 76 << 8 | 3;
			} else {
				int red, green, blue;

				int fade = pos.getX() * 63 + pos.getY() * 63 + pos.getZ() * 63;
				if ((fade & 256) != 0) {
					fade = 255 - (fade & 255);
				}
				fade &= 255;

				float spring = (255 - fade) / 255F;
				float fall = fade / 255F;

				red = (int) (spring * 54 + fall * 168);
				green = (int) (spring * 76 + fall * 199);
				blue = (int) (spring * 3 + fall * 43);

				return red << 16 | green << 8 | blue;
			}
		}, TFBlocks.SORTING_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (worldIn == null || pos == null) {
				return -1;
			} else {
				float f = AuroraBrickBlock.rippleFractialNoise(2, 32.0f, pos, 0.4f, 1.0f, 2f);
				return Color.HSBtoRGB(0.1f, 1f - f, (f + 2f) / 3f);
			}
		}, TFBlocks.TOWERWOOD, TFBlocks.CRACKED_TOWERWOOD, TFBlocks.INFESTED_TOWERWOOD, TFBlocks.MOSSY_TOWERWOOD);
		blockColors.register((state, world, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (world == null || pos == null) {
				return 0x48B518;
			} else {
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int dz = -1; dz <= 1; ++dz) {
					for (int dx = -1; dx <= 1; ++dx) {
						//int color = world.getBiome(pos.add(dx, 0, dz)).getFoliageColor(pos);
						int color = BiomeColors.getAverageFoliageColor(world, pos);
						red += (color & 16711680) >> 16;
						green += (color & 65280) >> 8;
						blue += color & 255;
					}
				}

				return (red / 9 & 0xFF) << 16 | (green / 9 & 0xFF) << 8 | blue / 9 & 0xFF;
			}
		}, TFBlocks.TWILIGHT_OAK_LEAVES);
		blockColors.register((state, world, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (world == null || pos == null) {
				return 0x609860;
			} else {
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int dz = -1; dz <= 1; ++dz) {
					for (int dx = -1; dx <= 1; ++dx) {
						//int color = world.getBiome(pos.add(dx, 0, dz)).getFoliageColor(pos);
						int color = BiomeColors.getAverageFoliageColor(world, pos);
						red += (color & 16711680) >> 16;
						green += (color & 65280) >> 8;
						blue += color & 255;
					}
				}

				int normalColor = (red / 9 & 0xFF) << 16 | (green / 9 & 0xFF) << 8 | blue / 9 & 0xFF;
				// canopy colorizer
				return ((normalColor & 0xFEFEFE) + 0x469A66) / 2;
				//return ((normalColor & 0xFEFEFE) + 0x009822) / 2;
			}
		}, TFBlocks.CANOPY_LEAVES);
		blockColors.register((state, world, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (world == null || pos == null) {
				return 0x80A755;
			} else {
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int dz = -1; dz <= 1; ++dz) {
					for (int dx = -1; dx <= 1; ++dx) {
						//int color = world.getBiome(pos.add(dx, 0, dz)).getFoliageColor(pos);
						int color = BiomeColors.getAverageFoliageColor(world, pos);
						red += (color & 16711680) >> 16;
						green += (color & 65280) >> 8;
						blue += color & 255;
					}
				}

				int normalColor = (red / 9 & 0xFF) << 16 | (green / 9 & 0xFF) << 8 | blue / 9 & 0xFF;
				// mangrove colors
				return ((normalColor & 0xFEFEFE) + 0xC0E694) / 2;
			}
		}, TFBlocks.MANGROVE_LEAVES);
		blockColors.register((state, world, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;

			if (world == null || pos == null) {
				return 0x48B518;
			} else {
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int dz = -1; dz <= 1; ++dz) {
					for (int dx = -1; dx <= 1; ++dx) {
						//int color = world.getBiome(pos.add(dx, 0, dz)).getFoliageColor(pos);
						int color = BiomeColors.getAverageFoliageColor(world, pos);
						red += (color & 16711680) >> 16;
						green += (color & 65280) >> 8;
						blue += color & 255;
					}
				}

				// RAINBOW!
				red = pos.getX() * 32 + pos.getY() * 16;
				if ((red & 256) != 0) {
					red = 255 - (red & 255);
				}
				red &= 255;

				blue = pos.getY() * 32 + pos.getZ() * 16;
				if ((blue & 256) != 0) {
					blue = 255 - (blue & 255);
				}
				blue ^= 255;

				green = pos.getX() * 16 + pos.getZ() * 32;
				if ((green & 256) != 0) {
					green = 255 - (green & 255);
				}
				green &= 255;


				return red << 16 | blue << 8 | green;
			}
		}, TFBlocks.RAINBOW_OAK_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> FoliageColor.getEvergreenColor(), TFBlocks.BEANSTALK_LEAVES, TFBlocks.THORN_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex != 0) {
				return 0xFFFFFF;
			} else {
				if (worldIn != null && pos != null) {
					return BiomeColors.getAverageFoliageColor(worldIn, pos);
				} else {
					return FoliageColor.getDefaultColor();
				}
			}
		}, TFBlocks.FALLEN_LEAVES);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex != 0) {
				return 0xFFFFFF;
			} else {
				if (worldIn != null && pos != null) {
					return BiomeColors.getAverageGrassColor(worldIn, pos);
				} else {
					return GrassColor.get(0.5D, 1.0D);
				}
			}
		}, TFBlocks.FIDDLEHEAD, TFBlocks.POTTED_FIDDLEHEAD);
		blockColors.register((state, worldIn, pos, tintIndex) -> GrassColor.get(0.5D, 1.0D),
				TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE, /*TFBlocks.HEDGE_MAZE_MINIATURE_STRUCTURE, TFBlocks.HOLLOW_HILL_MINIATURE_STRUCTURE, TFBlocks.QUEST_GROVE_MINIATURE_STRUCTURE, TFBlocks.MUSHROOM_TOWER_MINIATURE_STRUCTURE,*/ TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE, TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE //TFBlocks.MINOTAUR_LABYRINTH_MINIATURE_STRUCTURE,
				/*TFBlocks.HYDRA_LAIR_MINIATURE_STRUCTURE, TFBlocks.GOBLIN_STRONGHOLD_MINIATURE_STRUCTURE, TFBlocks.DARK_TOWER_MINIATURE_STRUCTURE, TFBlocks.YETI_CAVE_MINIATURE_STRUCTURE, TFBlocks.AURORA_PALACE_MINIATURE_STRUCTURE, TFBlocks.TROLL_CAVE_COTTAGE_MINIATURE_STRUCTURE, TFBlocks.FINAL_CASTLE_MINIATURE_STRUCTURE*/);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0xFF00FF;
		}, TFBlocks.PINK_CASTLE_RUNE_BRICK, TFBlocks.PINK_CASTLE_DOOR);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0x00FFFF;
		}, TFBlocks.BLUE_CASTLE_RUNE_BRICK, TFBlocks.BLUE_CASTLE_DOOR);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0xFFFF00;
		}, TFBlocks.YELLOW_CASTLE_RUNE_BRICK, TFBlocks.YELLOW_CASTLE_DOOR);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0x4B0082;
		}, TFBlocks.VIOLET_CASTLE_RUNE_BRICK, TFBlocks.VIOLET_CASTLE_DOOR);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0x5C1074;
		}, TFBlocks.VIOLET_FORCE_FIELD);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0xFA057E;
		}, TFBlocks.PINK_FORCE_FIELD);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0xFF5B02;
		}, TFBlocks.ORANGE_FORCE_FIELD);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0x89E701;
		}, TFBlocks.GREEN_FORCE_FIELD);
		blockColors.register((state, worldIn, pos, tintIndex) -> {
			if (tintIndex > 15) return 0xFFFFFF;
			return 0x0DDEFF;
		}, TFBlocks.BLUE_FORCE_FIELD);
	}

	public static void registerItemColors(ItemColors itemColors, BlockColors blockColors) {
		itemColors.register((stack, tintIndex) -> blockColors.getColor(((BlockItem)stack.getItem()).getBlock().defaultBlockState(), null, null, tintIndex),
				TFBlocks.AURORA_BLOCK, TFBlocks.AURORA_PILLAR, TFBlocks.AURORA_SLAB, TFBlocks.AURORALIZED_GLASS, TFBlocks.DARK_LEAVES, TFBlocks.GIANT_LEAVES, TFBlocks.SMOKER, TFBlocks.FIRE_JET,
				TFBlocks.TIME_LEAVES, TFBlocks.TRANSFORMATION_LEAVES, TFBlocks.MINING_LEAVES, TFBlocks.SORTING_LEAVES, TFBlocks.TWILIGHT_OAK_LEAVES, TFBlocks.CANOPY_LEAVES, TFBlocks.MANGROVE_LEAVES, TFBlocks.RAINBOW_OAK_LEAVES, TFBlocks.THORN_LEAVES, TFBlocks.BEANSTALK_LEAVES,
				TFBlocks.FALLEN_LEAVES, TFBlocks.FIDDLEHEAD, TFBlocks.POTTED_FIDDLEHEAD, TFBlocks.PINK_CASTLE_RUNE_BRICK, TFBlocks.BLUE_CASTLE_RUNE_BRICK, TFBlocks.YELLOW_CASTLE_RUNE_BRICK, TFBlocks.VIOLET_CASTLE_RUNE_BRICK,
				TFBlocks.YELLOW_CASTLE_DOOR, TFBlocks.BLUE_CASTLE_DOOR, TFBlocks.PINK_CASTLE_DOOR, TFBlocks.VIOLET_CASTLE_DOOR, TFBlocks.PINK_FORCE_FIELD, TFBlocks.BLUE_FORCE_FIELD, TFBlocks.GREEN_FORCE_FIELD, TFBlocks.ORANGE_FORCE_FIELD, TFBlocks.VIOLET_FORCE_FIELD, TFBlocks.HUGE_LILY_PAD,
				TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE, /*TFBlocks.HEDGE_MAZE_MINIATURE_STRUCTURE, TFBlocks.HOLLOW_HILL_MINIATURE_STRUCTURE, TFBlocks.QUEST_GROVE_MINIATURE_STRUCTURE, TFBlocks.MUSHROOM_TOWER_MINIATURE_STRUCTURE,*/ TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE, TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE//, TFBlocks.MINOTAUR_LABYRINTH_MINIATURE_STRUCTURE,
				/*TFBlocks.HYDRA_LAIR_MINIATURE_STRUCTURE, TFBlocks.GOBLIN_STRONGHOLD_MINIATURE_STRUCTURE, TFBlocks.DARK_TOWER_MINIATURE_STRUCTURE, TFBlocks.YETI_CAVE_MINIATURE_STRUCTURE, TFBlocks.AURORA_PALACE_MINIATURE_STRUCTURE, TFBlocks.TROLL_CAVE_COTTAGE_MINIATURE_STRUCTURE, TFBlocks.FINAL_CASTLE_MINIATURE_STRUCTURE*/);

		itemColors.register((stack, tintIndex) ->
				stack.getItem() instanceof ArcticArmorItem
						? ((ArcticArmorItem) stack.getItem()).getColor(stack, tintIndex)
						: 0xFFFFFF,
				TFItems.ARCTIC_HELMET, TFItems.ARCTIC_CHESTPLATE, TFItems.ARCTIC_LEGGINGS, TFItems.ARCTIC_BOOTS);

		itemColors.register((stack, tintIndex) ->
				tintIndex > 0 ? -1 : PotionUtils.getColor(stack),
				TFItems.BRITTLE_FLASK, TFItems.GREATER_FLASK);

		//FIXME IE Compat
		/*if (ModList.isLoaded("immersiveengineering")) {
			itemColors.register(TFShaderItem::getShaderColors, Registry.ITEM.get(TwilightForestMod.prefix("shader")));
			for(Rarity r: ShaderRegistry.rarityWeightMap.keySet()) {
				itemColors.register((stack, tintIndex) -> {
					int c = r.color.getColor();

					float d = tintIndex + 1;

					return (int) ((c >> 16 & 0xFF) / d) << 16
							| (int) ((c >> 8 & 0xFF) / d) << 8
							| (int) ((c & 0xFF) / d);
				}, Registry.ITEM.get(TwilightForestMod.prefix("shader_bag_" + r.name().toLowerCase(Locale.US).replace(':', '_'))));
			}
		}*/
	}

	private ColorHandler() {}
}
