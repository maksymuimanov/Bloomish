package io.bloomish.api.engine.event.data.recipe.strategy;

import io.bloomish.api.engine.event.data.recipe.ApiRecipeProvider;
import io.bloomish.api.engine.event.data.recipe.description.RecipeDescription;
import net.minecraft.data.recipes.RecipeOutput;
import org.jetbrains.annotations.NotNull;

public interface RecipeStrategy<T extends RecipeDescription> {
    void saveRecipe(T description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput output);
}
