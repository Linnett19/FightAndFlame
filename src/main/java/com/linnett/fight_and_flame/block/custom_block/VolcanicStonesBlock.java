package com.linnett.fight_and_flame.block.custom_block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VolcanicStonesBlock extends Block {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());

    public VolcanicStonesBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        return this.defaultBlockState().setValue(FACING, direction);
    }

    @Override
    public VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter world, net.minecraft.core.BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);

        // Вместо проработанных хитбоксов, используем один большой куб, охватывающий модель
        return Shapes.box(3 / 16.0, 0 / 16.0, 3 / 16.0, 13 / 16.0, 10.8 / 16.0, 13 / 16.0);
    }
}










