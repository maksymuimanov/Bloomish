package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.engine.event.data.server.tag.PointOfInterestTypeTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddPointOfInterestTypeTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class AddPointOfInterestTypeTagStrategy implements FieldAnnotationStrategy<AddPointOfInterestTypeTag> {
    @Override
    public void execute(Field field, Object object, AddPointOfInterestTypeTag annotation) throws Exception {
        Holder<? extends PoiType> poiType = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(PointOfInterestTypeTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, poiType);
        }
    }

    @Override
    public Class<AddPointOfInterestTypeTag> getAnnotationClass() {
        return AddPointOfInterestTypeTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
