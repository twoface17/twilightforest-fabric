package twilightforest.lib.events;

import com.mojang.math.Vector3f;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import java.awt.*;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.Vec3i;

public interface EntityViewEvents {

    Event<FogColors> FOG_COLORS = EventFactory.createArrayBacked(FogColors.class, callbacks -> ((info, partialTicks, color) -> {
        for (FogColors event : callbacks) {
            Vector3f newColor = event.fogColors(info, partialTicks, color);
            if(newColor != null)
                return newColor;
        }
        return color;
    }));

    Event<FogRender> FOG_RENDER = EventFactory.createArrayBacked(FogRender.class, callbacks -> (type, info, partial, distance) -> {
        for (FogRender event : callbacks)
            event.onFogRender(type, info, partial, distance);
    });

    @FunctionalInterface
    interface FogColors {
        Vector3f fogColors(Camera info, float partialTicks, Vector3f color);
    }

    @FunctionalInterface
    interface FogRender {
        void onFogRender(FogRenderer.FogMode type, Camera info, float partial, float distance);
    }
}
