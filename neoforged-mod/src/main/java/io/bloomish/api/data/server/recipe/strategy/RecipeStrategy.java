package io.bloomish.api.data.server.recipe.strategy;

import io.bloomish.api.data.server.recipe.ApiRecipeProvider;
import io.bloomish.api.data.server.recipe.description.RecipeDescription;
import net.minecraft.data.recipes.RecipeOutput;
import org.jetbrains.annotations.NotNull;

public interface RecipeStrategy<T extends RecipeDescription> {
    void saveRecipe(T description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput output);
}
