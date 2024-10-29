package com.linnett.fight_and_flame.entity.custom;

import com.linnett.fight_and_flame.entity.FightAndFlameEntityRegistry;
import com.linnett.fight_and_flame.items.ModItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class MusicTape extends ThrowableItemProjectile {
    private Vec3[] trailPositions = new Vec3[64];
    private Float[] trailRots = new Float[64];
    private int trailPointer = -1;
    protected static final EntityDataAccessor<Integer> DATA_VISUAL_TYPE;

    // Задержка перезарядки в тиках
    private static final int RELOAD_TICKS = 30; // 1.5 секунды = 30 тиков (1 тик = 1/20 секунды)
    private int reloadCounter = 0;

    public MusicTape(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public MusicTape(Level level) {
        super(FightAndFlameEntityRegistry.MUSIC_TAPE.get(), level);
    }

    public MusicTape(Level level, LivingEntity livingEntity) {
        super(FightAndFlameEntityRegistry.MUSIC_TAPE.get(), livingEntity, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.NOTE.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (reloadCounter > 0) {
            reloadCounter--;
        }
        Vec3 trailAt = this.position().add(0, this.getBbHeight() / 2, 0);
        if (trailPointer == -1) {
            Vec3 backAt = trailAt;
            for (int i = 0; i < trailPositions.length; i++) {
                trailPositions[i] = backAt;
                trailRots[i] = this.getXRot() / 360 * 3.14f;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = trailAt;
        this.trailRots[this.trailPointer] = this.getXRot() / 360 * 3.14f;
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        // Проверяем, не находится ли сущность на клиентской стороне
        if (!this.level().isClientSide) {
            // Наносим урон цели
            float damage = 1.0F + this.random.nextFloat() * 2.0F;
            entity.hurt(damageSources().thrown(this, this.getOwner()), damage);

            // Удаляем снаряд после нанесения урона
            this.discard();
        }
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

    public boolean isAttackable() {
        return false;
    }

    public void setVisualType(int p_31960_) {
        this.entityData.set(DATA_VISUAL_TYPE, p_31960_);
    }

    public int getVisualType() {
        return this.entityData.get(DATA_VISUAL_TYPE);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VISUAL_TYPE, 0);
    }

    static {
        DATA_VISUAL_TYPE = SynchedEntityData.defineId(MusicTape.class, EntityDataSerializers.INT);
    }


    public boolean canShoot() {
        return reloadCounter == 0;
    }


    public void startReload() {
        reloadCounter = RELOAD_TICKS;
    }
}

