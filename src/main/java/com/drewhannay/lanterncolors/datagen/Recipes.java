package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ColoredLanternBlocks.getBlocks().forEach(block -> {
            ShapelessRecipeBuilder.shapelessRecipe(block)
                                  .addIngredient(ItemTags.glassPaneTagForDyeColor(block.getDyeColor()))
                                  .addIngredient(ItemTags.LANTERNS)
                                  .addCriterion("has_lantern", hasItem(ItemTags.LANTERNS))
                                  .build(consumer);
        });
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Recipes";
    }
}
