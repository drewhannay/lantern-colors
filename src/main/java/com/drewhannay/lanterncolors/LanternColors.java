package com.drewhannay.lanterncolors;

import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import com.drewhannay.lanterncolors.items.ColoredLanternItems;
import net.minecraftforge.fml.common.Mod;

import static com.drewhannay.lanterncolors.LanternColors.MODID;


@Mod(MODID)
public class LanternColors {

    public static final String MODID = "lanterncolors";

    public LanternColors() {
        ColoredLanternBlocks.init();
        ColoredLanternItems.init();
    }
}
