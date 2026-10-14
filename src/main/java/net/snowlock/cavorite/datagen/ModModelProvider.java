package net.snowlock.cavorite.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.snowlock.cavorite.item.ModItems;
import net.snowlock.cavorite.block.ModBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.CAVORITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_CAVORITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.CAVORITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.CAVORITE_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.RAW_CAVORITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CAVORITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CAVORITE_PLATE, ModelTemplates.FLAT_ITEM);
    }
}