package luna.lunasorigins.mixin.client.origin;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.screen.OriginDisplayScreen;
import luna.lunasorigins.origin.CustomOriginScreens;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.HoveredTooltipPositioner;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Language;
import java.util.List;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.origins.badge.Badge;
import io.github.apace100.origins.badge.BadgeManager;
import io.github.apace100.origins.mixin.DrawContextAccessor;

import java.lang.reflect.Method;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Shadow;

@Environment(EnvType.CLIENT)
@Mixin(OriginDisplayScreen.class)
public class OriginDisplayScreenMixin {
  /*
  @Shadow
  private int guiLeft;
  @Shadow
  private int guiTop;
  @Shadow
  private int scrollPos;
  @Shadow
  private int currentMaxScroll;
  @Shadow
  private static int windowWidth;
  @Shadow
  private static int windowHeight;
  @Shadow
  private boolean isOriginRandom;
  @Shadow
  private Text randomOriginText;
  @Shadow
  private boolean scrolling;
  @Shadow
  private float time = 0;

  private final List<Object> renderedBadges = new java.util.ArrayList<>();

  private TextRenderer getTextRenderer() {
    return MinecraftClient.getInstance().textRenderer;
  }

  private void renderBadgeTooltip(DrawContext context, int mouseX, int mouseY) {
    int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
    TextRenderer textRenderer = getTextRenderer();
    for (Object obj : renderedBadges) {
      try {
        PowerType<?> powerType = (PowerType<?>) ((Object[])obj)[0];
        Badge badge = (Badge) ((Object[])obj)[1];
        int x = (int) ((Object[])obj)[2];
        int y = (int) ((Object[])obj)[3];
        if (mouseX >= x && mouseX < x + 9 && mouseY >= y && mouseY < y + 9 && badge.hasTooltip()) {
          int widthLimit = width - mouseX - 24;
          java.util.List<TooltipComponent> tooltip = badge.getTooltipComponents(powerType, widthLimit, this.time, textRenderer);
          ((DrawContextAccessor) context).invokeDrawTooltip(
              textRenderer, tooltip, mouseX, mouseY, HoveredTooltipPositioner.INSTANCE);
          break;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private void renderOriginContent(DrawContext context, int mouseX, int mouseY) {
    renderedBadges.clear();
    TextRenderer textRenderer = getTextRenderer();
    int textWidth = windowWidth - 48;
    Origin origin = ((OriginDisplayScreen) (Object) this).getCurrentOrigin();
    int x = guiLeft + 18;
    int y = guiTop + 50;
    int startY = y;
    int endY = y - 72 + windowHeight;
    y -= scrollPos;
    Text orgDesc = origin.getDescription();
    List<OrderedText> descLines = textRenderer.wrapLines(orgDesc, textWidth);
    for (OrderedText line : descLines) {
      if (y >= startY - 18 && y <= endY + 12) {
        context.drawText(textRenderer, line, x + 2, y - 6, 0xCCCCCC, false);
      }
      y += 12;
    }
    if (isOriginRandom) {
      List<OrderedText> drawLines = textRenderer.wrapLines(randomOriginText, textWidth);
      for (OrderedText line : drawLines) {
        y += 12;
        if (y >= startY - 24 && y <= endY + 12) {
          context.drawText(textRenderer, line, x + 2, y, 0xCCCCCC, false);
        }
      }
      y += 14;
    } else {
      for (PowerType<?> p : origin.getPowerTypes()) {
        if (p.isHidden()) {
          continue;
        }
        OrderedText name = Language.getInstance()
            .reorder(textRenderer.trimToWidth(p.getName().formatted(Formatting.UNDERLINE), textWidth));
        Text desc = p.getDescription();
        List<OrderedText> drawLines = textRenderer.wrapLines(desc, textWidth);
        if (y >= startY - 24 && y <= endY + 12) {
          context.drawText(textRenderer, name, x, y, 0xFFFFFF, false);
          int tw = textRenderer.getWidth(name);
          List<Badge> badges = BadgeManager.getPowerBadges(p.getIdentifier());
          int xStart = x + tw + 4;
          int bi = 0;
          for (Badge badge : badges) {
            Object[] renderedBadge = new Object[] { p, badge, xStart + 10 * bi, y - 1 };
            renderedBadges.add(renderedBadge);
            context.drawTexture(badge.spriteId(), xStart + 10 * bi, y - 1, 0, 0, 9, 9, 9, 9);
            bi++;
          }
        }
        for (OrderedText line : drawLines) {
          y += 12;
          if (y >= startY - 24 && y <= endY + 12) {
            context.drawText(textRenderer, line, x + 2, y, 0xCCCCCC, false);
          }
        }
        y += 14;
      }
    }
    y += scrollPos;
    currentMaxScroll = y - 14 - (guiTop + 158);
    if (currentMaxScroll < 0) {
      currentMaxScroll = 0;
    }
  }

  @Inject(method = "renderOriginWindow", at = @At("HEAD"), cancellable = true)
  private void CustomBackground(DrawContext context, int mouseX, int mouseY, CallbackInfo ci) {
    OriginDisplayScreen self = (OriginDisplayScreen) (Object) this;
    Origin origin = self.getCurrentOrigin();
    Identifier customBackground = CustomOriginScreens.get(origin.getIdentifier().toString());
    if (customBackground != null) {
      try {
        int guiLeft = this.guiLeft;
        int guiTop = this.guiTop;
        RenderSystem.setShaderTexture(0, customBackground);
        context.drawTexture(customBackground, guiLeft, guiTop, 0, 0, 0, 176, 182, 256, 256);
        renderOriginContent(context, mouseX, mouseY);
        context.drawTexture(customBackground, guiLeft, guiTop + 169, 0, 169, 175, 13, 256, 256);
        context.drawTexture(customBackground, guiLeft + 10, guiTop + 10, 0, 182, 150, 26, 256, 256);
        Method renderOriginNameMethod = OriginDisplayScreen.class.getDeclaredMethod("renderOriginName",
            DrawContext.class);
        Method renderOriginImpactMethod = OriginDisplayScreen.class.getDeclaredMethod("renderOriginImpact",
            DrawContext.class, int.class, int.class);
        renderOriginNameMethod.setAccessible(true);
        renderOriginImpactMethod.setAccessible(true);
        renderOriginNameMethod.invoke(self, context);
        renderOriginImpactMethod.invoke(self, context, mouseX, mouseY);
        renderBadgeTooltip(context, mouseX, mouseY);
        ci.cancel();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    ci.cancel();
  }

  @Inject(method = "renderScrollbar", at = @At("HEAD"), cancellable = true)
  private void CustomScrollbar(DrawContext context, int mouseX, int mouseY, CallbackInfo ci) {
    OriginDisplayScreen self = (OriginDisplayScreen) (Object) this;
    Origin origin = self.getCurrentOrigin();
    Identifier customBackground = CustomOriginScreens.get(origin.getIdentifier().toString());
    if (customBackground != null) {
      try {
        int guiLeft = this.guiLeft;
        int guiTop = this.guiTop;
        int scrollPos = this.scrollPos;
        int currentMaxScroll = this.currentMaxScroll;
        if (currentMaxScroll <= 0) {
          ci.cancel();
          return;
        }
        RenderSystem.setShaderTexture(0, customBackground);
        context.drawTexture(customBackground, guiLeft + 155, guiTop + 35, 188, 24, 8, 134);
        int scrollbarY = 36;
        int maxScrollbarOffset = 141;
        int u = 176;
        float part = scrollPos / (float) currentMaxScroll;
        scrollbarY += (maxScrollbarOffset - scrollbarY) * part;
        if (scrolling || (mouseX >= guiLeft + 156 && mouseX < guiLeft + 162 &&
            mouseY >= guiTop + scrollbarY && mouseY < guiTop + scrollbarY + 27)) {
          u += 6;
        }
        context.drawTexture(customBackground, guiLeft + 156, guiTop + scrollbarY, u, 24, 6, 27);
        ci.cancel();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
   }
  */
}
