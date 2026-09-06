package io.bloomish.api.bean.injector;

import io.bloomish.api.bean.BeanDefinition;
import io.bloomish.api.bean.BeanInjector;
import io.bloomish.api.bean.Inject;
import io.bloomish.api.bean.Injected;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.util.ReflectionUtils;
import io.bloomish.api.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class DefaultBeanInjector implements BeanInjector {
    @Override
    public void inject(BeanDefinition beanDefinition, ObjectRegistry registry) {
        Constructor<?> constructor = beanDefinition.constructor();
        Object[] parameterValues = Arrays.stream(constructor.getParameters())
                .map(parameter -> this.resolveDependency(parameter, registry))
                .toArray();
        Object bean = ReflectionUtils.createObject(constructor, parameterValues);
        this.registerBean(beanDefinition.injected(), registry, bean);
    }

    private Object resolveDependency(Parameter parameter, ObjectRegistry registry) {
        if (parameter.isAnnotationPresent(Inject.class)) {
            Inject inject = parameter.getDeclaredAnnotation(Inject.class);
            String beanQualifier = inject.value();
            if (StringUtils.isNotBlank(beanQualifier)) {
                return registry.getByName(beanQualifier);
            }
        }
        Class<?> parameterType = parameter.getType();
        if (Iterable.class.isAssignableFrom(parameterType)) {
            ParameterizedType parameterizedType = (ParameterizedType) parameter.getParameterizedType();
            Type genericType = parameterizedType.getActualTypeArguments()[0];
            return registry.getAllByInterface(genericType.getClass());
        } else {
            return registry.getByClass(parameterType);
        }
    }

    private void registerBean(Injected injected, ObjectRegistry registry, Object bean) {
        String beanName = injected.value();
        if (StringUtils.isNotBlank(beanName)) {
            registry.registerValueByName(bean, beanName);
        } else {
            registry.registerValue(bean);
        }
    }
}
