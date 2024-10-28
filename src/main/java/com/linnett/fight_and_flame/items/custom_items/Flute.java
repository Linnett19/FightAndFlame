package com.linnett.fight_and_flame.items.custom_items;

import com.linnett.fight_and_flame.entity.custom.MusicTape;
import com.linnett.fight_and_flame.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;

public class Flute extends Item {

    public Flute(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity player, int p_41415_) {
        if (!level.isClientSide) {
            MusicTape musicTape = new MusicTape(level, player);
            musicTape.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(musicTape);
        }
        level.playSound((Player) player, new BlockPos((int) player.getX(), (int) player.getY(), (int) player.getZ()), ModSounds.FLUTE_SOUND.get(), SoundSource.PLAYERS);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }
}

