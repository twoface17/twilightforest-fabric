package twilightforest.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.HollowLogClimbable;
import twilightforest.block.HollowLogHorizontal;
import twilightforest.block.HollowLogVertical;

import javax.annotation.Nullable;
import java.util.Map;

public class HollowLogItem extends BlockItem {
    private final HollowLogHorizontal horizontalLog;
    private final HollowLogVertical verticalLog;
    private final HollowLogClimbable climbable;

    public HollowLogItem(HollowLogHorizontal horizontalLog, HollowLogVertical verticalLog, HollowLogClimbable climbable, Properties properties) {
        super(verticalLog, properties);
        this.horizontalLog = horizontalLog;
        this.verticalLog = verticalLog;
        this.climbable = climbable;
    }

    @Nullable
    @Override
    protected BlockState getPlacementState(BlockPlaceContext context) {
        return switch (context.getClickedFace().getAxis()) {
            case Y -> this.verticalLog.getStateForPlacement(context);
            case X, Z -> this.horizontalLog.getStateForPlacement(context);
        };
    }

    @Override
    public void registerBlocks(Map<Block, Item> pBlockToItemMap, Item pItem) {
        super.registerBlocks(pBlockToItemMap, pItem);
        pBlockToItemMap.put(this.horizontalLog, pItem);
        pBlockToItemMap.put(this.verticalLog, pItem);
        pBlockToItemMap.put(this.climbable, pItem);
    }


    //TODO: PORT
    //@Override
    public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        //super.removeFromBlockToItemMap(blockToItemMap, itemIn);
        blockToItemMap.remove(this.horizontalLog);
        blockToItemMap.remove(this.verticalLog);
        blockToItemMap.remove(this.climbable);
    }
}
