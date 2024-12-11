package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.block.ModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class StrippableLogBlock extends RotatedPillarBlock {

    public StrippableLogBlock(Properties properties) {
        super(properties);
    }

    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        ItemStack itemStack = context.getItemInHand();
        if (!itemStack.canPerformAction(toolAction))
            return null;

        if (ToolActions.AXE_STRIP == toolAction) {
            if(this == ModBlocks.HORRIBLE_LOG.get()){
                return ModBlocks.STRIPPED_HORRIBLE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            }
        }
        if (ToolActions.AXE_STRIP == toolAction) {
            if(this == ModBlocks.HORRIBLE_WOOD.get()){
                return ModBlocks.STRIPPED_HORRIBLE_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            }
        }
        if (ToolActions.AXE_STRIP == toolAction) {
            if(this == ModBlocks.HORRIBLE_BEHOLD_WOOD.get()){
                return ModBlocks.STRIPPED_HORRIBLE_BEHOLD_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            }
        }
        if (ToolActions.AXE_STRIP == toolAction) {
            if(this == ModBlocks.HORRIBLE_BEHOLD_LOG.get()){
                return ModBlocks.STRIPPED_HORRIBLE_BEHOLD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}