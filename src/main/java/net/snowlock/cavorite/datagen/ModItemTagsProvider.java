package net.snowlock.cavorite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.snowlock.cavorite.item.ModItems;
import net.snowlock.cavorite.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.CAVORITE_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.CAVORITE_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.CAVORITE_SHOVEL);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.CAVORITE_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.CAVORITE_HOE);
    }
}