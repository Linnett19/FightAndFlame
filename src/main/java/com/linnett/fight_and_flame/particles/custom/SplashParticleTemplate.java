package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SplashParticleTemplate extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final double initialYSpeed;

    protected SplashParticleTemplate(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.gravity = 1F;
        this.friction = 1F;
        this.xd = 0;
        this.zd = 0;
        this.initialYSpeed = Math.abs(pYSpeed) * 0.5;
        this.yd = initialYSpeed;
        this.sprites = spriteSet;
        this.quadSize *= 2f;
        this.lifetime = 20;

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
        this.roll = (float) Math.random() * ((float) Math.PI) / 4 - ((float) Math.PI * 0.125f);
        this.oRoll = this.roll;
        this.setSpriteFromAge(spriteSet);
        this.alpha = 0.6F;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);


        this.alpha = 0.6f - ((float) this.age / (float) this.lifetime) * 0.6f;


        if (this.age < this.lifetime / 2) {
            this.yd = initialYSpeed * (1 - (float) this.age / (this.lifetime / 2)); // Снижение скорости подъема
        } else {

            this.yd -= 0.05;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new SplashParticleTemplate(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
