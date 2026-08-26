package io.bloomish.api.engine.metadata.strategy.type.data;

import io.bloomish.api.data.server.recipe.ApiRecipeProvider;
import io.bloomish.api.data.server.recipe.description.RecipeDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateRecipe;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.reflect.Constructor;

@Strategy(StrategyInitializer.DEFAULT_CLASS_DATA)
public class GenerateRecipeStrategy implements ClassAnnotationStrategy<GenerateRecipe> {
    @Override
    public void execute(Class<?> clazz, Object object, GenerateRecipe annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        RecipeDescription recipeDescription = (RecipeDescription) constructor.newInstance();
        ApiRecipeProvider.RECIPES.add(recipeDescription);
    }

    @Override
    public Class<GenerateRecipe> getAnnotationClass() {
        return GenerateRecipe.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
