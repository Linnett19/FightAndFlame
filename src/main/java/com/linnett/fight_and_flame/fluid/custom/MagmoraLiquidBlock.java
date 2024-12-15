package com.linnett.fight_and_flame.fluid.custom;


import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.RegistryObject;

public class MagmoraLiquidBlock extends LiquidBlock {
    public MagmoraLiquidBlock(RegistryObject<? extends Fluid> fluid, Properties properties) {
        super(() -> (FlowingFluid) fluid.get(), properties);
    }
}

