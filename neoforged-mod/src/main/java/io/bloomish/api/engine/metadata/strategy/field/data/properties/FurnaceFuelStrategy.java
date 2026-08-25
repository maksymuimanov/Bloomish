package io.bloomish.api.engine.metadata.strategy.field.data.properties;

import io.bloomish.api.engine.event.data.server.map.ApiDataMapProvider;
import io.bloomish.api.engine.event.data.server.map.FurnaceFuelDto;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.properties.FurnaceFuel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class FurnaceFuelStrategy implements FieldAnnotationStrategy<FurnaceFuel> {
    @Override
    public void execute(Field field, Object object, FurnaceFuel annotation) throws Exception {
        Holder<? extends Item> itemHolder = ReflectionUtils.getItemHolder(field, object);
        FurnaceFuelDto fuelDto = new FurnaceFuelDto(itemHolder, annotation.burnTime(), annotation.replace());
        ApiDataMapProvider.FURNACE_FUELS.add(fuelDto);
    }

    @Override
    public Class<FurnaceFuel> getAnnotationClass() {
        return FurnaceFuel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
