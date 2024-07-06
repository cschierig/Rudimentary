package com.carlschierig.rudimentary.datagen;

import com.carlschierig.rudimentary.block.RudimentaryBlocks;
import com.carlschierig.rudimentary.block.entity.BrickFurnaceBlockEntity;
import com.carlschierig.rudimentary.item.RudimentaryItems;
import com.carlschierig.rudimentary.util.TranslationUtil;
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
        translationBuilder.add(RudimentaryItems.FURNACE_BRICK, "Furnace Brick");
        translationBuilder.add(RudimentaryItems.UNFIRED_FURNACE_BRICK, "Unfired Furnace Brick");

        translationBuilder.add(RudimentaryBlocks.FURNACE_BRICKS, "Furnace Bricks");
        translationBuilder.add(RudimentaryBlocks.FURNACE_BRICK_STAIRS, "Furnace Brick Stairs");
        translationBuilder.add(RudimentaryBlocks.FURNACE_BRICK_SLAB, "Furnace Brick Slab");
        translationBuilder.add(RudimentaryBlocks.FURNACE_BRICK_WALL, "Furnace Brick Wall");
        translationBuilder.add(RudimentaryBlocks.BRICK_FURNACE, "Brick Furnace");
        translationBuilder.add(TranslationUtil.translateContainer(BrickFurnaceBlockEntity.LANGUAGE_KEY), "Brick Furnace");
    }
}
