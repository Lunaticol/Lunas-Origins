package luna.lunasorigins.blocks;

import luna.lunasorigins.LunaItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class SoulBerryBushBlock extends SweetBerryBushBlock {
  public SoulBerryBushBlock(AbstractBlock.Settings settings) {
    super(settings);
  }

  @Override
  public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
    return floor.isOf(Blocks.SOUL_SAND) || floor.isOf(Blocks.SOUL_SOIL);
  }

  @Override
  public Item asItem() {
    return LunaItems.SOUL_BERRY;
  }
}
