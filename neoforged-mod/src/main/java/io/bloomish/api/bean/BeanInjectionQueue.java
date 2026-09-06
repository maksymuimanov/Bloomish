package io.bloomish.api.bean;

import io.bloomish.api.util.ReflectionUtils;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.util.*;

public class BeanInjectionQueue implements Queue<BeanDefinition> {
    private final Queue<BeanDefinition> queue;

    public BeanInjectionQueue() {
        this(new ArrayDeque<>());
    }

    public BeanInjectionQueue(Collection<BeanDefinition> collection) {
        this.queue = new PriorityQueue<>(collection.size(), new InjectionComparator());
        this.queue.addAll(collection);
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.queue.contains(o);
    }

    @Override
    public @NotNull Iterator<BeanDefinition> iterator() {
        return this.queue.iterator();
    }

    @Override
    public Object @NotNull [] toArray() {
        return this.queue.toArray();
    }

    @Override
    public <T> T @NotNull [] toArray(T @NotNull [] a) {
        return this.queue.toArray(a);
    }

    @Override
    public boolean add(BeanDefinition constructor) {
        return this.queue.add(constructor);
    }

    @Override
    public boolean remove(Object o) {
        return this.queue.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return this.queue.containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends BeanDefinition> c) {
        return this.queue.addAll(c);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return this.queue.removeAll(c);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return this.queue.retainAll(c);
    }

    @Override
    public void clear() {
        this.queue.clear();
    }

    @Override
    public boolean offer(BeanDefinition constructor) {
        return this.queue.offer(constructor);
    }

    @Override
    public BeanDefinition remove() {
        return this.queue.remove();
    }

    @Override
    public BeanDefinition poll() {
        return this.queue.poll();
    }

    @Override
    public BeanDefinition element() {
        return this.queue.element();
    }

    @Override
    public BeanDefinition peek() {
        return this.queue.peek();
    }

    private static class InjectionComparator implements Comparator<BeanDefinition> {
        @Override
        public int compare(BeanDefinition o1, BeanDefinition o2) {
            Constructor<?> c1 = o1.constructor();
            Constructor<?> c2 = o2.constructor();
            if (c1.getParameterCount() == 0 && c2.getParameterCount() != 0) {
                return -1;
            }
            if (c1.getParameterCount() != 0 && c2.getParameterCount() == 0) {
                return 1;
            }
            if (ReflectionUtils.isConstructorDependency(c1, c2)) {
                return 1;
            }
            if (ReflectionUtils.isConstructorDependency(c2, c1)) {
                return -1;
            }
            return Integer.compare(c1.getParameterCount(), c2.getParameterCount());
        }
    }
}
