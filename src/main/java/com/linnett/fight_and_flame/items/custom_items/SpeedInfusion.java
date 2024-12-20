package com.linnett.fight_and_flame.items.custom_items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.linnett.fight_and_flame.items.FaFItems.TRIANGULAR_GLASS;

public class SpeedInfusion extends PotionItem {

    public SpeedInfusion(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {

            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1200, 0));
        }

        if (!(entity instanceof net.minecraft.world.entity.player.Player player) || !player.getAbilities().instabuild) {
            return new ItemStack(TRIANGULAR_GLASS.get());
        }

        return super.finishUsingItem(stack, level, entity);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("effect.minecraft.speed")
                .append(" (1:00)").withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.translatable("effect.minecraft.nausea")
                .append(" (1:00)").withStyle(ChatFormatting.RED));
    }
}
