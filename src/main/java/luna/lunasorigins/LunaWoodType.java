package luna.lunasorigins;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class LunaWoodType {
    public static final WoodType COMMAND = register("command", WoodTypeBuilder.copyOf(WoodType.WARPED),
            LunaBlockSetType.COMMAND);

    public static WoodType register(String id, WoodTypeBuilder woodTypeBuilder, BlockSetType blockSetType) {
        return woodTypeBuilder.register(new Identifier(LunasOrigins.MOD_ID, id), blockSetType);
    }
}