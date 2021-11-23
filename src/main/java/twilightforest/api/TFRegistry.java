package twilightforest.api;

import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class TFRegistry<T> {
    private final Registry<T> registry;
    private final String mod_id;

    TFRegistry(Registry<T> registry, String modid) {
        this.registry = registry;
        this.mod_id = modid;
    }

    public <U extends T> U register(String id, Supplier<U> entry) {
        return Registry.register(registry, new ResourceLocation(mod_id, id), entry.get());
    }

    public static <R> TFRegistry<R> create(Registry<R> registry, String id) {
        return new TFRegistry<>(registry, id);
    }
}
