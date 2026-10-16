package net.snowlock.cavorite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.snowlock.cavorite.block.ModBlocks;
import net.snowlock.cavorite.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> CAVORITE_SMELTABLES = List.of(ModItems.RAW_CAVORITE, ModBlocks.CAVORITE_ORE, ModBlocks.CAVORITE_DEEPSLATE_ORE);

                oreSmelting(CAVORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.CAVORITE_INGOT, 0.25f, 300, "cavorite");
                oreBlasting(CAVORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.CAVORITE_INGOT, 0.25f, 150, "cavorite");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.CAVORITE_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CAVORITE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_CAVORITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_CAVORITE_BLOCK);

                shaped(RecipeCategory.MISC, ModItems.CAVORITE_PLATE, 2)
                        .pattern("cc")
                        .pattern("cc")
                        .define('c', ModItems.CAVORITE_INGOT)
                        .unlockedBy(getHasName(ModItems.CAVORITE_INGOT), has(ModItems.CAVORITE_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.CAVORITE_SWORD)
                        .pattern("ici")
                        .pattern("ici")
                        .pattern(" S ")
                        .define('c', ModItems.CAVORITE_INGOT)
                        .define('S', Items.STICK)
                        .define('i', Items.IRON_INGOT)
                        .unlockedBy(getHasName(ModItems.CAVORITE_INGOT), has(ModItems.CAVORITE_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.CAVORITE_PICKAXE)
                        .pattern("cCc")
                        .pattern("iSi")
                        .pattern(" S ")
                        .define('c', ModItems.CAVORITE_INGOT)
                        .define('C', ModItems.CAVORITE_PLATE)
                        .define('i', Items.IRON_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.CAVORITE_INGOT), has(ModItems.CAVORITE_INGOT))
                        .unlockedBy(getHasName(ModItems.CAVORITE_PLATE), has(ModItems.CAVORITE_PLATE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.CAVORITE_SHOVEL)
                        .pattern(" c ")
                        .pattern(" i ")
                        .pattern(" S ")
                        .define('c', ModItems.CAVORITE_INGOT)
                        .define('i', Items.IRON_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.CAVORITE_INGOT), has(ModItems.CAVORITE_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.CAVORITE_AXE)
                        .pattern(" cc")
                        .pattern(" Si")
                        .pattern(" S ")
                        .define('c', ModItems.CAVORITE_INGOT)
                        .define('i', Items.IRON_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.CAVORITE_INGOT), has(ModItems.CAVORITE_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.CAVORITE_HOE)
                        .pattern(" cc")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('c', ModItems.CAVORITE_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.CAVORITE_INGOT), has(ModItems.CAVORITE_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .save(output);

            }
        };
    }

    @Override
    public String getName() {
        return "Cavorite Recipes";
    }
}