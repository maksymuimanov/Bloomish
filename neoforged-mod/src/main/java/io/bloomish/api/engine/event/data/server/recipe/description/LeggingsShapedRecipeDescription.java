package io.bloomish.api.engine.event.data.server.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;

public interface LeggingsShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                "X X",
                "X X"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.COMBAT;
    }
}
