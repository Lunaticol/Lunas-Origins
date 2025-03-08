package luna.lunasorigins;

import luna.lunasorigins.items.Luna;
import luna.lunasorigins.items.LunaHeadTaker;
import luna.lunasorigins.items.RoninSword;
import luna.lunasorigins.items.Time;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LunaItems {

        public static final RegistryKey<ItemGroup> LUNASORIGINS_ITEM_GROUP_KEY = RegistryKey.of(
                        Registries.ITEM_GROUP.getKey(),
                        Identifier.of(LunasOrigins.MOD_ID, "item_group"));

        public static final ItemGroup LUNASORIGINS_ITEM_GROUP = FabricItemGroup.builder()
                        .icon(() -> new ItemStack(LunaItems.DIMENSIONAL_BERRY))
                        .displayName(Text.translatable("itemGroup.lunaitemgroup"))
                        .build();

        public static void initialize() {

                Registry.register(Registries.ITEM_GROUP, LUNASORIGINS_ITEM_GROUP_KEY, LUNASORIGINS_ITEM_GROUP);

                ItemGroupEvents.modifyEntriesEvent(LUNASORIGINS_ITEM_GROUP_KEY).register(itemGroup -> {
                        itemGroup.add(LunaItems.CRIMSON_MEMBRANE);
                        itemGroup.add(LunaItems.TITAN_BATTERY);
                        itemGroup.add(LunaItems.DIMENSIONAL_BERRY);
                        itemGroup.add(LunaItems.SOUL_BERRY);
                        // Weapons
                        itemGroup.add(LunaItems.LUNA_HEADTAKER);
                        itemGroup.add(LunaItems.RONIN_SWORD);
                        itemGroup.add(LunaItems.ENTANGLED_SWORD);
                        // Donators
                        itemGroup.add(LunaItems.LUNA);
                        itemGroup.add(LunaItems.TIME);
                        itemGroup.add(LunaItems.PIW);
                        itemGroup.add(LunaItems.MINEWARRIOR);
                        itemGroup.add(LunaItems.DASH);
                        itemGroup.add(LunaItems.REWIND);
                        itemGroup.add(LunaItems.MOOSHEKING);
                        // Origins
                        itemGroup.add(LunaItems.STARS);
                        itemGroup.add(LunaItems.UMBRYTE);
                        itemGroup.add(LunaItems.WIND_CHARGE);
                        itemGroup.add(LunaItems.WISPS);
                        itemGroup.add(LunaItems.SOUL_RED);
                        itemGroup.add(LunaItems.SOUL_ORANGE);
                        itemGroup.add(LunaItems.SOUL_YELLOW);
                        itemGroup.add(LunaItems.SOUL_GREEN);
                        itemGroup.add(LunaItems.SOUL_CYAN);
                        itemGroup.add(LunaItems.SOUL_BLUE);
                        itemGroup.add(LunaItems.SOUL_PURPLE);
                        itemGroup.add(LunaItems.SOUL_WHITE);
                });
        }

        public static Item register(Item item, String id) {
                Identifier itemID = new Identifier(LunasOrigins.MOD_ID, id);
                Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
                return registeredItem;
        }

        // Register items
        public static final Item CRIMSON_MEMBRANE = register(
                        new Item(new Item.Settings()),
                        "crimson_membrane");

        public static final Item COMMAND_SIGN = register(
                        new SignItem(new Item.Settings().maxCount(16), LunaBlocks.COMMAND_SIGN_BLOCK,
                                        LunaBlocks.COMMAND_WALL_SIGN_BLOCK),
                        "command_sign");

        public static final Item COMMAND_HANGING_SIGN = register(
                        new HangingSignItem(LunaBlocks.COMMAND_HANGING_WALL_SIGN, LunaBlocks.COMMAND_HANGING_SIGN,
                                        new Item.Settings().maxCount(16)),
                        "command_hanging_sign");

        public static final Item TITAN_BATTERY = register(
                        new BlockItem(LunaBlocks.TITAN_BATTERY, new Item.Settings()),
                        "titan_battery");

        public static final Item DIMENSIONAL_BERRY = register(
                        new BlockItem(LunaBlocks.DIMENSIONAL_BERRY_BUSH_BLOCK,
                                        new Item.Settings().food(new FoodComponent.Builder()
                                                        .hunger(2)
                                                        .saturationModifier(0.1f)
                                                        .build())),
                        "dimensional_berry");

        public static final Item SOUL_BERRY = register(
                        new BlockItem(LunaBlocks.SOUL_BERRY_BUSH_BLOCK,
                                        new Item.Settings().food(new FoodComponent.Builder()
                                                        .hunger(2)
                                                        .saturationModifier(0.1f)
                                                        .build())),
                        "soul_berry");

        // Weapons

        public static final Item LUNA_HEADTAKER = register(
                        new LunaHeadTaker(ToolMaterials.NETHERITE, 10F, -3.2F,
                                        new Item.Settings()),
                        "luna_headtaker");

        public static final Item RONIN_SWORD = register(
                        new RoninSword(ToolMaterials.NETHERITE, 5F, -3.2F,
                                        new Item.Settings()),
                        "ronin_sword");

        public static final Item ENTANGLED_SWORD = register(
                        new SwordItem(ToolMaterials.NETHERITE, 3, -2.4F,
                                        new Item.Settings()),
                        "entangled_sword");

        // Donators/Players

        public static final Item LUNA = register(
                        new Luna(new Item.Settings()),
                        "luna");

        public static final Item TIME = register(
                        new Time(new Item.Settings()),
                        "time");

        public static final Item PIW = register(
                        new Item(new Item.Settings()),
                        "piw");

        public static final Item MINEWARRIOR = register(
                        new Item(new Item.Settings()),
                        "minewarrior");

        public static final Item DONATOR = register(
                        new Item(new Item.Settings()),
                        "donator");

        public static final Item REWIND = register(
                        new Item(new Item.Settings()),
                        "rewind");

        public static final Item DASH = register(
                        new Item(new Item.Settings()),
                        "dash");

        public static final Item MOOSHEKING = register(
                        new Item(new Item.Settings()),
                        "moosheking");

        // Origins

        public static final Item WIND_CHARGE = register(
                        new Item(new Item.Settings()),
                        "wind_charge");

        public static final Item WISPS = register(
                        new Item(new Item.Settings()),
                        "wisps");

        public static final Item UMBRYTE = register(
                        new Item(new Item.Settings()),
                        "umbryte");

        public static final Item STARS = register(
                        new Item(new Item.Settings()),
                        "stars");

        public static final Item SOUL_RED = register(
                        new Item(new Item.Settings()),
                        "soul_red");

        public static final Item SOUL_ORANGE = register(
                        new Item(new Item.Settings()),
                        "soul_orange");

        public static final Item SOUL_YELLOW = register(
                        new Item(new Item.Settings()),
                        "soul_yellow");

        public static final Item SOUL_GREEN = register(
                        new Item(new Item.Settings()),
                        "soul_green");

        public static final Item SOUL_CYAN = register(
                        new Item(new Item.Settings()),
                        "soul_cyan");

        public static final Item SOUL_BLUE = register(
                        new Item(new Item.Settings()),
                        "soul_blue");

        public static final Item SOUL_PURPLE = register(
                        new Item(new Item.Settings()),
                        "soul_purple");

        public static final Item SOUL_WHITE = register(
                        new Item(new Item.Settings()),
                        "soul_white");

}
