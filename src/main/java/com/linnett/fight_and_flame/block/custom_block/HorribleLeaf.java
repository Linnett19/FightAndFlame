package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.particles.FaFParticlesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HorribleLeaf extends LeavesBlock {
    public HorribleLeaf(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (belowState.isAir() || !belowState.canOcclude() && !(belowState.getBlock() instanceof LeavesBlock)) {
            if (random.nextFloat() < 0.2) {
                for (int i = 0; i < 1; i++) {
                    double particleX = pos.getX() + 0.5 + (random.nextDouble() - 0.5);
                    double particleY = pos.getY() - 0.1;
                    double particleZ = pos.getZ() + 0.5 + (random.nextDouble() - 0.5);
                    level.addParticle(FaFParticlesRegistry.HORRIBLE_LEAF.get(), particleX, particleY, particleZ, 0, -0.05, 0);
                }
            }
        }
    }



    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0, 0, 0, 16, 16, 16);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return super.getFluidState(state);
    }
}

