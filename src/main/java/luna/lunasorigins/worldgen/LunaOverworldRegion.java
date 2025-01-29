package luna.lunasorigins.worldgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils.Continentalness;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.Erosion;
import terrablender.api.ParameterUtils.Humidity;
import terrablender.api.ParameterUtils.ParameterPointListBuilder;
import terrablender.api.ParameterUtils.Temperature;
import terrablender.api.ParameterUtils.Weirdness;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class LunaOverworldRegion extends Region {
  public LunaOverworldRegion(Identifier name, int weight) {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry,
      Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
    VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
    new ParameterPointListBuilder()
        .temperature(Temperature.span(Temperature.WARM, Temperature.NEUTRAL))
        .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.DRY))
        .continentalness(Continentalness.INLAND)
        .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
        .depth(Depth.FULL_RANGE)
        .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
        .build().forEach(point -> builder.add(point, LunaBiomes.COMMAND_FOREST));

    new ParameterPointListBuilder()
        .temperature(Temperature.span(Temperature.HOT, Temperature.WARM))
        .humidity(Humidity.span(Humidity.DRY, Humidity.ARID))
        .continentalness(Continentalness.INLAND)
        .erosion(Erosion.EROSION_0, Erosion.EROSION_6)
        .depth(Depth.FULL_RANGE)
        .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
        .build().forEach(point -> builder.add(point, LunaBiomes.COMMAND_SAVANNAH));

    new ParameterPointListBuilder()
        .temperature(Temperature.span(Temperature.ICY, Temperature.FROZEN))
        .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.HUMID))
        .continentalness(Continentalness.INLAND)
        .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
        .depth(Depth.FULL_RANGE)
        .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
        .build().forEach(point -> builder.add(point, LunaBiomes.COMMAND_SNOWY));

    builder.build().forEach(mapper);
  }
}