package com.carlschierig.rudimentary.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static com.carlschierig.rudimentary.block.RudimentaryBlocks.*;

public class BlockLootTableGenerator extends FabricBlockLootTableProvider {
    protected BlockLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(BRICK_FURNACE);
        dropSelf(FURNACE_BRICKS);
        dropSelf(FURNACE_BRICK_SLAB);
        dropSelf(FURNACE_BRICK_STAIRS);
        dropSelf(FURNACE_BRICK_WALL);
    }
}
