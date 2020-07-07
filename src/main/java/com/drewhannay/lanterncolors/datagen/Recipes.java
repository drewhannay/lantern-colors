package com.drewhannay.lanterncolors.datagen;

import com.drewhannay.lanterncolors.LanternColors;
import com.drewhannay.lanterncolors.setup.Registration;
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
        ShapelessRecipeBuilder.shapelessRecipe(Registration.COLORED_LANTERN_BLOCK.get())
                              .addIngredient(Tags.Items.GLASS_PANES)
                              .addIngredient(ItemTags.LANTERNS)
                              .addCriterion("has_lantern", hasItem(Blocks.LANTERN))
                              .addCriterion("has_glass_pane", hasItem(Tags.Items.GLASS_PANES))
                              .build(consumer);
    }

    @Override
    public String getName() {
        return LanternColors.MODID + " - Recipes";
    }
}
