package io.bloomish.api.channel.endpoint;

import io.bloomish.api.channel.ObjectChannel;

import java.util.Queue;
import java.util.stream.Stream;

public interface ObjectChannelStore {
    void produce(ObjectChannel channel, Object input);

    <T> Stream<T> detach(ObjectChannel channel);

    <T> Stream<T> consume(ObjectChannel channel);

    <T> Queue<T> lazyQueue(ObjectChannel channel);

    void clear();
}
