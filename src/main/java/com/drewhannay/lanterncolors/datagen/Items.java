package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlock;
import com.drewhannay.lanterncolors.items.ColoredLanternItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;


public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, LanternColors.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ColoredLanternItems.getItems().forEach(item -> {
            // TODO: Can we do this without casting?
            ColoredLanternBlock block = (ColoredLanternBlock) item.getBlock();
            getBuilder(item.getRegistryName().getPath())
                .parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/" + block.registryName()));
        });
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Items";
    }
}
