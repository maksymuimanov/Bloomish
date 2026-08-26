package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.data.client.model.deprecated.block.BlockModelContainer;
import io.bloomish.api.data.client.model.deprecated.block.spec.TrapDoorBlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateTrapDoorBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateTrapDoorBlockModelStrategy implements FieldAnnotationStrategy<GenerateTrapDoorBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateTrapDoorBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        TrapDoorBlockModelSpec spec = new TrapDoorBlockModelSpec(holder, annotation.renderType(), annotation.orientable());
        BlockModelContainer.TRAPDOORS.add(spec);
    }

    @Override
    public Class<GenerateTrapDoorBlockModel> getAnnotationClass() {
        return GenerateTrapDoorBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
