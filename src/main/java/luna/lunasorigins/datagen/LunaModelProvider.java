package luna.lunasorigins.datagen;

import luna.lunasorigins.LunaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;

public class LunaModelProvider extends FabricModelProvider {

  public LunaModelProvider(FabricDataOutput generator) {
    super(generator);
  }

  @Override

  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    // Define how to generate block state models here
    blockStateModelGenerator.registerTintableCross(LunaBlocks.PINK_COMMAND_SAPLING, TintType.NOT_TINTED);
    blockStateModelGenerator.registerTintableCross(LunaBlocks.GREEN_COMMAND_SAPLING, TintType.NOT_TINTED);
    blockStateModelGenerator.registerTintableCross(LunaBlocks.RED_COMMAND_SAPLING, TintType.NOT_TINTED);
    blockStateModelGenerator.registerTintableCross(LunaBlocks.YELLOW_COMMAND_SAPLING, TintType.NOT_TINTED);

  }

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
  }
}
