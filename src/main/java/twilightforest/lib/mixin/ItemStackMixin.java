package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import twilightforest.lib.util.NBTSerializable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemStack.class)
public class ItemStackMixin implements NBTSerializable {
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        ((ItemStack) (Object) this).save(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        ((ItemStack) (Object) this).setTag(ItemStack.of(nbt).getTag());
    }
}
