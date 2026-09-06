package io.bloomish.api.bean.filter;

import io.bloomish.api.bean.BeanFilter;
import io.bloomish.api.bean.BeanFilterChain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultBeanFilterChain implements BeanFilterChain {
    private final Collection<BeanFilter> filters;

    public DefaultBeanFilterChain() {
        this(List.of());
    }

    public DefaultBeanFilterChain(Collection<? extends BeanFilter> filters) {
        this.filters = new ArrayList<>(filters);
    }

    @Override
    public boolean shouldRegister(Class<?> clazz) {
        return filters.stream().allMatch(filter -> filter.shouldRegister(clazz));
    }
}
