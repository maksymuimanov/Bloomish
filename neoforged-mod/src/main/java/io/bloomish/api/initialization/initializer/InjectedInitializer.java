package io.bloomish.api.initialization.initializer;

import io.bloomish.api.bean.BeanDefinitionResolver;
import io.bloomish.api.bean.BeanFilterChain;
import io.bloomish.api.bean.BeanInjector;
import io.bloomish.api.bean.BeanRegistrar;
import io.bloomish.api.bean.definition.InjectBeanDefinitionResolver;
import io.bloomish.api.bean.filter.DefaultBeanFilterChain;
import io.bloomish.api.bean.filter.InjectedBeanFilter;
import io.bloomish.api.bean.filter.OnModBeanFilter;
import io.bloomish.api.bean.injector.DefaultBeanInjector;
import io.bloomish.api.bean.registrar.InjectedBeanRegistrar;
import io.bloomish.api.engine.context.ObjectRegistry;

import java.util.Collection;
import java.util.List;

public class InjectedInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry registry) {
        BeanFilterChain beanFilterChain = new DefaultBeanFilterChain(List.of(
                new InjectedBeanFilter(),
                new OnModBeanFilter()
        ));
        BeanDefinitionResolver beanDefinitionResolver = new InjectBeanDefinitionResolver();
        BeanInjector beanInjector = new DefaultBeanInjector();
        BeanRegistrar beanRegistrar = new InjectedBeanRegistrar(beanFilterChain, beanDefinitionResolver, beanInjector);
        beanRegistrar.registerBeans(classes, registry);
    }
}
