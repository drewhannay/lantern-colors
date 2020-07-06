package com.drewhannay.lanterncolors.setup;

import net.minecraft.block.Blocks;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ModSetup {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void init(FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
