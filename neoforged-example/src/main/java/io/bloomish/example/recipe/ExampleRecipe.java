package io.bloomish.example.recipe;

import io.bloomish.api.engine.event.data.server.recipe.description.ShapelessRecipeDescription;
import io.bloomish.api.engine.metadata.annotation.data.GenerateRecipe;
import io.bloomish.example.item.ExampleItems;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.Map;

@GenerateRecipe
public class ExampleRecipe implements ShapelessRecipeDescription {
    @Override
    public Map<ItemLike, Integer> getItemAndCountMap() {
        return Map.of(
                Items.DIAMOND, 1,
                Items.COPPER_BLOCK, 2
        );
    }

    @Override
    public RecipeCategory getRecipeCategory() {
        return RecipeCategory.FOOD;
    }

    @Override
    public ItemLike getResult() {
        return ExampleItems.EXAMPLE_FUEL;
    }
}
