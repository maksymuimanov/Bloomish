package io.bloomish.example.recipe;

import io.bloomish.api.data.server.recipe.description.TemplateSmithingTrimRecipeDescription;
import io.bloomish.api.engine.metadata.annotation.data.GenerateRecipe;
import io.bloomish.example.item.ExampleItems;
import net.minecraft.world.level.ItemLike;

@GenerateRecipe
public class ExampleArmorTrimTemplateRecipe implements TemplateSmithingTrimRecipeDescription {
    @Override
    public ItemLike[] getTemplates() {
        return new ItemLike[]{ExampleItems.EXAMPLE_ARMOR_TRIM_SMITHING_TEMPLATE};
    }

    @Override
    public String getName() {
        return "trim_templates_recipe";
    }
}
