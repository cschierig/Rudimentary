package com.carlschierig.rudimentary.datagen;

import com.carlschierig.immersivecrafting.api.data.ICRecipeProvider;
import com.carlschierig.immersivecrafting.api.predicate.ICPredicate;
import com.carlschierig.immersivecrafting.api.predicate.condition.BlockCondition;
import com.carlschierig.immersivecrafting.api.predicate.condition.ingredient.ItemStackIngredient;
import com.carlschierig.immersivecrafting.api.predicate.condition.stack.ICItemStack;
import com.carlschierig.immersivecrafting.api.recipe.ICRecipe;
import com.carlschierig.immersivecrafting.api.recipe.UseItemOnRecipe;
import com.carlschierig.rudimentary.item.RudimentaryItems;
import com.carlschierig.rudimentary.util.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ICRecipeGenerator extends ICRecipeProvider {
    public ICRecipeGenerator(@NotNull PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(@NotNull BiConsumer<ResourceLocation, ICRecipe> biConsumer) {
        biConsumer.accept(Util.id("flaked_flint"),
                new UseItemOnRecipe.Builder()
                        .mainHandIngredient(new ItemStackIngredient(Items.FLINT))
                        .predicate(new ICPredicate.Builder().with(new BlockCondition.Builder().hardnessMinOnly(1.5f).build()).build())
                        .addResult(new ICItemStack(new ItemStack(RudimentaryItems.FLAKED_FLINT, 2)))
                        .build()
        );
    }
}
