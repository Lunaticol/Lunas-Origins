// Based on EmissivePower by Provismet, licensed under the Lily License v1.1
// https://github.com/Provismet/Provi-Origins/blob/1.20.4/src/main/java/com/provismet/proviorigins/powers/EmissivePower.java
// Don't kill me for this, I just needed a glowing power and this was the best way to do it. I also do not know how to do this any other way.

package luna.lunasorigins.origin.powers;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import luna.lunasorigins.LunasOrigins;
import net.minecraft.entity.LivingEntity;

public class GlowingPower extends Power {
  public static final String GLOW = "glow";

  public final int glow;

  public GlowingPower(PowerType<?> type, LivingEntity entity, int glow) {
    super(type, entity);
    this.glow = glow;
  }

  public static PowerFactory createPowerFactory() {
    return new PowerFactory<>(LunasOrigins.identifier("glowing"),
        new SerializableData()
            .add(GLOW, SerializableDataTypes.INT),
        data -> (type, player) -> new GlowingPower(type, player,
            data.getInt(GLOW)))
                .allowCondition();
  }

}