package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

public class ColoredDust extends TextureSheetParticle {

    private float initialAlpha = 0.5F;

    protected ColoredDust(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.setSize(0.5F, 0.5F);
        this.quadSize = 0.5F + world.random.nextFloat() * 0.2F;
        this.lifetime = 10 + world.random.nextInt(4);
        this.friction = 0.96F;
        this.setColor((float) xSpeed, (float) ySpeed, (float) zSpeed);
        this.initialAlpha = 0.0F;
        this.setAlpha(initialAlpha);
        this.xd = 0.05F * random.nextGaussian();
        this.yd = 0.15F * random.nextFloat();
        this.zd = 0.05F * random.nextGaussian();
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.xd *= (double) this.friction;
            this.yd *= (double) this.friction;
            this.zd *= (double) this.friction;
        }
        float f = (float)this.age / this.lifetime;
        this.setAlpha(1F - f);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public float getQuadSize(float scaleFactor) {
        return super.getQuadSize(scaleFactor);
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double x, double y, double z, double dx, double dy, double dz) {
            ColoredDust particle = new ColoredDust(clientLevel, x, y, z, dx, dy, dz);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}

