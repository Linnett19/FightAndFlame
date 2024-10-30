package com.linnett.fight_and_flame.events;


import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.particles.custom.SplashParticleTemplate;
import com.linnett.fight_and_flame.particles.particleRegistry;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FightAndFlame.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(particleRegistry.CANDY_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(particleRegistry.SLIME_LOLIPOP_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(particleRegistry.SOUL_BONE_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(particleRegistry.JELLY_BALLS_SPLASH.get(), SplashParticleTemplate.Provider::new);

    }
}