package io.bloomish.api.engine.event.data.client.language.transformer;

public class StringTransformer implements KeyTransformer<String> {
    @Override
    public String transform(String string) {
        return string;
    }
}
