package twilightforest.lib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.HitResult;

@FunctionalInterface
public interface ProjectileHitEvent {
    Event<ProjectileHitEvent> PROJECTILE_HIT_EVENT = EventFactory.createArrayBacked(ProjectileHitEvent.class, (projectileHitEvents -> (projectile, result) -> {
        for (ProjectileHitEvent event : projectileHitEvents) {
            if(event.onHit(projectile, result))
                return true;
        }
        return false;
    }));

    boolean onHit(Projectile projectile, HitResult result);
}
