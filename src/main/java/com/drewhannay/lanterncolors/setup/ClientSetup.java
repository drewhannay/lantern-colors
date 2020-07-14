package com.drewhannay.lanterncolors.setup;

import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        ColoredLanternBlocks.getBlocks().forEach(block -> RenderTypeLookup.setRenderLayer(block, RenderType.getCutout()));
    }
}
