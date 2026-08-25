package io.bloomish.api.engine.metadata.strategy.field.data.model.block;

import io.bloomish.api.engine.event.data.client.model.block.BlockModelContainer;
import io.bloomish.api.engine.event.data.client.model.block.spec.SignBlockModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.block.GenerateSignBlockModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateSignBlockModelStrategy implements FieldAnnotationStrategy<GenerateSignBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateSignBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        SignBlockModelSpec spec = new SignBlockModelSpec(holder, annotation.wallSign(), annotation.particleTexture());
        BlockModelContainer.SIGNS.add(spec);
    }

    @Override
    public Class<GenerateSignBlockModel> getAnnotationClass() {
        return GenerateSignBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
