package net.snowlock.cavorite.tags;

import net.snowlock.cavorite.Cavorite;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CAVORITE_TOOL = createTag("needs_cavorite_tool");
        public static final TagKey<Block> INCORRECT_FOR_CAVORITE_TOOL = createTag("incorrect_for_cavorite_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Cavorite.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CAVORITE_REPAIR = createTag("cavorite_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Cavorite.MOD_ID, name));
        }
    }
}