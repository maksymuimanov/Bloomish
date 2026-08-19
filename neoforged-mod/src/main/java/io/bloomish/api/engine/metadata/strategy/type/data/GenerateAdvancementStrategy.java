package io.bloomish.api.engine.metadata.strategy.type.data;

import io.bloomish.api.engine.event.data.advancement.AdvancementDescription;
import io.bloomish.api.engine.event.data.advancement.AdvancementStrategy;
import io.bloomish.api.engine.event.data.advancement.ApiAdvancementProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateAdvancement;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.reflect.Constructor;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_DATA)
public class GenerateAdvancementStrategy implements ClassAnnotationStrategy<GenerateAdvancement> {
    @Override
    public void execute(Class<?> clazz, Object object, GenerateAdvancement annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        AdvancementDescription advancementDescription = (AdvancementDescription) constructor.newInstance();
        if (AdvancementStrategy.class.equals(annotation.value())) {
            ApiAdvancementProvider.ADVANCEMENTS.add(advancementDescription);
        } else {
            Class<? extends AdvancementStrategy> strategyClass = annotation.value();
            AdvancementStrategy advancementStrategy = strategyClass.getDeclaredConstructor().newInstance();
            ApiAdvancementProvider.CUSTOM_ADVANCEMENTS.put(advancementDescription, advancementStrategy);
        }
    }

    @Override
    public Class<GenerateAdvancement> getAnnotationClass() {
        return GenerateAdvancement.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
