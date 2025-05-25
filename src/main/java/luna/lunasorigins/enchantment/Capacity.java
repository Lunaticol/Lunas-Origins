package luna.lunasorigins.enchantment;

import luna.lunasorigins.items.Pistol;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class Capacity extends Enchantment {

  public Capacity() {
    super(Rarity.UNCOMMON, PistolToolEnchantmentTarget.PISTOL, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
  }

  @Override
  public int getMaxLevel() {
    return 3;
  }

  @Override
  public int getMinPower(int level) {
    return 10 + (level - 1) * 10;
  }

  @Override
  public int getMaxPower(int level) {
    return this.getMinPower(level) + 15;
  }

  public boolean isTreasureOnly() {
    return false;
  }

  public boolean isTradeable() {
    return true;
  }

  public boolean isDiscoverable() {
    return true;
  }

  @Override
  public boolean isAcceptableItem(ItemStack stack) {
    return stack.getItem() instanceof Pistol;
  }

  public boolean canApplyAtEnchantingTable(ItemStack stack) {
    return stack.getItem() instanceof Pistol;
  }

  public boolean canApply(ItemStack stack) {
    return stack.getItem() instanceof Pistol;
  }

}
