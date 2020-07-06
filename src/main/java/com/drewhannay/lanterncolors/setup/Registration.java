package com.drewhannay.lanterncolors.setup;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class Registration {

    private static final DeferredRegister<Block> BLOCKS =
        new DeferredRegister<>(ForgeRegistries.BLOCKS, LanternColors.MODID);

    private static final DeferredRegister<Item> ITEMS =
        new DeferredRegister<>(ForgeRegistries.ITEMS, LanternColors.MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // TODO: the hardcoded "coloredlantern" string here and elsewhere is ugly, need to find a better way to store that
    public static final RegistryObject<ColoredLanternBlock> COLORED_LANTERN_BLOCK =
        BLOCKS.register("coloredlantern", ColoredLanternBlock::new);
    public static final RegistryObject<Item> COLORED_LANTERN_ITEM =
        ITEMS.register(COLORED_LANTERN_BLOCK.getId().getPath(),
                       () -> new BlockItem(COLORED_LANTERN_BLOCK.get(),
                                           new Item.Properties().group(ItemGroup.DECORATIONS)));
}
