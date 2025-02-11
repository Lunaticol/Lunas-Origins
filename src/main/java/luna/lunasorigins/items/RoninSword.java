package luna.lunasorigins.items;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class RoninSword extends SwordItem {

  public RoninSword(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
    super(material, (int) attackDamage, attackSpeed, settings);
  }

  @Override
  public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(Text.translatable("itemTooltip.lunasorigins.ronin_sword").formatted(Formatting.GRAY));
  }
}
