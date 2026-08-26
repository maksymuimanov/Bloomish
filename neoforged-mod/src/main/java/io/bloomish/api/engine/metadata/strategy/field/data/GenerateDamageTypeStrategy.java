package io.bloomish.api.engine.metadata.strategy.field.data;

import io.bloomish.api.data.server.damage.ApiDamageTypeProvider;
import io.bloomish.api.data.server.damage.DamageTypeDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateDamageType;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateDamageTypeStrategy implements FieldAnnotationStrategy<GenerateDamageType> {
    @Override
    public void execute(Field field, Object object, GenerateDamageType annotation) throws Exception {
        ResourceKey<DamageType> damageType = ReflectionUtils.getFieldValue(field, object);
        DamageTypeDescription description = new DamageTypeDescription(annotation.scaling(), annotation.exhaustion(), annotation.effects(), annotation.message());
        ApiDamageTypeProvider.DAMAGE_TYPES.put(damageType, description);
    }

    @Override
    public Class<GenerateDamageType> getAnnotationClass() {
        return GenerateDamageType.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
