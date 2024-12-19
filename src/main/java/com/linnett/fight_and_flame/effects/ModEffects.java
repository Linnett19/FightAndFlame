package com.linnett.fight_and_flame.effects;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.effects.custom.AshEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FightAndFlame.MOD_ID);

    public static final RegistryObject<MobEffect> ASH_EFFECT = EFFECTS.register("ash_effect", () -> new AshEffect(MobEffectCategory.HARMFUL));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}

