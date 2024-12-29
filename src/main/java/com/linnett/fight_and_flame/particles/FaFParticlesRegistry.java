package com.linnett.fight_and_flame.particles;

import com.linnett.fight_and_flame.FightAndFlame;
import com.mojang.serialization.Codec;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class FaFParticlesRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, FightAndFlame.MOD_ID);
    public static final RegistryObject<SimpleParticleType> CANDY_SPLASH = PARTICLE_TYPES.register("candy_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SLIME_LOLIPOP_SPLASH = PARTICLE_TYPES.register("slime_lolipop_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SOUL_BONE_SPLASH = PARTICLE_TYPES.register("sour_bone_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> JELLY_BALLS_SPLASH = PARTICLE_TYPES.register("jelly_balls_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> CLOUD_SPLASH = PARTICLE_TYPES.register("cloud_splash", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> FIRE_SPARK  = PARTICLE_TYPES.register("fire_spark", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ASH_FLAKE  = PARTICLE_TYPES.register("ash_flake", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> COLORED_DUST  = PARTICLE_TYPES.register("colored_dust", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SCARY_DUST  = PARTICLE_TYPES.register("scary_dust", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SCARY_BUBBLE  = PARTICLE_TYPES.register("scary_bubble", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SCARY_SONAR  = PARTICLE_TYPES.register("scary_sonar", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> PURPLE_MAGIC  = PARTICLE_TYPES.register("purple_magic", () -> new SimpleParticleType(true));




    public static final RegistryObject<ParticleType<BlockParticleOption>> SAND_PARTICLES = PARTICLE_TYPES.register("sand_particles", () -> new ParticleType<BlockParticleOption>(true, BlockParticleOption.DESERIALIZER) {
        @Override
        public Codec<BlockParticleOption> codec() {
            Function<ParticleType<BlockParticleOption>, Codec<BlockParticleOption>> codec = BlockParticleOption::codec;
            return (Codec)codec.apply(this);
        }
    });



    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}