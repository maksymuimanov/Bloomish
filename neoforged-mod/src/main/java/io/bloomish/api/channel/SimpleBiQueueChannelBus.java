package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Injected
public class SimpleBiQueueChannelBus implements BiQueueChannelBus {
    private final Map<BiQueueChannel, Map<Object, Queue<?>>> channels;

    public SimpleBiQueueChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> void send(BiQueueChannel channel, K key, V data) {
        this.channels.compute(channel, (biQueueChannel, queueMap)  -> {
            if (queueMap == null) {
                Map<Object, Queue<?>> map = new HashMap<>();
                map.put(key, CollectionUtils.concurrentLinkedQueueOf(data));
                return map;
            }
            ((Queue<V>) queueMap.get(key)).add(data);
            return queueMap;
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<BiQueueChannel.Entry<K, V>> receive(BiQueueChannel channel) {
        return this.channels.getOrDefault(channel, new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new BiQueueChannel.Entry<>(
                                (K) entry.getKey(),
                                (Queue<V>) entry.getValue()
                        )
                );
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<BiQueueChannel.Entry<K, V>> drain(BiQueueChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new BiQueueChannel.Entry<>(
                                (K) entry.getKey(),
                                (Queue<V>) entry.getValue()
                        )
                );
    }
}
