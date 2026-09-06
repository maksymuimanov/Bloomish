package io.bloomish.api.bean;

import io.bloomish.api.engine.context.ObjectRegistry;

import java.lang.reflect.Parameter;

public interface BeanCandidateResolverChain {
    Object resolveBeanCandidate(Parameter parameter, ObjectRegistry registry);
}
