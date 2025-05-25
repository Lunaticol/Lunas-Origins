package luna.lunasorigins.blocks.signs;

import luna.lunasorigins.entity.sign.HangingCommandSign;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CommandWallHangingSign extends WallHangingSignBlock {
  public CommandWallHangingSign(Settings settings, WoodType woodType) {
    super(settings, woodType);
  }

  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new HangingCommandSign(pos, state);
  }
}
