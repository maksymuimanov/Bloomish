package io.bloomish.api.channel.registry;

import io.bloomish.api.channel.ObjectChannel;

import java.util.Optional;

public interface ObjectChannelRegistry {
    ObjectChannel findOrRegisterChannel(String channelId);

    boolean isChannelRegistered(String channelId);

    Optional<ObjectChannel> findChannel(String channelId);

    void registerChannel(ObjectChannel channel);

    void unregisterChannel(String channelId);
}
