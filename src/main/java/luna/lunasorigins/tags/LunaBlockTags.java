package luna.lunasorigins.tags;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class LunaBlockTags {

  public static final TagKey<Block> ENDER_FIRE_BASE_BLOCKS = of("ender_fire_base_blocks");

  private LunaBlockTags() {
  }

  private static TagKey<Block> of(String id) {
    return TagKey.of(RegistryKeys.BLOCK, new Identifier("lunasorigins", id));
  }

}
