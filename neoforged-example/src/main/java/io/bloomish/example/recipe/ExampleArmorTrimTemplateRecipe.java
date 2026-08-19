package io.bloomish.example.recipe;

import io.bloomish.api.core.engine.event.data.recipe.description.TemplateSmithingTrimRecipeDescription;
import io.bloomish.api.core.engine.metadata.annotation.data.GenerateRecipe;
import net.minecraft.world.level.ItemLike;
import io.bloomish.example.item.ExampleItems;

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
