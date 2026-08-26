package io.bloomish.api.data.server.recipe.description;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapedRecipeDescription extends RecipeDescription {
    String[] getPattern();

    Map<Character, ItemLike> getPatternTranslation();
}
