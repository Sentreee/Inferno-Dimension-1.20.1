package net.sentree.infernodim.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.sentree.infernodim.block.ModBlocks;

public class HardenedAshFeature extends Feature<NoneFeatureConfiguration> {
    public HardenedAshFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }


    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel world = context.level();
        RandomSource random = context.random();

        for (int y = 0; y < world.getMaxBuildHeight(); y++) {
            BlockPos currentPos = pos.above(y);
            BlockState state = world.getBlockState(currentPos);

            if (state.is(Blocks.STONE)) {
                world.setBlock(currentPos, ModBlocks.HARDENED_ASH_BLOCK.get().defaultBlockState(), 2);
            }
        }

        return true;
    }
}
