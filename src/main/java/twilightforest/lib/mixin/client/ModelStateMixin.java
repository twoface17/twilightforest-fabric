package twilightforest.lib.mixin.client;

import net.minecraft.client.resources.model.ModelState;
import org.spongepowered.asm.mixin.Mixin;
import twilightforest.lib.extensions.IModelStateEx;

@Mixin(ModelState.class)
public interface ModelStateMixin extends IModelStateEx {

}
