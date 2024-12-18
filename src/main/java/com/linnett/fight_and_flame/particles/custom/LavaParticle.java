package com.linnett.fight_and_flame.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

public class LavaParticle extends TextureSheetParticle {
    private static final Vector3f ROTATION_VECTOR = (new Vector3f(0.5F, 0.5F, 0.5F)).normalize();
    private static final Vector3f TRANSFORM_VECTOR = new Vector3f(-1.0F, -1.0F, 0.0F);
    private static final float MAGICAL_X_ROT = 1.0472F;
    private final SpriteSet sprite;

    LavaParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double pXs, double pYs, double pZs) {
        super(pLevel, pX, pY, pZ, 0.0, 0.0, 0.0);
        this.quadSize = 0.2F;
        this.friction = 0.96f;
        this.lifetime = 14;
        this.gravity = 0.4F;
        this.sprite = spriteSet;
        this.xd = pXs;
        this.yd = pYs;
        this.zd = pZs;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        this.setSpriteFromAge(this.sprite);
        super.tick();
        this.oRoll = this.roll;
        this.roll += (float) this.age/this.lifetime*3.14f/10;
        this.quadSize= 0.5f+(float) (Math.sin(this.age/3f)/5f);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprite) {
            this.sprite = pSprite;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            LavaParticle $$8 = new LavaParticle(pLevel,pX,pY,pZ,this.sprite,pXSpeed,pYSpeed,pZSpeed);
            $$8.setSpriteFromAge(this.sprite);
            $$8.setAlpha(1.0F);
            return $$8;
        }
    }
}
