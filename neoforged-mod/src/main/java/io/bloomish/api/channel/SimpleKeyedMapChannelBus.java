package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

@Injected
public class SimpleKeyedMapChannelBus implements KeyedMapChannelBus {
    private final Map<DataChannel, Map<Object, Map<?, ?>>> channels;

    public SimpleKeyedMapChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, K1, V1> void send(DataChannel channel, K key, K1 dataKey, V1 data) {
        this.channels.compute(channel, (keyedQueueChannel, multiMap)  -> {
            if (multiMap == null) {
                return CollectionUtils.hashMapOf(key, CollectionUtils.hashMapOf(dataKey, data));
            }
            ((Map<K1, V1>) multiMap.get(key)).put(dataKey, data);
            return multiMap;
        });
    }

    @Override
    public <K, K1, V1> void forEach(DataChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer) {
        this.<K, K1, V1>stream(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> stream(DataChannel channel) {
        return this.channels.getOrDefault(channel, new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedMapChannelEntry<>(
                                (K) entry.getKey(),
                                (Map<K1, V1>) entry.getValue()
                        )
                );
    }

    @Override
    public <K, K1, V1> void forEachDrain(DataChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer) {
        this.<K, K1, V1>drain(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> drain(DataChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedMapChannelEntry<>(
                                (K) entry.getKey(),
                                (Map<K1, V1>) entry.getValue()
                        )
                );
    }
}
