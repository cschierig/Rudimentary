package com.carlschierig.rudimentary.datagen;

import com.carlschierig.rudimentary.item.RudimentaryItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(RudimentaryItems.FLAKED_FLINT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(RudimentaryItems.FLAX, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(RudimentaryItems.FLAX_TWINE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(RudimentaryItems.FIRE_STARTER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(RudimentaryItems.FLINT_HATCHET, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(RudimentaryItems.FLINT_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
