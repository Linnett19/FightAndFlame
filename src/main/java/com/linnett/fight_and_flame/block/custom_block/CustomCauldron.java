package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.items.ModItems;
import com.linnett.fight_and_flame.particles.ModParticlesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class CustomCauldron extends AbstractCauldronBlock {

    public static final int LevelMax = 5;
    public static final int MaxCandy = 100;
    private int candyNumber = 0;

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final IntegerProperty CANDY_NUMBER = IntegerProperty.create("candy_number", 0, 100);
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, LevelMax);

    public CustomCauldron(BlockBehaviour.Properties properties) {
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
            itemStack.shrink(1);
            if (itemStack.getItem() == ModItems.CANDI_CORN.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(ModParticlesRegistry.CANDY_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                updateCauldronLevel(level, pos, state);
            }

            if (itemStack.getItem() == ModItems.SLIME_LOLIPOP.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(ModParticlesRegistry.SLIME_LOLIPOP_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                updateCauldronLevel(level, pos, state);
            }
            if (itemStack.getItem() == ModItems.SOUR_BONE.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(ModParticlesRegistry.SOUL_BONE_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                updateCauldronLevel(level, pos, state);
            }
            if (itemStack.getItem() == ModItems.JELLY_BALLS.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(ModParticlesRegistry.JELLY_BALLS_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, particleCount, xOffset, yOffset, zOffset, .1);
                updateCauldronLevel(level, pos, state);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }


    @Override
    public boolean isFull(BlockState blockState) {
        return false;
    }

    private boolean isCustomItem(Item item) {
        return item == ModItems.CANDI_CORN.get() || item == ModItems.SOUR_BONE.get() ||
                item == ModItems.SLIME_LOLIPOP.get() || item == ModItems.JELLY_BALLS.get();
    }

    private static void breakCauldron(ServerLevel level, BlockPos pos) {
        level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
        ((ServerLevel) level).sendParticles(ModParticlesRegistry.JELLY_BALLS_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        ((ServerLevel) level).sendParticles(ModParticlesRegistry.CANDY_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        ((ServerLevel) level).sendParticles(ModParticlesRegistry.SOUL_BONE_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        ((ServerLevel) level).sendParticles(ModParticlesRegistry.SLIME_LOLIPOP_SPLASH.get(), pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, 5, .3, .3, .3, .1);
        level.destroyBlock(pos, false);
    }


    private void updateCauldronLevel(Level level, BlockPos pos, BlockState state) {
        int candyNumber = state.getValue(CANDY_NUMBER);

        candyNumber += 1;

        if (candyNumber >= MaxCandy) {
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.BLANK_BLUEPRINT.get()));
            level.addFreshEntity(itemEntity);
            breakCauldron((ServerLevel) level, pos);
            return;
        }




        if (candyNumber == 20 ) {
            spawnMob(level, pos, 4, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 40 ) {
            spawnMob(level, pos, 5, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 60 ) {
            spawnMob(level, pos, 5, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 80 ) {
            spawnMob(level, pos, 6, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber == 100 ) {
            spawnMob(level, pos, 7, EntityType.SLIME);
            state = state.setValue(STAGE, state.getValue(STAGE) + 1);
        }

        if (candyNumber <= 100) {
            level.setBlock(pos, state.setValue(CANDY_NUMBER, candyNumber), 3);
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
            }
        }
    }
}