package io.bloomish.api.engine.metadata.strategy.field.data.properties;

import io.bloomish.api.engine.event.data.map.ApiDataMapProvider;
import io.bloomish.api.engine.event.data.map.CompostableDto;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.properties.Compostable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class CompostableStrategy implements FieldAnnotationStrategy<Compostable> {
    @Override
    public void execute(Field field, Object object, Compostable annotation) throws Exception {
        Holder<? extends Item> itemHolder = ReflectionUtils.getItemHolder(field, object);
        CompostableDto compostableDto = new CompostableDto(itemHolder, annotation.chance(), annotation.replace());
        ApiDataMapProvider.COMPOSTABLES.add(compostableDto);
    }

    @Override
    public Class<Compostable> getAnnotationClass() {
        return Compostable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
