package luna.lunasorigins.entity;

import luna.lunasorigins.LunasOrigins;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class LunaEntityTypeTags {

  public static final TagKey<EntityType<?>> HOSTILE_AXOLOTL_ALWAYS_HOSTILES = of("hostile_axolotl_always_hostiles");
  public static final TagKey<EntityType<?>> HOSTILE_AXOLOTL_HUNT_TARGETS = of("hostile_axolotl_hunt_targets");

  private LunaEntityTypeTags() {
  }

  private static TagKey<EntityType<?>> of(String id) {
    return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(LunasOrigins.MOD_ID, id));
  }

  public static void registerEntityTags() {
  }

}
