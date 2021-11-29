package twilightforest.lib;

import twilightforest.lib.crafting.CompoundIngredient;
import twilightforest.lib.crafting.CraftingHelper;
import twilightforest.lib.crafting.NBTIngredient;
import twilightforest.lib.crafting.VanillaIngredientSerializer;
import twilightforest.lib.events.ResourceListenerCallback;
import twilightforest.lib.loot.LootModifierManager;

import java.util.List;

import net.minecraft.resources.ResourceLocation;

public class TFInternalApi {

    private static LootModifierManager INSTANCE;

    public static void init() {
        CraftingHelper.register(new ResourceLocation("forge", "compound"), CompoundIngredient.Serializer.INSTANCE);
        CraftingHelper.register(new ResourceLocation("forge", "nbt"), NBTIngredient.Serializer.INSTANCE);
        CraftingHelper.register(new ResourceLocation("minecraft", "item"), VanillaIngredientSerializer.INSTANCE);
        ResourceListenerCallback.EVENT.register(serverResources -> {
            INSTANCE = new LootModifierManager();
            return List.of(INSTANCE);
        });
    }

    public static LootModifierManager getLootModifierManager() {
        if(INSTANCE == null)
            throw new IllegalStateException("Can not retrieve LootModifierManager until resources have loaded once.");
        return INSTANCE;
    }
}
