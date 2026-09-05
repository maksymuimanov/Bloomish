package io.bloomish.api.channel.deprecated;

import io.bloomish.api.channel.ObjectChannel;

import java.util.function.Consumer;
import java.util.stream.Stream;

public interface ValueChannelBus extends DataChannelBus {
    <T> void send(ObjectChannel channel, T data);

    <T> void forEach(ObjectChannel channel, Consumer<? super T> consumer);

    <T> Stream<T> stream(ObjectChannel channel);

    <T> void forEachDrain(ObjectChannel channel, Consumer<? super T> consumer);

    <T> Stream<T> drain(ObjectChannel channel);
}
