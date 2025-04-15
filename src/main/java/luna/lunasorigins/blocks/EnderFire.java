package luna.lunasorigins.blocks;

import luna.lunasorigins.tags.LunaBlockTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class EnderFire extends AbstractFireBlock {

  public EnderFire(AbstractBlock.Settings settings) {
    super(settings, 4.0F);
  }

  @Override
  public BlockState getStateForNeighborUpdate(
      BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos,
      BlockPos neighborPos) {
    return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
  }

  @Override
  public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    return isEnderBase(world.getBlockState(pos.down()));
  }

  public static boolean isEnderBase(BlockState state) {
    return state.isIn(LunaBlockTags.ENDER_FIRE_BASE_BLOCKS);
  }

  @Override
  protected boolean isFlammable(BlockState state) {
    return true;
  }

}
