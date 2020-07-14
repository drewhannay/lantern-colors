package com.drewhannay.lanterncolors.blocks;

import com.drewhannay.lanterncolors.LanternColors;
import net.minecraft.block.Block;
import net.minecraft.item.DyeColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public final class ColoredLanternBlocks {

    public static final DeferredRegister<Block> REGISTRY =
        DeferredRegister.create(ForgeRegistries.BLOCKS, LanternColors.MODID);

    private static final Map<DyeColor, RegistryObject<ColoredLanternBlock>> REGISTRY_OBJECTS
        = new EnumMap<>(DyeColor.class);

    public static void init() {
        Stream.of(DyeColor.values())
              .forEach(dyeColor -> {
                  ColoredLanternBlock block = new ColoredLanternBlock(dyeColor);
                  RegistryObject<ColoredLanternBlock> registeredObject = REGISTRY.register(block.registryName(), () -> block);
                  REGISTRY_OBJECTS.put(dyeColor, registeredObject);
              });

        ColoredLanternBlocks.REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static RegistryObject<ColoredLanternBlock> getRegistryObject(DyeColor color) {
        return REGISTRY_OBJECTS.get(color);
    }

    public static Stream<ColoredLanternBlock> getBlocks() {
        return REGISTRY_OBJECTS.values().stream().map(RegistryObject::get);
    }
}
