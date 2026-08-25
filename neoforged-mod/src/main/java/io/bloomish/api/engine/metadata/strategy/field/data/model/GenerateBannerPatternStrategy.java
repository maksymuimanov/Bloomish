package io.bloomish.api.engine.metadata.strategy.field.data.model;

import io.bloomish.api.engine.event.data.server.banner.ApiBannerPatternProvider;
import io.bloomish.api.engine.event.data.server.banner.BannerPatternDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.GenerateBannerPattern;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateBannerPatternStrategy implements FieldAnnotationStrategy<GenerateBannerPattern> {
    @Override
    public void execute(Field field, Object object, GenerateBannerPattern annotation) throws Exception {
        ResourceKey<BannerPattern> patternResourceKey = ReflectionUtils.getFieldValue(field, object);
        ApiBannerPatternProvider.PATTERNS.add(new BannerPatternDescription(patternResourceKey));
    }

    @Override
    public Class<GenerateBannerPattern> getAnnotationClass() {
        return GenerateBannerPattern.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
