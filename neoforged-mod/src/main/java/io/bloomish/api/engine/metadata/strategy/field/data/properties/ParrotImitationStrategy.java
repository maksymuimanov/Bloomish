package io.bloomish.api.engine.metadata.strategy.field.data.properties;

import io.bloomish.api.engine.event.data.map.ApiDataMapProvider;
import io.bloomish.api.engine.event.data.map.ParrotImitationDto;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.properties.ParrotImitation;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class ParrotImitationStrategy implements FieldAnnotationStrategy<ParrotImitation> {
    @Override
    public void execute(Field field, Object object, ParrotImitation annotation) throws Exception {
        Holder<EntityType<?>> entityType = ReflectionUtils.getFieldValue(field, object);
        ParrotImitationDto parrotImitationDto = new ParrotImitationDto(entityType, annotation.soundEvent(), annotation.replace());
        ApiDataMapProvider.PARROT_IMITATIONS.add(parrotImitationDto);
    }

    @Override
    public Class<ParrotImitation> getAnnotationClass() {
        return ParrotImitation.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
