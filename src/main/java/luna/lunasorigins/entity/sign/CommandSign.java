package luna.lunasorigins.entity.sign;

import luna.lunasorigins.entity.LunaBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class CommandSign extends SignBlockEntity {
  public CommandSign(BlockPos pos, BlockState state) {
    super(pos, state);
  }

  @Override
  public BlockEntityType<?> getType() {
    return LunaBlockEntities.COMMAND_SIGN;
  }
}
