package com.linnett.fight_and_flame.entity;

import com.linnett.fight_and_flame.FightAndFlame;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = FightAndFlame.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FightAndFlameEntityRegistry {

    public static final DeferredRegister<EntityType<?>> DEF_REG
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FightAndFlame.MOD_ID);





    public static void registerEntities(IEventBus eventBus) {
        DEF_REG.register(eventBus);
    }
}


