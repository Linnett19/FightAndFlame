package com.linnett.fight_and_flame.block.custom_block;

import com.linnett.fight_and_flame.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;


public class CustomCauldron extends AbstractCauldronBlock {


    public CustomCauldron(BlockBehaviour.Properties properties) {
        super(properties, CauldronInteraction.EMPTY);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.PASS;
        }


        ItemStack itemStack = player.getItemInHand(hand);
        if (isCustomItem(itemStack.getItem())) {
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
        boolean isCustom = item == ModItems.CANDICORN.get() || item == ModItems.SOUR_BONE.get() ||
                item == ModItems.SLIME_LOLIPOP.get() || item == ModItems.JELLY_BALLS.get();
        return isCustom;
    }
}
