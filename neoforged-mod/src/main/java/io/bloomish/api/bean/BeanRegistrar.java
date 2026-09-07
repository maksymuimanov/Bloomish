package io.bloomish.api.bean;

import io.bloomish.api.context.ObjectRegistry;

import java.util.Collection;

public interface BeanRegistrar {
    void registerBeans(Collection<Class<?>> classes, ObjectRegistry registry);
}
