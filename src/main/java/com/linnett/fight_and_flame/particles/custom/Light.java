package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Light extends TextureSheetParticle {

    private static final float MAX_SIZE = 3.0f;
    private static final float GROWTH_RATE = 0.05f;
    private float size = 2.0f;
    private float initialAlpha = 0.0f;
    private final SpriteSet spriteSet;

    private int alphaTransitionStart = 5;
    private int alphaTransitionPeak = 15;
    private int alphaTransitionEnd = 20;

    Light(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z);
        this.setSize(1.0f, 1.0f);
        this.quadSize = size;
        this.lifetime = 25;  // Время жизни частицы
        this.hasPhysics = false;
        this.alpha = initialAlpha;

        this.spriteSet = spriteSet;

        this.rCol = 1.0f;
        this.gCol = 0.92f;
        this.bCol = 0.99f;

        this.pickSprite(spriteSet);
    }

    @Override
    public void tick() {
        if (this.age++ >= this.lifetime) {
            this.remove();
            return;
        }

        if (size < MAX_SIZE) {
            size += GROWTH_RATE;
        }

        if (this.age <= alphaTransitionStart) {
            this.alpha = 0.0f;
        } else if (this.age <= alphaTransitionPeak) {
            this.alpha = (float) (this.age - alphaTransitionStart) / (alphaTransitionPeak - alphaTransitionStart);
        } else if (this.age <= alphaTransitionEnd) {
            this.alpha = 1.0f - (float) (this.age - alphaTransitionPeak) / (alphaTransitionEnd - alphaTransitionPeak);
        } else {
            this.alpha = 0.0f;
        }

        this.setSpriteFromAge(this.spriteSet);

        this.quadSize = size;
        this.setAlpha(this.alpha);
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
            return new Light(clientLevel, x, y, z, spriteSet);
        }
    }
}




