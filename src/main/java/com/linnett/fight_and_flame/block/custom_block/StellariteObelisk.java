package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.particles.FaFParticlesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class StellariteObelisk extends Block {
    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(1, 2, 1, 15, 6, 15),
            Block.box(1, 10, 1, 15, 14, 15),
            Block.box(5, 6, 5, 11, 10, 11),
            Block.box(0, 14, 0, 16, 16, 16)
    );

    public StellariteObelisk(Properties properties) {
        super(properties.lightLevel((state) -> 10));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + random.nextDouble();
            level.addParticle(FaFParticlesRegistry.MAGIC_SONAR.get(), x, y, z, 0.0, 0.05, 0.0);
        }
    }
}

