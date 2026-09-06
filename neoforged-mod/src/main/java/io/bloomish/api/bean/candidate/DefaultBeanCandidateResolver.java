package io.bloomish.api.bean.candidate;

import io.bloomish.api.bean.BeanCandidateResolver;
import io.bloomish.api.engine.context.ObjectRegistry;

import java.lang.reflect.Parameter;
import java.util.Optional;

public class DefaultBeanCandidateResolver implements BeanCandidateResolver {
    @Override
    public Optional<Object> resolveBeanCandidate(Parameter parameter, ObjectRegistry registry) {
        Class<?> parameterType = parameter.getType();
        return Optional.of(registry.getByClass(parameterType));
    }

    @Override
    public boolean isApplicable(Parameter parameter) {
        return true;
    }
}
