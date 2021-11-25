package twilightforest.api;

import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public record RegistryObject<T>(Registry<? super T> registry, Supplier<T> wrappedEntry) implements Supplier<T> {

    public ResourceLocation getRegistryName() {
        return registry.getKey(wrappedEntry.get());
    }

    @Override
    public T get() {
        return wrappedEntry.get();
    }
}
