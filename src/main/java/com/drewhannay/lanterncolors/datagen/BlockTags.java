package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTags extends BlockTagsProvider {

    public static final Tag.Named<Block> LANTERNS = net.minecraft.tags.BlockTags.bind(LanternColors.MODID + ":lanterns");

    public BlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, LanternColors.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        TagAppender<Block> lanternTag = tag(LANTERNS).add(Blocks.LANTERN);
        TagAppender<Block> mineableTag = tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE);
        ColoredLanternBlocks.getBlocks().forEach(block -> {
            lanternTag.add(block);
            mineableTag.add(block);
        });

    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - BlockTags";
    }
}
