package luna.lunasorigins.blocks.signs;

import luna.lunasorigins.entity.sign.CommandSign;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CommandWallSign extends WallSignBlock {
  public CommandWallSign(Settings settings, WoodType woodType) {
    super(settings, woodType);
  }

  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new CommandSign(pos, state);
  }
}
