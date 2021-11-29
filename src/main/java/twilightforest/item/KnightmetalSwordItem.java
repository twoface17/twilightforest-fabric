package twilightforest.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import twilightforest.TwilightForestMod;
import twilightforest.lib.events.LivingHurtCallback;

import javax.annotation.Nullable;
import java.util.List;

public class KnightmetalSwordItem extends SwordItem {

	private static final int BONUS_DAMAGE = 2;

	public KnightmetalSwordItem(Tier material, Properties props) {
		super(material, 3, -2.4F, props);
		LivingHurtCallback.EVENT.register(KnightmetalSwordItem::onDamage);
	}

	public static float onDamage(LivingHurtCallback.LivingHurtEvent evt) {
		LivingEntity target = evt.getEntityLiving();

		if (!target.level.isClientSide && evt.getSource().getDirectEntity() instanceof LivingEntity living) {
			ItemStack weapon = living.getMainHandItem();

			if (!weapon.isEmpty()) {
				if (target.getArmorValue() > 0 && (weapon.is(TFItems.KNIGHTMETAL_PICKAXE.get()) || weapon.is(TFItems.KNIGHTMETAL_SWORD.get()))) {
					if(target.getArmorCoverPercentage() > 0) {
						int moreBonus = (int) (BONUS_DAMAGE * target.getArmorCoverPercentage());
						evt.setAmount(evt.getAmount() + moreBonus);
					} else {
						evt.setAmount(evt.getAmount() + BONUS_DAMAGE);
					}
					// enchantment attack sparkles
					((ServerLevel) target.level).getChunkSource().broadcastAndSend(target, new ClientboundAnimatePacket(target, 5));
				} else if(target.getArmorValue() == 0 && weapon.is(TFItems.KNIGHTMETAL_AXE.get())) {
					evt.setAmount(evt.getAmount() + BONUS_DAMAGE);
					// enchantment attack sparkles
					((ServerLevel) target.level).getChunkSource().broadcastAndSend(target, new ClientboundAnimatePacket(target, 5));
				}
			}
		}
		return evt.getAmount();
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flags) {
		super.appendHoverText(stack, world, list, flags);
		list.add(new TranslatableComponent(getDescriptionId() + ".tooltip").withStyle(ChatFormatting.GRAY));
	}
}
