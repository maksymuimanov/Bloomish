package io.bloomish.api.channel;

public record BiChannel(
        String name
) {
    public record Entry<K, V>(
            K key,
            V value
    ) {
    }
}
