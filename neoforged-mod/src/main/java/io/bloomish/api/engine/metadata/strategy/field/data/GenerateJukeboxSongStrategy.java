package io.bloomish.api.engine.metadata.strategy.field.data;

import io.bloomish.api.engine.event.data.server.jukebox.ApiJukeboxSongProvider;
import io.bloomish.api.engine.event.data.server.jukebox.JukeboxSongDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateJukeboxSong;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateJukeboxSongStrategy implements FieldAnnotationStrategy<GenerateJukeboxSong> {
    @Override
    public void execute(Field field, Object object, GenerateJukeboxSong annotation) throws Exception {
        ResourceKey<JukeboxSong> jukeboxSong = ReflectionUtils.getFieldValue(field, object);
        JukeboxSongDescription description = new JukeboxSongDescription(jukeboxSong, annotation.soundEvent(), annotation.lengthInSeconds(), annotation.comparatorOutput());
        ApiJukeboxSongProvider.SONGS.add(description);
    }

    @Override
    public Class<GenerateJukeboxSong> getAnnotationClass() {
        return GenerateJukeboxSong.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
