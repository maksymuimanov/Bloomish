package io.bloomish.api.channel;

import java.util.function.Consumer;
import java.util.stream.Stream;

public interface ValueChannelBus extends DataChannelBus {
    <T> void send(DataChannel channel, T data);

    <T> void forEach(DataChannel channel, Consumer<? super T> consumer);

    <T> Stream<T> stream(DataChannel channel);

    <T> void forEachDrain(DataChannel channel, Consumer<? super T> consumer);

    <T> Stream<T> drain(DataChannel channel);
}
