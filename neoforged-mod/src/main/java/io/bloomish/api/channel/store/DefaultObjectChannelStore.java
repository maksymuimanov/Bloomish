package io.bloomish.api.channel.store;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.bean.BeanConstructor;
import io.bloomish.api.channel.ObjectChannel;
import io.bloomish.api.channel.ObjectChannelStore;
import io.bloomish.api.util.CollectionUtils;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

@Bean
public class DefaultObjectChannelStore implements ObjectChannelStore {
    private final Map<ObjectChannel, Queue<Object>> data;

    @BeanConstructor
    public DefaultObjectChannelStore() {
        this(Map.of());
    }

    public DefaultObjectChannelStore(Map<ObjectChannel, Queue<Object>> data) {
        this.data = new ConcurrentHashMap<>(data);
    }

    @Override
    public void produce(ObjectChannel channel, Object input) {
        this.queue(channel).add(input);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> detach(ObjectChannel channel) {
        Queue<T> objectQueue = (Queue<T>) this.data.remove(channel);
        return CollectionUtils.toStream(objectQueue);
    }

    @Override
    public <T> Stream<T> consume(ObjectChannel channel) {
        return this.<T>queue(channel).stream();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Queue<T> queue(ObjectChannel channel) {
        return (Queue<T>) this.data.computeIfAbsent(channel, key -> new ConcurrentLinkedQueue<>());
    }

    @Override
    public void clear() {
        this.data.values().forEach(Queue::clear);
        this.data.clear();
    }
}
