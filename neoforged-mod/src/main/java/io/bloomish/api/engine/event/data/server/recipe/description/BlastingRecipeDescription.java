package io.bloomish.api.engine.event.data.server.recipe.description;

public interface BlastingRecipeDescription extends CookingRecipeDescription {
    @Override
    default String getName() {
        return "_from_blasting";
    }
}
