package twilightforest.lib.client.model;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public interface MultiPartModel extends UnbakedModel {

    Collection<? extends ModelPart> getParts();

    Optional<? extends ModelPart> getPart(String name);

    @Override
    default Collection<Material> getMaterials(Function<ResourceLocation, UnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
        return null;
    }

    default void addQuads(BlockModel owner, ModelBakery bakery, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform, ResourceLocation modelLocation)
    {
        getParts().stream()
                .forEach(part -> part.addQuads(bakery, spriteGetter, modelTransform, modelLocation));
    }
}
