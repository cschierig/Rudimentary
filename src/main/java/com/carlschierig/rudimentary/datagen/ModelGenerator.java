package com.carlschierig.rudimentary.datagen;

import com.carlschierig.rudimentary.block.RudimentaryBlocks;
import com.carlschierig.rudimentary.item.RudimentaryItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.createFurnace(RudimentaryBlocks.BRICK_FURNACE, TexturedModel.ORIENTABLE_ONLY_TOP);
        generator.family(RudimentaryBlocks.FURNACE_BRICKS)
                .wall(RudimentaryBlocks.FURNACE_BRICK_WALL)
                .slab(RudimentaryBlocks.FURNACE_BRICK_SLAB)
                .stairs(RudimentaryBlocks.FURNACE_BRICK_STAIRS);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(RudimentaryItems.FLAKED_FLINT, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(RudimentaryItems.FLAX, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(RudimentaryItems.FLAX_TWINE, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(RudimentaryItems.FIRE_STARTER, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(RudimentaryItems.FLINT_HATCHET, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(RudimentaryItems.FLINT_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(RudimentaryItems.UNFIRED_FURNACE_BRICK, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(RudimentaryItems.FURNACE_BRICK, ModelTemplates.FLAT_ITEM);
    }
}
