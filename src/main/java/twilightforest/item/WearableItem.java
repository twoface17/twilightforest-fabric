package twilightforest.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

import net.minecraft.world.item.Item.Properties;

public class WearableItem extends BlockItem {
    public WearableItem(Block block, FabricItemSettings props) {
        super(block, props.equipmentSlot(WearableItem::getEquipmentSlot));
    }

//    @Override
//    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
//        return armorType == EquipmentSlot.HEAD;
//    }

    @Nullable
    public static EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
