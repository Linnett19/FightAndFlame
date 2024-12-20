package com.linnett.fight_and_flame.particles.custom;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.Random;
import java.util.function.Consumer;

public class MagicSonar extends TextureSheetParticle {

    private float xRot;
    private float yRot;

    protected MagicSonar(ClientLevel world, double x, double y, double z, float xRot, float yRot, double speedX, double speedY, double speedZ) {
        super(world, x, y, z, speedX, speedY, speedZ);
        this.quadSize = 0.5F;
        this.setSize(1.0F, 1.0F);
        this.setRandomColor();
        this.lifetime = 40;
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.friction = 0F;
        this.xRot = xRot;
        this.yRot = yRot;
        this.hasPhysics = false;
    }

    private void setRandomColor() {
        Random random = new Random();
        this.rCol = random.nextFloat();
        this.gCol = random.nextFloat();
        this.bCol = random.nextFloat();
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        float f1 = this.age / (float) this.lifetime;
        float f2 = 1F - 0.1F * f1;
        this.friction = 1F - 0.65F * f1;

        // Управляем прозрачностью
        float alphaFactor = 1.0F;
        if (this.age < this.lifetime / 2) {
            alphaFactor = (float) this.age / (this.lifetime / 2);  // Плавное увеличение видимости
        } else {
            alphaFactor = 1.0F - ((float) (this.age - this.lifetime / 2) / (this.lifetime / 2));  // Плавное исчезновение
        }
        this.alpha = alphaFactor;

        Vec3 motionVec = new Vec3(this.xd, this.yd, this.zd);

        this.xRot = 90F;
        this.yRot = 0F;

        this.xd *= f2;
        this.yd *= f2;
        this.zd *= f2;

        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.xd *= this.friction;
            this.yd *= this.friction;
            this.zd *= this.friction;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }

    public float getQuadSize(float scaleFactor) {
        float f = 2.0F;
        return this.quadSize * Mth.clamp(((float) this.age + scaleFactor) * 2.0F / (float) this.lifetime, 0.0F, 1.0F) * f;
    }

    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        this.renderSignal(vertexConsumer, camera, partialTick, (quaternionf) -> {
            quaternionf.rotateY(-(float) Math.toRadians(yRot)).rotateX(-(float) Math.toRadians(xRot));
        });
        this.renderSignal(vertexConsumer, camera, partialTick, (quaternionf) -> {
            quaternionf.rotateY(-(float) Math.PI - (float) Math.toRadians(yRot)).rotateX((float) Math.toRadians(xRot));
        });
    }

    private void renderSignal(VertexConsumer consumer, Camera camera, float partialTicks, Consumer<Quaternionf> rots) {
        Vec3 vec3 = camera.getPosition();
        float f = (float) (Mth.lerp(partialTicks, this.xo, this.x) - vec3.x());
        float f1 = (float) (Mth.lerp(partialTicks, this.yo, this.y) - vec3.y());
        float f2 = (float) (Mth.lerp(partialTicks, this.zo, this.z) - vec3.z());
        Vector3f vector3f = (new Vector3f(0.5F, 0.5F, 0.5F)).normalize();
        Quaternionf quaternionf = (new Quaternionf()).setAngleAxis(0.0F, vector3f.x(), vector3f.y(), vector3f.z());
        rots.accept(quaternionf);

        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f3 = this.getQuadSize(partialTicks);

        for (int i = 0; i < 4; ++i) {
            Vector3f vector3f1 = avector3f[i];
            vector3f1.rotate(quaternionf);
            vector3f1.mul(f3);
            vector3f1.add(f, f1, f2);
        }

        float f6 = this.getU0();
        float f7 = this.getU1();
        float f4 = this.getV0();
        float f5 = this.getV1();
        int j = this.getLightColor(partialTicks);

        consumer.vertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).uv(f7, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        consumer.vertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).uv(f7, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        consumer.vertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).uv(f6, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        consumer.vertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).uv(f6, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            double deviation = 0;
            MagicSonar particle = new MagicSonar(worldIn, x, y, z, 0.0F, 0.0F, xSpeed + (Math.random() - 0.5) * deviation, ySpeed, zSpeed + (Math.random() - 0.5) * deviation);
            particle.pickSprite(spriteSet);
            return particle;
        }
    }
}











