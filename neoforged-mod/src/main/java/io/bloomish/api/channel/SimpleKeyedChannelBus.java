package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

@Injected
public class SimpleKeyedChannelBus implements KeyedChannelBus {
    private final Map<DataChannel, Map<?, ?>> channels;

    public SimpleKeyedChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> void send(DataChannel channel, K key, V data) {
        this.channels.compute(channel, (keyedChannel, objectMap)  -> {
            if (objectMap == null) {
                Map<K, V> map = new HashMap<>();
                map.put(key, data);
                return map;
            }
            ((Map<K, V>) objectMap).put(key, data);
            return objectMap;
        });
    }

    @Override
    public <K, V> void forEach(DataChannel channel, BiConsumer<? super K, ? super V> consumer) {
        this.<K, V>stream(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<KeyedChannelEntry<K, V>> stream(DataChannel channel) {
        return this.channels.getOrDefault(channel, new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedChannelEntry<>(
                                (K) entry.getKey(),
                                (V) entry.getValue()
                        )
                );
    }

    @Override
    public <K, V> void forEachDrain(DataChannel channel, BiConsumer<? super K, ? super V> consumer) {
        this.<K, V>drain(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<KeyedChannelEntry<K, V>> drain(DataChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedChannelEntry<>(
                                (K) entry.getKey(),
                                (V) entry.getValue()
                        )
                );
    }
}
