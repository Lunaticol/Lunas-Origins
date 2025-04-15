package luna.lunasorigins.blocks;

import luna.lunasorigins.LunaParticles;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CryingObsidianBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BlueCryingObsidian extends CryingObsidianBlock {
  public BlueCryingObsidian(AbstractBlock.Settings settings) {
    super(settings);
  }

  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    if (random.nextInt(5) == 0) {
      Direction direction = Direction.random(random);
      if (direction != Direction.UP) {
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        if (!state.isOpaque() || !blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
          double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5 + (double) direction.getOffsetX() * 0.6;
          double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5 + (double) direction.getOffsetY() * 0.6;
          double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5 + (double) direction.getOffsetZ() * 0.6;
          world.addParticle(LunaParticles.BLUE_DRIPPING_OBSIDIAN_TEAR, (double) pos.getX() + d, (double) pos.getY() + e,
              (double) pos.getZ() + f, 0.0, 0.0, 0.0);
        }
      }
    }
  }
}
