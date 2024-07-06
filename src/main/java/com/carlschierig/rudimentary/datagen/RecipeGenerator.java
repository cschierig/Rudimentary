package com.carlschierig.rudimentary.datagen;

import com.carlschierig.rudimentary.block.RudimentaryBlockFamilies;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

import static com.carlschierig.rudimentary.item.RudimentaryItems.*;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        // Flax Twine
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, FLAX_TWINE)
                .requires(Ingredient.of(FLAX), 3)
                .unlockedBy(getHasName(FLAX_TWINE), has(FLAX_TWINE))
                .unlockedBy(getHasName(FLAX), has(FLAX))
                .save(exporter);
        // Flint Hatchet
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FLINT_HATCHET)
                .pattern("ft").pattern(" s")
                .define('f', FLAKED_FLINT)
                .define('t', ConventionalItemTags.STRINGS)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(FLINT_HATCHET), has(FLINT_HATCHET))
                .unlockedBy(getHasName(FLAKED_FLINT), has(FLAKED_FLINT))
                .unlockedBy(getHasName(Items.STRING), has(ConventionalItemTags.STRINGS))
                .unlockedBy(getHasName(Items.STICK), has(ConventionalItemTags.WOODEN_RODS))
                .save(exporter);
        // Flint Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FLINT_PICKAXE)
                .pattern("ftf").pattern(" s ").pattern(" s ")
                .define('f', FLAKED_FLINT)
                .define('t', ConventionalItemTags.STRINGS)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(FLINT_PICKAXE), has(FLINT_PICKAXE))
                .unlockedBy(getHasName(FLAKED_FLINT), has(FLAKED_FLINT))
                .unlockedBy(getHasName(Items.STRING), has(ConventionalItemTags.STRINGS))
                .unlockedBy(getHasName(Items.STICK), has(ConventionalItemTags.WOODEN_RODS))
                .save(exporter);
        // Fire starter
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.TOOLS, FIRE_STARTER)
                .requires(Ingredient.of(ConventionalItemTags.WOODEN_RODS), 2)
                .requires(Ingredient.of(FLAX))
                .unlockedBy(getHasName(Items.STICK), has(ConventionalItemTags.WOODEN_RODS))
                .unlockedBy(getHasName(FLAX), has(FLAX))
                .save(exporter);
        // Campfire
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CAMPFIRE)
                .pattern(" s ").pattern("sfs").pattern("lll")
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .define('f', FIRE_STARTER)
                .define('l', ItemTags.LOGS)
                .unlockedBy(getHasName(Items.STICK), has(ConventionalItemTags.WOODEN_RODS))
                .unlockedBy(getHasName(FIRE_STARTER), has(FIRE_STARTER))
                .unlockedBy("logs", has(ItemTags.LOGS))
                .save(exporter);
        // Unfired furnace bricks
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UNFIRED_FURNACE_BRICK, 4)
                .pattern(" c ").pattern("csc").pattern(" c ")
                .define('s', ItemTags.SAND)
                .define('c', Items.CLAY_BALL)
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .unlockedBy(getHasName(Items.SAND), has(ItemTags.SAND))
                .save(exporter);
        // Furnace brick
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(UNFIRED_FURNACE_BRICK), RecipeCategory.MISC, FURNACE_BRICK, 0.35f, 300)
                .unlockedBy(getHasName(UNFIRED_FURNACE_BRICK), has(UNFIRED_FURNACE_BRICK))
                .save(exporter);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(UNFIRED_FURNACE_BRICK), RecipeCategory.MISC, FURNACE_BRICK, 0.35f, 300)
                .unlockedBy(getHasName(UNFIRED_FURNACE_BRICK), has(UNFIRED_FURNACE_BRICK))
                .save(exporter, "furnace_brick_blasting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(UNFIRED_FURNACE_BRICK), RecipeCategory.MISC, FURNACE_BRICK, 0.35f, 300)
                .unlockedBy(getHasName(UNFIRED_FURNACE_BRICK), has(UNFIRED_FURNACE_BRICK))
                .save(exporter, "furnace_brick_smelting");
        // Furnace
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BRICK_FURNACE)
                .pattern("bbb").pattern("b b").pattern("bbb")
                .define('b', FURNACE_BRICK)
                .unlockedBy(getHasName(FURNACE_BRICK), has(FURNACE_BRICK))
                .save(exporter);
        // Bricks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FURNACE_BRICKS)
                .pattern("bb").pattern("bb")
                .define('b', FURNACE_BRICKS)
                .unlockedBy(getHasName(FURNACE_BRICK), has(FURNACE_BRICK))
                .save(exporter);
        generateRecipes(exporter, RudimentaryBlockFamilies.FURNACE_BRICKS, FeatureFlags.VANILLA_SET);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, FURNACE_BRICK_SLAB, FURNACE_BRICKS, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, FURNACE_BRICK_STAIRS, FURNACE_BRICKS);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, FURNACE_BRICK_WALL, FURNACE_BRICKS);
    }
}
