package twilightforest.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import twilightforest.TwilightForestMod;

import javax.annotation.Nullable;

public class FluidTagGenerator extends FluidTagsProvider {

    public static final Tag.Named<Fluid> FIRE_JET_FUEL = FluidTags.bind(TwilightForestMod.prefix("fire_jet_fuel").toString());

    public FluidTagGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void addTags() {
        tag(FIRE_JET_FUEL).addTag(FluidTags.LAVA);
    }
}
