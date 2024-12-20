package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.particles.FaFParticlesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.particles.ParticleTypes;

public class FireBlock extends Block {

    public FireBlock(Properties properties) {
        super(properties
                .strength(0.4f)
                .lightLevel(state -> 7)
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);
        if (!level.isClientSide && entity instanceof LivingEntity) {
            entity.setSecondsOnFire(6);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (random.nextInt(3) == 0) {
            double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5);
            double y = pos.getY() + 0.5 + (random.nextDouble() - 0.5);
            double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5);
            level.addParticle(FaFParticlesRegistry.FIRE_SPARK.get(), x, y, z, 0.0, 0.05, 0.0);
        }

        if (random.nextInt(6) == 0) {
            double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5);
            double y = pos.getY() + 0.5 + (random.nextDouble() * 0.5);
            double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5);
            level.addParticle(ParticleTypes.LAVA, x, y, z, 0.0, 0.0, 0.0);
        }

        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);

            if (neighborState.is(Blocks.WATER) ||
                    neighborState.is(Blocks.BLUE_ICE) ||
                    neighborState.is(Blocks.PACKED_ICE) ||
                    neighborState.is(Blocks.ICE) ||
                    neighborState.is(Blocks.SNOW) ||
                    neighborState.is(Blocks.SNOW_BLOCK) ||
                    neighborState.is(Blocks.POWDER_SNOW)) {

                for (int i = 0; i < 8; i++) {
                    double x = neighborPos.getX() + 0.5 + (random.nextDouble() - 0.5);
                    double y = neighborPos.getY() + 0.5 + (random.nextDouble() * 0.5);
                    double z = neighborPos.getZ() + 0.5 + (random.nextDouble() - 0.5);
                    level.addParticle(FaFParticlesRegistry.CLOUD_SPLASH.get(), x, y, z, 0.0, 0.1, 0.0);
                }
            }
        }
    }
}

