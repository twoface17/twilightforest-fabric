package twilightforest.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import twilightforest.TwilightForestMod;

import javax.annotation.Nullable;

public class FluidTagGenerator extends FabricTagProvider.FluidTagProvider {

    public static final Tag.Named<Fluid> FIRE_JET_FUEL = FluidTags.bind(TwilightForestMod.prefix("fire_jet_fuel").toString());

    public FluidTagGenerator(FabricDataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void generateTags() {
        tag(FIRE_JET_FUEL).addTag(FluidTags.LAVA);
    }
}
