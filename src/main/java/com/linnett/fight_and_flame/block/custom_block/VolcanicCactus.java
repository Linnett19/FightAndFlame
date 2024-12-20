package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.block.FaFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VolcanicCactus extends CactusBlock {

    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

    public VolcanicCactus(Properties properties) {
        super(properties
                .strength(0.4f)
                .lightLevel(state -> 7)
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity livingEntity) {
            livingEntity.hurt(livingEntity.damageSources().cactus(), 3.0f);
            entity.setSecondsOnFire(3);
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity livingEntity) {
            livingEntity.hurt(livingEntity.damageSources().cactus(), 3.0f);
            entity.setSecondsOnFire(3);
        }
    }



    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        boolean isValidGround = belowState.is(Blocks.SAND)
                || belowState.is(Blocks.RED_SAND)
                || belowState.is(FaFBlocks.VOLCANO_STONE.get())
                || belowState.is(FaFBlocks.VOLCANO_MAGMA.get())
                || belowState.is(FaFBlocks.VOLCANIC_CACTUS.get())
                || belowState.is(this);

        boolean isAirNorth = level.getBlockState(pos.north()).isAir();
        boolean isAirSouth = level.getBlockState(pos.south()).isAir();
        boolean isAirWest = level.getBlockState(pos.west()).isAir();
        boolean isAirEast = level.getBlockState(pos.east()).isAir();

        return isValidGround && isAirNorth && isAirSouth && isAirWest && isAirEast;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!canSurvive(state, level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        neighborChanged(state, level, pos, this, pos, isMoving);
    }


    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockPos abovePos = pos.above();
        if (canSurvive(state, level, abovePos) && level.isEmptyBlock(abovePos)) {
            int cactusHeight = 1;
            BlockPos checkPos = pos.below();

            while (level.getBlockState(checkPos).is(this)) {
                cactusHeight++;
                checkPos = checkPos.below();
            }

            if (cactusHeight < 5 && random.nextInt(5) == 0) {
                level.setBlockAndUpdate(abovePos, this.defaultBlockState());
            }
        }
    }


    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + random.nextDouble();
            double z = pos.getZ() + random.nextDouble();
            level.addParticle(ParticleTypes.FLAME, x, y, z, 0.0, 0.05, 0.0);
        }
    }
}


