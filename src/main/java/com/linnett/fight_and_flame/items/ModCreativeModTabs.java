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

    public static final RegistryObject<CreativeModeTab> FIGHT_AND_FLAME = CREATIVE_MODE_TABS.register("fight_and_flame",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLANK_BLUEPRINT.get()))
                    .title(Component.translatable("itemGroup.fight_and_flame_materials_and_blocks"))
                    .displayItems((pparameters, poutput) -> {


                        poutput.accept(ModItems.BLANK_BLUEPRINT.get());

                        poutput.accept(ModItems.IRON_BROADSWORD.get());

                        poutput.accept(ModBlocks.SCARY_STONE.get());
                        poutput.accept(ModBlocks.SCARY_STONE_STAIRS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_SLAB.get());


                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_STAIRS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_SLAB.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_WALL.get());



                        poutput.accept(ModBlocks.MOSSY_SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.LAWN.get());

                        poutput.accept(ModItems.CANDI_CORN.get());
                        poutput.accept(ModItems.SLIME_LOLIPOP.get());
                        poutput.accept(ModItems.SOUR_BONE.get());
                        poutput.accept(ModItems.JELLY_BALLS.get());

                        poutput.accept(ModBlocks.CAULDRON.get());

                        poutput.accept(ModBlocks.HORRIBLE_LEAVES.get());
                        poutput.accept(ModBlocks.HORRIBLE_LOG.get());
                        poutput.accept(ModBlocks.HORRIBLE_WOOD.get());
                        poutput.accept(ModBlocks.HORRIBLE_BEHOLD_LOG.get());
                        poutput.accept(ModBlocks.HORRIBLE_BEHOLD_WOOD.get());
                        poutput.accept(ModBlocks.STRIPPED_HORRIBLE_BEHOLD_LOG.get());
                        poutput.accept(ModBlocks.STRIPPED_HORRIBLE_BEHOLD_WOOD.get());
                        poutput.accept(ModBlocks.STRIPPED_HORRIBLE_LOG.get());
                        poutput.accept(ModBlocks.STRIPPED_HORRIBLE_WOOD.get());
                        poutput.accept(ModBlocks.HORRIBLE_PLANKS.get());
                        poutput.accept(ModBlocks.HORRIBLE_STAIRS.get());
                        poutput.accept(ModBlocks.HORRIBLE_SLAB.get());
                        poutput.accept(ModBlocks.HORRIBLE_DOOR  .get());
                        poutput.accept(ModItems.HORRIBLE_SIGN.get());
                        poutput.accept(ModItems.HORRIBLE_HANGING_SIGN.get());










                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}
