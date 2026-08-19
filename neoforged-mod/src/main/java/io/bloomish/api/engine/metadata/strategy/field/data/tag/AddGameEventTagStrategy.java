package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.engine.event.data.tag.GameEventTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddGameEventTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.gameevent.GameEvent;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class AddGameEventTagStrategy implements FieldAnnotationStrategy<AddGameEventTag> {
    @Override
    public void execute(Field field, Object object, AddGameEventTag annotation) throws Exception {
        Holder<? extends GameEvent> gameEvent = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(GameEventTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, gameEvent);
        }
    }

    @Override
    public Class<AddGameEventTag> getAnnotationClass() {
        return AddGameEventTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
