package luna.lunasorigins;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import luna.lunasorigins.effects.LunaCorruptedEffect;
import luna.lunasorigins.effects.SoulTunedEffect;
import luna.lunasorigins.entity.LunaEntities;
import luna.lunasorigins.entity.LunaEntityTypeTags;
import luna.lunasorigins.entity.LunaSensorType;
import luna.lunasorigins.entity.LunaSpawnRestrict;

public class LunasOrigins implements ModInitializer {

  // State Mod ID
  public static final String MOD_ID = "lunasorigins";
  // Logger
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
  // Particle

  // Effect
  public static final StatusEffect SOUL_TUNED_EFFECT;
  public static final StatusEffect LUNA_CORRUPTION;

  static {
    SOUL_TUNED_EFFECT = Registry.register(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "soul_tuned"),
        new SoulTunedEffect(StatusEffectCategory.BENEFICIAL, 0x60f5fa));
  }

  static {
    LUNA_CORRUPTION = Registry.register(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "corruption"),
        new LunaCorruptedEffect(StatusEffectCategory.HARMFUL, 0xcc9ad7));
  }

  @Override
  public void onInitialize() {

    LunaItems.initialize();
    LunaBlocks.initialize();
    SoulTunedEffect.initialize();
    LunaEvent.initialize();
    LunaEntities.registerEntities();
    LunaSpawnRestrict.registerSpawnRestriction();
    LunaSounds.initialize();
    LunaParticles.initalize();
    LunaSensorType.registerSensors();
    LunaEntityTypeTags.registerEntityTags();
    LOGGER.info("Wow I have a mod now this is great");

  }
}