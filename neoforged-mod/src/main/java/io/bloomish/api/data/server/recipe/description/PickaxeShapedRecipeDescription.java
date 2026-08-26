package io.bloomish.api.data.server.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;

public interface PickaxeShapedRecipeDescription extends ShapedRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                " S ",
                " S "
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.TOOLS;
    }
}
