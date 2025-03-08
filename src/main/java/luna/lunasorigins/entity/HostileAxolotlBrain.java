package luna.lunasorigins.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Dynamic;

import java.util.Optional;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AxolotlBrain;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.ForgetAttackTargetTask;
import net.minecraft.entity.ai.brain.task.MeleeAttackTask;
import net.minecraft.entity.ai.brain.task.RangedApproachTask;
import net.minecraft.entity.ai.brain.task.UpdateAttackTargetTask;

public class HostileAxolotlBrain extends AxolotlBrain {

  private static Optional<? extends LivingEntity> getCustomAttackTarget(HostileAxolotl axolotl) {
    return axolotl.getBrain()
        .getOptionalRegisteredMemory(MemoryModuleType.NEAREST_ATTACKABLE)
        .filter(target -> target.getType().isIn(LunaEntityTags.HOSTILE_AXOLOTL_HUNT_TARGETS));
  }

  private static float getTargetApproachingSpeed(LivingEntity entity) {
    return entity.isInsideWaterOrBubbleColumn() ? 0.6F : 0.15F;
  }

  public static void addFightActivities(Brain<HostileAxolotl> brain) {
    brain.setTaskList(
        Activity.FIGHT,
        0,
        ImmutableList.of(
            UpdateAttackTargetTask.create((axolotl) -> getCustomAttackTarget(axolotl)),
            RangedApproachTask.create(HostileAxolotlBrain::getTargetApproachingSpeed),
            MeleeAttackTask.create(20),
            ForgetAttackTargetTask.create()),
        MemoryModuleType.ATTACK_TARGET);
  }

  protected static Brain<?> createHostileAxolotlBrain(Brain<HostileAxolotl> brain) {
    addFightActivities(brain);
    brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
    brain.setDefaultActivity(Activity.IDLE);
    brain.resetPossibleActivities();
    return brain;
  }

  protected Brain.Profile<HostileAxolotl> createBrainProfile() {
    return Brain.createProfile(ImmutableList.of(), ImmutableList.of());
  }

  protected Brain<?> createBrain(Dynamic<?> dynamic) {
    Brain<HostileAxolotl> brain = this.createBrainProfile().deserialize(dynamic);
    return HostileAxolotlBrain.createHostileAxolotlBrain(brain);
  }

}
