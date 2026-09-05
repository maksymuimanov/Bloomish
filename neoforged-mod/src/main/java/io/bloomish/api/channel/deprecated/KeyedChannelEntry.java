package io.bloomish.api.channel.deprecated;

public record KeyedChannelEntry<K, V>(
        K key,
        V value
) {
}
