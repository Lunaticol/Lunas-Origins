package luna.lunasorigins.effects;

import java.util.UUID;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class LunaCorruptedEffect extends StatusEffect {

  private static final UUID WEAKNESS_MODIFIER_ID = UUID.fromString("e3b3a6c1-7c1f-4d5b-8a72-5e96a44d9b13");
  private static final UUID SLOWNESS_MODIFIER_ID = UUID.fromString("a6f72f51-8e53-4f9a-ae30-2f3a0d9c6b9b");

  public LunaCorruptedEffect(StatusEffectCategory category, int color) {
    super(category, color);
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true;
  }

  @Override
  public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    if (entity.getWorld().isClient)
      if (entity instanceof PlayerEntity player) {
        player.setSprinting(false);
      }

    EntityAttributeInstance attackDamage = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    EntityAttributeInstance movementSpeed = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

    if (attackDamage != null && attackDamage.getModifier(WEAKNESS_MODIFIER_ID) == null) {
      attackDamage.addPersistentModifier(new EntityAttributeModifier(
          WEAKNESS_MODIFIER_ID, "Corruption Weakness", -(1.0 + amplifier), EntityAttributeModifier.Operation.ADDITION));
    }

    if (movementSpeed != null && movementSpeed.getModifier(SLOWNESS_MODIFIER_ID) == null) {
      movementSpeed.addPersistentModifier(new EntityAttributeModifier(
          SLOWNESS_MODIFIER_ID, "Corruption Slowness", -0.05 * (amplifier + 1),
          EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }
  }

  @Override
  public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
    if (entity.getWorld().isClient)
      return;

    EntityAttributeInstance attackDamage = attributes.getCustomInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    EntityAttributeInstance movementSpeed = attributes.getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

    if (attackDamage != null && attackDamage.getModifier(WEAKNESS_MODIFIER_ID) != null) {
      attackDamage.removeModifier(WEAKNESS_MODIFIER_ID);
    }

    if (movementSpeed != null && movementSpeed.getModifier(SLOWNESS_MODIFIER_ID) != null) {
      movementSpeed.removeModifier(SLOWNESS_MODIFIER_ID);
    }
  }
}
