package io.bloomish.api.channel;

import java.util.Collection;

public record BiQueueChannel(
        String name
) {
    public record Entry<K, V>(
            K key,
            Collection<V> value
    ) {
    }
}
