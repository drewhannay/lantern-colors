package com.drewhannay.lanterncolors.blocks;


import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ColoredLanternBlock extends LanternBlock {

    private final DyeColor color;

    public ColoredLanternBlock(DyeColor color) {
        super(BlockBehaviour.Properties.copy(Blocks.LANTERN));
        this.color = color;
    }

    public String registryName() {
        return color.getName() + "_coloredlantern";
    }

    public DyeColor getDyeColor() {
        return color;
    }
}
