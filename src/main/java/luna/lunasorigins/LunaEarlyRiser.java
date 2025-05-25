package luna.lunasorigins;

import com.chocohead.mm.api.ClassTinkerers;
import com.chocohead.mm.api.EnumAdder;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.util.Formatting;

public class LunaEarlyRiser implements Runnable, PreLaunchEntrypoint {
  private static boolean registered = false;

  @Override
  public void onPreLaunch() {
    run();
  }

  @Override
  public void run() {
    if (registered)
      return;
    registered = true;

    MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

    String enchantmentTarget = remapper.mapClassName("intermediary", "net.minecraft.class_1886");
    ClassTinkerers.enumBuilder(enchantmentTarget)
        .addEnumSubclass("PISTOL", "luna.lunasorigins.enchantment.LunaEnchantmentTarget")
        .build();

    String formattingInternalName = remapper.mapClassName("intermediary", "net.minecraft.class_124"); // Mapping for Formatting

    EnumAdder impactAdder = ClassTinkerers.enumBuilder(
        "io.github.apace100.origins.origin.Impact",
        "I",
        "Ljava/lang/String;",
        "L" + formattingInternalName + ";");

    impactAdder
        .addEnum("EXTREME", 4, "extreme", Formatting.LIGHT_PURPLE)
        .addEnum("BOSS", 5, "boss", Formatting.DARK_GRAY)
        .addEnum("CUSTOM", 6, "custom", Formatting.GOLD)
        .build();

  }
}