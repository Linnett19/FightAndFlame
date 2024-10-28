package com.linnett.fight_and_flame.entity;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.entity.custom.MusicTape;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = FightAndFlame.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FightAndFlameEntityRegistry {
    public static final DeferredRegister<EntityType<?>> DEF_REG
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FightAndFlame.MOD_ID);

    public static final RegistryObject<EntityType<MusicTape>> MUSIC_TAPE = DEF_REG.register(
            "music_tape",
            () ->EntityType.Builder.<MusicTape>of(MusicTape::new, MobCategory.MISC)
                    .sized(0.2F, 0.2F)
                    .clientTrackingRange(8)
                    .build("music_tape")
    );
}
