package twilightforest.client.providers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shadow.fabric.api.client.rendering.v1.ArmorRenderingRegistry;
import twilightforest.TwilightForestMod;
import twilightforest.client.model.TFModelLayers;
import twilightforest.client.model.armor.TFArmorModel;

@Environment(EnvType.CLIENT)
public class KnightArmorProvider implements ArmorRenderingRegistry.ModelProvider, ArmorRenderingRegistry.TextureProvider{
    @Override
    public @NotNull HumanoidModel<LivingEntity> getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot armorSlot, HumanoidModel<LivingEntity> defaultModel) {
        EntityModelSet models = Minecraft.getInstance().getEntityModels();
        ModelPart root = models.bakeLayer(armorSlot == EquipmentSlot.LEGS ? TFModelLayers.KNIGHTMETAL_ARMOR_INNER : TFModelLayers.KNIGHTMETAL_ARMOR_OUTER);
        return new TFArmorModel(root);
    }

    @Override
    public @NotNull ResourceLocation getArmorTexture(LivingEntity entity, ItemStack stack, EquipmentSlot slot, boolean secondLayer, @Nullable String suffix, ResourceLocation defaultTexture) {
        if (slot == EquipmentSlot.LEGS) {
            return TwilightForestMod.getArmorTexture("knightly_2.png");
        } else {
            return TwilightForestMod.getArmorTexture("knightly_1.png");
        }
    }
}