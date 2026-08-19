package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.engine.event.data.tag.CatVariantTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddCatVariantTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.animal.CatVariant;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddCatVariantTagStrategy implements FieldAnnotationStrategy<AddCatVariantTag> {
    @Override
    public void execute(Field field, Object object, AddCatVariantTag annotation) throws Exception {
        Holder<? extends CatVariant> catVariant = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(CatVariantTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, catVariant);
        }
    }

    @Override
    public Class<AddCatVariantTag> getAnnotationClass() {
        return AddCatVariantTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
