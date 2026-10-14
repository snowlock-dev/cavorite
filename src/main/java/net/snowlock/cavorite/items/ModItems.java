package net.snowlock.cavorite.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.snowlock.cavorite.Cavorite;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item RAW_CAVORITE = registerItem("raw_cavorite", Item::new);
    public static final Item CAVORITE_INGOT = registerItem("cavorite_ingot", Item::new);
    public static final Item CAVORITE_PLATE = registerItem("cavorite_plate", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Cavorite.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Cavorite.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Cavorite.LOGGER.info("Registering Mod Items for " + Cavorite.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(RAW_CAVORITE);
            output.accept(CAVORITE_INGOT);
            output.accept(CAVORITE_PLATE);
        });
    }
}