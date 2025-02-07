package luna.lunasorigins;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LunaEvent {

    public static void initialize() {
        registerEvents();
    }

    public static void registerEvents() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.isClient && hand == Hand.MAIN_HAND) {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = world.getBlockState(pos);

                if (state.isOf(LunaBlocks.COMMAND_LOG_PINK) || state.isOf(LunaBlocks.COMMAND_LOG_GREEN)
                        || state.isOf(LunaBlocks.COMMAND_LOG_RED) || state.isOf(LunaBlocks.COMMAND_LOG_YELLOW)) {
                    ItemStack heldItem = player.getStackInHand(hand);
                    if (heldItem.getItem() instanceof AxeItem) {
                        world.setBlockState(pos, LunaBlocks.STRIPPED_COMMAND_LOG.getDefaultState(), 11);
                        if (!player.isCreative()) {
                            heldItem.damage(1, player, (p) -> p.sendToolBreakStatus(hand));
                        }
                        world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        return ActionResult.SUCCESS;
                    }
                }
            }
            return ActionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.isClient && hand == Hand.MAIN_HAND) {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = world.getBlockState(pos);

                if (state.isOf(LunaBlocks.COMMAND_WOOD_PINK) || state.isOf(LunaBlocks.COMMAND_WOOD_GREEN)
                        || state.isOf(LunaBlocks.COMMAND_WOOD_RED) || state.isOf(LunaBlocks.COMMAND_WOOD_YELLOW)) {
                    ItemStack heldItem = player.getStackInHand(hand);
                    if (heldItem.getItem() instanceof AxeItem) {
                        world.setBlockState(pos, LunaBlocks.STRIPPED_COMMAND_WOOD.getDefaultState(), 11);
                        if (!player.isCreative()) {
                            heldItem.damage(1, player, (p) -> p.sendToolBreakStatus(hand));
                        }
                        world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        return ActionResult.SUCCESS;
                    }
                }
            }
            return ActionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.isClient) {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = world.getBlockState(pos);

                if (state.isOf(LunaBlocks.DIMENSIONAL_BERRY_BUSH_BLOCK)) {
                    return handleBerryPicking(player, hand, state, pos, world);
                }
            }
            return ActionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) ->

        {
            if (!world.isClient) {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = world.getBlockState(pos);
                if (state.isOf(LunaBlocks.SOUL_BERRY_BUSH_BLOCK)) {
                    return handleSoulBerryPicking(player, hand, state, pos, world);
                }
            }
            return ActionResult.PASS;
        });

    }

    private static ActionResult handleBerryPicking(PlayerEntity player, Hand hand, BlockState state, BlockPos pos,
            World world) {
        int age = state.get(SweetBerryBushBlock.AGE);
        ItemStack heldItem = player.getStackInHand(hand);

        if (age == 2 && !heldItem.isOf(Items.BONE_MEAL) || age == 3) {
            if (age == 2 && heldItem.isOf(Items.BONE_MEAL)) {
                world.setBlockState(pos, state.with(SweetBerryBushBlock.AGE, 3), 2);
                return ActionResult.SUCCESS;
            }
            dropDimensionalBerries(world, pos, age);
            world.setBlockState(pos, state.with(SweetBerryBushBlock.AGE, 1));

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    private static void dropDimensionalBerries(World world, BlockPos pos, int age) {
        int berryCount = age == 3 ? 2 : 1;
        ItemStack berries = new ItemStack(LunaItems.DIMENSIONAL_BERRY, berryCount);
        net.minecraft.util.ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), berries);
        world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    private static ActionResult handleSoulBerryPicking(PlayerEntity player, Hand hand, BlockState state, BlockPos pos,
            World world) {
        int age = state.get(SweetBerryBushBlock.AGE);
        ItemStack heldItem = player.getStackInHand(hand);

        if (age == 2 && !heldItem.isOf(Items.BONE_MEAL) || age == 3) {
            if (age == 2 && heldItem.isOf(Items.BONE_MEAL)) {
                world.setBlockState(pos, state.with(SweetBerryBushBlock.AGE, 3), 2);

            }

            dropSoulBerries(world, pos, age);
            world.setBlockState(pos, state.with(SweetBerryBushBlock.AGE, 1));

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    private static void dropSoulBerries(World world, BlockPos pos, int age) {
        int berryCount = age == 3 ? 2 : 1;
        ItemStack berries = new ItemStack(LunaItems.SOUL_BERRY, berryCount);

        net.minecraft.util.ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), berries);
        world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

}
