package net.snowlock.cavorite.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.snowlock.cavorite.Cavorite;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {
    public static final Item RAW_CAVORITE = registerItem("raw_cavorite", Item::new);
    public static final Item CAVORITE_INGOT = registerItem("cavorite_ingot", Item::new);
    public static final Item CAVORITE_PLATE = registerItem("cavorite_plate", Item::new);
    
    public static final Item CAVORITE_SWORD = registerItem("cavorite_sword", properties -> new Item(properties.sword(ModToolMaterials.CAVORITE, 3, -2.4f)));
    public static final Item CAVORITE_PICKAXE = registerItem("cavorite_pickaxe", properties -> new Item(properties.pickaxe(ModToolMaterials.CAVORITE, 1, -2.8f)));
    public static final Item CAVORITE_SHOVEL = registerItem("cavorite_shovel", properties -> new ShovelItem(ModToolMaterials.CAVORITE, 1.5f, -3.0f, properties));
    public static final Item CAVORITE_AXE = registerItem("cavorite_axe", properties -> new AxeItem(ModToolMaterials.CAVORITE, 6f, -3.2f, properties));
    public static final Item CAVORITE_HOE = registerItem("cavorite_hoe", properties -> new HoeItem(ModToolMaterials.CAVORITE, 0f, -3.0f, properties));



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

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(CAVORITE_SWORD);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(CAVORITE_PICKAXE);
            output.accept(CAVORITE_AXE);
            output.accept(CAVORITE_SHOVEL);
            output.accept(CAVORITE_HOE);
        });
    }
}