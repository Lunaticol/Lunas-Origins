package luna.lunasorigins.worldgen;

import luna.lunasorigins.LunaBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class LunaFeatures {

        public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {

                featureRegisterable.register(PINK_COMMAND_TREE, PinkCommandTree());
                featureRegisterable.register(GREEN_COMMAND_TREE,
                                new ConfiguredFeature<>(Feature.TREE, GreenCommandTree().build()));
                featureRegisterable.register(RED_COMMAND_TREE, RedCommandTree());
                featureRegisterable.register(YELLOW_COMMAND_TREE, YellowCommandTree());
        }

        public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_COMMAND_TREE = RegistryKey.of(
                        RegistryKeys.CONFIGURED_FEATURE,
                        new Identifier("lunasorigins", "pink_command_tree"));

        public static ConfiguredFeature<TreeFeatureConfig, ?> PinkCommandTree() {
                return new ConfiguredFeature<>(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(LunaBlocks.COMMAND_LOG_GREEN),
                                                new StraightTrunkPlacer(4, 2, 0),
                                                BlockStateProvider.of(LunaBlocks.COMMAND_LEAVES_PINK),
                                                new BlobFoliagePlacer(ConstantIntProvider.create(2),
                                                                ConstantIntProvider.create(0), 3),
                                                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        }

        public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_COMMAND_TREE = RegistryKey.of(
                        RegistryKeys.CONFIGURED_FEATURE,
                        new Identifier("lunasorigins", "yellow_command_tree"));

        public static ConfiguredFeature<TreeFeatureConfig, ?> YellowCommandTree() {
                return new ConfiguredFeature<>(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(LunaBlocks.COMMAND_LOG_RED),
                                                new StraightTrunkPlacer(4, 2, 0),
                                                BlockStateProvider.of(LunaBlocks.COMMAND_LEAVES_YELLOW),
                                                new BlobFoliagePlacer(ConstantIntProvider.create(2),
                                                                ConstantIntProvider.create(0), 3),
                                                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        }

        public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_COMMAND_TREE = RegistryKey.of(
                        RegistryKeys.CONFIGURED_FEATURE, new Identifier("lunasorigins", "green_command_tree"));

        public static TreeFeatureConfig.Builder GreenCommandTree() {
                return new TreeFeatureConfig.Builder(
                                BlockStateProvider.of(LunaBlocks.COMMAND_LOG_PINK),
                                new CherryTrunkPlacer(
                                                7,
                                                1,
                                                0,
                                                new WeightedListIntProvider(
                                                                DataPool.<IntProvider>builder()
                                                                                .add(ConstantIntProvider.create(1), 1)
                                                                                .add(ConstantIntProvider.create(2), 1)
                                                                                .add(ConstantIntProvider.create(3), 1)
                                                                                .build()),
                                                UniformIntProvider.create(2, 4),
                                                UniformIntProvider.create(-4, -3),
                                                UniformIntProvider.create(-1, 0)),
                                BlockStateProvider.of(LunaBlocks.COMMAND_LEAVES_GREEN),
                                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0),
                                                ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                                new TwoLayersFeatureSize(1, 0, 2))
                                .ignoreVines();
        }

        public static final RegistryKey<ConfiguredFeature<?, ?>> RED_COMMAND_TREE = RegistryKey.of(
                        RegistryKeys.CONFIGURED_FEATURE,
                        new Identifier("lunasorigins", "red_command_tree"));

        public static ConfiguredFeature<TreeFeatureConfig, ?> RedCommandTree() {
                return new ConfiguredFeature<>(Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(LunaBlocks.COMMAND_LOG_YELLOW),
                                                new ForkingTrunkPlacer(5, 2, 2),
                                                BlockStateProvider.of(LunaBlocks.COMMAND_LEAVES_RED),
                                                new AcaciaFoliagePlacer(ConstantIntProvider.create(2),
                                                                ConstantIntProvider.create(0)),
                                                new TwoLayersFeatureSize(1, 0, 2))
                                                .ignoreVines()
                                                .build());
        }

}
