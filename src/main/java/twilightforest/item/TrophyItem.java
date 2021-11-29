package twilightforest.item;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import twilightforest.lib.extensions.IItemEx;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class TrophyItem extends StandingAndWallBlockItem implements IItemEx {

	public TrophyItem(Block floorBlockIn, Block wallBlockIn, FabricItemSettings builder) {
		super(floorBlockIn, wallBlockIn, builder.equipmentSlot((itemStack -> EquipmentSlot.HEAD)));
	}

	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
		return armorType == EquipmentSlot.HEAD;
	}
}
