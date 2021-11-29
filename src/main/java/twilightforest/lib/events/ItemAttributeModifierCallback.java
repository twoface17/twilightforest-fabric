package twilightforest.lib.events;

import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

@FunctionalInterface
public interface ItemAttributeModifierCallback {
    Event<ItemAttributeModifierCallback> EVENT = EventFactory.createArrayBacked(ItemAttributeModifierCallback.class, callbacks -> ((stack, slotType, originalModifiers) -> {
        for (ItemAttributeModifierCallback callback : callbacks)
            callback.addAttributres(stack, slotType, originalModifiers);
    }));


    void addAttributres(ItemStack stack, EquipmentSlot slotType, final Multimap<Attribute, AttributeModifier> originalModifiers);
}
