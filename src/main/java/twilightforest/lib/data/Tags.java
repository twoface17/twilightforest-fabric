package twilightforest.lib.data;

import net.fabricmc.fabric.api.tag.TagFactory;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tags {
    public static class Items {
        public static final Tag.Named<Item> ORES = tag("ores");
        public static final Tag.Named<Item> RODS_WOODEN = tag("wood_sticks");
        public static final Tag.Named<Item> CHESTS_WOODEN = tag("wooden_chests");
        public static final Tag.Named<Item> STORAGE_BLOCKS = tag("storage_blocks");
        public static final Tag.Named<Item> FENCES = tag("fences");
        public static final Tag.Named<Item> FENCE_GATES = tag("fence_gates");
        public static final Tag.Named<Item> FENCES_WOODEN = tag("wood_fences");
        public static final Tag.Named<Item> FEATHERS = tag("feathers");
        public static final Tag.Named<Item> GEMS = tag("gems");
        public static final Tag.Named<Item> GEMS_DIAMOND = tag("diamonds");
        public static final Tag.Named<Item> INGOTS = tag("ingots");
        public static final Tag.Named<Item> NUGGETS_IRON = tag("iron_nuggets");
        public static final Tag.Named<Item> NUGGETS_GOLD = tag("gold_nuggets");
        public static final Tag.Named<Item> ORES_REDSTONE = tag("redstone_ores");
        public static final Tag.Named<Item> DUSTS_REDSTONE = tag("redstone");
        public static final Tag.Named<Item> RODS_BLAZE = tag("blaze_rods");
        public static final Tag.Named<Item> ENDER_PEARLS = tag("ender_pearls");
        public static final Tag.Named<Item> STORAGE_BLOCKS_DIAMOND = tag("diamond_blocks");
        public static final Tag.Named<Item> STORAGE_BLOCKS_GOLD = tag("gold_blocks");
        public static final Tag.Named<Item> STORAGE_BLOCKS_IRON = tag("iron_blocks");
        public static final Tag.Named<Item> DUSTS_GLOWSTONE = tag("glowstone_dusts");
        public static final Tag.Named<Item> INGOTS_IRON = tag("iron_ingots");
        public static final Tag.Named<Item> FENCE_GATES_WOODEN = tag("wood_fence_gates");

        public static Tag.Named<Item> tag(String id) {
            return TagFactory.ITEM.create(new ResourceLocation("c", id));
        }
    }
    public static class Blocks {
        public static final Tag.Named<Block> DIRT = tag("dirt");
        public static final Tag.Named<Block> GRAVEL = tag("gravel");
        public static final Tag.Named<Block> SAND = tag("sand");
        public static final Tag.Named<Block> CHESTS = tag("chests");
        public static final Tag.Named<Block> ORES = tag("ores");
        public static final Tag.Named<Block> STORAGE_BLOCKS = tag("storage_blocks");
        public static final Tag.Named<Block> CHESTS_WOODEN = tag("wooden_chests");
        public static final Tag.Named<Block> FENCES = tag("fences");
        public static final Tag.Named<Block> FENCE_GATES = tag("fence_gates");
        public static final Tag.Named<Block> FENCES_WOODEN = tag("wood_fences");
        public static final Tag.Named<Block> FENCE_GATES_WOODEN = tag("wood_fence_gates");

        public static Tag.Named<Block> tag(String id) {
            return TagFactory.BLOCK.create(new ResourceLocation("c", id));
        }
    }
}
