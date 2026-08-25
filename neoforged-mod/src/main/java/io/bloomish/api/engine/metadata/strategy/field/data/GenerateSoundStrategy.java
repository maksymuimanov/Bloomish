package io.bloomish.api.engine.metadata.strategy.field.data;

import io.bloomish.api.engine.event.data.client.sound.ApiSoundProvider;
import io.bloomish.api.engine.event.data.client.sound.SoundDescription;
import io.bloomish.api.engine.event.data.client.sound.SoundHolder;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateSound;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateSoundStrategy implements FieldAnnotationStrategy<GenerateSound> {
    @Override
    public void execute(Field field, Object object, GenerateSound annotation) throws Exception {
        Holder<SoundEvent> soundEvent = ReflectionUtils.getFieldValue(field, object);
        SoundHolder description = new SoundHolder(soundEvent, annotation.replace());
        List<SoundDescription> soundDescriptions = Arrays.stream(annotation.value())
                .map(sound -> new SoundDescription(sound.fileName(), sound.type(),
                        sound.volume(), sound.pitch(),
                        sound.weight(), sound.attenuationDistance(),
                        sound.stream(), sound.preload()))
                .toList();
        ApiSoundProvider.SOUNDS.put(description, soundDescriptions);
    }

    @Override
    public Class<GenerateSound> getAnnotationClass() {
        return GenerateSound.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
