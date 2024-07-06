package com.carlschierig.rudimentary.block.entity;

import com.carlschierig.rudimentary.menu.BrickFurnaceMenu;
import com.carlschierig.rudimentary.util.TranslationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BrickFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public static final String LANGUAGE_KEY = "brick_furnace";

    public BrickFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RudimentaryBlockEntities.BRICK_FURNACE, blockPos, blockState, RecipeType.BLASTING);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable(TranslationUtil.translateContainer(LANGUAGE_KEY));
    }

    @Override
    protected int getBurnDuration(ItemStack itemStack) {
        return (int) (super.getBurnDuration(itemStack) * 1.5);
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new BrickFurnaceMenu(i, inventory, this, this.dataAccess);
    }
}
