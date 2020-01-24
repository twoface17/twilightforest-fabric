package twilightforest.client.model.entity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelTFHydraMortar extends EntityModel {

	public ModelRenderer box;

	public ModelTFHydraMortar() {
		textureWidth = 32;
		textureHeight = 32;
		box = new ModelRenderer(this, 0, 0);
		box.addBox(-4F, 0F, -4F, 8, 8, 8, 0F);
		box.setRotationPoint(0F, 0F, 0F);
	}

	public void render(float f5) {
		box.render(f5);
	}
}
