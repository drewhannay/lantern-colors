package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ITag;

public class BlockTags extends BlockTagsProvider {

    public static final ITag.INamedTag<Block> LANTERNS = net.minecraft.tags.BlockTags.makeWrapperTag(LanternColors.MODID + ":lanterns");

    public BlockTags(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        Builder<Block> builder = getOrCreateBuilder(LANTERNS).add(Blocks.LANTERN);
        ColoredLanternBlocks.getBlocks().forEach(builder::add);
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - BlockTags";
    }
}
