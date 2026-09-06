package io.bloomish.api.bean.definition;

import io.bloomish.api.bean.BeanDefinition;
import io.bloomish.api.bean.BeanDefinitionResolver;
import io.bloomish.api.bean.Inject;
import io.bloomish.api.bean.Injected;
import io.bloomish.api.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class InjectBeanDefinitionResolver implements BeanDefinitionResolver {
    @Override
    public BeanDefinition resolveDefinition(Class<?> clazz) {
        Constructor<?> constructor = this.resolveConstructor(clazz);
        Injected injected = ReflectionUtils.findDeepAnnotation(clazz, Injected.class).orElseThrow();
        return new BeanDefinition(clazz, constructor, injected);
    }

    private Constructor<?> resolveConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        return Arrays.stream(constructors)
                .filter(constructor -> constructor.isAnnotationPresent(Inject.class))
                .findAny()
                .orElseGet(() -> constructors[0]);
    }
}
