package com.carlschierig.rudimentary.item;

import com.carlschierig.rudimentary.block.RudimentaryBlocks;
import com.carlschierig.rudimentary.item.tier.RudimentaryTiers;
import com.carlschierig.rudimentary.util.Util;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

public class RudimentaryItems {

    public static final Item FLAKED_FLINT = register("flaked_flint", new Item(new Item.Properties()));
    public static final Item FLAX = register("flax", new Item(new Item.Properties()));
    public static final Item FLAX_TWINE = register("flax_twine", new Item(new Item.Properties()));
    public static final Item FLINT_HATCHET = register(
            "flint_hatchet",
            new AxeItem(RudimentaryTiers.FLINT, new Item.Properties().attributes(AxeItem.createAttributes(RudimentaryTiers.FLINT, 7, -3)))
    );
    public static final Item FLINT_PICKAXE = register(
            "flint_pickaxe",
            new AxeItem(RudimentaryTiers.FLINT, new Item.Properties().attributes(PickaxeItem.createAttributes(RudimentaryTiers.FLINT, 1, -3.2f)))
    );
    public static final Item FIRE_STARTER = register("fire_starter", new FirestarterItem(new Item.Properties().durability(1)));
    public static final Item UNFIRED_FURNACE_BRICK = register("unfired_furnace_brick", new Item(new Item.Properties()));
    public static final Item FURNACE_BRICK = register("furnace_brick", new Item(new Item.Properties()));
    public static final Item BRICK_FURNACE = register(RudimentaryBlocks.BRICK_FURNACE, new Item.Properties());
    public static final Item FURNACE_BRICKS = register(RudimentaryBlocks.FURNACE_BRICKS, new Item.Properties());
    public static final Item FURNACE_BRICK_STAIRS = register(RudimentaryBlocks.FURNACE_BRICK_STAIRS, new Item.Properties());
    public static final Item FURNACE_BRICK_SLAB = register(RudimentaryBlocks.FURNACE_BRICK_SLAB, new Item.Properties());
    public static final Item FURNACE_BRICK_WALL = register(RudimentaryBlocks.FURNACE_BRICK_WALL, new Item.Properties());

    public static void createItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(
                entries -> {
                    entries.addBefore(Items.BRICKS, FURNACE_BRICKS);
                    entries.addAfter(FURNACE_BRICKS, FURNACE_BRICK_STAIRS);
                    entries.addAfter(FURNACE_BRICK_STAIRS, FURNACE_BRICK_SLAB);
                    entries.addAfter(FURNACE_BRICK_SLAB, FURNACE_BRICK_WALL);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(
                entries -> {
                    entries.addBefore(Items.FLINT_AND_STEEL, FIRE_STARTER);
                    entries.addAfter(Items.WOODEN_HOE, FLINT_HATCHET);
                    entries.addAfter(FLINT_HATCHET, FLINT_PICKAXE);
                    entries.addAfter(FLINT_PICKAXE, FLINT_HATCHET);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(
                entries -> {
                    entries.addBefore(Items.BRICK, FURNACE_BRICK);
                    entries.addBefore(FURNACE_BRICK, UNFIRED_FURNACE_BRICK);

                    entries.addAfter(Items.STRING, FLAX);
                    entries.addAfter(FLAX, FLAX_TWINE);

                    entries.addAfter(Items.FLINT, FLAKED_FLINT);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(
                entries -> {
                    entries.addBefore(Items.FURNACE, BRICK_FURNACE);
                }
        );
    }

    private static Item register(Block block, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, BuiltInRegistries.BLOCK.getKey(block), new BlockItem(block, properties));
    }

    private static Item register(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Util.id(name), item);
    }

    public static void init() {
    }
}
