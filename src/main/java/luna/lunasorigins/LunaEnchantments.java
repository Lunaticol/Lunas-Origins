package luna.lunasorigins;

import luna.lunasorigins.enchantment.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LunaEnchantments {

  public static Enchantment CAPACITY = register("capacity", new Capacity());
  public static Enchantment RAPID_FIRE = register("rapid_fire", new RapidFire());

  private static Enchantment register(String name, Enchantment enchantment) {
    return Registry.register(Registries.ENCHANTMENT, new Identifier("lunasorigins", name), enchantment);
  }

  public static void initalizeLunaEnchantments() {
    System.out.println("We out here enchanting alright...");
  }
}
