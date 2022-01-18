package twilightforest.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

public class DataGenerators implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		var existingData = System.getProperty("twilightforest.data.existingData").split(";");
		var helper = new ExistingFileHelper(Arrays.stream(existingData).map(Paths::get).toList(), Collections.emptySet(),
				true, null, null);

		generator.addProvider(new AdvancementGenerator(generator));
		generator.addProvider(new PatchouliAdvancementGenerator(generator));
		generator.addProvider(new BlockstateGenerator(generator, helper));
		generator.addProvider(new ItemModelGenerator(generator, helper));
		FabricTagProvider.BlockTagProvider blocktags = new BlockTagGenerator(generator);
		generator.addProvider(blocktags);
		generator.addProvider(new FluidTagGenerator(generator));
		generator.addProvider(new ItemTagGenerator(generator, blocktags));
		generator.addProvider(new EntityTagGenerator(generator));
		generator.addProvider(new CustomTagGenerator.EnchantmentTagGenerator(generator));
		generator.addProvider(new LootGenerator(generator));
		generator.addProvider(new StonecuttingGenerator(generator));
		generator.addProvider(new CraftingGenerator(generator));
		generator.addProvider(new TwilightWorldDataCompiler(generator));
	}
}
