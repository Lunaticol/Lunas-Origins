package luna.lunasorigins.entity;

import java.util.function.Supplier;

import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LunaSensorType<U extends Sensor<?>> {
  public static final SensorType<HostileAxolotlAttackables> HOSTILE_AXOLOTL_ATTACKABLES = register(
      "hostile_axolotl_attackables",
      HostileAxolotlAttackables::new);

  private final Supplier<U> factory;

  public LunaSensorType(Supplier<U> factory) {
    this.factory = factory;
  }

  public U create() {
    return (U) this.factory.get();
  }

  private static <U extends Sensor<?>> SensorType<U> register(String id, Supplier<U> factory) {
    return Registry.register(Registries.SENSOR_TYPE, new Identifier(id), new SensorType<>(factory));
  }

  public static void initialize() {
  }
}
