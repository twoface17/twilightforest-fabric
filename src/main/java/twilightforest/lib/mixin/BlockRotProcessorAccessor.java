package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.level.levelgen.structure.templatesystem.BlockRotProcessor;

@Mixin(BlockRotProcessor.class)
public interface BlockRotProcessorAccessor {
    @Accessor
    float getIntegrity();
}
