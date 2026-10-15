package net.snowlock.cavorite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.snowlock.cavorite.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CAVORITE_BLOCK)
                .add(ModBlocks.RAW_CAVORITE_BLOCK)
                .add(ModBlocks.CAVORITE_ORE)
                .add(ModBlocks.CAVORITE_DEEPSLATE_ORE);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CAVORITE_BLOCK)
                .add(ModBlocks.RAW_CAVORITE_BLOCK)
                .add(ModBlocks.CAVORITE_ORE)
                .add(ModBlocks.CAVORITE_DEEPSLATE_ORE);

    }
}