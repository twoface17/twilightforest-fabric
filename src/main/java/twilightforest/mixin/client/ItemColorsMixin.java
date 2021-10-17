package twilightforest.mixin.client;

import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import twilightforest.client.ColorHandler;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;

@Mixin(ItemColors.class)
public class ItemColorsMixin {
    @Inject(method = "createDefault", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void initItemColors(BlockColors blockColors, CallbackInfoReturnable<ItemColors> cir, ItemColors itemColors) {
        DynamicRegistrySetupCallback.EVENT.register((registryManager -> ColorHandler.registerItemColors(itemColors, blockColors)));
    }
}
