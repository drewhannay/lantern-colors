package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;


public class Languages extends LanguageProvider {

    public Languages(DataGenerator gen, String locale) {
        super(gen, LanternColors.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // TODO: this probably isn't the right way to do this
        add(Registration.COLORED_LANTERN_BLOCK.get(), "Colored Lantern");
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Languages";
    }
}
