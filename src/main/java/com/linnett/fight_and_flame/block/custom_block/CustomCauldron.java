package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.items.Moditems;
import com.linnett.fight_and_flame.particles.particleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CustomCauldron extends AbstractCauldronBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 5);

    public CustomCauldron(BlockBehaviour.Properties properties) {
        super(properties, CauldronInteraction.EMPTY);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LEVEL, 0));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(LEVEL);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.PASS;
        }

        ItemStack itemStack = player.getItemInHand(hand);
        int particleCount = 3;
        if (isCustomItem(itemStack.getItem())) {
            itemStack.shrink(1);
            if (itemStack.getItem() == Moditems.CANDICORN.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(particleRegistry.CANDY_SPLASH.get(), pos.getX() + .5,pos.getY() + 1.5, pos.getZ() + .5,particleCount,.3,.3,.3,.1);
            }
            if (itemStack.getItem() == Moditems.SLIME_LOLIPOP.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(particleRegistry.SLIME_LOLIPOP_SPLASH.get(), pos.getX() + .5,pos.getY() + 1.5, pos.getZ() + .5,particleCount,.3,.3,.3,.1);
            }
            if (itemStack.getItem() == Moditems.SOUR_BONE.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(particleRegistry.SOUL_BONE_SPLASH.get(), pos.getX() + .5,pos.getY() + 1.5, pos.getZ() + .5,particleCount,.3,.3,.3,.1);
            }
            if (itemStack.getItem() == Moditems.JELLY_BALLS.get()) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                ((ServerLevel) level).sendParticles(particleRegistry.JELLY_BALLS_SPLASH.get(), pos.getX() + .5,pos.getY() + 1.5, pos.getZ() + .5,particleCount,.3,.3,.3,.1);
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
        return item == Moditems.CANDICORN.get() || item == Moditems.SOUR_BONE.get() ||
                item == Moditems.SLIME_LOLIPOP.get() || item == Moditems.JELLY_BALLS.get();
    }
}
