package luna.lunasorigins.enchantment;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.Item;

@Mixin(EnchantmentTarget.class)
abstract class EnchantmentTargetMixin {
  @Shadow
  abstract boolean isAcceptableItem(Item item);
}
