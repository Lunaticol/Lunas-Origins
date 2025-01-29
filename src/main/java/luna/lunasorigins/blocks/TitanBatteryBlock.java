package luna.lunasorigins.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class TitanBatteryBlock extends RedstoneBlock {

  public TitanBatteryBlock(Settings settings) {
    super(settings);
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return Block.createCuboidShape(4, 0, 4, 12, 16, 12); // (minX, minY, minZ, maxX, maxY, maxZ)
  }

  @Override
  public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return this.getOutlineShape(state, world, pos, context);
  }

}
