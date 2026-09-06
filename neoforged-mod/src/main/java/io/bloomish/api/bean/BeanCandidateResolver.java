package io.bloomish.api.bean;

import io.bloomish.api.engine.context.ObjectRegistry;

import java.lang.reflect.Parameter;
import java.util.Optional;

public interface BeanCandidateResolver {
    Optional<Object> resolveBeanCandidate(Parameter parameter, ObjectRegistry registry);

    boolean isApplicable(Parameter parameter);
}
