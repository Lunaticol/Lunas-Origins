package luna.lunasorigins;

import net.minecraft.block.*;
import net.minecraft.block.enums.*;
import net.minecraft.block.piston.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import luna.lunasorigins.blocks.*;
import luna.lunasorigins.blocks.signs.CommandSignBlock;
import luna.lunasorigins.blocks.signs.CommandWallHangingSign;
import luna.lunasorigins.blocks.signs.CommandWallSign;
import luna.lunasorigins.blocks.signs.HangingCommandSignBlock;
import luna.lunasorigins.worldgen.tree.*;
import luna.lunasorigins.blocks.stuffy.*;
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
                                        .strength(0.2F)
                                        .sounds(BlockSoundGroup.GRASS)),
                        "pink_command_leaves",
                        true);

        public static final Block COMMAND_LEAVES_GREEN = register(
                        new LeavesBlock(AbstractBlock.Settings.create()
                                        .noCollision()
                                        .nonOpaque()
                                        .strength(0.2F)
                                        .sounds(BlockSoundGroup.GRASS)),
                        "green_command_leaves",
                        true);

        public static final Block COMMAND_LEAVES_RED = register(
                        new LeavesBlock(AbstractBlock.Settings.create()
                                        .noCollision()
                                        .nonOpaque()
                                        .strength(0.2F)
                                        .sounds(BlockSoundGroup.GRASS)),
                        "red_command_leaves",
                        true);

        public static final Block COMMAND_LEAVES_YELLOW = register(
                        new LeavesBlock(AbstractBlock.Settings.create()
                                        .noCollision()
                                        .nonOpaque()
                                        .strength(0.2F)
                                        .sounds(BlockSoundGroup.GRASS)),
                        "yellow_command_leaves",
                        true);

        public static final Block COMMAND_PLANKS = register(
                        new Block(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD)
                                        .strength(2.0F, 3.0F)),
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
                                        .sounds(BlockSoundGroup.WOOD).strength(3.0F).nonOpaque(), BlockSetType.CHERRY),
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
                                        .sounds(BlockSoundGroup.WOOD)
                                        .strength(2.0F, 3.0F), BlockSetType.CHERRY, 30, true),
                        "command_button",
                        true);

        public static final Block COMMAND_FENCE_GATE = register(
                        new FenceGateBlock(
                                        AbstractBlock.Settings.create().strength(2.0F, 3.0F)
                                                        .sounds(BlockSoundGroup.WOOD),
                                        LunaWoodType.COMMAND),
                        "command_fence_gate", true);

        public static final Block COMMAND_PRESSURE_PLATE = register(
                        new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                                        AbstractBlock.Settings.create()
                                                        .sounds(BlockSoundGroup.WOOD)
                                                        .strength(2.0F, 3.0F),
                                        BlockSetType.CHERRY),
                        "command_pressure_plate",
                        true);

        public static final Block COMMAND_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD)
                                        .strength(2.0F, 3.0F)),
                        "command_slab",
                        true);

        public static final Block COMMAND_SIGN = register(
                        new CommandSignBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD).noCollision(), LunaWoodType.COMMAND),
                        "command_sign",
                        false);

        public static final Block COMMAND_WALL_SIGN = register(
                        new CommandWallSign(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD).noCollision(), LunaWoodType.COMMAND),
                        "command_wall_sign",
                        false);

        public static final Block COMMAND_HANGING_SIGN = register(
                        new HangingCommandSignBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD).noCollision(), LunaWoodType.COMMAND),
                        "command_hanging_sign",
                        false);

        public static final Block COMMAND_HANGING_WALL_SIGN = register(
                        new CommandWallHangingSign(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.WOOD).noCollision(), LunaWoodType.COMMAND),
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
                                        AbstractBlock.Settings.copy(COMMAND_PLATED_STONE)
                                                        .strength(2.0F, 3.0F)),
                        "plated_stone_brick_stairs",
                        true);

        public static final Block COMMAND_PLATED_STONE_STAIRS = register(
                        new StairsBlock(COMMAND_PLATED_STONE.getDefaultState(),
                                        AbstractBlock.Settings.copy(COMMAND_PLATED_STONE)
                                                        .strength(2.0F, 3.0F)),
                        "plated_stone_stairs",
                        true);

        public static final Block COMMAND_PLATED_STONE_BRICK_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.STONE)
                                        .strength(2.0F, 3.0F)),
                        "plated_stone_brick_slab",
                        true);

        public static final Block COMMAND_PLATED_STONE_BRICK_WALL = register(
                        new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).solid()
                                        .strength(2.0F, 3.0F)),
                        "plated_stone_brick_wall",
                        true);

        public static final Block COMMAND_PLATED_MOSSY_STONE_BRICK_WALL = register(
                        new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).solid()
                                        .strength(2.0F, 3.0F)),
                        "plated_mossy_stone_brick_wall",
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

        public static final Block KARL = register(
                        new Karl(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "karl", true);
        public static final Block EEVEE = register(
                        new EeveeStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "eevee", true);
        public static final Block FLAREON = register(
                        new FlareonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "flareon",
                        true);
        public static final Block JOLTEON = register(
                        new JolteonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "jolteon",
                        true);
        public static final Block VAPOREON = register(
                        new VaporeonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "vaporeon",
                        true);
        public static final Block ESPEON = register(
                        new EspeonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "espeon", true);
        public static final Block UMBREON = register(
                        new UmbreonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "umbreon",
                        true);
        public static final Block LEAFEON = register(
                        new LeafeonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "leafeon",
                        true);
        public static final Block GLACEON = register(
                        new GlaceonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "glaceon",
                        true);
        public static final Block SYLVEON = register(
                        new SylveonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "sylveon",
                        true);
        public static final Block ABOMINACEON = register(
                        new AbominaceonStuffy(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)),
                        "abominaceon",
                        true);

        public static final Block NOCTILITH = register(
                        new FlowerBlock(StatusEffects.WITHER, 20, AbstractBlock.Settings.copy(Blocks.WHITE_TULIP)),
                        "noctilith",
                        true);

        public static final Block WHITE_LILY = register(
                        new FlowerBlock(StatusEffects.REGENERATION, 20,
                                        AbstractBlock.Settings.copy(Blocks.WHITE_TULIP)),
                        "white_lily",
                        true);

        public static final Block BLUE_OBSIDIAN = register(
                        new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN).mapColor(MapColor.BLUE)),
                        "blue_obsidian", true);

        public static final Block BLUE_CRYING_OBSIDIAN = register(
                        new BlueCryingObsidian(AbstractBlock.Settings.create().mapColor(MapColor.BLUE)
                                        .instrument(Instrument.BASEDRUM).requiresTool().strength(25.0F, 1200.0F)
                                        .luminance((state) -> {
                                                return 10;
                                        })),
                        "blue_crying_obsidian", true);

        public static final Block ENDER_FIRE = register(
                        new EnderFire(AbstractBlock.Settings.copy(Blocks.SOUL_FIRE).mapColor(MapColor.PALE_PURPLE)),
                        "ender_fire", false);

        public static final Block DROP_POINT = register(
                        new Block(AbstractBlock.Settings.copy(Blocks.BLUE_BED).mapColor(MapColor.BLUE)
                                        .luminance((state) -> {
                                                return 15;
                                        }).nonOpaque().noCollision()),
                        "drop_point", true);

        public static final Block RED_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 15;
                                        })
                                        .nonOpaque()),
                        "red_wisp_lantern", true);

        public static final Block ORANGE_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 15;
                                        })
                                        .nonOpaque()),
                        "orange_wisp_lantern", true);

        public static final Block YELLOW_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 15;
                                        })
                                        .nonOpaque()),
                        "yellow_wisp_lantern", true);

        public static final Block GREEN_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 10;
                                        })
                                        .nonOpaque()),
                        "green_wisp_lantern", true);

        public static final Block CYAN_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 15;
                                        })
                                        .nonOpaque()),
                        "cyan_wisp_lantern", true);

        public static final Block BLUE_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 8;
                                        })
                                        .nonOpaque()),
                        "blue_wisp_lantern", true);

        public static final Block PURPLE_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 4;
                                        })
                                        .nonOpaque()),
                        "purple_wisp_lantern", true);

        public static final Block WHITE_WISP_LANTERN = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 15;
                                        })
                                        .nonOpaque()),
                        "white_wisp_lantern", true);

        public static final Block LANTERN_CASING = register(
                        new LanternBlock(AbstractBlock.Settings.create()
                                        .sounds(BlockSoundGroup.LANTERN)
                                        .strength(2.0F, 3.0F)
                                        .luminance((state) -> {
                                                return 0;
                                        })
                                        .nonOpaque()),
                        "lantern_casing", true);

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
                                                .add(LunaBlocks.COMMAND_PLATED_STONE_BRICK_WALL.asItem()));
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
                                                .add(LunaBlocks.COMMAND_PLATED_MOSSY_STONE_BRICK_WALL.asItem()));
                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.COMMAND_PLATED_STONE_BRICK_SLAB.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.KARL.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.EEVEE.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.FLAREON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.JOLTEON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.VAPOREON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.ESPEON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.UMBREON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.LEAFEON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.GLACEON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.SYLVEON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.ABOMINACEON.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.NOCTILITH.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.WHITE_LILY.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.BLUE_OBSIDIAN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.BLUE_CRYING_OBSIDIAN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.DROP_POINT.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.RED_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.ORANGE_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.YELLOW_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.GREEN_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.CYAN_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.BLUE_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.PURPLE_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.WHITE_WISP_LANTERN.asItem()));

                ItemGroupEvents.modifyEntriesEvent(LunaItems.LUNASORIGINS_ITEM_GROUP_KEY)
                                .register(itemGroup -> itemGroup
                                                .add(LunaBlocks.LANTERN_CASING.asItem()));
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