package io.bloomish.api.engine.metadata.strategy.field.data.model.item;

import io.bloomish.api.data.client.model.deprecated.item.ItemModelContainer;
import io.bloomish.api.data.client.model.deprecated.item.spec.DependantBlockItemModelSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.item.GenerateWallBlockItemModel;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateWallBlockItemModelStrategy implements FieldAnnotationStrategy<GenerateWallBlockItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateWallBlockItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        DependantBlockItemModelSpec spec = new DependantBlockItemModelSpec(holder, annotation.fullBlock());
        ItemModelContainer.WALL_BLOCK_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateWallBlockItemModel> getAnnotationClass() {
        return GenerateWallBlockItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
