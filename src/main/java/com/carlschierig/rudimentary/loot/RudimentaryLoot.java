package com.carlschierig.rudimentary.loot;

import com.carlschierig.rudimentary.item.RudimentaryItems;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RudimentaryLoot {
    private static final Set<ResourceKey<LootTable>> GRASS = Stream.of(Blocks.SHORT_GRASS, Blocks.TALL_GRASS).map(Block::getLootTable).collect(Collectors.toSet());

    public static void modifyLootTable(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source) {
        if (GRASS.contains(key) && source.isBuiltin()) {
            var builder = LootPool.lootPool()
                    .add(LootItem.lootTableItem(RudimentaryItems.FLAX))
                    .conditionally(LootItemRandomChanceCondition.randomChance(0.2f).build())
                    .setRolls(new UniformGenerator(new ConstantValue(1), new ConstantValue(3)));

            tableBuilder.withPool(builder);
        }
    }
}
