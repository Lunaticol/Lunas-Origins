package luna.lunasorigins.entity;

import luna.lunasorigins.LunasOrigins;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LunaSensorType<U extends Sensor<?>> {

  public static final SensorType<HostileAxolotlAttackablesSensor> HOSTILE_AXOLOTL_ATTACKABLES = Registry.register(
      Registries.SENSOR_TYPE,
      new Identifier("lunasorigins", "hostile_axolotl_attackables"),
      new SensorType<>(HostileAxolotlAttackablesSensor::new));

  public static void registerSensors() {
    LunasOrigins.LOGGER.info("They're sensing alright...");
  }
}
