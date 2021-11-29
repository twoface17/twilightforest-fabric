package twilightforest.client;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.mojang.realmsclient.util.JsonUtils;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

public final class PatchModelLoader implements ResourceManagerReloadListener {
    public static final PatchModelLoader INSTANCE = new PatchModelLoader();

    private PatchModelLoader() {
    }

    //@Override
    public UnbakedPatchModel read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        if (!modelContents.has("texture"))
            throw new RuntimeException("Patch model missing value for 'texture'.");

        return new UnbakedPatchModel(new ResourceLocation(modelContents.get("texture").getAsString()), JsonUtils.getBooleanOr("shaggify", modelContents, false));
    }

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {
        // No need to do anything here
    }
}
