package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.block.entity.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class FaFHangingSignBlock extends CeilingHangingSignBlock {
    public FaFHangingSignBlock(Properties properties, WoodType type) {
        super(properties, type);
    }
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSignBlockEntity(pPos, pState);
    }

}
