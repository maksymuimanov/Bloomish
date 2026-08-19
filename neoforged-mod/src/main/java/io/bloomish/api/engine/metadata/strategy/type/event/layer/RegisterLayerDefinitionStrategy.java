package io.bloomish.api.engine.metadata.strategy.type.event.layer;

import io.bloomish.api.engine.event.handler.EntityRendererRegisterLayerDefinitionEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.event.layer.RegisterLayerDefinition;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.EntityRendererRegisterLayerDefinitionEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.type.ClassAnnotationStrategy;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

@Strategy(StrategyInitializer.DEFAULT_CLASS_EVENT_LAYER)
public class RegisterLayerDefinitionStrategy implements ClassAnnotationStrategy<RegisterLayerDefinition> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterLayerDefinition annotation) throws Exception {
        ModelLayerLocation modelLayerLocation = (ModelLayerLocation) clazz.getDeclaredField(annotation.fieldName()).get(object);
        LayerDefinition layerDefinition = (LayerDefinition) clazz.getDeclaredMethod(annotation.factoryMethodName()).invoke(object);
        EntityRendererRegisterLayerDefinitionEventHandler.LAYERS.put(modelLayerLocation, layerDefinition);
    }

    @Override
    public Class<RegisterLayerDefinition> getAnnotationClass() {
        return RegisterLayerDefinition.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(EntityRendererRegisterLayerDefinitionEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
