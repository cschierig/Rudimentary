package com.carlschierig.rudimentary.datagen;

import com.carlschierig.rudimentary.item.RudimentaryItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {

    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.AXES).add(RudimentaryItems.FLINT_HATCHET);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(RudimentaryItems.FLINT_PICKAXE);
        getOrCreateTagBuilder(ConventionalItemTags.STRINGS).add(RudimentaryItems.FLAX_TWINE);
        getOrCreateTagBuilder(ConventionalItemTags.BRICKS).add(RudimentaryItems.FURNACE_BRICK);
    }
}
