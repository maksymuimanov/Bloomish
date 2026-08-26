package io.bloomish.api.data.server.recipe.description;

public interface CampfireCookingRecipeDescription extends CookingRecipeDescription {
    @Override
    default String getName() {
        return "_from_campfire_cooking";
    }
}
