package io.bloomish.api.bean.filter;

import io.bloomish.api.bean.BeanFilter;
import io.bloomish.api.bean.Injected;
import io.bloomish.api.util.ReflectionUtils;

public class InjectedBeanFilter implements BeanFilter {
    @Override
    public boolean shouldRegister(Class<?> clazz) {
        Injected injected = ReflectionUtils.findDeepAnnotation(clazz, Injected.class).orElseThrow();
        return injected.register();
    }
}
