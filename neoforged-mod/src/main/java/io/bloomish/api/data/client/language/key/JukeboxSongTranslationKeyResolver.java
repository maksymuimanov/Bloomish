package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

@Injected
public class JukeboxSongTranslationKeyResolver extends AbstractResourceKeyResolver<JukeboxSong> {
    public static final String PREFIX = "jukebox_song";

    @Override
    protected ResourceKey<? extends Registry<JukeboxSong>> getRegistryKey() {
        return Registries.JUKEBOX_SONG;
    }

    @Override
    public String resolve(ResourceKey<JukeboxSong> jukeboxSongResourceKey) {
        return this.resolveTranslationKey(PREFIX, jukeboxSongResourceKey);
    }
}
