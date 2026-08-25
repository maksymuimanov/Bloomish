package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.engine.event.data.client.model.block.BlockModelContainer;
import io.bloomish.api.engine.event.data.client.model.block.spec.BlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateCarpetBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateCarpetBlockModelStrategy implements FieldAnnotationStrategy<GenerateCarpetBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateCarpetBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        BlockModelSpec spec = new BlockModelSpec(holder, annotation.renderType());
        BlockModelContainer.CARPETS.add(spec);
    }

    @Override
    public Class<GenerateCarpetBlockModel> getAnnotationClass() {
        return GenerateCarpetBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
