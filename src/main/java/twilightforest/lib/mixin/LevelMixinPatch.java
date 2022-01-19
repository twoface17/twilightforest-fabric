package twilightforest.lib.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import twilightforest.ASMHooks;

import java.util.List;
import java.util.function.Predicate;

@Mixin(Level.class)
public class LevelMixinPatch {

//    @ModifyVariable(method = "getEntities(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;", at=@At("RETURN"))
//    public List<Entity> multipartHitbox(List<Entity> list, Entity entity, AABB area, Predicate<? super Entity> predicate){
//        return ASMHooks.multipartHitbox(list, ((Level) (Object) this), entity, area, predicate);
//    }

}
