package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import twilightforest.lib.TFInternalApi;
import twilightforest.lib.loot.IGlobalLootModifier;
import twilightforest.lib.loot.LootModifierManager;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;

@Mixin(LootTable.class)
public class LootTableMixin {
    @Inject(method = "getRandomItems(Lnet/minecraft/world/level/storage/loot/LootContext;)Ljava/util/List;", at = @At("TAIL"))
    public void modifyLoot(LootContext context, CallbackInfoReturnable<List<ItemStack>> cir) {
        cir.setReturnValue(modifyLoot(cir.getReturnValue(), context));
    }

    @Unique
    private static List<ItemStack> modifyLoot(List<ItemStack> generatedLoot, LootContext context) {
        LootModifierManager man = TFInternalApi.getLootModifierManager();
        for (IGlobalLootModifier mod : man.getAllLootMods()) {
            generatedLoot = mod.apply(generatedLoot, context);
        }
        return generatedLoot;
    }
}
