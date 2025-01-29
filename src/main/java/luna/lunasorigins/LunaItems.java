package luna.lunasorigins;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
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

        // Initialize method to modify item groups
        public static void initialize() {

                Registry.register(Registries.ITEM_GROUP, LUNASORIGINS_ITEM_GROUP_KEY, LUNASORIGINS_ITEM_GROUP);

                ItemGroupEvents.modifyEntriesEvent(LUNASORIGINS_ITEM_GROUP_KEY).register(itemGroup -> {
                        itemGroup.add(LunaItems.CRIMSON_MEMBRANE);
                        itemGroup.add(LunaItems.TITAN_BATTERY);
                        itemGroup.add(LunaItems.DIMENSIONAL_BERRY);
                        itemGroup.add(LunaItems.SOUL_BERRY);
                        itemGroup.add(LunaItems.LUNA_HEADTAKER);
                });
        }

        // Register an item
        public static Item register(Item item, String id) {
                // Create the identifier for the item.
                Identifier itemID = new Identifier(LunasOrigins.MOD_ID, id);

                // Register the item.
                Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

                // Return the registered item!
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

        public static final Item LUNA_HEADTAKER = register(
                        new AxeItem(ToolMaterials.NETHERITE, 10F, -2F, new Item.Settings()),
                        "luna_headtaker");
}
