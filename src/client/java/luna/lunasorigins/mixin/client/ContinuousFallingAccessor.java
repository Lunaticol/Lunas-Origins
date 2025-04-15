package luna.lunasorigins.mixin.client;

import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.particle.ParticleEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockLeakParticle.ContinuousFalling.class)
public interface ContinuousFallingAccessor {
    @Invoker("<init>")
    static BlockLeakParticle.ContinuousFalling newFalling(ClientWorld world, double x, double y, double z, Fluid fluid,
            ParticleEffect nextParticle) {
        throw new UnsupportedOperationException();
    }
}
