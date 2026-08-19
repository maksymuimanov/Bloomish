package io.bloomish.api.engine.metadata.strategy.field.data.model;

import io.bloomish.api.engine.event.data.particle.ApiParticleProvider;
import io.bloomish.api.engine.event.data.particle.ParticleDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.model.GenerateParticleSpriteSet;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateParticleSpriteSetStrategy implements FieldAnnotationStrategy<GenerateParticleSpriteSet> {
    @Override
    public void execute(Field field, Object object, GenerateParticleSpriteSet annotation) throws Exception {
        Holder<ParticleType<?>> particleType = ReflectionUtils.getFieldValue(field, object);
        ParticleDescription particleDescription = new ParticleDescription(annotation.id(), annotation.count(), annotation.reverse());
        ApiParticleProvider.PARTICLE_SPRITES.put(particleType, particleDescription);
    }

    @Override
    public Class<GenerateParticleSpriteSet> getAnnotationClass() {
        return GenerateParticleSpriteSet.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
