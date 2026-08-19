package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.engine.event.data.tag.ItemTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddItemTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddItemTagStrategy implements FieldAnnotationStrategy<AddItemTag> {
    @Override
    public void execute(Field field, Object object, AddItemTag annotation) throws Exception {
        Holder<? extends Item> item = ReflectionUtils.getItemHolder(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(ItemTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, item);
        }
    }

    @Override
    public Class<AddItemTag> getAnnotationClass() {
        return AddItemTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
