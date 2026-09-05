package io.bloomish.api.channel.deprecated;

import io.bloomish.api.channel.ObjectChannel;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

public interface KeyedChannelBus extends DataChannelBus {
    <K, V> void send(ObjectChannel channel, K key, V data);

    <K, V> void forEach(ObjectChannel channel, BiConsumer<? super K, ? super V> consumer);

    <K, V> Stream<KeyedChannelEntry<K, V>> stream(ObjectChannel channel);

    <K, V> void forEachDrain(ObjectChannel channel, BiConsumer<? super K, ? super V> consumer);

    <K, V> Stream<KeyedChannelEntry<K, V>> drain(ObjectChannel channel);
}
