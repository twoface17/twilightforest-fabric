package twilightforest.lib;

import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public record RegistryObject<T>(ResourceLocation id, Supplier<T> wrappedEntry) implements Supplier<T> {

    public ResourceLocation getId() {
        return id;
    }

    @Override
    public T get() {
        return wrappedEntry.get();
    }
}
