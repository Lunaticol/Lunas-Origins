package luna.lunasorigins.origin;

import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import luna.lunasorigins.origin.powers.GlowingPower;
import net.minecraft.registry.Registry;

public class LunaPowerFactory {
  public static void register() {
    register(GlowingPower.createPowerFactory());
  }

  private static void register(PowerFactory<?> powerFactory) {
    Registry.register(ApoliRegistries.POWER_FACTORY, powerFactory.getSerializerId(), powerFactory);
  }
}
