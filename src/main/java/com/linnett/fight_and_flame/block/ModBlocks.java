package com.linnett.fight_and_flame.block;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.custom_block.CustomCauldron;
import com.linnett.fight_and_flame.block.custom_block.StrippableLogBlock;
import com.linnett.fight_and_flame.items.Moditems;
import com.linnett.fight_and_flame.world.wood.ModWoodTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.linnett.fight_and_flame.world.wood.ModWoodTypes.HORRIBLE;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS =
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

    public static final RegistryObject<Block> SCARY_STONE_STAIRS = registerBlock("scary_stone_stairs",
            () -> new StairBlock(SCARY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> SCARY_STONE_SLAB = registerBlock("scary_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> SCARY_STONE_BRICKS = registerBlock("scary_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> SCARY_STONE_BRICKS_STAIRS = registerBlock("scary_stone_bricks_stairs",
            () -> new StairBlock(SCARY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> SCARY_STONE_BRICKS_SLAB = registerBlock("scary_stone_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> SCARY_STONE_BRICKS_WALL = registerBlock("scary_stone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> MOSSY_SCARY_STONE_BRICKS = registerBlock("mossy_scary_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

    public static final RegistryObject<Block> LAWN = registerBlock("lawn",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)));

    public static final RegistryObject<Block> CAULDRON = registerBlock("cauldron",
            () -> new CustomCauldron(BlockBehaviour.Properties.copy(Blocks.CAULDRON)));

    public static final RegistryObject<Block> HORRIBLE_BEHOLD_LOG = registerBlock("horrible_behold_log",
            () -> new StrippableLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> HORRIBLE_BEHOLD_WOOD = registerBlock("horrible_behold_wood",
            () -> new StrippableLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> HORRIBLE_LOG = registerBlock("horrible_log",
            () -> new StrippableLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> HORRIBLE_WOOD = registerBlock("horrible_wood",
            () -> new StrippableLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_HORRIBLE_WOOD = registerBlock("stripped_horrible_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_HORRIBLE_BEHOLD_WOOD = registerBlock("stripped_horrible_behold_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_HORRIBLE_LOG = registerBlock("stripped_horrible_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_HORRIBLE_BEHOLD_LOG = registerBlock("stripped_horrible_behold_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> HORRIBLE_PLANKS = registerBlock("horrible_planks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> HORRIBLE_STAIRS = registerBlock("horrible_stairs",
            () -> new StairBlock(SCARY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> HORRIBLE_SLAB = registerBlock("horrible_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.CHERRY_WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> HORRIBLE_LEAVES = registerBlock("horrible_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((blockState, getter, pos) -> false)));

    public static final RegistryObject<Block> HORRIBLE_SIGN = registerBlock("horrible_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F).sound(SoundType.CHERRY_WOOD), HORRIBLE));
    public static final RegistryObject<Block> HORRIBLE_WALL_SIGN = registerBlock("horrible_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F).sound(SoundType.CHERRY_WOOD), HORRIBLE));
    public static final RegistryObject<Block> HORRIBLE_HANGING_SIGN = registerBlock("horrible_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F), HORRIBLE));
    public static final RegistryObject<Block> HORRIBLE_WALL_HANGING_SIGN = registerBlock("horrible_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(HORRIBLE_HANGING_SIGN.get()), HORRIBLE));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
