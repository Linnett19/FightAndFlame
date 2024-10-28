package com.linnett.fight_and_flame.items;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FightAndFlame.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIGHT_AND_FLAME_INGREDIENTS = CREATIVE_MODE_TABS.register("fight_and_flame_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLANK_BLUEPRINT.get()))
                    .title(Component.translatable("itemGroup.fight_and_flame_ingredients"))
                    .displayItems((pparameters, poutput) -> {

                        poutput.accept(ModBlocks.ARMORY_TABLE.get());

                        poutput.accept(ModItems.BLANK_BLUEPRINT_TORN.get());
                        poutput.accept(ModItems.BLANK_BLUEPRINT.get());

                        poutput.accept(ModItems.BLANK_BLUEPRINT_TWOHANDED_SWORD.get());
                        poutput.accept(ModItems.BLANK_BLUEPRINT_RAPIER.get());
                        poutput.accept(ModItems.BLANK_BLUEPRINT_SICKLE.get());
                        poutput.accept(ModItems.BLANK_BLUEPRINT_BRAID.get());
                        poutput.accept(ModItems.BLANK_BLUEPRINT_SPEAR.get());

                        poutput.accept(ModItems.NEPHRITIS_PIECES.get());
                        poutput.accept(ModItems.NEPHRITIS_INGOT.get());
                        poutput.accept(ModItems.RAW_NEPHRITIS.get());
                        poutput.accept(ModBlocks.NEPHRITIS_ORE.get());
                        poutput.accept(ModBlocks.NEPHRITIS_BLOCK.get());

                        poutput.accept(ModItems.APHATIT_CRYSTAL_SPLINTER.get());
                        poutput.accept(ModItems.APHATIT_CRYSTAL.get());
                        poutput.accept(ModBlocks.APHATIT_CLUSTER.get());
                        poutput.accept(ModBlocks.APHATIT_CRYSTAL_BLOCK.get());


                        poutput.accept(ModItems.BLOOD_STONE_PIECES.get());
                        poutput.accept(ModItems.BLOOD_STONE_INGOT.get());
                        poutput.accept(ModItems.RAW_BLOOD_STONE.get());
                        poutput.accept(ModBlocks.RAW_BLOOD_STONE_BLOCK.get());
                        poutput.accept(ModBlocks.BLOOD_STONE_ORE.get());
                        poutput.accept(ModBlocks.BLOOD_STONE_BLOCK.get());


                        poutput.accept(ModItems.AWAKENED_NETHERITE_PIECES.get());
                        poutput.accept(ModItems.AWAKENED_NETHERITE_INGOT.get());
                        poutput.accept(ModBlocks.AWAKENED_NETHERITE_BLOCK.get());

                        poutput.accept(ModItems.ELEMENTAL_CRYSTAL.get());
                        poutput.accept(ModItems.NOTE.get());



                        poutput.accept(ModBlocks.SCARY_STONE.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.MOSSY_SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.LAWN.get());


                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> FIGHT_AND_FLAME_WEAPONS = CREATIVE_MODE_TABS.register("fight_and_flame_weapons",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLANK_BLUEPRINT.get()))
                    .title(Component.translatable("itemGroup.fight_and_flame_weapons"))
                    .displayItems((pparameters, poutput) -> {

                        poutput.accept(ModItems.FLUTE.get());
                    })
                    .build());






    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}