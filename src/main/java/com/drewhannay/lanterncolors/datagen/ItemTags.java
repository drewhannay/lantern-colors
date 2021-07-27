package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.items.ColoredLanternItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {

    public static final Tag.Named<Item> LANTERNS = net.minecraft.tags.ItemTags.bind(LanternColors.MODID + ":lanterns");

    public ItemTags(DataGenerator generatorIn, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generatorIn, blockTagsProvider, LanternColors.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        TagAppender<Item> builder = tag(LANTERNS).add(Items.LANTERN);
        ColoredLanternItems.getItems().forEach(builder::add);
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - ItemTags";
    }

    // TODO: Is there an existing helper for this?
    public static Tag.Named<Item> glassPaneTagForDyeColor(DyeColor color) {
        switch (color) {
            case WHITE:
                return Tags.Items.GLASS_PANES_WHITE;
            case ORANGE:
                return Tags.Items.GLASS_PANES_ORANGE;
            case MAGENTA:
                return Tags.Items.GLASS_PANES_MAGENTA;
            case LIGHT_BLUE:
                return Tags.Items.GLASS_PANES_LIGHT_BLUE;
            case YELLOW:
                return Tags.Items.GLASS_PANES_YELLOW;
            case LIME:
                return Tags.Items.GLASS_PANES_LIME;
            case PINK:
                return Tags.Items.GLASS_PANES_PINK;
            case GRAY:
                return Tags.Items.GLASS_PANES_GRAY;
            case LIGHT_GRAY:
                return Tags.Items.GLASS_PANES_LIGHT_GRAY;
            case CYAN:
                return Tags.Items.GLASS_PANES_CYAN;
            case PURPLE:
                return Tags.Items.GLASS_PANES_PURPLE;
            case BLUE:
                return Tags.Items.GLASS_PANES_BLUE;
            case BROWN:
                return Tags.Items.GLASS_PANES_BROWN;
            case GREEN:
                return Tags.Items.GLASS_PANES_GREEN;
            case RED:
                return Tags.Items.GLASS_PANES_RED;
            case BLACK:
                return Tags.Items.GLASS_PANES_BLACK;
            default:
                throw new IllegalArgumentException("Unknown DyeColor " + color);
        }
    }
}
