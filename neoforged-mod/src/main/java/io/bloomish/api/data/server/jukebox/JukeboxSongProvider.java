package io.bloomish.api.data.server.jukebox;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.JukeboxSong;

public interface JukeboxSongProvider {
    void addSong(BootstrapContext<JukeboxSong> context);
}
