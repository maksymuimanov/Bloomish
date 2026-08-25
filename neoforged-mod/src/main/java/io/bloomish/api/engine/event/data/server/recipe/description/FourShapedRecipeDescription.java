package io.bloomish.api.engine.event.data.server.recipe.description;

public interface FourShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XX",
                "XX"
        };
    }
}
