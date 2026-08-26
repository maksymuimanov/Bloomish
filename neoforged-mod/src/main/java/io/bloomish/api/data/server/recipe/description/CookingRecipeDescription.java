package io.bloomish.api.data.server.recipe.description;

import net.minecraft.world.level.ItemLike;

public interface CookingRecipeDescription extends RecipeDescription {
    ItemLike getIngredient();

    float getExperience();

    int getCookingTime();

    String getGroup();
}
