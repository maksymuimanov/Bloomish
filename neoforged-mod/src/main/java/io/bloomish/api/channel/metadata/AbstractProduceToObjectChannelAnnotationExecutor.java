package io.bloomish.api.channel.metadata;

import io.bloomish.api.channel.*;
import io.bloomish.api.context.ModContext;
import io.bloomish.api.metadata.AnnotationExecutor;

public abstract class AbstractProduceToObjectChannelAnnotationExecutor implements AnnotationExecutor<ProduceToObjectChannel> {
    private final ObjectChannelRegistry channelRegistry;
    private final ObjectChannelStore channelStore;

    protected AbstractProduceToObjectChannelAnnotationExecutor(ObjectChannelRegistry channelRegistry, ObjectChannelStore channelStore) {
        this.channelRegistry = channelRegistry;
        this.channelStore = channelStore;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void execute(ProduceToObjectChannel annotation, Object channelCandidate) {
        String channelId = annotation.value();
        ObjectChannel channel = this.channelRegistry.findOrRegisterChannel(channelId);
        Class<? extends ObjectTransformer> transformerType = annotation.transformer();
        Object value = ObjectTransformer.class.equals(transformerType)
                ? channelCandidate
                : ModContext.getObject(transformerType).transform(channelCandidate);
        this.channelStore.produce(channel, value);
    }

    @Override
    public Class<ProduceToObjectChannel> annotationType() {
        return ProduceToObjectChannel.class;
    }
}
