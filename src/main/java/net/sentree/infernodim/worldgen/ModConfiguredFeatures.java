package net.sentree.infernodim.worldgen;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.block.ModBlocks;
import net.sentree.infernodim.feature.ModFeatures;
import net.sentree.infernodim.util.ModTags;

import java.util.List;
import java.util.Map;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_INFERNO_ORE_KEY = registerKey("inferno_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLAZE_KEY = registerKey("blaze");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest ashReplaceable = new TagMatchTest(ModTags.Blocks.ASH_BLOCK_REPLACEABLES);
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldInfernoOres = List.of(OreConfiguration.target(ashReplaceable,
                ModBlocks.INFERNO_DEBRIS.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.INFERNO_DEBRIS.get().defaultBlockState()),
                OreConfiguration.target(stoneReplaceable, ModBlocks.INFERNO_DEBRIS.get().defaultBlockState()));

        register(context, OVERWORLD_INFERNO_ORE_KEY, Feature.ORE, new OreConfiguration(overworldInfernoOres, 3));

        register(context, BLAZE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BLAZE_LOG.get()),
                new StraightTrunkPlacer(5,4,3),

                BlockStateProvider.simple(ModBlocks.BLAZE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2),3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(InfernoMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
