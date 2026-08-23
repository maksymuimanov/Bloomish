package io.bloomish.api.channel;

import java.util.stream.Stream;

public interface BiQueueChannelBus {
    <K, V> void send(BiQueueChannel channel, K key, V data);

    <K, V> Stream<BiQueueChannel.Entry<K, V>> receive(BiQueueChannel channel);

    <K, V> Stream<BiQueueChannel.Entry<K, V>> drain(BiQueueChannel channel);
}
