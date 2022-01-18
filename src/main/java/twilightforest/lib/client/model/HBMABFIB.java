package twilightforest.lib.client.model;

import com.google.common.base.Charsets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hydos' Based Model Api Because Fabric Is Bad
 */
public class HBMABFIB {

    public static BlockModel getModelSafe(ResourceLocation resourceId) {
        return BlockModel.fromStream(getModelJson(resourceId));
    }

    static BufferedReader getModelJson(ResourceLocation location) {
        ResourceLocation file = new ResourceLocation(location.getNamespace(), "models/" + location.getPath() + ".json");
        Resource resource = null;
        try {
            resource = Minecraft.getInstance().getResourceManager().getResource(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BufferedReader(new InputStreamReader(resource.getInputStream(), Charsets.UTF_8));
    }
}
