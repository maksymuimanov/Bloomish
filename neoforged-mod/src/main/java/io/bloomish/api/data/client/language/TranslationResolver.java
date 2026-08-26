package io.bloomish.api.data.client.language;

import java.util.Map;

public interface TranslationResolver {
    Map<String, String> resolveTranslations(Map<Object, String> source);
}
