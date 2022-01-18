package twilightforest.lib.extensions;

import com.mojang.math.Transformation;

public interface IModelStateEx {
    default Transformation getPartTransformation(Object part)
    {
        return Transformation.identity();
    }
}
