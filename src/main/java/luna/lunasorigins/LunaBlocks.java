package luna.lunasorigins;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SignBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import luna.lunasorigins.blocks.DimensionalBerryBushBlock;
import luna.lunasorigins.blocks.SoulBerryBushBlock;
import luna.lunasorigins.blocks.TitanBatteryBlock;
import luna.lunasorigins.worldgen.tree.GreenCommandTreeSaplingGenerator;
import luna.lunasorigins.worldgen.tree.PinkCommandTreeSaplingGenerator;
import luna.lunasorigins.worldgen.tree.RedCommandTreeSaplingGenerator;
import luna.lunasorigins.worldgen.tree.YellowCommandTreeSaplingGenerator;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class LunaBlocks {

        public static final Block COMMAND_LOG_PINK = register(
                        new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "pink_command_log",
                        true);

        public static final Block COMMAND_LOG_GREEN = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "green_command_log",
                        true);

        public static final Block COMMAND_LOG_RED = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "red_command_log",
                        true);

        public static final Block COMMAND_LOG_YELLOW = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "yellow_command_log",
                        true);

        public static final Block STRIPPED_COMMAND_LOG = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "stripped_command_log",
                        true);

        public static final Block COMMAND_LEAVES_PINK = register(
                        new LeavesBlock(AbstractBlock.Settings.create()
                                        .noCollision()
                                        .nonOpaque()
                                        .sounds(BlockSoundGroup.GRASS)),
                        "pink_command_leaves",
                        true);

        public static final Block COMMAND_LEAVES_GREEN = register(
                        new LeavesBlock(AbstractBlock.Settings.create()
                                        .noCollision()
                                        .nonOpaque()
                                        .sounds(BlockSoundGroup.GRASS)),
                        "green_command_leaves",
                        true);

        public static final Block COMMAND_LEAVES_RED = register(
                        new LeavesBlock(AbstractBlock.Settings.create()
                                        .noCollision()
                                        .nonOpaque()
                                        .sounds(BlockSoundGroup.GRASS)),
                        "red_command_leaves",
                        true);

        public static final Block COMMAND_LEAVES_YELLOW = register(
                        new LeavesBlock(AbstractBlock.Settings.create()
                                        .noCollision()
                                        .nonOpaque()
                                        .sounds(BlockSoundGroup.GRASS)),
                        "yellow_command_leaves",
                        true);

        public static final Block COMMAND_PLANKS = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD)),
                        "command_planks",
                        true);

        public static final Block COMMAND_DOOR = register(
                        new DoorBlock(AbstractBlock.Settings.create()
                                        .mapColor(DyeColor.WHITE.getMapColor())
                                        .instrument(Instrument.BASS)
                                        .strength(3.0F)
                                        .nonOpaque()
                                        .burnable()
                                        .pistonBehavior(PistonBehavior.DESTROY),
                                        BlockSetType.CHERRY),
                        "command_door", true);

        public static final Block COMMAND_TRAPDOOR = register(
                        new TrapdoorBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD).nonOpaque(), BlockSetType.CHERRY),
                        "command_trapdoor",
                        true);

        public static final Block COMMAND_STAIRS = register(
                        new StairsBlock(COMMAND_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(COMMAND_PLANKS)),
                        "command_stairs",
                        true);

        public static final Block COMMAND_FENCE = register(
                        new FenceBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD)
                                        .solid()
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.WOOD)
                                        .burnable()),
                        "command_fence", true);

        public static final Block COMMAND_BUTTON = register(
                        new ButtonBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD), BlockSetType.CHERRY, 30, true),
                        "command_button",
                        true);

        public static final Block COMMAND_FENCE_GATE = register(
                        new FenceGateBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD),
                                        LunaWoodType.COMMAND),
                        "command_fence_gate", true);

        public static final Block COMMAND_PRESSURE_PLATE = register(
                        new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                                        AbstractBlock.Settings.create()
                                                        .sounds(BlockSoundGroup.WOOD),
                                        BlockSetType.CHERRY),
                        "command_pressure_plate",
                        true);

        public static final Block COMMAND_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD)),
                        "command_slab",
                        true);

        public static final Block COMMAND_SIGN_BLOCK = register(
                        new SignBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD), LunaWoodType.COMMAND),
                        "command_sign",
                        false);

        public static final Block COMMAND_WALL_SIGN_BLOCK = register(
                        new WallSignBlock(FabricBlockSettings.copy(Blocks.CHERRY_SIGN), LunaWoodType.COMMAND),
                        "command_wall_sign",
                        false);

        public static final Block COMMAND_HANGING_SIGN = register(
                        new HangingSignBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD), LunaWoodType.COMMAND),
                        "command_hanging_sign",
                        false);

        public static final Block COMMAND_HANGING_WALL_SIGN = register(
                        new HangingSignBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD), LunaWoodType.COMMAND),
                        "command_hanging_wall_sign",
                        false);

        public static final Block COMMAND_WOOD_PINK = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "pink_command_wood",
                        true);

        public static final Block COMMAND_WOOD_GREEN = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "green_command_wood",
                        true);

        public static final Block COMMAND_WOOD_RED = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "red_command_wood",
                        true);

        public static final Block COMMAND_WOOD_YELLOW = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "yellow_command_wood",
                        true);

        public static final Block STRIPPED_COMMAND_WOOD = register(
                        new PillarBlock(AbstractBlock.Settings.create()
                                        .mapColor(MapColor.WHITE_GRAY)
                                        .instrument(Instrument.BASS)
                                        .strength(2.0F, 3.0F)
                                        .sounds(BlockSoundGroup.CHERRY_WOOD)),
                        "stripped_command_wood",
                        true);

        public static final Block PINK_COMMAND_SAPLING = register(
                        new SaplingBlock(new PinkCommandTreeSaplingGenerator(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)),
                        "pink_command_sapling",
                        true);

        public static final Block GREEN_COMMAND_SAPLING = register(
                        new SaplingBlock(new GreenCommandTreeSaplingGenerator(),
                                        FabricBlockSettings.copyOf(Blocks.CHERRY_SAPLING)),
                        "green_command_sapling",
                        true);

        public static final Block RED_COMMAND_SAPLING = register(
                        new SaplingBlock(new RedCommandTreeSaplingGenerator(),
                                        FabricBlockSettings.copyOf(Blocks.ACACIA_SAPLING)),
                        "red_command_sapling",
                        true);

        public static final Block YELLOW_COMMAND_SAPLING = register(
                        new SaplingBlock(new YellowCommandTreeSaplingGenerator(),
                                        FabricBlockSettings.copyOf(Blocks.MANGROVE_PROPAGULE)),
                        "yellow_command_sapling",
                        true);

        public static final Block COMMAND_PLATED_STONE = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)
                                        .allowsSpawning((state, world, pos, type) -> false)),
                        "plated_stone",
                        true);

        public static final Block COMMAND_PLATED_STONE_BRICKS = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_stone_bricks",
                        true);

        public static final Block COMMAND_PLATED_MOSSY_STONE_BRICKS = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_mossy_stone_bricks",
                        true);

        public static final Block COMMAND_PLATED_CRACKED_STONE_BRICKS = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_cracked_stone_bricks",
                        true);

        public static final Block COMMAND_PLATED_CHISELED_STONE_BRICKS = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_chiseled_stone_bricks",
                        true);

        public static final Block COMMAND_PLATED_SMOOTH_STONE = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_smooth_stone",
                        true);

        public static final Block COMMAND_PLATED_SMOOTH_STONE_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_smooth_stone_slab",
                        true);

        public static final Block COMMAND_PLATED_STONE_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_stone_slab",
                        true);

        public static final Block COMMAND_PLATED_STONE_BRICK_STAIRS = register(
                        new StairsBlock(COMMAND_PLATED_STONE.getDefaultState(),
                                        AbstractBlock.Settings.copy(COMMAND_PLATED_STONE)),
                        "plated_stone_brick_stairs",
                        true);

        public static final Block COMMAND_PLATED_STONE_STAIRS = register(
                        new StairsBlock(COMMAND_PLATED_STONE.getDefaultState(),
                                        AbstractBlock.Settings.copy(COMMAND_PLATED_STONE)),
                        "plated_stone_stairs",
                        true);

        public static final Block COMMAND_PLATED_STONE_BRICK_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_stone_brick_slab",
                        true);

        public static final Block COMMAND_PLATED_STONE_BRICK_WALL = register(
                        new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).solid()),
                        "plated_stone_brick_wall",
                        true);

        public static final Block COMMAND_PLATED_MOSSY_STONE_BRICK_WALL = register(
                        new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).solid()),
                        "plated_stone_mossy_brick_wall",
                        true);

        public static final Block COMMAND_PLATED_MOSSY_STONE_BRICK_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_mossy_stone_brick_slab",
                        true);

        public static final Block COMMAND_PLATED_MOSSY_STONE_BRICK_STAIRS = register(
                        new StairsBlock(COMMAND_PLATED_STONE.getDefaultState(),
                                        AbstractBlock.Settings.copy(COMMAND_PLATED_STONE)),
                        "plated_mossy_stone_brick_stairs",
                        true);

        public static final Block DIMENSIONAL_BERRY_BUSH_BLOCK = register(
                        new DimensionalBerryBushBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque().noCollision()),
                        "dimensional_berry_bush", false);

        public static final Block SOUL_BERRY_BUSH_BLOCK = register(
                        new SoulBerryBushBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque().noCollision()),
                        "soul_berry_bush", false);

        public static final Block TITAN_BATTERY = register(
                        new TitanBatteryBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.ANVIL).nonOpaque()),
                        "titan_battery", false);

        public static void initialize() {

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LOG_PINK.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LOG_GREEN.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LOG_RED.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LOG_YELLOW.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LEAVES_PINK.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LEAVES_GREEN.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LEAVES_RED.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_LEAVES_YELLOW.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.STRIPPED_COMMAND_LOG.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_PLANKS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_BUTTON.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_DOOR.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_FENCE.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_FENCE_GATE.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_PRESSURE_PLATE.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_SLAB.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_STAIRS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_TRAPDOOR.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_WOOD_PINK.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_WOOD_GREEN.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_WOOD_RED.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_WOOD_YELLOW.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.STRIPPED_COMMAND_WOOD.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.PINK_COMMAND_SAPLING.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.GREEN_COMMAND_SAPLING.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.RED_COMMAND_SAPLING.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.YELLOW_COMMAND_SAPLING.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_PLATED_STONE.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_PLATED_STONE_STAIRS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_PLATED_STONE_SLAB.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_PLATED_STONE_BRICKS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_MOSSY_STONE_BRICKS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_CHISELED_STONE_BRICKS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_CRACKED_STONE_BRICKS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup.add(LunaBlocks.COMMAND_PLATED_SMOOTH_STONE.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_SMOOTH_STONE_SLAB.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_STONE_BRICK_STAIRS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_MOSSY_STONE_BRICK_STAIRS.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_MOSSY_STONE_BRICK_SLAB.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_STONE_BRICK_SLAB.asItem()));
        }

        private static Block register(Block block, String name, boolean registerBlockItem) {

                Block registeredBlock = Registry.register(
                                Registries.BLOCK,
                                new Identifier("lunasorigins", name),
                                block);

                if (registerBlockItem) {
                        Item item = new BlockItem(registeredBlock, new Item.Settings());
                        Registry.register(Registries.ITEM, new Identifier("lunasorigins", name), item);
                }

                return registeredBlock;
        }
}
