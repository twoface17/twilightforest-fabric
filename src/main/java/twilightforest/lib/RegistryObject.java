package twilightforest.lib;

import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("CanBeRecord")
public final class RegistryObject<T> implements Supplier<T> {

    private final ResourceLocation id;
    private final Supplier<T> wrappedEntry;

    public RegistryObject(ResourceLocation id, Supplier<T> wrappedEntry) {
        this.id = id;
        this.wrappedEntry = wrappedEntry;
    }

    public ResourceLocation getId() {
        return id;
    }

    @Override
    public T get() {
        return wrappedEntry.get();
    }
}
