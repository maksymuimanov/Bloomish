package io.bloomish.api.engine.metadata.strategy.field.data.model;

import io.bloomish.api.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.engine.event.data.server.wolf.ApiWolfVariantProvider;
import io.bloomish.api.engine.event.data.server.wolf.WolfVariantDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.GenerateWolfVariant;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import io.bloomish.api.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.WolfVariant;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateWolfVariantStrategy implements FieldAnnotationStrategy<GenerateWolfVariant> {
    @Override
    public void execute(Field field, Object object, GenerateWolfVariant annotation) throws Exception {
        ResourceKey<WolfVariant> variantResourceKey = ReflectionUtils.getFieldValue(field, object);
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotation.biomeTagContainer());
        ApiWolfVariantProvider.VARIANTS.add(new WolfVariantDescription(variantResourceKey, annotation.biomeTag()));
    }

    @Override
    public Class<GenerateWolfVariant> getAnnotationClass() {
        return GenerateWolfVariant.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
