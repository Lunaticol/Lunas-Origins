package luna.lunasorigins.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class LunaEntityTags {
  public static final TagKey<EntityType<?>> HOSTILE_AXOLOTL_HUNT_TARGETS = TagKey.of(
      RegistryKeys.ENTITY_TYPE,
      new Identifier("lunasorigins", "hostile_axolotl_hunt_targets"));
  public static final TagKey<EntityType<?>> HOSTILE_AXOLOTL_ALWAYS_HOSTILES = TagKey.of(
      RegistryKeys.ENTITY_TYPE,
      new Identifier("lunasorigins", "hostile_axolotl_always_hostiles"));

  public static void initialize() {
  }
}
