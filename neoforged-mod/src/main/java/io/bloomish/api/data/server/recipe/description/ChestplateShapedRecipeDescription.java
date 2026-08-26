package io.bloomish.api.data.server.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;

public interface ChestplateShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "X X",
                "XXX",
                "XXX"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.COMBAT;
    }
}
