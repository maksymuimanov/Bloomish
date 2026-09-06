package io.bloomish.api.bean.registrar;

import io.bloomish.api.bean.*;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.util.ReflectionUtils;

import java.util.Collection;
import java.util.stream.Collectors;

public class DefaultBeanRegistrar implements BeanRegistrar {
    private final BeanFilterChain beanFilterChain;
    private final BeanDefinitionResolver beanDefinitionResolver;
    private final BeanInjector beanInjector;

    public DefaultBeanRegistrar(BeanFilterChain beanFilterChain, BeanDefinitionResolver beanDefinitionResolver, BeanInjector beanInjector) {
        this.beanFilterChain = beanFilterChain;
        this.beanDefinitionResolver = beanDefinitionResolver;
        this.beanInjector = beanInjector;
    }

    @Override
    public void registerBeans(Collection<Class<?>> classes, ObjectRegistry registry) {
        classes.stream()
                .filter(clazz -> ReflectionUtils.isAnnotationPresentDeep(clazz, Bean.class))
                .filter(this.beanFilterChain::shouldRegister)
                .map(this.beanDefinitionResolver::resolveDefinition)
                .collect(Collectors.toCollection(BeanInjectionQueue::new))
                .forEach(beanDefinition -> this.beanInjector.inject(beanDefinition, registry));
    }
}
