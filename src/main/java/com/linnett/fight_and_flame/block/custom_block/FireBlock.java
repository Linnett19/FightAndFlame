package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.particles.ModParticlesRegistry;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.particles.ParticleTypes;

public class FireBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public FireBlock(Properties properties) {
        super(properties
                .strength(3.0f)
                .lightLevel(state -> 15)
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);
        if (!level.isClientSide) {
            if (entity instanceof LivingEntity livingEntity) {
                entity.setSecondsOnFire(6);
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (random.nextInt(5) == 0) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + random.nextDouble();
            double z = pos.getZ() + random.nextDouble();
            level.addParticle(ParticleTypes.LAVA, x, y, z, 0.0, 0.05, 0.0); // Вызов новой частицы
        }

        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            if (level.getBlockState(neighborPos).is(Blocks.WATER)) {
                for (int i = 0; i < 8; i++) {
                    double x = neighborPos.getX() + 0.5 + (random.nextDouble() - 0.5);
                    double y = neighborPos.getY() + 0.5 + (random.nextDouble() * 0.5);
                    double z = neighborPos.getZ() + 0.5 + (random.nextDouble() - 0.5);
                    level.addParticle(ModParticlesRegistry.CLOUD_SPLASH.get(), x, y, z, 0.0, 0.1, 0.0); // Используем новую частицу
                }
            }
        }
    }
}

