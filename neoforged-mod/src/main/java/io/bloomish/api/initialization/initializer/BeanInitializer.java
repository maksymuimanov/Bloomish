package io.bloomish.api.initialization.initializer;

import io.bloomish.api.bean.*;
import io.bloomish.api.bean.candidate.*;
import io.bloomish.api.bean.definition.DefaultBeanDefinitionResolver;
import io.bloomish.api.bean.filter.AnnotatedBeanFilter;
import io.bloomish.api.bean.filter.DefaultBeanFilterChain;
import io.bloomish.api.bean.filter.OnModBeanFilter;
import io.bloomish.api.bean.injector.DefaultBeanInjector;
import io.bloomish.api.bean.registrar.DefaultBeanRegistrar;
import io.bloomish.api.context.ObjectRegistry;

import java.util.Collection;
import java.util.List;

public class BeanInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry registry) {
        BeanFilterChain beanFilterChain = new DefaultBeanFilterChain(List.of(
                new AnnotatedBeanFilter(),
                new OnModBeanFilter()
        ));
        BeanDefinitionResolver beanDefinitionResolver = new DefaultBeanDefinitionResolver();
        BeanCandidateResolverChain beanCandidateResolverChain = new DefaultCandidateResolverChain(new DefaultBeanCandidateResolver(), List.of(
                new ObserveObjectChannelBeanCandidateResolver(),
                new AnnotatedBeanCandidateResolver(),
                new IterableBeanCandidateResolver()
        ));
        BeanInjector beanInjector = new DefaultBeanInjector(beanCandidateResolverChain);
        BeanRegistrar beanRegistrar = new DefaultBeanRegistrar(beanFilterChain, beanDefinitionResolver, beanInjector);
        beanRegistrar.registerBeans(classes, registry);
    }
}
