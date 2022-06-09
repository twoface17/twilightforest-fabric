package twilightforest.world.components.structures.start;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import twilightforest.world.components.structures.util.LegacyStructureAdapter;
import twilightforest.init.TFLandmark;
import twilightforest.init.TFStructureTypes;

import java.util.Optional;

@Deprecated
public class LegacyStructure extends Structure implements LegacyStructureAdapter {
    public final TFLandmark feature;

	public static final Codec<LegacyStructure> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			TFLandmark.CODEC.fieldOf("legacy_landmark_id").forGetter(o -> o.feature),
			Structure.settingsCodec(instance)
	).apply(instance, LegacyStructure::new));

	public LegacyStructure(TFLandmark feature, StructureSettings structureSettings) {
		super(structureSettings);
		this.feature = feature;
	}

	@Override
	public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
		return this.feature.generateStub(context);
	}

	@Override
	public StructureType<?> type() {
		return TFStructureTypes.LEGACY_TYPE.get();
	}

	@Override
	public TFLandmark getFeatureType() {
		return this.feature;
	}
}
