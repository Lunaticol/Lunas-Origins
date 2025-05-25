
package luna.lunasorigins.mixin.enchant;

import luna.lunasorigins.items.Pistol;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageEnchantment.class)
public class SharpnessEnchantmentMixin {

  @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
  private void allowSharpnessOnSwordPistols(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
    if (stack.getItem() instanceof Pistol) {
      Identifier id = Registries.ITEM.getId(stack.getItem());
      if (id != null && id.getPath().contains("pistol_") && id.getPath().contains("_sword")) {
        cir.setReturnValue(true);
      }
    }
  }
}
