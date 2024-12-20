package com.linnett.fight_and_flame.worldgen.wood;

import com.linnett.fight_and_flame.FightAndFlame;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class FaFWoodTypes {
    public static final WoodType HORRIBLE = WoodType.register(new WoodType(FightAndFlame.MOD_ID + ":horrible", BlockSetType.BIRCH));
}
