package luna.lunasorigins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.concurrent.CompletableFuture;

import luna.lunasorigins.worldgen.LunaFeatures;

public class LunaWorldGenerator extends FabricDynamicRegistryProvider {

  public LunaWorldGenerator(FabricDataOutput output,
      CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
    // Retrieve the blockRegistryLookup from registries

    // Register your configured features
    entries.add(
        LunaFeatures.PINK_COMMAND_TREE,
        LunaFeatures.PinkCommandTree());
    entries.add(LunaFeatures.GREEN_COMMAND_TREE,
        new ConfiguredFeature<>(net.minecraft.world.gen.feature.Feature.TREE,
            LunaFeatures.GreenCommandTree().build()));
    entries.add(
        LunaFeatures.RED_COMMAND_TREE,
        LunaFeatures.RedCommandTree());
    entries.add(
        LunaFeatures.YELLOW_COMMAND_TREE,
        LunaFeatures.YellowCommandTree());
  }

  @Override
  public String getName() {
    return "Luna World Generator";
  }
}
