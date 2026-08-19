package io.bloomish.api.engine.metadata.strategy.type.data;

import io.bloomish.api.engine.event.data.modifier.ApiGlobalLootModifierProvider;
import io.bloomish.api.engine.event.data.modifier.ChestModifierDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateChestLootModifier;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.type.ClassAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_DATA)
public class GenerateChestLootModifierStrategy implements ClassAnnotationStrategy<GenerateChestLootModifier> {
    @Override
    public void execute(Class<?> clazz, Object object, GenerateChestLootModifier annotation) throws Exception {
        ChestModifierDescription description = (ChestModifierDescription) ReflectionUtils.createObject(clazz);
        ApiGlobalLootModifierProvider.CHEST_MODIFIER_DESCRIPTIONS.add(description);
    }

    @Override
    public Class<GenerateChestLootModifier> getAnnotationClass() {
        return GenerateChestLootModifier.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
