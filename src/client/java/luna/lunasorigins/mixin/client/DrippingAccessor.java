package luna.lunasorigins.mixin.client;

import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.particle.ParticleEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockLeakParticle.Dripping.class)
public interface DrippingAccessor {

    @Invoker("<init>")
    static BlockLeakParticle.Dripping newDripping(ClientWorld world, double x, double y, double z, Fluid fluid,
            ParticleEffect nextParticle) {
        throw new UnsupportedOperationException();
    }
}
