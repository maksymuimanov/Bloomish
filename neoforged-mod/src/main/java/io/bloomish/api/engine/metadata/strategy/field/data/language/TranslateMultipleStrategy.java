package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMultiple;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.pool.SimpleStrategyPool;
import io.bloomish.api.engine.metadata.pool.StrategyPool;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateMultipleStrategy implements FieldAnnotationStrategy<TranslateMultiple> {
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void execute(Field field, Object object, TranslateMultiple annotation) throws Exception {
        Class<? extends TranslateMultiple> annotationClass = annotation.getClass();
        StrategyPool strategyPool = SimpleStrategyPool.getInstance();
        Method[] methods = annotationClass.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getReturnType().isArray()) continue;
            Annotation[] languageAnnotations = (Annotation[]) method.invoke(annotation);
            for (Annotation languageAnnotation : languageAnnotations) {
                strategyPool.get(languageAnnotation.annotationType()).forEach(strategy -> {
                    try {
                        ((FieldAnnotationStrategy) strategy).execute(field, object, languageAnnotation);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }

    @Override
    public Class<TranslateMultiple> getAnnotationClass() {
        return TranslateMultiple.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
