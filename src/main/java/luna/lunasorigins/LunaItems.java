package luna.lunasorigins;

import luna.lunasorigins.items.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

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

                        itemGroup.add(LunaItems.DONATOR);
                        itemGroup.add(LunaItems.CRIMSON_MEMBRANE);
                        itemGroup.add(LunaItems.TITAN_BATTERY);
                        itemGroup.add(LunaItems.DIMENSIONAL_BERRY);
                        itemGroup.add(LunaItems.SOUL_BERRY);
                        // Weapons
                        itemGroup.add(LunaItems.LUNA_HEADTAKER);
                        itemGroup.add(LunaItems.RONIN_SWORD);
                        itemGroup.add(LunaItems.ENTANGLED_SWORD);
                        itemGroup.add(LunaItems.JAX_SWORD);
                        itemGroup.add(LunaItems.CRIMSON_DAGGER);
                        itemGroup.add(LunaItems.PISTOL);
                        itemGroup.add(LunaItems.PISTOL_WOODEN_SWORD);
                        itemGroup.add(LunaItems.PISTOL_STONE_SWORD);
                        itemGroup.add(LunaItems.PISTOL_GOLDEN_SWORD);
                        itemGroup.add(LunaItems.PISTOL_IRON_SWORD);
                        itemGroup.add(LunaItems.PISTOL_DIAMOND_SWORD);
                        itemGroup.add(LunaItems.PISTOL_NETHERITE_SWORD);
                        // Donators
                        itemGroup.add(LunaItems.LUNA);
                        itemGroup.add(LunaItems.TIME);
                        itemGroup.add(LunaItems.PIW);
                        itemGroup.add(LunaItems.MINEWARRIOR);
                        itemGroup.add(LunaItems.DASH);
                        itemGroup.add(LunaItems.REWIND);
                        itemGroup.add(LunaItems.MOOSHEKING);
                        itemGroup.add(LunaItems.IDKMN);
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
                        itemGroup.add(LunaItems.LUMINA);
                        // Music Discs
                        itemGroup.add(LunaItems.LUMINA_DISC);
                        itemGroup.add(LunaItems.AONO_DISC);
                        itemGroup.add(LunaItems.CRIMSON_DISC);

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
                        new SignItem(new Item.Settings().maxCount(16), LunaBlocks.COMMAND_SIGN,
                                        LunaBlocks.COMMAND_WALL_SIGN),
                        "command_sign");

        public static final Item COMMAND_HANGING_SIGN = register(
                        new HangingSignItem(LunaBlocks.COMMAND_HANGING_SIGN, LunaBlocks.COMMAND_HANGING_WALL_SIGN,
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

        public static final Item BLIND_FOLD = register(
                        new DyeableArmorItem(ArmorMaterials.LEATHER, Type.HELMET, new Item.Settings().maxCount(1)
                                        .rarity(Rarity.UNCOMMON)),
                        "blind_fold");
        // Weapons

        public static final Item LUNA_HEADTAKER = register(
                        new LunaHeadTaker(ToolMaterials.NETHERITE, 10, -3.2F,
                                        new Item.Settings().rarity(Rarity.EPIC)),
                        "luna_headtaker");

        public static final Item RONIN_SWORD = register(
                        new RoninSword(ToolMaterials.NETHERITE, 5, -3.2F,
                                        new Item.Settings().rarity(Rarity.RARE)),
                        "ronin_sword");

        public static final Item ENTANGLED_SWORD = register(
                        new SwordItem(ToolMaterials.NETHERITE, 3, -2.4F,
                                        new Item.Settings()),
                        "entangled_sword");

        public static final Item JAX_SWORD = register(
                        new SwordItem(ToolMaterials.NETHERITE, 6, -3.2F,
                                        new Item.Settings().rarity(Rarity.EPIC)),
                        "jax_sword");

        public static final Item CRIMSON_DAGGER = register(
                        new SwordItem(ToolMaterials.NETHERITE, 0, 1F,
                                        new Item.Settings()),
                        "crimson_dagger");

        public static final Item PISTOL = register(
                        new Pistol(-1, -2.6F, new Item.Settings().maxCount(1)),
                        "pistol");
        public static final Item PISTOL_WOODEN_SWORD = register(
                        new Pistol(1, -2.6F, new Item.Settings().maxCount(1)),
                        "pistol_wooden_sword");
        public static final Item PISTOL_STONE_SWORD = register(
                        new Pistol(2, -2.6F, new Item.Settings().maxCount(1)),
                        "pistol_stone_sword");
        public static final Item PISTOL_GOLDEN_SWORD = register(
                        new Pistol(3, -2.6F, new Item.Settings().maxCount(1)),
                        "pistol_golden_sword");
        public static final Item PISTOL_IRON_SWORD = register(
                        new Pistol(4, -2.6F, new Item.Settings().maxCount(1)),
                        "pistol_iron_sword");
        public static final Item PISTOL_DIAMOND_SWORD = register(
                        new Pistol(5, -2.6F, new Item.Settings().maxCount(1)),
                        "pistol_diamond_sword");
        public static final Item PISTOL_NETHERITE_SWORD = register(
                        new Pistol(6, -2.6F, new Item.Settings().maxCount(1)),
                        "pistol_netherite_sword");

        // Donators/Players

        public static final Item LUNA = register(
                        new Luna(new Item.Settings().rarity(Rarity.EPIC)),
                        "luna");

        public static final Item TIME = register(
                        new Time(new Item.Settings().rarity(Rarity.EPIC)),
                        "time");

        public static final Item PIW = register(
                        new Item(new Item.Settings().rarity(Rarity.EPIC)),
                        "piw");

        public static final Item MINEWARRIOR = register(
                        new Item(new Item.Settings().rarity(Rarity.EPIC)),
                        "minewarrior");

        public static final Item DONATOR = register(
                        new Item(new Item.Settings().rarity(Rarity.EPIC)),
                        "donator");

        public static final Item REWIND = register(
                        new Item(new Item.Settings().rarity(Rarity.EPIC)),
                        "rewind");

        public static final Item DASH = register(
                        new Item(new Item.Settings().rarity(Rarity.EPIC)),
                        "dash");

        public static final Item MOOSHEKING = register(
                        new Item(new Item.Settings().rarity(Rarity.EPIC)),
                        "moosheking");

        public static final Item IDKMN = register(
                        new Item(new Item.Settings().rarity(Rarity.EPIC)),
                        "idkmn");

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

        public static final Item LUMINA = register(
                        new Item(new Item.Settings()), "lumina");

        // Music Discs

        public static final Item LUMINA_DISC = register(
                        new MusicDiscItem(15, LunaSounds.LUMINA_ULT,
                                        new Item.Settings().maxCount(1).rarity(Rarity.RARE), 146),
                        "lumina_disc");

        public static final Item AONO_DISC = register(
                        new MusicDiscItem(3, LunaSounds.AONO_ULT,
                                        new Item.Settings().maxCount(1).rarity(Rarity.RARE), 72),
                        "aono_disc");

        public static final Item CRIMSON_DISC = register(
                        new MusicDiscItem(1, LunaSounds.CRIMSON_ULT,
                                        new Item.Settings().maxCount(1).rarity(Rarity.RARE), 172),
                        "crimson_disc");

}