package luna.lunasorigins.worldgen.tree;

import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import luna.lunasorigins.worldgen.LunaFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class RedCommandTreeSaplingGenerator extends SaplingGenerator {
  @Nullable
  @Override
  protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
    return LunaFeatures.RED_COMMAND_TREE;
  }

}