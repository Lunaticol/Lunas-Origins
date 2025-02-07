package luna.lunasorigins;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class LunaWoodType {
    public static final WoodType COMMAND = new WoodType(
            "my_custom_wood",
            BlockSetType.CHERRY,
            BlockSoundGroup.CHERRY_WOOD,
            BlockSoundGroup.HANGING_SIGN,
            SoundEvents.BLOCK_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_FENCE_GATE_OPEN);

    public static void registerWoodTypes() {
    }
}