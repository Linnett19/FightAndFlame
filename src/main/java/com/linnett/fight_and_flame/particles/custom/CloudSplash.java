package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CloudSplash extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected CloudSplash(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.gravity = 0F;
        this.friction = 0.98F;

        this.xd = pXSpeed + (random.nextDouble() * 0.05 - 0.025);
        this.yd = pYSpeed + 0.02;
        this.zd = pZSpeed + (random.nextDouble() * 0.05 - 0.025);

        this.sprites = spriteSet;
        this.quadSize = 0.5f;
        this.lifetime = 60;

        float lifeRatio = (float) this.age / (float) this.lifetime;
        this.rCol = 1f - lifeRatio;
        this.gCol = 1f - lifeRatio;
        this.bCol = 1f - lifeRatio;


        this.quadSize *= 1.02F + random.nextFloat() * 0.02F;


        this.roll = (float) Math.random() * ((float) Math.PI) / 2 - ((float) Math.PI * 0.25f);
        this.oRoll = this.roll;


        this.setSpriteFromAge(spriteSet);


        this.alpha = 0.8F - (lifeRatio * 0.7F);


        if (random.nextInt(10) == 0) {
            this.xd += random.nextDouble() * 0.01 - 0.005;
            this.zd += random.nextDouble() * 0.01 - 0.005;
        }
    }


    @Override
    public void tick() {
        super.tick();


        this.alpha = 0.6f - ((float) this.age / (float) this.lifetime) * 0.6f;

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
            return new CloudSplash(level, x, y, z, this.sprites, dx, 0.1, dz);
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
