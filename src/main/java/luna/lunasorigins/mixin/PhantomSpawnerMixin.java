package luna.lunasorigins.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.ServerStatHandler;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.spawner.PhantomSpawner;
import net.minecraft.world.spawner.Spawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import luna.lunasorigins.entity.CrimsonPhantom;
import luna.lunasorigins.entity.LunaEntities;

@Mixin(PhantomSpawner.class)
public abstract class PhantomSpawnerMixin implements Spawner {

  private int cooldown;

  @Inject(method = "spawn", at = @At("HEAD"), cancellable = true)
  private void modifyPhantomSpawning(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals,
      CallbackInfoReturnable<Integer> cir) {
    if (!spawnMonsters || !world.getGameRules().getBoolean(GameRules.DO_INSOMNIA)) {
      return;
    }
    Random random = world.random;
    this.cooldown--;
    if (this.cooldown > 0) {
      return;
    }
    // (60 + random.nextInt(60)) * 20 ticks
    this.cooldown = (60 + random.nextInt(60)) * 20;
    if (world.getAmbientDarkness() < 5 && world.getDimension().hasSkyLight()) {
      return;
    }
    int spawnCount = 0;
    for (ServerPlayerEntity player : world.getPlayers()) {
      if (!player.isSpectator()) {
        BlockPos playerPos = player.getBlockPos();
        if (!world.getDimension().hasSkyLight()
            || (playerPos.getY() >= world.getSeaLevel() && world.isSkyVisible(playerPos))) {
          LocalDifficulty difficulty = world.getLocalDifficulty(playerPos);
          if (difficulty.isHarderThan(random.nextFloat() * 3.0F))
            if (!world.isClient) {
              ServerStatHandler stats = ((ServerPlayerEntity) player).getStatHandler();
              int timeSinceRest = MathHelper.clamp(stats.getStat(Stats.CUSTOM.getOrCreateStat(Stats.TIME_SINCE_REST)),
                  1,
                  Integer.MAX_VALUE);
              if (timeSinceRest >= 72000) {
                System.out.println("timeSinceRest: " + timeSinceRest);
                BlockPos spawnPos = playerPos.up(20 + random.nextInt(15))
                    .east(-10 + random.nextInt(21))
                    .south(-10 + random.nextInt(21));
                BlockState blockState = world.getBlockState(spawnPos);
                FluidState fluidState = world.getFluidState(spawnPos);
                if (SpawnHelper.isClearForSpawn(world, spawnPos, blockState, fluidState, EntityType.PHANTOM)) {
                  EntityData entityData = null;
                  int groupSize = 1 + random.nextInt(difficulty.getGlobalDifficulty().getId() + 1);
                  for (int m = 0; m < groupSize; m++) {
                    // If player hasn't slept for 8 days (8*24000), spawn Crimson Phantoms.
                    if (timeSinceRest >= 192000) {
                      CrimsonPhantom crimsonPhantom = new CrimsonPhantom(LunaEntities.CRIMSON_PHANTOM, world);
                      if (crimsonPhantom != null) {
                        crimsonPhantom.refreshPositionAndAngles(spawnPos, 0.0F, 0.0F);
                        entityData = crimsonPhantom.initialize(world, difficulty, SpawnReason.NATURAL, entityData,
                            null);
                        world.spawnEntityAndPassengers(crimsonPhantom);
                        spawnCount++;
                        System.out.println("timeSinceRest: " + timeSinceRest + ", spawning Crimson Phantom.");
                      }
                    } else {
                      PhantomEntity phantom = EntityType.PHANTOM.create(world);
                      System.out.println("timeSinceRest: " + timeSinceRest + ", spawning Phantom.");
                      if (phantom != null) {
                        phantom.refreshPositionAndAngles(spawnPos, 0.0F, 0.0F);
                        entityData = phantom.initialize(world, difficulty, SpawnReason.NATURAL, entityData, null);
                        world.spawnEntityAndPassengers(phantom);
                        spawnCount++;
                      }
                    }
                  }
                }
              }
            }
        }
      }
    }
    cir.setReturnValue(spawnCount);
  }
}
