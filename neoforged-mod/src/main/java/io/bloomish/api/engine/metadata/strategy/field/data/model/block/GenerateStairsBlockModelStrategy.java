package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.engine.event.data.model.block.BlockModelContainer;
import io.bloomish.api.engine.event.data.model.block.spec.DependantBlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateStairsBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateStairsBlockModelStrategy implements FieldAnnotationStrategy<GenerateStairsBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateStairsBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        DependantBlockModelSpec spec = new DependantBlockModelSpec(holder, annotation.fullBlock());
        BlockModelContainer.STAIRS.add(spec);
    }

    @Override
    public Class<GenerateStairsBlockModel> getAnnotationClass() {
        return GenerateStairsBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
