package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

public class Recipes extends ForgeRecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ColoredLanternBlocks.getBlocks().forEach(block -> {
            ShapelessRecipeBuilder.shapelessRecipe(block)
                                  .addIngredient(ItemTags.glassPaneTagForDyeColor(block.getDyeColor()))
                                  .addIngredient(ItemTags.LANTERNS)
                                  .addCriterion("has_lantern", hasItem(Blocks.LANTERN))
                                  .addCriterion("has_glass_pane", hasItem(Tags.Items.GLASS_PANES))
                                  .build(consumer);
        });
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Recipes";
    }
}
