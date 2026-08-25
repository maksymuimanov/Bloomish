package io.bloomish.api.channel;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public interface KeyedMapChannelBus extends DataChannelBus {
    <K, K1, V1> void send(DataChannel channel, K key, K1 dataKey, V1 data);

    <K, K1, V1> void forEach(DataChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer);

    <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> stream(DataChannel channel);

    <K, K1, V1> void forEachDrain(DataChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer);

    <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> drain(DataChannel channel);
}
