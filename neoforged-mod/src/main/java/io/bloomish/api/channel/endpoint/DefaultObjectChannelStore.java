package io.bloomish.api.channel.endpoint;

import io.bloomish.api.bean.Injected;
import io.bloomish.api.channel.ObjectChannel;
import io.bloomish.api.util.CollectionUtils;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

@Injected
public class DefaultObjectChannelStore implements ObjectChannelStore {
    private final Map<ObjectChannel, Queue<Object>> data;

    public DefaultObjectChannelStore() {
        this(Map.of());
    }

    public DefaultObjectChannelStore(Map<ObjectChannel, Queue<Object>> data) {
        this.data = new ConcurrentHashMap<>(data);
    }

    @Override
    public void produce(ObjectChannel channel, Object input) {
        this.lazyQueue(channel).add(input);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> detach(ObjectChannel channel) {
        Queue<T> objectQueue = (Queue<T>) this.data.remove(channel);
        return CollectionUtils.toStream(objectQueue);
    }

    @Override
    public <T> Stream<T> consume(ObjectChannel channel) {
        return this.<T>lazyQueue(channel).stream();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Queue<T> lazyQueue(ObjectChannel channel) {
        return (Queue<T>) this.data.computeIfAbsent(channel, key -> new ConcurrentLinkedQueue<>());
    }

    @Override
    public void clear() {
        this.data.values().forEach(Queue::clear);
        this.data.clear();
    }
}
