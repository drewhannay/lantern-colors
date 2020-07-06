package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;


public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, LanternColors.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        getBuilder(Registration.COLORED_LANTERN_ITEM.get().getRegistryName().getPath())
            .parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
            .texture("layer0", modLoc("item/coloredlantern"));
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Items";
    }
}
