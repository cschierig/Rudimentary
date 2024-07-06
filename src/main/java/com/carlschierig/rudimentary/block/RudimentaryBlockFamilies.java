package com.carlschierig.rudimentary.block;

import net.minecraft.data.BlockFamily;

public class RudimentaryBlockFamilies {
    public static final BlockFamily FURNACE_BRICKS = new BlockFamily.Builder(RudimentaryBlocks.FURNACE_BRICKS)
            .wall(RudimentaryBlocks.FURNACE_BRICK_WALL)
            .stairs(RudimentaryBlocks.FURNACE_BRICK_STAIRS)
            .slab(RudimentaryBlocks.FURNACE_BRICK_SLAB)
            .getFamily();

    public static void init() {
    }
}
