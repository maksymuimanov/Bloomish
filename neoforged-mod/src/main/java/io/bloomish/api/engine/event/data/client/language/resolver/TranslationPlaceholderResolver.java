package io.bloomish.api.engine.event.data.client.language.resolver;

import java.util.Map;

public interface TranslationPlaceholderResolver {
    String resolve(String key, String placeholder, Map<String, String> translationMap);
}
