package com.drewhannay.lanterncolors;

import com.drewhannay.lanterncolors.setup.ClientSetup;
import com.drewhannay.lanterncolors.setup.ModSetup;
import com.drewhannay.lanterncolors.setup.Registration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.drewhannay.lanterncolors.LanternColors.MODID;


@Mod(MODID)
public class LanternColors {

    public static final String MODID = "lanterncolors";

    private static final Logger LOGGER = LogManager.getLogger();

    public LanternColors() {
        Registration.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
}
