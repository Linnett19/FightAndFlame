package com.linnett.fight_and_flame.items.custom_items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import static com.linnett.fight_and_flame.items.FaFItems.BOTTLE;
import static com.linnett.fight_and_flame.items.FaFItems.DISTORTED_GLASS;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;



public class BurstInfusion extends PotionItem {

    public BurstInfusion(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {
            level.explode(entity, entity.getX(), entity.getY(), entity.getZ(), 2.0F, Level.ExplosionInteraction.NONE);

            entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1200, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1200, 0));
        }

        if (!(entity instanceof net.minecraft.world.entity.player.Player player) || !player.getAbilities().instabuild) {
            return new ItemStack(DISTORTED_GLASS.get());
        }

        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("effect.minecraft.health_boost")
                .append(" (1:00)").withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.translatable("effect.minecraft.nausea")
                .append(" (1:00)").withStyle(ChatFormatting.RED));
        tooltip.add(Component.translatable("effect.minecraft.explosion")
                .append(" (instantly)").withStyle(ChatFormatting.DARK_PURPLE));
    }
}


