package io.bloomish.api.engine.metadata.strategy.field.data.model;

import io.bloomish.api.engine.event.data.painting.ApiPaintingVariantProvider;
import io.bloomish.api.engine.event.data.painting.PaintingVariantDescription;
import io.bloomish.api.engine.event.data.tag.PaintingVariantTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.GeneratePainting;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GeneratePaintingStrategy implements FieldAnnotationStrategy<GeneratePainting> {
    public static final String MINECRAFT_PLACEABLES_TAG = "minecraft:placeable";

    @Override
    public void execute(Field field, Object object, GeneratePainting annotation) throws Exception {
        ResourceKey<PaintingVariant> paintingVariant = ReflectionUtils.getFieldValue(field, object);
        PaintingVariantDescription paintingVariantDescription = new PaintingVariantDescription(paintingVariant, annotation.width(), annotation.height());
        ApiPaintingVariantProvider.PAINTINGS.add(paintingVariantDescription);
        MapUtils.putToListMap(PaintingVariantTagsProvider.TAG_GENERATION_DESCRIPTIONS, MINECRAFT_PLACEABLES_TAG, paintingVariant);
    }

    @Override
    public Class<GeneratePainting> getAnnotationClass() {
        return GeneratePainting.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
