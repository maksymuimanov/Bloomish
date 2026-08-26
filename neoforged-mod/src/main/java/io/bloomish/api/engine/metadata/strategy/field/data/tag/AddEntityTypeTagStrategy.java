package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.data.server.tag.EntityTypeTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddEntityTypeTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class AddEntityTypeTagStrategy implements FieldAnnotationStrategy<AddEntityTypeTag> {
    @Override
    public void execute(Field field, Object object, AddEntityTypeTag annotation) throws Exception {
        Holder<? extends EntityType<?>> entityType = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(EntityTypeTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, entityType);
        }
    }

    @Override
    public Class<AddEntityTypeTag> getAnnotationClass() {
        return AddEntityTypeTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
