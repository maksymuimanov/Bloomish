package io.bloomish.example.jukebox;

import io.bloomish.api.engine.metadata.annotation.data.GenerateJukeboxSong;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public final class ExampleJukeboxSongs {
    @TranslateAmericanEnglish("DavigJ - Thaw")
    @GenerateJukeboxSong(soundEvent = "example:example_jukebox_song_sound", lengthInSeconds = 222, comparatorOutput = 15)
    public static final ResourceKey<JukeboxSong> EXAMPLE_JUKEBOX_SONG = ResourceUtils.createKey(Registries.JUKEBOX_SONG, "example");
}