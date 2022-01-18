package twilightforest.lib.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import twilightforest.lib.extensions.IBlockMethods;

import net.minecraft.world.level.block.Block;
import twilightforest.lib.extensions.ICachedName;

@Mixin(Block.class)
public class BlockMixin implements IBlockMethods, ICachedName<Block> {
    @Unique
    private ResourceLocation id;

    @Unique
    @Override
    public Block setRegistryName(ResourceLocation location) {
        this.id = location;
        return (Block) (Object) this;
    }

    @Unique
    @Override
    public ResourceLocation getRegistryName() {
        return this.id;
    }
}
