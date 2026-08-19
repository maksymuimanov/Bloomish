package io.bloomish.api.engine.metadata.strategy.field.injection;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.context.ObjectPool;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.injection.Dependency;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.InjectionAnnotationProcessor;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_INJECTION)
public class DependencyStrategy implements FieldAnnotationStrategy<Dependency> {
    @Override
    public void execute(Field field, Object object, Dependency annotation) throws Exception {
        field.setBoolean(object, ModList.get().isLoaded(annotation.value()));
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.put(object);
    }

    @Override
    public Class<Dependency> getAnnotationClass() {
        return Dependency.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(InjectionAnnotationProcessor.NAME);
    }
}
