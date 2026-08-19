package io.bloomish.api.engine.metadata.strategy.field.data.properties;

import io.bloomish.api.engine.event.data.map.ApiDataMapProvider;
import io.bloomish.api.engine.event.data.map.WaxableDto;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.properties.Waxable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class WaxableStrategy implements FieldAnnotationStrategy<Waxable> {
    @Override
    public void execute(Field field, Object object, Waxable annotation) throws Exception {
        Holder<? extends Block> block = ReflectionUtils.getFieldValue(field, object);
        WaxableDto waxableDto = new WaxableDto(block, annotation.waxedBlock(), annotation.replace());
        ApiDataMapProvider.WAXABLES.add(waxableDto);
    }

    @Override
    public Class<Waxable> getAnnotationClass() {
        return Waxable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
