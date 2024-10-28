package com.linnett.fight_and_flame.render;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.entity.custom.MusicTape;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;
@OnlyIn(Dist.CLIENT)
public class MusicTapeRender extends ThrownItemRenderer<MusicTape> {
    private static final ResourceLocation TRAIL_TEXTURE = new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/music_tape.png");
    private static final float[][] COLORS = new float[][]{{0.08f,0.05f,0.01f},{0.04f,0.01f,0.08f},{0.01f,0.07f,0.06f},{0.01f,0.04f,0.06f}};
    private ItemRenderer itemRenderer;
    public MusicTapeRender(EntityRendererProvider.Context context) {
        super(context, 1, false);
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(MusicTape pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.hasTrail()) {
            double x = Mth.lerp(pPartialTicks, pEntity.xOld, pEntity.getX());
            double y = Mth.lerp(pPartialTicks, pEntity.yOld, pEntity.getY());
            double z = Mth.lerp(pPartialTicks, pEntity.zOld, pEntity.getZ());
            pMatrixStack.pushPose();
            pMatrixStack.translate(-x, -y, -z);
            renderTrail(pEntity, pPartialTicks, pMatrixStack, pBuffer, 1F,3F,1F, 1F, 400);
            pMatrixStack.popPose();
        }
        if (pEntity.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(pEntity) < 12.25D)) {
            pMatrixStack.pushPose();
            pMatrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            this.itemRenderer.renderStatic(pEntity.getItem(), ItemDisplayContext.GROUND, pPackedLight, OverlayTexture.NO_OVERLAY, pMatrixStack, pBuffer, pEntity.level(), pEntity.getId());
            pMatrixStack.popPose();
        }
    }
    private void renderTrail(MusicTape entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
        Quaternionf rotation = Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation();
        int sampleSize = 16;
        float trailHeight = 0.5F;
        int type = entityIn.getVisualType();
        float minusR = COLORS[type][0];
        float minusG= COLORS[type][2];
        float minusB= COLORS[type][0];
        float offset = 0;
        float oldoffset = 0;
        Vec3 drawFrom = entityIn.getTrailPosition(0, partialTicks);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RenderType.entityTranslucentEmissive(TRAIL_TEXTURE));
        for(int samples = 0; samples < sampleSize; samples++) {
            Vec3 sample = entityIn.getTrailPosition(samples + 2, partialTicks);
            float u1 = samples / (float) sampleSize;
            float u2 = u1 + 1 / (float) sampleSize;
            offset = entityIn.tickCount+partialTicks+samples;
            Vec3 topAngleVec = new Vec3(new Vector3f( 0, (float) (trailHeight-0.1f+Math.sin(offset)/6f), 1).rotate(rotation));
            Vec3 bottomAngleVec = new Vec3(new Vector3f(0, (float) (-trailHeight-0.1f+Math.sin(offset)/6f), 1).rotate(rotation));
            Vec3 oldTopAngleVec = new Vec3(new Vector3f( 0, (float) (trailHeight-0.1f+Math.sin(oldoffset)/6f), 1).rotate(rotation));
            Vec3 oldBottomAngleVec = new Vec3(new Vector3f(0, (float) (-trailHeight-0.1f+Math.sin(oldoffset)/6f), 1).rotate(rotation));
            Vec3 draw1 = drawFrom;
            Vec3 draw2 = sample;

            PoseStack.Pose posestack$pose = poseStack.last();
            Matrix4f matrix4f = posestack$pose.pose();
            Matrix3f matrix3f = posestack$pose.normal();
            vertexconsumer.vertex(matrix4f, (float) draw1.x + (float) oldBottomAngleVec.x, (float) draw1.y + (float) oldBottomAngleVec.y, (float) draw1.z + (float) oldBottomAngleVec.z).color(trailR, trailG, trailB, trailA).uv(u1, 1F).overlayCoords(NO_OVERLAY).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
            vertexconsumer.vertex(matrix4f, (float) draw2.x + (float) bottomAngleVec.x, (float) draw2.y + (float) bottomAngleVec.y, (float) draw2.z + (float) bottomAngleVec.z).color(trailR-minusR, trailG-minusG, trailB-minusB, trailA-0.05f).uv(u2, 1F).overlayCoords(NO_OVERLAY).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
            vertexconsumer.vertex(matrix4f, (float) draw2.x + (float) topAngleVec.x, (float) draw2.y + (float) topAngleVec.y, (float) draw2.z + (float) topAngleVec.z).color(trailR-minusR, trailG-minusG, trailB-minusB, trailA-0.05f).uv(u2, 0).overlayCoords(NO_OVERLAY).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
            vertexconsumer.vertex(matrix4f, (float) draw1.x + (float) oldTopAngleVec.x, (float) draw1.y + (float) oldTopAngleVec.y, (float) draw1.z + (float) oldTopAngleVec.z).color(trailR, trailG, trailB, trailA).uv(u1, 0).overlayCoords(NO_OVERLAY).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
            trailR-=minusR;
            trailG-=minusG;
            trailB-=minusB;
            trailA-=0.05f;
            drawFrom = sample;
            oldoffset = offset;
        }
    }
}