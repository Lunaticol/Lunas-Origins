package luna.lunasorigins.enchantment;

import luna.lunasorigins.items.Pistol;
import net.minecraft.item.Item;

public class LunaEnchantmentTarget extends EnchantmentTargetMixin {
  @Override
  public boolean isAcceptableItem(Item item) {
    return item instanceof Pistol;
  }
}
