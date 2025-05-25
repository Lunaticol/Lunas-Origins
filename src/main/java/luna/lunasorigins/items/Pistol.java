package luna.lunasorigins.items;

import java.util.List;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import luna.lunasorigins.LunaEnchantments;

import com.google.common.collect.Multimap;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class Pistol extends Item implements Vanishable {
  private static final String AMMO_KEY = "ShotsLeft";
  private static final int MAX_SHOTS = 6;
  private static final String RELOADING_KEY = "IsReloading";

  private final float attackDamage;
  private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

  public Pistol(float attackDamage, float attackSpeed, Item.Settings settings) {
    super(settings);
    this.attackDamage = (float) attackDamage;
    Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
    builder.put(
        EntityAttributes.GENERIC_ATTACK_DAMAGE,
        new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double) this.attackDamage,
            EntityAttributeModifier.Operation.ADDITION));
    builder.put(
        EntityAttributes.GENERIC_ATTACK_SPEED,
        new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double) attackSpeed,
            EntityAttributeModifier.Operation.ADDITION));
    this.attributeModifiers = builder.build();
  }

  public float getAttackDamage() {
    return this.attackDamage;
  }

  @Override
  public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
    return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack stack = user.getStackInHand(hand);

    if (user.isSneaking()) {
      if (getShotsLeft(stack) < getMaxShots(stack)) {
        stack.getOrCreateNbt().putBoolean(RELOADING_KEY, true);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(stack);
      } else {
        return TypedActionResult.fail(stack);
      }
    } else {
      if (getShotsLeft(stack) > 0) {
        if (!world.isClient) {
          setShotsLeft(stack, getShotsLeft(stack) - 1);
          world.playSound(null, user.getX(), user.getY(), user.getZ(),
              SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f);

          ArrowEntity arrow = new ArrowEntity(world, user);
          arrow.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
          world.spawnEntity(arrow);

          int rapidFireLevel = net.minecraft.enchantment.EnchantmentHelper.getLevel(
              LunaEnchantments.RAPID_FIRE, stack);
          int cooldown = Math.max(0, 30 - (rapidFireLevel * 5));
          user.getItemCooldownManager().set(this, cooldown);
        }
        return TypedActionResult.success(stack, world.isClient());
      } else {
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
            SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.PLAYERS, 0.5f, 1.0f);
        return TypedActionResult.fail(stack);
      }
    }
  }

  private int getMaxShots(ItemStack stack) {
    int enchantLevel = net.minecraft.enchantment.EnchantmentHelper.getLevel(
        LunaEnchantments.CAPACITY, stack);
    return MAX_SHOTS + enchantLevel;
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return stack.getOrCreateNbt().getBoolean(RELOADING_KEY) ? UseAction.CROSSBOW : UseAction.NONE;
  }

  @Override
  public int getMaxUseTime(ItemStack stack) {
    int quickChargeLevel = net.minecraft.enchantment.EnchantmentHelper
        .getLevel(net.minecraft.enchantment.Enchantments.QUICK_CHARGE, stack);
    return Math.max(10, 40 - (quickChargeLevel * 10));
  }

  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    if (!world.isClient && user instanceof PlayerEntity) {
      int currentShots = getShotsLeft(stack);
      if (currentShots < getMaxShots(stack)) {
        setShotsLeft(stack, currentShots + 1);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
            SoundEvents.ITEM_CROSSBOW_LOADING_END, SoundCategory.PLAYERS, 1.0f, 1.0f);
      }
    }

    stack.getOrCreateNbt().putBoolean(RELOADING_KEY, false);
    return stack;
  }

  private int getShotsLeft(ItemStack stack) {
    return stack.getOrCreateNbt().getInt(AMMO_KEY);
  }

  private void setShotsLeft(ItemStack stack, int value) {
    stack.getOrCreateNbt().putInt(AMMO_KEY, value);
  }

  @Override
  public boolean isItemBarVisible(ItemStack stack) {
    return getShotsLeft(stack) < getMaxShots(stack);
  }

  @Override
  public int getItemBarStep(ItemStack stack) {
    return Math.round(13.0F * getShotsLeft(stack) / getMaxShots(stack));
  }

  @Override
  public int getItemBarColor(ItemStack stack) {
    return 0xFFD700;
  }

  @Override
  public boolean isEnchantable(ItemStack stack) {
    return false;
  }

  @Override
  public int getEnchantability() {
    return 0;
  }

  @Override
  public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
    tooltip.add(Text.literal("Ammo: " + getShotsLeft(stack) + "/" + getMaxShots(stack)).formatted(Formatting.GRAY));
    tooltip.add(Text.literal("Shift right click to reload.").formatted(Formatting.GRAY));
    String itemId = Registries.ITEM.getId(stack.getItem()).toString();
    String tier = switch (itemId) {
      case "lunasorigins:pistol_wooden_sword" -> "Tier: Wooden";
      case "lunasorigins:pistol_stone_sword" -> "Tier: Stone";
      case "lunasorigins:pistol_iron_sword" -> "Tier: Iron";
      case "lunasorigins:pistol_golden_sword" -> "Tier: Golden";
      case "lunasorigins:pistol_diamond_sword" -> "Tier: Diamond";
      case "lunasorigins:pistol_netherite_sword" -> "Tier: Netherite";
      default -> "Tier: Standard";
    };
    tooltip.add(Text.literal(tier).formatted(Formatting.GOLD));
  }
}
