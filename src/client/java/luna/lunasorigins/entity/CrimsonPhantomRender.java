package luna.lunasorigins.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PhantomEntityRenderer;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.Identifier;

public class CrimsonPhantomRender extends PhantomEntityRenderer {
  private static final Identifier TEXTURE = new Identifier("lunasorigins",
      "textures/entity/crimson/crimson_phantom.png");

  public CrimsonPhantomRender(EntityRendererFactory.Context context) {
    super(context);
    this.features.clear();
    this.addFeature(new CrimsonPhantomEyesFeatureRenderer(this));
  }

  @Override
  public Identifier getTexture(PhantomEntity entity) {
    return TEXTURE;
  }

}
