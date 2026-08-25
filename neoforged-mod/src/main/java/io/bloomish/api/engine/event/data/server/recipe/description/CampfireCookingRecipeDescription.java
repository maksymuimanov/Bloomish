package io.bloomish.api.engine.event.data.server.recipe.description;

public interface CampfireCookingRecipeDescription extends CookingRecipeDescription {
    @Override
    default String getName() {
        return "_from_campfire_cooking";
    }
}
