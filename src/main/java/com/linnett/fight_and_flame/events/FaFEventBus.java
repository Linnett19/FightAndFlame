package com.linnett.fight_and_flame.events;


import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.particles.FaFParticlesRegistry;
import com.linnett.fight_and_flame.particles.custom.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = FightAndFlame.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FaFEventBus {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(FaFParticlesRegistry.CANDY_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.SLIME_LOLIPOP_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.SOUL_BONE_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.JELLY_BALLS_SPLASH.get(), SplashParticleTemplate.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.CLOUD_SPLASH.get(), CloudSplash.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.FIRE_SPARK.get(), FireSparkParticle.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.ASH_FLAKE.get(), AshFlake.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.SAND_PARTICLES.get(), SandParticles.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.COLORED_DUST.get(), ColoredDust.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.SCARY_DUST.get(), ScaryDust.Provider::new);
        event.registerSpriteSet(FaFParticlesRegistry.SCARY_BUBBLE.get(), BubbleParticle.Provider::new);

    }
}