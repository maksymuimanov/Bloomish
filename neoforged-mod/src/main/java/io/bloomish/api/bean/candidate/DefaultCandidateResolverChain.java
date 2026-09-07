package io.bloomish.api.bean.candidate;

import io.bloomish.api.bean.BeanCandidateResolver;
import io.bloomish.api.bean.BeanCandidateResolverChain;
import io.bloomish.api.context.ObjectRegistry;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultCandidateResolverChain implements BeanCandidateResolverChain  {
    private final List<BeanCandidateResolver> resolvers;
    private final BeanCandidateResolver fallbackResolver;

    public DefaultCandidateResolverChain(BeanCandidateResolver fallbackResolver) {
        this(fallbackResolver, List.of());
    }

    public DefaultCandidateResolverChain(BeanCandidateResolver fallbackResolver, Collection<? extends BeanCandidateResolver> resolvers) {
        this.resolvers = new ArrayList<>(resolvers);
        this.fallbackResolver = fallbackResolver;
    }

    @Override
    public Object resolveBeanCandidate(Parameter parameter, ObjectRegistry registry) {
        return this.resolvers.stream()
                .filter(resolver -> resolver.isApplicable(parameter))
                .findFirst()
                .orElse(this.fallbackResolver)
                .resolveBeanCandidate(parameter, registry)
                .orElseThrow();
    }
}
