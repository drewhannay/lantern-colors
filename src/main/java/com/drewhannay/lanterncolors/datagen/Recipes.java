package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.blocks.ColoredLanternBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ColoredLanternBlocks.getBlocks().forEach(block -> {
            ShapelessRecipeBuilder.shapeless(block)
                                  .requires(ItemTags.glassPaneTagForDyeColor(block.getDyeColor()))
                                  .requires(ItemTags.LANTERNS)
                                  .unlockedBy("has_lantern", has(ItemTags.LANTERNS))
                                  .save(consumer);
        });
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Recipes";
    }
}
