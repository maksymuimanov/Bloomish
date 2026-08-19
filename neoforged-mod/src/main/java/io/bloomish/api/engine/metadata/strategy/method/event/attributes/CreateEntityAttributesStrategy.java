package io.bloomish.api.engine.metadata.strategy.method.event.attributes;

import io.bloomish.api.engine.event.handler.EntityAttributeEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.event.attributes.CreateEntityAttributes;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.EntityAttributeEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.method.MethodAnnotationStrategy;
import io.bloomish.api.core.util.ReflectionUtils;
import io.bloomish.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.lang.reflect.Method;

@Strategy(StrategyPoolInitializer.DEFAULT_METHOD_EVENT_ATTRIBUTES)
public class CreateEntityAttributesStrategy implements MethodAnnotationStrategy<CreateEntityAttributes> {
    @Override
    @SuppressWarnings("deprecation")
    public void execute(Method method, Object object, CreateEntityAttributes annotation) throws Exception {
        AttributeSupplier.Builder attributes = ReflectionUtils.invokeMethod(method, object);
        String[] entityTypeIds = annotation.value();
        for (String id : entityTypeIds) {
            Holder<? extends EntityType<?>> entityType = RegistryUtils.getEntityType(id).builtInRegistryHolder();
            EntityAttributeEventHandler.ENTITY_ATTRIBUTES.put(entityType, attributes);
        }
    }

    @Override
    public Class<CreateEntityAttributes> getAnnotationClass() {
        return CreateEntityAttributes.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(EntityAttributeEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
