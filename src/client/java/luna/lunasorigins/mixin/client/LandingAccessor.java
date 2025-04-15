package luna.lunasorigins.mixin.client;

import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockLeakParticle.Landing.class)
public interface LandingAccessor {

    @Invoker("<init>")
    static BlockLeakParticle.Landing newLanding(ClientWorld clientWorld, double d, double e, double f, Fluid fluid) {
        throw new UnsupportedOperationException();
    }
}
