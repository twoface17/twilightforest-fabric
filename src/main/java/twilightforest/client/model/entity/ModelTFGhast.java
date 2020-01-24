package twilightforest.client.model.entity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.EntityTFTowerGhast;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class ModelTFGhast<T extends EntityTFTowerGhast> extends EntityModel<T> {
	ModelRenderer body;
	protected ModelRenderer[] tentacles = new ModelRenderer[9];


	public ModelTFGhast() {
		byte yOffset = -16;
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
		this.body.rotationPointY += (float) (24 + yOffset);
		Random rand = new Random(1660L);

		for (int i = 0; i < this.tentacles.length; ++i) {
			makeTentacle(yOffset, rand, i);
		}
	}

	protected void makeTentacle(byte yOffset, Random random, int i) {
		this.tentacles[i] = new ModelRenderer(this, 0, 0);
		float xPoint = (((float) (i % 3) - (float) (i / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
		float zPoint = ((float) (i / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
		int length = random.nextInt(7) + 8;
		this.tentacles[i].addBox(-1.0F, 0.0F, -1.0F, 2, length, 2);
		this.tentacles[i].rotationPointX = xPoint;
		this.tentacles[i].rotationPointZ = zPoint;
		this.tentacles[i].rotationPointY = (float) (23 + yOffset);

		this.body.addChild(this.tentacles[i]);
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
	 * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
	 * "far" arms and legs can swing at most.
	 */
	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// wave tentacles
		for (int i = 0; i < this.tentacles.length; ++i) {
			this.tentacles[i].rotateAngleX = 0.2F * MathHelper.sin(ageInTicks * 0.3F + (float) i) + 0.4F;
		}

		// make body face what we're looking at
		this.body.rotateAngleX = headPitch / (180F / (float) Math.PI);
		this.body.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		this.body.render(scale);
	}
}
