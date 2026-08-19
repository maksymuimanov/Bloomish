package io.bloomish.api.engine.metadata.strategy.field.data.properties;

import io.bloomish.api.engine.event.data.map.ApiDataMapProvider;
import io.bloomish.api.engine.event.data.map.OxidizableDto;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.properties.Oxidizable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class OxidizableStrategy implements FieldAnnotationStrategy<Oxidizable> {
    @Override
    public void execute(Field field, Object object, Oxidizable annotation) throws Exception {
        Holder<? extends Block> block = ReflectionUtils.getFieldValue(field, object);
        OxidizableDto oxidizableDto = new OxidizableDto(block, annotation.nextBlock(), annotation.replace());
        ApiDataMapProvider.OXIDIZABLES.add(oxidizableDto);
    }

    @Override
    public Class<Oxidizable> getAnnotationClass() {
        return Oxidizable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
