package twilightforest.lib.extensions;

import javax.annotation.Nullable;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

//TODO: PORT
public interface IItemEx {
    default void onUsingTick(ItemStack stack, LivingEntity living, int count) {};

    default boolean showDurabilityBar(ItemStack stack) {
        return stack.isDamaged();
    }

    default int getRGBDurabilityForDisplay(ItemStack stack) {
        return Mth.hsvToRgb(Math.max(0.0F, (float) (1.0F - getDurabilityForDisplay(stack))) / 3.0F, 1.0F, 1.0F);
    }
    default double getDurabilityForDisplay(ItemStack stack) {
        return (double) stack.getDamageValue() / (double) stack.getMaxDamage();
    }
    default boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return this instanceof AxeItem;
    }

    default float getXpRepairRatio(ItemStack stack) {
        return 1.0f;
    }

    default boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }

    default boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.world.item.enchantment.Enchantment enchantment) {
        return enchantment.category.canEnchant(stack.getItem());
    }

    default boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return Mob.getEquipmentSlotForItem(stack) == armorType;
    }

    default int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return -1;
    }

    default boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {
        return ItemStack.isSameIgnoreDurability(oldStack, newStack);
    }

    default boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.equals(newStack); // !ItemStack.areItemStacksEqual(oldStack, newStack);
    }

    static IItemEx cast(Item item) {
        if(item instanceof IItemEx itemEx)
            return itemEx;
        throw new ClassCastException();
    }
}
