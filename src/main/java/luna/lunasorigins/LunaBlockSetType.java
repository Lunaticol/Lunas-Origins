package luna.lunasorigins;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Set;
import java.util.stream.Stream;

import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public record LunaBlockSetType(
    String name,
    boolean canOpenByHand,
    BlockSoundGroup soundType,
    SoundEvent doorClose,
    SoundEvent doorOpen,
    SoundEvent trapdoorClose,
    SoundEvent trapdoorOpen,
    SoundEvent pressurePlateClickOff,
    SoundEvent pressurePlateClickOn,
    SoundEvent buttonClickOff,
    SoundEvent buttonClickOn) {
  private static final Set<BlockSetType> VALUES = new ObjectArraySet<>();

  public static final BlockSetType COMMAND = register(
      new BlockSetType(
          "lunasorigins:command",
          true,
          BlockSoundGroup.CHERRY_WOOD,
          SoundEvents.BLOCK_CHERRY_WOOD_DOOR_CLOSE,
          SoundEvents.BLOCK_CHERRY_WOOD_DOOR_OPEN,
          SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_CLOSE,
          SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_OPEN,
          SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
          SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON,
          SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_OFF,
          SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON));

  private static BlockSetType register(BlockSetType blockSetType) {
    VALUES.add(blockSetType);
    return blockSetType;
  }

  public static Stream<BlockSetType> stream() {
    return VALUES.stream();
  }
}
