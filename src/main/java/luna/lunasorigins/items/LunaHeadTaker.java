package luna.lunasorigins.items;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import luna.lunasorigins.LunasOrigins;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class LunaHeadTaker extends AxeItem {

  public LunaHeadTaker(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
    super(material, attackDamage, attackSpeed, settings);
  }

  @Override
  public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(Text.translatable("itemTooltip.lunasorigins.luna_headtaker").formatted(Formatting.GRAY));
    tooltip.add(Text.translatable("itemTooltip.lunasorigins.luna_headtaker2").formatted(Formatting.GRAY));
  }

  @Override
  public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    if (!target.getWorld().isClient) {
      target.addStatusEffect(new StatusEffectInstance(LunasOrigins.LUNA_CORRUPTION, 100, 2));
    }
    return super.postHit(stack, target, attacker);
  }
}
