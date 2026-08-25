package io.bloomish.api.engine.event.data.client.language.provider;

import io.bloomish.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class LojbanProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public LojbanProvider(PackOutput output) {
        super(output, "jbo_en");
    }
}