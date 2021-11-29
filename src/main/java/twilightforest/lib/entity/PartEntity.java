package twilightforest.lib.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;

public abstract class PartEntity<T extends Entity> extends Entity {
    private final T parent;

    public PartEntity(T parent) {
        super(parent.getType(), parent.level);
        this.parent = parent;
    }

    public T getParent() {
        return parent;
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }
}
