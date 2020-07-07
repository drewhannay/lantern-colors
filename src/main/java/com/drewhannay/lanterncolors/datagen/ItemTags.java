package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ItemTags extends ItemTagsProvider {

    public static final Tag<Item> LANTERNS =
        new net.minecraft.tags.ItemTags.Wrapper(new ResourceLocation(LanternColors.MODID, "lanterns"));

    public ItemTags(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        getBuilder(LANTERNS).add(Items.LANTERN).add(Registration.COLORED_LANTERN_ITEM.get());
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - ItemTags";
    }
}
