package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.engine.event.data.tag.BlockTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddBlockTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddBlockTagStrategy implements FieldAnnotationStrategy<AddBlockTag> {
    @Override
    public void execute(Field field, Object object, AddBlockTag annotation) throws Exception {
        Holder<? extends Block> block = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(BlockTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, block);
        }
    }

    @Override
    public Class<AddBlockTag> getAnnotationClass() {
        return AddBlockTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
