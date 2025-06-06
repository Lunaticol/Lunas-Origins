package luna.lunasorigins.worldgen;

import luna.lunasorigins.LunasOrigins;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class LunaBiomes {

  public static final RegistryKey<Biome> COMMAND_FOREST = RegistryKey.of(RegistryKeys.BIOME,
      new Identifier(LunasOrigins.MOD_ID, "command_forest"));
  public static final RegistryKey<Biome> COMMAND_SAVANNAH = RegistryKey.of(RegistryKeys.BIOME,
      new Identifier(LunasOrigins.MOD_ID, "command_savannah"));
  public static final RegistryKey<Biome> COMMAND_SNOWY = RegistryKey.of(RegistryKeys.BIOME,
      new Identifier(LunasOrigins.MOD_ID, "command_snowy"));
  // public static final RegistryKey<Biome> CONCORD_GROVE = RegistryKey.of(RegistryKeys.BIOME,
  //   new Identifier(LunasOrigins.MOD_ID, "concord_grove"));

  public static void bootstrap(Registerable<Biome> context) {
    context.register(COMMAND_FOREST, new Biome.Builder().build());
    context.register(COMMAND_SAVANNAH, new Biome.Builder().build());
    context.register(COMMAND_SNOWY, new Biome.Builder().build());
    //context.register(CONCORD_GROVE, new Biome.Builder().build());
  }
}
