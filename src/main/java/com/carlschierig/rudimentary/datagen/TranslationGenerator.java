package com.carlschierig.rudimentary.datagen;

import com.carlschierig.rudimentary.item.RudimentaryItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class TranslationGenerator extends FabricLanguageProvider {
    protected TranslationGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(RudimentaryItems.FLAKED_FLINT, "Flaked Flint");
        translationBuilder.add(RudimentaryItems.FLAX, "Flax");
        translationBuilder.add(RudimentaryItems.FLAX_TWINE, "Flax Twine");
        translationBuilder.add(RudimentaryItems.FLINT_HATCHET, "Flint Hatchet");
        translationBuilder.add(RudimentaryItems.FLINT_PICKAXE, "Flint Pickaxe");
        translationBuilder.add(RudimentaryItems.FIRE_STARTER, "Fire Starter");
    }
}
