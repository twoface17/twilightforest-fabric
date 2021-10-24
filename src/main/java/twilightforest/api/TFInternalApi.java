package twilightforest.api;

import twilightforest.api.crafting.CompoundIngredient;
import twilightforest.api.crafting.CraftingHelper;
import twilightforest.api.crafting.NBTIngredient;
import twilightforest.api.crafting.VanillaIngredientSerializer;

import net.minecraft.resources.ResourceLocation;

public class TFInternalApi {
    public static void init() {
        CraftingHelper.register(new ResourceLocation("forge", "compound"), CompoundIngredient.Serializer.INSTANCE);
        CraftingHelper.register(new ResourceLocation("forge", "nbt"), NBTIngredient.Serializer.INSTANCE);
        CraftingHelper.register(new ResourceLocation("minecraft", "item"), VanillaIngredientSerializer.INSTANCE);
    }
}
