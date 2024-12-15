package com.linnett.fight_and_flame.fluid;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.ModBlocks;
import com.linnett.fight_and_flame.fluid.custom.MagmoraLiquidBlock;
import com.linnett.fight_and_flame.fluid.custom.MagmoraFluidType;
import com.linnett.fight_and_flame.items.ModItems;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, FightAndFlame.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, FightAndFlame.MOD_ID);

    private static ForgeFlowingFluid.Properties magmoraProperties() {
        return new ForgeFlowingFluid.Properties(MAGMORA_TYPE, MAGMORA_SOURCE, MAGMORA_FLOWING)
                .bucket(MAGMORA_BUCKET)
                .block(MAGMORA)
                .explosionResistance(100.0f);
    }

    public static final RegistryObject<FluidType> MAGMORA_TYPE = FLUID_TYPES.register("magmora", () ->
            new MagmoraFluidType(FluidType.Properties.create()
                    .lightLevel(7)
                    .density(0)
                    .viscosity(0)
                    .canPushEntity(false)
                    .canSwim(false)
                    .canConvertToSource(true)
                    .canDrown(false)
                    .pathType(BlockPathTypes.LAVA)
                    .supportsBoating(false)
                    .temperature(200)
                    .canExtinguish(false)
                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                    .canHydrate(false)
            ));

    public static final RegistryObject<FlowingFluid> MAGMORA_SOURCE = FLUIDS.register("magmora", () ->
            new ForgeFlowingFluid.Source(magmoraProperties()));

    public static final RegistryObject<FlowingFluid> MAGMORA_FLOWING = FLUIDS.register("flowing_magmora", () ->
            new ForgeFlowingFluid.Flowing(magmoraProperties()));

    public static final RegistryObject<Item> MAGMORA_BUCKET = ModItems.ITEM.register("magmora_bucket", () ->
            new BucketItem(ModFluids.MAGMORA_SOURCE, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<LiquidBlock> MAGMORA = ModBlocks.BLOCKS.register("magmora", () ->
            new MagmoraLiquidBlock(MAGMORA_SOURCE, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .replaceable()
                    .noCollission()
                    .strength(100.0F)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(state -> 7)
                    .noLootTable()
                    .liquid()
                    .sound(SoundType.EMPTY)));

    public static void init(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
    }

    public static void initFluidInteractions() {
        FluidInteractionRegistry.addInteraction(MAGMORA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                ForgeMod.WATER_TYPE.get(), state -> ModBlocks.VOLCANO_STONE.get().defaultBlockState()));
    }
}

