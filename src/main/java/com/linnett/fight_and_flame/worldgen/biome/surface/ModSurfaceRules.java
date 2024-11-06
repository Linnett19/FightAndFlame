package com.linnett.fight_and_flame.worldgen.biome.surface;

import com.linnett.fight_and_flame.block.ModBlocks;
import com.linnett.fight_and_flame.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(ModBlocks.SCARY_STONE.get());
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(ModBlocks.LAWN.get());
    private static final SurfaceRules.RuleSource SAPPHIRE = makeStateRule(ModBlocks.SCARY_STONE.get());
    private static final SurfaceRules.RuleSource RAW_SAPPHIRE = makeStateRule(ModBlocks.LAWN.get());
    private static final SurfaceRules.RuleSource CUSTOM_DIRT_REPLACEMENT = makeStateRule(ModBlocks.SCARY_STONE.get()); // Замените на блок, который будет заменять землю

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK),
                DIRT
        );

        return SurfaceRules.sequence(
                // Применяем замену на сырой сапфир на поверхности TEST_BIOME
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TEST_BIOME),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RAW_SAPPHIRE),
                                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SAPPHIRE)
                        )
                ),

                // Заменяем камень на пользовательский блок в диапазоне высот

                // Заменяем землю на пользовательский блок
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), CUSTOM_DIRT_REPLACEMENT),

                // По умолчанию поверхность из травы и земли
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
