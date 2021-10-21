package twilightforest.api.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;

@Mixin(ModelBakery.class)
public interface ModelBakeryAccessor {
    @Accessor
    static Set<Material> getUNREFERENCED_TEXTURES() {
        throw new UnsupportedOperationException();
    }
}
