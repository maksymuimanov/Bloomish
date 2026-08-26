package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.data.server.tag.FluidTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddFluidTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.material.Fluid;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class AddFluidTagStrategy implements FieldAnnotationStrategy<AddFluidTag> {
    @Override
    public void execute(Field field, Object object, AddFluidTag annotation) throws Exception {
        Holder<? extends Fluid> fluid = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(FluidTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, fluid);
        }
    }

    @Override
    public Class<AddFluidTag> getAnnotationClass() {
        return AddFluidTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
