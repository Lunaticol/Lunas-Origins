
package luna.lunasorigins.enchantment;

import luna.lunasorigins.items.Pistol;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class RapidFire extends Enchantment {

  public RapidFire() {
    super(Rarity.RARE, PistolToolEnchantmentTarget.PISTOL, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
  }

  @Override
  public int getMinPower(int level) {
    return 10 + (level - 1) * 10;
  }

  @Override
  public int getMaxPower(int level) {
    return this.getMinPower(level) + 15;
  }

  @Override
  public int getMaxLevel() {
    return 3;
  }

  public boolean isTreasureOnly() {
    return true;
  }

  public boolean isTradeable() {
    return false;
  }

  public boolean isDiscoverable() {
    return false;
  }

  @Override
  public boolean isAcceptableItem(ItemStack stack) {
    return stack.getItem() instanceof Pistol;
  }

}
