package luna.lunasorigins.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

public class LunaLangProvider extends FabricLanguageProvider {

  public LunaLangProvider(FabricDataOutput dataOutput,
      CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    // Specifying en_us is optional, as it's the default language code
    super(dataOutput, "en_us");
  }

  @Override
  public void generateTranslations(TranslationBuilder translationBuilder) {
    translationBuilder.add("text.fabric_docs_reference.greeting", "Hello there!");
  }
}
