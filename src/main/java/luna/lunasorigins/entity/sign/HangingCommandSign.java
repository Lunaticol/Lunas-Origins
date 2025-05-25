package luna.lunasorigins.entity.sign;

import luna.lunasorigins.entity.LunaBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class HangingCommandSign extends HangingSignBlockEntity {
  public HangingCommandSign(BlockPos pos, BlockState state) {
    super(pos, state);
  }

  @Override
  public BlockEntityType<?> getType() {
    return LunaBlockEntities.COMMAND_HANGING_SIGN;
  }
}
