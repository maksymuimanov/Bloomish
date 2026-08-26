package io.bloomish.api.data.server.recipe.strategy;

import io.bloomish.api.data.server.recipe.ApiRecipeProvider;
import io.bloomish.api.data.server.recipe.description.SmeltingRecipeDescription;
import io.bloomish.api.engine.context.ModContext;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class SmeltingRecipeStrategy implements RecipeStrategy<SmeltingRecipeDescription> {
    @Override
    public void saveRecipe(SmeltingRecipeDescription description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(description.getIngredient()), description.getRecipeCategory(), description.getResult(),
                        description.getExperience(), description.getCookingTime())
                .group(description.getGroup())
                .unlockedBy(ApiRecipeProvider.getHasName(description.getIngredient()), ApiRecipeProvider.has(description.getIngredient()))
                .save(recipeOutput, ModContext.currentMod.getModId() + ":" + ApiRecipeProvider.getItemName(description.getResult()) + description.getName() + "_" + ApiRecipeProvider.getItemName(description.getIngredient()));
    }
}
