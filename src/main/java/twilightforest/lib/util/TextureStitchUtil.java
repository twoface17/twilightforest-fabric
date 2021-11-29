package twilightforest.lib.util;

import java.util.Set;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;

/**
 * This util class is different from other ones, an instance of it must be made before use.
 * See the {@link twilightforest.lib.events.OnTextureStitchCallback} event for example use.
 */
@Environment(EnvType.CLIENT)
public record TextureStitchUtil(TextureAtlas map, Set<ResourceLocation> locations) {
    public boolean addSprite(ResourceLocation location) {
        return locations.add(location);
    }
}

