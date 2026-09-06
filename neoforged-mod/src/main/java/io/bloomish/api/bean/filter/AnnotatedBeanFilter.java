package io.bloomish.api.bean.filter;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.bean.BeanFilter;
import io.bloomish.api.util.ReflectionUtils;

public class AnnotatedBeanFilter implements BeanFilter {
    @Override
    public boolean shouldRegister(Class<?> clazz) {
        Bean bean = ReflectionUtils.findDeepAnnotation(clazz, Bean.class).orElseThrow();
        return bean.register();
    }
}
