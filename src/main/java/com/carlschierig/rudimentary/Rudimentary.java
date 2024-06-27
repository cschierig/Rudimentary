package com.carlschierig.rudimentary;

import com.carlschierig.rudimentary.item.RudimentaryItems;
import com.carlschierig.rudimentary.loot.RudimentaryLoot;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rudimentary implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("rudimentary");

    @Override
    public void onInitialize() {
        RudimentaryItems.init();

        LootTableEvents.MODIFY.register(RudimentaryLoot::modifyLootTable);
    }

}