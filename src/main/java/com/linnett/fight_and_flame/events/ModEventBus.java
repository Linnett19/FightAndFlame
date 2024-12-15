package com.linnett.fight_and_flame.events;


import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.particles.custom.CloudSplash;
import com.linnett.fight_and_flame.particles.custom.SplashParticleTemplate;
import com.linnett.fight_and_flame.particles.ModParticlesRegistry;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FightAndFlame.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticlesRegistry.CANDY_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(ModParticlesRegistry.SLIME_LOLIPOP_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(ModParticlesRegistry.SOUL_BONE_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(ModParticlesRegistry.JELLY_BALLS_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(ModParticlesRegistry.CLOUD_SPLASH.get(), CloudSplash.Provider::new);
    }
}