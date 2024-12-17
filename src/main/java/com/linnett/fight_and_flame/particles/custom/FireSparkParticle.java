package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FireSparkParticle extends TextureSheetParticle {

    FireSparkParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
        this.quadSize = 1f + random.nextFloat() * 0.5f;
        this.setSize(1f, 0.5f);
        this.lifetime = 130;
        this.hasPhysics = false;


        float rand = random.nextFloat();

        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 1.0f;


    }

    @Override
    public void tick() {
        if (this.age++ >= this.lifetime || this.alpha <= 0.0f) {
            this.remove();
            return;
        }

        // Плавное изменение прозрачности
        if (this.age <= this.lifetime / 2 && this.alpha < 1.0f) {
            this.alpha += 0.015f;
        }

        if (this.age >= this.lifetime / 2 && this.alpha > 0.01f) {
            this.alpha -= 0.015f;
        }
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double x, double y, double z, double dx, double dy, double dz) {
            FireSparkParticle fireSparkParticle = new FireSparkParticle(clientLevel, x, y, z);
            fireSparkParticle.pickSprite(this.spriteSet);
            fireSparkParticle.setAlpha(0.01f);
            return fireSparkParticle;
        }
    }
}



