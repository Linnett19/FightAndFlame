package com.linnett.fight_and_flame.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class AshEffect extends MobEffect {

    public AshEffect(MobEffectCategory category) {
        super(category, 0x6f5d4f); // Цвет 6f5d4f
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }
}











