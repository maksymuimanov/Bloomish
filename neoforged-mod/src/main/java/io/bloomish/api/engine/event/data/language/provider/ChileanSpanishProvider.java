package io.bloomish.api.engine.event.data.language.provider;

import io.bloomish.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class ChileanSpanishProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public ChileanSpanishProvider(PackOutput output) {
        super(output, "es_cl");
    }
}