package luna.lunasorigins.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class HostileAxolotl extends AxolotlEntity {

  public HostileAxolotl(EntityType<? extends AxolotlEntity> entityType, World world) {
    super(entityType, world);
  }

  protected static final ImmutableList<? extends SensorType<? extends Sensor<? super HostileAxolotl>>> SENSORS = ImmutableList
      .of(
          SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_ADULT, SensorType.HURT_BY,
          LunaSensorType.HOSTILE_AXOLOTL_ATTACKABLES, SensorType.AXOLOTL_TEMPTATIONS);

  protected MemoryModuleType<LivingEntity> getOutputMemoryModule() {
    return MemoryModuleType.ATTACK_TARGET;
  }

  public static DefaultAttributeContainer.Builder createHostileAxolotlAttributes() {
    return MobEntity.createMobAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0);
  }

  protected Brain.Profile<HostileAxolotl> createHostileAxolotlBrain() {
    return Brain.createProfile(MEMORY_MODULES, SENSORS);
  }

  @Override
  public void tick() {
    super.tick();
    this.getBrain().tick((ServerWorld) this.getWorld(), this);
  }
}