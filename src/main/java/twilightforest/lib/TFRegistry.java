package twilightforest.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class TFRegistry<T> {
    private final Registry<T> registry;
    private final String mod_id;
    private final List<RegistryObject<? extends T>> entires;

    TFRegistry(Registry<T> registry, String modid) {
        this.registry = registry;
        this.mod_id = modid;
        this.entires = new ArrayList<>();
    }

//    public <U extends T> RegistryObject<U> register(String id, Supplier<U> entry) {
//        return () -> Registry.register(registry, new ResourceLocation(mod_id, id), entry.get());
//    }

    public <R extends T> RegistryObject<R> register(String id, Supplier<R> entry) {
        RegistryObject<R> obj = new RegistryObject<R>(new ResourceLocation(mod_id, id), entry);
        entires.add(obj);
        return obj;
    }

    public <R extends T> RegistryObject<R> register(ResourceLocation id, Supplier<R> entry) {
        RegistryObject<R> obj = new RegistryObject<>(id, entry);
        entires.add(obj);
        return obj;
    }

    public void register() {
        entires.forEach(entry -> Registry.register(registry, entry.id(), entry.get()));
    }

    public static <R> TFRegistry<R> create(Registry<R> registry, String id) {
        return new TFRegistry<>(registry, id);
    }
}
