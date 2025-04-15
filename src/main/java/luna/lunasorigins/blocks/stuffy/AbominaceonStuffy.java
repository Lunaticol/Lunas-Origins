package luna.lunasorigins.blocks.stuffy;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class AbominaceonStuffy extends StuffyBlock {

  public AbominaceonStuffy(Settings settings) {
    super(settings);
  }

  public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(Text.translatable("itemTooltip.lunasorigins.abominaceon").formatted(Formatting.GRAY));
    tooltip.add(Text.translatable("itemTooltip.lunasorigins.abominaceon2").formatted(Formatting.GRAY));
  }

}
