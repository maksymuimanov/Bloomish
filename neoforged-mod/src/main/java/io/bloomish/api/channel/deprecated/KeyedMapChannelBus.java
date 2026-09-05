package io.bloomish.api.channel.deprecated;

import io.bloomish.api.channel.ObjectChannel;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public interface KeyedMapChannelBus extends DataChannelBus {
    <K, K1, V1> void send(ObjectChannel channel, K key, K1 dataKey, V1 data);

    <K, K1, V1> void forEach(ObjectChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer);

    <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> stream(ObjectChannel channel);

    <K, K1, V1> void forEachDrain(ObjectChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer);

    <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> drain(ObjectChannel channel);
}
