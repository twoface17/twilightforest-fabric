package twilightforest.lib.events;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import twilightforest.lib.util.TextureStitchUtil;

@Environment(EnvType.CLIENT)
public interface OnTextureStitchCallback {
    Event<OnTextureStitchCallback.Post> POST = EventFactory.createArrayBacked(OnTextureStitchCallback.Post.class, callbacks -> (util) -> {
        for (OnTextureStitchCallback.Post callback : callbacks) {
            callback.onModelRegistry(util);
        }
    });

    Event<OnTextureStitchCallback.Post> PRE = EventFactory.createArrayBacked(OnTextureStitchCallback.Post.class, callbacks -> (util) -> {
        for (OnTextureStitchCallback.Post callback : callbacks) {
            callback.onModelRegistry(util);
        }
    });

    interface Post {
        void onModelRegistry(TextureStitchUtil util);
    }

    interface Pre {
        void onModelRegistry(TextureStitchUtil util);
    }
}
