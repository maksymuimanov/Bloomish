package io.bloomish.api.channel;

public record KeyedChannelEntry<K, V>(
        K key,
        V value
) {
}
