package net.snowlock.cavorite;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.snowlock.cavorite.datagen.ModModelProvider;
import net.snowlock.cavorite.datagen.ModBlockLootTableProvider;
import net.snowlock.cavorite.datagen.ModBlockTagsProvider;


public class CavoriteDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
	}
}