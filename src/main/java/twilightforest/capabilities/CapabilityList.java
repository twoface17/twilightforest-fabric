package twilightforest.capabilities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import twilightforest.TwilightForestMod;
import twilightforest.capabilities.shield.IShieldCapability;
import twilightforest.capabilities.shield.ShieldCapabilityHandler;

public class CapabilityList implements EntityComponentInitializer {

	public static final ComponentKey<IShieldCapability> SHIELDS = ComponentRegistry.getOrCreate(new ResourceLocation(TwilightForestMod.ID,"shield"), IShieldCapability.class);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerFor(LivingEntity.class, SHIELDS, ShieldCapabilityHandler::new);
	}
}
