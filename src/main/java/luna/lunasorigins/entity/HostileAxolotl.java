package luna.lunasorigins.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import java.util.Optional;

public class HostileAxolotl extends AxolotlEntity {

  public HostileAxolotl(EntityType<? extends AxolotlEntity> entityType, World world) {
    super(entityType, world);
  }

  protected static final ImmutableList<? extends SensorType<? extends Sensor<? super AxolotlEntity>>> SENSORS = ImmutableList
      .of(LunaSensorType.HOSTILE_AXOLOTL_ATTACKABLES);

  public static DefaultAttributeContainer.Builder createHostileAxolotlAttributes() {
    return MobEntity.createMobAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
        .add(EntityAttributes.GENERIC_ARMOR, 10.0);
  }

  @Override
  protected Brain.Profile<AxolotlEntity> createBrainProfile() {
    return Brain.createProfile(MEMORY_MODULES, SENSORS);
  }

  @Override
  public void mobTick() {
    super.mobTick();
    // Custom attack logic using NEAREST_ATTACKABLE memory
    Optional<LivingEntity> targetOpt = this.getBrain().getOptionalMemory(MemoryModuleType.NEAREST_ATTACKABLE);
    if (targetOpt.isPresent()) {
      LivingEntity target = targetOpt.get();
      if (this.canSee(target) && this.squaredDistanceTo(target) < 4.0) { // within attack range
        this.tryAttack(target);
      } else {
        this.getNavigation().startMovingTo(target, 1.2);
      }
    }
  }

}