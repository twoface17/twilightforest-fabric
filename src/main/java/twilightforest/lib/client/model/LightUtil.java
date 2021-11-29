package twilightforest.lib.client.model;

import net.minecraft.client.renderer.block.model.BakedQuad;

public class LightUtil {

    public static int getLightOffset(int v) {
        return (v * 8) + 6;
    }

    public static void setLightData(BakedQuad q, int light) {
        int[] data = q.getVertices();
        for (int i = 0; i < 4; i++)
        {
            data[getLightOffset(i)] = light;
        }
    }
}
