package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

@Injected
public class SimpleKeyedQueueChannelBus implements KeyedQueueChannelBus {
    private final Map<DataChannel, Map<Object, Queue<?>>> channels;

    public SimpleKeyedQueueChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> void send(DataChannel channel, K key, V data) {
        this.channels.compute(channel, (keyedQueueChannel, queueMap)  -> {
            if (queueMap == null) {
                return CollectionUtils.hashMapOf(key, CollectionUtils.concurrentLinkedQueueOf(data));
            }
            ((Queue<V>) queueMap.get(key)).add(data);
            return queueMap;
        });
    }

    @Override
    public <K, V> void forEach(DataChannel channel, BiConsumer<? super K, Queue<V>> consumer) {
        this.<K, V>stream(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<KeyedQueueChannelEntry<K, V>> stream(DataChannel channel) {
        return this.channels.getOrDefault(channel, new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedQueueChannelEntry<>(
                                (K) entry.getKey(),
                                (Queue<V>) entry.getValue()
                        )
                );
    }

    @Override
    public <K, V> void forEachDrain(DataChannel channel, BiConsumer<? super K, Queue<V>> consumer) {
        this.<K, V>drain(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<KeyedQueueChannelEntry<K, V>> drain(DataChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedQueueChannelEntry<>(
                                (K) entry.getKey(),
                                (Queue<V>) entry.getValue()
                        )
                );
    }
}
