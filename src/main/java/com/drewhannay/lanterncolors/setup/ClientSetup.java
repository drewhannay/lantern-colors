package com.drewhannay.lanterncolors.setup;

import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        ColoredLanternBlocks.getBlocks().forEach(block -> ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout()));
    }
}
