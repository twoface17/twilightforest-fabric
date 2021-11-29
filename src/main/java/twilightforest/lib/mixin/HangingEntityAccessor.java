package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.decoration.HangingEntity;

@Mixin(HangingEntity.class)
public interface HangingEntityAccessor {
    @Invoker
    void callSetDirection(Direction facingDirection);
}
