package io.bloomish.api.engine.event.data.client.language;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedMapChannelBus;
import io.bloomish.api.engine.event.data.AbstractMultiDataProvider;
import io.bloomish.api.engine.event.data.DataTarget;
import io.bloomish.api.engine.event.data.client.ClientDataProvider;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.data.PackOutput;

@Injected
public class LanguageProvider extends AbstractMultiDataProvider implements ClientDataProvider {
    private static final String LANGUAGE_PATH = "lang";
    private final KeyedMapChannelBus channelBus;

    public LanguageProvider(PackOutput packOutput, KeyedMapChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<String, String, String>forEachDrain(DataChannels.LANGUAGE_PROVIDER, (language, value) -> {
            DataTarget languageResource = DataTarget.createModAsset(LANGUAGE_PATH, language);
            this.addData(languageResource, value);
        });
    }
}
