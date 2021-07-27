package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Languages extends LanguageProvider {

    public Languages(DataGenerator gen, String locale) {
        super(gen, LanternColors.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // TODO: this probably isn't the right way to do this
        ColoredLanternBlocks.getBlocks().forEach(block -> add(block, getTranslationName(block.getDyeColor()) + " Lantern"));
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Languages";
    }

    private String getTranslationName(DyeColor color) {
        return Arrays.stream(StringUtils.split(color.getName(), "_")).map(StringUtils::capitalise).collect(Collectors.joining(" "));
    }
}
