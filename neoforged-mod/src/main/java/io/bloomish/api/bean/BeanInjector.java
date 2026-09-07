package io.bloomish.api.bean;

import io.bloomish.api.context.ObjectRegistry;

public interface BeanInjector {
    void inject(BeanDefinition beanDefinition, ObjectRegistry registry);
}
