package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class LeafParticle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private float rotationSpeed;
    private final float spinAcceleration;
    private final float particleRandom;
    private final float friction;
    private boolean hasLanded = false;

    protected LeafParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites) {
        super(level, x, y, z);

        this.sprites = sprites;
        this.rotationSpeed = (float) Math.toRadians(random.nextBoolean() ? -30 : 30);
        this.spinAcceleration = (float) Math.toRadians(random.nextBoolean() ? -5 : 5);
        this.particleRandom = random.nextFloat();
        this.friction = 0.98F;

        this.lifetime = 300;
        this.gravity = 0.00075F;
        float size = random.nextBoolean() ? 0.075F : 0.095F;
        this.quadSize = size;

        this.setSize(size, size);
        this.setSpriteFromAge(sprites);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.lifetime-- <= 0) {
            this.remove();
            return;
        }

        double timeFactor = (300 - this.lifetime) / 300.0;
        double d0 = Math.cos(Math.toRadians(this.particleRandom * 60.0)) * 2.0 * Math.pow(timeFactor, 1.25);
        double d1 = Math.sin(Math.toRadians(this.particleRandom * 60.0)) * 2.0 * Math.pow(timeFactor, 1.25);

        if (!hasLanded) {
            this.xd += d0 * 0.0025;
            this.zd += d1 * 0.0025;
            this.yd -= gravity;
        }

        this.rotationSpeed += this.spinAcceleration / 20.0F;
        this.oRoll = this.roll;
        this.roll += this.rotationSpeed / 20.0F;

        this.move(this.xd, this.yd, this.zd);

        if (this.onGround && !hasLanded) {
            hasLanded = true;
            this.xd = 0;
            this.zd = 0;
            this.yd = 0;
        }

        if (hasLanded) {
            this.alpha = Math.max(0, this.alpha - 0.02f);
        } else {
            this.xd *= friction;
            this.yd *= friction;
            this.zd *= friction;
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new LeafParticle(level, x, y, z, sprites);
        }
    }
}








