package twilightforest.lib.extensions;

import net.minecraft.resources.ResourceLocation;

public interface ICachedName<R> {
    default R setRegistryName(String namespace, String id) {
        return setRegistryName(new ResourceLocation(namespace, id));
    }

    R setRegistryName(ResourceLocation location);

    ResourceLocation getRegistryName();

    static <R> ICachedName<R> cast(R obj) {
        return (ICachedName<R>) obj;
    }
}
