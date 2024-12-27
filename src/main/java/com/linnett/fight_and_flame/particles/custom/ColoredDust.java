package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;
import java.util.Random;

public class ColoredDust extends TextureSheetParticle {

    private float initialAlpha = 1.0F;
    private int colorTransitionStart = 10;
    private int colorTransitionEnd = 30;
    private int alphaTransitionStart = 50;
    private int alphaTransitionEnd = 60;
    private Random random = new Random();

    protected ColoredDust(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.setSize(0.5F, 0.5F);
        this.quadSize = 0.5F + world.random.nextFloat() * 0.2F;
        this.lifetime = 60;
        this.friction = 0.96F;
        this.setAlpha(initialAlpha);
        this.xd = 0.05F * random.nextGaussian();
        this.yd = 0.15F * random.nextFloat();
        this.zd = 0.05F * random.nextGaussian();

        this.setColor(1.0F, 1.0F, 1.0F);
    }

    private void setRandomColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        this.setColor(r, g, b);
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

        if (this.age >= colorTransitionStart && this.age <= colorTransitionEnd) {
            float progress = (float) (this.age - colorTransitionStart) / (colorTransitionEnd - colorTransitionStart);
            this.setColorLerp(progress);
        }

        if (this.age >= alphaTransitionStart && this.age <= alphaTransitionEnd) {
            float progress = (float) (this.age - alphaTransitionStart) / (alphaTransitionEnd - alphaTransitionStart);
            this.setAlpha(1F - progress);
        }
    }

    private void setColorLerp(float progress) {
        float r = 1.0F + progress * (random.nextFloat() - 1.0F);
        float g = 1.0F + progress * (random.nextFloat() - 1.0F);
        float b = 1.0F + progress * (random.nextFloat() - 1.0F);
        this.setColor(r, g, b);
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


