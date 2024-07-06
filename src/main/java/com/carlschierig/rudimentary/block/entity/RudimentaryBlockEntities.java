package com.carlschierig.rudimentary.block.entity;

import com.carlschierig.rudimentary.block.RudimentaryBlocks;
import com.carlschierig.rudimentary.util.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class RudimentaryBlockEntities {
    public static final BlockEntityType<BrickFurnaceBlockEntity> BRICK_FURNACE = register(
            "brick_furnace",
            BlockEntityType.Builder.of(BrickFurnaceBlockEntity::new, RudimentaryBlocks.BRICK_FURNACE).build()
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Util.id(name), type);
    }

    public static void init() {
    }
}
