package io.bloomish.api.channel.metadata;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObjectChannelRegistry;
import io.bloomish.api.channel.ObjectChannelStore;
import io.bloomish.api.channel.ProduceToObjectChannel;
import io.bloomish.api.metadata.executor.FieldAnnotationExecutor;
import io.bloomish.api.util.ReflectionUtils;

import java.lang.reflect.Field;

@Bean
public class ProduceToObjectChannelFieldAnnotationExecutor
        extends AbstractProduceToObjectChannelAnnotationExecutor
        implements FieldAnnotationExecutor<ProduceToObjectChannel> {
    protected ProduceToObjectChannelFieldAnnotationExecutor(ObjectChannelRegistry channelRegistry, ObjectChannelStore channelStore) {
        super(channelRegistry, channelStore);
    }

    @Override
    public void execute(ProduceToObjectChannel annotation, Field field, Object bean) {
        Object channelCandidate = ReflectionUtils.extractFieldValue(field, bean);
        this.execute(annotation, channelCandidate);
    }
}
