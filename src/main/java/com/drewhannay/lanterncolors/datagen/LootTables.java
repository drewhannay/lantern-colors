package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraft.world.storage.loot.ValidationTracker;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTables extends LootTableProvider {

    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>>
        lootTables = ImmutableList.of(Pair.of(BlockLootTables::new, LootParameterSets.BLOCK));

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((location, table) -> {
            LootTableManager.func_227508_a_(validationtracker, location, table);
        });
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - LootTables";
    }

    public static class BlockLootTables extends net.minecraft.data.loot.BlockLootTables {

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ColoredLanternBlocks.REGISTRY.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }

        @Override
        protected void addTables() {
            ColoredLanternBlocks.getBlocks().forEach(this::registerDropSelfLootTable);
        }
    }
}
