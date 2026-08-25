package io.bloomish.api.channel;

import java.util.Map;

public record KeyedMapChannelEntry<K, K1, V1>(
        K key,
        Map<K1, V1> value
) {
}
