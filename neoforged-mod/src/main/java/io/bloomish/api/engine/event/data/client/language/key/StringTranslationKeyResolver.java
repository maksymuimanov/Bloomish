package io.bloomish.api.engine.event.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;

@Injected
public class StringTranslationKeyResolver implements TranslationKeyResolver<String> {
    @Override
    public boolean supports(Object object) {
        return object instanceof String;
    }

    @Override
    public String resolve(String string) {
        return string;
    }
}
