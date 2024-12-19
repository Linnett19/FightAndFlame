package com.linnett.fight_and_flame.events;

import com.linnett.fight_and_flame.items.custom_items.Broadsword;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack activeItem = player.getUseItem();

            if (activeItem.getItem() instanceof Broadsword && player.isUsingItem()) {
                event.setAmount(event.getAmount() * 0F);
            }
        }
    }
}

