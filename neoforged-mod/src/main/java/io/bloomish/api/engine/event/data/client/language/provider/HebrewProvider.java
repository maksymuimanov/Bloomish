package io.bloomish.api.engine.event.data.client.language.provider;

import io.bloomish.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class HebrewProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public HebrewProvider(PackOutput output) {
        super(output, "he_il");
    }
}