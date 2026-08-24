package io.bloomish.api.channel;

import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public interface KeyedQueueChannelBus extends DataChannelBus {
    <K, V> void send(DataChannel channel, K key, V data);

    <K, V> void forEach(DataChannel channel, BiConsumer<? super K, Queue<V>> consumer);

    <K, V> Stream<KeyedQueueChannelEntry<K, V>> stream(DataChannel channel);

    <K, V> void forEachDrain(DataChannel channel, BiConsumer<? super K, Queue<V>> consumer);

    <K, V> Stream<KeyedQueueChannelEntry<K, V>> drain(DataChannel channel);
}
