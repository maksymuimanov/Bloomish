package io.bloomish.api.bean;

import java.lang.reflect.Constructor;

public record BeanDefinition(
        Class<?> clazz,
        Constructor<?> constructor,
        String name
) {
}
