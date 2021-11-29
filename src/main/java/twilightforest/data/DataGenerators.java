package twilightforest.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import twilightforest.TwilightForestMod;

public class DataGenerators {
	//https://github.com/FabricMC/fabric/pull/1824 waiting on datagen pr
//	@SubscribeEvent
//	public static void gatherData(GatherDataEvent evt) {
//		DataGenerator generator = evt.getGenerator();
//		ExistingFileHelper helper = evt.getExistingFileHelper();
//
//		generator.addProvider(new AdvancementGenerator(generator, helper));
//		generator.addProvider(new PatchouliAdvancementGenerator(generator, helper));
//		generator.addProvider(new BlockstateGenerator(generator, helper));
//		generator.addProvider(new ItemModelGenerator(generator, helper));
//		BlockTagsProvider blocktags = new BlockTagGenerator(generator, helper);
//		generator.addProvider(blocktags);
//		generator.addProvider(new FluidTagGenerator(generator, helper));
//		generator.addProvider(new ItemTagGenerator(generator, blocktags, helper));
//		generator.addProvider(new EntityTagGenerator(generator, helper));
//		generator.addProvider(new CustomTagGenerator.EnchantmentTagGenerator(generator, helper));
//		generator.addProvider(new LootGenerator(generator));
//		generator.addProvider(new StonecuttingGenerator(generator));
//		generator.addProvider(new CraftingGenerator(generator));
//		generator.addProvider(new TwilightWorldDataCompiler(generator));
//	}
}
