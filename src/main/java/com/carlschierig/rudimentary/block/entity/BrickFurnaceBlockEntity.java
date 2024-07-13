package com.carlschierig.rudimentary.block.entity;

import com.carlschierig.rudimentary.menu.BrickFurnaceMenu;
import com.carlschierig.rudimentary.util.TranslationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BrickFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public static final String LANGUAGE_KEY = "brick_furnace";

    private byte tick = 0;

    public BrickFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RudimentaryBlockEntities.BRICK_FURNACE, blockPos, blockState, RecipeType.BLASTING);
    }

    public static void brickFurnaceTick(Level level, BlockPos pos, BlockState state, BrickFurnaceBlockEntity entity) {
        if (entity.tick++ >= 2) {
            AbstractFurnaceBlockEntity.serverTick(level, pos, state, entity);
            entity.tick = 0;
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        tick = tag.getByte("BrickFurnaceTick");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putByte("TickFurnaceTick", tick);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable(TranslationUtil.translateContainer(LANGUAGE_KEY));
    }


    @Override
    protected @NotNull AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new BrickFurnaceMenu(i, inventory, this, this.dataAccess);
    }
}
