package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class BlockTags extends BlockTagsProvider {

    public static final Tag<Block> LANTERNS =
        new net.minecraft.tags.BlockTags.Wrapper(new ResourceLocation(LanternColors.MODID, "lanterns"));

    public BlockTags(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        getBuilder(LANTERNS).add(Blocks.LANTERN).add(Registration.COLORED_LANTERN_BLOCK.get());
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - BlockTags";
    }
}
