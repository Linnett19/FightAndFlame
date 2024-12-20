package com.linnett.fight_and_flame.events;

import com.linnett.fight_and_flame.block.FaFBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class FaFClientEvents {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void fogRender(ViewportEvent.RenderFog event) {
        if (event.isCanceled()) {
            return;
        }

        Entity player = Minecraft.getInstance().getCameraEntity();
        BlockState blockState = player.level().getBlockState(event.getCamera().getBlockPosition());
        if (blockState.getBlock() == FaFBlocks.ASH.get()) {
            event.setCanceled(true);

            float farness = 1.8F;
            event.setFarPlaneDistance(farness);
            event.setNearPlaneDistance(0.56F);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void fogColor(ViewportEvent.ComputeFogColor event) {
        Entity player = Minecraft.getInstance().getCameraEntity();
        BlockState blockState = player.level().getBlockState(event.getCamera().getBlockPosition());
        if (blockState.getBlock() == FaFBlocks.ASH.get()) {
            event.setBlue(0.145f);
            event.setGreen(0.157f);
            event.setRed(0.188f);
        }
    }
}









