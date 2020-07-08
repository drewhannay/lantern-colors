package com.drewhannay.lanterncolors;

import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import com.drewhannay.lanterncolors.items.ColoredLanternItems;
import com.drewhannay.lanterncolors.setup.ClientSetup;
import com.drewhannay.lanterncolors.setup.ModSetup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.drewhannay.lanterncolors.LanternColors.MODID;


@Mod(MODID)
public class LanternColors {

    public static final String MODID = "lanterncolors";

    public LanternColors() {
        ColoredLanternBlocks.init();
        ColoredLanternItems.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
}
