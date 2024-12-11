package com.linnett.fight_and_flame.block;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.custom_block.*;
import com.linnett.fight_and_flame.items.ModItem;
import com.linnett.fight_and_flame.worldgen.wood.ModWoodTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FightAndFlame.MOD_ID);





    public static final RegistryObject<Block> VOLCANO_STONE = registerBlock("volcano_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> MAGMORA = registerBlock("magmora",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> ERUPTION_CORE = registerBlock("eruption_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));



    public static final RegistryObject<Block> STELLARITE_OBELISK = registerBlock("stellarite_obelisk",
            () -> new StellariteObelisk(BlockBehaviour.Properties.copy(Blocks.STONE)));





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

    public static final RegistryObject<Block> HORRIBLE_SIGN = BLOCKS.register("horrible_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.HORRIBLE));

    public static final RegistryObject<Block> HORRIBLE_WALL_SIGN = BLOCKS.register("horrible_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.HORRIBLE));

    public static final RegistryObject<Block> HORRIBLE_HANGING_SIGN = BLOCKS.register("horrible_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.HORRIBLE));

    public static final RegistryObject<Block> HORRIBLE_WALL_HANGING_SIGN = BLOCKS.register("horrible_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.HORRIBLE));

    public static final RegistryObject<Block> HORRIBLE_DOOR = registerBlock("horrible_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(HORRIBLE_PLANKS.get()).strength(3.0F).sound(SoundType.CHERRY_WOOD).noOcclusion(), BlockSetType.CHERRY));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItem.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
