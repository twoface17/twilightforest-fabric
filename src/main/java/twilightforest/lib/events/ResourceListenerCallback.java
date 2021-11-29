package twilightforest.lib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.ServerResources;
import net.minecraft.server.packs.resources.PreparableReloadListener;

@FunctionalInterface
public interface ResourceListenerCallback {
    Event<ResourceListenerCallback> EVENT = EventFactory.createArrayBacked(ResourceListenerCallback.class, callbacks -> serverResources -> {
        final List<PreparableReloadListener> listeners = new ArrayList<>();
        for(ResourceListenerCallback event : callbacks)
            listeners.addAll(event.reloadListeners(serverResources));
        return listeners;
    });

    List<PreparableReloadListener> reloadListeners(ServerResources serverResources);
}
