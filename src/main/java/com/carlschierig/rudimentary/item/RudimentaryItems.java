package com.carlschierig.rudimentary.item;

import com.carlschierig.rudimentary.item.tier.RudimentaryTiers;
import com.carlschierig.rudimentary.util.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class RudimentaryItems {

    public static final Item FLAKED_FLINT = register("flaked_flint", new Item(new Item.Properties()));
    public static final Item FLAX = register("flax", new Item(new Item.Properties()));
    public static final Item FLAX_TWINE = register("flax_twine", new Item(new Item.Properties()));
    public static final Item FLINT_HATCHET = register(
            "flint_hatchet",
            new AxeItem(RudimentaryTiers.FLINT, new Item.Properties().attributes(AxeItem.createAttributes(RudimentaryTiers.FLINT, 8, -3)))
    );
    public static final Item FLINT_PICKAXE = register(
            "flint_pickaxe",
            new AxeItem(RudimentaryTiers.FLINT, new Item.Properties().attributes(PickaxeItem.createAttributes(RudimentaryTiers.FLINT, 4, -3.2f)))
    );
    public static final Item FIRE_STARTER = register("fire_starter", new FirestarterItem(new Item.Properties().durability(1)));

    private static Item register(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Util.id(name), item);
    }

    public static void init() {
    }
}
