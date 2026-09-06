package io.bloomish.api.channel.registry;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.bean.BeanConstructor;
import io.bloomish.api.channel.ObjectChannel;
import io.bloomish.api.channel.ObjectChannelRegistry;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Bean
public class DefaultObjectChannelRegistry implements ObjectChannelRegistry {
    private final Map<String, ObjectChannel> channels;

    @BeanConstructor
    public DefaultObjectChannelRegistry() {
        this(Map.of());
    }

    public DefaultObjectChannelRegistry(Map<String, ObjectChannel> channels) {
        this.channels = new ConcurrentHashMap<>(channels);
    }

    @Override
    public ObjectChannel findOrRegisterChannel(String channelId) {
        return this.channels.computeIfAbsent(channelId, ObjectChannel::new);
    }

    @Override
    public boolean isChannelRegistered(String channelId) {
        return this.channels.containsKey(channelId);
    }

    @Override
    public Optional<ObjectChannel> findChannel(String channelId) {
        return Optional.ofNullable(this.channels.get(channelId));
    }

    @Override
    public void registerChannel(ObjectChannel channel) {
        String channelId = channel.id();
        this.channels.putIfAbsent(channelId, channel);
    }

    @Override
    public void unregisterChannel(String channelId) {
        this.channels.remove(channelId);
    }
}
