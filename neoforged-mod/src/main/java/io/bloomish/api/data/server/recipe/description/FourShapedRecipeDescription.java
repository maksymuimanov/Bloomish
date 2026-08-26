package io.bloomish.api.data.server.recipe.description;

public interface FourShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XX",
                "XX"
        };
    }
}
