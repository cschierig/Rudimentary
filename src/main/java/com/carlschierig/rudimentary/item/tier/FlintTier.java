package com.carlschierig.rudimentary.item.tier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class FlintTier implements Tier {
    @Override
    public int getUses() {
        return 70;
    }

    @Override
    public float getSpeed() {
        return 4.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 1.0f;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_STONE_TOOL;
    }

    @Override
    public int getEnchantmentValue() {
        return 4;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.of(Items.FLINT);
    }
}
