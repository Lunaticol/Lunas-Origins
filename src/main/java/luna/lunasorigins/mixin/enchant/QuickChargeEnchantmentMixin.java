package luna.lunasorigins.mixin.enchant;

import luna.lunasorigins.items.Pistol;
import net.minecraft.enchantment.QuickChargeEnchantment;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;

@Mixin(QuickChargeEnchantment.class)
public class QuickChargeEnchantmentMixin {

  public boolean isAcceptableItem(ItemStack stack) {
    return stack.getItem() instanceof Pistol || stack.getItem() == net.minecraft.item.Items.CROSSBOW;
  }
}