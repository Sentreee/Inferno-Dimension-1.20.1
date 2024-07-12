package net.sentree.infernodim.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.sentree.infernodim.block.ModBlocks;
import net.sentree.infernodim.worldgen.biome.ModBiomes;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource HARDENED_ASH_BLOCK = makeStateRule(ModBlocks.HARDENED_ASH_BLOCK.get());
    private static final SurfaceRules.RuleSource ASH_BLOCK = makeStateRule(ModBlocks.ASH_BLOCK.get());



    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.INFERNO_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, ASH_BLOCK)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, HARDENED_ASH_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, HARDENED_ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, HARDENED_ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), HARDENED_ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.hole(), ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(), HARDENED_ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.temperature(), ASH_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.steep(), HARDENED_ASH_BLOCK)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
