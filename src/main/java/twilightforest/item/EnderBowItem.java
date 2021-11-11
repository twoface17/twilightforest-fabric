package twilightforest.item;

import twilightforest.events.ProjectileHitEvent;
import twilightforest.api.extensions.IBowItemEx;
import twilightforest.api.extensions.IEntityEx;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EnderBowItem extends BowItem implements IBowItemEx {
	private static final String KEY = "twilightforest:ender";

	public EnderBowItem(Properties props) {
		super(props);
		ProjectileHitEvent.PROJECTILE_HIT_EVENT.register(EnderBowItem::onHit);
	}

	public static void onHit(Projectile arrow, HitResult result) {
		if (arrow.getOwner() instanceof Player player
						&& result instanceof EntityHitResult entityHitResult
						&& entityHitResult.getEntity() instanceof LivingEntity living) {
			if (((IEntityEx)arrow).getPersistentData().contains(KEY) && player.getVehicle() == null) {
				double sourceX = player.getX(), sourceY = player.getY(), sourceZ = player.getZ();
				float sourceYaw = player.getYRot(), sourcePitch = player.getXRot();

				player.setYRot(living.getYRot());
				player.setXRot(living.getXRot());
				player.teleportTo(living.getX(), living.getY(), living.getZ());
				player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);

				living.setYRot(sourceYaw);
				living.setXRot(sourcePitch);
				living.teleportTo(sourceX, sourceY, sourceZ);
				living.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
			}
		}
	}

	@Override
	public AbstractArrow customArrow(AbstractArrow arrow) {
		((IEntityEx)arrow).getPersistentData().putBoolean(KEY, true);
		return arrow;
	}

}
