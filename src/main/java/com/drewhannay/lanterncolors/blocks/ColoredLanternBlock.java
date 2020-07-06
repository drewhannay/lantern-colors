package com.drewhannay.lanterncolors.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class ColoredLanternBlock extends LanternBlock {

    public ColoredLanternBlock() {
        super(
            Block.Properties.create(Material.IRON)
                            .hardnessAndResistance(3.5F)
                            .sound(SoundType.LANTERN)
                            .lightValue(15)
                            .notSolid()
        );
    }
}
