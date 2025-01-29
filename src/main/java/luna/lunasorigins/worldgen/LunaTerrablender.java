package luna.lunasorigins.worldgen;

import luna.lunasorigins.LunasOrigins;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class LunaTerrablender implements TerraBlenderApi {

  @Override
  public void onTerraBlenderInitialized() {

    Regions.register(new LunaOverworldRegion(new Identifier(LunasOrigins.MOD_ID, "overworld"), 1));
  }

}
