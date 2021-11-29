package twilightforest.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import twilightforest.TwilightForestMod;

public class DataGenerators {
	//https://github.com/FabricMC/fabric/pull/1824 waiting on datagen pr
//	@SubscribeEvent
//	public static void gatherData(GatherDataEvent evt) {
//		DataGenerator generator = evt.getGenerator();
//
//		generator.addProvider(new AdvancementProvider(generator));
//		evt.getGenerator().addProvider(new BlockstateGenerator(generator, helper));
//		evt.getGenerator().addProvider(new ItemModelGenerator(generator, helper));
//		BlockTagsProvider blocktags = new BlockTagGenerator(generator, helper);
//		generator.addProvider(blocktags);
//		generator.addProvider(new FluidTagGenerator(generator));
//		generator.addProvider(new ItemTagGenerator(generator, blocktags));
//		generator.addProvider(new EntityTagGenerator(generator));
//		generator.addProvider(new CustomTagGenerator.EnchantmentTagGenerator(generator));
//		generator.addProvider(new LootGenerator(generator));
//		generator.addProvider(new StonecuttingGenerator(generator));
//		generator.addProvider(new CraftingGenerator(generator));
//		generator.addProvider(new TwilightWorldDataCompiler(generator));
//	}
}
