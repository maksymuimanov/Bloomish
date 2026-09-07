package io.bloomish.api.bean.injector;

import io.bloomish.api.bean.BeanCandidateResolverChain;
import io.bloomish.api.bean.BeanDefinition;
import io.bloomish.api.bean.BeanInjector;
import io.bloomish.api.context.ObjectRegistry;
import io.bloomish.api.util.ReflectionUtils;
import io.bloomish.api.util.StringUtils;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class DefaultBeanInjector implements BeanInjector {
    private final BeanCandidateResolverChain beanCandidateResolverChain;

    public DefaultBeanInjector(BeanCandidateResolverChain beanCandidateResolverChain) {
        this.beanCandidateResolverChain = beanCandidateResolverChain;
    }

    @Override
    public void inject(BeanDefinition beanDefinition, ObjectRegistry registry) {
        Constructor<?> constructor = beanDefinition.constructor();
        Object[] parameterValues = Arrays.stream(constructor.getParameters())
                .map(parameter -> this.beanCandidateResolverChain.resolveBeanCandidate(parameter, registry))
                .toArray();
        Object bean = ReflectionUtils.createObject(constructor, parameterValues);
        this.registerBean(bean, beanDefinition.name(), registry);
    }

    private void registerBean(Object bean, String beanName, ObjectRegistry registry) {
        if (StringUtils.isNotBlank(beanName)) {
            registry.registerValueByName(bean, beanName);
        } else {
            registry.registerValue(bean);
        }
    }
}
