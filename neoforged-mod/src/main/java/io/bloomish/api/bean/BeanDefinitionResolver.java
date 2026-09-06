package io.bloomish.api.bean;

public interface BeanDefinitionResolver {
    BeanDefinition resolveDefinition(Class<?> clazz);
}
