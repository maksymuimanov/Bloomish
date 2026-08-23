package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Injected
public class SimpleBiChannelBus implements BiChannelBus {
    private final Map<BiChannel, Map<?, ?>> channels;

    public SimpleBiChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> void send(BiChannel channel, K key, V data) {
        this.channels.compute(channel, (biChannel, objectMap)  -> {
            if (objectMap == null) {
                Map<K, V> map = new HashMap<>();
                map.put(key, data);
                return map;
            }
            ((Map<K, V>) objectMap).put(key, data);
            return objectMap;
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<BiChannel.Entry<K, V>> receive(BiChannel channel) {
        return this.channels.getOrDefault(channel, new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new BiChannel.Entry<>(
                                (K) entry.getKey(),
                                (V) entry.getValue()
                        )
                );
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Stream<BiChannel.Entry<K, V>> drain(BiChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new BiChannel.Entry<>(
                                (K) entry.getKey(),
                                (V) entry.getValue()
                        )
                );
    }
}
