package io.bloomish.api.data.client.sound;

import io.bloomish.api.core.collection.TemporalMap;
import io.bloomish.api.data.client.language.key.SoundEventTranslationKeyResolver;
import io.bloomish.api.engine.context.ModContext;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ApiSoundProvider extends SoundDefinitionsProvider {
    public static final Map<SoundHolder, List<SoundDescription>> SOUNDS = new TemporalMap<>();

    public ApiSoundProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModContext.currentMod.getModId(), existingFileHelper);
    }

    @Override
    public void registerSounds() {
        final String modId = ModContext.currentMod.getModId();
        SOUNDS.forEach((holder, descriptions) -> {
            SoundDefinition soundDefinition = definition();
            descriptions.forEach(soundDescription -> soundDefinition.with(
                    sound(modId + ":" + soundDescription.id(), soundDescription.type())
                            .volume(soundDescription.volume())
                            .pitch(soundDescription.pitch())
                            .weight(soundDescription.weight())
                            .attenuationDistance(soundDescription.attenuationDistance())
                            .stream(soundDescription.stream())
                            .preload(soundDescription.preload())));
            String subtitle = Util.makeDescriptionId(SoundEventTranslationKeyResolver.PREFIX, Objects.requireNonNull(holder.sound().getKey()).location());
            add(holder.sound().value(), soundDefinition.subtitle(subtitle)
                    .replace(holder.replace()));
        });
    }
}
