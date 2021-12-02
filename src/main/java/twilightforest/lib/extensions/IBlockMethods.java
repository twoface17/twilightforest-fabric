package twilightforest.lib.extensions;

import twilightforest.lib.block.IPlantable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;

//TODO: Implement a mixin for each one of these properties somewhere in minecraft, to check, and do said special behaviour if the block has that property.
public interface IBlockMethods {
    default float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 0.0f;
    }

    default int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 0;
    }

    default int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 0;
    }

    default boolean isFireSource(BlockState state, LevelReader world, BlockPos pos, Direction side) {
        return false;
    }

    default boolean isStickyBlock(BlockState state) {
        return false;
    }

    default boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.relative(facing));
        IPlantable.PlantType type = plantable.getPlantType(world, pos.relative(facing));

        if (plant.getBlock() == Blocks.CACTUS)
            return state.is(Blocks.CACTUS) || state.is(Blocks.SAND) || state.is(Blocks.RED_SAND);

        if (plant.getBlock() == Blocks.SUGAR_CANE && this == Blocks.SUGAR_CANE)
            return true;

        if (plantable instanceof BushBlock && ((BushBlock)plantable).mayPlaceOn(state, world, pos))
            return true;

        if (IPlantable.PlantType.DESERT.equals(type)) {
            return this == Blocks.SAND || this == Blocks.TERRACOTTA || this instanceof GlazedTerracottaBlock;
        } else if (IPlantable.PlantType.NETHER.equals(type)) {
            return this == Blocks.SOUL_SAND;
        } else if (IPlantable.PlantType.CROP.equals(type)) {
            return state.is(Blocks.FARMLAND);
        } else if (IPlantable.PlantType.CAVE.equals(type)) {
            return state.isFaceSturdy(world, pos, Direction.UP);
        } else if (IPlantable.PlantType.PLAINS.equals(type)) {
            return this == Blocks.GRASS_BLOCK || state.is(Blocks.DIRT) || this == Blocks.FARMLAND;
        } else if (IPlantable.PlantType.WATER.equals(type)) {
            return state.getMaterial() == net.minecraft.world.level.material.Material.WATER; //&& state.getValue(BlockLiquidWrapper)
        } else if (IPlantable.PlantType.BEACH.equals(type)) {
            boolean isBeach = state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.SAND) || state.is(Blocks.RED_SAND);
            boolean hasWater = false;
            for (Direction face : Direction.Plane.HORIZONTAL) {
                BlockState blockState = world.getBlockState(pos.relative(face));
                FluidState fluidState = world.getFluidState(pos.relative(face));
                hasWater |= blockState.is(Blocks.FROSTED_ICE);
                hasWater |= fluidState.is(net.minecraft.tags.FluidTags.WATER);
                if (hasWater)
                    break; //No point continuing.
            }
            return isBeach && hasWater;
        }
        return false;
    };

    default boolean isValidSpawn(BlockState state, BlockGetter world, BlockPos pos, SpawnPlacements.Type type, @Nullable EntityType<?> entityType) {
        return true;
    }
    default float getExplosionResistance(BlockState state, BlockGetter world, BlockPos pos, Explosion explosion) {
        return 0.0f;
    }

    /**
     * Determines if this block is can be destroyed by the specified entities normal behavior.
     *
     * @param state The current state
     * @param world The current world
     * @param pos Block position in world
     * @return True to allow the ender dragon to destroy this block
     */
    default boolean canEntityDestroy(BlockState state, BlockGetter world, BlockPos pos, Entity entity)
    {
        if (entity instanceof EnderDragon)
        {
            return !BlockTags.DRAGON_IMMUNE.contains((Block) this);
        }
        else if ((entity instanceof WitherBoss) ||
                (entity instanceof WitherSkull))
        {
            return state.isAir() || WitherBoss.canDestroy(state);
        }

        return true;
    }

    default boolean canEntityDestroy(BlockState state, BlockPos pos, Entity entity) {
        return true;
    }

    /**
     * Determines if the player can harvest this block, obtaining it's drops when the block is destroyed.
     *
     * @param world The current world
     * @param pos The block's current position
     * @param player The player damaging the block
     * @return True to spawn the drops
     */
    default boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player)
    {
        return true;
    }

    /**
     * Called when a player removes a block.  This is responsible for
     * actually destroying the block, and the block is intact at time of call.
     * This is called regardless of whether the player can harvest the block or
     * not.
     *
     * Return true if the block is actually destroyed.
     *
     * Note: When used in multiplayer, this is called on both client and
     * server sides!
     *
     * @param state The current state.
     * @param world The current world
     * @param player The player damaging the block, may be null
     * @param pos Block position in world
     * @param willHarvest True if Block.harvestBlock will be called after this, if the return in true.
     *        Can be useful to delay the destruction of tile entities till after harvestBlock
     * @param fluid The current fluid state at current position
     * @return True if the block is actually destroyed.
     */
    default boolean onDestroyedByPlayer(BlockState state, Level world, BlockPos pos, Player player, boolean willHarvest, FluidState fluid)
    {
        ((Block) this).playerWillDestroy(world, pos, state, player);
        return world.setBlock(pos, fluid.createLegacyBlock(), world.isClientSide ? 11 : 3);
    }

    @Nullable
    default BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter world, BlockPos pos, @Nullable Mob entity) {
        return state.getBlock() == Blocks.LAVA ? BlockPathTypes.LAVA : (this == Blocks.FIRE || this == Blocks.LAVA) ? BlockPathTypes.DAMAGE_FIRE : null;
    }

    default int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return 0;
    };

    default boolean tf$isBookshelf() {
        return false;
    }

    static IBlockMethods cast(Block block) {
        if(block instanceof IBlockMethods blockEx)
            return blockEx;
        throw new ClassCastException();
    }

    default BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
        return state.rotate(direction);
    }

    default void onCaughtFire(BlockState state, Level world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {}
}
