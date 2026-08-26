package io.bloomish.api.data.client.language;

import io.bloomish.api.data.client.language.key.TranslationKeyResolver;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;

import java.util.HashMap;
import java.util.Map;

@Injected
public class DefaultTranslationResolver implements TranslationResolver {
    private final Iterable<TranslationKeyResolver<?>> keyResolvers;

    public DefaultTranslationResolver(Iterable<TranslationKeyResolver<?>> keyResolvers) {
        this.keyResolvers = keyResolvers;
    }

    @Override
    public Map<String, String> resolveTranslations(Map<Object, String> source) {
        Map<String, String> result = new HashMap<>();
        source.forEach((key, value) -> this.populateResolvedTranslations(key, value, result));
        return result;
    }

    private void populateResolvedTranslations(Object key, String value, Map<String, String> result) {
        this.keyResolvers.forEach(resolver -> this.putResolvedTranslation(key, value, result, resolver));
    }

    private void putResolvedTranslation(Object key, String value, Map<String, String> result, TranslationKeyResolver<?> resolver) {
        String resolvedKey = resolver.tryResolve(key);
        if (resolvedKey != null) {
            result.put(resolvedKey, value);
        }
    }
}
