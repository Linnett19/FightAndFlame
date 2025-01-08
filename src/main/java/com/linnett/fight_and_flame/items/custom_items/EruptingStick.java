package com.linnett.fight_and_flame.items.custom_items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EruptingStick extends Item {
    private static final Random RANDOM = new Random();
    private static final int PARTICLE_INTERVAL = 10;
    private int particleCooldown = 0;

    private static final List<MobEffect> RANDOM_EFFECTS = Arrays.asList(
            MobEffects.FIRE_RESISTANCE
    );

    public EruptingStick(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity target) {
            applyRandomEffect(target);
            spawnCustomParticlesAroundEntity(player.level(), target);
        }
        return false;
    }

    private void applyRandomEffect(LivingEntity target) {
        MobEffect randomEffect = RANDOM_EFFECTS.get(RANDOM.nextInt(RANDOM_EFFECTS.size()));
        int duration = RANDOM.nextInt(100) + 100;
        int amplifier = RANDOM.nextInt(2);

        target.setSecondsOnFire(5);
    }

    private void spawnCustomParticlesAroundEntity(Level level, LivingEntity entity) {
        if (!level.isClientSide) return;

        Vec3 entityPos = entity.position();
        double radius = 0.5;

        for (int i = 0; i < 10; i++) {
            double angle = RANDOM.nextDouble() * 2 * Math.PI;
            double offsetX = radius * Math.cos(angle);
            double offsetZ = radius * Math.sin(angle);
            double offsetY = RANDOM.nextDouble() * entity.getBbHeight();

            level.addParticle(ParticleTypes.LAVA,
                    entityPos.x + offsetX,
                    entityPos.y + offsetY,
                    entityPos.z + offsetZ,
                    0.0, 0.0, 0.0);
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            player.startUsingItem(hand);
        }

        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean isSelected) {
        if (level.isClientSide && entity instanceof Player player && player.isUsingItem() && isSelected) {
            if (particleCooldown <= 0) {
                createParticles(level, player);
                particleCooldown = PARTICLE_INTERVAL;
            } else {
                particleCooldown--;
            }
        }
    }

    public void createParticles(Level level, Player player) {
        Vec3 lookVec = player.getLookAngle();

        double particleX = player.getX() + lookVec.x * 2.0;
        double particleY = player.getY() + player.getEyeHeight() + lookVec.y * 2.0;
        double particleZ = player.getZ() + lookVec.z * 2.0;

        for (int i = 0; i < 3; i++) {
            double offsetX = RANDOM.nextDouble() * 0.6 - 0.3;
            double offsetY = RANDOM.nextDouble() * 0.6 - 0.3;
            double offsetZ = RANDOM.nextDouble() * 0.6 - 0.3;

            double speedX = lookVec.x * 0.3 + offsetX;
            double speedY = lookVec.y * 0.3 + offsetY;
            double speedZ = lookVec.z * 0.3 + offsetZ;

            level.addParticle(ParticleTypes.LAVA,
                    particleX, particleY, particleZ,
                    speedX, speedY, speedZ);
        }

        level.playSound(player, player.getX(), player.getY(), player.getZ(),
                SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 100F, 1.0F + RANDOM.nextFloat() * 0.5F);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("effect.fight_and_flame.fire")
                .append(" 0:05").withStyle(ChatFormatting.RED));
        tooltip.add(Component.translatable("effect.fight_and_flame.fire_magic")
                .append("").withStyle(ChatFormatting.DARK_PURPLE));
    }
}





