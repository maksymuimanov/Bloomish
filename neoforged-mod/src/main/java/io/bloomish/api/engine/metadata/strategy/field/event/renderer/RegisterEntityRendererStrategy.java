package io.bloomish.api.engine.metadata.strategy.field.event.renderer;

import io.bloomish.api.engine.event.handler.EntityRendererRegisterRendererEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.event.renderer.RegisterEntityRenderer;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.EntityRendererRegisterRendererEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_EVENT_RENDERER)
public class RegisterEntityRendererStrategy implements FieldAnnotationStrategy<RegisterEntityRenderer> {
    @Override
    @SuppressWarnings("unchecked")
    public void execute(Field field, Object object, RegisterEntityRenderer annotation) throws Exception {
        Holder<? extends EntityType<? extends Entity>> entityType = ReflectionUtils.getFieldValue(field, object);
        Class<? extends EntityRenderer<?>> rendererClass = annotation.value();
        Constructor<? extends EntityRenderer<?>> rendererConstructor = rendererClass.getDeclaredConstructor(EntityRendererProvider.Context.class);
        EntityRendererRegisterRendererEventHandler.RENDERING_REGISTRIES.add(event -> {
            event.registerEntityRenderer(entityType.value(), context -> {
                try {
                    return (EntityRenderer<Entity>) rendererConstructor.newInstance(context);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @Override
    public Class<RegisterEntityRenderer> getAnnotationClass() {
        return RegisterEntityRenderer.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(EntityRendererRegisterRendererEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
