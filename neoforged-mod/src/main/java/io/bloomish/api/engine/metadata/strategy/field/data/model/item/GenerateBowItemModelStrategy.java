package io.bloomish.api.engine.metadata.strategy.field.data.model.item;

import io.bloomish.api.data.client.model.deprecated.item.ItemModelContainer;
import io.bloomish.api.data.client.model.deprecated.item.spec.ItemModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.item.GenerateBowItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateBowItemModelStrategy implements FieldAnnotationStrategy<GenerateBowItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateBowItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        ItemModelSpec spec = new ItemModelSpec(holder);
        ItemModelContainer.BOW_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateBowItemModel> getAnnotationClass() {
        return GenerateBowItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
