package com.carlschierig.rudimentary.menu;

import com.carlschierig.rudimentary.util.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class RudimentaryMenus {
    public static final MenuType<BrickFurnaceMenu> BRICK_FURNACE = register("brick_furnace", BrickFurnaceMenu::new);

    private static <T extends AbstractContainerMenu> MenuType<T> register(String name, MenuType.MenuSupplier<T> supplier) {
        return Registry.register(BuiltInRegistries.MENU, Util.id(name), new MenuType<>(supplier, FeatureFlags.VANILLA_SET));
    }

    public static void init() {
    }
}
