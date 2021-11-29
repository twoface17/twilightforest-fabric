package twilightforest.lib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import java.util.function.Consumer;

import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.RepositorySource;

@FunctionalInterface
public interface AddPackFindersCallback {

    Event<AddPackFindersCallback> EVENT = EventFactory.createArrayBacked(AddPackFindersCallback.class, callbacks -> ((packType, sources) -> {
        for (AddPackFindersCallback event : callbacks)
            event.addPacks(packType, sources);
    }));

    void addPacks(PackType packType, Consumer<RepositorySource> sources);
}
