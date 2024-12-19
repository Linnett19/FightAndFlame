package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.particles.ModParticlesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AshBlock extends FallingBlock {
    private static final float HORIZONTAL_PARTICLE_MOMENTUM_FACTOR = 0.083333336F;
    private static final float NUM_BLOCKS_TO_FALL_INTO_BLOCK = 2.5F;
    private static final VoxelShape FALLING_COLLISION_SHAPE = Shapes.box(0.0, 0.0, 0.0, 1.0, 0.8999999761581421, 1.0);
    private static final double MINIMUM_FALL_DISTANCE_FOR_SOUND = 4.0;
    private static final double MINIMUM_FALL_DISTANCE_FOR_BIG_SOUND = 7.0;

    public AshBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction direction) {
        return adjacentBlockState.is(this) || super.skipRendering(state, adjacentBlockState, direction);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter getter, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getFeetBlockState().is(this)) {
            entity.makeStuckInBlock(state, new Vec3(0.5, 0.5, 0.5));

            if (level.isClientSide) {
                RandomSource random = level.getRandom();
                boolean isMoving = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
                if (isMoving && random.nextBoolean()) {
                    level.addParticle(
                            ModParticlesRegistry.ASH_FLAKE.get(),
                            entity.getX(),
                            pos.getY() + 1,
                            entity.getZ(),
                            Mth.randomBetween(random, -1.0F, 1.0F) * HORIZONTAL_PARTICLE_MOMENTUM_FACTOR,
                            0.05,
                            Mth.randomBetween(random, -1.0F, 1.0F) * HORIZONTAL_PARTICLE_MOMENTUM_FACTOR
                    );
                }
            } else {
                entity.setSecondsOnFire(5);
            }
        }
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!(fallDistance < MINIMUM_FALL_DISTANCE_FOR_SOUND) && entity instanceof LivingEntity livingEntity) {
            LivingEntity.Fallsounds fallSounds = livingEntity.getFallSounds();
            SoundEvent soundEvent = (fallDistance < MINIMUM_FALL_DISTANCE_FOR_BIG_SOUND) ? fallSounds.small() : fallSounds.big();
            entity.playSound(soundEvent, 1.0F, 1.0F);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext entityContext) {
            Entity entity = entityContext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > NUM_BLOCKS_TO_FALL_INTO_BLOCK) {
                    return FALLING_COLLISION_SHAPE;
                }
                if (entity instanceof FallingBlockEntity) {
                    return super.getCollisionShape(state, getter, pos, context);
                }
            }
        }
        return Shapes.empty();
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return true;
    }
}

