package com.carlschierig.rudimentary.ui.screen;

import com.carlschierig.rudimentary.menu.RudimentaryMenus;
import net.minecraft.client.gui.screens.MenuScreens;

public class RudimentaryScreens {

    public static final void init() {
        MenuScreens.register(RudimentaryMenus.BRICK_FURNACE, BrickFurnaceScreen::new);
    }
}
