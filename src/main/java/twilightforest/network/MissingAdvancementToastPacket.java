package twilightforest.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import twilightforest.client.MissingAdvancementToast;
import twilightforest.lib.BasePacket;

import java.util.function.Supplier;

public class MissingAdvancementToastPacket implements BasePacket<MissingAdvancementToastPacket> {
    private final Component title;
    private final ItemStack icon;

    public MissingAdvancementToastPacket(Component title, ItemStack icon) {
        this.title = title;
        this.icon = icon;
    }

    public MissingAdvancementToastPacket(FriendlyByteBuf buf) {
        this.title = buf.readComponent();
        this.icon = buf.readItem();
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeComponent(this.title);
        buf.writeItem(this.icon);
    }

    @Override
    public void handle(MissingAdvancementToastPacket packet, BasePacket.Context ctx) {
        ctx.get().enqueueWork(new Runnable() {
            @Override
            public void run() {
                Minecraft.getInstance().getToasts().addToast(new MissingAdvancementToast(packet.title, packet.icon));
            }
        });
    }
}
