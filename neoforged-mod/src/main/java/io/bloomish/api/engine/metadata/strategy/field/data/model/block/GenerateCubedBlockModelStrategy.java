package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.data.client.model.deprecated.block.BlockModelContainer;
import io.bloomish.api.data.client.model.deprecated.block.spec.BlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateCubedBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateCubedBlockModelStrategy implements FieldAnnotationStrategy<GenerateCubedBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateCubedBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        BlockModelSpec spec = new BlockModelSpec(holder, annotation.renderType());
        BlockModelContainer.CUBED_BLOCKS.add(spec);
    }

    @Override
    public Class<GenerateCubedBlockModel> getAnnotationClass() {
        return GenerateCubedBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
