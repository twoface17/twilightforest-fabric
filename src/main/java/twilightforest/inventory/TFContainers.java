package twilightforest.inventory;

import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import twilightforest.lib.RegistryObject;
import twilightforest.TwilightForestMod;
import twilightforest.client.UncraftingGui;
import twilightforest.lib.TFRegistry;

public class TFContainers {

	public static final TFRegistry<MenuType<?>> CONTAINERS = TFRegistry.create(Registry.MENU, TwilightForestMod.ID);

	public static final RegistryObject<MenuType<UncraftingContainer>> UNCRAFTING = CONTAINERS.register("uncrafting",
			() -> new MenuType<>(UncraftingContainer::fromNetwork));

	@Environment(EnvType.CLIENT)
	public static void renderScreens() {
		ScreenRegistry.register(UNCRAFTING.get(), UncraftingGui::new);
	}
}
