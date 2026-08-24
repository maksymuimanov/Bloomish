package io.bloomish.api.channel;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

public interface KeyedChannelBus extends DataChannelBus {
    <K, V> void send(DataChannel channel, K key, V data);

    <K, V> void forEach(DataChannel channel, BiConsumer<? super K, ? super V> consumer);

    <K, V> Stream<KeyedChannelEntry<K, V>> stream(DataChannel channel);

    <K, V> void forEachDrain(DataChannel channel, BiConsumer<? super K, ? super V> consumer);

    <K, V> Stream<KeyedChannelEntry<K, V>> drain(DataChannel channel);
}
