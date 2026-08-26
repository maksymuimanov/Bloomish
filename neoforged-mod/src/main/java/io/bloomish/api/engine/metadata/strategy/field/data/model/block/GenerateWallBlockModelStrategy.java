package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.data.client.model.deprecated.block.BlockModelContainer;
import io.bloomish.api.data.client.model.deprecated.block.spec.DependantBlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateWallBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateWallBlockModelStrategy implements FieldAnnotationStrategy<GenerateWallBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateWallBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        DependantBlockModelSpec spec = new DependantBlockModelSpec(holder, annotation.renderType(), annotation.fullBlock());
        BlockModelContainer.WALLS.add(spec);
    }

    @Override
    public Class<GenerateWallBlockModel> getAnnotationClass() {
        return GenerateWallBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
