package io.bloomish.api.engine.event.data.language.provider;

import io.bloomish.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class MongolianProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public MongolianProvider(PackOutput output) {
        super(output, "mn_mn");
    }
}