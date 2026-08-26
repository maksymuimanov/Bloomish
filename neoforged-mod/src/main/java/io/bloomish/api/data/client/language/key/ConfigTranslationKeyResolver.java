package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.neoforge.common.ModConfigSpec;

@Injected
public class ConfigTranslationKeyResolver implements TranslationKeyResolver<ModConfigSpec.ConfigValue<?>> {
    @Override
    public boolean supports(Object object) {
        return object instanceof ModConfigSpec.ConfigValue<?>;
    }

    @Override
    public String resolve(ModConfigSpec.ConfigValue<?> configValue) {
        return configValue.getSpec().getTranslationKey();
    }
}
