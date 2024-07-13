package com.carlschierig.rudimentary.block;

import com.carlschierig.rudimentary.block.entity.BrickFurnaceBlockEntity;
import com.carlschierig.rudimentary.block.entity.RudimentaryBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BrickFurnaceBlock extends FurnaceBlock {
    public static final MapCodec<FurnaceBlock> CODEC = simpleCodec(BrickFurnaceBlock::new);

    protected BrickFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull MapCodec<FurnaceBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, RudimentaryBlockEntities.BRICK_FURNACE, BrickFurnaceBlockEntity::brickFurnaceTick);
    }

    @Override
    protected void openContainer(Level level, BlockPos blockPos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof BrickFurnaceBlockEntity) {
            player.openMenu((MenuProvider) blockEntity);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BrickFurnaceBlockEntity(blockPos, blockState);
    }
}
