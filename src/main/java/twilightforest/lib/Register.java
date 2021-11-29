package twilightforest.lib;

import twilightforest.lib.extensions.ICachedName;

public record Register<T>(TFRegistry<T> registry) {
    public void register(T entry) {
        if(entry instanceof ICachedName cachedName)
            registry.register(cachedName.getRegistryName(), () -> entry);
    }
}
