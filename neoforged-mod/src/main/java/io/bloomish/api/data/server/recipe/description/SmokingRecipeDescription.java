package io.bloomish.api.data.server.recipe.description;

public interface SmokingRecipeDescription extends CookingRecipeDescription {
    @Override
    default String getName() {
        return "_from_smoking";
    }
}
