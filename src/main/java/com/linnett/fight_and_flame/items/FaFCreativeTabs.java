package com.linnett.fight_and_flame.items;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.FaFBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FaFCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FightAndFlame.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIGHT_AND_FLAME_STAFF = CREATIVE_MODE_TABS.register("fight_and_flame_stuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(FaFItems.OMNIGEM.get()))
                    .title(Component.translatable("itemGroup.fight_and_flame_stuff"))
                    .withBackgroundLocation(new ResourceLocation("fight_and_flame:textures/gui/fight_and_flame_item_tab.png"))
                    .withTabsImage(new ResourceLocation("fight_and_flame:textures/gui/fight_and_flame_tabs.png"))
                    .displayItems((pparameters, poutput) -> {

                        // Elemental Crystals


                        poutput.accept(FaFItems.PYROCLASTITE.get());
                        poutput.accept(FaFItems.HARMONITE.get());
                        poutput.accept(FaFItems.FLORAMBER.get());
                        poutput.accept(FaFItems.VOLTINITE.get());
                        poutput.accept(FaFItems.AEROGEL.get());
                        poutput.accept(FaFItems.SANGUINITE.get());
                        poutput.accept(FaFItems.ABYSSNESS.get());
                        poutput.accept(FaFItems.STELLARITE.get());
                        poutput.accept(FaFItems.OMNIGEM.get());

                        poutput.accept(FaFBlocks.STELLARITE_OBELISK.get());


                        // Eruption Biome


                        poutput.accept(FaFBlocks.VOLCANIC_STONES.get());

                        poutput.accept(FaFBlocks.VOLCANO_STONE.get());
                        poutput.accept(FaFBlocks.VOLCANO_STONE_STAIRS.get());
                        poutput.accept(FaFBlocks.VOLCANO_STONE_SLAB.get());
                        poutput.accept(FaFBlocks.VOLCANO_STONE_WALL.get());
                        poutput.accept(FaFBlocks.POLISHED_VOLCANO_STONE.get());
                        poutput.accept(FaFBlocks.POLISHED_VOLCANO_STONE_WALL.get());
                        poutput.accept(FaFBlocks.VOLCANO_STONE_BRICKS.get());
                        poutput.accept(FaFBlocks.VOLCANO_STONE_BRICKS_WALL.get());

                        poutput.accept(FaFBlocks.GEYSER.get());

                        poutput.accept(FaFBlocks.VOLCANO_MAGMA.get());
                        poutput.accept(FaFBlocks.VOLCANO_MAGMA_BRICKS.get());
                        poutput.accept(FaFBlocks.POLISHED_VOLCANO_MAGMA.get());

                        poutput.accept(FaFBlocks.VOLCANO_CORE.get());

                        poutput.accept(FaFBlocks.VOLCANIC_CACTUS.get());

                        poutput.accept(FaFBlocks.ASH.get());
                        poutput.accept(FaFBlocks.ASH_DUNE.get());
                        poutput.accept(FaFItems.PHOENIX_FEATHER.get());



                        // Tangle Forest



                        poutput.accept(FaFBlocks.SCARY_STONE.get());
                        poutput.accept(FaFBlocks.SCARY_STONE_STAIRS.get());
                        poutput.accept(FaFBlocks.SCARY_STONE_SLAB.get());


                        poutput.accept(FaFBlocks.SCARY_STONE_BRICKS.get());
                        poutput.accept(FaFBlocks.SCARY_STONE_BRICKS_STAIRS.get());
                        poutput.accept(FaFBlocks.SCARY_STONE_BRICKS_SLAB.get());
                        poutput.accept(FaFBlocks.SCARY_STONE_BRICKS_WALL.get());



                        poutput.accept(FaFBlocks.MOSSY_SCARY_STONE_BRICKS.get());
                        poutput.accept(FaFBlocks.LAWN.get());
                        poutput.accept(FaFItems.LAWN_CARPET_ITEM.get());
                        poutput.accept(FaFBlocks.BLOOD_LILY.get());


                        poutput.accept(FaFItems.CANDI_CORN.get());
                        poutput.accept(FaFItems.SLIME_LOLIPOP.get());
                        poutput.accept(FaFItems.SOUR_BONE.get());
                        poutput.accept(FaFItems.JELLY_BALLS.get());

                        poutput.accept(FaFBlocks.CAULDRON.get());

                        poutput.accept(FaFBlocks.HORRIBLE_LEAVES.get());
                        poutput.accept(FaFBlocks.HORRIBLE_LOG.get());
                        poutput.accept(FaFBlocks.HORRIBLE_WOOD.get());
                        poutput.accept(FaFBlocks.HORRIBLE_BEHOLD_LOG.get());
                        poutput.accept(FaFBlocks.HORRIBLE_BEHOLD_WOOD.get());

                        poutput.accept(FaFBlocks.STRIPPED_HORRIBLE_LOG.get());
                        poutput.accept(FaFBlocks.STRIPPED_HORRIBLE_WOOD.get());
                        poutput.accept(FaFBlocks.STRIPPED_HORRIBLE_BEHOLD_LOG.get());
                        poutput.accept(FaFBlocks.STRIPPED_HORRIBLE_BEHOLD_WOOD.get());

                        poutput.accept(FaFBlocks.HORRIBLE_PLANKS.get());
                        poutput.accept(FaFBlocks.HORRIBLE_STAIRS.get());
                        poutput.accept(FaFBlocks.HORRIBLE_SLAB.get());
                        poutput.accept(FaFBlocks.HORRIBLE_DOOR  .get());
                        poutput.accept(FaFItems.HORRIBLE_SIGN.get());
                        poutput.accept(FaFItems.HORRIBLE_HANGING_SIGN.get());
                        poutput.accept(FaFBlocks.HORRIBLE_FENCE.get());
                        poutput.accept(FaFBlocks.HORRIBLE_FENCE_GATE.get());
                        poutput.accept(FaFBlocks.HORRIBLE_TRAPDOOR.get());
                        poutput.accept(FaFBlocks.HORRIBLE_PRESSURE_PLATE.get());



                        // Flooded Biome



                    })
                    .build());




    public static final RegistryObject<CreativeModeTab> FIGHT_AND_FLAME_WEAPONS = CREATIVE_MODE_TABS.register("fight_and_flame_weapons",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(FaFItems.BLANK_BLUEPRINT.get()))
                    .title(Component.translatable("itemGroup.fight_and_flame_weapons"))
                    .withBackgroundLocation(new ResourceLocation("fight_and_flame:textures/gui/fight_and_flame_item_tab.png"))
                    .withTabsImage(new ResourceLocation("fight_and_flame:textures/gui/fight_and_flame_tabs.png"))
                    .displayItems((pparameters, poutput) -> {


                        poutput.accept(FaFItems.BLANK_BLUEPRINT.get());


                        poutput.accept(Items.IRON_INGOT);
                        poutput.accept(FaFItems.IRON_BROADSWORD.get());
                        poutput.accept(FaFItems.IRON_SPEAR.get());
                        poutput.accept(FaFItems.IRON_SCYTHE.get());
                        poutput.accept(FaFItems.IRON_RAPIER.get());
                        poutput.accept(FaFItems.IRON_SICKLE.get());

                        poutput.accept(Items.GOLD_INGOT);
                        poutput.accept(FaFItems.GOLDEN_BROADSWORD.get());
                        poutput.accept(FaFItems.GOLDEN_SPEAR.get());
                        poutput.accept(FaFItems.GOLDEN_SCYTHE.get());
                        poutput.accept(FaFItems.GOLDEN_RAPIER.get());
                        poutput.accept(FaFItems.GOLDEN_SICKLE.get());

                        poutput.accept(Items.DIAMOND);
                        poutput.accept(FaFItems.DIAMOND_BROADSWORD.get());
                        poutput.accept(FaFItems.DIAMOND_SPEAR.get());
                        poutput.accept(FaFItems.DIAMOND_SCYTHE.get());
                        poutput.accept(FaFItems.DIAMOND_RAPIER.get());
                        poutput.accept(FaFItems.DIAMOND_SICKLE.get());

                        poutput.accept(Items.NETHERITE_INGOT);
                        poutput.accept(FaFItems.NETHERITE_BROADSWORD.get());
                        poutput.accept(FaFItems.NETHERITE_SPEAR.get());
                        poutput.accept(FaFItems.NETHERITE_SCYTHE.get());
                        poutput.accept(FaFItems.NETHERITE_RAPIER.get());
                        poutput.accept(FaFItems.NETHERITE_SICKLE.get());


                        poutput.accept(FaFItems.FORCE_MOKTEL.get());
                        poutput.accept(FaFItems.JUMP_MOKTEL.get());
                        poutput.accept(FaFItems.SPEED_MOKTEL.get());
                        poutput.accept(FaFItems.BURST_MOKTEL.get());

                        poutput.accept(FaFItems.BOTTLE.get());
                        poutput.accept(FaFItems.CYLINDRICAL_GLASS.get());
                        poutput.accept(FaFItems.TRIANGULAR_GLASS.get());
                        poutput.accept(FaFItems.DISTORTED_GLASS.get());

                        poutput.accept(FaFItems.MAGIC_STICK.get());
                        poutput.accept(FaFItems.ERUPTING_STICK.get());
                        poutput.accept(FaFItems.ICE_STICK.get());
                        poutput.accept(FaFItems.LIGHTNING_STICK.get());

                    })
                    .build());







    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}
