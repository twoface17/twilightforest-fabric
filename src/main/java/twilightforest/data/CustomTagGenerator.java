package twilightforest.data;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import twilightforest.TwilightForestMod;
import twilightforest.lib.data.DataUtil;

import java.nio.file.Path;

import javax.annotation.Nullable;

//a place to hold all custom tags, since I imagine we wont have a lot of them
public class CustomTagGenerator {

	public static class EnchantmentTagGenerator extends TagsProvider<Enchantment> {

		public static final Tag.Named<Enchantment> PHANTOM_ARMOR_BANNED_ENCHANTS = DataUtil.ENCHANTMENTS.create(TwilightForestMod.prefix("phantom_armor_banned_enchants"));

		public EnchantmentTagGenerator(DataGenerator generatorIn) {
			super(generatorIn, Registry.ENCHANTMENT);
		}

		@Override
		protected void addTags() {
			tag(PHANTOM_ARMOR_BANNED_ENCHANTS).add(Enchantments.VANISHING_CURSE, Enchantments.BINDING_CURSE);
		}

		@Override
		protected Path getPath(ResourceLocation id) {
			Path ouput = this.generator.getOutputFolder();
			String namespace = id.getNamespace();
			return ouput.resolve("data/" + namespace + "/tags/enchantments/" + id.getPath() + ".json");
		}

		@Override
		public String getName() {
			return "Twilight Forest Enchantment Tags";
		}
	}
}
