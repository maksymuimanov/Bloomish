package io.bloomish.api.engine.metadata.strategy.field.data.model.item;

import io.bloomish.api.engine.event.data.client.model.item.ItemModelContainer;
import io.bloomish.api.engine.event.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.item.GenerateBasicItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateBasicItemModelStrategy implements FieldAnnotationStrategy<GenerateBasicItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateBasicItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        ItemModelSpec spec = new ItemModelSpec(holder);
        ItemModelContainer.BASIC_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateBasicItemModel> getAnnotationClass() {
        return GenerateBasicItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
