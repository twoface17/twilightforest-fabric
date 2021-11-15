package twilightforest.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import twilightforest.api.extensions.IItemEx;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class TrophyItem extends StandingAndWallBlockItem implements IItemEx {

	public TrophyItem(Block floorBlockIn, Block wallBlockIn, FabricItemSettings builder) {
		super(floorBlockIn, wallBlockIn, builder.equipmentSlot(TrophyItem::getEquipmentSlot));
	}

	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
		return armorType == EquipmentSlot.HEAD;
	}

	@Nullable
	public static EquipmentSlot getEquipmentSlot(ItemStack stack) {
		return EquipmentSlot.HEAD;
	}
}
