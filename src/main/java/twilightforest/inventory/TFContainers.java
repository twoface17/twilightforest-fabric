package twilightforest.inventory;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import twilightforest.TwilightForestMod;
import twilightforest.api.RegistryObject;
import twilightforest.api.TFRegistry;
import twilightforest.client.UncraftingGui;

import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;

public class TFContainers {

	public static final TFRegistry<MenuType<?>> CONTAINERS = TFRegistry.create(Registry.MENU, TwilightForestMod.ID);

	public static final RegistryObject<MenuType<UncraftingContainer>> UNCRAFTING = CONTAINERS.register("uncrafting",
			() -> new MenuType<>(UncraftingContainer::fromNetwork));

	@Environment(EnvType.CLIENT)
	public static void renderScreens() {
		ScreenRegistry.register(UNCRAFTING.get(), UncraftingGui::new);
	}
}
