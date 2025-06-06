// Based on EntityRendererMixin by Provismet, licensed under the Lily License v1.1
// https://github.com/Provismet/Provi-Origins/blob/1.20.4/src/main/java/com/provismet/proviorigins/mixin/EntityRendererMixin.java
// Same applys here I don't know how to do this any other way.

package luna.lunasorigins.mixin.client.origin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.apace100.apoli.component.PowerHolderComponent;
import luna.lunasorigins.origin.powers.GlowingPower;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

@Mixin(value = EntityRenderer.class, priority = 998)
public abstract class EntityRenderMixin {
  // Emissive Power
  @Inject(at = @At("HEAD"), method = "getBlockLight", cancellable = true)
  public void makeEmissive(Entity entity, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
    if (entity instanceof LivingEntity living) {
      List<GlowingPower> glowing = PowerHolderComponent.getPowers(living, GlowingPower.class);
      if (!glowing.isEmpty()) {
        int max = glowing.get(0).glow;
        for (GlowingPower p : glowing) {
          if (p.glow > max)
            max = p.glow;
        }
        cir.setReturnValue(max);
      }
    }
  }
}