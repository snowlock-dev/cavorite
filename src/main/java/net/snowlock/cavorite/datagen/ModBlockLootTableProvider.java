package net.snowlock.cavorite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.snowlock.cavorite.block.ModBlocks;
import net.snowlock.cavorite.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.CAVORITE_BLOCK);
        dropSelf(ModBlocks.RAW_CAVORITE_BLOCK);

        add(ModBlocks.CAVORITE_ORE, createOreDrop(ModBlocks.CAVORITE_ORE, ModItems.RAW_CAVORITE));
        add(ModBlocks.CAVORITE_DEEPSLATE_ORE, createOreDrop(ModBlocks.CAVORITE_DEEPSLATE_ORE, ModItems.RAW_CAVORITE));

    }

}