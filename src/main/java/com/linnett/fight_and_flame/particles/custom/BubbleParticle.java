package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class BubbleParticle extends TextureSheetParticle {

    private final float initialQuadSize;

    public BubbleParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites) {
        super(world, x, y, z);
        this.pickSprite(sprites);
        this.gravity = -0.15F - random.nextFloat() * 0.02F;
        this.lifetime = 40 + random.nextInt(20);
        this.quadSize = 0.15F + random.nextFloat() * 0.1F;
        this.initialQuadSize = this.quadSize;
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
    }

    @Override
    public void tick() {
        super.tick();

        float lifeProgress = (float) this.age / this.lifetime;

        this.alpha = 1.0F - lifeProgress;

        float pulseFactor = (float) (0.75F + 0.25F * Math.sin(Math.PI * 2 * this.age / 20.0));
        this.quadSize = this.initialQuadSize * pulseFactor;
    }



    private float easeOutCubic(float x) {
        return 1 - (float) Math.pow(1 - x, 3);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new BubbleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
        }
    }
}


