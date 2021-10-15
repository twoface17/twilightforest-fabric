package twilightforest.mixin.client;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import twilightforest.TwilightForestMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.HitResult;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final private Minecraft minecraft;

    @Redirect(method = "pick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;pick(DFZ)Lnet/minecraft/world/phys/HitResult;"))
    public HitResult debug(Entity entity, double rayTraceDistance, float partialTicks, boolean rayTraceFluids) {
        HitResult result = entity.pick(rayTraceDistance, partialTicks, rayTraceFluids);
        for(ModContainer modMetadata : FabricLoader.getInstance().getAllMods()) {
            modMetadata.getMetadata().getType();
        }
        //TwilightForestMod.LOGGER.info(result);
        return result;
    }
}
