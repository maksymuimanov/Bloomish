package io.bloomish.api.channel;

import java.util.stream.Stream;

public interface BiChannelBus {
    <K, V> void send(BiChannel channel, K key, V data);

    <K, V> Stream<BiChannel.Entry<K, V>> receive(BiChannel channel);

    <K, V> Stream<BiChannel.Entry<K, V>> drain(BiChannel channel);
}
