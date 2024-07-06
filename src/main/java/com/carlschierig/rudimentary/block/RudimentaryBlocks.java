package com.carlschierig.rudimentary.block;

import com.carlschierig.rudimentary.util.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class RudimentaryBlocks {

    public static final Block BRICK_FURNACE = register("brick_furnace", new BrickFurnaceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(3.5F)
            .lightLevel(Blocks.litBlockEmission(13)))
    );
    public static final Block FURNACE_BRICKS = register("furnace_bricks", new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(2.0F, 6.0F))
    );
    public static final Block FURNACE_BRICK_STAIRS = registerStairs("furnace_brick_stairs", FURNACE_BRICKS);
    public static final Block FURNACE_BRICK_SLAB = registerSlab("furnace_brick_slab", BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(2.0F, 6.0F)
    );
    public static final Block FURNACE_BRICK_WALL = registerWall("furnace_brick_wall", FURNACE_BRICKS);


    private static <T extends Block> T register(String name, T block) {
        return Registry.register(BuiltInRegistries.BLOCK, Util.id(name), block);
    }

    private static Block registerStairs(String name, Block block) {

        return register(name, new StairBlock(block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block)));
    }

    private static Block registerSlab(String name, BlockBehaviour.Properties properties) {
        return register(name, new SlabBlock(properties));
    }

    private static Block registerWall(String name, Block block) {
        return register(name, new WallBlock(BlockBehaviour.Properties.ofFullCopy(block)));
    }

    public static void init() {
    }

}
