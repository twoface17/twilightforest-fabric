package twilightforest.lib;

import me.pepperbell.simplenetworking.C2SPacket;
import me.pepperbell.simplenetworking.S2CPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.Executor;
import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.PacketListener;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

public interface BasePacket<T extends BasePacket> extends S2CPacket, C2SPacket {
    @Override
    default void handle(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, SimpleChannel.ResponseTarget responseTarget) {
        handle((T) this, new Context(server, handler, player, responseTarget));
    }

    @Override
    default void handle(Minecraft client, ClientPacketListener handler, SimpleChannel.ResponseTarget responseTarget) {
        handle((T) this, new Context(client, handler, null, responseTarget));
    }

    void handle(T packet, Context context);

    public static record Context(Executor exec, PacketListener handler, @Nullable ServerPlayer sender, SimpleChannel.ResponseTarget responseTarget) implements Supplier<Context> {
        public void enqueueWork(Runnable runnable) {
            exec().execute(runnable);
        }

        @Nullable
        public ServerPlayer getSender() {
            return sender();
        }

        public void setPacketHandled(boolean value) {
        }

        @Override
        public Context get() {
            return this;
        }
    }
}
