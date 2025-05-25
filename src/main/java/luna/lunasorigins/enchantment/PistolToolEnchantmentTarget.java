package luna.lunasorigins.enchantment;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.enchantment.EnchantmentTarget;

//The only reason this exists is because I can't put the field in the main class for whatever reason. Go figure.
public interface PistolToolEnchantmentTarget {

  /**
   * Allows the custom enum to be used as an EnchantmentTarget.
   */
  EnchantmentTarget PISTOL = ClassTinkerers.getEnum(EnchantmentTarget.class, "PISTOL");
}