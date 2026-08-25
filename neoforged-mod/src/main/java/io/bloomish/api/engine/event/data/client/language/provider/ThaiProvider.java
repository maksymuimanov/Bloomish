package io.bloomish.api.engine.event.data.client.language.provider;

import io.bloomish.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class ThaiProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public ThaiProvider(PackOutput output) {
        super(output, "th_th");
    }
}