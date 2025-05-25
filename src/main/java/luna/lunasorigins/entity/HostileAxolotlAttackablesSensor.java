package luna.lunasorigins.entity;

import luna.lunasorigins.LunasOrigins;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.NearestVisibleLivingEntitySensor;
import net.minecraft.entity.ai.brain.sensor.Sensor;

public class HostileAxolotlAttackablesSensor extends NearestVisibleLivingEntitySensor {
  public static final float TARGET_RANGE = 8.0F;

  @Override
  protected boolean matches(LivingEntity entity, LivingEntity target) {
    LunasOrigins.LOGGER.info("Checking if {} matches {}.", entity.getName().getString(), target.getName().getString());
    return this.isInRange(entity, target)
        && (this.isAlwaysHostileTo(target) || this.canHunt(entity, target))
        && Sensor.testAttackableTargetPredicate(entity, target);
  }

  private boolean canHunt(LivingEntity axolotl, LivingEntity target) {
    return !axolotl.getBrain().hasMemoryModule(MemoryModuleType.HAS_HUNTING_COOLDOWN)
        && target.getType().isIn(LunaEntityTypeTags.HOSTILE_AXOLOTL_HUNT_TARGETS);
  }

  protected boolean isAlwaysHostileTo(LivingEntity target) {
    return target.getType().isIn(LunaEntityTypeTags.HOSTILE_AXOLOTL_ALWAYS_HOSTILES);
  }

  private boolean isInRange(LivingEntity axolotl, LivingEntity target) {
    return target.squaredDistanceTo(axolotl) <= 64.0;
  }

  @Override
  protected MemoryModuleType<LivingEntity> getOutputMemoryModule() {
    return MemoryModuleType.NEAREST_ATTACKABLE;
  }
}
