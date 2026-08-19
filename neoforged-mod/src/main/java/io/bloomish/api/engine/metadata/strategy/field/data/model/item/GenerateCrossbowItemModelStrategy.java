package io.bloomish.api.engine.metadata.strategy.field.data.model.item;

import io.bloomish.api.engine.event.data.model.item.ItemModelContainer;
import io.bloomish.api.engine.event.data.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.item.GenerateCrossbowItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateCrossbowItemModelStrategy implements FieldAnnotationStrategy<GenerateCrossbowItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateCrossbowItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        ItemModelSpec spec = new ItemModelSpec(holder);
        ItemModelContainer.CROSSBOW_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateCrossbowItemModel> getAnnotationClass() {
        return GenerateCrossbowItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
