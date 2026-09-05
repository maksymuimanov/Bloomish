package io.bloomish.api.channel.deprecated;

import java.util.Queue;

public record KeyedQueueChannelEntry<K, V>(
        K key,
        Queue<V> value
) {
}
