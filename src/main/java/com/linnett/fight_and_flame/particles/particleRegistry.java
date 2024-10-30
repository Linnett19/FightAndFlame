package com.linnett.fight_and_flame.particles;

import com.google.common.base.Function;
import com.linnett.fight_and_flame.FightAndFlame;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class particleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, FightAndFlame.MOD_ID);
    public static final RegistryObject<SimpleParticleType> CANDY_SPLASH = PARTICLE_TYPES.register("candy_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SLIME_LOLIPOP_SPLASH = PARTICLE_TYPES.register("slime_lolipop_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SOUL_BONE_SPLASH = PARTICLE_TYPES.register("sour_bone_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> JELLY_BALLS_SPLASH = PARTICLE_TYPES.register("jelly_balls_splash", () -> new SimpleParticleType(true));
    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}