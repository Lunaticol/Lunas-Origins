package luna.lunasorigins;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import luna.lunasorigins.effects.SoulTunedEffect;

public class LunasOrigins implements ModInitializer {

  // State Mod ID
  public static final String MOD_ID = "lunasorigins";
  // Logger
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
  // Particle
  public static final DefaultParticleType PURPLE_FLAME = FabricParticleTypes.simple();
  public static final DefaultParticleType GREEN_FLAME = FabricParticleTypes.simple();
  public static final DefaultParticleType RED_FLAME = FabricParticleTypes.simple();
  public static final DefaultParticleType YELLOW_FLAME = FabricParticleTypes.simple();
  public static final DefaultParticleType BLUE_FLAME = FabricParticleTypes.simple();

  // Effect
  public static final StatusEffect SOUL_TUNED_EFFECT;

  static {
    SOUL_TUNED_EFFECT = Registry.register(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "soul_tuned"),
        new SoulTunedEffect(StatusEffectCategory.BENEFICIAL, 0));
  }

  @Override
  public void onInitialize() {
    Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "purple_flame"), PURPLE_FLAME);
    Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "green_flame"), GREEN_FLAME);
    Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "red_flame"), RED_FLAME);
    Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "yellow_flame"), YELLOW_FLAME);
    Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "blue_flame"), BLUE_FLAME);
    LunaItems.initialize();
    LunaBlocks.initialize();
    SoulTunedEffect.initialize();
    LunaEvent.initialize();
    // Use the Registerable API for ConfiguredFeature
    LOGGER.info("Wow I have a mod now this is great");

  }
}