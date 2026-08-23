package io.bloomish.api.channel;

import java.util.stream.Stream;

public interface ChannelBus {
    <T> void send(Channel channel, T data);

    <T> Stream<T> receive(Channel channel);

    <T> Stream<T> drain(Channel channel);
}
