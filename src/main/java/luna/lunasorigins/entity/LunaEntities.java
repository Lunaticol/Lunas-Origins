package luna.lunasorigins.entity;

import luna.lunasorigins.LunasOrigins;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LunaEntities {

  public static final String MOD_ID = "lunasorigins";

  public static final EntityType<PhantomEntity> CRIMSON_PHANTOM = Registry.register(
      Registries.ENTITY_TYPE,
      new Identifier(MOD_ID, "crimson_phantom"),
      EntityType.Builder.create(PhantomEntity::new, SpawnGroup.MONSTER)
          .setDimensions(1F, 0.5F)
          .build("crimson_phantom"));

  public static final EntityType<AxolotlEntity> HOSTILE_AXOLOTL = Registry.register(
      Registries.ENTITY_TYPE,
      new Identifier(MOD_ID, "hostile_axolotl"),
      EntityType.Builder.create(AxolotlEntity::new, SpawnGroup.MONSTER)
          .setDimensions(0.75F, 0.42F)
          .build("hostile_axolotl"));

  public static void registerEntities() {
    LunasOrigins.LOGGER.info("The Beasts...");
    FabricDefaultAttributeRegistry.register(CRIMSON_PHANTOM, CrimsonPhantom.createCrimsonPhantomAttributes());
    FabricDefaultAttributeRegistry.register(HOSTILE_AXOLOTL, HostileAxolotl.createHostileAxolotlAttributes());
  }
}
