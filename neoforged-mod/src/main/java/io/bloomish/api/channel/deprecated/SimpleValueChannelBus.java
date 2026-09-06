package io.bloomish.api.channel.deprecated;

import io.bloomish.api.bean.Injected;
import io.bloomish.api.channel.ObjectChannel;
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
    private final Map<ObjectChannel, Queue<?>> channels;

    public SimpleValueChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void send(ObjectChannel channel, T data) {
        this.channels.compute(channel, (ignored, queue)  -> {
            if (queue == null) {
                return CollectionUtils.concurrentLinkedQueueOf(data);
            }
            ((Queue<T>) queue).add(data);
            return queue;
        });
    }

    @Override
    public <T> void forEach(ObjectChannel channel, Consumer<? super T> consumer) {
        this.<T>stream(channel).forEach(consumer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> stream(ObjectChannel channel) {
        return this.channels.getOrDefault(channel, new ConcurrentLinkedQueue<>())
                .stream()
                .map(data -> (T) data);
    }

    @Override
    public <T> void forEachDrain(ObjectChannel channel, Consumer<? super T> consumer) {
        this.<T>drain(channel).forEach(consumer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> drain(ObjectChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new ConcurrentLinkedQueue<>())
                .stream()
                .map(data -> (T) data);
    }
}
