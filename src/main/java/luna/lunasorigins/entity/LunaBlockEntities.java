package luna.lunasorigins.entity;

import luna.lunasorigins.LunaBlocks;
import luna.lunasorigins.LunasOrigins;
import luna.lunasorigins.entity.sign.CommandSign;
import luna.lunasorigins.entity.sign.HangingCommandSign;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LunaBlockEntities<T extends BlockEntity> {

  public static final BlockEntityType<CommandSign> COMMAND_SIGN = register("command_sign",
      FabricBlockEntityTypeBuilder.create(CommandSign::new, LunaBlocks.COMMAND_SIGN, LunaBlocks.COMMAND_WALL_SIGN)
          .build(null));

  public static final BlockEntityType<HangingCommandSign> COMMAND_HANGING_SIGN = register("command_hanging_sign",
      FabricBlockEntityTypeBuilder.create(HangingCommandSign::new, LunaBlocks.COMMAND_HANGING_SIGN,
          LunaBlocks.COMMAND_HANGING_WALL_SIGN)
          .build(null));

  public static <T extends BlockEntityType<?>> T register(String name, T blockEntityType) {
    return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(LunasOrigins.MOD_ID, name), blockEntityType);
  }
}