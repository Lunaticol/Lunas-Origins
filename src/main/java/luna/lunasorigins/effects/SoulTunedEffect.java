package luna.lunasorigins.effects;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class SoulTunedEffect extends StatusEffect {
    private static final UUID SOUL_SPEED_BOOST_ID = UUID.fromString("11111111-1111-1111-1111-111111111111");

    public SoulTunedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        BlockPos pos = entity.getBlockPos();

        boolean onSoulBlock = world.getBlockState(pos.down()).isOf(net.minecraft.block.Blocks.SOUL_SAND) ||
                world.getBlockState(pos.down()).isOf(net.minecraft.block.Blocks.SOUL_SOIL);

        // Get the remaining duration of the effect
        int remainingDuration = entity.getStatusEffect(this).getDuration();

        // If near the end of the effect, remove the speed boost early
        if (remainingDuration <= 20) { // 1 second before the effect ends
            removeSpeedBoost(entity);
        } else if (onSoulBlock) {
            applySpeedBoost(entity, amplifier);
        } else {
            removeSpeedBoost(entity); // Remove if not on soul blocks
        }
    }

    private void applySpeedBoost(LivingEntity entity, int amplifier) {
        if (entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                .getModifier(SOUL_SPEED_BOOST_ID) == null) {

            double boostMultiplier = 0.1 + (amplifier * 0.05);

            EntityAttributeModifier speedBoost = new EntityAttributeModifier(
                    SOUL_SPEED_BOOST_ID,
                    "Soul Tuned",
                    boostMultiplier,
                    EntityAttributeModifier.Operation.ADDITION);

            entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                    .addPersistentModifier(speedBoost);
        }
    }

    private void removeSpeedBoost(LivingEntity entity) {
        if (entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                .getModifier(SOUL_SPEED_BOOST_ID) != null) {
            entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                    .removeModifier(SOUL_SPEED_BOOST_ID);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Ensure the effect updates every tick
        return true;
    }

    public static void initialize() {
    }
}
