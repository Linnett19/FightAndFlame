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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.BLANK_BLUEPRINT.get()))
                    .title(Component.translatable("itemGroup.fight_and_flame_materials_and_blocks"))
                    .displayItems((pparameters, poutput) -> {


                        poutput.accept(ModBlocks.ARMORY_TABLE.get());

                        poutput.accept(Moditems.BLANK_BLUEPRINT_TORN.get());
                        poutput.accept(Moditems.BLANK_BLUEPRINT.get());

                        poutput.accept(Moditems.BLANK_BLUEPRINT_TWOHANDED_SWORD.get());
                        poutput.accept(Moditems.BLANK_BLUEPRINT_RAPIER.get());
                        poutput.accept(Moditems.BLANK_BLUEPRINT_SICKLE.get());
                        poutput.accept(Moditems.BLANK_BLUEPRINT_BRAID.get());
                        poutput.accept(Moditems.BLANK_BLUEPRINT_SPEAR.get());

                        poutput.accept(Moditems.IRON_TWOHANDED_SWORD.get());
                        poutput.accept(Moditems.IRON_BRAID.get());
                        poutput.accept(Moditems.IRON_RAPIER.get());
                        poutput.accept(Moditems.IRON_SPEAR.get());
                        poutput.accept(Moditems.IRON_SICKLE.get());

                        poutput.accept(Moditems.GOLDEN_TWOHANDED_SWORD.get());
                        poutput.accept(Moditems.GOLDEN_BRAID.get());
                        poutput.accept(Moditems.GOLDEN_RAPIER.get());
                        poutput.accept(Moditems.GOLDEN_SPEAR.get());
                        poutput.accept(Moditems.GOLDEN_SICKLE.get());

                        poutput.accept(Moditems.DIAMOND_TWOHANDED_SWORD.get());
                        poutput.accept(Moditems.DIAMOND_BRAID.get());
                        poutput.accept(Moditems.DIAMOND_RAPIER.get());
                        poutput.accept(Moditems.DIAMOND_SPEAR.get());
                        poutput.accept(Moditems.DIAMOND_SICKLE.get());

                        poutput.accept(Moditems.BRAID_OF_FEARS.get());
                        poutput.accept(Moditems.RAPIER_OF_FEARS.get());
                        poutput.accept(Moditems.TWOHANDED_SWORD_OF_FEARS.get());






                        poutput.accept(ModBlocks.SCARY_STONE.get());
                        poutput.accept(ModBlocks.SCARY_STONE_STAIRS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_SLAB.get());


                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_STAIRS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_SLAB.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_WALL.get());



                        poutput.accept(ModBlocks.MOSSY_SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.LAWN.get());

                        poutput.accept(Moditems.CANDICORN.get());
                        poutput.accept(Moditems.SLIME_LOLIPOP.get());
                        poutput.accept(Moditems.SOUR_BONE.get());
                        poutput.accept(Moditems.JELLY_BALLS.get());

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
                        poutput.accept(Moditems.HORRIBLE_SIGN.get());
                        poutput.accept(Moditems.HORRIBLE_HANGING_SIGN.get());










                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}
