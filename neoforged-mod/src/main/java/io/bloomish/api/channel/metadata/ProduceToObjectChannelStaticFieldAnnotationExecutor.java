package io.bloomish.api.channel.metadata;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObjectChannelRegistry;
import io.bloomish.api.channel.ObjectChannelStore;
import io.bloomish.api.channel.ProduceToObjectChannel;
import io.bloomish.api.metadata.executor.StaticFieldAnnotationExecutor;
import io.bloomish.api.util.ReflectionUtils;

import java.lang.reflect.Field;

@Bean
public class ProduceToObjectChannelStaticFieldAnnotationExecutor
        extends AbstractProduceToObjectChannelAnnotationExecutor
        implements StaticFieldAnnotationExecutor<ProduceToObjectChannel> {
    protected ProduceToObjectChannelStaticFieldAnnotationExecutor(ObjectChannelRegistry channelRegistry, ObjectChannelStore channelStore) {
        super(channelRegistry, channelStore);
    }

    @Override
    public void execute(ProduceToObjectChannel annotation, Field field) {
        Object channelCandidate = ReflectionUtils.extractStaticFieldValue(field);
        this.execute(annotation, channelCandidate);
    }
}
