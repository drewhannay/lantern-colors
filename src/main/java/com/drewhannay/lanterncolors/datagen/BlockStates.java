package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;

import javax.annotation.Nonnull;


public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, LanternColors.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ColoredLanternBlocks.getBlocks().forEach(block -> {
            BlockModelBuilder modelLantern =
                models().getBuilder(block.getRegistryName().getPath())
                        .parent(new ModelFile.UncheckedModelFile(mcLoc("block/lantern")))
                        .texture("particle", modLoc("block/" + block.registryName()))
                        .texture("all", modLoc("block/" + block.registryName()));

            BlockModelBuilder modelHangingLantern =
                models().getBuilder(block.getRegistryName().getPath().replace("_coloredlantern", "_hanging_coloredlantern"))
                        .parent(new ModelFile.UncheckedModelFile(mcLoc("block/hanging_lantern")))
                        .texture("particle", modLoc("block/" + block.registryName()))
                        .texture("all", modLoc("block/" + block.registryName()));

            getVariantBuilder(block).forAllStates(state -> {
                BlockModelBuilder model;
                if (state.get(LanternBlock.HANGING)) {
                    model = modelHangingLantern;
                } else {
                    model = modelLantern;
                }
                return ConfiguredModel.builder().modelFile(model).build();
            });
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return LanternColors.MODID + " - BlockStates";
    }
}
