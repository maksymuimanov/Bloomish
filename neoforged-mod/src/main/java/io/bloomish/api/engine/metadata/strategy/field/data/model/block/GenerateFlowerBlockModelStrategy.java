package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.data.client.model.deprecated.block.BlockModelContainer;
import io.bloomish.api.data.client.model.deprecated.block.spec.DependantBlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateFlowerBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateFlowerBlockModelStrategy implements FieldAnnotationStrategy<GenerateFlowerBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateFlowerBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        DependantBlockModelSpec spec = new DependantBlockModelSpec(holder, annotation.renderType(), annotation.pottedFlower());
        BlockModelContainer.FLOWER_BLOCKS.add(spec);
    }

    @Override
    public Class<GenerateFlowerBlockModel> getAnnotationClass() {
        return GenerateFlowerBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
