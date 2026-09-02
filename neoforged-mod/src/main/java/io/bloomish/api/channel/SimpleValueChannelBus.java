package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;

import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Injected
public class SimpleValueChannelBus implements ValueChannelBus {
    private final Map<DataChannel, Queue<?>> channels;

    public SimpleValueChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void send(DataChannel channel, T data) {
        this.channels.compute(channel, (ignored, queue)  -> {
            if (queue == null) {
                return CollectionUtils.concurrentLinkedQueueOf(data);
            }
            ((Queue<T>) queue).add(data);
            return queue;
        });
    }

    @Override
    public <T> void forEach(DataChannel channel, Consumer<? super T> consumer) {
        this.<T>stream(channel).forEach(consumer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> stream(DataChannel channel) {
        return this.channels.getOrDefault(channel, new ConcurrentLinkedQueue<>())
                .stream()
                .map(data -> (T) data);
    }

    @Override
    public <T> void forEachDrain(DataChannel channel, Consumer<? super T> consumer) {
        this.<T>drain(channel).forEach(consumer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> drain(DataChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new ConcurrentLinkedQueue<>())
                .stream()
                .map(data -> (T) data);
    }
}
