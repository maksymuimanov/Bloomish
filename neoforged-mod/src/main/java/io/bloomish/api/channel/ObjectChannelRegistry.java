package io.bloomish.api.channel;

import java.util.Optional;

public interface ObjectChannelRegistry {
    ObjectChannel findOrRegisterChannel(String channelId);

    boolean isChannelRegistered(String channelId);

    Optional<ObjectChannel> findChannel(String channelId);

    void registerChannel(ObjectChannel channel);

    void unregisterChannel(String channelId);
}
