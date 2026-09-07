package io.bloomish.api.bean.candidate;

import io.bloomish.api.bean.BeanCandidateResolver;
import io.bloomish.api.context.ObjectRegistry;

import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public class IterableBeanCandidateResolver implements BeanCandidateResolver {
    @Override
    public Optional<Object> resolveBeanCandidate(Parameter parameter, ObjectRegistry registry) {
        ParameterizedType parameterizedType = (ParameterizedType) parameter.getParameterizedType();
        Type genericType = parameterizedType.getActualTypeArguments()[0];
        return Optional.of(registry.getAllByInterface((Class<?>) genericType));
    }

    @Override
    public boolean isApplicable(Parameter parameter) {
        return Iterable.class.isAssignableFrom(parameter.getType());
    }
}
