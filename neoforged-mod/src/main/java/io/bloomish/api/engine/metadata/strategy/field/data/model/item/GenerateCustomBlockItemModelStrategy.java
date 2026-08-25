package io.bloomish.api.engine.metadata.strategy.field.data.model.item;

import io.bloomish.api.engine.event.data.client.model.item.ItemModelContainer;
import io.bloomish.api.engine.event.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.client.model.item.spec.CustomBlockItemModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.item.GenerateCustomBlockItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;
import java.util.List;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateCustomBlockItemModelStrategy implements FieldAnnotationStrategy<GenerateCustomBlockItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateCustomBlockItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        List<String> additionalData = List.of(annotation.additionalData());
        CustomBlockItemModelSpec spec = new CustomBlockItemModelSpec(holder, additionalData);
        ItemModelProviderStrategy<CustomBlockItemModelSpec> strategy = ReflectionUtils.createObject(annotation.strategy());
        ItemModelContainer.CUSTOM_BLOCK_MODELS.put(spec, strategy);
    }

    @Override
    public Class<GenerateCustomBlockItemModel> getAnnotationClass() {
        return GenerateCustomBlockItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
