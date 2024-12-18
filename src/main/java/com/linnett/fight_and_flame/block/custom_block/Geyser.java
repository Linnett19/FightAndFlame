package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.particles.ModParticlesRegistry;
import com.linnett.fight_and_flame.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Geyser extends Block {

    public static final BooleanProperty ERUPTING = BooleanProperty.create("erupting");
    public static final BooleanProperty IGNITED = BooleanProperty.create("ignited");

    private static final VoxelShape SHAPE = Block.box(5, 0, 5, 11, 16, 11);

    public Geyser(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ERUPTING, false).setValue(IGNITED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity livingEntity) {
            if (state.getValue(ERUPTING)) {
                livingEntity.hurt(livingEntity.damageSources().cactus(), 3.0f);
                entity.setSecondsOnFire(3);
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ERUPTING, IGNITED);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        if (state.getValue(ERUPTING)) {
            // Генерация частиц лавы
            for (int i = 0; i < 10; i++) {
                double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
                double y = pos.getY() + 1.0 + random.nextDouble() * 0.5;
                double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
                level.addParticle(ParticleTypes.LAVA, x, y, z, 0, 0.1, 0);
            }

            if (!level.isClientSide) {
                double radius = 3.0;

                AABB area = new AABB(
                        pos.getX() - radius, pos.getY() - radius, pos.getZ() - radius,
                        pos.getX() + radius, pos.getY() + radius, pos.getZ() + radius
                );
                level.getEntitiesOfClass(LivingEntity.class, area, entity -> true).stream().filter(entity -> entity instanceof LivingEntity).forEach(livingEntity -> livingEntity.setSecondsOnFire(5));
            }
        }
    }










    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return InteractionResult.PASS;
        }

        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.is(ModItems.PYROCLASTITE.get())) {
            if (!state.getValue(IGNITED)) {
                level.setBlockAndUpdate(pos, state.setValue(ERUPTING, true).setValue(IGNITED, true));

                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }

                level.playSound(null, pos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
                serverLevel.sendParticles(ParticleTypes.LAVA, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, 10, 0.1, 0.1, 0.1, 0.1);

                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }

        if (state.getValue(IGNITED)) {
            if (itemStack.is(ModItems.HARMONITE.get()) || itemStack.is(Items.WATER_BUCKET)) {
                level.setBlockAndUpdate(pos, state.setValue(ERUPTING, false).setValue(IGNITED, false));

                if (!player.isCreative()) {
                    if (itemStack.is(Items.WATER_BUCKET)) {
                        player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                    } else {
                        itemStack.shrink(1);
                    }
                }

                serverLevel.sendParticles(ModParticlesRegistry.CLOUD_SPLASH.get(), pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, 10, 0.1, 0.1, 0.1, 0.1);
                level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }
}
