package luna.lunasorigins.mixin.origin;

import com.google.gson.JsonObject;
import io.github.apace100.origins.origin.Origin;
import luna.lunasorigins.origin.CustomOriginScreens;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Origin.class)
public class OriginMixin {

  /* @Inject(method = "fromJson", at = @At("RETURN"))
  private static void onFromJson(Identifier id, JsonObject jsonObject, CallbackInfoReturnable<Origin> cir) {
    Identifier backgroundId;
  
    if (jsonObject.has("background")) {
      String backgroundStr = jsonObject.get("background").getAsString();
      String[] parts = backgroundStr.split(":", 2);
      if (parts.length == 2) {
        backgroundId = new Identifier(parts[0], parts[1]);
      } else {
        System.out.println("Invalid background texture format for origin: " + id);
        backgroundId = new Identifier("lunasorigins", "textures/gui/choose_origin.png");
      }
    } else {
      // Default value if missing
      backgroundId = new Identifier("lunasorigins", "textures/gui/choose_origin.png");
    }
    CustomOriginScreens.register(id.toString(), backgroundId); // pass as Identifier, not String
  }*/
}
