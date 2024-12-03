package com.linnett.fight_and_flame.block.entity;

import com.linnett.fight_and_flame.FightAndFlame;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FightAndFlame.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> HORRIGBLE_SIGN =
            BLOCK_ENTITIES.register("horrible_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.HORRIBLE_SIGN.get(), ModBlocks.HORRIBLE_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> HORRIBLE_HANGING_SIGN =
            BLOCK_ENTITIES.register("horrible_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.HORRIBLE_HANGING_SIGN.get(), ModBlocks.HORRIBLE_WALL_HANGING_SIGN.get()).build(null));
}
