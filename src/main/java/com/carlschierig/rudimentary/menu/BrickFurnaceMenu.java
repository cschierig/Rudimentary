package com.carlschierig.rudimentary.menu;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;

public class BrickFurnaceMenu extends AbstractFurnaceMenu {
    public BrickFurnaceMenu(int i, Inventory inventory) {
        super(RudimentaryMenus.BRICK_FURNACE, RecipeType.BLASTING, RecipeBookType.FURNACE, i, inventory);
    }

    public BrickFurnaceMenu(int i, Inventory inventory, Container container, ContainerData containerData) {
        super(RudimentaryMenus.BRICK_FURNACE, RecipeType.BLASTING, RecipeBookType.FURNACE, i, inventory, container, containerData);
    }
}
