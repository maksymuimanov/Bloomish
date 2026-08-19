package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.engine.event.data.model.block.BlockModelContainer;
import io.bloomish.api.engine.event.data.model.block.spec.DependantBlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateFenceGateBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateFenceGateBlockModelStrategy implements FieldAnnotationStrategy<GenerateFenceGateBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateFenceGateBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        DependantBlockModelSpec spec = new DependantBlockModelSpec(holder, annotation.renderType(), annotation.fullBlock());
        BlockModelContainer.FENCE_GATES.add(spec);
    }

    @Override
    public Class<GenerateFenceGateBlockModel> getAnnotationClass() {
        return GenerateFenceGateBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
