package io.bloomish.api.engine.event.data.client.language;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedMapChannelBus;
import io.bloomish.api.engine.event.data.AbstractMultiDataProvider;
import io.bloomish.api.engine.event.data.DataTarget;
import io.bloomish.api.engine.event.data.client.ClientDataProvider;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.data.PackOutput;

import java.util.Map;

@Injected
public class LanguageProvider extends AbstractMultiDataProvider implements ClientDataProvider {
    private static final String LANGUAGE_PATH = "lang";
    private final KeyedMapChannelBus channelBus;
    private final TranslationResolver translationResolver;

    public LanguageProvider(PackOutput packOutput, KeyedMapChannelBus channelBus, TranslationResolver translationResolver) {
        super(packOutput);
        this.channelBus = channelBus;
        this.translationResolver = translationResolver;
    }

    @Override
    protected void registerData() {
        this.channelBus.<String, Object, String>forEachDrain(DataChannels.LANGUAGE_PROVIDER, (language, translations) -> {
            DataTarget languageResource = DataTarget.createModAsset(LANGUAGE_PATH, language);
            Map<String, String> resolvedTranslations = this.translationResolver.resolveTranslations(translations);
            this.addData(languageResource, resolvedTranslations);
        });
    }
}
