package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AshFlake extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected AshFlake(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.gravity = 0.1F;
        this.friction = 0.98F;

        this.xd = pXSpeed + (random.nextDouble() * 0.02 - 0.01);
        this.yd = pYSpeed + 0.05;
        this.zd = pZSpeed + (random.nextDouble() * 0.02 - 0.01);

        this.sprites = spriteSet;
        this.quadSize = 0.4f;

        this.lifetime = 60;

        float lifeRatio = (float) this.age / (float) this.lifetime;
        this.rCol = 1f - lifeRatio;
        this.gCol = 1f - lifeRatio;
        this.bCol = 1f - lifeRatio;

        this.quadSize *= 1.1F + random.nextFloat() * 0.02F;

        this.roll = (float) Math.random() * ((float) Math.PI) / 2 - ((float) Math.PI * 0.25f);
        this.oRoll = this.roll;

        this.setSpriteFromAge(spriteSet);

        this.alpha = 0.8F - (lifeRatio * 0.8F);
    }

    @Override
    public void tick() {
        super.tick();
        float lifeRatio = (float) this.age / (float) this.lifetime;
        this.alpha = 0.8F - (lifeRatio * 0.8F);
        this.setSpriteFromAge(this.sprites);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new AshFlake(level, x, y, z, this.sprites, dx, 0.05, dz);
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}





