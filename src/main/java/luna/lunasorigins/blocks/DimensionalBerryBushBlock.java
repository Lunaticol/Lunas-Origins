package luna.lunasorigins.blocks;

import luna.lunasorigins.LunaItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class DimensionalBerryBushBlock extends SweetBerryBushBlock {
  public DimensionalBerryBushBlock(AbstractBlock.Settings settings) {
    super(settings); // Call the parent class constructor with the required settings
  }

  @Override
  public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
    // Allow planting on soul sand and other valid surfaces
    return floor.isOf(Blocks.SOUL_SAND) || super.canPlantOnTop(floor, world, pos) || floor.isOf(Blocks.SOUL_SOIL)
        || floor.isOf(Blocks.NETHERRACK) || floor.isOf(Blocks.CRIMSON_NYLIUM) || floor.isOf(Blocks.WARPED_NYLIUM)
        || floor.isOf(Blocks.END_STONE);
  }

  @Override
  public Item asItem() {
    // Return your custom berry item
    return LunaItems.DIMENSIONAL_BERRY;
  }
}
