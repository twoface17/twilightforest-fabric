package twilightforest.lib.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import twilightforest.lib.entity.PartEntity;
import twilightforest.lib.extensions.IEntityEx;

import java.util.Objects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;

public class WorldUtil {
    @SuppressWarnings("deprecation")
    public static boolean isAreaLoaded(LevelReader world, BlockPos center, int range) {
        return world.hasChunksAt(center.offset(-range, -range, -range), center.offset(range, range, range));
    }

    // Not much of a world util but its fine here for now
    public static ItemStack getItemStack(JsonObject json, boolean readNBT)
    {
        String itemName = GsonHelper.getAsString(json, "item");

        Item item = Registry.ITEM.get(new ResourceLocation(itemName));

        if (item == null)
            throw new JsonSyntaxException("Unknown item '" + itemName + "'");

        if (readNBT && json.has("nbt"))
        {
            // Lets hope this works? Needs test
            try
            {
                JsonElement element = json.get("nbt");
                CompoundTag nbt;
                if(element.isJsonObject())
                    nbt = TagParser.parseTag(new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(element));
                else
                    nbt = TagParser.parseTag(GsonHelper.convertToString(element, "nbt"));

                CompoundTag tmp = new CompoundTag();

                tmp.put("tag", nbt);
                tmp.putString("id", itemName);
                tmp.putInt("Count", GsonHelper.getAsInt(json, "count", 1));

                return ItemStack.of(tmp);
            }
            catch (CommandSyntaxException e)
            {
                throw new JsonSyntaxException("Invalid NBT Entry: " + e.toString());
            }
        }

        return new ItemStack(item, GsonHelper.getAsInt(json, "count", 1));
    }

    public static void removeEntityComplete(ServerLevel level, Entity entity, boolean keepData) {
        if((IEntityEx.cast(entity).isMultipartEntity())) {
            for(PartEntity<?> parts : Objects.requireNonNull(((IEntityEx) entity).getParts())) {
                parts.discard();
            }
        }

        level.getChunkSource().removeEntity(entity);
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverplayerentity = (ServerPlayer)entity;
            level.players.remove(serverplayerentity);
        }

        level.getScoreboard().entityRemoved(entity);
        if (entity instanceof Mob) {
            level.navigatingMobs.remove(((Mob)entity).getNavigation());
        }

        entity.discard();
        ServerEntityEvents.ENTITY_UNLOAD.invoker().onUnload(entity, level);
    }
}
