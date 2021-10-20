package twilightforest.api.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import twilightforest.api.extensions.IBlockMethods;
import java.util.List;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;

@Mixin(EnchantmentMenu.class)
public abstract class EnchantmentMenuMixin extends AbstractContainerMenu {
    @Shadow @Final private Container enchantSlots;

    @Shadow @Final private ContainerLevelAccess access;

    @Shadow @Final private DataSlot enchantmentSeed;

    @Shadow @Final private Random random;

    @Shadow @Final public int[] costs;

    @Shadow @Final public int[] enchantClue;

    @Shadow @Final public int[] levelClue;

    protected EnchantmentMenuMixin(@Nullable MenuType<?> menuType, int i) {
        super(menuType, i);
    }

    @Shadow protected abstract List<EnchantmentInstance> getEnchantmentList(ItemStack stack, int enchantSlot, int level);

//    @ModifyVariable(method = "slotsChanged", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z"))
//    private boolean enchantPower(boolean old) {
//        System.out.println(old);
//        return false;
//    }

//    /**
//     * @author AlphaMode
//     * I am sorry blod good luck converting this
//     */
//    @Overwrite
//    public void slotsChanged(Container pInventory) {
//        if (pInventory == this.enchantSlots) {
//            ItemStack itemstack = pInventory.getItem(0);
//            if (!itemstack.isEmpty() && itemstack.isEnchantable()) {
//                this.access.execute((level, blockPos) -> {
//                    int power = 0;
//
//                    for(int k = -1; k <= 1; ++k) {
//                        for(int l = -1; l <= 1; ++l) {
//                            if ((k != 0 || l != 0) && level.isEmptyBlock(blockPos.offset(l, 0, k)) && level.isEmptyBlock(blockPos.offset(l, 1, k))) {
//                                power += getPower(level, blockPos.offset(l * 2, 0, k * 2));
//                                power += getPower(level, blockPos.offset(l * 2, 1, k * 2));
//
//                                if (l != 0 && k != 0) {
//                                    power += getPower(level, blockPos.offset(l * 2, 0, k));
//                                    power += getPower(level, blockPos.offset(l * 2, 1, k));
//                                    power += getPower(level, blockPos.offset(l, 0, k * 2));
//                                    power += getPower(level, blockPos.offset(l, 1, k * 2));
//                                }
//                            }
//                        }
//                    }
//
//                    this.random.setSeed(this.enchantmentSeed.get());
//
//                    for(int i1 = 0; i1 < 3; ++i1) {
//                        this.costs[i1] = EnchantmentHelper.getEnchantmentCost(this.random, i1, power, itemstack);
//                        this.enchantClue[i1] = -1;
//                        this.levelClue[i1] = -1;
//                        if (this.costs[i1] < i1 + 1) {
//                            this.costs[i1] = 0;
//                        }
//                    }
//
//                    for(int j1 = 0; j1 < 3; ++j1) {
//                        if (this.costs[j1] > 0) {
//                            List<EnchantmentInstance> list = this.getEnchantmentList(itemstack, j1, this.costs[j1]);
//                            if (list != null && !list.isEmpty()) {
//                                EnchantmentInstance enchantmentinstance = list.get(this.random.nextInt(list.size()));
//                                this.enchantClue[j1] = Registry.ENCHANTMENT.getId(enchantmentinstance.enchantment);
//                                this.levelClue[j1] = enchantmentinstance.level;
//                            }
//                        }
//                    }
//
//                    this.broadcastChanges();
//                });
//            } else {
//                for(int i = 0; i < 3; ++i) {
//                    this.costs[i] = 0;
//                    this.enchantClue[i] = -1;
//                    this.levelClue[i] = -1;
//                }
//            }
//        }
//
//    }

    private float getPower(Level level, BlockPos offset) {
        return ((IBlockMethods)level.getBlockState(offset).getBlock()).getEnchantPowerBonus(level.getBlockState(offset), level, offset);
    }

}
