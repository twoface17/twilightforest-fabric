package twilightforest.data;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import net.fabricmc.fabric.api.tag.TagFactory;
import twilightforest.TwilightForestMod;

import java.nio.file.Path;

//a place to hold all custom tags, since I imagine we wont have a lot of them
public class CustomTagGenerator {

	public static class EnchantmentTagGenerator extends TagsProvider<Enchantment> {

	    public static final TagFactory<Enchantment> ENCHANTMENTS = TagFactory.of(Registry.ENCHANTMENT_REGISTRY, "tags/enchantments");

		public static final Tag.Named<Enchantment> PHANTOM_ARMOR_BANNED_ENCHANTS = ENCHANTMENTS.create(TwilightForestMod.prefix("phantom_armor_banned_enchants"));

		public EnchantmentTagGenerator(DataGenerator generatorIn) {
			super(generatorIn, Registry.ENCHANTMENT);
		}

		@Override
		protected void addTags() {
			tag(PHANTOM_ARMOR_BANNED_ENCHANTS).add(Enchantments.VANISHING_CURSE, Enchantments.BINDING_CURSE);
		}

        @Override
        protected Path getPath(ResourceLocation id) {
            return generator.getOutputFolder().resolve("data/" + id.getNamespace() + "/tags/enchantments/" + id.getPath() + ".json");
        }

        @Override
		public String getName() {
			return "Twilight Forest Enchantment Tags";
		}
	}
}
