package io.bloomish.api.bean;

public interface BeanFilter {
    boolean shouldRegister(Class<?> clazz);
}
