package io.bloomish.api.bean;

public interface BeanFilterChain {
    boolean shouldRegister(Class<?> clazz);
}
