package io.bloomish.api.bean.candidate;

import io.bloomish.api.bean.BeanCandidate;
import io.bloomish.api.bean.BeanCandidateResolver;
import io.bloomish.api.context.ObjectRegistry;
import io.bloomish.api.util.StringUtils;

import java.lang.reflect.Parameter;
import java.util.Optional;

public class AnnotatedBeanCandidateResolver implements BeanCandidateResolver {
    @Override
    public Optional<Object> resolveBeanCandidate(Parameter parameter, ObjectRegistry registry) {
        BeanCandidate beanCandidate = parameter.getDeclaredAnnotation(BeanCandidate.class);
        String beanQualifier = beanCandidate.value();
        return StringUtils.isNotBlank(beanQualifier)
                ? Optional.of(registry.getByName(beanQualifier))
                : Optional.empty();
    }

    @Override
    public boolean isApplicable(Parameter parameter) {
        return parameter.isAnnotationPresent(BeanCandidate.class);
    }
}
