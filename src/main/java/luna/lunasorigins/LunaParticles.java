package luna.lunasorigins;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LunaParticles {

  public static final String MOD_ID = "lunasorigins";

  public static final DefaultParticleType RED_FLAME = register("red_flame", false);
  public static final DefaultParticleType YELLOW_FLAME = register("yellow_flame", false);
  public static final DefaultParticleType GREEN_FLAME = register("green_flame", false);
  public static final DefaultParticleType BLUE_FLAME = register("blue_flame", false);
  public static final DefaultParticleType PURPLE_FLAME = register("purple_flame", false);
  public static final DefaultParticleType WHITE_FLAME = register("white_flame", false);
  public static final DefaultParticleType BLUE_DRIPPING_OBSIDIAN_TEAR = register("blue_dripping_obsidian_tear", false);
  public static final DefaultParticleType BLUE_FALLING_OBSIDIAN_TEAR = register("blue_falling_obsidian_tear", false);
  public static final DefaultParticleType BLUE_LANDING_OBSIDIAN_TEAR = register("blue_landing_obsidian_tear", false);
  public static final DefaultParticleType BLUE_SPARK = register("blue_spark", false);
  public static final DefaultParticleType ORANGE_SPARK = register("orange_spark", false);
  public static final DefaultParticleType GEM_SPARK = register("gem_spark", false);

  private static DefaultParticleType register(String name, boolean alwaysShow) {
    return Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, name),
        FabricParticleTypes.simple(alwaysShow));
  }

  public static void initalize() {

  }
}
