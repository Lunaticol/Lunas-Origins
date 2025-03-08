package luna.lunasorigins.entity;

import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;

public class LunaSpawnRestrict extends SpawnRestriction {

  public static void registerSpawnRestriction() {
    SpawnRestriction.register(LunaEntities.CRIMSON_PHANTOM, SpawnRestriction.Location.NO_RESTRICTIONS,
        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

  }

}