package com.drewhannay.lanterncolors.items;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlock;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public final class ColoredLanternItems {

    public static final DeferredRegister<Item> REGISTRY
        = DeferredRegister.create(ForgeRegistries.ITEMS, LanternColors.MODID);

    private static final Map<DyeColor, RegistryObject<BlockItem>> REGISTRY_OBJECTS = new EnumMap<>(DyeColor.class);

    public static void init() {
        Stream.of(DyeColor.values())
              .forEach(dyeColor -> {
                  RegistryObject<ColoredLanternBlock> block = ColoredLanternBlocks.getRegistryObject(dyeColor);
                  RegistryObject<BlockItem> registeredObject =
                      REGISTRY.register(block.getId().getPath(),
                                        () -> new BlockItem(block.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
                  REGISTRY_OBJECTS.put(dyeColor, registeredObject);
              });

        ColoredLanternItems.REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static Stream<BlockItem> getItems() {
        return REGISTRY_OBJECTS.values().stream().map(RegistryObject::get);
    }
}
