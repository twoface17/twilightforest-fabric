package twilightforest.network;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.FriendlyByteBuf;
import twilightforest.inventory.UncraftingContainer;
import twilightforest.lib.BasePacket;

import java.util.function.Supplier;

public class UncraftingGuiPacket implements BasePacket<UncraftingGuiPacket> {
    private int type;

    public UncraftingGuiPacket(int type) {
        this.type = type;
    }

    public UncraftingGuiPacket(FriendlyByteBuf buf) {
        type = buf.readInt();
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeInt(type);
    }

    @Override
    public void handle(UncraftingGuiPacket packet, Context context) {
        Handler.onMessage(packet, context);
    }

    public static class Handler {

        @SuppressWarnings("Convert2Lambda")
        public static boolean onMessage(UncraftingGuiPacket message, Supplier<BasePacket.Context> ctx) {
            ServerPlayer player = ctx.get().getSender();

            ctx.get().enqueueWork(new Runnable() {
                @Override
                public void run() {
                    AbstractContainerMenu container = player.containerMenu;

                    if (container instanceof UncraftingContainer) {
                        UncraftingContainer uncrafting = (UncraftingContainer) container;

                        switch (message.type) {
                            case 0 -> uncrafting.unrecipeInCycle++;
                            case 1 -> uncrafting.unrecipeInCycle--;
                            case 2 -> uncrafting.ingredientsInCycle++;
                            case 3 -> uncrafting.ingredientsInCycle--;
                            case 4 -> uncrafting.recipeInCycle++;
                            case 5 -> uncrafting.recipeInCycle--;
                        }

                        if (message.type < 4)
                            uncrafting.slotsChanged(uncrafting.tinkerInput);

                        if (message.type >= 4)
                            uncrafting.slotsChanged(uncrafting.assemblyMatrix);
                    }
                }
            });

            return true;
        }
    }
}
