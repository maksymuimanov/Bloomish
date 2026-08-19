package io.bloomish.api.engine.metadata.strategy.field.event.particle;

import io.bloomish.api.engine.event.handler.RegisterParticleProvidersEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.event.particle.RegisterParticleProvider;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.RegisterParticleProvidersEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Strategy(StrategyInitializer.DEFAULT_FIELD_EVENT_PARTICLE)
public class RegisterParticleProviderStrategy implements FieldAnnotationStrategy<RegisterParticleProvider> {
    @Override
    @SuppressWarnings("unchecked")
    public void execute(Field field, Object object, RegisterParticleProvider annotation) throws Exception {
        Holder<? extends ParticleType<ParticleOptions>> particleType = ReflectionUtils.getFieldValue(field, object);
        Class<? extends ParticleProvider<?>> providerClass = annotation.value();
        Constructor<? extends ParticleProvider<?>> providerConstructor = providerClass.getDeclaredConstructor(SpriteSet.class);
        RegisterParticleProvidersEventHandler.PROVIDER_REGISTRIES.add(event -> {
            event.registerSpriteSet(particleType.value(), spriteSet -> {
                try {
                    return (ParticleProvider<ParticleOptions>) providerConstructor.newInstance(spriteSet);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @Override
    public Class<RegisterParticleProvider> getAnnotationClass() {
        return RegisterParticleProvider.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(RegisterParticleProvidersEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
