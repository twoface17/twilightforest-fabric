package twilightforest.client.model.item;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;
import java.util.List;

public class TintIndexAwareFullbrightBakedModel extends FullbrightBakedModel {

	public TintIndexAwareFullbrightBakedModel(BakedModel delegate) {
		super(delegate);
	}

	@Override
	protected List<BakedQuad> getQuads(@Nullable Direction face, List<BakedQuad> quads) {
		for (BakedQuad quad : quads)
			if (quad.isTinted())
				setLightData(quad, 0xF000F0);
		return quads;
	}

	public static void setLightData(BakedQuad q, int light)
	{
		int[] data = q.getVertices();
		for (int i = 0; i < 4; i++)
		{
			data[(i * 8) + 6] = light;
		}
	}
}
