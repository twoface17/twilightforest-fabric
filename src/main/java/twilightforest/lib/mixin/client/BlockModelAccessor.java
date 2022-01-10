package twilightforest.lib.mixin.client;

import com.google.gson.Gson;
import net.minecraft.client.renderer.block.model.BlockModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockModel.class)
public interface BlockModelAccessor {
    @Accessor
    static Gson getGSON() {
        throw new UnsupportedOperationException();
    }
}
