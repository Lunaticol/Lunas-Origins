package luna.lunasorigins.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import luna.lunasorigins.items.Pistol;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> {

  @Shadow
  public BipedEntityModel.ArmPose rightArmPose;
  @Shadow
  public BipedEntityModel.ArmPose leftArmPose;

  @Inject(method = "positionRightArm", at = @At("HEAD"))
  private void applyPistolPoseRight(T entity, CallbackInfo ci) {
    if (entity.getActiveItem().getItem() instanceof Pistol) {
      this.rightArmPose = BipedEntityModel.ArmPose.CROSSBOW_HOLD;
    }
  }

  @Inject(method = "positionLeftArm", at = @At("HEAD"))
  private void applyPistolPoseLeft(T entity, CallbackInfo ci) {
    if (entity.getActiveItem().getItem() instanceof Pistol) {
      this.leftArmPose = BipedEntityModel.ArmPose.CROSSBOW_HOLD;
    }
  }

  @Inject(method = "setAngles", at = @At("HEAD"))
  private void applyPistolPoseToArms(
      T entity, float limbAngle, float limbDistance,
      float animationProgress, float headYaw, float headPitch,
      CallbackInfo ci) {
    if (entity.getActiveItem().getItem() instanceof Pistol) {
      if (entity.getMainArm() == Arm.RIGHT) {
        this.rightArmPose = BipedEntityModel.ArmPose.CROSSBOW_HOLD;
      } else {
        this.leftArmPose = BipedEntityModel.ArmPose.CROSSBOW_HOLD;
      }
    }
  }
}
