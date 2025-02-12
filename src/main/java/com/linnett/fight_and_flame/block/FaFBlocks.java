package com.linnett.fight_and_flame.block;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.custom_block.*;
import com.linnett.fight_and_flame.block.custom_block.FireBlock;
import com.linnett.fight_and_flame.items.FaFItems;
import com.linnett.fight_and_flame.worldgen.wood.FaFWoodTypes;
import net.minecraft.client.resources.model.Material;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.TrapDoorBlock;



import java.util.function.Supplier;


public class FaFBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FightAndFlame.MOD_ID);

    public static final RegistryObject<Block> VOLCANO_STONE = registerBlock("volcano_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));



    public static final RegistryObject<Block> VOLCANO_STONE_WALL = registerBlock("volcano_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> POLISHED_VOLCANO_STONE_WALL = registerBlock("polished_volcano_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> VOLCANO_STONE_BRICKS_WALL = registerBlock("volcano_stone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));




    public static final RegistryObject<Block> VOLCANIC_STONES = registerBlock("volcanic_stones",
            () -> new VolcanicStonesBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> POLISHED_VOLCANO_STONE = registerBlock("polished_volcano_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.POLISHED_DEEPSLATE)));

    public static final RegistryObject<Block> VOLCANO_STONE_BRICKS = registerBlock("volcano_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.DEEPSLATE_BRICKS)));

    public static final RegistryObject<Block> VOLCANO_STONE_STAIRS = registerBlock("volcano_stone_stairs",
            () -> new StairBlock(VOLCANO_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> VOLCANO_STONE_SLAB = registerBlock("volcano_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> VOLCANO_MAGMA = registerBlock("volcano_magma",
            () -> new FireBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> POLISHED_VOLCANO_MAGMA = registerBlock("polished_volcano_magma",
            () -> new FireBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.POLISHED_DEEPSLATE)));

    public static final RegistryObject<Block> VOLCANO_MAGMA_BRICKS = registerBlock("volcano_magma_bricks",
            () -> new FireBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.DEEPSLATE_BRICKS)));

    public static final RegistryObject<Block> ASH = registerBlock("ash",
            () -> new AshBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)));

    public static final RegistryObject<Block> ASH_DUNE = registerBlock("ash_dune",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SOUL_SOIL)));

    public static final RegistryObject<Block> VOLCANO_CORE = registerBlock("volcano_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.LODESTONE)));

    public static final RegistryObject<Block> VOLCANIC_CACTUS = registerBlock("volcanic_cactus",
            () -> new VolcanicCactus(BlockBehaviour.Properties.copy(Blocks.CACTUS).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> GEYSER = registerBlock("geyser",
            () -> new Geyser(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.TUFF)));


    public static final RegistryObject<Block> BLOOD_LILY = registerBlock("blood_lily",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 10,
                    BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));
    
    public static final RegistryObject<Block> POTTED_BLOOD_LILY = BLOCKS.register("potted_blood_lily",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), FaFBlocks.BLOOD_LILY,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));


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

    public static final RegistryObject<Block> LAWN_CARPET = BLOCKS.register("lawn_carpet", LawnCarpet::new);


    public static final RegistryObject<Block> CAULDRON = registerBlock("cauldron",
            () -> new ScaryCauldron(BlockBehaviour.Properties.copy(Blocks.CAULDRON)));


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
            () -> new HorribleLeaf(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((blockState, getter, pos) -> false)));

    public static final RegistryObject<Block> HORRIBLE_SIGN = BLOCKS.register("horrible_sign",
            () -> new FaFStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), FaFWoodTypes.HORRIBLE));


    public static final RegistryObject<Block> HORRIBLE_WALL_SIGN = BLOCKS.register("horrible_wall_sign",
            () -> new FaFWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), FaFWoodTypes.HORRIBLE));

    public static final RegistryObject<Block> HORRIBLE_HANGING_SIGN = BLOCKS.register("horrible_hanging_sign",
            () -> new FaFHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), FaFWoodTypes.HORRIBLE));

    public static final RegistryObject<Block> HORRIBLE_WALL_HANGING_SIGN = BLOCKS.register("horrible_wall_hanging_sign",
            () -> new FaFWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), FaFWoodTypes.HORRIBLE));

    public static final RegistryObject<Block> HORRIBLE_DOOR = registerBlock("horrible_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(HORRIBLE_PLANKS.get()).strength(3.0F).sound(SoundType.CHERRY_WOOD).noOcclusion(), BlockSetType.CHERRY));

    public static final RegistryObject<Block> HORRIBLE_FENCE = BLOCKS.register("horrible_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> HORRIBLE_FENCE_GATE = BLOCKS.register("horrible_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(HORRIBLE_PLANKS.get()).strength(2.0F, 3.0F).sound(SoundType.CHERRY_WOOD).forceSolidOn(), SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> HORRIBLE_TRAPDOOR = BLOCKS.register("horrible_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(3.0F).sound(SoundType.CHERRY_WOOD).noOcclusion(), BlockSetType.CHERRY));

    public static final RegistryObject<Block> HORRIBLE_PRESSURE_PLATE = BLOCKS.register("horrible_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(HORRIBLE_PLANKS.get()).noCollission().strength(0.5F).sound(SoundType.CHERRY_WOOD), BlockSetType.CHERRY));

    public static final RegistryObject<Block> HORRIBLE_BUTTON = BLOCKS.register("horrible_button.json",
            () -> new ButtonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(0.5F).sound(SoundType.CHERRY_WOOD), BlockSetType.CHERRY, 30, true));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return FaFItems.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
