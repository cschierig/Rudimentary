package com.carlschierig.rudimentary.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
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
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CAMPFIRE)
                .pattern(" s ").pattern("sfs").pattern("lll")
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .define('f', FIRE_STARTER)
                .define('l', ItemTags.LOGS)
                .unlockedBy(getHasName(Items.STICK), has(ConventionalItemTags.WOODEN_RODS))
                .unlockedBy(getHasName(FIRE_STARTER), has(FIRE_STARTER))
                .unlockedBy("logs", has(ItemTags.LOGS))
                .save(exporter);
    }
}
