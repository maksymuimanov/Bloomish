package io.bloomish.api.engine.metadata.strategy.field.data;

import io.bloomish.api.engine.event.data.trim.material.ApiTrimMaterialProvider;
import io.bloomish.api.engine.event.data.trim.material.TrimMaterialDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateTrimMaterial;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateTrimMaterialStrategy implements FieldAnnotationStrategy<GenerateTrimMaterial> {
    @Override
    public void execute(Field field, Object object, GenerateTrimMaterial annotation) throws Exception {
        ResourceKey<TrimMaterial> trimMaterial = ReflectionUtils.getFieldValue(field, object);
        TrimMaterialDescription descriptionHolder = new TrimMaterialDescription(annotation.item(), annotation.color(), annotation.itemModelIndex());
        ApiTrimMaterialProvider.TRIM_MATERIALS.put(trimMaterial, descriptionHolder);
    }

    @Override
    public Class<GenerateTrimMaterial> getAnnotationClass() {
        return GenerateTrimMaterial.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
