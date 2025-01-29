package luna.lunasorigins;

import luna.lunasorigins.datagen.LunaLangProvider;
import luna.lunasorigins.datagen.LunaModelProvider;
import luna.lunasorigins.datagen.LunaWorldGenerator;
import luna.lunasorigins.worldgen.LunaFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class LunasOriginsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(LunaModelProvider::new);
		pack.addProvider(LunaLangProvider::new);
		pack.addProvider(LunaWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, LunaFeatures::bootstrap);
	}
}
