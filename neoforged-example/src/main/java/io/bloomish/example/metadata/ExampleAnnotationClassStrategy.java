package io.bloomish.example.metadata;

import io.bloomish.api.core.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.core.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

@Strategy(ExampleAnnotationClassStrategy.EXAMPLE_CLASS)
public class ExampleAnnotationClassStrategy implements ClassAnnotationStrategy<ExampleAnnotation> {
    public static final String EXAMPLE_CLASS = "example_class";

    @Override
    public void execute(Class<?> clazz, Object object, ExampleAnnotation annotation) throws Exception {
        System.out.println(clazz.getName() + " : " + annotation.value());
    }

    @Override
    public Class<ExampleAnnotation> getAnnotationClass() {
        return ExampleAnnotation.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(ExampleAnnotationProcessor.NAME);
    }
}
