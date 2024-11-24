package com.linnett.fight_and_flame.worldgen.biome;

import com.linnett.fight_and_flame.FightAndFlame;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(FightAndFlame.MOD_ID, "overworld"), 5));
    }
}
