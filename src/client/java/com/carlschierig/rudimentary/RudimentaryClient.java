package com.carlschierig.rudimentary;

import com.carlschierig.rudimentary.ui.screen.RudimentaryScreens;
import net.fabricmc.api.ClientModInitializer;

public class RudimentaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RudimentaryScreens.init();
    }
}