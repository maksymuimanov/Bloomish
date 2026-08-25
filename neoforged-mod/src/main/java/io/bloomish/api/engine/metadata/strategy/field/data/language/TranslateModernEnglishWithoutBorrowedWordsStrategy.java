package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ModernEnglishWithoutBorrowedWordsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateModernEnglishWithoutBorrowedWords;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateModernEnglishWithoutBorrowedWordsStrategy extends TranslationStrategy<TranslateModernEnglishWithoutBorrowedWords> {
    public TranslateModernEnglishWithoutBorrowedWordsStrategy() {
        super(ModernEnglishWithoutBorrowedWordsProvider.class);
    }

    @Override
    public Class<TranslateModernEnglishWithoutBorrowedWords> getAnnotationClass() {
        return TranslateModernEnglishWithoutBorrowedWords.class;
    }
}
