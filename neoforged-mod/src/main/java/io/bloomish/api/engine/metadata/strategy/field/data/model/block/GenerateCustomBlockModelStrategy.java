package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.engine.event.data.model.block.BlockModelContainer;
import io.bloomish.api.engine.event.data.model.block.spec.CustomBlockModelSpec;
import io.bloomish.api.engine.event.data.model.block.strategy.BlockModelProviderStrategy;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateCustomBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;
import java.util.List;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateCustomBlockModelStrategy implements FieldAnnotationStrategy<GenerateCustomBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateCustomBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        List<String> additionalData = List.of(annotation.additionalData());
        CustomBlockModelSpec spec = new CustomBlockModelSpec(holder, annotation.renderType(), additionalData);
        BlockModelProviderStrategy<CustomBlockModelSpec> providerStrategy = ReflectionUtils.createObject(annotation.strategy());
        BlockModelContainer.CUSTOM_MODELS.put(spec, providerStrategy);
    }

    @Override
    public Class<GenerateCustomBlockModel> getAnnotationClass() {
        return GenerateCustomBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
