package luna.lunasorigins.items;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class Luna extends Item {

  public Luna(Settings settings) {
    super(settings);
  }

  @Override
  public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(Text.translatable("itemTooltip.lunasorigins.luna").formatted(Formatting.GRAY));
  }
}
