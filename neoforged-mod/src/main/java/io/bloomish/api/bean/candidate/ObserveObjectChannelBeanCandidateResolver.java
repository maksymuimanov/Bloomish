package io.bloomish.api.bean.candidate;

import io.bloomish.api.bean.BeanCandidateResolver;
import io.bloomish.api.channel.ObjectChannel;
import io.bloomish.api.channel.ObjectChannelRegistry;
import io.bloomish.api.channel.ObjectChannelStore;
import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.context.ObjectRegistry;

import java.lang.reflect.Parameter;
import java.util.Optional;

public class ObserveObjectChannelBeanCandidateResolver implements BeanCandidateResolver {
    @Override
    public Optional<Object> resolveBeanCandidate(Parameter parameter, ObjectRegistry registry) {
        ObserveObjectChannel observeObjectChannel = parameter.getAnnotation(ObserveObjectChannel.class);
        ObjectChannelRegistry channelRegistry = registry.getByClass(ObjectChannelRegistry.class);
        String channelId = observeObjectChannel.value();
        ObjectChannel channel = channelRegistry.findOrRegisterChannel(channelId);
        ObjectChannelStore channelStore = registry.getByClass(ObjectChannelStore.class);
        Object value = switch (observeObjectChannel.returnType()) {
            case STREAM -> channelStore.consume(channel);
            case QUEUE -> channelStore.queue(channel);
        };
        return Optional.of(value);
    }

    @Override
    public boolean isApplicable(Parameter parameter) {
        return parameter.isAnnotationPresent(ObserveObjectChannel.class);
    }
}
