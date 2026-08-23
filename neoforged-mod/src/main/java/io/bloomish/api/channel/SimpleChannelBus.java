package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;

import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

@Injected
public class SimpleChannelBus implements ChannelBus {
    private final Map<Channel, Queue<?>> channels;

    public SimpleChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void send(Channel channel, T data) {
        this.channels.compute(channel, (ignored, queue)  -> {
            if (queue == null) {
                return CollectionUtils.concurrentLinkedQueueOf(data);
            }
            ((Queue<T>) queue).add(data);
            return queue;
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> receive(Channel channel) {
        return this.channels.getOrDefault(channel, new ConcurrentLinkedQueue<>())
                .stream()
                .map(data -> (T) data);
    }

    @Override
    public <T> Stream<T> drain(Channel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new ConcurrentLinkedQueue<>())
                .stream()
                .map(data -> (T) data);
    }
}
