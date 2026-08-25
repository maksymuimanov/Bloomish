package io.bloomish.api.engine.event.data.server.recipe.description;

public interface NineShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                "XXX",
                "XXX"
        };
    }
}
