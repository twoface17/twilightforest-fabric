package twilightforest.lib.data;

import net.fabricmc.fabric.api.tag.TagFactory;

import net.minecraft.core.Registry;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.enchantment.Enchantment;

public interface DataUtil {
    TagFactory<Enchantment> ENCHANTMENTS = TagFactory.of(Registry.ENCHANTMENT_REGISTRY, "tags/enchantments");

    static <T> TagsProvider.TagAppender<T> addTags(TagsProvider.TagAppender<T> builder, Tag.Named<T>... values) {
        for (Tag.Named<T> value : values) {
            builder.addTag(value);
        }
        return builder;
    }

}
