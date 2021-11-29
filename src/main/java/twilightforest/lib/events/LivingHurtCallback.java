package twilightforest.lib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

@FunctionalInterface
public interface LivingHurtCallback {
    Event<LivingHurtCallback> EVENT = EventFactory.createArrayBacked(LivingHurtCallback.class, callbacks -> (event) -> {
        for (LivingHurtCallback callback : callbacks) {
            callback.onHurt(event);
        }
        return event.getAmount();
    });

    float onHurt(LivingHurtEvent event);

    class LivingHurtEvent {
        private final LivingEntity entity;
        private final DamageSource source;
        private float amount;
        public LivingHurtEvent(LivingEntity entity, DamageSource source, float amount)
        {
            this.entity = entity;
            this.source = source;
            this.amount = amount;
        }

        public LivingEntity getEntityLiving() { return entity; }

        public DamageSource getSource() { return source; }

        public float getAmount() { return amount; }

        public void setAmount(float amount) { this.amount = amount; }
    }
}
