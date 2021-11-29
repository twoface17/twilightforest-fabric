package twilightforest.lib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import net.minecraft.world.entity.Entity;

@FunctionalInterface
public interface EntityMountCallback {
    Event<EntityMountCallback> EVENT = EventFactory.createArrayBacked(EntityMountCallback.class, callbacks -> ((entityMounting, entityBeingMounted, isMounting) -> {
        for (EntityMountCallback event : callbacks) {
            if(event.canEntityMount(entityMounting, entityBeingMounted, isMounting))
                return true;
        }
        return false;
    }));

    boolean canEntityMount(Entity entityMounting, Entity entityBeingMounted, boolean isMounting);
}
