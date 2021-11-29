package twilightforest.lib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@FunctionalInterface
public interface PlayerChangedDimensionCallback {

    Event<PlayerChangedDimensionCallback> EVENT = EventFactory.createArrayBacked(PlayerChangedDimensionCallback.class, callback -> ((player, fromDim, toDim) -> {
        for (PlayerChangedDimensionCallback event : callback)
            event.onDimensionChange(player, fromDim, toDim);
    }));

    void onDimensionChange(Player player, ResourceKey<Level> fromDim, ResourceKey<Level> toDim);
}
