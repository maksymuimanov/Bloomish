package io.bloomish.api.engine.event.data.client.language.resolver;

import java.util.Map;

public interface TranslationValueResolver {
    String PLACEHOLDER_REGEX = "\\{(.*?)}";

    String resolve(String key, String value, Map<String, String> translationMap, Iterable<TranslationPlaceholderResolver> placeholderResolvers);
}
