package com.linnett.fight_and_flame.block;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.items.Moditems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
         public static final DeferredRegister<Block>    BLOCKS =
                 DeferredRegister.create(ForgeRegistries.BLOCKS, FightAndFlame.MOD_ID);

         public static final RegistryObject<Block> NEPHRITIS_BLOCK = registerBlock("nephritis_block",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

         public static final RegistryObject<Block> NEPHRITIS_ORE = registerBlock("nephritis_ore",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));


    public static final RegistryObject<Block> AWAKENED_NETHERITE_BLOCK = registerBlock("awakened_netherite_block",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

         public static final RegistryObject<Block> BLOOD_STONE_BLOCK = registerBlock("blood_stone_block",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

         public static final RegistryObject<Block> RAW_BLOOD_STONE_BLOCK = registerBlock("raw_blood_stone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

         public static final RegistryObject<Block> BLOOD_STONE_ORE = registerBlock("blood_stone_ore",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

         public static final RegistryObject<Block> APHATIT_CRYSTAL_BLOCK = registerBlock("aphatit_crystal_block",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));

         public static final RegistryObject<Block> APHATIT_CLUSTER = registerBlock("aphatit_cluster",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)));


         public static final RegistryObject<Block> ARMORY_TABLE = registerBlock("armory_table",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_COPPER)));

         public static final RegistryObject<Block> SCARY_STONE = registerBlock("scary_stone",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

         public static final RegistryObject<Block> SCARY_STONE_BRICKS = registerBlock("scary_stone_bricks",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

         public static final RegistryObject<Block> MOSSY_SCARY_STONE_BRICKS = registerBlock("mossy_scary_stone_bricks",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

         public static final RegistryObject<Block> LAWN = registerBlock("lawn",
                 () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
             RegistryObject<T> toReturn = BLOCKS.register(name, block);
             registerBlockItem(name, toReturn);
             return toReturn;

         }

         private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
             return Moditems.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
         }

         public static void register(IEventBus eventBus) {
             BLOCKS.register(eventBus);
         }
}
