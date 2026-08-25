package io.bloomish.api.engine.metadata.strategy.field.data.model.item;

import io.bloomish.api.engine.event.data.client.model.item.ItemModelContainer;
import io.bloomish.api.engine.event.data.client.model.item.spec.BlockItemModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.item.GenerateLogBlockItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateLogBlockItemModelStrategy implements FieldAnnotationStrategy<GenerateLogBlockItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateLogBlockItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        BlockItemModelSpec spec = new BlockItemModelSpec(holder);
        ItemModelContainer.LOG_BLOCK_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateLogBlockItemModel> getAnnotationClass() {
        return GenerateLogBlockItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
