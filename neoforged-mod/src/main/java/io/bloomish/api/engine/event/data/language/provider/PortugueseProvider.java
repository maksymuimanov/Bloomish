package io.bloomish.api.engine.event.data.language.provider;

import io.bloomish.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class PortugueseProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public PortugueseProvider(PackOutput output) {
        super(output, "pt_pt");
    }
}