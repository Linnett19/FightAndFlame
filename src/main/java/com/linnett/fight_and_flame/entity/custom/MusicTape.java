package com.linnett.fight_and_flame.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;


public class MUSIC_TAPE extends ThrowableItemProjectile {
    private Vec3[] trailPositions = new Vec3[64];
    private Float[] trailRots = new Float[64];
    private int trailPointer = -1;
    protected static final EntityDataAccessor<Integer> DATA_VISUAL_TYPE;
    public MUSIC_TAPE(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);

    }

    @Override
    protected Item getDefaultItem() {
        return Items.AMETHYST_SHARD;
    }
    public Vec3 getTrailPosition(int pointer, float partialTick) {
        if (this.isRemoved()) {
            partialTick = 1.0F;
        }
        int i = this.trailPointer - pointer & 63;
        int j = this.trailPointer - pointer - 1 & 63;
        Vec3 d0 = this.trailPositions[j];
        Vec3 d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.scale(partialTick));
    }

    public boolean hasTrail() {

        return trailPointer != -1;
    }

    @Override
    protected void onHitBlock(BlockHitResult p_37258_) {
        super.onHitBlock(p_37258_);
        if(tickCount>3 && level() instanceof ServerLevel serverLevel)
        {
            for(int i = 0; i < 10; i++) {
            }
            this.discard();
        }

    }
    public boolean isAttackable() {
        return false;
    }

    public void setVisualType(int p_31960_) {
        this.entityData.set(DATA_VISUAL_TYPE, p_31960_);
    }

    public int getVisualType() {
        return (int)this.entityData.get(DATA_VISUAL_TYPE);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VISUAL_TYPE, 0);
    }

    @Override
    public void tick() {
        super.tick();

        Vec3 trailAt = this.position().add(0, this.getBbHeight()/2, 0);
        if (trailPointer == -1) {
            Vec3 backAt = trailAt;
            for (int i = 0; i < trailPositions.length; i++) {
                trailPositions[i] = backAt;
                trailRots[i] = this.getXRot()/360*3.14f;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = trailAt;
        this.trailRots[this.trailPointer] = this.getXRot()/360*3.14f;
    }
    static {
        DATA_VISUAL_TYPE = SynchedEntityData.defineId(MUSIC_TAPE.class, EntityDataSerializers.INT);
    }
}
