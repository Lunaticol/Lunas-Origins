package luna.lunasorigins;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class LunaWoodType {
    // Create a custom WoodType
    public static final WoodType COMMAND = new WoodType(
            "my_custom_wood",
            BlockSetType.CHERRY, // Use an existing BlockSetType, or create a new one
            BlockSoundGroup.CHERRY_WOOD,
            BlockSoundGroup.HANGING_SIGN,
            SoundEvents.BLOCK_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_FENCE_GATE_OPEN);

    // Register your custom WoodType
    public static void registerWoodTypes() {
    }
}