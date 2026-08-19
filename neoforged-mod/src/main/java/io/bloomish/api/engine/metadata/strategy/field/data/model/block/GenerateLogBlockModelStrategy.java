package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.engine.event.data.model.block.BlockModelContainer;
import io.bloomish.api.engine.event.data.model.block.spec.BlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateLogBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateLogBlockModelStrategy implements FieldAnnotationStrategy<GenerateLogBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateLogBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        BlockModelSpec spec = new BlockModelSpec(holder, annotation.renderType());
        BlockModelContainer.LOGS.add(spec);
    }

    @Override
    public Class<GenerateLogBlockModel> getAnnotationClass() {
        return GenerateLogBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
