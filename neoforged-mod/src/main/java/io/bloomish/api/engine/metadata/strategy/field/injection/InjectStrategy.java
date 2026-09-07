package io.bloomish.api.engine.metadata.strategy.field.injection;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.bean.BeanCandidate;
import io.bloomish.api.context.DefaultObjectRegistry;
import io.bloomish.api.context.ObjectRegistry;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.InjectionAnnotationProcessor;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_INJECTION)
public class InjectStrategy implements FieldAnnotationStrategy<BeanCandidate> {
    @Override
    public void execute(Field field, Object object, BeanCandidate annotation) throws Exception {
        ObjectRegistry objectRegistry = DefaultObjectRegistry.getInstance();
        String beanName = annotation.value();
        Object poolObject = beanName.isBlank() ? objectRegistry.findByClass(field.getType()) : objectRegistry.findByName(beanName);
        field.set(object, poolObject);
        Class<?> objectClass = object.getClass();
        Bean bean = objectClass.getDeclaredAnnotation(Bean.class);
        if (!bean.register()) throw new IllegalStateException("@Inject annotation can be applied if class is annotated with @Injected(isContextObject=true)");
        String rootBeanName = bean.name();
        if (rootBeanName.isBlank()) {
            objectRegistry.registerValueByClass(objectClass);
        } else {
            objectRegistry.register(rootBeanName, objectClass);
        }
    }

    @Override
    public Class<BeanCandidate> getAnnotationClass() {
        return BeanCandidate.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(InjectionAnnotationProcessor.NAME);
    }
}
