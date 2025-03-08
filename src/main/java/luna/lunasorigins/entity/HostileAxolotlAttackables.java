package luna.lunasorigins.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.AxolotlAttackablesSensor;
import net.minecraft.entity.ai.brain.sensor.Sensor;

public class HostileAxolotlAttackables extends AxolotlAttackablesSensor {
  public static final float TARGET_RANGE = 12.0F;

  @Override
  protected boolean matches(LivingEntity entity, LivingEntity target) {
    return this.isInRange(entity, target)
        && (this.isAlwaysHostileTo(target) || this.canHunt(entity, target))
        && Sensor.testAttackableTargetPredicate(entity, target);
  }

  private boolean canHunt(LivingEntity hostileAxolotl, LivingEntity target) {
    return !hostileAxolotl.getBrain().hasMemoryModule(MemoryModuleType.HAS_HUNTING_COOLDOWN)
        && target.getType().isIn(LunaEntityTags.HOSTILE_AXOLOTL_HUNT_TARGETS);
  }

  private boolean isAlwaysHostileTo(LivingEntity target) {
    return target.getType().isIn(LunaEntityTags.HOSTILE_AXOLOTL_ALWAYS_HOSTILES);
  }

  private boolean isInRange(LivingEntity hostileAxolotl, LivingEntity target) {
    return target.squaredDistanceTo(hostileAxolotl) <= 64.0;
  }

  @Override
  protected MemoryModuleType<LivingEntity> getOutputMemoryModule() {
    return MemoryModuleType.NEAREST_ATTACKABLE;
  }
}