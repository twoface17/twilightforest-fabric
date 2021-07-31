package twilightforest.item;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.LoyalZombieEntity;
import twilightforest.entity.TFEntities;
import twilightforest.util.EntityUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import net.minecraft.world.item.Item.Properties;

public class ZombieWandItem extends Item {

	protected ZombieWandItem(Properties props) {
		super(props);
	}

	@Nonnull
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, @Nonnull InteractionHand hand) {

		ItemStack stack = player.getItemInHand(hand);

		if (stack.getDamageValue() == stack.getMaxDamage()) {
			return InteractionResultHolder.fail(stack);
		}

		if (!world.isClientSide) {
			// what block is the player pointing at?
			BlockHitResult blockray = EntityUtil.rayTrace(player, 20.0);

			if (blockray.getType() != HitResult.Type.MISS) {
				LoyalZombieEntity zombie = TFEntities.loyal_zombie.create(world);
				Direction face = blockray.getDirection();
				zombie.absMoveTo(blockray.getBlockPos().getX() + 0.5F + face.getStepX(), blockray.getBlockPos().getY() + face.getStepY(), blockray.getBlockPos().getZ() + 0.5F + face.getStepZ(), 1.0F, 1.0F);
				zombie.setTame(true);
				zombie.setOwnerUUID(player.getUUID());
				zombie.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1));
				world.addFreshEntity(zombie);

				stack.hurt(1, random, (ServerPlayer) null);
			}
		}

		return InteractionResultHolder.fail(stack);
	}

	@Override
	public float getXpRepairRatio(ItemStack stack) {
		return 1f;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flags) {
		super.appendHoverText(stack, world, tooltip, flags);
		tooltip.add(new TranslatableComponent("twilightforest.scepter_charges", stack.getMaxDamage() - stack.getDamageValue()));
	}
}