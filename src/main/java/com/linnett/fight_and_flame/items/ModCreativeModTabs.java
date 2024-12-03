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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.BLANK_BLUEPRINT.get()))
                    .title(Component.translatable("itemGroup.fight_and_flame_materials_and_blocks"))
                    .displayItems((pparameters, poutput) -> {


                        poutput.accept(ModItem.PYROCLASTITE.get());
                        poutput.accept(ModItem.HARMONITE.get());
                        poutput.accept(ModItem.FLORAMBER.get());
                        poutput.accept(ModItem.VOLTINITE.get());
                        poutput.accept(ModItem.AEROGEL.get());
                        poutput.accept(ModItem.SANGUINITE.get());
                        poutput.accept(ModItem.ABYSSNESS.get());
                        poutput.accept(ModItem.STELLARITE.get());
                        poutput.accept(ModItem.OMNIGEM.get());

                        poutput.accept(ModItem.BLANK_BLUEPRINT.get());

                        poutput.accept(ModItem.IRON_BROADSWORD.get());
                        poutput.accept(ModItem.IRON_SPEAR.get());
                        poutput.accept(ModItem.IRON_SCYTHE.get());
                        poutput.accept(ModItem.IRON_RAPIER.get());
                        poutput.accept(ModItem.IRON_SICKLE.get());

                        poutput.accept(ModItem.GOLDEN_BROADSWORD.get());
                        poutput.accept(ModItem.GOLDEN_SPEAR.get());
                        poutput.accept(ModItem.GOLDEN_SCYTHE.get());
                        poutput.accept(ModItem.GOLDEN_RAPIER.get());
                        poutput.accept(ModItem.GOLDEN_SICKLE.get());

                        poutput.accept(ModItem.DIAMOND_BROADSWORD.get());
                        poutput.accept(ModItem.DIAMOND_SPEAR.get());
                        poutput.accept(ModItem.DIAMOND_SCYTHE.get());
                        poutput.accept(ModItem.DIAMOND_RAPIER.get());
                        poutput.accept(ModItem.DIAMOND_SICKLE.get());

                        poutput.accept(ModItem.NETHERITE_BROADSWORD.get());
                        poutput.accept(ModItem.NETHERITE_SPEAR.get());
                        poutput.accept(ModItem.NETHERITE_SCYTHE.get());
                        poutput.accept(ModItem.NETHERITE_RAPIER.get());
                        poutput.accept(ModItem.NETHERITE_SICKLE.get());

                        poutput.accept(ModBlocks.STELLARIT_OBELISK.get());

                        poutput.accept(ModBlocks.VOLCANO_STONE.get());
                        poutput.accept(ModBlocks.MAGMORA.get());
                        poutput.accept(ModBlocks.ERUPTION_CORE.get());


                        poutput.accept(ModBlocks.SCARY_STONE.get());
                        poutput.accept(ModBlocks.SCARY_STONE_STAIRS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_SLAB.get());


                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_STAIRS.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_SLAB.get());
                        poutput.accept(ModBlocks.SCARY_STONE_BRICKS_WALL.get());



                        poutput.accept(ModBlocks.MOSSY_SCARY_STONE_BRICKS.get());
                        poutput.accept(ModBlocks.LAWN.get());

                        poutput.accept(ModItem.CANDI_CORN.get());
                        poutput.accept(ModItem.SLIME_LOLIPOP.get());
                        poutput.accept(ModItem.SOUR_BONE.get());
                        poutput.accept(ModItem.JELLY_BALLS.get());

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
                        poutput.accept(ModItem.HORRIBLE_SIGN.get());
                        poutput.accept(ModItem.HORRIBLE_HANGING_SIGN.get());










                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}
