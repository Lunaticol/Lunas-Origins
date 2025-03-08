package luna.lunasorigins.entity;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PhantomEntityModel;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.Identifier;

public class CrimsonPhantomEyesFeatureRenderer
    extends EyesFeatureRenderer<PhantomEntity, PhantomEntityModel<PhantomEntity>> {

  private static final Identifier EYES_TEXTURE = new Identifier("lunasorigins",
      "textures/entity/crimson/crimson_phantom_eyes.png");

  public CrimsonPhantomEyesFeatureRenderer(
      FeatureRendererContext<PhantomEntity, PhantomEntityModel<PhantomEntity>> context) {
    super(context);
  }

  @Override
  public RenderLayer getEyesTexture() {
    return RenderLayer.getEyes(EYES_TEXTURE);
  }
}
