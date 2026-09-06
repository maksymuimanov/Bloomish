package io.bloomish.api.bean.definition;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.bean.BeanConstructor;
import io.bloomish.api.bean.BeanDefinition;
import io.bloomish.api.bean.BeanDefinitionResolver;
import io.bloomish.api.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class DefaultBeanDefinitionResolver implements BeanDefinitionResolver {
    @Override
    public BeanDefinition resolveDefinition(Class<?> clazz) {
        Constructor<?> constructor = this.resolveConstructor(clazz);
        Bean bean = ReflectionUtils.findDeepAnnotation(clazz, Bean.class).orElseThrow();
        return new BeanDefinition(clazz, constructor, bean.name());
    }

    private Constructor<?> resolveConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        return Arrays.stream(constructors)
                .filter(constructor -> constructor.isAnnotationPresent(BeanConstructor.class))
                .findAny()
                .orElseGet(() -> constructors[0]);
    }
}
