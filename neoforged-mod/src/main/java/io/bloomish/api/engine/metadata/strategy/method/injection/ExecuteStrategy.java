package io.bloomish.api.engine.metadata.strategy.method.injection;

import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.injection.Execute;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.InjectionAnnotationProcessor;
import io.bloomish.api.engine.metadata.strategy.method.MethodAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.reflect.Method;

@Strategy(StrategyInitializer.DEFAULT_METHOD_INJECTION)
public class ExecuteStrategy implements MethodAnnotationStrategy<Execute> {
    @Override
    public void execute(Method method, Object object, Execute annotation) throws Exception {
        String modCondition = annotation.mod();
        if (modCondition.isBlank() || ModList.get().isLoaded(modCondition)) method.invoke(object);
    }

    @Override
    public Class<Execute> getAnnotationClass() {
        return Execute.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(InjectionAnnotationProcessor.NAME);
    }
}
