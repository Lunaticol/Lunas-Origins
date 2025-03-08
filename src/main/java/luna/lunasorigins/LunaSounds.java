package luna.lunasorigins;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class LunaSounds {

  public static final SoundEvent COMMAND_FOREST_AMBIENCE = registerSound("command_forest_ambience");

  private static SoundEvent registerSound(String id) {
    Identifier identifier = Identifier.of(LunasOrigins.MOD_ID, id);
    return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
  }

  public static void initialize() {
    LunasOrigins.LOGGER.info("The Voices....");
  }

}