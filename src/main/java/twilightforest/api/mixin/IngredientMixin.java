package twilightforest.api.mixin;

import it.unimi.dsi.fastutil.ints.IntList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import twilightforest.api.crafting.IIngredientSerializer;
import twilightforest.api.crafting.VanillaIngredientSerializer;
import twilightforest.api.extensions.IIngredientEx;

import java.util.stream.Stream;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

@Mixin(Ingredient.class)
public class IngredientMixin implements IIngredientEx {

    @Shadow private ItemStack[] itemStacks;

    @Shadow private IntList stackingIds;

    @Shadow @Final public static Ingredient EMPTY;
    private static final java.util.Set<Ingredient> INSTANCES = java.util.Collections.newSetFromMap(new java.util.WeakHashMap<Ingredient, Boolean>());

    @Final @Unique
    public boolean isSimple;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(Stream stream, CallbackInfo ci) {
        //INSTANCES.add((Ingredient) (Object) this);
    }

    @Override
    public IIngredientSerializer<? extends Ingredient> getSerializer() {
        if (!isVanilla()) throw new IllegalStateException("Modders must implement Ingredient.getSerializer in their custom Ingredients: " + this);
            return VanillaIngredientSerializer.INSTANCE;
    }

    public final boolean isVanilla() {
        return ((Class)this.getClass()) == Ingredient.class;
    }

    @Override
    public boolean isSimple() {
        return (Object) this == EMPTY;
    }

    @Override
    public void invalidate() {
        itemStacks = null;
        stackingIds = null;
    }
}
