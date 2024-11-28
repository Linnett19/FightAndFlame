package com.linnett.fight_and_flame.client;

import com.linnett.fight_and_flame.items.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "fight_and_flame", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModItemProperties {

    @SubscribeEvent
    public static void registerItemProperties(FMLClientSetupEvent event) {

        ItemProperties.register(ModItems.IRON_BROADSWORD.get(),
                new ResourceLocation("custom_model_data"),
                (stack, level, entity, seed) -> {

                    return stack.hasTag() && stack.getTag().contains("CustomModelData")

                            ? stack.getTag().getInt("CustomModelData")
                            : 0;
                });
    }
}

