package com.linnett.fight_and_flame.events;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.entity.BlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

@Mod.EventBusSubscriber(modid = FightAndFlame.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void register(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntities.HORRIGBLE_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(BlockEntities.HORRIBLE_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

}
