package luna.lunasorigins.particle;

import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

import luna.lunasorigins.LunaParticles;
import luna.lunasorigins.mixin.client.ContinuousFallingAccessor;
import luna.lunasorigins.mixin.client.DrippingAccessor;
import luna.lunasorigins.mixin.client.LandingAccessor;

public class ModParticleFactories {

  public static BlockLeakParticle.Dripping createDrippingBlueObsidianTear(@Nullable BlockLeakParticle.Dripping dripping,
      DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX,
      double velocityY, double velocityZ) {
    if (dripping == null)
      dripping = DrippingAccessor.newDripping(world, x, y, z, Fluids.EMPTY, LunaParticles.BLUE_FALLING_OBSIDIAN_TEAR);
    dripping.obsidianTear = true;
    dripping.gravityStrength *= 0.01F;
    dripping.maxAge = 100;
    dripping.setColor(0.34509803921f, 0.25098039215f, 0.92156862745f);
    return dripping;
  }

  public static BlockLeakParticle.ContinuousFalling createFallingBlueObsidianTear(
      @Nullable BlockLeakParticle.ContinuousFalling falling, DefaultParticleType type, ClientWorld world,
      double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
    if (falling == null)
      falling = ContinuousFallingAccessor.newFalling(world, x, y, z, Fluids.EMPTY,
          LunaParticles.BLUE_LANDING_OBSIDIAN_TEAR);
    falling.obsidianTear = true;
    falling.gravityStrength = 0.01F;
    falling.setColor(0.34509803921f, 0.25098039215f, 0.92156862745f);
    return falling;
  }

  public static BlockLeakParticle.Landing createLandingBlueObsidianTear(@Nullable BlockLeakParticle.Landing landing,
      DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX,
      double velocityY, double velocityZ) {
    if (landing == null)
      landing = LandingAccessor.newLanding(world, x, y, z, Fluids.EMPTY);
    landing.obsidianTear = true;
    landing.maxAge = (int) (28.0 / (Math.random() * 0.8 + 0.2));
    landing.setColor(0.34509803921f, 0.25098039215f, 0.92156862745f);
    return landing;
  }

  public static class LandingBlueObsidianTearFactory implements ParticleFactory<DefaultParticleType> {
    protected final SpriteProvider spriteProvider;

    public LandingBlueObsidianTearFactory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    @Override
    public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld world, double x, double y,
        double z, double velocityX, double velocityY, double velocityZ) {
      BlockLeakParticle.Landing landing = LandingAccessor.newLanding(world, x, y, z, Fluids.EMPTY);
      landing.setSprite(this.spriteProvider);
      landing = ModParticleFactories.createLandingBlueObsidianTear(landing, defaultParticleType, world, x, y, z,
          velocityX, velocityY, velocityZ);
      return landing;
    }
  }

  public static class FallingBlueObsidianTearFactory implements ParticleFactory<DefaultParticleType> {
    protected final SpriteProvider spriteProvider;

    public FallingBlueObsidianTearFactory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    @Override
    public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld world, double x, double y,
        double z, double velocityX, double velocityY, double velocityZ) {
      BlockLeakParticle.ContinuousFalling falling = ModParticleFactories.createFallingBlueObsidianTear(null,
          defaultParticleType, world, x, y, z, velocityX, velocityY, velocityZ);
      falling.setSprite(this.spriteProvider);
      return falling;
    }
  }

  public static class DrippingBlueObsidianTearFactory implements ParticleFactory<DefaultParticleType> {
    protected final SpriteProvider spriteProvider;

    public DrippingBlueObsidianTearFactory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    @Override
    public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld world, double x, double y,
        double z, double velocityX, double velocityY, double velocityZ) {
      BlockLeakParticle.Dripping dripping = ModParticleFactories.createDrippingBlueObsidianTear(null,
          defaultParticleType,
          world, x, y, z, velocityX, velocityY, velocityZ);
      dripping.setSprite(this.spriteProvider);
      return dripping;
    }
  }

}