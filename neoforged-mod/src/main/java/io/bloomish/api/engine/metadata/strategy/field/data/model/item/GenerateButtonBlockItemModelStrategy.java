package io.bloomish.api.engine.metadata.strategy.field.data.model.item;

import io.bloomish.api.engine.event.data.model.item.ItemModelContainer;
import io.bloomish.api.engine.event.data.model.item.spec.DependantBlockItemModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.item.GenerateButtonBlockItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateButtonBlockItemModelStrategy implements FieldAnnotationStrategy<GenerateButtonBlockItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateButtonBlockItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        DependantBlockItemModelSpec spec = new DependantBlockItemModelSpec(holder, annotation.fullBlock());
        ItemModelContainer.BUTTON_BLOCK_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateButtonBlockItemModel> getAnnotationClass() {
        return GenerateButtonBlockItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
