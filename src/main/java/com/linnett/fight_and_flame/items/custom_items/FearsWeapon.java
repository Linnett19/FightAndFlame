package com.linnett.fight_and_flame.items.custom_items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;

public class FearsWeapon extends SwordItem {

    public FearsWeapon(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (attacker instanceof Player player) {
            if (player.getFoodData().getFoodLevel() < 20) {
                player.getFoodData().eat(2, 0.3F); // Восстанавливает 2 единицы голода.
            } else if (player.getHealth() < player.getMaxHealth()) {
                player.heal(1.0F);
            } else {
                stack.hurtAndBreak(4, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
            }
        }

        return result;
    }
}
