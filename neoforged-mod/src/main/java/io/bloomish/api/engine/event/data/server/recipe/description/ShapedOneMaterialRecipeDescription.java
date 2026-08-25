package io.bloomish.api.engine.event.data.server.recipe.description;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapedOneMaterialRecipeDescription extends ShapedRecipeDescription {
    ItemLike getSimplePatternTranslation();

    @Override
    default Map<Character, ItemLike> getPatternTranslation() {
        return Map.of('X', getSimplePatternTranslation());
    }
}
