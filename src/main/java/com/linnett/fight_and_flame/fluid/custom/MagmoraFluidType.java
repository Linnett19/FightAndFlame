package com.linnett.fight_and_flame.fluid.custom;

import com.linnett.fight_and_flame.sounds.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class MagmoraFluidType extends FluidType {

    private static final ResourceLocation STILL = new ResourceLocation("fight_and_flame:block/magmora_still");
    private static final ResourceLocation FLOWING = new ResourceLocation("fight_and_flame:block/magmora_flow");
    private static final ResourceLocation OVERLAY = new ResourceLocation("fight_and_flame:textures/block/magmora_overlay.png");

    public MagmoraFluidType(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING;
            }

            @Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return OVERLAY;
            }
        });
    }

    @Override
    public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity) {
        return false;
    }

    @Override
    public void onVaporize(@Nullable Player player, Level level, BlockPos pos, FluidStack stack) {
        level.playSound(player, pos, ModSounds.MAGMORA_FIRE.get(), SoundSource.BLOCKS, 1.0f, 1.0f);

        for (int l = 0; l < 8; ++l) {
            level.addAlwaysVisibleParticle(ParticleTypes.SOUL, (double) pos.getX() + Math.random(), (double) pos.getY() + Math.random(), (double) pos.getZ() + Math.random(), 0.0, 0.0, 0.0);
        }
    }
}

