package io.bloomish.api.engine.metadata.strategy.field.data.model;

import io.bloomish.api.engine.event.data.trim.pattern.ApiTrimPatternProvider;
import io.bloomish.api.engine.event.data.trim.pattern.TrimPatternDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.GenerateTrimPattern;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateTrimPatternStrategy implements FieldAnnotationStrategy<GenerateTrimPattern> {
    @Override
    public void execute(Field field, Object object, GenerateTrimPattern annotation) throws Exception {
        ResourceKey<TrimPattern> trimPattern = ReflectionUtils.getFieldValue(field, object);
        TrimPatternDescription descriptionHolder = new TrimPatternDescription(annotation.item(), annotation.decal());
        ApiTrimPatternProvider.TRIM_PATTERNS.put(trimPattern, descriptionHolder);
    }

    @Override
    public Class<GenerateTrimPattern> getAnnotationClass() {
        return GenerateTrimPattern.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
