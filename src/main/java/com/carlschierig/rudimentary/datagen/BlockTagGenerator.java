package com.carlschierig.rudimentary.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

import static com.carlschierig.rudimentary.block.RudimentaryBlocks.*;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookup) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
                BRICK_FURNACE,
                FURNACE_BRICKS,
                FURNACE_BRICK_SLAB,
                FURNACE_BRICK_STAIRS,
                FURNACE_BRICK_WALL
        );
    }
}
