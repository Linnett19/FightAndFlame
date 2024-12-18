package com.linnett.fight_and_flame.entity;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.entity.custom.LavaShardEntity;
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


 public static final RegistryObject<EntityType<LavaShardEntity>> LAVA_SHARD = DEF_REG.register("lava_shard", () -> (EntityType) EntityType.Builder.of(LavaShardEntity::new, MobCategory.MISC).sized(0.2F, 0.2F).clientTrackingRange(8).build("lava_shard"));



    public static void registerEntities(IEventBus eventBus) {
        DEF_REG.register(eventBus);
    }
}


