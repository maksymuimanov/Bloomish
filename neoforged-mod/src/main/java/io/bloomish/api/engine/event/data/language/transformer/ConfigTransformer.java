package io.bloomish.api.engine.event.data.language.transformer;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigTransformer implements KeyTransformer<ModConfigSpec.ConfigValue<?>> {
    @Override
    public String transform(ModConfigSpec.ConfigValue<?> configValue) {
        return configValue.getSpec().getTranslationKey();
    }
}
