package io.bloomish.api.engine.event.data.language.provider;

import io.bloomish.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class BashkirProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public BashkirProvider(PackOutput output) {
        super(output, "ba_ru");
    }
}