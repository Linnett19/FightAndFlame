package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.items.FaFItems;
import com.linnett.fight_and_flame.particles.FaFParticlesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ScaryCauldron extends AbstractCauldronBlock {

    public static final int LevelMax = 5;
    public static final int MaxCandy = 100;
    private int candyNumber = 0;

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final IntegerProperty CANDY_NUMBER = IntegerProperty.create("candy_number", 0, 100);
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, LevelMax);

    public ScaryCauldron(BlockBehaviour.Properties properties) {
        super(properties, CauldronInteraction.EMPTY);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(STAGE, 0)
                .setValue(CANDY_NUMBER, 0)
        );

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(STAGE);
        builder.add(CANDY_NUMBER);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.PASS;
        }

        ItemStack itemStack = player.getItemInHand(hand);
        int particleCount = 1;
        double xOffset = 0.1;
        double yOffset = 0.1;
        double zOffset = 0.1;

        if (isCustomItem(itemStack.getItem())) {
            if (itemStack.getItem() == FaFItems.CANDI_CORN.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.CANDY_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SCARY_DUST.get(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, particleCount, xOffset, yOffset, zOffset, 0.1);
                updateCauldronLevel(level, pos, state);
            }

            if (itemStack.getItem() == FaFItems.SLIME_LOLIPOP.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SLIME_LOLIPOP_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SCARY_DUST.get(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, particleCount, xOffset, yOffset, zOffset, 0.1);
                updateCauldronLevel(level, pos, state);
            }
            if (itemStack.getItem() == FaFItems.SOUR_BONE.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SOUL_BONE_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SCARY_DUST.get(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, particleCount, xOffset, yOffset, zOffset, 0.1);
                updateCauldronLevel(level, pos, state);
            }
            if (itemStack.getItem() == FaFItems.JELLY_BALLS.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.JELLY_BALLS_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SCARY_DUST.get(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, particleCount, xOffset, yOffset, zOffset, 0.1);
                updateCauldronLevel(level, pos, state);
            }
            itemStack.shrink(1);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }


    @Override
    public boolean isFull(BlockState blockState) {
        return false;
    }

    private boolean isCustomItem(Item item) {
        return item == FaFItems.CANDI_CORN.get() || item == FaFItems.SOUR_BONE.get() ||
                item == FaFItems.SLIME_LOLIPOP.get() || item == FaFItems.JELLY_BALLS.get();
    }

    private static void breakCauldron(ServerLevel level, BlockPos pos) {
        level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
        ((ServerLevel) level).sendParticles(FaFParticlesRegistry.JELLY_BALLS_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        ((ServerLevel) level).sendParticles(FaFParticlesRegistry.CANDY_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SOUL_BONE_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SLIME_LOLIPOP_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        level.destroyBlock(pos, false);
    }


    private void updateCauldronLevel(Level level, BlockPos pos, BlockState state) {
        int candyNumber = state.getValue(CANDY_NUMBER);

        candyNumber += 1;

        if (candyNumber >= MaxCandy) {
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(FaFItems.SANGUINITE.get()));
            level.addFreshEntity(itemEntity);
            breakCauldron((ServerLevel) level, pos);
            return;
        }


        if (candyNumber == 20) {
            spawnMob(level, pos, 4, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 40) {
            spawnMob(level, pos, 5, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 60) {
            spawnMob(level, pos, 5, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 90) {
            spawnMob(level, pos, 1, EntityType.WITCH);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 100) {
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber <= 100) {
            level.setBlock(pos, state.setValue(CANDY_NUMBER, candyNumber), 3);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        int candyNumber = state.getValue(CANDY_NUMBER);

        if (candyNumber > 10 && random.nextInt(5) == 0) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5;

            level.addParticle(
                    FaFParticlesRegistry.SCARY_BUBBLE.get(),
                    x, y, z,
                    random.nextFloat() * 0.1 - 0.05, // Случайное смещение по X
                    random.nextFloat() * 0.1 - 0.05, // Случайное смещение по Y
                    random.nextFloat() * 0.1 - 0.05  // Случайное смещение по Z
            );

        }
        if (candyNumber > 50 && random.nextInt(3) == 0) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5;

            level.addParticle(
                    FaFParticlesRegistry.SCARY_BUBBLE.get(),
                    x, y, z,
                    random.nextFloat() * 0.1 - 0.05, // Случайное смещение по X
                    random.nextFloat() * 0.1 - 0.05, // Случайное смещение по Y
                    random.nextFloat() * 0.1 - 0.05  // Случайное смещение по Z
            );

        }
        if (candyNumber > 70 && random.nextInt(1) == 0) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5;

            level.addParticle(
                    FaFParticlesRegistry.SCARY_BUBBLE.get(),
                    x, y, z,
                    random.nextFloat() * 0.1 - 0.05, // Случайное смещение по X
                    random.nextFloat() * 0.1 - 0.05, // Случайное смещение по Y
                    random.nextFloat() * 0.1 - 0.05  // Случайное смещение по Z
            );

        }
    }




    private <T extends Mob> void spawnMob(Level level, BlockPos pos, int count, EntityType<T> type) {
        double x = pos.getX() + (level.random.nextDouble() - 0.5);
        double y = pos.getY() + 1;
        double z = pos.getZ() + (level.random.nextDouble() - 0.5);

        for (int i = 0; i < count; i++) {
            T entity = type.create(level);
            if (entity != null) {
                entity.setPos(x, y, z);
                level.addFreshEntity(entity);

                ((ServerLevel) level).sendParticles(FaFParticlesRegistry.SCARY_DUST.get(), x + 0.5, y + 0.5, z + 0.5, 10, 0.3, 0.3, 0.3, 0.1);
            }
        }
    }
}