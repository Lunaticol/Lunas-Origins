package luna.lunasorigins.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

public class ElectricSparkParticleFactory extends SpriteBillboardParticle {
  static final Random RANDOM = Random.create();
  private final SpriteProvider spriteProvider;

  ElectricSparkParticleFactory(ClientWorld world, double x, double y, double z, double velocityX, double velocityY,
      double velocityZ, SpriteProvider spriteProvider) {
    super(world, x, y, z, velocityX, velocityY, velocityZ);
    this.velocityMultiplier = 0.96F;
    this.ascending = true;
    this.spriteProvider = spriteProvider;
    this.scale *= 0.75F;
    this.collidesWithWorld = false;
    this.setSpriteForAge(spriteProvider);
  }

  @Override
  public ParticleTextureSheet getType() {
    return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
  }

  @Override
  public int getBrightness(float tint) {
    float f = ((float) this.age + tint) / (float) this.maxAge;
    f = MathHelper.clamp(f, 0.0F, 1.0F);
    int i = super.getBrightness(tint);
    int j = i & 0xFF;
    int k = i >> 16 & 0xFF;
    j += (int) (f * 15.0F * 16.0F);
    if (j > 240) {
      j = 240;
    }

    return j | k << 16;
  }

  @Override
  public void tick() {
    super.tick();
    this.setSpriteForAge(this.spriteProvider);
  }

  public static class BlueElectricSparkFactory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;

    public BlueElectricSparkFactory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e,
        double f, double g, double h, double i) {
      ElectricSparkParticleFactory glowParticle = new ElectricSparkParticleFactory(clientWorld, d, e, f, 0.0, 0.0, 0.0,
          this.spriteProvider);
      glowParticle.setColor(0.211764706F, 0.517647059F, 0.847058824F);
      glowParticle.setVelocity(g * 0.25, h * 0.25, i * 0.25);
      glowParticle.setMaxAge(clientWorld.random.nextInt(2) + 2);
      return glowParticle;
    }
  }

  public static class OrangeElectricSparkFactory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;

    public OrangeElectricSparkFactory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e,
        double f, double g, double h, double i) {
      ElectricSparkParticleFactory glowParticle = new ElectricSparkParticleFactory(clientWorld, d, e, f, 0.0, 0.0, 0.0,
          this.spriteProvider);
      glowParticle.setColor(0.847058824F, 0.466666667F, 0.211764706F);
      glowParticle.setVelocity(g * 0.25, h * 0.25, i * 0.25);
      glowParticle.setMaxAge(clientWorld.random.nextInt(2) + 2);
      return glowParticle;
    }
  }

  public static class GemElectricSparkFactory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;

    public GemElectricSparkFactory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e,
        double f, double g, double h, double i) {
      ElectricSparkParticleFactory glowParticle = new ElectricSparkParticleFactory(clientWorld, d, e, f, 0.0, 0.0, 0.0,
          this.spriteProvider);
      glowParticle.setColor(0.9921568634F, 0.341176471F, 0.793548387F);
      glowParticle.setVelocity(g * 0.25, h * 0.25, i * 0.25);
      glowParticle.setMaxAge(clientWorld.random.nextInt(2) + 2);
      return glowParticle;
    }
  }

}
