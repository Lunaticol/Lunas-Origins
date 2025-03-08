package luna.lunasorigins.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.world.World;

public class CrimsonPhantom extends PhantomEntity {

  public CrimsonPhantom(EntityType<? extends PhantomEntity> entityType, World world) {
    super(entityType, world);
  }

  public static DefaultAttributeContainer.Builder createCrimsonPhantomAttributes() {
    return MobEntity.createMobAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
  }

  @Override
  protected void initGoals() {
    super.initGoals();
  }

}
