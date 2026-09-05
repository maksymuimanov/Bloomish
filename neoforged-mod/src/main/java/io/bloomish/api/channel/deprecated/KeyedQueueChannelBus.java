package io.bloomish.api.channel.deprecated;

import io.bloomish.api.channel.ObjectChannel;

import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public interface KeyedQueueChannelBus extends DataChannelBus {
    <K, V> void send(ObjectChannel channel, K key, V data);

    <K, V> void forEach(ObjectChannel channel, BiConsumer<? super K, Queue<V>> consumer);

    <K, V> Stream<KeyedQueueChannelEntry<K, V>> stream(ObjectChannel channel);

    <K, V> void forEachDrain(ObjectChannel channel, BiConsumer<? super K, Queue<V>> consumer);

    <K, V> Stream<KeyedQueueChannelEntry<K, V>> drain(ObjectChannel channel);
}
